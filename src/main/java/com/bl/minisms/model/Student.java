package com.bl.minisms.model;

import com.bl.minisms.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;


public class Student implements Serializable {

    private Long id;
    @Length(min = 1,max = 50,message = "Length of name is 1 to 50")
    private String name;
    private String studentNumber;

    @NotNull(message = "Birth date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private Integer age;
    private Integer genderValue;
    @NotNull(message = "Invalid gender")
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate leavingDate;

    @Length(min = 1,max = 200,message = "Length of address is 1 to 200")
    private String address;
    @NotNull(message = "Category is required")
    private Category category;
    @NotEmpty(message = "At least choose one contact")
    private List<Contact> contactList;

    public Student() {
    }

    public Student(String name, String studentNumber, LocalDate birthDate, Gender gender, String address, Category category, List<Contact> contactList) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.birthDate = birthDate;
        setGender(gender);
        this.address = address;
        this.category = category;
        this.contactList = contactList;
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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        if(birthDate != null){
            this.age = Period.between(birthDate, LocalDate.now()).getYears();
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(Integer genderValue) {
        this.genderValue = genderValue;
        this.gender = Gender.getByValue(genderValue);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        if(gender != null){
            this.genderValue = gender.getValue();
        }
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(LocalDate leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
