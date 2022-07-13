import router from './router'
import store from './store'
// import { getToken } from '@/util/auth'

router.beforeEach(async (to, from, next) => {
  store.dispatch('user/getInfo')
  next()
})
