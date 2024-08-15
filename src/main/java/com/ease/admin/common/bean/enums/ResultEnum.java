package com.ease.admin.common.bean.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS("00000", "成功"),
    CUSTOM_EXCEPTION("B0001", "自定义异常"),
    PARAMETER_IS_EMPTY_EXCEPTION("B0002", "参数为空异常"),
    PARAMETER_VERIFICATION_EXCEPTION("B0003", "参数校验异常"),
    USER_REGISTER_EXCEPTION("B0004", "用户注册异常"),
    UNKNOWN_EXCEPTION("F9999", "未知异常");

    private final String state;

    private final String msg;

    ResultEnum(String state, String msg) {
        this.state = state;
        this.msg = msg;
    }

}
