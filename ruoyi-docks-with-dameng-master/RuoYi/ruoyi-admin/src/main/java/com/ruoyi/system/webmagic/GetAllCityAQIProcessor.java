package com.ruoyi.system.webmagic;
import com.ruoyi.system.domain.TqCity;
import com.ruoyi.system.util.UrlConstant;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;

public class GetAllCityAQIProcessor implements PageProcessor {
    public static final String INDEX="Index";
    private List<TqCity> tqCitys;

    public GetAllCityAQIProcessor(List<TqCity> tqCitys) {
        this.tqCitys=tqCitys;
    }

    /*页面分析
    *下载结果封装成Page对象，可以从page对象中获得下载的结果
    *
     */
    @Override
    public void process(Page page) {
        String response=page.getHtml().xpath("//body/text()").toString();
        page.putField("data",response);
        Request request = page.getRequest();
        int index=request.getExtra(INDEX);
        index=index+1;
        if(index==1)
        {
            for(;index<tqCitys.size();index++) {
                Request newRequest = new Request(UrlConstant.GetAQIDataPublishLiveInfo + tqCitys.get(index).getCityCode());
                newRequest.putExtra(INDEX, index);
                newRequest.setMethod(HttpConstant.Method.GET);
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
//        Spider.create(new GetAllCityAQIProcessor())
//                .addUrl(UrlConstant.GetAQIDataPublishLiveInfo+"110000")
//                .addPipeline(new AqiDetailPipeline())
//                .thread(8)
//                //run是同步方法，在当前线程中执行爬虫
//                //start是异步方法
//                .start();
    }
}
