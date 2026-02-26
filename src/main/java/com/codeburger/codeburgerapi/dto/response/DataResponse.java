package com.codeburger.codeburgerapi.dto.response;

public class DataResponse<T> {
    private T data;

    public DataResponse() {}

    public DataResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Boolean getIsSuccess() {
        return true;
    }
}