package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 城市监测点管理对象 tq_aqi_station
 *
 * @date 2024-03-30
 */
public class TqAqiStation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表id */
    private String id;

    /** 时间点 */
//    @Excel(name = "时间点")
//    private String timepoint;
    @Excel(name = "时间点", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timepoint;

    /** 城市 */
    @Excel(name = "城市")
    private String area;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String citycode;

    /** 省编码 */
    @Excel(name = "省编码")
    private String provinceid;

    /** 省名称 */
    @Excel(name = "省名称")
    private String provincename;

    /** 监测点名 */
    @Excel(name = "监测点名")
    private String positionname;

    /** 监测点编码 */
    @Excel(name = "监测点编码")
    private String stationcode;

    /** co */
    @Excel(name = "co")
    private String co;

    /** 24小时co */
    @Excel(name = "24小时co")
    private String co24h;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 建议 */
    @Excel(name = "建议")
    private String measure;

    /** no2 */
    @Excel(name = "no2")
    private String no2;

    /** 24小时no2 */
    @Excel(name = "24小时no2")
    private String no224h;

    /** o3 */
    @Excel(name = "o3")
    private String o3;

    /** 24小时o3 */
    @Excel(name = "24小时o3")
    private String o324h;

    /** 8小时o3 */
    @Excel(name = "8小时o3")
    private String o38h;

    /** pm10 */
    @Excel(name = "pm10")
    private String pm10;

    /** 24小时pm10 */
    @Excel(name = "24小时pm10")
    private String pm1024h;

    /** pm2.5 */
    @Excel(name = "pm2.5")
    private String pm25;

    /** 24小时pm2.5 */
    @Excel(name = "24小时pm2.5")
    private String pm2524h;

    /** so2 */
    @Excel(name = "so2")
    private String so2;

    /** 24小时so2 */
    @Excel(name = "24小时so2")
    private String so224h;

    /** aqi */
    @Excel(name = "aqi")
    private String aqi;

    /** co等级 */
    @Excel(name = "co等级")
    private String colevel;

    /** no2等级 */
    @Excel(name = "no2等级")
    private String no2level;

    /** o3等级 */
    @Excel(name = "o3等级")
    private String o3level;

    /** pm10等级 */
    @Excel(name = "pm10等级")
    private String pm10level;

    /** pm2.5等级 */
    @Excel(name = "pm2.5等级")
    private String pm25level;

    /** so2等级 */
    @Excel(name = "so2等级")
    private String so2level;

    /** 主要污染物 */
    @Excel(name = "主要污染物")
    private String primarypollutant;

    /** 空气质量 */
    @Excel(name = "空气质量")
    private String quality;

    /** 健康影响 */
    @Excel(name = "健康影响")
    private String unheathful;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
    public void setProvinceid(String provinceid) 
    {
        this.provinceid = provinceid;
    }

    public String getProvinceid() 
    {
        return provinceid;
    }
    public void setProvincename(String provincename) 
    {
        this.provincename = provincename;
    }

    public String getProvincename() 
    {
        return provincename;
    }
    public void setPositionname(String positionname) 
    {
        this.positionname = positionname;
    }

    public String getPositionname() 
    {
        return positionname;
    }
    public void setStationcode(String stationcode) 
    {
        this.stationcode = stationcode;
    }

    public String getStationcode() 
    {
        return stationcode;
    }
    public void setCo(String co) 
    {
        this.co = co;
    }

    public String getCo() 
    {
        return co;
    }
    public void setCo24h(String co24h) 
    {
        this.co24h = co24h;
    }

    public String getCo24h() 
    {
        return co24h;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setMeasure(String measure) 
    {
        this.measure = measure;
    }

    public String getMeasure() 
    {
        return measure;
    }
    public void setNo2(String no2) 
    {
        this.no2 = no2;
    }

    public String getNo2() 
    {
        return no2;
    }
    public void setNo224h(String no224h) 
    {
        this.no224h = no224h;
    }

    public String getNo224h() 
    {
        return no224h;
    }
    public void setO3(String o3) 
    {
        this.o3 = o3;
    }

    public String getO3() 
    {
        return o3;
    }
    public void setO324h(String o324h) 
    {
        this.o324h = o324h;
    }

    public String getO324h() 
    {
        return o324h;
    }
    public void setO38h(String o38h) 
    {
        this.o38h = o38h;
    }

    public String getO38h() 
    {
        return o38h;
    }
    public void setPm10(String pm10) 
    {
        this.pm10 = pm10;
    }

    public String getPm10() 
    {
        return pm10;
    }
    public void setPm1024h(String pm1024h) 
    {
        this.pm1024h = pm1024h;
    }

    public String getPm1024h() 
    {
        return pm1024h;
    }
    public void setPm25(String pm25) 
    {
        this.pm25 = pm25;
    }

    public String getPm25() 
    {
        return pm25;
    }
    public void setPm2524h(String pm2524h) 
    {
        this.pm2524h = pm2524h;
    }

    public String getPm2524h() 
    {
        return pm2524h;
    }
    public void setSo2(String so2) 
    {
        this.so2 = so2;
    }

    public String getSo2() 
    {
        return so2;
    }
    public void setSo224h(String so224h) 
    {
        this.so224h = so224h;
    }

    public String getSo224h() 
    {
        return so224h;
    }
    public void setAqi(String aqi) 
    {
        this.aqi = aqi;
    }

    public String getAqi() 
    {
        return aqi;
    }
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
    public void setUnheathful(String unheathful) 
    {
        this.unheathful = unheathful;
    }

    public String getUnheathful() 
    {
        return unheathful;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("timepoint", getTimepoint())
            .append("area", getArea())
            .append("citycode", getCitycode())
            .append("provinceid", getProvinceid())
            .append("provincename", getProvincename())
            .append("positionname", getPositionname())
            .append("stationcode", getStationcode())
            .append("co", getCo())
            .append("co24h", getCo24h())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("measure", getMeasure())
            .append("no2", getNo2())
            .append("no224h", getNo224h())
            .append("o3", getO3())
            .append("o324h", getO324h())
            .append("o38h", getO38h())
            .append("pm10", getPm10())
            .append("pm1024h", getPm1024h())
            .append("pm25", getPm25())
            .append("pm2524h", getPm2524h())
            .append("so2", getSo2())
            .append("so224h", getSo224h())
            .append("aqi", getAqi())
            .append("colevel", getColevel())
            .append("no2level", getNo2level())
            .append("o3level", getO3level())
            .append("pm10level", getPm10level())
            .append("pm25level", getPm25level())
            .append("so2level", getSo2level())
            .append("primarypollutant", getPrimarypollutant())
            .append("quality", getQuality())
            .append("unheathful", getUnheathful())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
