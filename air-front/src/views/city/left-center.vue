<!--
 * @Author: daidai
 * @Date: 2022-02-28 16:16:42
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-10-25 09:18:22
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\left-center.vue
-->
<template>
	<div style="display: flex;padding:30px">
		<div style="flex:1;text-align:center;line-height:70px;">
			<div style="font-size: 60px;"><span id="SZdh" style="color:#00fdfa">{{lnAQI}}</span>
			<span :style="{ color: getColor(quality) }" style="font-size: 20px;">{{quality}}</span></div>
			<div style="font-size: 25px;" >空气质量指数</div>
		</div>
		<div style="flex:1;text-align:center;line-height:70px">
			<div style="font-size: 60px;"><span id="SZdh1" style="color:#00fdfa">{{cityNum}}</span><span
					style="font-size: 20px;">&nbsp;</span></div>
			<div style="font-size: 25px;">总城市数</div>
		</div>
		<div style="flex:1;text-align:center;line-height:70px">
			<div style="font-size: 60px;"><span id="SZdh2" style="color:#00fdfa">{{nwrCityNum}}</span><span
					style="font-size: 20px;">&nbsp;</span></div>
			<div style="font-size: 25px;">无污染城市个数</div>
		</div>
	</div>
</template>

<script>
	import {
		currentGET
	} from 'api/modules'
	import {
		httpAction,
		postAction,
		getAction
	} from '@/utils/manage'
	import { CountUp } from 'countup.js'
	
	// // 给数字执行滚动的动画
	// function startAnimation(panelItems = []) {
	//    // 等 dom更新 完成之后执行
	//    const option1 = {
	//     decimalPlaces: 1, // 保留一位小数点 
	//     duration: 2,
	//     useGrouping: false, // 1000 -> 1,000
	//   }
	//   const option2 = {
	//     decimalPlaces: 1, // 保留一位小数点 
	//     duration: 2,
	//     useGrouping: false, // 1000 -> 1,000
	//     suffix: '%'
	//   }
	//   panelItems.forEach((item)=>{
	//     new CountUp(`total-num-${item.id}`, item.totalNum, option1).start()
	//     new CountUp(`percentage-num-${item.id}`, item.percentage, option2).start()
	//   })
	
	// }
	
	
	export default {
		data() {
			return {
				pageflag: true,
				timer: null,
				lnAQI: null,
				cityNum: null,
				nwrCityNum: null,
				quality:null
			};
		},
		created() {
			this.getDataByCenter()
		},
		mounted() {
		
		},
		beforeDestroy() {
			this.clearData()

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
			        
			getDataByCenter() {
				var params = {
					"code": "210000",
					"type": "aqi",
					"px": "Desc"
				};
				postAction("/Aqi/getCityAQIListByProvince", params).then((res) => {
					console.log(res);
					if (res.code == '-1') {
						this.$Message({
							text: res.msg,
							type: 'warning'
						})
						return;
					}
					var data = res.data;
					var sum = 0;
					var obj = {};
					var thisAQI=parseInt(data.aqi);
						if(thisAQI<=50){
							this.quality="优";
						}else  if(thisAQI<=100){
							this.quality="良";
						}else  if(thisAQI<=150){
							this.quality="轻度污染";
						}else  if(thisAQI<=200){
							this.quality="中度污染";
						}else  if(thisAQI<=300){
							this.quality="重度污染";
						}else  if(thisAQI>300){
							this.quality="严重污染";
						}
					this.lnAQI = thisAQI;
					
					this.cityNum = data.cityNum;
					 var wwrCityNum=0;
					for(var i=0;i<data.list.length;i++)
					{
						var str=data.list[i].quality;
						if(str === "优" || str === "良") {
						wwrCityNum=wwrCityNum+1;
						}
					}
					 this.nwrCityNum=wwrCityNum;
					const countUp = new CountUp(document.getElementById('SZdh'), this.lnAQI);
					countUp.start();
					const countUp1 = new CountUp(document.getElementById('SZdh1'), this.cityNum);
					countUp1.start();
					const countUp2 = new CountUp(document.getElementById('SZdh2'), this.nwrCityNum);
				    countUp2.start();
				})
			},
			clearData() {
				if (this.timer) {
					clearInterval(this.timer)
					this.timer = null
				}
			},

			//轮询
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
		},
	};
</script>
<style lang='scss' scoped>
</style>