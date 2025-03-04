package com.ruoyi.system.service;


import com.ruoyi.system.domain.TqCity;

import java.util.List;

/**
 * 城市管理Service接口
 *
 * @date 2024-03-20
 */
public interface ITqCityService 
{
    /**
     * 查询城市管理
     * 
     * @param id 城市管理ID
     * @return 城市管理
     */
    public TqCity selectTqCityById(String id);


    /**
     * 查询城市管理列表
     * 
     * @param tqCity 城市管理
     * @return 城市管理集合
     */
    public List<TqCity> selectTqCityList(TqCity tqCity);

    /**
     * 新增城市管理
     * 
     * @param tqCity 城市管理
     * @return 结果
     */
    public int insertTqCity(TqCity tqCity);

    /**
     * 修改城市管理
     * 
     * @param tqCity 城市管理
     * @return 结果
     */
    public int updateTqCity(TqCity tqCity);

    /**
     * 批量删除城市管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTqCityByIds(String ids);


    public TqCity selectTqCityByName(String code);
    public int deleteTqCityById(String id);
}
