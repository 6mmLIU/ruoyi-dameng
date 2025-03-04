package com.ruoyi.system.webmagic.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.ruoyi.system.domain.TqAqiStation;
import com.ruoyi.system.service.ITqAqiStationService;
import com.ruoyi.system.util.TqCityAqiUtil;
import com.ruoyi.system.webmagic.GetCityStationAQIProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.text.SimpleDateFormat;
import java.util.List;

public class StationAqiDetailPipeline implements Pipeline {
    private Logger LOGGER = LoggerFactory.getLogger(StationAqiDetailPipeline.class);
    @Override
    public void process(ResultItems resultItems, Task task) {
        // 获取 DiseaseDetailProcessor 执行器中 page.putField("diseaseDetail",map) 存储的数据
        String response = resultItems.get("data");
        List<TqAqiStation> tqAqiStations = JSON.parseObject(response, new TypeReference<List<TqAqiStation>>(){});
        try {
            ITqAqiStationService tqAqiStationService = TqCityAqiUtil.tqCityAqiUtil.getTqAqiStationService();
            if (null != tqAqiStationService){
                LOGGER.debug("监测点个数: " + tqAqiStations.size());
                for(int i=0;i<tqAqiStations.size();i++) {
                    TqAqiStation tqAqiStation = tqAqiStations.get(i);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = sdf.format(tqAqiStation.getTimepoint());
                    List<TqAqiStation> list = tqAqiStationService.selectTqStationList(tqAqiStation.getArea(),tqAqiStation.getPositionname(),dateString);
                    if (list.size() == 0) {
                        tqAqiStation.setCitycode(resultItems.get(GetCityStationAQIProcessor.CITY_CODE));
                        tqAqiStation.setProvinceid(resultItems.get(GetCityStationAQIProcessor.PROVINCE_CODE));
                        tqAqiStation.setProvincename(resultItems.get(GetCityStationAQIProcessor.PROVINCE_NAME));
                        int resultCode = tqAqiStationService.insertTqAqiStation(tqAqiStation);
                        if (resultCode > 0) {
                            LOGGER.debug(i+"/"+tqAqiStations.size()+"操作成功: " + tqAqiStation.getArea()+tqAqiStation.getPositionname());
                        } else {
                            LOGGER.debug(i+"/"+tqAqiStations.size()+"操作失败: " + tqAqiStation.getArea()+tqAqiStation.getPositionname());
                        }
                    } else {
                        LOGGER.debug(i+"/"+tqAqiStations.size()+"数据库中已经存在: " + tqAqiStation.getArea()+tqAqiStation.getPositionname());
                    }
                }
        }
        } catch (Exception ex) {
            LOGGER.error("保存异常", ex);
        }
    }

}
