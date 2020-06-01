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

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router
