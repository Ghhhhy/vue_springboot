import request from '@/utils/request'

export function getProfessions(data) {
  return request({
    url: 'http://139.159.238.19:8081/zhuanyes/find',
    method: 'post',
    data
  })
}


export function getProfessionsByPage(params, data) {
  return request({
    url: 'http://139.159.238.19:8081/zhuanyeinfo/find' + '/' + params.current + '/' + params.pagesize,
    method: 'post',
    data
  })
}

export function getProfessionInfo(data) {
  return request({
    url: 'http://139.159.238.19:8081/zhuanyeinfo/find',
    method: 'post',
    data
  })
} 