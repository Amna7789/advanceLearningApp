package com.example.advancelearningapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO {

    String message;
    String errorCode;

    public ErrorDTO (String msg, String ec) {
        message = msg;
        errorCode = ec;
    }

}
