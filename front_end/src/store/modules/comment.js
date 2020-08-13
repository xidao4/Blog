import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {addCommentAPI, addCommentByPassageIdAPI, deleteCommentAPI, getCommentByPassageIdAPI} from "../../api/comment";
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
            const res=await getCommentByPassageIdAPI(id)
            console.log(res)
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
        },
        deleteComment:async ({commit,dispatch,state},id)=>{
            let passageId=state.commentList[0].passageId
            let res=await deleteCommentAPI(id)
            if(res){
                dispatch('getCommentList',passageId)
                message.success("已删除")
            }
            else{
                message.error("删除失败")
            }
        }
    },
}
export default comment