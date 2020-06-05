import Vue from 'vue'
import axios from './plugins/axios'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import store from './store'
import '@/permission'
Vue.config.productionTip = false
Vue.prototype.$ajax = axios

Vue.use(Antd)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
