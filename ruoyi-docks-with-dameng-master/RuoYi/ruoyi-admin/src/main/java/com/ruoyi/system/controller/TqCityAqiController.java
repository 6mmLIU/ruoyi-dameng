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
import com.ruoyi.system.domain.TqCityAqi;
import com.ruoyi.system.service.ITqCityAqiService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市空气质量管理Controller
 *
 * @date 2024-03-30
 */
@Controller
@RequestMapping("/system/aqi")
public class TqCityAqiController extends BaseController
{
    private String prefix = "system/aqi";

    @Autowired
    private ITqCityAqiService tqCityAqiService;

    @RequiresPermissions("system:aqi:view")
    @GetMapping()
    public String aqi()
    {
        return prefix + "/aqi";
    }

    /**
     * 查询城市空气质量管理列表
     */
    @RequiresPermissions("system:aqi:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TqCityAqi tqCityAqi)
    {
        startPage();
        List<TqCityAqi> list = tqCityAqiService.selectTqCityAqiList(tqCityAqi);
        return getDataTable(list);
    }

    /**
     * 导出城市空气质量管理列表
     */
    @RequiresPermissions("system:aqi:export")
    @Log(title = "城市空气质量管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TqCityAqi tqCityAqi)
    {
        List<TqCityAqi> list = tqCityAqiService.selectTqCityAqiList(tqCityAqi);
        ExcelUtil<TqCityAqi> util = new ExcelUtil<TqCityAqi>(TqCityAqi.class);
        return util.exportExcel(list, "城市空气质量管理数据");
    }

    /**
     * 新增城市空气质量管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市空气质量管理
     */
    @RequiresPermissions("system:aqi:add")
    @Log(title = "城市空气质量管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TqCityAqi tqCityAqi)
    {
        return toAjax(tqCityAqiService.insertTqCityAqi(tqCityAqi));
    }

    /**
     * 修改城市空气质量管理
     */
    @RequiresPermissions("system:aqi:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TqCityAqi tqCityAqi = tqCityAqiService.selectTqCityAqiById(id);
        mmap.put("tqCityAqi", tqCityAqi);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市空气质量管理
     */
    @RequiresPermissions("system:aqi:edit")
    @Log(title = "城市空气质量管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TqCityAqi tqCityAqi)
    {
        return toAjax(tqCityAqiService.updateTqCityAqi(tqCityAqi));
    }

    /**
     * 删除城市空气质量管理
     */
    @RequiresPermissions("system:aqi:remove")
    @Log(title = "城市空气质量管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tqCityAqiService.deleteTqCityAqiByIds(ids));
    }
}
