package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TqCityMapper;
import com.ruoyi.system.domain.TqCity;
import com.ruoyi.system.service.ITqCityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 城市Service业务层处理
 *
 * @date 2024-03-30
 */
@Service
public class TqCityServiceImpl implements ITqCityService 
{
    @Autowired
    private TqCityMapper tqCityMapper;

    /**
     * 查询城市
     * 
     * @param id 城市主键
     * @return 城市
     */
    @Override
    public TqCity selectTqCityById(String id)
    {
        return tqCityMapper.selectTqCityById(id);
    }

    /**
     * 查询城市列表
     * 
     * @param tqCity 城市
     * @return 城市
     */
    @Override
    public List<TqCity> selectTqCityList(TqCity tqCity)
    {
        return tqCityMapper.selectTqCityList(tqCity);
    }

    /**
     * 新增城市
     * 
     * @param tqCity 城市
     * @return 结果
     */
    @Override
    public int insertTqCity(TqCity tqCity)
    {
        tqCity.setId(UUIDGenerator.generate());
        tqCity.setCreateTime(DateUtils.getNowDate());
        return tqCityMapper.insertTqCity(tqCity);
    }

    /**
     * 修改城市
     * 
     * @param tqCity 城市
     * @return 结果
     */
    @Override
    public int updateTqCity(TqCity tqCity)
    {
        tqCity.setUpdateTime(DateUtils.getNowDate());
        return tqCityMapper.updateTqCity(tqCity);
    }

    /**
     * 批量删除城市
     * 
     * @param ids 需要删除的城市主键
     * @return 结果
     */
    @Override
    public int deleteTqCityByIds(String ids)
    {
        return tqCityMapper.deleteTqCityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除城市信息
     * 
     * @param id 城市主键
     * @return 结果
     */
    @Override
    public int deleteTqCityById(String id)
    {
        return tqCityMapper.deleteTqCityById(id);
    }
    public TqCity selectTqCityByName(String name)
    {
        return tqCityMapper.selectTqCityByName(name);
    }
}
