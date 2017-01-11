package com.shengtian.service.tmcs.domain;

public enum Position {

    UNKNOWN(0),
    TOP(1),
    BOTTOM(2),
    LEFT(3),
    RIGHT(4);

    private int id;

    Position(int id) {
        this.id = id;
    }

}
