package com.data.ProductApp.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private T data;
    private LocalDateTime timeStamp = LocalDateTime.now();


    public static final Response<String> SUCCESS = new Response<>(HttpStatus.OK.value(),HttpStatus.OK, "Success");
    public static final Response<String> CREATED = new Response<>(HttpStatus.CREATED.value(),HttpStatus.CREATED, "Created");
    public static final Response<String> FAILURE = new Response<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT, "Failure");
    public static final Response<String> NOT_FOUND = new Response<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "Resource not found");

    public Response(Integer statusCode, HttpStatus status, String message, T data) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public Response(Integer statusCode, HttpStatus status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }
    public Response(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public Response(Integer statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
    public Response(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    public Response(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public Response(T data) {
        this.data = data;
    }
}
