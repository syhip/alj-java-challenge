package jp.co.axa.apidemo.exception;


import jp.co.axa.apidemo.enums.ResultEnum;

/**
 * User Defined Exception
 */
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
