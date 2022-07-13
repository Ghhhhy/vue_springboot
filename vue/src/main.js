import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import Cookies from 'js-cookie'

require('./mock')

// require('./permission')

Vue.use(Antd);
Vue.use(ElementUI);
Vue.use(Cookies)

import JwChat from 'jwchat';

Vue.use(JwChat)

Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
