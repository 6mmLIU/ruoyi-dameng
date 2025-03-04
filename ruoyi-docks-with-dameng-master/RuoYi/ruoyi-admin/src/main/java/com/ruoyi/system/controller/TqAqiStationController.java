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
import com.ruoyi.system.domain.TqAqiStation;
import com.ruoyi.system.service.ITqAqiStationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市监测点管理Controller
 *
 * @date 2024-03-30
 */
@Controller
@RequestMapping("/system/station")
public class TqAqiStationController extends BaseController
{
    private String prefix = "system/station";

    @Autowired
    private ITqAqiStationService tqAqiStationService;

    @RequiresPermissions("system:station:view")
    @GetMapping()
    public String station()
    {
        return prefix + "/station";
    }

    /**
     * 查询城市监测点管理列表
     */
    @RequiresPermissions("system:station:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TqAqiStation tqAqiStation)
    {
        startPage();
        List<TqAqiStation> list = tqAqiStationService.selectTqAqiStationList(tqAqiStation);
        return getDataTable(list);
    }

    /**
     * 导出城市监测点管理列表
     */
    @RequiresPermissions("system:station:export")
    @Log(title = "城市监测点管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TqAqiStation tqAqiStation)
    {
        List<TqAqiStation> list = tqAqiStationService.selectTqAqiStationList(tqAqiStation);
        ExcelUtil<TqAqiStation> util = new ExcelUtil<TqAqiStation>(TqAqiStation.class);
        return util.exportExcel(list, "城市监测点管理数据");
    }

    /**
     * 新增城市监测点管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市监测点管理
     */
    @RequiresPermissions("system:station:add")
    @Log(title = "城市监测点管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TqAqiStation tqAqiStation)
    {
        return toAjax(tqAqiStationService.insertTqAqiStation(tqAqiStation));
    }

    /**
     * 修改城市监测点管理
     */
    @RequiresPermissions("system:station:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TqAqiStation tqAqiStation = tqAqiStationService.selectTqAqiStationById(id);
        mmap.put("tqAqiStation", tqAqiStation);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市监测点管理
     */
    @RequiresPermissions("system:station:edit")
    @Log(title = "城市监测点管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TqAqiStation tqAqiStation)
    {
        return toAjax(tqAqiStationService.updateTqAqiStation(tqAqiStation));
    }

    /**
     * 删除城市监测点管理
     */
    @RequiresPermissions("system:station:remove")
    @Log(title = "城市监测点管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tqAqiStationService.deleteTqAqiStationByIds(ids));
    }
}
