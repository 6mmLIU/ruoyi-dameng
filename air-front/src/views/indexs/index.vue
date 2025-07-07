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
      <ItemWrap class="contetn_left-top contetn_lr-item" title="实时空气质量总览">
        <LeftTop/>
  
      </ItemWrap>
      <ItemWrap class="contetn_left-center contetn_lr-item" title="全国空气质量情况">
      <LeftCenter/>

      </ItemWrap>
      <ItemWrap
        class="contetn_left-bottom contetn_lr-item"
        title="全国城市空气质量情况"
        style="padding: 0 10px 16px 10px"
      >
       <LeftBottom/>
	  
      </ItemWrap>
    </div>
    <div class="contetn_center">
		<div style="position: relative;  height: 650px;">
		
			<div class="map1">
			
			</div>
			<div class="map2">
			
			</div>
			<div class="map3">
			
			</div>
			<CenterMap  class="contetn_center_top" style=" z-index: 2;"/>
		</div>
      <ItemWrap class="contetn_center-bottom" title="各省空气质量">
        <CenterBottom />
      </ItemWrap>
    </div>
    <div class="contetn_right">
      <ItemWrap
        class="contetn_left-bottom contetn_lr-item"
        title="全国城市空气质量排名(TOP10)"
      >
        <RightTop />
      </ItemWrap>
      <ItemWrap
        class="contetn_left-bottom contetn_lr-item"
        title="全国污染城市报警"
        style="padding: 0 10px 16px 10px"
      >
        <RightCenter />
      </ItemWrap>
      <ItemWrap
        class="contetn_left-bottom contetn_lr-item"
        title="历史空气质量"
      >
         <RightBottom />
      </ItemWrap>
    </div>
  </div>
</template>

<script>
import LeftTop from './left-top.vue'
import LeftCenter from "./left-center1.vue";
import LeftBottom from "./left-bottom1.vue";
import CenterMap from "./center-map.vue";
import CenterBottom from "./center-bottom.vue";
import RightTop from "./right-top1.vue";
import RightCenter from "./right-center1.vue";
import RightBottom from "./right-bottom1.vue";

export default {
  components: {
    LeftTop,
    LeftCenter,
    LeftBottom,
    CenterMap,
    RightTop,
    RightCenter,
    RightBottom,
    CenterBottom,
  },
  data() {
    return {
    
    };
  },
  filters: {
    numsFilter(msg) {
      return msg || 0;
    },
  },
  created() {
  },

  mounted() {},
  methods: {
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
	.map1,
	.map2,
	.map3
	{
	  position: absolute;
	  top: 54%;
	  left: 50%;
	  transform: translate(-50%, -50%);
	  width: 500px;
	  height: 500px;
	  background: url(../../assets/img/map.png) no-repeat;
	  background-size: 100% 100%;
	  opacity: 0.3;
	}
	.map2 {
	  width: 560px;
	  height: 560px;
	  background-image: url(../../assets/img/lbx.png);
	  opacity: 0.6;
	  animation: rotate 15s linear infinite;
	  z-index: 0;
	}
	.map3 {
	  width: 550px;
	  height: 550px;
	 z-index: 0;
	  background-image: url(../../assets/img/jt.png);
	  animation: rotate1 10s linear infinite;
	}
	@keyframes rotate {
	  from {
	    transform: translate(-50%, -50%) rotate(0deg);
	  }
	  to {
	    transform: translate(-50%, -50%) rotate(360deg);
	  }
	}
	@keyframes rotate1 {
	  from {
	    transform: translate(-50%, -50%) rotate(0deg);
	  }
	  to {
	    transform: translate(-50%, -50%) rotate(-360deg);
	  }
	}
// 内容
.contents {
  .contetn_left,
  .contetn_right {
    width: 500px;
    box-sizing: border-box;
    // padding: 16px 0;
  }

  .contetn_center {
    width: 800px;
  }

  //左右两侧 三个块
  .contetn_lr-item {
    height: 310px;
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
    height: 310px;
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
