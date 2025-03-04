package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TqCity;
import com.ruoyi.system.service.ITqCityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市Controller
 *
 * @date 2024-03-30
 */
@Controller
@RequestMapping("/system/city")
public class TqCityController extends BaseController
{
    private String prefix = "system/city";

    @Autowired
    private ITqCityService tqCityService;

    @RequiresPermissions("system:city:view")
    @GetMapping()
    public String city()
    {
        return prefix + "/city";
    }

    /**
     * 查询城市列表
     */
    @RequiresPermissions("system:city:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TqCity tqCity)
    {
        startPage();
        List<TqCity> list = tqCityService.selectTqCityList(tqCity);
        return getDataTable(list);
    }

    /**
     * 导出城市列表
     */
    @RequiresPermissions("system:city:export")
    @Log(title = "城市", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TqCity tqCity)
    {
        List<TqCity> list = tqCityService.selectTqCityList(tqCity);
        ExcelUtil<TqCity> util = new ExcelUtil<TqCity>(TqCity.class);
        return util.exportExcel(list, "城市数据");
    }

    /**
     * 新增城市
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市
     */
    @RequiresPermissions("system:city:add")
    @Log(title = "城市", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TqCity tqCity)
    {
        return toAjax(tqCityService.insertTqCity(tqCity));
    }

    /**
     * 修改城市
     */
    @RequiresPermissions("system:city:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TqCity tqCity = tqCityService.selectTqCityById(id);
        mmap.put("tqCity", tqCity);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市
     */
    @RequiresPermissions("system:city:edit")
    @Log(title = "城市", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TqCity tqCity)
    {
        return toAjax(tqCityService.updateTqCity(tqCity));
    }

    /**
     * 删除城市
     */
    @RequiresPermissions("system:city:remove")
    @Log(title = "城市", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tqCityService.deleteTqCityByIds(ids));
    }
}
