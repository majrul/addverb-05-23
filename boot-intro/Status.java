package com.example.dto;

public class Status {

    private int statusCode;
    private String messageIfAny;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessageIfAny() {
        return messageIfAny;
    }

    public void setMessageIfAny(String messageIfAny) {
        this.messageIfAny = messageIfAny;
    }
}
