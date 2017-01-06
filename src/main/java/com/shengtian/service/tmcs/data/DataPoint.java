package com.shengtian.service.tmcs.data;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class DataPoint {

    @Setter(AccessLevel.NONE)
    String code;  // this field is immutable, as the identifier of a data point

    String kilnCode;
    int slot;
    Position position;

    double maxTemperature;
    double minTemperature;
    double temperature;

    int moduleId;
    int channelId;

    public DataPoint(String code) {
        this.code = code;
    }


}
