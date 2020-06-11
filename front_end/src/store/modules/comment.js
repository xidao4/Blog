import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {addCommentAPI, addCommentByPassageIdAPI, getCommentByPassageIdAPI} from "../../api/comment";
const comment={
    state:{
        commentList:[

        ],
    },
    mutations:{
        set_commentList:function (state,data) {
            state.commentList=data
        }
    },
    actions:{
        getCommentList:async ({commit,state},id)=>{
            let res=await getCommentByPassageIdAPI(id)
            if(res){
                commit('set_commentList',res)
            }
        },
        addComment:async ({commit,state,dispatch},data)=>{
            let res=await addCommentAPI(data)
            if(res){
                dispatch('getCommentList',data.passageId)
                message.success('评论成功')
            }
            else{
                message.error('评论失败')
            }
        }
    },
}
export default comment