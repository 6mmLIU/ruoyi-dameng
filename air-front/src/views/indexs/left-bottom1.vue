<!--
 * @Author: daidai
 * @Date: 2022-02-28 16:16:42
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-10-25 09:18:22
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\left-center.vue
-->
<template>
  <Echart id="leftCenter" :options="options" class="left_center_inner" v-if="pageflag" ref="charts" />
  <Reacquire v-else @onclick="getData" style="line-height:200px">
    重新获取
  </Reacquire>
</template>

<script>
import { currentGET } from 'api/modules'
import {httpAction, postAction, getAction} from '@/utils/manage'
export default {
  data() {
    return {
      options: {},
      countUserNumData: {
       
      },
      pageflag: true,
      timer: null
    };
  },
  created() {
    //this.getData()
    this.getDataByCenter()
  },
  mounted() {
  },
  beforeDestroy() {
    this.clearData()

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
              obj.num1 = parseInt(data[i].num);
            }else if(data[i].quality == "良"){
              obj.num2 = parseInt(data[i].num);
            }else if(data[i].quality == "轻度污染"){
              obj.num3 = parseInt(data[i].num);
            }else if(data[i].quality == "中度污染"){
              obj.num4 = parseInt(data[i].num);
            }else if(data[i].quality == "严重污染"){
              obj.num5 = parseInt(data[i].num);
            }else if(data[i].quality == "重度污染"){
              obj.num6 = parseInt(data[i].num);
            }
          }
          obj.sum = sum;
          this.countUserNumData = obj;
          this.$nextTick(() => {
            this.init1()
          })
			})
    },
    clearData() {
      if (this.timer) {
        clearInterval(this.timer)
        this.timer = null
      }
    },
    // getData() {
    //   this.pageflag = true
    //   // this.pageflag =false

    //   currentGET('big1').then(res => {
    //     //只打印一次
    //     if (!this.timer) {
    //       console.log("设备总览", res);
    //     }
    //     if (res.success) {
    //       this.countUserNumData = res.data
    //       this.$nextTick(() => {
    //         this.init()
    //       })

    //     } else {
    //       this.pageflag = false
    //       this.$Message({
    //         text: res.msg,
    //         type: 'warning'
    //       })
    //     }
    //   })
    // },
    // //轮询
    switper() {
      if (this.timer) {
        return
      }
      let looper = (a) => {
        this.getData()
      };
      this.timer = setInterval(looper, this.$store.state.setting.echartsAutoTime);
      let myChart = this.$refs.charts.chart
      myChart.on('mouseover', params => {
        this.clearData()
      });
      myChart.on('mouseout', params => {
        this.timer = setInterval(looper, this.$store.state.setting.echartsAutoTime);
      });
    },
    init1() {

      let total = this.countUserNumData.sum;
      let colors = ['#0c7c10', '#8bc65a', '#ffff7f', '#cd830b', '#ff440b', '#82020f'];
      let piedata = {
        name: "全国空气空气质量情况",
        type: "pie",
        radius: ["25%", "55%"],
		    // roseType: 'area',
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 4,
          borderColor: "rgba(0,0,0,0)",
          borderWidth: 2,
        },

        color: colors,
        data: [
          {
            value:this.countUserNumData.num1,
            name: "优",
            label: {
              shadowColor: colors[0],
            },
          },
          {
            value: this.countUserNumData.num2,
            name: "良",
            label: {
              shadowColor: colors[1],
            },
          },
          {
            value: this.countUserNumData.num3,
            name: "轻度污染",
            label: {
              shadowColor: colors[2],
            },
          },
          {
            value: this.countUserNumData.num4,
            name: "中度污染",
            label: {
              shadowColor: colors[3],
            },
          },
          {
            value: this.countUserNumData.num5,
            name: "严重污染",
            label: {
              shadowColor: colors[4],
            },
          },
          {
            value: this.countUserNumData.num6,
            name: "重度污染",
            label: {
              shadowColor: colors[5],
            },
          },


        ],
      };
      this.options = {
        title: {
          // zlevel: 0,
          text: ["{value|" + total + "}", "{name|总数}"].join("\n"),
          top: "center",
          left: "center",
          textStyle: {
            rich: {
              value: {
                color: "#ffffff",
                fontSize: 24,
                fontWeight: "bold",
                lineHeight: 20,
              },
              name: {
                color: "#ffffff",
                lineHeight: 20,
              },
            },
          },
        },
        tooltip: {
          trigger: "item",
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
        series: [
          //展示圆点
          {
            ...piedata,
            tooltip: { show: true },
            label: {
              formatter: "   {b|{b}}   \n   {c|{c}个}   {per|{d}%}  ",
              //   position: "outside",
              rich: {
                b: {
                  color: "#fff",
                  fontSize: 12,
                  lineHeight: 26,
                },
                c: {
                  color: "#31ABE3",
                  fontSize: 14,
                },
                per: {
                  color: "#31ABE3",
                  fontSize: 14,
                },
              },
            },
            labelLine: {
              length: 20, // 第一段线 长度
              length2: 36, // 第二段线 长度
              show: true,
            
            },
              emphasis: {
                show: true,
              },
          },
          {
            ...piedata,
            tooltip: { show: true },
            itemStyle: {},
            label: {
              backgroundColor: "inherit", //圆点颜色，auto：映射的系列色
              height: 0,
              width: 0,
              lineHeight: 0,
              borderRadius: 2.5,
              shadowBlur: 8,
              shadowColor: "auto",
              padding: [2.5, -2.5, 2.5, -2.5],
            },
            labelLine: {
              length: 20, // 第一段线 长度
              length2: 36, // 第二段线 长度
              show: false,
            },
          },
        ],
      };
    },
 
  },
};
</script>
<style lang='scss' scoped>
</style>