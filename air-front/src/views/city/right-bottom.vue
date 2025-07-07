<!--
 * @Author: daidai
 * @Date: 2022-03-01 15:27:58
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-05-07 11:24:14
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\right-center.vue
-->
<template>
	<div>
		
	<div style="display:flex;width: 100%;height: 100%;">
		
		<div style="text-align: center;">
			<div style="line-height: 30px;;">
				<div><img style="width: 120px;" src="../../assets/img/paichacishu.png" /></div>
				<div style="font-size: 20px;color:#55aaff">站点个数</div>
				<div style="margin-top: 10px;color:#468dd3">11</div>
			</div>
			<div style="margin-top: 50px;">
				<div><img style="width: 120px;" src="../../assets/img/yinhuanshu.png" /></div>
				<div style="font-size: 20px;color:#ffaa00">站点个数</div>
				<div style="margin-top: 10px;color:#d58e00">11</div>
			</div>
			<!-- <dv-decoration-3 style="width:150px;height:30px;" /> -->
		</div>
		<div style="flex:1">
			<table class="airTable" style="width: 100%;text-align: center;line-height: 30px;font-size: 20px;">
				<tr>
					<th>站点</th>
					<th>AQI</th>
					<th>PM2.5</th>
					<th>PM10</th>
					<th>SO2</th>
					<th>No2</th>
					<th>CO</th>
					<th>O3</th>
					<th>空气质量</th>
				</tr>
				<tr>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
				</tr>
				<tr>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
				</tr>
				<tr>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
				</tr>
				<tr>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
				</tr>
				<tr>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
				</tr>
				<tr>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
					<td>1212</td>
				</tr>
			</table>
		</div>
			</div>
				<dv-decoration-3 style="width:100%;height:50px;margin-top: 50px;" />
				<dv-decoration-3 style="width:100%;height:50px;" />
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
	import * as echarts from 'echarts';
	import 'echarts-liquidfill'
	import 'echarts-wordcloud'

	export default {
		name: "VueWordCloud",
		data() {
			return {
				worddata: [{
						name: "PM2.6",
						value: 100,
					},
					{
						name: "PM10",
						value: 100,
					},
					{
						name: "AQI",
						value: 100,
					},
					{
						name: "CO",
						value: 100,
					},
					{
						name: "SO2",
						value: 100,
					},
					{
						name: "NO2",
						value: 100,
					},
					{
						name: "O3",
						value: 100,
					}
				],
			};
		},
		mounted() {
			//this.initEcharts();
			//this.getDataByCenter();
		},
		methods: {
			getDataByCenter() {
				var params = {};
				getAction("/Aqi/queryAQILevelNum", params).then((res) => {
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
					for (var i = 0; i < data.length; i++) {
						sum += parseInt(data[i].num);
						if (data[i].quality == "优") {
							obj.num1 = parseFloat(data[i].percentage);
						} else if (data[i].quality == "良") {
							obj.num2 = parseFloat(data[i].percentage);
						} else if (data[i].quality == "轻度污染") {
							obj.num3 = parseFloat(data[i].percentage);
						} else if (data[i].quality == "中度污染") {
							obj.num4 = parseFloat(data[i].percentage);
						} else if (data[i].quality == "严重污染") {
							obj.num5 = parseFloat(data[i].percentage);
						} else if (data[i].quality == "重度污染") {
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
						text: "城市AQI良好率" + percentage + "%",
						left: "center",
						bottom: 0,
						textStyle: {
							color: "#fff",
							fontWeight: "400",
							fontSize: 18,
						},
					},

					series: [{
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
						color: [{
							type: "linear",
							x: 0,
							y: 1,
							x2: 0,
							y2: 0,
							colorStops: [{
									offset: 1,
									color: ["#328CDA"], // 0% 处的颜色
								},
								{
									offset: 0,
									color: ["#9DC9FF"], // 100% 处的颜色
								},
							],
							global: false, // 缺省为 false
						}, ],

						outline: {
							show: true,
							borderDistance: 5,
							itemStyle: {
								borderColor: "#54B3FC",
								borderWidth: 3,
							},
						},
					}]
				}
				chart.setOption(option)
			},
			initEcharts(data) {
				const chart = echarts.init(this.$refs.chart)
				const color = [
					"#fff",
					"#FFD200",
					"#00EAFF",
					"#fff",
					"#FFD200",
					"#00EAFF",
					"#fff",
					"#FFD200",
					"#00EAFF",
					"#fff",
					"#FFD200",
					"#00EAFF",
					"#fff",
					"#FFD200",
					"#00EAFF",
				];
				let option = {
					title: {
						text: "",
						x: "center",
					},
					series: [{
						type: "wordCloud",
						//用来调整词之间的距离
						gridSize: 20,
						//用来调整字的大小范围
						sizeRange: [12, 20],
						rotationRange: [0, 0],
						//随机生成字体颜色
						textStyle: {
							color: (v) => `${color[v.dataIndex]}`,
						},
						//位置相关设置
						left: "center",
						top: "center",
						right: null,
						bottom: null,
						width: "100%",
						height: "100%",
						//数据
						data: this.worddata,
					}, ],
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

	.airTable th,
	.airTable td {
		padding: 10px;
	}

	.airTable th {
		background: #328CDA;
	}
</style>