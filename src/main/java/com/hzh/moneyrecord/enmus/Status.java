package com.hzh.moneyrecord.enmus;

/**
 * @author hanzhihua
 * @ClassName Status.java
 * @createTime 2021年11月09日 15:27:00
 */
public enum Status {
    SUCCESS(200, "成功"),
    ERROR(400,"失败");
    private int code;
    private String cnMsg;
    Status(int code, String cnMsg) {
        this.code = code;
        this.cnMsg = cnMsg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return cnMsg;
    }
}
