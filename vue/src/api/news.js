import request from '@/utils/request'

export function getNews(data) {
  return request({
    url: 'http://139.159.238.19:8081/news/find/1/6',
    method: 'post',
    data
  })
}

export function getNewsDetail(data) {
  return request({
    url: 'http://139.159.238.19:8081/news/find',
    method: 'post',
    data
  })
}