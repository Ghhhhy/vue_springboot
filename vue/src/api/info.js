import request from '@/utils/request'

export function getImg() {
  return request({
    url: '/getImg',
    methdod: 'get'
  })
}

export function getCarouselImg() {
  return request({
    url: '/getCarouselImg',
    methdod: 'get'
  })
}

export function getNews() {
  return request({
    url: '/getNews',
    methdod: 'get'
  })
}
