package com.shengtian.service.tmcs;

import com.shengtian.service.tmcs.domain.DataPoint;
import com.shengtian.service.tmcs.init.Initializer;
import com.shengtian.service.tmcs.parsing.DataFileParser;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataPointsService {

    @Getter
    private Set<DataPoint> dataPoints;

    private DataFileParser dataFileParser;

    @Value("${tmcs.data.source.isProduction:false}")
    private boolean isDataFromProduction;

    @Inject
    public DataPointsService(Initializer initializer, DataFileParser dataFileParser) {
        this.dataPoints = initializer.initializeDataPoints();
        this.dataFileParser = dataFileParser;
    }

    @Scheduled(fixedRate = 1000)
    public void update() {
        Map<String, String> dataPointCodeToValueMap = isDataFromProduction ? getRealData() : getFakeData();
        dataPoints.forEach(dataPoint -> {
            final String stringValue = dataPointCodeToValueMap.getOrDefault(dataPoint.getCode(), null);

            if (stringValue == null) {
                dataPoint.setTemperature(null);
            } else {
                dataPoint.setTemperature(Double.valueOf(stringValue));
            }
        });

        System.out.println("[UPDATE] updating data");
        System.out.print("[UPDATE]" + LocalDateTime.now() + "\t");
        System.out.println(dataPoints.stream()
                .filter(dp -> dataPointCodeToValueMap.containsKey(dp.getCode()))
                .map(dp -> dp.getCode() + ": " + dp.getTemperature()).collect(Collectors.joining(" | ")));
    }

    public List<DataPoint> getSortedDataPointsBy(String kilnCode) {
        return dataPoints.stream()
                .filter(dataPoint -> Objects.equals(dataPoint.getKiln(), kilnCode))
                .sorted(Comparator.comparingInt(DataPoint::getSlot))
                .collect(Collectors.toList());
    }

    private Map<String, String> getRealData() {
        return dataFileParser.parse();
    }

    private Map<String, String> getFakeData() {
        Map<String, String> fakeDatasource = new HashMap<>();
        Random r = new Random();
        int range = 100;
        fakeDatasource.put("TA6_BM", String.valueOf(r.nextDouble() * range));
        fakeDatasource.put("TB5_TM", String.valueOf(r.nextDouble() * range));
        fakeDatasource.put("T118_TM", String.valueOf(r.nextDouble() * range));
        return fakeDatasource;
    }

}
