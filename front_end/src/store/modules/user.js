import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    loginAPI,
    registerAPI,
    getUserInfoAPI,
} from '../../api/user.js'
import {addCollectionAPI, deleteCollectionAPI, getCollectionAPI} from "../../api/passages";

const user={
    state:{
        user_id:0,
        collection:[],
    },
    mutations:{
        set_userId: (state, data) => {
            state.user_id = data
        },
        set_token: function (state, token) {
            state.token = token
        },
        set_collection:function (state,data) {
            state.collection=data
        },
    },
    actions:{
        login: async ({state,dispatch, commit}, userData) => {
            const res = await loginAPI(userData)
            if (res) {
                setToken(res.id)
                /* 
                dispatch('getUserInfo')*/
                commit('set_userId', res.id)
                router.push('/createblog')
                //console.log('success',state.user_id,res)
            }
        },
        register: async ({commit}, data) => {
            //console.log('enter',data)
            const res = await registerAPI(data)
            if (res) {
                message.success('注册成功')
            }
        },
        getUserInfo({state,commit}) {
            return new Promise((resolve, reject) => {
                getUserInfoAPI(state.user_id).then(response => {
                    const data = response
                    if (!data) {
                        reject('登录已过期，请重新登录')
                    }
                    //commit('set_userInfo', data.membership)
                    //commit('set_userId', data.id)
                    resolve(data)
                }).catch(error => {
                    reject(error)
                })
            })
        },
        getCollection:async ({commit,state})=>{
            const res=await getCollectionAPI(state.user_id)
            if(res){
                commit('set_collection',res)
            }
        },
        addCollection:async ({dispatch,state},passageId)=>{
            const data={
                userId:state.user_id,
                passageId:passageId,
                collectTime:new Date()
            }
            let res=await addCollectionAPI(data)
            if(res){
                dispatch('getCollection')
                message.success('收藏成功')
            }
            else{
                message.error('收藏失败')
            }
        },
        deleteCollection:async ({dispatch,state},passageId)=>{
            const data={
                userId:state.user_id,
                passageId:passageId,
                collectTime:new Date()
            }
            let res=await deleteCollectionAPI(data)
            if(res){
                dispatch('getCollection')
                message.success('已取消')
            }
            else{
                message.error('取消失败')
            }
        }
    }
}
export default user;