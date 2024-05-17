package com.example.validation.utils;

/**
 * 响应状态码枚举类
 *
 * @author CJW
 * @since 2023/11/9
 */

public enum StatusCode {
    /**
     * 成功
     */
    SUCCESS("00000", "一切正常"),
    /**
     * 失败
     */
    Error("11111", "错误");
    /**
     * 状态码
     */
    private final String code;
    /**
     * 状态提示信息
     */
    private final String message;

    StatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
