package com.ruoyi.system.domain;

import java.util.List;

public class OutPutCityAQIByProvince {
    private int cityNum;//城市个数
    private List<TqCityAqi> list;//各城市空气质量数据
    private String aqi;//省平均
    private String  co;//省平均
    private String  no2;//省平均
    private String  o3;//省平均
    private String pm10;//省平均
    private String pm2_5;//省平均
    private String  so2;//省平均

    public int getCityNum() {
        return cityNum;
    }

    public void setCityNum(int cityNum) {
        this.cityNum = cityNum;
    }

    public List<TqCityAqi> getList() {
        return list;
    }

    public void setList(List<TqCityAqi> list) {
        this.list = list;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(String pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }
}
