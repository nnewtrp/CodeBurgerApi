package com.codeburger.codeburgerapi.dto.response;

public class DataInfoResponse<T> {
    private T data;

    public DataInfoResponse() {}

    public DataInfoResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Boolean getIsSuccess() {
        return true;
    }
}