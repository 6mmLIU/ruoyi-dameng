<!--
 * @Author: daidai
 * @Date: 2022-03-01 11:17:39
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-29 15:50:18
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\center-map.vue
-->
<template>

  <div class="centermap">
    <div class="maptitle">
      <div class="zuo"></div>
      <span class="titletext">{{ maptitle }}</span>
      <div class="you"></div>
    </div>
    <div class="mapwrap scale-up">
      <dv-border-box-1>
        <div class="quanguo" @click="getData('china')" v-if="code !== 'china'">
          中国
        </div>

        <Echart id="CenterMap" :options="options" ref="CenterMap" />
      </dv-border-box-1>
    </div>
  </div>

</template>

<script>
import xzqCode from "../../utils/map/xzqCode";
import { currentGET } from "api/modules";
import {httpAction, postAction} from '@/utils/manage'
import * as echarts from "echarts";
import { GETNOBASE } from "api";
import { mapState, mapMutations } from 'vuex';
export default {
  data() {
    return {
      maptitle: "空气质量地图",
      options: {},
      config: {
        data:[66]
      },
      code: "china", //china 代表中国 其他地市是行政编码
      echartBindClick: false,
      isSouthChinaSea: false, //是否要展示南海群岛  修改此值请刷新页面
    };
  },
  created() {
	    this.getData("china");
  },

  mounted() {
  
	// let timeline = gsap.timeline()
	
	// timeline.fromTo(
	//   ['#dongxiao'],
	//   // 0% 
	//   {
	//     duration: 1,
	//     scale: 0.7,
	//     y: 50
	
	//   },
	//   // 100%
	//   {
	//     duration: 1,
	//     scale: 1,
	//     y:0
	//   })
  },
  methods: {
    ...mapMutations(['setAreaCode']),
    getData(code){
      if(code == "china"){
        var params = {
            "type": "aqi",
            "px": "Desc"
        }
        postAction("/Aqi/getProvinceAQIList", params).then((res) => {
          this.getGeojson("china", res.data);
          this.mapclick();
				})
        
      }else{
        var params = {
            "type": "aqi",
            "px": "Desc",
            "code": code
        }
        postAction("/Aqi/getCityAQIListByProvince", params).then((res) => {
          this.getGeojson(code, res.data.list);
				})
      }
      // 传给其他模块，进行数据变化
      this.setAreaCode(code);
    },
    // getData(code) {
    //   currentGET("big8", { regionCode: code }).then((res) => {
    //     console.log("设备分布", res);
    //     if (res.success) {
    //       this.getGeojson(res.data.regionCode, res.data.dataList);
    //       this.mapclick();
    //     } else {
    //       this.$Message.warning(res.msg);
    //     }
    //   });
    // },
    /**
     * @description: 获取geojson
     * @param {*} name china 表示中国 其他省份行政区编码
     * @param {*} mydata 接口返回列表数据
     * @return {*}
     */
    async getGeojson(name, mydata) {
      this.code = name;
      //如果要展示南海群岛并且展示的是中国的话
      let geoname=name
      if (this.isSouthChinaSea && name == "china") {
        geoname = "chinaNanhai";
      }
      //如果有注册地图的话就不用再注册 了
      let mapjson = echarts.getMap(name);
      if (mapjson) {
        mapjson = mapjson.geoJSON;
      } else {
        mapjson = await GETNOBASE(`./map-geojson/${geoname}.json`).then((res) => {
          return res;
        });
        echarts.registerMap(name, mapjson);
      }
      let cityCenter = {};
      let arr = mapjson.features;
      //根据geojson获取省份中心点
      arr.map((item) => {
        cityCenter[item.properties.name] =
          item.properties.centroid || item.properties.center;
      });
      let newData = [];
	  console.log(mydata);
      mydata.map((item) => {
        var label = item.provinceName? item.provinceName: item.area;
        if (cityCenter[label]) {
          newData.push({
            name: label,
            value: cityCenter[label].concat(item.aqi),
            adcode: item.citycode
          });
        }
        item.value = parseFloat(item.aqi);
        item.name = item.provinceName? item.provinceName: item.area;
		// if(item.provinceName.indexOf("福建") >= 0){
		// 	console.log(item);
		// }
      });
	  console.log(mydata);
      this.init(name, mydata, newData);
    },
    init(name, data, data2) {
      let top = 65;
      let zoom = 1.2;
      let option = {
        backgroundColor: "rgba(0,0,0,0)",
        tooltip: {
          show: false,
        },
        legend: {
          show: false,
        },
        visualMap: {
          left: 20,
          bottom: 20,
          pieces: [
            // { gte: 1000, label: "1000 mg/m³以上" }, // 不指定 max，表示 max 为无限大（Infinity）。
            // { gte: 600, lte: 999, label: "600-999 mg/m³" },
            // { gte: 200, lte: 599, label: "200-599 mg/m³" },
            // { gte: 50, lte: 199, label: "49-199 mg/m³" },
            // { gte: 10, lte: 49, label: "10-49 mg/m³" },
            // { lte: 9, label: "1-9 mg/m³" }, // 不指定 min，表示 min 为无限大（-Infinity）。
			{ gte: 300, label: ">300严重污染" }, // 不指定 max，表示 max 为无限大（Infinity）。
			{ gte: 200, lte: 300, label: "201-300重度污染" },
			{ gte: 150, lte: 200, label: "151-200中度污染" },
			{ gte: 100, lte: 150, label: "101-150轻度污染" },
			{ gte: 50, lte: 100, label: "51-100空气良" },
			{ gte: 0, lte: 50, label: "<=50空气优" }, // 不指定 min，表示 min 为无限大（-Infinity）。
          ],
          inRange: {
            // 渐变颜色，从小到大
            color: [
              // "#c3d7df",
              // "#5cb3cc",
              // "#8abcd1",
              // "#66a9c9",
              // "#2f90b9",
              // "#1781b5",
		
			'#0c7c10', '#8bc65a', '#ffff7f', '#cd830b', '#ff440b', '#82020f'
			  
            ],
          },
          textStyle: {
            color: "#FFF",
          },
        },
        geo: {
          map: name,
          roam: false,
          selectedMode: false, //是否允许选中多个区域
          zoom: zoom,
          top: top,
          // aspectScale: 0.78,
          show: false,
        },
        series: [
          {
            name: "MAP",
            type: "map",
            map: name,
            // aspectScale: 0.78,
            data: data,
            // data: [1,100],
            selectedMode: false, //是否允许选中多个区域
            zoom: zoom,
            geoIndex: 1,
            top: top,
            tooltip: {
              show: true,
              formatter: function (params) {
                if (params.data) {
                  return params.name + "：" + params.data["value"];
                } else {
                  return params.name;
                }
              },
              backgroundColor: "rgba(0,0,0,.6)",
              borderColor: "rgba(147, 235, 248, .8)",
              textStyle: {
                color: "#FFF",
              },
            },
            label: {
              show: false,
              color: "#000",
              // position: [-10, 0],
              formatter: function (val) {
                // console.log(val)
                if (val.data !== undefined) {
                  return val.name.slice(0, 2);
                } else {
                  return "";
                }
              },
              rich: {},
            },
            emphasis: {
              label: {
                show: false,
              },
              itemStyle: {
                areaColor: "#389BB7",
                borderWidth: 1,
              },
            },
            itemStyle: {
              borderColor: "rgba(147, 235, 248, .8)",
              borderWidth: 1,
              areaColor: {
                type: "radial",
                x: 0.5,
                y: 0.5,
                r: 0.8,
                colorStops: [
                  {
                    offset: 0,
                    color: "rgba(147, 235, 248, 0)", // 0% 处的颜色
                  },
                  {
                    offset: 1,
                    color: "rgba(147, 235, 248, .2)", // 100% 处的颜色
                  },
                ],
                globalCoord: false, // 缺为 false
              },
              shadowColor: "rgba(128, 217, 248, .3)",
              shadowOffsetX: -2,
              shadowOffsetY: 2,
              shadowBlur: 10,
            },
          },
          {
            data: data2,
            type: "effectScatter",
            coordinateSystem: "geo",
            symbolSize: function (val) {
              return 4;
              // return val[2] / 50;
            },
            legendHoverLink: true,
            showEffectOn: "render",
            rippleEffect: {
              // period: 4,
              scale: 6,
              color: "rgba(255,255,255, 1)",
              brushType: "fill",
            },
            tooltip: {
              show: true,
              formatter: function (params) {
                if (params.data) {
                  return params.name + "：" + params.data["value"][2];
                } else {
                  return params.name;
                }
              },
              backgroundColor: "rgba(0,0,0,.6)",
              borderColor: "rgba(147, 235, 248, .8)",
              textStyle: {
                color: "#FFF",
              },
            },
            label: {
              formatter: (param) => {
                return param.name.slice(0, 2);
              },

              fontSize: 11,
              offset: [0, 2],
              position: "bottom",
              textBorderColor: "#fff",
              textShadowColor: "#000",
              textShadowBlur: 10,
              textBorderWidth: 0,
              color: "#FFF",
              show: true,
            },
            // colorBy: "data",
            itemStyle: {
              color: "rgba(255,255,255,1)",
              borderColor: "rgba(2255,255,255,2)",
              borderWidth: 4,
              shadowColor: "#000",
              shadowBlur: 10,
            },
          },
        ],
         //动画效果
            // animationDuration: 1000,
            // animationEasing: 'linear',
            // animationDurationUpdate: 1000
      };
      this.options = option;
    },
    message(text) {
      this.$Message({
        text: text,
        type: "warning",
      });
    },
    mapclick() {
      if (this.echartBindClick) return;
      //单击切换到级地图，当mapCode有值,说明可以切换到下级地图
      this.$refs.CenterMap.chart.on("click", (params) => {
        // console.log(params);
        let xzqData = xzqCode[params.name];
        if (xzqData) {
          this.getData(xzqData.adcode);
        } else {
          this.message("暂无下级地市!");
        }
      });
      this.echartBindClick = true;
    },
  },
};
</script>
<style lang="scss" scoped>
	
	.scale-up {
	  animation: scaleUp 0.8s ease-in-out;
	}
	@keyframes scaleUp {
	  0% {
	    transform: scale(0.7);
		y:50;
	  }
	  100% {
	    transform: scale(1);
		 y:0;
	  }
	}
	
	// // 0%
	// {
	//   duration: 1,
	//   scale: 0.7,
	//   y: 50
		
	// },
	// // 100%
	// {
	//   duration: 1,
	//   scale: 1,
	//   y:0
	// })
	
