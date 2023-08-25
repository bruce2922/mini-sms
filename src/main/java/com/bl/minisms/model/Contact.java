package com.bl.minisms.model;

import com.bl.minisms.model.enums.Relationship;

import java.io.Serializable;


public class Contact implements Serializable {

    private Long id;
    private String name;
    private Integer relationshipValue;
    private Relationship relationship;
    private String address;
    private String email;
    private String phone;


    public Contact() {
    }

    public Contact(Long id) {
        this.id = id;
    }

    public Contact(String name, Relationship relationship, String address, String email, String phone) {
        this.name = name;
        this.relationship = relationship;
        setRelationship(relationship);
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelationshipValue() {
        return relationshipValue;
    }

    public void setRelationshipValue(Integer relationshipValue) {
        this.relationshipValue = relationshipValue;
        this.relationship = Relationship.getByValue(relationshipValue);
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
        this.relationshipValue = relationship.getValue();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
