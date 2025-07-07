<!--
 * @Author: daidai
 * @Date: 2022-03-01 14:13:04
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-27 15:04:49
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\right-top.vue
-->
<template>
	<div style="">
		<div style="display:flex;">
			<div style="flex:2">
			   <Echart id="rightTop" :options="option" class="right_top_inner" style="margin-left: 0px;margin-top: 20px;height: 200px;width: 300px;"/>
		        <div style="font-size: 21px;margin-left: 80px;padding-top:0px;color:#8bc65a;width: 140px;text-align: center;">
		    		<span :style="{color: getColor(curCityQuality)}" style="font-size: 30px">{{curCityQuality}}
		    		</span>
		    	</div>
			</div>
			<div style="flex:4;font-size: 20px;line-height: 43px;margin-top: 20px;">
				<!-- <div style="display:flex;color:#8bc65a">
					<div style="flex:1"><span>城市：</span><span style="font-size: 20px;color:#eee">沈阳
				    </span>
					</div>
				</div> -->
				<div style="display:flex ;font-size: 23px;">
					<div style=";width:100px;color: #ddd;" >PM2.5</div>
					<div style=";width:200px;color: #ccc" >{{curCityPM25}} μg/m³</div>
					<div style=";width:100px;color: #ddd;" >PM10</div>
					<div style=";width:200px;color: #ccc" >{{curCityPM10}} μg/m³</div>
					<!-- <div ><span style=";width:300px;text-align: left;background-color: #111">PM25：</span><span style=";width:100px;text-align: left;background-color: #333">{{curCityPM25}} μg/m³</span></div><div style="margin-left:100px;background-color: #111"><span style=";width:100px;text-align: left;">PM10：</span><span style=";width:100px;text-align: left;background-color: #333">{{curCityPM10}} μg/m³</span></div> -->
					<!-- <div style=";width:300px;text-align: left;background-color: #111">PM10：<span style=";width:100px;text-align: left;background-color: #333">{{curCityPM10}} μg/m³</span></div> -->
				</div>
				<div style="display:flex;font-size: 23px">
					<div style=";width:100px;color: #ddd;" >CO</div>
					<div style=";width:200px;color: #ccc" >{{curCityCO}} mg/m³</div>
					<div style=";width:100px;color: #ddd;" >NO2</div>
					<div style=";width:200px;color: #ccc" >{{curCityNO2}} μg/m³</div>
			    </div>
				<div style="display:flex;font-size: 23px">
					<div style=";width:100px;color: #ddd;" >SO2</div>
					<div style=";width:200px;color: #ccc" >{{curCitySO2}} μg/m³</div>
					<div style=";width:100px;color: #ddd;" >O3</div>
					<div style=";width:200px;color: #ccc;" >{{curCityO3}} μg/m³</div>
				</div>
				<div style="display:flex;color:#8bc65a;font-size: 23px">
					<div style="flex:1"><span>温馨提示：</span><span style=";color:#ddd">{{curMeasure}}
			        </span>
					</div>
				</div>
			</div>
		</div>
		<!-- <div style="display:flex;padding-left:20px;padding-top:20px;"> -->
			<!-- <div style="flex:4; display: flex;">
				<img src="../../assets/img/zhenggaishu.png" />
				<div style="font-size: 20px;line-height: 53px;">
					<div style="font-size: 50px">{{curCityAqi}}
						<span :style="{color: getColor(curCityQuality)}" style="font-size: 30px">{{curCityQuality}}
						</span>
					</div>
					<div>主要污染物：{{curCityPrimarypollutant}}</div>
				</div>
	         </div> -->
		

			<!-- <div style="flex:3;font-size: 20px;line-height: 43px;background-image: url('../../assets/img/zuo_xuxian.png')">
				<div style="display:flex ;">
					<div style="flex:1">PM25：<span>{{curCityPM25}} μg/m³</span></div>
					<div style="flex:1">PM10：<span>{{curCityPM10}} μg/m³</span></div>
				</div>
				<div style="display:flex;">
					<div style="flex:1">CO：<span>{{curCityCO}} mg/m³</span></div>
					<div style="flex:1">NO2：<span>{{curCityNO2}} μg/m³</span></div>
				</div>
				<div style="display:flex;">
					<div style="flex:1">SO2：<span>{{curCitySO2}} μg/m³</span></div>
					<div style="flex:1">O3：<span>{{curCityO3}} μg/m³</span></div>
				</div>
			</div> -->

		<!-- </div> -->
	
	<!-- <div style="font-size: 21px;padding-left: 40px;padding-bottom: 15px;color:#8bc65a">温馨提示：
			<span style="font-size: 20px;color:#eee">{{curMeasure}}
			</span>
		</div> -->
		<!-- <div style="font-size: 21px;padding-left: 40px;padding-bottom: 20px;color:#cd830b">健康影响：
			<span style="font-size: 20px;color:#eee">{{curUnheathful}}
			</span>
		</div> -->
	</div>
