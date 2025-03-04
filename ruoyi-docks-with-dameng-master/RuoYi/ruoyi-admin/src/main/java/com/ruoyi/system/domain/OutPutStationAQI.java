package com.ruoyi.system.domain;

import java.util.List;

public class OutPutStationAQI {
    private int stationNum;//站点个数
    private List<TqAqiStation> list;//各站点空气质量数据
    private  int wrSationNum;//aqi>100站点个数
    private TqCityAqi cityAqi;//当前城市空气质量明细

    @Override
    public String toString() {
        return "OutPutStationAQI{" +
                "stationNum=" + stationNum +
                ", list=" + list +
                ", wrSationNum=" + wrSationNum +
                ", cityAqi=" + cityAqi.toString() +
                '}';
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public List<TqAqiStation> getList() {
        return list;
    }

    public void setList(List<TqAqiStation> list) {
        this.list = list;
    }

    public int getWrSationNum() {
        return wrSationNum;
    }

    public void setWrSationNum(int wrSationNum) {
        this.wrSationNum = wrSationNum;
    }

    public TqCityAqi getCityAqi() {
        return cityAqi;
    }

    public void setCityAqi(TqCityAqi cityAqi) {
        this.cityAqi = cityAqi;
    }
}
