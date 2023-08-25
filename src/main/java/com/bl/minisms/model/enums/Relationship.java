package com.bl.minisms.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Relationship {
    MOTHER(1,"Mother"),
    FATHER(2,"Father"),
    SISTER(3,"Sister"),
    BROTHER(4,"Brother"),
    FRIEND(5,"Friend");

    private int value;
    private String desc;

    Relationship(int value, String desc) {
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

    public static Relationship getByValue(int value) {
        for(Relationship r: Relationship.values()) {
            if(r.getValue() == value) {
                return r;
            }
        }
        return null;
    }
}
