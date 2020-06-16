import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    loginAPI,
    registerAPI,
    getUserInfoAPI,
    updateInfoAPI,
    addFriendUrlAPI,
    deleteFriendUrlAPI,
    getFriendUrlAPI
} from '../../api/user.js'
import{
    getTagsByUserAPI,
}from '../../api/tag.js'
import {addCollectionAPI, deleteCollectionAPI, getCollectionAPI} from "../../api/passages";

const user={
    state:{
        user_id:0,
        collection:[],
        friendURL:[],
        friendURLParams:{
            userId:"",
            url:''
        },
        userTags:[],
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
        reset_state: function (state) {
            state.token = '',
                state.userId = '',
                state.userInfo = {},
                state.userOrderList = [],
                state.membership={}
        },
        set_friendURL:function (state,data) {
            state.friendURL=data;
        },
        set_friendURLParams:function (state,data) {
            state.friendURLParams=data;
        },
        setUserTags:function(state,data){
            state.userTags=data;
        }
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
        logout: async ({commit}) => {
            removeToken()
            resetRouter()
            commit('reset_state')
        },
        register: async ({commit}, data) => {
            //console.log('enter',data)
            const res = await registerAPI(data)
            if (res) {
                message.success('注册成功')
            }
            return res;
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
        async updateInfo({state,commit},data){
            //console.log(state.user_id,data)
            const res=await updateInfoAPI(state.user_id,data)
            /* if(res){
                message.success('修改成功')
            }else{
                message.error('修改失败')
            } */

            return res;
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
        },
        getFriendUrl:async ({dispatch,state,commit}, data)=>{
            let res=await getFriendUrlAPI(data)
            if(res){
                commit('set_friendURL',res)
            }
        },
        deleteFriendUrl:async ({dispatch,state},data)=>{
            let res=await deleteFriendUrlAPI(data)
            console.log(data)
            if(res){
                dispatch('getFriendUrl')
                message.success('已删除')
            }
            else{
                message.error('删除失败')
            }
        },
        addFriendUrl:async ({dispatch,state},data)=>{
            let res=await addFriendUrlAPI(data)
            if(res){
                dispatch('getFriendUrl')
                message.success('已添加')
            }
            else{
                message.error('添加失败')
            }
            },
        getTagsByUser:async({state,commit})=>{
            let res=await getTagsByUserAPI(state.user_id);
            commit('setUserTags',res);
            console.log('tags',res)
        }
}}
export default user;