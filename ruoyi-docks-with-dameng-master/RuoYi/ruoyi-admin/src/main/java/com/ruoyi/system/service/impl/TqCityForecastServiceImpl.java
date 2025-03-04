package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.system.domain.TqCityForecast;
import com.ruoyi.system.mapper.TqCityForecastMapper;
import com.ruoyi.system.service.ITqCityForecastService;
import com.ruoyi.system.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市AQI预测管理Service业务层处理
 * @date 2024-03-27
 */
@Service
public class TqCityForecastServiceImpl implements ITqCityForecastService
{
    @Autowired
    private TqCityForecastMapper tqCityForecastMapper;

    /**
     * 查询城市AQI预测管理
     * 
     * @param id 城市AQI预测管理ID
     * @return 城市AQI预测管理
     */
    @Override
    public TqCityForecast selectTqCityForecastById(String id)
    {
        return tqCityForecastMapper.selectTqCityForecastById(id);
    }
    public List<TqCityForecast>  queryForecastAQIByCity(String code)
    {
        return tqCityForecastMapper.queryForecastAQIByCity(code);
    }
    /**
     * 查询城市AQI预测管理列表
     * 
     * @param tqCityForecast 城市AQI预测管理
     * @return 城市AQI预测管理
     */
    @Override
    public List<TqCityForecast> selectTqCityForecastList(TqCityForecast tqCityForecast)
    {
        return tqCityForecastMapper.selectTqCityForecastList(tqCityForecast);
    }

    /**
     * 新增城市AQI预测管理
     * 
     * @param tqCityForecast 城市AQI预测管理
     * @return 结果
     */
    @Override
    public int insertTqCityForecast(TqCityForecast tqCityForecast)
    {
        tqCityForecast.setId(UUIDGenerator.generate());
        tqCityForecast.setCreateTime(DateUtils.getNowDate());
        return tqCityForecastMapper.insertTqCityForecast(tqCityForecast);
    }

    /**
     * 修改城市AQI预测管理
     * 
     * @param tqCityForecast 城市AQI预测管理
     * @return 结果
     */
    @Override
    public int updateTqCityForecast(TqCityForecast tqCityForecast)
    {
        return tqCityForecastMapper.updateTqCityForecast(tqCityForecast);
    }

    /**
     * 删除城市AQI预测管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTqCityForecastByIds(String ids)
    {
        return tqCityForecastMapper.deleteTqCityForecastByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除城市AQI预测管理信息
     * 
     * @param id 城市AQI预测管理ID
     * @return 结果
     */
    @Override
    public int deleteTqCityForecastById(String id)
    {
        return tqCityForecastMapper.deleteTqCityForecastById(id);
    }
    @Override
    public int deleteTqCityForecastByCityCode(String cityCode)
    {
        return tqCityForecastMapper.deleteTqCityForecastByCityCode(cityCode);
    }
}
