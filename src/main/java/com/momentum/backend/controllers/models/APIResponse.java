package com.momentum.backend.controllers.models;

import java.util.List;

public class APIResponse<T, E> {

    private Boolean success;
    private String message;
    private List<T> data;
    private List<E> errors;

    public APIResponse(Boolean success) {
        this.success = success;
    }

    public APIResponse(Boolean success, String message, List<T> data, List<E> errors) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<E> getErrors() {
        return errors;
    }

    public void setErrors(List<E> errors) {
        this.errors = errors;
    }
}
