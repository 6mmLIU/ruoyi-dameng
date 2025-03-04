package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.system.domain.TqProvince;
import com.ruoyi.system.mapper.TqProvinceMapper;
import com.ruoyi.system.service.ITqProvinceService;
import com.ruoyi.system.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 省份管理Service业务层处理
 *
 * @date 2024-03-20
 */
@Service
public class TqProvinceServiceImpl implements ITqProvinceService
{
    @Autowired
    private TqProvinceMapper tqProvinceMapper;

    /**
     * 查询省份管理
     * 
     * @param id 省份管理ID
     * @return 省份管理
     */
    @Override
    public TqProvince selectTqProvinceById(String id)
    {
        return tqProvinceMapper.selectTqProvinceById(id);
    }

    /**
     * 查询省份管理列表
     * 
     * @param tqProvince 省份管理
     * @return 省份管理
     */
    @Override
    public List<TqProvince> selectTqProvinceList(TqProvince tqProvince)
    {
        return tqProvinceMapper.selectTqProvinceList(tqProvince);
    }

    /**
     * 新增省份管理
     * 
     * @param tqProvince 省份管理
     * @return 结果
     */
    @Override
    public int insertTqProvince(TqProvince tqProvince)
    {
        tqProvince.setId(UUIDGenerator.generate());
        tqProvince.setCreateTime(DateUtils.getNowDate());
        return tqProvinceMapper.insertTqProvince(tqProvince);
    }

    /**
     * 修改省份管理
     * 
     * @param tqProvince 省份管理
     * @return 结果
     */
    @Override
    public int updateTqProvince(TqProvince tqProvince)
    {
        tqProvince.setUpdateTime(DateUtils.getNowDate());
        return tqProvinceMapper.updateTqProvince(tqProvince);
    }

    /**
     * 删除省份管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTqProvinceByIds(String ids)
    {
        return tqProvinceMapper.deleteTqProvinceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除省份管理信息
     * 
     * @param id 省份管理ID
     * @return 结果
     */
    @Override
    public int deleteTqProvinceById(String id)
    {
        return tqProvinceMapper.deleteTqProvinceById(id);
    }
}
