package com.ruoyi.system.task;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.TqCity;
import com.ruoyi.system.util.TqCityAqiUtil;
import com.ruoyi.system.util.UrlConstant;
import com.ruoyi.system.webmagic.GetAllCityAQIProcessor;
import com.ruoyi.system.webmagic.GetAllCityForecastProcessor;
import com.ruoyi.system.webmagic.GetCityStationAQIProcessor;
import com.ruoyi.system.webmagic.pipeline.CityAqiDetailPipeline;
import com.ruoyi.system.webmagic.pipeline.ForecastAqiPipeline;
import com.ruoyi.system.webmagic.pipeline.StationAqiDetailPipeline;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务调度测试
 *
 */
@Component("tqTask")
public class TqTask
{
    //获取空气质量预测数据
    public void getCityForecast()
    {
        List<TqCity> tqCitys=TqCityAqiUtil.tqCityAqiUtil.getTqCitys(null);
        System.out.println("getCityForecast-tqCitys 大小="+tqCitys.size());

        if(null!=tqCitys&&tqCitys.size()>0) {
            Map<String, Object> map = new HashMap();
            map.put(GetAllCityForecastProcessor.CITY_CODE, tqCitys.get(0).getCityCode());
            Request request = new Request(UrlConstant.GetCityForecast);
            request.putExtra(GetAllCityForecastProcessor.CITY_CODE, tqCitys.get(0).getCityCode());
            request.putExtra(GetAllCityForecastProcessor.CITY_NAME, tqCitys.get(0).getCityName());
            request.putExtra(GetAllCityForecastProcessor.INDEX, 0);

            request.setMethod(HttpConstant.Method.POST);
            request.setRequestBody(HttpRequestBody.form(map, "utf-8"));

            Spider.create(new GetAllCityForecastProcessor(tqCitys))
                    .addRequest(request)
                    .addPipeline(new ForecastAqiPipeline())
                    .thread(8)
                    //run是同步方法，在当前线程中执行爬虫
                    //start是异步方法
                    .start();
        }
    }
    //获取城市监测点的AQI数据
    public void getCityStations()
    {
        TqCity queryCity=new TqCity();
        queryCity.setProvinceName("辽宁");
        List<TqCity> tqCitys=TqCityAqiUtil.tqCityAqiUtil.getTqLNCitys(queryCity);

        System.out.println("getCityStations-tqCitys 大小="+tqCitys.size());

        Request request = new Request(UrlConstant.GetAQIDataPublishLive+ tqCitys.get(0).getCityName());
        request.putExtra(GetCityStationAQIProcessor.CITY_CODE, tqCitys.get(0).getCityCode());
        request.putExtra(GetCityStationAQIProcessor.CITY_NAME, tqCitys.get(0).getCityName());
        request.putExtra(GetCityStationAQIProcessor.PROVINCE_CODE, tqCitys.get(0).getProvinceId());
        request.putExtra(GetCityStationAQIProcessor.PROVINCE_NAME, tqCitys.get(0).getProvinceName());
        request.putExtra(GetCityStationAQIProcessor.INDEX, 0);
        request.setMethod(HttpConstant.Method.GET);

        Spider.create(new GetCityStationAQIProcessor(tqCitys))
                .addRequest(request)
                .addPipeline(new StationAqiDetailPipeline())
                .thread(8)
                .start();
    }
    //获取各个城市的空气质量数据
    public void getCityAQI()
    {

        List<TqCity> tqCitys=TqCityAqiUtil.tqCityAqiUtil.getTqCitys(null);
        System.out.println("getCityAQI-tqCitys 大小="+tqCitys.size());

        Request request = new Request(UrlConstant.GetAQIDataPublishLiveInfo+ tqCitys.get(0).getCityCode());
        request.putExtra(GetAllCityAQIProcessor.INDEX, 0);
        request.setMethod(HttpConstant.Method.GET);

        Spider.create(new GetAllCityAQIProcessor(tqCitys))
                .addRequest(request)
                .addPipeline(new CityAqiDetailPipeline())
                .thread(8)
                //run是同步方法，在当前线程中执行爬虫
                //start是异步方法
                .start();

    }
}
