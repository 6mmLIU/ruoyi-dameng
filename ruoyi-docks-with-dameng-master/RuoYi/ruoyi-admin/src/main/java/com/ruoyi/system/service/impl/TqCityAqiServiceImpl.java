package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.TqCityAqiMapper;
import com.ruoyi.system.service.ITqCityAqiService;
import com.ruoyi.system.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市AQI管理Service业务层处理
 *
 * @date 2024-03-20
 */
@Service
public class TqCityAqiServiceImpl implements ITqCityAqiService
{
    @Autowired
    private TqCityAqiMapper tqCityAqiMapper;

    /**
     * 查询城市AQI管理
     * 
     * @param id 城市AQI管理ID
     * @return 城市AQI管理
     */
    @Override
    public TqCityAqi selectTqCityAqiById(String id)
    {
        return tqCityAqiMapper.selectTqCityAqiById(id);
    }
    @Override
    public TqCityAqi selectTqCityAqiByCode(String code)
    {
        return tqCityAqiMapper.selectTqCityAqiByCode(code);
    }
    /**
     * 查询城市AQI管理列表
     * 
     * @param tqCityAqi 城市AQI管理
     * @return 城市AQI管理
     */
    @Override
    public List<TqCityAqi> selectTqCityAqiList(TqCityAqi tqCityAqi)
    {
        return tqCityAqiMapper.selectTqCityAqiList(tqCityAqi);
    }
    public List<TqCityAqi> selectTqCityList(String citycode,String time){
        return tqCityAqiMapper.selectTqCityList(citycode,time);
    }
    public List<TqCityAqi> getCityAQIListByProvince(InputGetCityAQIList inputInfo){
        return tqCityAqiMapper.getCityAQIListByProvince(inputInfo);
    }
    @Override
    public List<TqCityAqi> getCityAQIList(InputGetCityAQIList inputInfo)
    {
        return tqCityAqiMapper.getCityAQIList(inputInfo);
    }
    public List<OutputProvinceAQIAverage> getProvinceAQIList(InputGetProvinceAQIList inputInfo)
    {
        return tqCityAqiMapper.getProvinceAQIList(inputInfo);
    }
    public List<OutputAQILevelNum> queryAQILevelNum()
    {
        return tqCityAqiMapper.queryAQILevelNum();
    }
    public OutputAQIAverage queryQIAverage()
    {
        return tqCityAqiMapper.queryQIAverage();
    }
    public List<OutputAirLast7> queryDateLast7ByCity(String id){
        return tqCityAqiMapper.queryDateLast7ByCity(id);
    }
    /**
     * 新增城市AQI管理
     * 
     * @param tqCityAqi 城市AQI管理
     * @return 结果
     */
    @Override
    public int insertTqCityAqi(TqCityAqi tqCityAqi)
    {
       tqCityAqi.setId(UUIDGenerator.generate());
        tqCityAqi.setCreateTime(DateUtils.getNowDate());
        return tqCityAqiMapper.insertTqCityAqi(tqCityAqi);
    }

    /**
     * 修改城市AQI管理
     * 
     * @param tqCityAqi 城市AQI管理
     * @return 结果
     */
    @Override
    public int updateTqCityAqi(TqCityAqi tqCityAqi)
    {
        tqCityAqi.setUpdateTime(DateUtils.getNowDate());
        return tqCityAqiMapper.updateTqCityAqi(tqCityAqi);
    }

    /**
     * 删除城市AQI管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTqCityAqiByIds(String ids)
    {
        return tqCityAqiMapper.deleteTqCityAqiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除城市AQI管理信息
     * 
     * @param id 城市AQI管理ID
     * @return 结果
     */
    @Override
    public int deleteTqCityAqiById(String id)
    {
        return tqCityAqiMapper.deleteTqCityAqiById(id);
    }
}
