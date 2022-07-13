import axios from "axios";

const service = axios.create({
  // baseURL: 'http://139.159.238.19:8081',
  timeout: 5000
})

// 请求拦截器配置
service.interceptors.request.use(config => {
  return config
}, error => {
  console.log('err' + error)
  return Promise.reject(error)
})

// 响应拦截器配置
service.interceptors.response.use(response => {
  return response
}, error => {
  console.log(error)
  return Promise.reject(error)
})

export default service
