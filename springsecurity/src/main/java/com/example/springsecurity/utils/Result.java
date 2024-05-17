package com.example.springsecurity.utils;

/**
 * 统一响应结果类
 *
 * @author CJW
 * @since 2023/9/19
 */
public class Result<T> {
    /**
     * 响应状态码,1表示成功，非1表示失败
     */
    private Integer code;
    /**
     * 错误信息
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
        Result<T> result = new Result<>();
        result.code = 1;
        result.data = object;
        return result;
    }

    /**
     * 失败响应快捷方法
     *
     * @param message 错误的提示信息
     * @param <T>
     * @return 一个失败的响应
     */
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.code = 0;
        result.message = message;
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
