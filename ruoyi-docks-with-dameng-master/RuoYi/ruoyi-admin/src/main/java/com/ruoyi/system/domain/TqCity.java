package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 城市对象 tq_city
 * @date 2024-03-30
 */
public class TqCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市ID */
    private String id;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String cityCode;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    /** 所属省编码 */
    @Excel(name = "所属省编码")
    private String provinceId;

    /** 所属省名称 */
    @Excel(name = "所属省名称")
    private String provinceName;

    /** 城市拼音 */
    @Excel(name = "城市拼音")
    private String cityJc;

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
    public void setCityCode(String cityCode) 
    {
        this.cityCode = cityCode;
    }

    public String getCityCode() 
    {
        return cityCode;
    }
    public void setCityName(String cityName) 
    {
        this.cityName = cityName;
    }

    public String getCityName() 
    {
        return cityName;
    }
    public void setProvinceId(String provinceId) 
    {
        this.provinceId = provinceId;
    }

    public String getProvinceId() 
    {
        return provinceId;
    }
    public void setProvinceName(String provinceName) 
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName() 
    {
        return provinceName;
    }
    public void setCityJc(String cityJc) 
    {
        this.cityJc = cityJc;
    }

    public String getCityJc() 
    {
        return cityJc;
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
            .append("cityCode", getCityCode())
            .append("cityName", getCityName())
            .append("provinceId", getProvinceId())
            .append("provinceName", getProvinceName())
            .append("cityJc", getCityJc())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("flag", getFlag())
            .toString();
    }
}
