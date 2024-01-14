package com.subject.ErrorResponseModel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiResponse<T> {

    private Status status;
    private Metadata metadata;
    private List<T> result;

    public ApiResponse(Status status, Metadata metadata, List<T> result) {
        this.status = status;
        this.metadata = metadata;
        this.result = result;
    }

    public static <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<T>(new Status(2000, "OK"), new Metadata(result.size()), result);
    }
}