</template>

<script>
	import {
		httpAction,
		postAction,
		getAction
	} from '@/utils/manage'
	
	import {
		currentGET
	} from "api/modules";
	
	export default {
		 props: {
		    code: String,
		    name: String,
		  },
		data() {
			return {
				option: {},
				pageflag: false,
				timer: null,
				curCityAqi: null,
				curCityQuality: null,
				curCityPrimarypollutant: null,
				curCityPM25: null,
				curCityPM10: null,
				curCityCO: null,
				curCityNO2: null,
				curCitySO2: null,
				curCityO3: null,
				curMeasure: null,
				curUnheathful: null
			
			};
		},
		 watch: {
		    code(newValue, oldValue) {
				console.info("watch:code="+newValue);
		      this.getData(newValue);
		    },
		  },
		created() {
			console.info("created:code="+this.code);
			this.getData(this.code)
		},

		mounted() {
		
		},
		beforeDestroy() {
			this.clearData();
		},
		methods: {
			getColor: function (str) {
			   if (str === "优") {
			        return '#0c7c10';
			   } else if (str === "良") {
			        return '#8bc65a';
			   } else  if (str === "轻度污染") {
			         return '#ffff7f';
			   }else  if (str === "中度污染") {
			      return '#cd830b';
			   }else  if (str === "重度污染") {
			          return '#ff440b';
			   }else{
									 return '#82020f';
								}
			  },
			getData(code) {
				var params = {
					"code": code
				};
				getAction("/Aqi/queryStationAQIByCity", params).then((res) => {
					console.log("wsh" + res.data);
					if (res.code == '-1') {
						this.$Message({
							text: res.msg,
							type: 'warning'
						})
						return;
					}
					var data = res.data;
					this.curCityAqi = data.cityAqi.aqi;
					this.curCityQuality = data.cityAqi.quality;
					this.curCityPrimarypollutant = data.cityAqi.primarypollutant;
					this.curMeasure = data.cityAqi.measure;
					this.curUnheathful = data.cityAqi.unheathful;
					
					this.curCityPM25 = data.cityAqi.pm25;
					this.curCityPM10 = data.cityAqi.pm10;
					this.curCityCO = data.cityAqi.co;
					this.curCityNO2 = data.cityAqi.no2;
					this.curCitySO2 = data.cityAqi.so2;
					this.curCityO3 = data.cityAqi.o3;
			
			this.init();
					
				})
			},
		init() {
			
			this.option={
				 tooltip: {
					 show:true
				    // formatter: '{a} <br/>{b} : {c}%'
				  },
				 toolbox: {
				     feature: {} // 将 feature 设置为空对象
				   },
				  series: [
				    {
				      name: this.name,
				      type: 'gauge',
					  min: 0,
					  max: 500,
					  radius: '100%',
					  splitNumber: 5,
				      detail: { formatter: '{value}' ,
					  fontWeight: 'bolder',
					  fontSize: 30,
					  color: '#00fdfa'},
				      data: [{ value: this.curCityAqi, name: 'AQI' }],
				      axisLine: {
				        lineStyle: {
				          color: [
				          [0.1, '#0c7c10'],
				          [0.2, '#8bc65a'],
				          [0.3, '#ffff7f'],
				          [0.4, '#cd830b'],
				          [0.6, '#ff440b'],
				          [1, '#82020f']
				          ]
				        }
				      },
				      axisLabel: {
				
				        fontWeight: 'bolder',
				        color: '#fff',
				        fontSize: 30,
				        formatter: function (value) {
				          return '{value|' + value + '}';
				        },
				        rich: {
				          value: {
				            fontSize: 15,
				            fontWeight: 'bolder',
				            color: '#aaa',
				            // backgroundColor: 'rgba(255, 255, 255, 0.5)',
				            borderRadius: 5,
				            padding: [2, 4],
				            align: 'center',
				            verticalAlign: 'middle'
				          }
				        }
				      },
				      axisTick: {
				        length: 10,
				        lineStyle: {
				          color: 'auto',
				          width: 1
				        }
				      },
				      splitLine: {
				        length: 4,
				        lineStyle: {
				          color: 'auto',
				          width: 2
				        }
				      },
				      pointer: {
				        width: 5,
				        length: '80%'
				      },
				      title: {
				        offsetCenter: [0, '13%'],
				        fontWeight: 'bolder',
						color:'#eee',
				        fontSize: 18
				      }
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
		margin-top: 20px;
	}
</style>