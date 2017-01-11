package com.shengtian.service.tmcs.init;

import com.shengtian.service.tmcs.domain.DataPoint;

import java.util.Set;

public interface Initializer {

    public Set<DataPoint> initializeDataPoints();

}
