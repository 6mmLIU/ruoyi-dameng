package com.ruoyi.system.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("系统接口")
@Controller
@RequestMapping("/Aqi")
public class AqiContorller {
    @Autowired
    private ITqCityAqiService tqCityAqiService;
    @Autowired
    private ITqProvinceService tqProvinceService;
    @Autowired
    private ITqCityService tqCityService;

    @Autowired
    private ITqAqiStationService tqAqiStationService;
    @Autowired
    private ITqCityForecastService tqCityForecastService;
    @GetMapping("/test")
    @ResponseBody
    public AjaxResult getTest(HttpServletRequest request) {
        String id = request.getParameter("id");
        if(null!=tqCityAqiService) {
            System.out.println("tqCityAqiService！=null！");
        }else{
            System.out.println("tqCityAqiService=null！");
        }
        return AjaxResult.success("我是test！id="+id);
    }

    //获得最近采集时间的某个城市AQI
    @PostMapping("/getCityAQIList")
    @ResponseBody
    public AjaxResult getCityAQIList(HttpServletRequest request, @RequestBody InputGetCityAQIList inputInfo) {

        try {
            System.out.println("getCityAQIList 进来了");
            List<TqCityAqi> tqCityAqiList = tqCityAqiService.getCityAQIList(inputInfo);

            if (null != tqCityAqiList) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", tqCityAqiList);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }
    //获得最近采集时间的各省的平均空气质量
    @PostMapping("/getProvinceAQIList")
    @ResponseBody
    public AjaxResult getProvinceAQIList(HttpServletRequest request, @RequestBody InputGetProvinceAQIList inputInfo) {

        try {

            List<OutputProvinceAQIAverage> tqCityAqiList = tqCityAqiService.getProvinceAQIList(inputInfo);

            if (null != tqCityAqiList) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", tqCityAqiList);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }

    //获得最近采集时间的每种空气等级的城市个数和百分比
    @GetMapping("/queryAQILevelNum")
    @ResponseBody
    public AjaxResult queryAQILevelNum(HttpServletRequest request) {
        try {
            System.out.println("getCityAQIList 进来了");
            List<OutputAQILevelNum> list = tqCityAqiService.queryAQILevelNum();

            if (null != list) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", list);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }

    //获得最近采集时间的全国平均空气质量
    @GetMapping("/queryQIAverage")
    @ResponseBody
    public AjaxResult queryQIAverage(HttpServletRequest request) {
        try {

            OutputAQIAverage OutputAQIAverage = tqCityAqiService.queryQIAverage();
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", OutputAQIAverage);
            return ajaxResult;
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }

    //获得所有省
    @GetMapping("/getAllProvince")
    @ResponseBody
    public AjaxResult getAllProvince(HttpServletRequest request) {
        try {

            List<TqProvince> list = tqProvinceService.selectTqProvinceList(new TqProvince());
            if (null != list) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", list);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }

    //通过省编号查询下属所有城市
    @GetMapping("/getAllCityByProvince")
    @ResponseBody
    public AjaxResult getAllCityByProvince(HttpServletRequest request) {
        try {
            String code = request.getParameter("code");
            TqCity city=new TqCity();
            city.setProvinceId(code);
            List<TqCity> list = tqCityService.selectTqCityList(city);
            if (null != list) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", list);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }
    //通过城市名称，获得最近采集时间的各监测点空气质量
    @GetMapping("/queryStationAQIByCity")
    @ResponseBody
    public AjaxResult queryStationAQIByCity(HttpServletRequest request) {
        try {
            String code = request.getParameter("code");

            List<TqAqiStation> list = tqAqiStationService.queryStationAQIByCity(code);
            System.out.println("站点个数："+list.size());
            if (null != list) {
                OutPutStationAQI aqi=new OutPutStationAQI();
                aqi.setList(list);
                aqi.setStationNum(list.size());
                int num=0;
                for(int i=0;i<list.size();i++){
                    String strAqi=list.get(i).getAqi();
                    try {
                        if (Integer.parseInt(list.get(i).getAqi()) > 100) {
                            num = num + 1;
                        }
                    } catch (Exception e) {
                       continue;
                    }
                }
                aqi.setWrSationNum(num);
                aqi.setCityAqi(tqCityAqiService.selectTqCityAqiByCode(code));
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", aqi);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }
    //9、通过省编号，获得最近采集时间的城市空气质量数据
    @PostMapping("/getCityAQIListByProvince")
    @ResponseBody
    public AjaxResult getCityAQIListByProvince(HttpServletRequest request, @RequestBody InputGetCityAQIList inputInfo) {
        System.out.println("getCityAQIListByProvince 进来了");
        try {
            System.out.println("inputInfo"+inputInfo.toString());
            List<TqCityAqi> list = tqCityAqiService.getCityAQIListByProvince(inputInfo);
            if (null != list) {
                System.out.println("list"+list.size());
                OutPutCityAQIByProvince aqi=new OutPutCityAQIByProvince();
                aqi.setList(list);
                aqi.setCityNum(list.size());
                InputGetProvinceAQIList input=new InputGetProvinceAQIList(inputInfo.getCode(),inputInfo.getType(),inputInfo.getPx());
                List<OutputProvinceAQIAverage> tqCityAqiList = tqCityAqiService.getProvinceAQIList(input);
                if(null!=tqCityAqiList&&tqCityAqiList.size()>0) {
                    aqi.setAqi(tqCityAqiList.get(0).getAqi());
                    aqi.setCo(tqCityAqiList.get(0).getCo());
                    aqi.setNo2(tqCityAqiList.get(0).getNo2());
                    aqi.setO3(tqCityAqiList.get(0).getO3());
                    aqi.setPm2_5(tqCityAqiList.get(0).getPm2_5());
                    aqi.setPm10(tqCityAqiList.get(0).getPm10());
                    aqi.setSo2(tqCityAqiList.get(0).getSo2());
                }
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", aqi);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }

        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }
    //获得某个城市最近7天的空气质量数据
    @GetMapping("/queryDateLast7ByCity")
    @ResponseBody
    public AjaxResult queryDateLast7ByCity(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");

            List<OutputAirLast7> list = tqCityAqiService.queryDateLast7ByCity(id);
            if (null != list) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", list);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }
    //10、通过城市编号，获得该城市空气质量预测数据
    @GetMapping("/queryForecastAQIByCity")
    @ResponseBody
    public AjaxResult queryForecastAQIByCity(HttpServletRequest request) {
        try {
            String code = request.getParameter("code");

            List<TqCityForecast> list = tqCityForecastService.queryForecastAQIByCity(code);
            if (null != list) {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS, "请求成功！", list);
                return ajaxResult;
            } else {
                AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！");
                return ajaxResult;
            }
        } catch (Exception e) {
            AjaxResult ajaxResult = new AjaxResult(AjaxResult.Type.ERROR, "请求失败！" + e.getMessage());
            return ajaxResult;
        }
    }

}

