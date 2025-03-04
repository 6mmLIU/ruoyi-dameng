package com.ruoyi.system.domain;

public class InputGetCityAQIList {
    String code;//城市编码
    String type;//污染物
    String px;//升序还是降序

    @Override
    public String toString() {
        return "InputGetCityAQIList{" +
                "code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", px='" + px + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }
}
