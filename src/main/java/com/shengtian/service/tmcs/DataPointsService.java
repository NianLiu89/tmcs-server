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

    @Scheduled(fixedRate = 5000)
    public void update() {
        Map<String, String> codeToTemperatureMap = isDataFromProduction ? getRealData() : getFakeData();
        dataPoints.forEach(dataPoint -> {
            final String stringValue = codeToTemperatureMap.getOrDefault(dataPoint.getCode(), null);

            if (stringValue == null) {
                dataPoint.setTemperature(null);
            } else {
                dataPoint.setTemperature(Double.valueOf(stringValue));
            }
        });

        System.out.print("[UPDATE]" + LocalDateTime.now() + "\t");
        System.out.println(dataPoints.stream()
                .filter(dp -> codeToTemperatureMap.containsKey(dp.getCode()))
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
        return dataPoints.stream()
                .collect(Collectors.toMap(DataPoint::getCode, dp -> randomeTemp()));

    }

    private static String randomeTemp() {
        Random r = new Random();
        int range = 200;
        return String.valueOf(r.nextDouble() * range);
    }

}
