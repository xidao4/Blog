import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Layout from '../components/layout/index.vue'
import Setting from '../views/person_setting.vue'

Vue.use(VueRouter)

  const routes = [
    {
      path:'/',
      name:'layout',
      component:Layout,
      children:[
       {
         path:'/setting',
         name:'setting',
         component:Setting,
       },
       {
        path:'/home',
        name:'home',
        component:Home,
      },    
    
      ]
  },
  {
    path: '/about',
    name: 'About',
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router