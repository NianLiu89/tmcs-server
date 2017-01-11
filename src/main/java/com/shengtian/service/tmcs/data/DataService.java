package com.shengtian.service.tmcs.data;

import com.shengtian.service.tmcs.data.init.Initializer;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Getter
    private Set<DataPoint> dataPoints;

    @Inject
    public DataService(Initializer initializer) {
        this.dataPoints = initializer.initializeDataPoints();
    }

    @Scheduled(fixedRate = 100)
    public void update() {
        System.out.print(LocalDateTime.now() + "\t");
        System.out.println(dataPoints.stream().map(dp -> dp.getCode() + ": " + dp.getTemperature()).collect(Collectors.joining("|")));
    }

    public List<DataPoint> getSortedDataPointsBy(String kilnCode) {
        return dataPoints.stream()
                .filter(dataPoint -> Objects.equals(dataPoint.getKiln(), kilnCode))
                .sorted(Comparator.comparingInt(DataPoint::getSlot))
                .collect(Collectors.toList());
    }

}
