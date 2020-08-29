package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private  final String phoneNum;
    private String name;

    public Person(@JsonProperty("phoneNum") String phoneNum,
                  @JsonProperty("name") String name) {
        this.phoneNum = phoneNum;
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public String getName() {
        return name;
    }
    protected void setName(String n){
        name=n;
    }


}

