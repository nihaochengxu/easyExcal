package com.it.easyexcal.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> ok() {
        return of(CodeEnum.SUCCESS.getCode(), "ok", null);
    }

    public static <T> Result<T> ok(String msg) {
        return of(CodeEnum.SUCCESS.getCode(), msg, null);
    }

    public static <T> Result<T> ok(T data) {
        return of(CodeEnum.SUCCESS.getCode(), "ok", data);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return of(CodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> Result<T> failed() {
        return of(CodeEnum.ERROR.getCode(), "failed", null);
    }

    public static <T> Result<T> failed(Integer code, String msg) {
        return of(code, msg, null);
    }

    public static <T> Result<T> failed(String msg) {
        return of(CodeEnum.ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> failed(T data) {
        return of(CodeEnum.ERROR.getCode(), "failed", data);
    }

    public static <T> Result<T> failed(T data, String msg) {
        return of(CodeEnum.ERROR.getCode(), msg, data);
    }

    public static <T> Result<T> failed(ErrorCodeEnum resultEnum) {
        return of(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static <T> Result<T> of(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

}
