package com.ruoyi.system.service;


import com.ruoyi.system.domain.TqAqiStation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 监测点AQI管理Service接口
 *
 * @date 2024-03-24
 */
public interface ITqAqiStationService 
{
    /**
     * 查询监测点AQI管理
     * 
     * @param id 监测点AQI管理ID
     * @return 监测点AQI管理
     */
    public TqAqiStation selectTqAqiStationById(String id);

    /**
     * 查询监测点AQI管理列表
     * 
     * @param tqAqiStation 监测点AQI管理
     * @return 监测点AQI管理集合
     */
    public List<TqAqiStation> selectTqAqiStationList(TqAqiStation tqAqiStation);
    public List<TqAqiStation> selectTqStationList(@Param("area") String area,@Param("position") String position,@Param("time") String time);
    public List<TqAqiStation> queryStationAQIByCity(@Param("code")  String code);
    /**
     * 新增监测点AQI管理
     * 
     * @param tqAqiStation 监测点AQI管理
     * @return 结果
     */
    public int insertTqAqiStation(TqAqiStation tqAqiStation);

    /**
     * 修改监测点AQI管理
     * 
     * @param tqAqiStation 监测点AQI管理
     * @return 结果
     */
    public int updateTqAqiStation(TqAqiStation tqAqiStation);

    /**
     * 批量删除监测点AQI管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTqAqiStationByIds(String ids);

    /**
     * 删除监测点AQI管理信息
     * 
     * @param id 监测点AQI管理ID
     * @return 结果
     */
    public int deleteTqAqiStationById(String id);
}
