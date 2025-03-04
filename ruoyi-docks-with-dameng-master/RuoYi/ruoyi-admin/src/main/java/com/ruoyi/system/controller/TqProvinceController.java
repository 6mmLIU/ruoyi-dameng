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
import com.ruoyi.system.domain.TqProvince;
import com.ruoyi.system.service.ITqProvinceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 省份管理Controller
 * @date 2024-03-30
 */
@Controller
@RequestMapping("/system/province")
public class TqProvinceController extends BaseController
{
    private String prefix = "system/province";

    @Autowired
    private ITqProvinceService tqProvinceService;

    @RequiresPermissions("system:province:view")
    @GetMapping()
    public String province()
    {
        return prefix + "/province";
    }

    /**
     * 查询省份管理列表
     */
    @RequiresPermissions("system:province:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TqProvince tqProvince)
    {
        startPage();
        List<TqProvince> list = tqProvinceService.selectTqProvinceList(tqProvince);
        return getDataTable(list);
    }

    /**
     * 导出省份管理列表
     */
    @RequiresPermissions("system:province:export")
    @Log(title = "省份管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TqProvince tqProvince)
    {
        List<TqProvince> list = tqProvinceService.selectTqProvinceList(tqProvince);
        ExcelUtil<TqProvince> util = new ExcelUtil<TqProvince>(TqProvince.class);
        return util.exportExcel(list, "省份管理数据");
    }

    /**
     * 新增省份管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存省份管理
     */
    @RequiresPermissions("system:province:add")
    @Log(title = "省份管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TqProvince tqProvince)
    {
        return toAjax(tqProvinceService.insertTqProvince(tqProvince));
    }

    /**
     * 修改省份管理
     */
    @RequiresPermissions("system:province:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TqProvince tqProvince = tqProvinceService.selectTqProvinceById(id);
        mmap.put("tqProvince", tqProvince);
        return prefix + "/edit";
    }

    /**
     * 修改保存省份管理
     */
    @RequiresPermissions("system:province:edit")
    @Log(title = "省份管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TqProvince tqProvince)
    {
        return toAjax(tqProvinceService.updateTqProvince(tqProvince));
    }

    /**
     * 删除省份管理
     */
    @RequiresPermissions("system:province:remove")
    @Log(title = "省份管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tqProvinceService.deleteTqProvinceByIds(ids));
    }
}
