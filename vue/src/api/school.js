import request from '@/utils/request'

export function findSchools(data) {
  return request({
    url: 'http://139.159.238.19:8081/universitys/find',
    method: 'post',
    data
  })
}

export function findSchoolsByDetails(params, data) {
  return request({
    url: 'http://139.159.238.19:8081/universitys/find' + '/' + params.current + '/' + params.pagesize,
    method: 'post',
    data
  })
}

export function getSchoolsByPage(params) {
  return request({
    url: 'http://139.159.238.19:8081/universitys' + '/' + params.current + '/' + params.pagesize,
    method: 'get',
  })
}

export function getRecommendSchools(params, data) {
  return request({
    url: 'http://139.159.238.19:8081/universitys/recommenderByCity' + '/' + params.current + '/' + params.pagesize,
    method: 'post',
    data
  })
}