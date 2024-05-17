package com.example.validation.utils;

public class Result<T> {
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 响应携带的数据
     */
    private T data;

    /**
     * 成功响应快捷方法
     *
     * @param object 携带的数据对象
     * @param <T>
     * @return 一个成功的响应
     */
    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.code = StatusCode.SUCCESS.getCode();
        result.data = object;
        return result;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = StatusCode.SUCCESS.getCode();
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.code = StatusCode.Error.getCode();
        return result;
    }

    public static <T> Result<T> error(T object) {
        Result<T> result = new Result<T>();
        result.code = StatusCode.Error.getCode();
        result.data = object;
        return result;
    }
}
