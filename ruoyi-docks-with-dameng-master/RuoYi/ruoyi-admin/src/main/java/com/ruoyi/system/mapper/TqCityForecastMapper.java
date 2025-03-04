package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.TqCityForecast;

import java.util.List;

/**
 * 城市AQI预测管理Mapper接口
 *
 * @date 2024-03-27
 */
public interface TqCityForecastMapper 
{
    /**
     * 查询城市AQI预测管理
     * 
     * @param id 城市AQI预测管理ID
     * @return 城市AQI预测管理
     */
    public TqCityForecast selectTqCityForecastById(String id);
    public List<TqCityForecast>  queryForecastAQIByCity(String code);
    /**
     * 查询城市AQI预测管理列表
     * 
     * @param tqCityForecast 城市AQI预测管理
     * @return 城市AQI预测管理集合
     */
    public List<TqCityForecast> selectTqCityForecastList(TqCityForecast tqCityForecast);

    /**
     * 新增城市AQI预测管理
     * 
     * @param tqCityForecast 城市AQI预测管理
     * @return 结果
     */
    public int insertTqCityForecast(TqCityForecast tqCityForecast);

    /**
     * 修改城市AQI预测管理
     * 
     * @param tqCityForecast 城市AQI预测管理
     * @return 结果
     */
    public int updateTqCityForecast(TqCityForecast tqCityForecast);

    /**
     * 删除城市AQI预测管理
     * 
     * @param id 城市AQI预测管理ID
     * @return 结果
     */
    public int deleteTqCityForecastById(String id);
    public int deleteTqCityForecastByCityCode(String cityCode);
    /**
     * 批量删除城市AQI预测管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTqCityForecastByIds(String[] ids);
}
