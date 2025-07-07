<!--
 * @Author: daidai
 * @Date: 2022-02-28 16:16:42
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-07-20 17:57:11
 * @FilePath: \web-pc\src\pages\big-screen\view\indexs\left-center.vue
-->
<template>
    <ul class="user_Overview flex" v-if="pageflag">
        <li class="user_Overview-item" style="color: #00fdfa">
            <div class="user_Overview_nums allnum ">
                <dv-digital-flop :config="config" style="width:100%;height:100%;" />
            </div>
            <p>AQI</p>
        </li>
        <li class="user_Overview-item" style="color: #07f7a8">
            <div class="user_Overview_nums online">
                <dv-digital-flop :config="onlineconfig" style="width:100%;height:100%;" />
            </div>
            <p>PM2.5</p>
        </li>
        <li class="user_Overview-item" style="color: #e3b337">
            <div class="user_Overview_nums offline">
                <dv-digital-flop :config="offlineconfig" style="width:100%;height:100%;" />
            </div>
            <p>PM10</p>
        </li>
        <li class="user_Overview-item" style="flex:1.5;line-height: 50px;align-items: center; padding: 20px 0px 0px 0px; font-size: 16px;">
            <div>CO:  {{userOverview.num1}}mg/m³</div>
            <div>NO2: {{userOverview.num2}}μg/m³</div>
            <div>O3: {{userOverview.num3}}μg/m³</div>
            <div>SO2: {{userOverview.num4}}μg/m³</div>
        </li>
        <!-- <li class="user_Overview-item" style="color: #f5023d">
            <div class="user_Overview_nums laramnum">
                <dv-digital-flop :config="laramnumconfig" style="width:100%;height:100%;" />
            </div>
            <p>告警次数</p>
        </li> -->
    </ul>
    <Reacquire v-else @onclick="getData" line-height="200px">
        重新获取
    </Reacquire>
</template>

<script>
import { currentGET } from 'api/modules'
import { mapState, mapMutations } from 'vuex';
import {httpAction, postAction, getAction} from '@/utils/manage'
let style = {
    fontSize: 24
}
export default {
    data() {
        return {
            options: {},
            userOverview: {
                alarmNum: 0,
                offlineNum: 0,
                onlineNum: 0,
                totalNum: 0,
                num1: 0,
                num2: 0,
                num3: 0,
                num4: 0,
            },
            pageflag: true,
            timer: null,
            config: {
                number: [100],
                content: '{nt}',
                style: {
                    ...style,
                    // stroke: "#00fdfa",
                    fill: "#00fdfa",
                },
            },
            onlineconfig: {
                number: [0],
                content: '{nt}',
                style: {
                    ...style,
                    // stroke: "#07f7a8",
                    fill: "#07f7a8",
                },
            },
            offlineconfig: {
                number: [0],
                content: '{nt}',
                style: {
                    ...style,
                    // stroke: "#e3b337",
                    fill: "#e3b337",
                },
            },
            laramnumconfig: {
                number: [0],
                content: '{nt}',
                style: {
                    ...style,
                    // stroke: "#f5023d",
                    fill: "#f5023d",
                },
            }

        };
    },
    computed: {
        ...mapState(['areacode'])
    },
    watch: {
        areacode(newValue, oldValue) {
            console.log('Count changed from', oldValue, 'to', newValue);
            if(newValue == "china"){
                this.getDataByAreaCode();
            }else{
                this.getProvinceAQIList(newValue);
            }
        }
    },
    filters: {
        numsFilter(msg) {
            return msg || 0;
        },
    },
    created() {
        this.getDataByAreaCode();
        //this.getData()
    },
    mounted() {
    },
    beforeDestroy() {
        this.clearData()

    },
    methods: {
        getProvinceAQIList(code){
            var params = {
                "type": "aqi",
                "px": "Desc",
                "code": code
            };
            postAction("/Aqi/getProvinceAQIList", params).then((res) => {
				console.log(res);
                if(res.code == '-1'){
                    this.$Message({
                    text: res.msg,
                    type: 'warning'
                    })
                    return;
                }
                // AQI
                this.config = {
                    ...this.config,
                    number: [parseInt(res.data[0].aqi)]
                }
                // PM10
                this.offlineconfig = {
                    ...this.offlineconfig,
                    number: [parseInt(res.data[0].pm10)]
                }
                // PM2.5
                this.onlineconfig = {
                    ...this.onlineconfig,
                    number: [parseInt(res.data[0].pm2_5)]
                }
                this.userOverview.num1 = res.data[0].co;
                this.userOverview.num2 = res.data[0].no2;
                this.userOverview.num3 = res.data[0].o3;
                this.userOverview.num4 = res.data[0].so2;
			})
        },
        getDataByAreaCode(){
            var params = {
                "type": "aqi",
                "px": "Desc"
            };
            getAction("/Aqi/queryQIAverage", params).then((res) => {
				console.log(res);
                if(res.code == '-1'){
                    this.$Message({
                    text: res.msg,
                    type: 'warning'
                    })
                    return;
                }
                // AQI
                this.config = {
                    ...this.config,
                    number: [parseInt(res.data.aqi)]
                }
                // PM10
                this.offlineconfig = {
                    ...this.offlineconfig,
                    number: [parseInt(res.data.pm10)]
                }
                // PM2.5
                this.onlineconfig = {
                    ...this.onlineconfig,
                    number: [parseInt(res.data.pm2_5)]
                }
                this.userOverview.num1 = res.data.co;
                this.userOverview.num2 = res.data.no2;
                this.userOverview.num3 = res.data.o3;
                this.userOverview.num4 = res.data.so2;
			})
        },
        clearData() {
            if (this.timer) {
                clearInterval(this.timer)
                this.timer = null
            }
        },
        getData() {
            this.pageflag = true;
            currentGET("big2").then((res) => {
                if (!this.timer) {
                    console.log("设备总览", res);
                }
                if (res.success) {
                    this.userOverview = res.data;
                    this.onlineconfig = {
                        ...this.onlineconfig,
                        number: [res.data.onlineNum]
                    }
                    this.config = {
                        ...this.config,
                        number: [res.data.totalNum]
                    }
                    this.offlineconfig = {
                        ...this.offlineconfig,
                        number: [res.data.offlineNum]
                    }
                    this.laramnumconfig = {
                        ...this.laramnumconfig,
                        number: [res.data.alarmNum]
                    }
                    this.switper()
                } else {
                    this.pageflag = false;
                    this.$Message.warning(res.msg);
                }
            });
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
        },
    },
};
</script>
<style lang='scss' scoped>
.user_Overview {
    li {
        flex: 1;

        p {
            text-align: center;
            height: 16px;
            font-size: 16px;
        }

        .user_Overview_nums {
            width: 100px;
            height: 100px;
            text-align: center;
            line-height: 100px;
            font-size: 22px;
            margin: 50px auto 30px;
            background-size: cover;
            background-position: center center;
            position: relative;

            &::before {
                content: '';
                position: absolute;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
            }

            &.bgdonghua::before {
                animation: rotating 14s linear infinite;
            }
        }

        .allnum {

            // background-image: url("../../assets/img/left_top_lan.png");
            &::before {
                background-image: url("../../assets/img/left_top_lan.png");

            }
        }

        .online {
            &::before {
                background-image: url("../../assets/img/left_top_lv.png");

            }
        }

        .offline {
            &::before {
                background-image: url("../../assets/img/left_top_huang.png");

            }
        }

        .laramnum {
            &::before {
                background-image: url("../../assets/img/left_top_hong.png");

            }
        }
    }
}
</style>