package com.beam.sample.mail.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Response<T> {

    private int code;
    private String message;
    private T data;
}
