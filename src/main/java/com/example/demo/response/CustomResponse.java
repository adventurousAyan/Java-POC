package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomResponse<T> {

    private String message;
    private HttpStatus status;
    private T data;

    public CustomResponse(HttpStatus status, T Data) {
        this.status = status;
        this.data = data;
    }

    public CustomResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}


