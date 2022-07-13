import Mock from 'mockjs';

Mock.mock('/login', {
  'name': '@cname',
  'token': '@paragraph(1, 3)'
});

Mock.mock('/getInfo', {
  'token': '123456789'
});

// 获取图片
Mock.mock('/getCarouselImg', {
  "img|3": [
    {
      'src': "@dataImage( '1338x320' )"
    }
  ]
})

Mock.mock('/getNews', {
  'news|6': [
    {
      'title': '@csentence',
      'resume': '@cparagraph(1, 2)'
    }
  ]
})

Mock.mock('/getSchools', {
  'schools|8': [
    {
      'name': '@cword(5, 7)',
      'tag': '@cword(3)',
      'src': "@image('100x100')",
      'intro': '@csentence'
    }
  ]
})

Mock.mock('/getProfessions', {
  'professions|8': [{
    'name': '@cword(5, 7)',
    'src': "@image('100x100')",
    'course|1-5': [{
      'name': '@csentence',
      'intro': '@csentence',
    }]
  }]
})
