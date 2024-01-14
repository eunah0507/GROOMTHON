package com.subject.ErrorResponseModel.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SERVER_ERROR(500, "grade 는 6이상을 입력 할 수 없습니다.");
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
