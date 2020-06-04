import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    loginAPI,
} from '../../api/user.js'

const user={
    state:{

    },
    mutations:{

    },
    actions:{
        login: async ({dispatch, commit}, userData) => {
            console.log('enter',userData)
            const res = await loginAPI(userData)
            if (res) {
                //setToken(res.id)
                /* commit('set_userId', res.id)
                dispatch('getUserInfo')
                router.push('/hotel/hotelList') */
                console.log('success')
            }
        },
    }
}
export default user;