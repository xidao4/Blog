import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {getCommentByPassageIdAPI} from "../../api/comment";
const comment={
    state:{
        commentList:[]
    },
    mutations:{
        set_commentList:function (state,data) {
            state.commentList=data
        }
    },
    actions:{
        getCommentList:async ({commit},id)=>{
            let res=getCommentByPassageIdAPI(id)
            if(res){
                commit('set_commentList',res)
            }
        }
    },
}
export default comment