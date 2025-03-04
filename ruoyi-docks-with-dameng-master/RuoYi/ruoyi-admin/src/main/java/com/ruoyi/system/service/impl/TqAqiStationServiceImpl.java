package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.system.domain.TqAqiStation;
import com.ruoyi.system.mapper.TqAqiStationMapper;
import com.ruoyi.system.service.ITqAqiStationService;
import com.ruoyi.system.util.UUIDGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 监测点AQI管理Service业务层处理
 *
 * @date 2024-03-24
 */
@Service
public class TqAqiStationServiceImpl implements ITqAqiStationService
{
    @Autowired
    private TqAqiStationMapper tqAqiStationMapper;

    /**
     * 查询监测点AQI管理
     * 
     * @param id 监测点AQI管理ID
     * @return 监测点AQI管理
     */
    @Override
    public TqAqiStation selectTqAqiStationById(String id)
    {
        return tqAqiStationMapper.selectTqAqiStationById(id);
    }
    public List<TqAqiStation> selectTqStationList(String area,  String position,  String time){
        return tqAqiStationMapper.selectTqStationList(area,position,time);
    }
    /**
     * 查询监测点AQI管理列表
     * 
     * @param tqAqiStation 监测点AQI管理
     * @return 监测点AQI管理
     */
    @Override
    public List<TqAqiStation> selectTqAqiStationList(TqAqiStation tqAqiStation)
    {
        return tqAqiStationMapper.selectTqAqiStationList(tqAqiStation);
    }
    public List<TqAqiStation> queryStationAQIByCity(String code){
        return tqAqiStationMapper.queryStationAQIByCity(code);
    }
    /**
     * 新增监测点AQI管理
     * 
     * @param tqAqiStation 监测点AQI管理
     * @return 结果
     */
    @Override
    public int insertTqAqiStation(TqAqiStation tqAqiStation)
    {
       tqAqiStation.setId(UUIDGenerator.generate());
        tqAqiStation.setCreateTime(DateUtils.getNowDate());
        return tqAqiStationMapper.insertTqAqiStation(tqAqiStation);
    }

    /**
     * 修改监测点AQI管理
     * 
     * @param tqAqiStation 监测点AQI管理
     * @return 结果
     */
    @Override
    public int updateTqAqiStation(TqAqiStation tqAqiStation)
    {
        return tqAqiStationMapper.updateTqAqiStation(tqAqiStation);
    }

    /**
     * 删除监测点AQI管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTqAqiStationByIds(String ids)
    {
        return tqAqiStationMapper.deleteTqAqiStationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除监测点AQI管理信息
     * 
     * @param id 监测点AQI管理ID
     * @return 结果
     */
    @Override
    public int deleteTqAqiStationById(String id)
    {
        return tqAqiStationMapper.deleteTqAqiStationById(id);
    }
}
