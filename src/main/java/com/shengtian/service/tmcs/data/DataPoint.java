package com.shengtian.service.tmcs.data;

import lombok.*;

@Builder
@Getter
public class DataPoint {

    String code;
    String kiln;
    int slot;
    Position position;      //TODO check how to set this field

    double maxTemperature;  //TODO can this field be changed in run time?
    double minTemperature;  //TODO can this field be changed in run time?

    @Setter
    double temperature;

    int moduleId;
    int channelId;
}
