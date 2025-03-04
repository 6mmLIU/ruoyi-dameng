package com.ruoyi.system.webmagic;
import com.ruoyi.system.domain.TqCity;
import com.ruoyi.system.domain.TqCityForecast;
import com.ruoyi.system.util.UrlConstant;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.text.SimpleDateFormat;
import java.util.*;

public class GetAllCityForecastProcessor implements PageProcessor {
    private Logger LOGGER = LoggerFactory.getLogger(GetAllCityForecastProcessor.class);
    public static final String CITY_CODE="CityCode";
    public static final String CITY_NAME="CityName";
    public static final String INDEX="Index";
    private List<TqCity> tqCitys;

    public GetAllCityForecastProcessor(List<TqCity> tqCitys) {
        this.tqCitys=tqCitys;
    }

    private String parseArray(List<String> arrs)
    {
        StringBuffer aqiStringBuffer=new StringBuffer();
        if(null!=arrs) {
            for (int j = 0; j < arrs.size(); j++) {
                if (j == 0) {
                    aqiStringBuffer.append(arrs.get(0));
                }else {
                    aqiStringBuffer.append("～").append(arrs.get(j));
                }
            }
        }
        return aqiStringBuffer.toString();
    }
    private String parseText(String html)
    {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("span");
        StringBuffer stringBuffer=new StringBuffer();
        for (Element element : elements) {
            stringBuffer.append(element.text());
        }
        return stringBuffer.toString();
    }
    private Date parseDate(String dateStr)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (Exception e) {
            return null;
        }
    }
    /*页面分析
    *下载结果封装成Page对象，可以从page对象中获得下载的结果
    *
     */
    @Override
    public void process(Page page) {
        Request request = page.getRequest();
        List<TqCityForecast> cityForecastInfos=new ArrayList<>();
        for(int i=1;i<=7;i++)
        {
            TqCityForecast info=new TqCityForecast();
            String date=page.getHtml().xpath("//*[@id=\"yubaoTab\"]/div[1]/div[2]/div["+i+"]/div[1]/p/text()").toString();
            info.setForecastDate(parseDate(date));
            String day=page.getHtml().xpath("//*[@id=\"yubaoTab\"]/div[1]/div[2]/div["+i+"]/div[1]/span/text()").toString();
            if(null!=day)
            {
                info.setDay(day.replace("（", "").replace("）", ""));
            }
            List<String> aqis= page.getHtml().xpath("//*[@id=\"yubaoTab\"]/div[1]/div[2]/div["+i+"]/div[2]/dl/dd/div/p[1]/span/text()").all();
            info.setAqi(parseArray(aqis));
            info.setQuality(page.getHtml().xpath("//*[@id=\"yubaoTab\"]/div[1]/div[2]/div["+i+"]/div[2]/dl/dd/div/p[2]/text()").toString());
            String pollutantHtml = page.getHtml().xpath("//*[@id=\"yubaoTab\"]/div[1]/div[2]/div["+i+"]/div[2]/dl/dd/div/p[3]//span[2]").toString();
            info.setPrimarypollutant(parseText(pollutantHtml));
            info.setCitycode(request.getExtra(CITY_CODE));
            info.setCityname(request.getExtra(CITY_NAME));
            info.setTimepoint(new Date());
           // LOGGER.debug(info.toString());
            cityForecastInfos.add(info);
        }
        page.putField("data",cityForecastInfos);
        int index=request.getExtra(INDEX);
        index=index+1;
        if(index==1)
        {
            for(;index<tqCitys.size();index++) {
                Map<String, Object> map = new HashMap();
                map.put(CITY_CODE, tqCitys.get(index).getCityCode());
                Request newRequest = new Request(UrlConstant.GetCityForecast);
                newRequest.putExtra(CITY_CODE, tqCitys.get(index).getCityCode());
                newRequest.putExtra(CITY_NAME, tqCitys.get(index).getCityName());
                newRequest.putExtra(INDEX, index);
                newRequest.setMethod(HttpConstant.Method.POST);
                newRequest.setRequestBody(HttpRequestBody.form(map, "utf-8"));
                //将下一页链接添加到爬虫队列中
                page.addTargetRequest(newRequest);
            }
        }
    }
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /*
    *返回一个Site对象
    * Site就是站点的配置（可以设置抓取的频率，重试的次数，超时时间等）
    * 返回默认配置使用Site.me()创建一个Site对象
     */
    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
////        Spider.create(new GetAllCityAQIProcessor())
////                .addUrl(UrlConstant.GetAQIDataPublishLiveInfo+"110000")
////                .addPipeline(new AqiDetailPipeline())
////                .thread(8)
////                //run是同步方法，在当前线程中执行爬虫
////                //start是异步方法
////                .start();
//        Spider.create(weatherForecastCrawler)
//                .addUrl("https://air.cnemc.cn:18014/CityForecast")
//                .addPostParameter("CityCode", "110000")
//                .setThread(1) // 设置线程数
//                .run();
    }
}
