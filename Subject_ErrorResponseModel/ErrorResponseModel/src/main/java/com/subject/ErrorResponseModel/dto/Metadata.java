package com.subject.ErrorResponseModel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Metadata {
    private int resultCount;

    public Metadata(int resultCount) {
        this.resultCount = resultCount;
    }
}
