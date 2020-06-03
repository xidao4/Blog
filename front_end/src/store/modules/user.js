import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    loginAPI,
    registerAPI,
} from '../../api/user.js'

const user={
    state:{

    },
    mutations:{

    },
    actions:{
        login: async ({dispatch, commit}, userData) => {
            const res = await loginAPI(userData)
            if (res) {
                //setToken(res.id)
                /* commit('set_userId', res.id)
                dispatch('getUserInfo')
                router.push('/hotel/hotelList') */
                console.log('success')
            }
        },
        register: async ({commit}, data) => {
            console.log('enter',data)
            const res = await registerAPI(data)
            if (res) {
                message.success('注册成功')
            }
        },
    }
}
export default user;