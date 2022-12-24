package com.it.easyexcal.utils;


public enum CodeEnum {
    /**
     * 成功标识
     */
    SUCCESS(0),
    /**
     * 失败标识
     */
    ERROR(1);

    private final Integer code;

    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
