package com.hzh.moneyrecord.entity;

import com.hzh.moneyrecord.enmus.Status;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author hzh
 * @ClassName Result.java
 * @createTime 2022年02月09日 15:48:00
 */
@Data
public class Result <T>{
    /**
     * 状态码
     */
    private Integer statusCode = 1;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public Result() {
    }

    public Result(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Result(Integer statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static Result success() {

        return new Result(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg());
    }

    public static <T> Result<T> success(T data) {

        return new Result<T>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success(String message, T data) {

        return new Result<T>(Status.SUCCESS.getCode(), message, data);
    }

    public static Result error() {
        Result result = new Result(Status.ERROR.getCode(), Status.ERROR.getMsg(), null);

        return result;
    }


    public static <T>Result<T> error(T data){
        return new Result<T>(Status.ERROR.getCode(),Status.ERROR.getMsg(),data);
    }

    public static Result error(Throwable e) {

        return error(Objects.isNull(e) || StringUtils.isEmpty(e.getMessage()) ? Status.ERROR : e.getMessage());
    }

    public static <T>Result<T> error(String message) {

        return new Result<>(Status.ERROR.getCode(), message,null);
    }

    public static Result error(String message, Throwable e) {
        Result result = new Result(Status.ERROR.getCode(), message, Objects.isNull(e) ? null : e.getMessage());

        return result;
    }

    public static Result build(int code, String message) {

        return build(code, message, null);
    }

    public static <T> Result build(int code, String message, T data) {

        return new Result(code, message, data);
    }
}
