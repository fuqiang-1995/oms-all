package com.iecas.result;

public enum ResultCodeEnum {
    SUCCESS(true, 200, "成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    NULL_POINT_REASON(false, 20001, "参数为空发生异常"),
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
