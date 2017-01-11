package com.shengtian.service.tmcs.init;

import com.shengtian.service.tmcs.domain.DataPoint;
import com.shengtian.service.tmcs.parsing.ConfigFileParser;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Set;

@Component
public class InitializerParadox implements Initializer {

    @Inject
    ConfigFileParser configFileParser;

    @Override
    public Set<DataPoint> initializeDataPoints() {
        return configFileParser.parse();
    }
}
