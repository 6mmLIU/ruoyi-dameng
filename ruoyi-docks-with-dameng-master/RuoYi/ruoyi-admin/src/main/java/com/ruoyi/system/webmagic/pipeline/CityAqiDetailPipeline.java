package com.ruoyi.system.webmagic.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.ruoyi.system.domain.TqCityAqi;
import com.ruoyi.system.service.ITqCityAqiService;
import com.ruoyi.system.util.TqCityAqiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.text.SimpleDateFormat;
import java.util.List;

public class CityAqiDetailPipeline implements Pipeline {
    private Logger LOGGER = LoggerFactory.getLogger(CityAqiDetailPipeline.class);




    @Override
    public void process(ResultItems resultItems, Task task) {
        // 获取 DiseaseDetailProcessor 执行器中 page.putField("diseaseDetail",map) 存储的数据
        String response = resultItems.get("data");
        TqCityAqi cityAQIData = JSON.parseObject(response, new TypeReference<TqCityAqi>() {});
        try {
            ITqCityAqiService tqCityAqiService = TqCityAqiUtil.tqCityAqiUtil.getTqCityAqiService();
            if (null != tqCityAqiService){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(cityAQIData.getTimepoint());
                List<TqCityAqi> list=tqCityAqiService.selectTqCityList(cityAQIData.getCitycode(),dateString);
                if(list.size()==0) {
                    int resultCode = tqCityAqiService.insertTqCityAqi(cityAQIData);
                    if (resultCode > 0) {
                        LOGGER.debug("操作成功: "+cityAQIData.getArea());
                    } else {
                        LOGGER.debug("操作失败: "+cityAQIData.getArea());
                    }
                }else{
                    LOGGER.debug("数据库中已经存在: "+cityAQIData.getArea());
                }
        }
        } catch (Exception ex) {
            LOGGER.error("保存异常", ex);
        }
    }

}
