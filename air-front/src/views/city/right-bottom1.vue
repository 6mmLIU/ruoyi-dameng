<!--
 * @Author: daidai
 * @Date: 2022-03-01 09:43:37
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-09 11:40:22
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\left-bottom.vue
-->
<template>
	<div>
<div style="display: flex;">
	<div style="width: 170px;text-align: center;">
		<div style="line-height: 30px;;">
			<div><img style="width: 150px;" src="../../assets/img/paichacishu.png" /></div>
			<div style="font-size: 20px;color:#55aaff">站点个数</div>
			<div style="margin-top: 10px;color:#468dd3">{{stationNum}}</div>
		</div>
		<div style="margin-top: 50px;">
			<div><img style="width: 150px;" src="../../assets/img/yinhuanshu.png" /></div>
			<div style="font-size: 20px;color:#ffaa00">异常站点</div>
			<div style="margin-top: 10px;color:#d58e00">{{wrStationNum}}</div>
		</div>
	</div>
	<div style="flex:1;height:430px;">
<!-- 	<dv-decoration-3 style="width:100%;height:50px;marginpx-top: 50px;" /> -->
	<!-- <dv-decoration-3 style="width:100%;height:50px;" /> -->
	<div class="inner_right" style="height: 80px;padding-left: 50px;">

		<div style="height: 80px;text-align: start;display: flex;align-items: center;">
			<!-- <div  style="width: 30px;text-align: left;background-color: #100;">
				序号
			</div> -->
			<div class="contents zhuyao doudong wangguan" style="font-size: 25px;width:100px;text-align: left;margin-left: 10px;">
				<!-- <span class="labels"style="font-size: 14px;">城市：</span> -->
				站点名称
			</div>
			<div class="infoT" style="" >
				AQI
			</div>
			<div class="infoT"  style="" >
			PM2.5
			</div>
			<div class="infoT" >
			PM10
			</div>
		   <div class="infoT" >
			SO2
			</div>
			<div class="infoT" >
			NO2
			</div>
			<div class="infoT" >
			CO
			</div>
			<div class="infoT" >
			O3
			</div>
		  <div class="infoT"  style="width:120px"  >
			空气
			</div>
			
		</div>
	</div>
	<div v-if="pageflag" class="left_boottom_wrap beautify-scroll-def" :class="{ 'overflow-y-auto': !sbtxSwiperFlag }">
			<component :is="components" :data="list" :class-option="defaultOption">
			<ul class="left_boottom">
				<li class="left_boottom_item" v-for="(item, i) in list" :key="i">
					<!-- <span class="orderNum doudong" style="font-size: 22px;width:30px;background-color: #eee;">{{ i + 1 }}</span> -->

					<div class="inner_right">
						<div class="dibu"></div>
						<div  class="flex" style="height: 60px;text-align: center;align-items: center; ">
							<div class="contents zhuyao doudong wangguan" style="font-size:25px;width:100px;text-align: center;">
								<!-- <span class="labels"style="font-size: 14px;">城市：</span> -->
								{{ item.positionname }}
							</div>
							<div class="info1" >
									{{item.aqi}}
							</div>
							<div class="info1" style="" >
									{{item.pm25}}
							</div>
					    	<div class="info1" >
								{{item.pm10}}
				    		</div>
					       <div class="info1" >
								{{item.so2}}
							</div>
							<div class="info1" >
								{{item.no2}}
							</div>
							<div class="info1" >
								{{item.co}}
							</div>
							<div class="info1" >
								{{item.o3}}
							</div>
						<div   class="info1" :style="{color: getColor(item.quality)}"  style="width:120px"   >
								{{item.quality}}
							</div>
							
						</div>
					</div>
				</li>
			</ul>
		</component>
	</div>

	<Reacquire v-else @onclick="getData" style="line-height: 200px" />
	</div>

</div>
<dv-decoration-3 style="width:100%;height:30px;margin-top: 58px;"></dv-decoration-3>
</div>
</template>

