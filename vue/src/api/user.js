import request from '@/utils/request'

export function login(data) {
  return request({
    url: 'http://139.159.238.19:8081/users/signon',
    method: 'post',
    data
  })
}

export function register(data) {
  return request({
    url: 'http://139.159.238.19:8081/users/signup',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/getInfo',
    method: 'get',
    params: { token }
  })
}
