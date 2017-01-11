package com.shengtian.service.tmcs.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class DataPoint {

    String code;
    String kiln;
    int slot;
    Position position;      //TODO check how to set this field

    Double maxTemperature;  //TODO can this field be changed in run time?
    Double minTemperature;  //TODO can this field be changed in run time?

    @Setter
    Double temperature;     //TODO should this field be value?

    int moduleId;
    int channelId;
}
