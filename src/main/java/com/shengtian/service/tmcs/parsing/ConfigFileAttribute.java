package com.shengtian.service.tmcs.parsing;

import lombok.Getter;

@Getter
public enum ConfigFileAttribute {

    CODE("Gongwei"),
    KILN("Kiln"),
    SLOT("Chewei"),
    POSITION("Weizhi"),
    MAX_TEMPERATURE("Hlimit"),
    MIN_TEMPERATURE("Llimit"),
    MODULE("ModuleID"),
    CHANNEL("Channels");

    private String paradoxName;

    ConfigFileAttribute(String paradoxName) {
        this.paradoxName = paradoxName;
    }

}
