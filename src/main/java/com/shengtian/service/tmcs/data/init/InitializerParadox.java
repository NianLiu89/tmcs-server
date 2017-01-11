package com.shengtian.service.tmcs.data.init;

import com.shengtian.service.tmcs.data.DataPoint;
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
        try {
            return configFileParser.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
