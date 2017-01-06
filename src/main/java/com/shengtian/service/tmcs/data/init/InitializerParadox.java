package com.shengtian.service.tmcs.data.init;

import com.shengtian.service.tmcs.data.DataPoint;
import com.shengtian.service.tmcs.data.database.DatabaseAccessor;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Set;

@Component
public class InitializerParadox implements Initializer {

    @Inject
    DatabaseAccessor dataService;

    @Override
    public Set<DataPoint> initializeDataPoints() {
        return dataService.queryDataPoints();
    }
}
