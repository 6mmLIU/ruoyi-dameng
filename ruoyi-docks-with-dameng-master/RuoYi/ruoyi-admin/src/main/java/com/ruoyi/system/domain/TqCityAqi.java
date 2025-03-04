package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 城市空气质量管理对象 tq_city_aqi
 *
 * @date 2024-03-30
 */
public class TqCityAqi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表ID */
    private String id;

    /** 时间点 */
//    @Excel(name = "时间点")
//    private String timepoint;
    @Excel(name = "时间点", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timepoint;
    /** CO等级 */
    @Excel(name = "CO等级")
    private String colevel;

    /** NO2等级 */
    @Excel(name = "NO2等级")
    private String no2level;

    /** O3等级 */
    @Excel(name = "O3等级")
    private String o3level;

    /** PM10等级 */
    @Excel(name = "PM10等级")
    private String pm10level;

    /** PM2.5等级 */
    @Excel(name = "PM2.5等级")
    private String pm25level;

    /** SO2等级 */
    @Excel(name = "SO2等级")
    private String so2level;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String area;

    /** 城市代码 */
    @Excel(name = "城市代码")
    private String citycode;

    /** CO */
    @Excel(name = "CO")
    private String co;

    /** NO2 */
    @Excel(name = "NO2")
    private String no2;

    /** O3 */
    @Excel(name = "O3")
    private String o3;

    /** PM10 */
    @Excel(name = "PM10")
    private String pm10;

    /** PM2.5 */
    @Excel(name = "PM2.5")
    private String pm25;

    /** SO2 */
    @Excel(name = "SO2")
    private String so2;

    /** AQI */
    @Excel(name = "AQI")
    private String aqi;

    /** 主要污染物 */
    @Excel(name = "主要污染物")
    private String primarypollutant;

    /** 空气质量 */
    @Excel(name = "空气质量")
    private String quality;

    /** 建议 */
    @Excel(name = "建议")
    private String measure;

    /** 健康影响 */
    @Excel(name = "健康影响")
    private String Unheathful;

    /** 有效标志 */
    private String flag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public Date getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(Date timepoint) {
        this.timepoint = timepoint;
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
    public void setColevel(String colevel) 
    {
        this.colevel = colevel;
    }

    public String getColevel() 
    {
        return colevel;
    }
    public void setNo2level(String no2level) 
    {
        this.no2level = no2level;
    }

    public String getNo2level() 
    {
        return no2level;
    }
    public void setO3level(String o3level) 
    {
        this.o3level = o3level;
    }

    public String getO3level() 
    {
        return o3level;
    }
    public void setPm10level(String pm10level) 
    {
        this.pm10level = pm10level;
    }

    public String getPm10level() 
    {
        return pm10level;
    }
    public void setPm25level(String pm25level) 
    {
        this.pm25level = pm25level;
    }

    public String getPm25level() 
    {
        return pm25level;
    }
    public void setSo2level(String so2level) 
    {
        this.so2level = so2level;
    }

    public String getSo2level() 
    {
        return so2level;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setCitycode(String citycode) 
    {
        this.citycode = citycode;
    }

    public String getCitycode() 
    {
        return citycode;
    }
    public void setCo(String co) 
    {
        this.co = co;
    }

    public String getCo() 
    {
        return co;
    }
    public void setNo2(String no2) 
    {
        this.no2 = no2;
    }

    public String getNo2() 
    {
        return no2;
    }
    public void setO3(String o3) 
    {
        this.o3 = o3;
    }

    public String getO3() 
    {
        return o3;
    }
    public void setPm10(String pm10) 
    {
        this.pm10 = pm10;
    }

    public String getPm10() 
    {
        return pm10;
    }
    public void setPm25(String pm25) 
    {
        this.pm25 = pm25;
    }

    public String getPm25() 
    {
        return pm25;
    }
    public void setSo2(String so2) 
    {
        this.so2 = so2;
    }

    public String getSo2() 
    {
        return so2;
    }
    public void setAqi(String aqi) 
    {
        this.aqi = aqi;
    }

    public String getAqi() 
    {
        return aqi;
    }
    public void setPrimarypollutant(String primarypollutant) 
    {
        this.primarypollutant = primarypollutant;
    }

    public String getPrimarypollutant() 
    {
        return primarypollutant;
    }
    public void setQuality(String quality) 
    {
        this.quality = quality;
    }

    public String getQuality() 
    {
        return quality;
    }
    public void setMeasure(String measure) 
    {
        this.measure = measure;
    }

    public String getMeasure() 
    {
        return measure;
    }
    public void setUnheathful(String Unheathful) 
    {
        this.Unheathful = Unheathful;
    }

    public String getUnheathful() 
    {
        return Unheathful;
    }
    public void setFlag(String flag) 
    {
        this.flag = flag;
    }

    public String getFlag() 
    {
        return flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("timepoint", getTimepoint())
            .append("colevel", getColevel())
            .append("no2level", getNo2level())
            .append("o3level", getO3level())
            .append("pm10level", getPm10level())
            .append("pm25level", getPm25level())
            .append("so2level", getSo2level())
            .append("area", getArea())
            .append("citycode", getCitycode())
            .append("co", getCo())
            .append("no2", getNo2())
            .append("o3", getO3())
            .append("pm10", getPm10())
            .append("pm25", getPm25())
            .append("so2", getSo2())
            .append("aqi", getAqi())
            .append("primarypollutant", getPrimarypollutant())
            .append("quality", getQuality())
            .append("measure", getMeasure())
            .append("Unheathful", getUnheathful())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("flag", getFlag())
            .toString();
    }
}
