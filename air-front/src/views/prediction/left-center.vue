<template>
	<div>
		<div style="display: flex;">
			<div :style="index == 0 ?{'marginLeft':'0px'}:{}"
				style="padding-top: 20px;flex:1;text-align:center;line-height:30px; margin-left:10px;border: 1px solid #00FBF8;"
				v-for="(item, index) in list1">
				<div style="font-size: 26px;">{{item.forecastDate}}<span style="font-size: 22px;">({{item.day}})</span></div>
				<!-- <div>({{item.day}})</div> -->
				<div style="display: flex;justify-content: center;">
					<div><img src="../../assets/img/1.png" style="height:200px" /></div>
					<div style="font-size: 20px;">
						<div
							style="text-align: left;background: rgba(50, 140, 218); padding: 10px; margin-left: 10px; margin-bottom: 15px;">
							<div>AQI：{{item.aqi}}</div>
							
						</div>
						<div
							style="text-align: left;background: rgba(50, 140, 218); padding: 10px; margin-left: 10px; margin-bottom: 15px;">
				
							<div>空气质量：{{item.quality}}</div>
						</div>
						<div
							style="text-align: left;background: rgba(50, 140, 218, 0.3); padding: 10px; margin-left: 10px; margin-bottom: 25px;">
						<!-- 	<div>主要污染物</div> -->
							<div>主要污染物：{{ item.primarypollutant}}</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div style="display: flex;">
		<div :style="index == 0 ?{'marginLeft':'0px'}:{}"
			style="padding-top: 20px;flex:1;text-align:center;line-height:30px; margin-left:10px;border: 1px solid #00FBF8;"
			v-for="(item, index) in list2">
			<div style="font-size: 26px;">{{item.forecastDate}}<span style="font-size: 22px;">({{item.day}})</span></div>
			<!-- <div>({{item.day}})</div> -->
			<div style="display: flex;justify-content: center;">
				<div><img src="../../assets/img/1.png" style="height:200px" /></div>
				<div style="font-size: 20px;">
					<div
						style="text-align: left;background: rgba(50, 140, 218); padding: 10px; margin-left: 10px; margin-bottom: 15px;">
						<div>AQI：{{item.aqi}}</div>
						
					</div>
					<div
						style="text-align: left;background: rgba(50, 140, 218); padding: 10px; margin-left: 10px; margin-bottom: 15px;">
			
						<div>空气质量：{{item.quality}}</div>
					</div>
					<div
						style="text-align: left;background: rgba(50, 140, 218, 0.3); padding: 10px; margin-left: 10px; margin-bottom: 25px;">
					<!-- 	<div>主要污染物</div> -->
						<div>主要污染物：{{ item.primarypollutant}}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 	<div style="display: flex;">
			<div :style="index == 0 ?{'marginLeft':'0px'}:{}"
				style="flex:1;text-align:center;line-height:30px;margin-left:10px;border: 1px solid #00FBF8;margin-top:10px;"
				v-for="(item, index) in list1">
				<div>{{ item.time }}</div>
				<div>（24小时预报）</div>
				<div style="display: flex;justify-content: space-around;">
					<div><img src="../../assets/img/1.png" style="height:200px" /></div>
					<div>
						<div
							style="background: rgba(50, 140, 218); padding: 10px; margin-left: 10px; margin-bottom: 25px;">
							<div>{{ item.data }}</div>
							<div>{{ item.text }}</div>
						</div>
						<div
							style="background: rgba(50, 140, 218, 0.3); padding: 10px; margin-left: 10px; margin-bottom: 25px;">
							<div>主要污染物</div>
							<div>{{ item.main }}</div>
						</div>
					</div>
				</div>
			</div>
		</div> -->
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
	export default {
		props: {
		   code: String,
		   name: String,
		 },
		data() {
			return {
				options: {},
				list1: [],
					list2: [],
				pageflag: true,
				timer: null
			};
		},
		created() {
			this.getData(this.code);
			//this.getDataByCenter()
		},
		mounted() {
			// for (var i = 0; i < 7; i++) {
			// 	var obj = {
			// 		time: '2024-03-29 ' + i + ':00:00',
			// 		data: '27~30',
			// 		text: '良~轻度污染',
			// 		main: 'PM10'
			// 	}
			// 	this.list.push(obj);
			// }
		},
		beforeDestroy() {
			this.clearData()

		},
		watch: {
				code(newValue, oldValue) {
				console.info("watch:code="+newValue);
				this.getData(newValue);
				},
		},
		methods: {
			getData(code) {
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
				    this.list1.splice(0, this.list1.length);
					this.list2.splice(0, this.list2.length);
					var data = res.data;
					var length= res.data.length;
				   for (var i = 0; i < res.data.length; i++) {
					   if(i<4){
						var obj = {
							forecastDate: res.data[i].forecastDate.substring(0, 10),
							day: res.data[i].day,
							aqi:res.data[i].aqi,
							quality: res.data[i].quality,
							primarypollutant:res.data[i].primarypollutant,
						}
						this.list1.push(obj);
						}else{
							var obj1 = {
								forecastDate: res.data[i].forecastDate.substring(0, 10),
								day: res.data[i].day,
								aqi:res.data[i].aqi,
								quality: res.data[i].quality,
								primarypollutant:res.data[i].primarypollutant,
							}
							this.list2.push(obj1);
						}
					}
				
				// this.curCityAqi = data.cityAqi.aqi;
					// this.curCityQuality = data.cityAqi.quality;
					// this.curCityPrimarypollutant = data.cityAqi.primarypollutant;
					// this.curCityPM25 = data.cityAqi.pm25;
					// this.curCityPM10 = data.cityAqi.pm10;
					// this.curCityCO = data.cityAqi.co;
					// this.curCityNO2 = data.cityAqi.no2;
					// this.curCitySO2 = data.cityAqi.so2;
					// this.curCityO3 = data.cityAqi.o3;
					// this.curMeasure = data.cityAqi.measure;
					// this.curUnheathful = data.cityAqi.unheathful;
				})
			},
			clearData() {
				if (this.timer) {
					clearInterval(this.timer)
					this.timer = null
				}
			}
		},
	};
</script>
<style lang='scss' scoped>
</style>