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

const user={
    state:{
        user_id:'',
    },
    mutations:{
        set_userId: (state, data) => {
            state.user_id = data
        },
    },
    actions:{
        login: async ({state,dispatch, commit}, userData) => {
            const res = await loginAPI(userData)
            if (res) {
                //setToken(res.id)
                /* 
                dispatch('getUserInfo')
                router.push('/hotel/hotelList') */
                commit('set_userId', res.id)
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
    }
}
export default user;