package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 城市空气质量预测对象 tq_city_forecast
 *
 * @date 2024-03-30
 */
public class TqCityForecast extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 时间点 */
//    @Excel(name = "时间点")
//    private String timepoint;
    @Excel(name = "时间点", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timepoint;
    /** 城市编码 */
    @Excel(name = "城市编码")
    private String citycode;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityname;

    /** 预测日期 */
    @Excel(name = "预测日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date forecastDate;

    /** 距离现在时间 */
    @Excel(name = "距离现在时间")
    private String day;

    /** AQI */
    @Excel(name = "AQI")
    private String aqi;

    /** 空气质量 */
    @Excel(name = "空气质量")
    private String quality;

    /** 首要污染物 */
    @Excel(name = "首要污染物")
    private String primarypollutant;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public Date getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(Date forecastDate) {
        this.forecastDate = forecastDate;
    }

    //    public void setTimepoint(String timepoint)
//    {
//        this.timepoint = timepoint;
//    }
//
//    public String getTimepoint()
//    {
//        return timepoint;
//    }

    public Date getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(Date timepoint) {
        this.timepoint = timepoint;
    }

    public void setCitycode(String citycode)
    {
        this.citycode = citycode;
    }

    public String getCitycode() 
    {
        return citycode;
    }
    public void setCityname(String cityname) 
    {
        this.cityname = cityname;
    }

    public String getCityname() 
    {
        return cityname;
    }
//    public void setForecastDate(String forecastDate)
//    {
//        this.forecastDate = forecastDate;
//    }
//
//    public String getForecastDate()
//    {
//        return forecastDate;
//    }
    public void setDay(String day) 
    {
        this.day = day;
    }

    public String getDay() 
    {
        return day;
    }
    public void setAqi(String aqi) 
    {
        this.aqi = aqi;
    }

    public String getAqi() 
    {
        return aqi;
    }
    public void setQuality(String quality) 
    {
        this.quality = quality;
    }

    public String getQuality() 
    {
        return quality;
    }
    public void setPrimarypollutant(String primarypollutant) 
    {
        this.primarypollutant = primarypollutant;
    }

    public String getPrimarypollutant() 
    {
        return primarypollutant;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("timepoint", getTimepoint())
            .append("citycode", getCitycode())
            .append("cityname", getCityname())
            .append("day", getDay())
            .append("aqi", getAqi())
            .append("quality", getQuality())
            .append("primarypollutant", getPrimarypollutant())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
