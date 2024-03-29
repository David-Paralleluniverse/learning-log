package com.example.better.entity;

import lombok.Data;

import java.util.List;


@Data
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

}
