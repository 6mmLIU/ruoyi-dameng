<template>
  <div class="center_bottom">
    <Echart
      :options="options"
      id="bottomLeftChart"
      class="echarts_bottom"
    ></Echart>
  </div>
</template>

<script>
import { currentGET } from "api";
import { graphic } from "echarts";
import {httpAction, postAction, getAction} from '@/utils/manage'
import { TRUE } from "sass";
export default {
  data() {
    return {
      options: {},
    };
  },
  props: {},
  mounted() {
    this.getProvinceAQIList();
  },
  methods: {
    getProvinceAQIList(){
      var params = {
          "type": "aqi",
          "px": "Asc"
      };
      postAction("/Aqi/getProvinceAQIList", params).then((res) => {
        console.log(res);
        if(res.code == '-1'){
            this.$Message({
              text: res.msg,
              type: 'warning'
            })
            return;
        }
        var obj = {};
        var label = [];
        var data = [];
        var pm25 = [];
        var pm10 = [];
        var co = [];
        var no2 = [];
        var o3 = [];
        var so2 = []
        for(var i = 0;i<res.data.length;i++){
          label.push(res.data[i].provinceName);
          data.push(parseFloat(res.data[i].aqi));
          pm25.push(parseFloat(res.data[i].pm2_5));
          pm10.push(parseFloat(res.data[i].pm10));
          co.push(parseFloat(res.data[i].co));
          no2.push(parseFloat(res.data[i].no2));
          o3.push(parseFloat(res.data[i].o3));
          so2.push(parseFloat(res.data[i].so2));
        }
        this.init({
          category : label,
          barData : data,
          pm25: pm25,
          pm10: pm10,
          co : co,
          no2 : no2,
          o3 : o3,
          so2 : so2
        });
      })
    },
    getData() {
      this.pageflag = true;
      currentGET("big6", { companyName: this.companyName }).then((res) => {
        console.log("安装计划", res);
        if (res.success) {
          this.init(res.data);
        } else {
          this.pageflag = false;
          this.$Message({
            text: res.msg,
            type: "warning",
          });
        }
      });
    },
    init(newData) {
      this.options = {
        tooltip: {
          trigger: "axis",
          backgroundColor: "rgba(0,0,0,.6)",
          borderColor: "rgba(147, 235, 248, .8)",
          textStyle: {
            color: "#FFF",
          },
          formatter: function (params) {
            // 添加单位
            var result = params[0].name + "<br>";
            params.forEach(function (item) {
              if (item.value) {
                if (item.seriesName == "安装率") {
                  result +=
                    item.marker +
                    " " +
                    item.seriesName +
                    " : " +
                    item.value +
                    "%</br>";
                } else {
                  result +=
                    item.marker +
                    " " +
                    item.seriesName +
                    " : " +
                    item.value +
                    "</br>";
                }
              } else {
                result += item.marker + " " + item.seriesName + " :  - </br>";
              }
            });
            return result;
          },
        },
        legend: {
		  data: ["AQI","PM10","PM2.5", "O3","NO2", "SO2", "CO"],
          textStyle: {
            color: "#dedede",
          },
          top: "0",
        },
        grid: {
          left: "50px",
          right: "40px",
          bottom: "80px",
          top: "20px",
        },
        xAxis: {
          data: newData.category,
          axisLine: {
            lineStyle: {
              color: "#B4B4B4",
            },
          },
          axisLabel: {
            rotate: 45,
            interval: 0 ,// 设置标签间隔为 0，表示显示所有标签
			  color: "#7EB7FD",
          },
          axisTick: {
            show: false,
          },
        },
        yAxis: [
          {
            splitLine: { show: false },
            axisLine: {
              lineStyle: {
                color: "#B4B4B4",
              },
            },

            axisLabel: {
              formatter: "{value}",
			      color: "#7EB7FD",
            },
          },
          {
            splitLine: { show: false },
            axisLine: {
              lineStyle: {
                color: "#B4B4B4",
              },
            },
            axisLabel: {
              formatter: "{value}",
			    
            },
          },
        ],
        series: [
          // {
          //   name: "AQI",
          //   type: "bar",
          //   barWidth: 10,
          //   itemStyle: {
          //     borderRadius: 5,
          //     color: new graphic.LinearGradient(0, 0, 0, 1, [
          //       { offset: 0, color: "#956FD4" },
          //       { offset: 1, color: "#3EACE5" },
          //     ]),
          //   },
          //   data: newData.barData,
          // },
		  {
		    name: "AQI",
		    type: "bar",
		    showAllSymbol: true,
		    symbol: "emptyCircle",
		    symbolSize: 8,
		    // yAxisIndex: 1,
		    itemStyle: {
		        borderRadius: 5,
		        color: new graphic.LinearGradient(0, 0, 0, 1, [
		          { offset: 0, color: "#956FD4" },
		          { offset: 1, color: "#3EACE5" },
		        ]),
		    },
		    data: newData.barData,
		  },
		  {
		    name: "PM10",
		    type: "line",
		    smooth: true,
		    showAllSymbol: true,
		    symbol: "emptyCircle",
		    symbolSize: 8,
		    // yAxisIndex: 1,
		    itemStyle: {
		      color: "#00fdfa",
		    },
		    data: newData.pm10,
		  },
          {
            name: "PM2.5",
            type: "line",
            smooth: true,
            showAllSymbol: true,
            symbol: "emptyCircle",
            symbolSize: 8,
            // yAxisIndex: 1,
            itemStyle: {
              color: "#F02FC2",
            },
            data: newData.pm25,
          },
		  {
		    name: "O3",
		    type: "line",
		    smooth: true,
		    showAllSymbol: true,
		    symbol: "emptyCircle",
		    symbolSize: 8,
		    // yAxisIndex: 1,
		    itemStyle: {
		      color: "#9933cc",
		    },
		    data: newData.o3,
		  },
		  {
            name: "NO2",
            type: "line",
            smooth: true,
            showAllSymbol: true,
            symbol: "emptyCircle",
            symbolSize: 8,
            // yAxisIndex: 1,
            itemStyle: {
              color: "#e3b337",
            },
            data: newData.no2,
          },
          {
            name: "SO2",
            type: "line",
            smooth: true,
            showAllSymbol: true,
            symbol: "emptyCircle",
            symbolSize: 8,
            // yAxisIndex: 1,
            itemStyle: {
              color: "#ff9900",
            },
            data: newData.so2,
          },
          {
            name: "CO",
            type: "line",
            smooth: true,
            showAllSymbol: true,
            symbol: "emptyCircle",
            symbolSize: 8,
            // yAxisIndex: 1,
            itemStyle: {
              color: "#07f7a8",
            },
            data: newData.co,
          }
          
          
        ],
      };
    },
  },
};
</script>
<style lang="scss" scoped>
.center_bottom {
  width: 100%;
  height: 100%;

  .echarts_bottom {
    width: 100%;
    height: 100%;
  }
}
</style>
