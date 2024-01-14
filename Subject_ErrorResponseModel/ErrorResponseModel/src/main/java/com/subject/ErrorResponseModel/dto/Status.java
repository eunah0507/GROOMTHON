package com.subject.ErrorResponseModel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private int code;
    private String message;

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
