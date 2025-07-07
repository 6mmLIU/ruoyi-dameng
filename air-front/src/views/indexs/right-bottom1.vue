<!--
 * @Author: daidai
 * @Date: 2022-03-01 14:13:04
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-27 15:04:49
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\right-top.vue
-->
<template>
  <Echart
    :options="option"
    class="right_top_inner"
    v-if="pageflag"
    ref="charts"
  />
  <Reacquire v-else @onclick="getData" style="line-height: 200px">
    重新获取
  </Reacquire>
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
    };
  },
  created() {
   
  },

  mounted() {
     this.queryDateLast7ByCity();
  },
  beforeDestroy() {
    this.clearData();
  },
  methods: {
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
        var pm10 = [];
        var co = [];
        var no2 = [];
        var o3 = [];
        var so2 = [];
        for(var i = 0;i<res.data.length;i++){
          label.push(res.data[i].nowDay.split("-")[1] + "-" + res.data[i].nowDay.split("-")[2]);
          data.push(parseFloat(res.data[i].aqiAverage).toFixed(2));
          pm25.push(parseFloat(res.data[i].pm2_5Average).toFixed(2));
          pm10.push(parseFloat(res.data[i].pm10Average).toFixed(2));
		 o3.push(parseFloat(res.data[i].o3Average).toFixed(2));
        // no2.push(parseFloat(res.data[i].no2Average).toFixed(2));
        // so2.push(parseFloat(res.data[i].so2Average).toFixed(2));
		// co.push(parseFloat(res.data[i].coAverage).toFixed(2));
        }
        this.init(label, data, pm25,pm10,o3);
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
    init(xData, yData, yData2,yData3,yData4) {
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
            interval: 0,
				fontSize :18
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
				fontSize :18
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
		legend: {
		  show: true,
		  top: "90%",
		  left: "center",
		textStyle: {
		            color: '#fff'
		        }
		},
        grid: {
          //布局
          show: true,
          left: "10px",
          right: "30px",
          bottom: "30px",
          top: "10px",
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
          }, {
            data: yData3,
            type: "line",
            smooth: true,
            symbol: "none", //去除点
            name: "PM10",
            color: "rgba(76, 243, 15, 0.7)",
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
                   color: "rgba(76, 243, 15, 0.7)",
                    },
                    {
                      offset: 1,
                 color: "rgba(76, 243, 15, .0)",
                    },
                  ],
                  false
                ),
            },
          }, {
            data: yData4,
            type: "line",
            smooth: true,
            symbol: "none", //去除点
            name: "O3",
            color: "rgba(149, 24, 149, 0.7)",
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
                     color: "rgba(149, 24, 149, 0.7)",
                    },
                    {
                      offset: 1,
                     color: "rgba(149, 24, 149, .0)",
                    },
                  ],
                  false
                ),
            },
          }
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
</style>