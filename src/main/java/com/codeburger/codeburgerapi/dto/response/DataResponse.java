package com.codeburger.codeburgerapi.dto.response;

public class DataResponse<T> {
    private Integer totalItems;
    private T data;

    public DataResponse() {}

    public DataResponse(Integer totalItems, T data) {
        this.totalItems = totalItems;
        this.data = data;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public T getData() {
        return data;
    }

    public Boolean getIsSuccess() {
        return true;
    }
}