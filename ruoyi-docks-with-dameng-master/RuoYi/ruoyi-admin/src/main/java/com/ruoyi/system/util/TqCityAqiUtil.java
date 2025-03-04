package com.ruoyi.system.util;


import com.ruoyi.system.domain.TqCity;
import com.ruoyi.system.service.ITqAqiStationService;
import com.ruoyi.system.service.ITqCityAqiService;
import com.ruoyi.system.service.ITqCityForecastService;
import com.ruoyi.system.service.ITqCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TqCityAqiUtil {
    @Autowired
    private ITqCityAqiService tqCityAqiService;
    @Autowired
    private ITqCityService tqCityService;
    @Autowired
    private ITqAqiStationService tqAqiStationService;
    @Autowired
    private ITqCityForecastService tqCityForecastService;
    private   List<TqCity> tqCitys;
    private   List<TqCity> tqLNCitys;
    public static TqCityAqiUtil tqCityAqiUtil;
    @PostConstruct
    public void init() {
        System.out.println("wshwshwsh-init");
        tqCityAqiUtil = this;
        tqCityAqiUtil.tqCityAqiService = this.tqCityAqiService;
        tqCityAqiUtil.tqCityService = this.tqCityService;
        tqCityAqiUtil.tqAqiStationService = this.tqAqiStationService;
        tqCityAqiUtil.tqCityForecastService = this.tqCityForecastService;
    }

    public List<TqCity> getTqCitys(TqCity city) {
        if(null==tqCitys||tqCitys.size()==0){
            tqCityAqiUtil.tqCitys=  tqCityService.selectTqCityList(null==city?new TqCity():city);
            System.out.println("wshwshwsh-selectTqCityList");
            return tqCitys;
        }else{
            System.out.println("wshwshwsh-直接取值");
            return tqCitys;
        }

    }
    public List<TqCity> getTqLNCitys(TqCity city) {
        if(null==tqLNCitys||tqLNCitys.size()==0){
            tqCityAqiUtil.tqLNCitys=  tqCityService.selectTqCityList(city);
            System.out.println("wshwshwsh-getTqLNCitys");
            return tqLNCitys;
        }else{
            System.out.println("wshwshwsh-直接取值");
            return tqLNCitys;
        }

    }
    public ITqCityForecastService getTqCityForecastService() {
        return tqCityForecastService;
    }

    public void setTqCityForecastService(ITqCityForecastService tqCityForecastService) {
        this.tqCityForecastService = tqCityForecastService;
    }

    public ITqAqiStationService getTqAqiStationService() {
        return tqAqiStationService;
    }

    public ITqCityService getTqCityService() {
        return tqCityService;
    }

    public ITqCityAqiService getTqCityAqiService() {
        return tqCityAqiService;
    }
}
