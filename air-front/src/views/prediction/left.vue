<!--
 * @Author: daidai
 * @Date: 2022-03-01 14:13:04
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-27 15:04:49
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\right-top.vue
-->
<template>
  <Echart
    id="rightTop"
    :options="option"
    class="right_top_inner"
    v-if="pageflag"
 
  />
     <!-- ref="charts" -->
<!--  <Reacquire v-else @onclick="getData" style="line-height: 200px">
    重新获取
  </Reacquire> -->
</template>

<script>
import {httpAction, postAction, getAction} from '@/utils/manage'
import { currentGET } from "api/modules";
import {graphic} from "echarts"
export default {
	props: {
	   code: String,
	   name: String,
	 },
  data() {
    return {
      option: {},
      pageflag: false
      // timer: null,

	  
    };
  },
  created() {
    this.getData(this.code);
  },
  watch: {
		code(newValue, oldValue) {
		console.info("watch:code="+newValue);
		this.getData(newValue);
		},
  },
  mounted() {
 
  },
  beforeDestroy() {
    //this.clearData();
  },
  methods: {
	getData(code){
		var params = {
			"code": code
		};
		getAction("/Aqi/queryForecastAQIByCity", params).then((res) => {
			console.log("wshwshwshwshwshwshwsh" + res.data);
			if (res.code == '-1') {
				this.$Message({
					text: res.msg,
					type: 'warning'
				})
				return;
			}
			var data = res.data;
			var forecastDates=[];
			var aqiMins=[];
			var aqiCzs=[];
			for (var i = 0; i < res.data.length; i++) {
				forecastDates.push(res.data[i].forecastDate.substring(5, 10));
				var min=res.data[i].aqi.split("～")[0];
				var max=res.data[i].aqi.split("～")[1];
				var cz=max-min;
			    console.info("min="+min+"  max="+max+"   cz="+cz);
				
				aqiMins.push(min);
				aqiCzs.push(cz)
				// aqis.push(res.data[i].aqi);					
				}
				 this.init(forecastDates,aqiMins,aqiCzs);
			});
	},
    init(forecastDates,aqiMins,aqiCzs){
      this.pageflag = true;
       this.option = {
			tooltip: {
				   show:true,
                   trigger: 'axis', // 设置提示框触发方式为坐标轴
					backgroundColor: "rgba(0,0,0,.6)",
					borderColor: "rgba(147, 235, 248, .8)",
					textStyle: {
					  color: "#FFF",
					},
                     formatter: function (params) {
						  if (Array.isArray(params)){
						var max= parseInt(params[0].data)+parseInt(params[1].data);
      return params[0].name + '<br/>' +
                            'AQI: ' + params[0].data + '-' +
                            +max;	
									}else{
										return params.name + ': ' + params.data;
									}
                    }
                },
                xAxis: {
                      type: 'category',
                      data: forecastDates,
               // boundaryGap: false, // 不留白，从原点开始
               splitLine: {
                 show: true,
                 lineStyle: {
                   color: "rgba(31,99,163,.2)",
                 },
               },
               axisLine: {
                 // show:false,
                 lineStyle: {
                   color: "rgba(31,99,163,.1)",
                 },
               },
               axisLabel: {
                 color: "#7EB7FD",
                 fontWeight: "500",
                 interval: 0,
				fontSize :20
               }
             },
               yAxis: {
                 type: "value",
                 splitLine: {
                   show: true,
                   lineStyle: {
                     color: "rgba(31,99,163,.2)",
                   },
                 },
                 axisLine: {
                   lineStyle: {
                     color: "rgba(31,99,163,.1)",
                   },
                 },
                 axisLabel: {
                   color: "#7EB7FD",
                   fontWeight: "500",
				   fontSize :20
                 },
               },
			   grid: {
			     //布局
			     show: true,
			     left: "50px",
			     right: "30px",
			     bottom: "15px",
			     top: "20px",
			     containLabel: true,
			     borderColor: "#1F63A3",
			   },
                series: [
                      {
                          name: '最低空气质量指数',
                          // data: [95, 75, 50, 60, 70,55, 65], // 这里是您的空气质量数据，请替换为实际数据
                         data:aqiMins,
						  type: 'bar',
                          stack: '空气质量',
       					  itemStyle: { 
							  color: 'rgba(255, 0, 0, 0)',// 设置柱状图的颜色为红色
							  }
                      },
                      {
                          name: '与最高的差值',
                          data: aqiCzs, // 这里是您的空气质量数据，请替换为实际数据
                          type: 'bar',
                          stack: '空气质量',
       					  borderRadius: 0,
       					  color: new graphic.LinearGradient(0, 0, 0, 1, [
       					  // '#0c7c10', '#8bc65a',
							  { offset: 1, color: 'rgba(12, 124, 16, 1)' },
							      { offset: 0, color:'rgba(139, 198, 90, 1.0)' },
       					  ]),
                      }
                  ]
           };
      
    },
    clearData() {
      if (this.timer) {
        clearInterval(this.timer);
        this.timer = null;
      }
    }
  },
};
</script>
<style lang='scss' scoped>
.right_top_inner {
  margin-top: -0px;
}
</style>