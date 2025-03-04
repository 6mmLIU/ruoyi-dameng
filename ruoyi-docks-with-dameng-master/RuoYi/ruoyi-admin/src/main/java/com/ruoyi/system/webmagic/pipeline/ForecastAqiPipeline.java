package com.ruoyi.system.webmagic.pipeline;


import com.ruoyi.system.domain.TqCityForecast;
import com.ruoyi.system.service.ITqCityForecastService;
import com.ruoyi.system.util.TqCityAqiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

public class ForecastAqiPipeline implements Pipeline {
    private Logger LOGGER = LoggerFactory.getLogger(ForecastAqiPipeline.class);
    @Override
    public void process(ResultItems resultItems, Task task) {
        // 获取 DiseaseDetailProcessor 执行器中 page.putField("diseaseDetail",map) 存储的数据
        List<TqCityForecast> tqCityForecasts = resultItems.get("data");
        try {
            ITqCityForecastService tqCityForecastService = TqCityAqiUtil.tqCityAqiUtil.getTqCityForecastService();
            if (null != tqCityForecastService){
                if(null!=tqCityForecasts&&tqCityForecasts.size()>0)
                {
                   tqCityForecastService.deleteTqCityForecastByCityCode(tqCityForecasts.get(0).getCitycode());
                }
                for(int i=0;i<tqCityForecasts.size();i++) {
                    TqCityForecast tqCityForecast = tqCityForecasts.get(i);
                    int resultCode = tqCityForecastService.insertTqCityForecast(tqCityForecast);
                    if (resultCode > 0) {
                        LOGGER.debug(i + "/" + tqCityForecasts.size() + "操作成功: " + tqCityForecast.getCityname() + tqCityForecast.getForecastDate());
                    } else {
                        LOGGER.debug(i + "/" + tqCityForecasts.size() + "操作失败: " + tqCityForecast.getCityname()  + tqCityForecast.getForecastDate());
                    }
                }
        }
        } catch (Exception ex) {
            LOGGER.error("保存异常", ex);
        }
    }

}
