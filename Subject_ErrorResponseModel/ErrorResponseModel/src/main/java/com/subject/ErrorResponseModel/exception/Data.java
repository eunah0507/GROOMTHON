package com.subject.ErrorResponseModel.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    private InputRestriction inputRestriction;

    public Data(InputRestriction inputRestriction) {
        this.inputRestriction = inputRestriction;
    }
}
