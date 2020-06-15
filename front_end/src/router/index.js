import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Layout from '../components/layout/index.vue'
import Setting from '../views/person_setting.vue'
import Login from '../views/login.vue'
import CreateBlog from '../views/MyBlog/createblog.vue'
import Detail from "../views/MyBlog/component/details.vue";
import myCollection from "../views/MyBlog/myCollection";
import searchResult from "../components/layout/component/searchResult";
import myBlog from '../views/MyBlog/myblog.vue'
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
                path:'/myblog',
                name:'myblog',
                component:myBlog,
            },
            {
                path:'/home',
                name:'home',
                component:Home,
            },
            {
                path:'/login',
                name:'login',
                component:Login,
            },
            {
                path:'/createblog',
                name:'createblog',
                component:CreateBlog,
            },
            {
                path:'/details',
                name:'details',
                component:Detail,
            },
            {
                path:'/myCollection',
                name:'myCollection',
                component:myCollection,
            },
            {
                path:'/searchResult',
                name:'searchResult',
                component: searchResult,
            }
        ]
    },
    {
        path: '/about',
        name: 'About',
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]

/* const router = new VueRouter({
    mode: 'history',
    routes
}) */
const createRouter = () => new VueRouter({
    mode: 'history',
    scrollBehavior: () => ({ y: 0 }),
    routes
  })
  const router = createRouter()
  
  export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
  }
  
  export default router
