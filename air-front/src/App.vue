<!--
 * @Author: daidai
 * @Date: 2022-01-12 14:06:47
 * @LastEditors: daidai
 * @LastEditTime: 2022-03-01 17:55:49
 * @FilePath: \web-pc\src\pages\big-screen\App.vue
-->
<template>
  <div id="app">

	<!--  <transition name="fade"> -->
	     <router-view></router-view>
	    <!-- </transition> -->
  </div>
</template>

<style lang="scss" scoped>
#app {
  width: 100vw;
  height: 100vh;
  background-color: #03050C;
  background-image: url(assets/img/pageBg8.png);
  // overflow: hidden;
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>