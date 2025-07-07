<!--
 * @Author: daidai
 * @Date: 2022-03-01 09:43:37
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-09-09 11:40:22
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\left-bottom.vue
-->
<template>
	<div v-if="pageflag" class="left_boottom_wrap beautify-scroll-def" :class="{ 'overflow-y-auto': !sbtxSwiperFlag }">
		<component :is="components" :data="list" :class-option="defaultOption">
			<ul class="left_boottom">
				<li class="left_boottom_item" v-for="(item, i) in list" :key="i">
					<span class="orderNum doudong">{{ i + 1 }}</span>

					<div class="inner_right">
						<div class="dibu"></div>
						<div class="flex">
							<div class="info">
								<!-- <span class="labels"style="font-size: 14px;">城市：</span> -->
								<span class="contents zhuyao doudong wangguan" style="font-size: 18px;">
									{{ item.area }}</span>
								<span class="contents" style="font-size: 14px;color:#b43034;" >
									({{ item.quality}})</span>
							</div>
							
							<div class="info" style="margin-left: 60px">
								<!-- <span class="labels" style="font-size: 14px;">时间：</span> -->
								<span class="contents " style="font-size: 13px;color:#ccc;">
									{{ item.timepoint }}发布</span>
							</div>
						</div>

						<!--  <span
                class="types doudong"
                :class="{
                  typeRed: item.onlineState == 0,
                  typeGreen: item.onlineState == 1,
                }"
                >{{ item.quality}}({{ item.aqi}})</span
              > -->
						<div class="info addresswrap">
							<span class="labels" style="font-size: 14px;color:#8bc65a">温馨提示：</span>
							<span class="contents ciyao" style="font-size: 13px;color:#eee">
								{{ item.measure }}</span>
						</div>
						<div class="info addresswrap">
							<span class="labels" style="font-size: 14px;color:#cd830b">健康影响：</span>
							<span class="contents ciyao" style="font-size: 13px;color:#eee">
								{{ item.unheathful }}</span>
						</div>
					</div>
				</li>
			</ul>
		</component>
	</div>

	<Reacquire v-else @onclick="getData" style="line-height: 200px" />
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
		data() {
			return {
				list: [],
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
		created() {

		},
		destroyed() {

		},
		unmounted() {
			clearTimeout(this.timer);
		},
		mounted() {
			this.getCityAQIList();
		},
		methods: {
			getCityAQIList() {
				var params = {
					"type": "aqi",
					"px": "Desc"
				};
				postAction("/Aqi/getCityAQIList", params).then((res) => {
					console.log("##################", res);
					if (res.code == '-1') {
						this.$Message({
							text: res.msg,
							type: 'warning'
						})
						return;
					}
					for (var i = 0; i < res.data.length; i++) {
						if (res.data[i].quality != "优" && res.data[i].quality != "良") {
							this.list.push(res.data[i]);
						}
					}
					this.pageflag = true;
					let timer = setTimeout(() => {
						clearTimeout(timer)
						this.defaultOption.step = this.$store.state.setting.defaultOption.step
					}, this.$store.state.setting.defaultOption.waitTime);
				})
			},
			getData() {
				this.pageflag = true;
				// this.pageflag =false
				currentGET("big3", {
					limitNum: 20
				}).then((res) => {
					console.log("设备提醒", res);
					if (res.success) {
						this.countUserNumData = res.data;
						this.list = res.data.list;
						let timer = setTimeout(() => {
							clearTimeout(timer);
							this.defaultOption.step =
								this.$store.state.setting.defaultOption.step;
						}, this.$store.state.setting.defaultOption.waitTime);
					} else {
						this.pageflag = false;
						this.$Message({
							text: res.msg,
							type: "warning",
						});
					}
				});
			},
		},
	};
</script>
<style lang='scss' scoped>
	.left_boottom_wrap {
		overflow: hidden;
		width: 100%;
		height: 100%;
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

	.left_boottom {
		width: 100%;
		height: 100%;

		.left_boottom_item {
			display: flex;
			align-items: center;
			justify-content: center;
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
				width: 380px;
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