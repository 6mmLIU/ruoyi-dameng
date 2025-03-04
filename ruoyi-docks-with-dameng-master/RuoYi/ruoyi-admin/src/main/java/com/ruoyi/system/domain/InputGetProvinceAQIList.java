package com.ruoyi.system.domain;

public class InputGetProvinceAQIList {
    String code;//编码
    String type;//污染物
    String px;//升序还是降序
    public InputGetProvinceAQIList() {

    }
    public InputGetProvinceAQIList(String code, String type, String px) {
        this.code = code;
        this.type = type;
        this.px = px;
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
