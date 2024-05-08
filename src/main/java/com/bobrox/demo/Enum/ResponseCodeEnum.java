package com.bobrox.demo.Enum;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    SUCCESS(0, "Success"),
    ERROR(-1, "An error occurred. Error message : ${errorMessage}"),
    STUDENT_NOT_FOUND(-2, "Student does not exist!"),
    TEACHER_NOT_FOUND(-3, "Teacher does not exist!");

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private final int code;
    private final String description;
}
