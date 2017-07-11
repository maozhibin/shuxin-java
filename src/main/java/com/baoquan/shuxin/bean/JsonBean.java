package com.baoquan.shuxin.bean;

public class JsonBean {
    private int code;//状态码：-1代码报错、0请求成功、1-99业务错误代码，参考message
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
