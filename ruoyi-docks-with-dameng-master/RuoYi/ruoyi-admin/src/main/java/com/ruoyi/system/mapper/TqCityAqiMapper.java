package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市AQI管理Mapper接口
 *
 * @date 2024-03-20
 */
public interface TqCityAqiMapper 
{
    /**
     * 查询城市AQI管理
     * 
     * @param id 城市AQI管理ID
     * @return 城市AQI管理
     */
    public TqCityAqi selectTqCityAqiById(String id);
    public TqCityAqi selectTqCityAqiByCode(String code);
    /**
     * 查询城市AQI管理列表
     * 
     * @param tqCityAqi 城市AQI管理
     * @return 城市AQI管理集合
     */
    public List<TqCityAqi> selectTqCityAqiList(TqCityAqi tqCityAqi);
    public List<TqCityAqi> selectTqCityList(@Param("citycode") String citycode,@Param("time") String time);
    public List<TqCityAqi> getCityAQIListByProvince(InputGetCityAQIList inputInfo);
    public List<TqCityAqi> getCityAQIList(InputGetCityAQIList inputInfo);
    public List<OutputProvinceAQIAverage> getProvinceAQIList(InputGetProvinceAQIList inputInfo);
    public List<OutputAQILevelNum> queryAQILevelNum();
    public OutputAQIAverage queryQIAverage();
    public List<OutputAirLast7> queryDateLast7ByCity(@Param("id") String id);
    /**
     * 新增城市AQI管理
     * 
     * @param tqCityAqi 城市AQI管理
     * @return 结果
     */
    public int insertTqCityAqi(TqCityAqi tqCityAqi);

    /**
     * 修改城市AQI管理
     * 
     * @param tqCityAqi 城市AQI管理
     * @return 结果
     */
    public int updateTqCityAqi(TqCityAqi tqCityAqi);

    /**
     * 删除城市AQI管理
     * 
     * @param id 城市AQI管理ID
     * @return 结果
     */
    public int deleteTqCityAqiById(String id);

    /**
     * 批量删除城市AQI管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTqCityAqiByIds(String[] ids);
}
