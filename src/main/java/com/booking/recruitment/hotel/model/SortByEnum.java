package com.booking.recruitment.hotel.model;

public enum SortByEnum {
    DISTANCE("distance");

    private String name;

    SortByEnum(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
