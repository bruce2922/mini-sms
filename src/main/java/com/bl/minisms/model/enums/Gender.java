package com.bl.minisms.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    FEMALE(1,"Female"),
    MALE(2,"Male"),
    OTHER(3,"Other");

    private int value;
    private String desc;

    Gender(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    @JsonValue
    public String getDesc() {
        return desc;
    }

    public static Gender getByValue(int value) {
        for(Gender g: Gender.values()) {
            if(g.getValue() == value){
                return g;
            }
        }
        return null;
    }


}
