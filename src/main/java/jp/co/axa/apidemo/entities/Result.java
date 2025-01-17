package jp.co.axa.apidemo.entities;

/**
 * Result Class
 * @param <T>
 */
public class Result<T> {

    /**
     * Error Code
     */
    private Integer code;

    /**
     * message
     */
    private String msg;

    /**
     * information
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

