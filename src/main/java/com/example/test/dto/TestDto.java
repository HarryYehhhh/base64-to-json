package com.example.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestDto {
    @JsonProperty("msg")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
