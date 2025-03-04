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
import com.ruoyi.system.domain.TqCityForecast;
import com.ruoyi.system.service.ITqCityForecastService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市空气质量预测Controller
 *
 * @date 2024-03-30
 */
@Controller
@RequestMapping("/system/forecast")
public class TqCityForecastController extends BaseController
{
    private String prefix = "system/forecast";

    @Autowired
    private ITqCityForecastService tqCityForecastService;

    @RequiresPermissions("system:forecast:view")
    @GetMapping()
    public String forecast()
    {
        return prefix + "/forecast";
    }

    /**
     * 查询城市空气质量预测列表
     */
    @RequiresPermissions("system:forecast:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TqCityForecast tqCityForecast)
    {
        startPage();
        List<TqCityForecast> list = tqCityForecastService.selectTqCityForecastList(tqCityForecast);
        return getDataTable(list);
    }

    /**
     * 导出城市空气质量预测列表
     */
    @RequiresPermissions("system:forecast:export")
    @Log(title = "城市空气质量预测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TqCityForecast tqCityForecast)
    {
        List<TqCityForecast> list = tqCityForecastService.selectTqCityForecastList(tqCityForecast);
        ExcelUtil<TqCityForecast> util = new ExcelUtil<TqCityForecast>(TqCityForecast.class);
        return util.exportExcel(list, "城市空气质量预测数据");
    }

    /**
     * 新增城市空气质量预测
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市空气质量预测
     */
    @RequiresPermissions("system:forecast:add")
    @Log(title = "城市空气质量预测", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TqCityForecast tqCityForecast)
    {
        return toAjax(tqCityForecastService.insertTqCityForecast(tqCityForecast));
    }

    /**
     * 修改城市空气质量预测
     */
    @RequiresPermissions("system:forecast:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TqCityForecast tqCityForecast = tqCityForecastService.selectTqCityForecastById(id);
        mmap.put("tqCityForecast", tqCityForecast);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市空气质量预测
     */
    @RequiresPermissions("system:forecast:edit")
    @Log(title = "城市空气质量预测", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TqCityForecast tqCityForecast)
    {
        return toAjax(tqCityForecastService.updateTqCityForecast(tqCityForecast));
    }

    /**
     * 删除城市空气质量预测
     */
    @RequiresPermissions("system:forecast:remove")
    @Log(title = "城市空气质量预测", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tqCityForecastService.deleteTqCityForecastByIds(ids));
    }
}