<script>
	import {
		currentGET
	} from "api";
	import vueSeamlessScroll from "vue-seamless-scroll"; // vue2引入方式
	import Kong from "../../components/kong.vue";
	import {
		httpAction,
		postAction,
		getAction
	} from '@/utils/manage'
	export default {
		components: {
			vueSeamlessScroll,
			Kong
		},
		props: {
		   code: String,
		   name: String,
		 },
		data() {
			return {
				list: [],
				stationNum:null,
				wrStationNum:null,
				pageflag: false,
				components: vueSeamlessScroll,
				defaultOption: {
					...this.$store.state.setting.defaultOption,
					limitMoveNum: 3,
					singleHeight: 150,
					step: 0,
					hoverStop: true
				},
				timer: {}
			};
		},
		computed: {
		
			sbtxSwiperFlag() {
				let sbtxSwiper = this.$store.state.setting.sbtxSwiper;
				if (sbtxSwiper) {
					this.components = vueSeamlessScroll;
				} else {
					this.components = Kong;
				}
				return sbtxSwiper;
			},
		},
		watch: {
		   code(newValue, oldValue) {
						console.info("watch:code="+newValue);
		     this.getCityAQIList(newValue);
		   },
		 },
		created() {
     	this.getCityAQIList(this.code);
		},
		destroyed() {

		},
		unmounted() {
			clearTimeout(this.timer);
		},
		mounted() {
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
			getCityAQIList(code) {
				var params = {
					"code":code
				};
				getAction("/Aqi/queryStationAQIByCity", params).then((res) => {
					if (res.code == '-1') {
						this.$Message({
							text: res.msg,
							type: 'warning'
						})
						return;
					}
					var stationNum = res.data.list.length;
					console.info("wsh-站点个数："+stationNum);
					this.stationNum= stationNum;
					this.wrStationNum=res.data.wrSationNum;
					this.list=res.data.list;
					// for (var i = 0; i < res.data.length; i++) {
					// 		this.list.push(res.data.list[i]);
					// }
					this.pageflag = true;
					let timer = setTimeout(() => {
						clearTimeout(timer)
						this.defaultOption.step = this.$store.state.setting.defaultOption.step
					}, this.$store.state.setting.defaultOption.waitTime);
				})
			},
			// getData() {
			// 	this.pageflag = true;
			// 	// this.pageflag =false
			// 	currentGET("big3", {
			// 		limitNum: 20
			// 	}).then((res) => {
			// 		console.log("设备提醒", res);
			// 		if (res.success) {
			// 			this.countUserNumData = res.data;
			// 			this.list = res.data.list;
			// 			let timer = setTimeout(() => {
			// 				clearTimeout(timer);
			// 				this.defaultOption.step =
			// 					this.$store.state.setting.defaultOption.step;
			// 			}, this.$store.state.setting.defaultOption.waitTime);
			// 		} else {
			// 			this.pageflag = false;
			// 			this.$Message({
			// 				text: res.msg,
			// 				type: "warning",
			// 			});
			// 		}
			// 	});
			// },
		},
	};
</script>
<style lang='scss' scoped>
	.left_boottom_wrap {
		overflow: hidden;
		width: 100%;
		height: 100%;
		padding-left:63px;
	}

	.doudong {
		//  vertical-align:middle;
		overflow: hidden;
		-webkit-backface-visibility: hidden;
		-moz-backface-visibility: hidden;
		-ms-backface-visibility: hidden;
		backface-visibility: hidden;
	}

	.overflow-y-auto {
		overflow-y: auto;
	}
	.infoT {
				width:85px;
				font-size:25px;
				text-align: center;
				}
.info1 {
			width:85px;
			font-size:25px;
			text-align: center;
			}
	.left_boottom {
		width: 100%;
		height: 100%;

		.left_boottom_item {
			display: flex;
			align-items: center;
			/* justify-content: center; */
			padding: 0px;
			font-size: 14px;
			margin: 10px 0;

			.orderNum {
				margin: 0 16px 0 -20px;
			}
			
			.info {
				margin-right: 10px;
				display: flex;
				align-items: center;
				color: #fff;

				.labels {
					flex-shrink: 0;
					font-size: 12px;
					color: rgba(255, 255, 255, 0.6);
				}

				.zhuyao {
					color: $primary-color;
					font-size: 15px;
				}

				.ciyao {
					color: rgba(255, 255, 255, 0.8);
				}

				.warning {
					color: #e6a23c;
					font-size: 15px;
				}
			}

			.inner_right {
				position: relative;
				height: 100%;
				width: 680px;
				flex-shrink: 0;
				line-height: 1.2;
				display: flex;
				align-items: center;
				justify-content: space-between;
				flex-wrap: wrap;

				.dibu {
					position: absolute;
					height: 2px;
					width: 104%;
					background-image: url("../../assets/img/zuo_xuxian.png");
					bottom: -10px;
					left: -2%;
					background-size: cover;
				}

				.addresswrap {
					width: 100%;
					display: flex;
					margin-top: 8px;
				}
			}

			.wangguan {
				color: #1890ff;
				font-weight: 900;
				font-size: 15px;
				width: 80px;
				flex-shrink: 0;
			}


			.time {
				font-size: 12px;
				// color: rgba(211, 210, 210,.8);
				color: #fff;
			}

			.address {
				font-size: 12px;
				cursor: pointer;
				// @include text-overflow(1);
			}

			.types {
				width: 70px;
				flex-shrink: 0;
			}

			.typeRed {
				color: #fc1a1a;
			}

			.typeGreen {
				color: #29fc29;
			}
		}
	}
</style>