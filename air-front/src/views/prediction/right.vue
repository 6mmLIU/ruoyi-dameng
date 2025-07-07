<!--
 * @Author: daidai
 * @Date: 2022-03-01 14:13:04
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-27 15:04:49
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\right-top.vue
-->
<template>
  <div>
    <div style="display: flex;align-items: center;justify-content: space-around;">
			<!-- '#0c7c10', '#8bc65a', '#ffff7f', '#cd830b', '#ff440b', '#82020f' rgba(50, 140, 218)-->
      <div style="flex:1.5;background: #328CDA;padding: 10px;"><img src="../../assets/img/hospital stay.png" style=" margin-left:10px;vertical-align: middle;" />健康提示</div>
      <div @click="changeTab('1')" :style="actived == '1'?{backgroundColor:'#0c7c10'}:{}" class="tab">一级</div>
      <div @click="changeTab('2')" :style="actived == '2'?{backgroundColor:'#8bc65a'}:{}" class="tab">二级</div>
      <div @click="changeTab('3')" :style="actived == '3'?{backgroundColor:'#c3c361'}:{}" class="tab">三级</div>
      <div @click="changeTab('4')" :style="actived == '4'?{backgroundColor:'#cd830b'}:{}" class="tab">四级</div>
      <div @click="changeTab('5')" :style="actived == '5'?{backgroundColor:'#ff440b'}:{}" class="tab">五级</div>
      <div @click="changeTab('6')" :style="actived == '6'?{backgroundColor:'#82020f'}:{}" class="tab">六级</div>
    </div>
    <div class="content" v-if="actived == '1'">
空气质量指数为<span style="font-size:25px ;">0－50</span>，空气质量级别为一级，空气质量状况属于优。此时，空气质量令人满意，基本无空气污染，各类人群可正常活动。
    </div>
    <div class="content" v-if="actived == '2'">
		空气质量指数为<span style="font-size:25px ;">51－100</span>，空气质量级别为二级，空气质量状况属于良。此时空气质量可接受，但某些污染物可能对极少数异常敏感人群健康有较弱影响，建议极少数异常敏感人群应减少户外活动。
	</div>
    <div class="content" v-if="actived == '3'">
		空气质量指数为<span style="font-size:25px ;">101－150</span>，空气质量级别为三级，空气质量状况属于轻度污染。此时，易感人群症状有轻度加剧，健康人群出现刺激症状。建议儿童、老年人及心脏病、呼吸系统疾病患者应减少长时间、高强度的户外锻炼。
	</div>
    <div class="content" v-if="actived == '4'">
		空气质量指数为<span style="font-size:25px ;">151－200</span>，空气质量级别为四级，空气质量状况属于中度污染。此时，进一步加剧易感人群症状，可能对健康人群心脏、呼吸系统有影响，建议疾病患者避免长时间、高强度的户外锻练，一般人群适量减少户外运动。
	</div>
    <div class="content" v-if="actived == '5'">
		空气质量指数为<span style="font-size:25px ;">201－300</span>，空气质量级别为五级，空气质量状况属于重度污染。此时，心脏病和肺病患者症状显著加剧，运动耐受力降低，健康人群普遍出现症状，建议儿童、老年人和心脏病、肺病患者应停留在室内，停止户外运动，一般人群减少户外运动。
	</div>
    <div class="content" v-if="actived == '6'">
		空气质量指数大于300，空气质量级别为六级，空气质量状况属于严重污染。此时，健康人群运动耐受力降低，有明显强烈症状，提前出现某些疾病，建议儿童、老年人和病人应当留在室内，避免体力消耗，一般人群应避免户外活动。
	</div>
  </div>
</template>

