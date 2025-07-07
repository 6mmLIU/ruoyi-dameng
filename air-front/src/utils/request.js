import Vue from 'vue'
import axios from 'axios'
import { VueAxios } from './axios'
import { ACCESS_TOKEN } from '@/store/mutation-types'


//自动设置后台服务 baseURL (也可以手工指定写死项目名字)
let baseDomain = window._CONFIG['domianURL'];
let baseProject = baseDomain.substring(baseDomain.lastIndexOf("/"));
console.log("baseDomain= ",baseDomain)
console.log("baseProject= ",baseProject)

// 创建 axios 实例
const service = axios.create({
  //baseURL: '/jeecg-boot',
  baseURL: baseDomain, // api base_url
  timeout: 18000 // 请求超时时间
})

const err = (error) => {
  if (error.response) {
    let data = error.response.data;
    const token = Vue.ls.get(ACCESS_TOKEN)
    console.log("------异常响应------",token)
    console.log("------异常响应------",error.response.status)
    switch (error.response.status) {
      case 403:
        notification.error({ message: '系统提示', description: '拒绝访问',duration: 4})
        break
      case 500:
        //notification.error({ message: '系统提示', description:'Token失效，请重新登录!',duration: 4})
        if(token && data.message=="Token失效，请重新登录"){
          // update-begin- --- author:scott ------ date:20190225 ---- for:Token失效采用弹框模式，不直接跳转----
          // store.dispatch('Logout').then(() => {
          //     window.location.reload()
          // })
          Vue.ls.remove(ACCESS_TOKEN)
          window.location.reload()
          // update-end- --- author:scott ------ date:20190225 ---- for:Token失效采用弹框模式，不直接跳转----
        }
        break
      case 404:
        break
      case 504:
        break
      case 401:
        if (token) {
          window.location.reload()
        }
        break
      default:
        notification.error({
          message: '系统提示',
          description: data.message,
          duration: 4
        })
        break
    }
  }
  return Promise.reject(error)
};

// request interceptor
service.interceptors.request.use(config => {
  const token = Vue.ls.get(ACCESS_TOKEN)
  if (token) {
    config.headers['Authorization'] = 'Bearer ' + token // 让每个请求携带自定义 token 请根据实际情况自行修改
  }
  if(config.method=='get'){
    if(config.url.indexOf("sys/dict/getDictItems")<0){
      config.params = {
        _t: Date.parse(new Date())/1000,
        ...config.params
      }
    }
  }
  return config
},(error) => {
  return Promise.reject(error)
})

// response interceptor
service.interceptors.response.use((response) => {
    return response.data
  }, err)

const installer = {
  vm: {},
  install (Vue, router = {}) {
    Vue.use(VueAxios, router, service)
  }
}

export {
  installer as VueAxios,
  service as axios
}