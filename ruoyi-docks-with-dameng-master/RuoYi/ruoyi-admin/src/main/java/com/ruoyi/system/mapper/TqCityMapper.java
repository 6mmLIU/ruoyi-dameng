package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TqCity;

/**
 * 城市Mapper接口
 *
 * @date 2024-03-30
 */
public interface TqCityMapper 
{
    /**
     * 查询城市
     * 
     * @param id 城市主键
     * @return 城市
     */
    public TqCity selectTqCityById(String id);

    /**
     * 查询城市列表
     * 
     * @param tqCity 城市
     * @return 城市集合
     */
    public List<TqCity> selectTqCityList(TqCity tqCity);

    /**
     * 新增城市
     * 
     * @param tqCity 城市
     * @return 结果
     */
    public int insertTqCity(TqCity tqCity);

    /**
     * 修改城市
     * 
     * @param tqCity 城市
     * @return 结果
     */
    public int updateTqCity(TqCity tqCity);

    /**
     * 删除城市
     * 
     * @param id 城市主键
     * @return 结果
     */
    public int deleteTqCityById(String id);

    /**
     * 批量删除城市
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTqCityByIds(String[] ids);
    public TqCity selectTqCityByName(String name);
}
