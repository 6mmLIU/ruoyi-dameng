package com.ruoyi.system.service;


import com.ruoyi.system.domain.TqProvince;

import java.util.List;

/**
 * 省份管理Service接口
 *
 * @date 2024-03-20
 */
public interface ITqProvinceService 
{
    /**
     * 查询省份管理
     * 
     * @param id 省份管理ID
     * @return 省份管理
     */
    public TqProvince selectTqProvinceById(String id);

    /**
     * 查询省份管理列表
     * 
     * @param tqProvince 省份管理
     * @return 省份管理集合
     */
    public List<TqProvince> selectTqProvinceList(TqProvince tqProvince);

    /**
     * 新增省份管理
     * 
     * @param tqProvince 省份管理
     * @return 结果
     */
    public int insertTqProvince(TqProvince tqProvince);

    /**
     * 修改省份管理
     * 
     * @param tqProvince 省份管理
     * @return 结果
     */
    public int updateTqProvince(TqProvince tqProvince);

    /**
     * 批量删除省份管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTqProvinceByIds(String ids);

    /**
     * 删除省份管理信息
     * 
     * @param id 省份管理ID
     * @return 结果
     */
    public int deleteTqProvinceById(String id);
}
