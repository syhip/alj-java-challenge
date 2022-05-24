package jp.co.axa.apidemo.enums;

import jp.co.axa.apidemo.common.Const;

/**
 * Result Enum Class
 */
public enum ResultEnum {
    SYSTEM_ERROR(-1, Const.SYSTEM_ERROR),
    SUCCESS(0, Const.SUCCESS),
    DATA_ERROR(2, Const.THE_DATA_DOES_NOT_EXIST);

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

