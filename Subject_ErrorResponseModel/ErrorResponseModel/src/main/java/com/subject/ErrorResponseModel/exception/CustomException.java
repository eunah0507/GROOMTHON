package com.subject.ErrorResponseModel.exception;

import com.subject.ErrorResponseModel.dto.Status;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private Status status;
    private Data data;

    public CustomException(ErrorCode errorCode, int grade) {
        super(errorCode.getMessage());
        this.status = new Status(errorCode.getCode(),errorCode.getMessage());
        this.data = new Data(new InputRestriction(grade));
    }
}
