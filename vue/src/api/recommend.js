import request from '@/utils/request'

export function recommend(data) {
  return request({
    url: 'http://139.159.238.19:8081/universitys/recommenderByScore/1/5',
    method: 'post',
    data
  })
}