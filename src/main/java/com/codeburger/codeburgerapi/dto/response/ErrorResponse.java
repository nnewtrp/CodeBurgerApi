package com.codeburger.codeburgerapi.dto.response;

public class ErrorResponse {
    private String message;

    public ErrorResponse() {}

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getIsSuccess() {
        return false;
    }
}
