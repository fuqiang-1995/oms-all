package com.iecas.common.result;

public enum ResultCodeEnum {
    SUCCESS(true, 200, "成功"),
    UNKNOWN_REASON(false, 2001, "未知错误"),
    NULL_POINT(false, 2002, "参数为空发生异常"),
    DUPLICATE_KEY(false, 2003, "主键重复异常"),
    USER_NOTFOUND(false, 2101, "用户名未找到"),
    PASSWORD_ERROR(false, 2102, "密码错误")
    ;

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
