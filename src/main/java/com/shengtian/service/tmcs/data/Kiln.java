package com.shengtian.service.tmcs.data;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum Kiln {
    UNKNOWN(0, null, null, null),
    A(1, "A", "焙烧窑A", KilnType.CALCINING),
    B(2, "B", "焙烧窑B", KilnType.CALCINING);

    private int id;

    private String paradoxCode;

    private String chineseName;

    private KilnType type;

    Kiln(int id, String paradoxCode, String chineseName, KilnType type) {
        this.id = id;
        this.paradoxCode = paradoxCode;
        this.chineseName = chineseName;
        this.type = type;
    }

    public Kiln ofName(String name) {
        return Lists.newArrayList(values()).stream()
                .filter(kiln -> Objects.equals(kiln.name(), name))
                .findFirst()
                .orElse(UNKNOWN);
    }

    public Kiln ofPradoxCode(String paradoxCode) {
        return Lists.newArrayList(values()).stream()
                .filter(kiln -> Objects.equals(kiln.getParadoxCode(), paradoxCode))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