.centermap {
  margin-bottom: 20px;

  .maptitle {
    height: 40px;
    display: flex;
    justify-content: center;
    padding-top: 10px;
    box-sizing: border-box;

    .titletext {
      font-size: 28px;
      font-weight: 900;
      letter-spacing: 6px;
      background: linear-gradient(
        92deg,
        #0072ff 0%,
        #00eaff 48.8525390625%,
        #01aaff 100%
      );
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      margin: 0 10px;
    }

    .zuo,
    .you {
      background-size: 100% 100%;
      width: 29px;
      height: 20px;
      margin-top: 8px;
    }

    .zuo {
      background: url("../../assets/img/xiezuo.png") no-repeat;
    }

    .you {
      background: url("../../assets/img/xieyou.png") no-repeat;
    }
  }

  .mapwrap {
    height: 600px;
    width: 100%;
    // padding: 0 0 10px 0;
    box-sizing: border-box;
    position: relative;

    .quanguo {
      position: absolute;
      right: 20px;
      top: -46px;
      width: 80px;
      height: 28px;
      border: 1px solid #00eded;
      border-radius: 10px;
      color: #00f7f6;
      text-align: center;
      line-height: 26px;
      letter-spacing: 6px;
      cursor: pointer;
      box-shadow: 0 2px 4px rgba(0, 237, 237, 0.5),
        0 0 6px rgba(0, 237, 237, 0.4);
    }
  }
}
</style>
