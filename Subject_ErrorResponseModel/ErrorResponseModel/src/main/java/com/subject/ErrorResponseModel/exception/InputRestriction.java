package com.subject.ErrorResponseModel.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputRestriction {
    private int maxGrade;

    public InputRestriction(int maxGrade) {
        this.maxGrade = maxGrade;
    }
}
