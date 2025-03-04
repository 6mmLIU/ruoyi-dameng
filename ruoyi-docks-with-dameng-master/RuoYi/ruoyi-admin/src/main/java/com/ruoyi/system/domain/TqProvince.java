package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 省份管理对象 tq_province
 *
 * @date 2024-03-30
 */
public class TqProvince extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 省ID */
    private String id;

    /** 省编码 */
    @Excel(name = "省编码")
    private String provinceCode;

    /** 省名称 */
    @Excel(name = "省名称")
    private String provinceName;

    /** 省拼音 */
    @Excel(name = "省拼音")
    private String provinceJc;

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
    public void setProvinceCode(String provinceCode) 
    {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode() 
    {
        return provinceCode;
    }
    public void setProvinceName(String provinceName) 
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName() 
    {
        return provinceName;
    }
    public void setProvinceJc(String provinceJc) 
    {
        this.provinceJc = provinceJc;
    }

    public String getProvinceJc() 
    {
        return provinceJc;
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
            .append("provinceCode", getProvinceCode())
            .append("provinceName", getProvinceName())
            .append("provinceJc", getProvinceJc())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("flag", getFlag())
            .toString();
    }
}
