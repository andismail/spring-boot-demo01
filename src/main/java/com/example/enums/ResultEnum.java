package com.example.enums;

/**
 * 此处使用枚举是为了使'异常码'和'异常信息'对应
 * Created by Jthan on 17/8/20.
 */
public enum  ResultEnum {
    UNKONW_ERROR(-1, "UNKNOW ERROR"),
    SUCCESS(0, "SUCCESS"),
    PRIMARY_SCHOOL(100, "PRIMARY SCHOOL"),
    MIDDLE_SCHOOL(101, "MIDDLE SCHOOL");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