<script>
import {httpAction, postAction, getAction} from '@/utils/manage'
import { currentGET } from "api/modules";
import {graphic} from "echarts"
export default {
  data() {
    return {
      option: {},
      pageflag: false,
      timer: null,
      actived: '1' 
    };
  },
  created() {
   
  },

  mounted() {
     //this.queryDateLast7ByCity();
  },
  beforeDestroy() {
    this.clearData();
  },
  methods: {
    changeTab(action) {
      this.actived = action;
    },
    queryDateLast7ByCity(areacode){
      this.pageflag = true;
      if(areacode == "china"){
        var params = {};
      }else{
        var params = {
          id :areacode
        };
      }
      getAction("/Aqi/queryDateLast7ByCity", params).then((res) => {
        console.log(res);
        if(res.code == '-1'){
            this.$Message({
              text: res.msg,
              type: 'warning'
            })
            return;
        }
        var label = [];
        var data = [];
        var pm25 = [];
        // var pm10 = [];
        // var co = [];
        // var no2 = [];
        // var o3 = [];
        // var so2 = [];
        for(var i = 0;i<res.data.length;i++){
          label.push(res.data[i].nowDay.split("-")[1] + "-" + res.data[i].nowDay.split("-")[2]);
          data.push(parseFloat(res.data[i].aqiAverage).toFixed(2));
          pm25.push(parseFloat(res.data[i].pm2_5Average).toFixed(2));
          // pm10.push(parseFloat(res.data[i].pm10));
          // co.push(parseFloat(res.data[i].co));
          // no2.push(parseFloat(res.data[i].no2));
          // o3.push(parseFloat(res.data[i].o3));
          // so2.push(parseFloat(res.data[i].cso2o));
        }
        this.init(label, data, pm25);
      })
    },
    clearData() {
      if (this.timer) {
        clearInterval(this.timer);
        this.timer = null;
      }
    },
    getData() {
      this.pageflag = true;
      // this.pageflag =false
      currentGET("big4").then((res) => {
        if (!this.timer) {
          console.log("报警次数", res);
        }
        if (res.success) {
          this.countUserNumData = res.data;
          this.$nextTick(() => {
            this.init(res.data.dateList, res.data.numList, res.data.numList2),
              this.switper();
          });
        } else {
          this.pageflag = false;
          this.$Message({
            text: res.msg,
            type: "warning",
          });
        }
      });
    },
    //轮询
    switper() {
      if (this.timer) {
        return;
      }
      let looper = (a) => {
        this.getData();
      };
      this.timer = setInterval(
        looper,
        this.$store.state.setting.echartsAutoTime
      );
      let myChart = this.$refs.charts.chart;
      myChart.on("mouseover", (params) => {
        this.clearData();
      });
      myChart.on("mouseout", (params) => {
        this.timer = setInterval(
          looper,
          this.$store.state.setting.echartsAutoTime
        );
      });
    },
    init(xData, yData, yData2) {
      this.option = {
        xAxis: {
          type: "category",
          data: xData,
          boundaryGap: false, // 不留白，从原点开始
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
            interval: 0
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
          },
        },
        tooltip: {
          trigger: "axis",
          backgroundColor: "rgba(0,0,0,.6)",
          borderColor: "rgba(147, 235, 248, .8)",
          textStyle: {
            color: "#FFF",
          },
        },
        grid: {
          //布局
          show: true,
          left: "10px",
          right: "30px",
          bottom: "10px",
          top: "28px",
          containLabel: true,
          borderColor: "#1F63A3",
        },
        series: [
          {
            data: yData,
            type: "line",
            smooth: true,
            symbol: "none", //去除点
            name: "AQI",
            color: "rgba(252,144,16,.7)",
            areaStyle: {
                //右，下，左，上
                color: new graphic.LinearGradient(
                  0,
                  0,
                  0,
                  1,
                  [
                    {
                      offset: 0,
                      color: "rgba(252,144,16,.7)",
                    },
                    {
                      offset: 1,
                      color: "rgba(252,144,16,.0)",
                    },
                  ],
                  false
                ),
            },
          },
          {
            data: yData2,
            type: "line",
            smooth: true,
            symbol: "none", //去除点
            name: "PM2.5",
            color: "rgba(9,202,243,.7)",
            areaStyle: {
                //右，下，左，上
                color: new graphic.LinearGradient(
                  0,
                  0,
                  0,
                  1,
                  [
                    {
                      offset: 0,
                      color: "rgba(9,202,243,.7)",
                    },
                    {
                      offset: 1,
                      color: "rgba(9,202,243,.0)",
                    },
                  ],
                  false
                ),
            },
          },
        ],
      };
    },
  },
};
</script>
<style lang='scss' scoped>
.right_top_inner {
  margin-top: -8px;
}

.content {
  padding: 10px;
  text-indent: 2em;
  font-size: 23px;
  line-height: 30px;
}
.tab {
  flex:1;background-color: rgba(50, 140, 218, 0.3);text-align: center;padding: 18px;cursor: pointer;
}
</style>