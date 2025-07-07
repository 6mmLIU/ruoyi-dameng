<!--
 * @Author: daidai
 * @Date: 2022-03-01 15:27:58
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-05-07 11:24:14
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\right-center.vue
-->
<template>
  <div style="display: flex;width: 100%;height: 100%;">
  <div style="flex:1">
      <div ref="chart" :style="{width: '100%', height: '100%'}"></div>
    </div>
    <div style="flex:1">
      <div ref="chart1" :style="{width: '100%', height: '90%'}"></div>
    </div>
  </div>

</template>

<script>
import { currentGET } from 'api/modules'
import {httpAction, postAction, getAction} from '@/utils/manage'
import * as echarts from 'echarts';
import 'echarts-liquidfill'
import 'echarts-wordcloud'

export default {
  name: "VueWordCloud",
  data() {
    return {
      worddata: [
        {
          name: "细颗粒物PM2.5",
          value: 100,
        },
        {
          name: "可吸入颗粒物PM10",
          value: 100,
        },
        {
          name: "一氧化碳CO",
          value: 100,
        },
        {
          name: "二氧化硫SO2",
          value: 100,
        },
        {
          name: "二氧化氮NO2",
          value: 100,
        },
        {
          name: "臭氧O3",
          value: 100,
        }
      ],
    };
  },
  mounted() {
    this.initEcharts();
    this.getDataByCenter();
  },
  methods: {
    getDataByCenter(){
      var params = {};
      getAction("/Aqi/queryAQILevelNum", params).then((res) => {
					console.log(res);
          if(res.code == '-1'){
            this.$Message({
              text: res.msg,
              type: 'warning'
            })
            return;
          }
          var data = res.data;
          var sum = 0;
          var obj = {};
          for(var i = 0; i < data.length; i++){
            sum += parseInt(data[i].num);
            if(data[i].quality == "优"){
              obj.num1 = parseFloat(data[i].percentage);
            }else if(data[i].quality == "良"){
              obj.num2 = parseFloat(data[i].percentage);
            }else if(data[i].quality == "轻度污染"){
              obj.num3 = parseFloat(data[i].percentage);
            }else if(data[i].quality == "中度污染"){
              obj.num4 = parseFloat(data[i].percentage);
            }else if(data[i].quality == "严重污染"){
              obj.num5 = parseFloat(data[i].percentage);
            }else if(data[i].quality == "重度污染"){
              obj.num6 = parseFloat(data[i].percentage);
            }
          }
          obj.sum = sum;
          this.countUserNumData = obj;
          this.avg = obj.num1 + obj.num2;
          this.initChart(this.avg, this.avg / 100);
			})
    },
    initChart(percentage, data) {
      const chart = echarts.init(this.$refs.chart1)
      const option = {
        title: {
          text: "城市AQI优良率" + percentage + "%",
          left: "center",
          bottom: 0,
          textStyle: {
            color: "#fff",
            fontWeight: "400",
            fontSize: 18,
          },
        },

        series: [
          {
            // name: "睡了",
            type: "liquidFill",
            radius: "140px",
            data: [data],
            label: {
              normal: {
                // color: "rgba(0,0,0,0)",
                // insideColor: "rgba(0,0,0,0)",
                textStyle: {
                  fontSize: 20,
                  fontWeight: "bold",
                },
              },
            },
            color: [
              {
                type: "linear",
                x: 0,
                y: 1,
                x2: 0,
                y2: 0,
                colorStops: [
                  {
                    offset: 1,
                    color: ["#328CDA"], // 0% 处的颜色
                  },
                  {
                    offset: 0,
                    color: ["#9DC9FF"], // 100% 处的颜色
                  },
                ],
                global: false, // 缺省为 false
              },
            ],
 
            outline: {
              show: true,
              borderDistance: 5,
              itemStyle: {
                borderColor: "#54B3FC",
                borderWidth: 3,
              },
            },
          }
        ]
      }
      chart.setOption(option)
    },
    initEcharts(data) {
      const chart = echarts.init(this.$refs.chart)
      const color = [
        // "#fff",
        // "#FFD200",
        // "#00EAFF",
        // "#fff",
        // "#FFD200",
        // "#00EAFF",
        // "#fff",
        // "#FFD200",
        // "#00EAFF",
        // "#fff",
        // "#FFD200",
        // "#00EAFF",
        // "#fff",
        // "#FFD200",
        // "#00EAFF",
		'#7DEFFC', '#2D8CF0', '#D1AF07', '#E27914', '#D3282C', '#B02690'
					  
      ];
      let option = {
        title: {
          text: "",
          x: "center",
        },
   //      series: [
   //        {
   //          type: "wordCloud",
			// shape: 'circle',
   //          //用来调整词之间的距离
   //          gridSize: 15,
   //          //用来调整字的大小范围
   //          sizeRange: [12, 20],
   //          // rotationRange: [0, 0],
			// rotationRange: [-90, 90],
			// 	rotationStep: 25,
   //          //随机生成字体颜色
   //          textStyle: {
   //            color: (v) => `${color[v.dataIndex]}`,
   //          },
   //          //位置相关设置
   //          left: "center",
   //          top: "center",
   //          right: null,
   //          bottom: null,
   //          width: "100%",
   //          height: "100%",
   //          //数据
   //          data: this.worddata,
   //        },
   //      ],
   series: [{
     type: 'wordCloud',
     /*要绘制的“云”的形状。可以是为回调函数，或一个关键字。
     可用的形状有(circle)圆形(默认)、(cardioid)心形，(diamond)菱形，(triangle-forward)三角形向前，(triangle)三角形，(pentagon)五边形和(star)星形。*/
     shape: 'circle',
     //保持maskImage的宽高比或1:1的形状，他的选项是支持从echarts-wordcloud@2.1.0
     keepAspect: false,
     //一个轮廓图像，其白色区域将被排除在绘制文本之外
     //意思就是可以通过图片，来自定义词云的形状
     // maskImage: maskImage,
   
     //设置显示区域的位置以及大小
     left: 'center',
     top: 'center',
     right: null,
     bottom: null,
     width: '90%',
     height: '90%',
     prefer_horizontal:1,
     //数据中的值将映射到的文本大小范围。默认大小为最小12px，最大60px。
     sizeRange: [12, 20],
     //文本旋转范围和步进度。文本将通过rotationStep:45在[- 90,90]范围内随机旋转
     rotationRange: [-60, 60],
     rotationStep: 45,
     //以像素为单位的网格大小，用于标记画布的可用性
     //网格尺寸越大，单词之间的间距越大。
     gridSize: 10,
     //设置为true，允许文字部分在画布外绘制。
     //允许绘制大于画布大小的单词
     //从echarts-wordcloud@2.1.0开始支持此选项
     drawOutOfBound: false,
     //如果字体太大而无法显示文本，
     //是否收缩文本。如果将其设置为false，则文本将不渲染。如果设置为true，则文本将被缩小。
     //从echarts-wordcloud@2.1.0开始支持此选项
     shrinkToFit: false,
     // 执行布局动画。当有大量的单词时，关闭它会导致UI阻塞。
     layoutAnimation: true,
     //全局文本样式
     textStyle: {
       fontFamily: 'sans-serif',
       fontWeight: 'bold',
       // Color可以是一个回调函数或一个颜色字符串
       color: function () {
         // Random color
         return 'rgb(' + [
           Math.round(Math.random() * (255-100) + 100),
           Math.round(Math.random() * (255-100) + 100),
           Math.round(Math.random() * (255-100) + 100)
         ].join(',') + ')';
       }
     },
     emphasis: {
       focus: 'self',
       textStyle: {
         textShadowBlur: 10,
         textShadowColor: '#333'
       }
     },
     //数据是一个数组。每个数组项必须具有名称和值属性。
     data: [
       {name: '细颗粒物PM2.5',value: Math.round(Math.random() * (100-60) + 60)},
       {name: '可吸入颗粒物PM10',value: Math.round(Math.random() * (100-60) + 60)},
       {name: '一氧化碳CO',value: Math.round(Math.random() * (100-60) + 60)},
       {name: '二氧化硫SO2',value: Math.round(Math.random() * (100-60) + 60)},
       {name: '二氧化氮NO2',value: Math.round(Math.random() * (100-60) + 60)},
       {name: '臭氧O3',value: Math.round(Math.random() * (100-60) + 60)},
       {name: 'AQI',value: Math.round(Math.random() * (100-60) + 60)},
       // {name: '双氧水',value: Math.round(Math.random() * (100-60) + 60)}
     ]
   }]
      };
      chart.setOption(option)
    },
  },
};
</script>
<style scoped>
#echartsWordcloud {
  width: 500px;
  height: 300px;
  background: #000;
}
</style>