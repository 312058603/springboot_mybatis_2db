package com.wpx.entity;

/**
 * Created by GM-KF007 on 2018/12/21.
 */
public class Reseponse<T>{

    private String code;
    private String meassage;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMeassage() {
        return meassage;
    }

    public void setMeassage(String meassage) {
        this.meassage = meassage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Reseponse{" +
                "code='" + code + '\'' +
                ", meassage='" + meassage + '\'' +
                ", data=" + data +
                '}';
    }

}
