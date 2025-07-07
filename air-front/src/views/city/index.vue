<!--
 * @Author: daidai
 * @Date: 2022-03-04 09:23:59
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-05-07 11:05:02
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\index.vue
-->
<template>
    <div class="contents">
        <div class="contetn_left">
            <div class="pagetab">
                <div class="item" @click="goHome()">全国空气质量</div>
                <div class="item" @click="goCity()">城市监测数据</div>
                <div class="item" @click="goPrediction()">城市空气预测</div>
            </div>
		
            <!-- <ItemWrap class="contetn_left-top contetn_lr-item" title="辽宁省AQI总览"> -->
               <div style="margin-top: 40px;">
				   <CenterMap />
			   </div> 
	
            <!-- </ItemWrap> -->
            <ItemWrap class="contetn_left-bottom contetn_lr-item" title="辽宁省今日空气质量">
                <LeftCenter />
            </ItemWrap>
        </div>
        <div class="contetn_right">
			<div style="display: flex;justify-content: right;font-size: 25px;padding-right: 40px;height:40px;">
				<div style=" display: flex; align-items: center; color:#00fdfa;margin-right: 10px;text-align: center;">切换城市：</div>
				<div style="display: flex; align-items: center; color:#eee;margin-right: 10px;">辽宁省</div>
				<div >
					<select v-model="selectedOption"  class="custom-select">
						<option v-for="option in options" :key="option.cityCode" :value="option.cityCode">
						{{ option.cityName}}
						</option>
					</select>
				</div>
			  </div>
            <ItemWrap class="contetn_right-top contetn_lr-item" :title="selectedCityName+'空气质量'">
                 <RightTop  :code="selectedOption" :name="selectedCityName"/> 
            </ItemWrap>
            <ItemWrap class="contetn_right-bottom contetn_lr-item" :title="selectedCityName+'各监测点空气质量'">
                 <RightBottom  :code="selectedOption" :name="selectedCityName"/> 
            </ItemWrap>
        </div>
    </div>
  </template>
  
  <script>
  import RightTop from "./right-top.vue";
  import LeftCenter from "./left-center.vue";
  import CenterMap from "./center-map.vue";
  import RightBottom from "./right-bottom1.vue";
  import {httpAction, postAction, getAction} from '@/utils/manage'
  export default {
    components: {
        CenterMap,
        LeftCenter,
        RightTop,
        RightBottom
    },
    data() {
      return {
        selectedOption: '210100',
	    selectedCityName:'沈阳市',
        options: [
		]
		,
      };
	  
    },
	watch: {
	   selectedOption(newValue, oldValue) {
			const selectedOption1= this.options.find(option => option.cityCode === newValue);
			if (selectedOption1) {
				const selectedOptionText = selectedOption1.cityName;
			this.selectedCityName=selectedOptionText;
			} else {
			this.selectedCityName="";
			}
	   },
	 },
    filters: {
      numsFilter(msg) {
        return msg || 0;
      },
    },
    created() {
		this.initData();
    },
  
    mounted() {},
    methods: {
		initData(){
		  var params = {
			  "code":"210000"
		  };
		  getAction("/Aqi/getAllCityByProvince", params).then((res) => {
						console.log(res);
		      if(res.code == '-1'){
		        this.$Message({
		          text: res.msg,
		          type: 'warning'
		        })
		        return;
		      }
		      this.options = res.data;
			})
		},
        goCity(){
            this.$router.push('/cityIndex');
        },
        goHome(){
            this.$router.push('/index');
        },
        goPrediction(){
            this.$router.push('/predictionIndex');
        }
    },

  };
  </script>
  <style lang="scss" scoped>
	  .custom-select {
	    height: 40px; /* 设置下拉列表的高度 */
	    background-color: rgba(3, 5, 55, 0.1); /* 设置背景颜色为蓝色半透明 */
	    color: #00fdfa; /* 设置文字颜色为红色 */
        font-size: 25px;
	  }
	  /* 调整弹出下拉选项的文字大小、文字颜色和背景颜色 */
	  .custom-select option {
	    font-size: 20px; /* 设置文字大小 */
	    color: #FFF; /* 设置文字颜色 */
	    background-color: rgba(3, 5, 55); /* 设置背景颜色为白色半透明 */
		// border-color: rgba(147, 235, 248, .8);
	  }
  // 内容
  .contents {
    .contetn_left{
      width: 700px;
      box-sizing: border-box;
      // padding: 16px 0;
    }
    .contetn_right {
      width: 1140px;
      box-sizing: border-box;
      //padding: 16px 0;
    }
  
    .contetn_center {
      width: 720px;
    }
  
    //左右两侧 三个块
    .contetn_left-top.contetn_lr-item {
      height: 620px;
    }
    .contetn_left-bottom.contetn_lr-item {
      height: 300px;
    }

    .contetn_right-top.contetn_lr-item{
        height: 320px;
    }
    .contetn_right-bottom.contetn_lr-item{
        height: 620px;
    }
  
    .contetn_center_top {
      width: 100%;
    }
  
    // 中间
    .contetn_center {
      display: flex;
      flex-direction: column;
      justify-content: space-around;
    }
  
    .contetn_center-bottom {
      height: 315px;
    }
  
    //左边 右边 结构一样
    .contetn_left,
    .contetn_right {
      display: flex;
      flex-direction: column;
      justify-content: space-around;
      position: relative;
  
    
    }
  }
  
  
  @keyframes rotating {
      0% {
          -webkit-transform: rotate(0) scale(1);
          transform: rotate(0) scale(1);
      }
      50% {
          -webkit-transform: rotate(180deg) scale(1.1);
          transform: rotate(180deg) scale(1.1);
      }
      100% {
          -webkit-transform: rotate(360deg) scale(1);
          transform: rotate(360deg) scale(1);
      }
  }
  </style>
  