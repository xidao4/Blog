import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    searchAPI,
    getPassageAPI,
    savePassageAPI,
    updatePassageAPI,
    getUserBlogsAPI,
    getMostPopularPassagesAPI,
    deletePassageAPI,
    listCreateTimeAPI, getRandomPassagesAPI,
} from "../../api/passages";
import {getUserNameAPI} from "../../api/user";
import {getTagsByPassageAPI} from "../../api/tag";
const passages={
    state:{
        searchResult:[],
        passageDetail:[],
        userBlogs:[],
        tags:[],
        listCreateTime:[],
        passageList:[]
    },
    mutations:{
        set_searchResult:function (state,data) {
            state.searchResult=data
        },
        set_passage:function (state,data) {
            state.passageDetail=data
        },
        set_userblogs:function(state,data){
            state.userBlogs=data
        },
        set_tags:function (state,data) {
            state.tags=data
        },
        set_listCreateTime:function(state,data){
            state.listCreateTime=data
        },
        set_passageList:function(state,data){
            state.passageList=data
        },
    },
    actions:{
        searchPassage:async ({commit},value)=>{
            let res=await searchAPI(value)
            if(res){
                commit("set_searchResult",res)
            }
        },
        getPassage:async ({commit},id)=>{
            let res=await getPassageAPI(id)
            if(res){
                let userId=res.userId
                let name=await getUserNameAPI(userId)
                res.userName=name
                commit('set_passage',res)
            }
        },
        savePassage:async({commit},data)=>{
            //console.log("passage",data)
            const res=await savePassageAPI(data)
            if(res){
                if(data.status==0){
                    message.success("暂存成功")
                }
                else
                {
                message.success("上传成功")
                }
            }
            return res
            
        },
        updatePassage:async({commit},data)=>{
            //console.log("passage",data)
            const res=await updatePassageAPI(data)
            if(res){
                    message.success("更新成功")
               
            }
            return res
            
        },
        getUserBlogs:async({commit},id)=>{
            //console.log(id)
            const res=await getUserBlogsAPI(id)
            commit('set_userblogs',res)
            console.log('pa',res)
            return res
        },
        getPassageTags:async({commit},id)=>{
            const res=await getTagsByPassageAPI(id)
            //console.log(res)
            commit('set_tags',res)
        },
        getMostPopularPassages:async({commit},id)=>{
            const res=await getMostPopularPassagesAPI(id)
            console.log(res)
            return res;
        },
        delPassage:async({commit},id)=>{
            const res=await deletePassageAPI(id)
            if(res){
                message.success("已删除")
            }
            else{
                message.error("删除失败")
            }
        },
        listCreateTime:async ({commit},id)=>{
            const dates=await listCreateTimeAPI(id)
            console.log(dates)
            commit('set_listCreateTime',dates);
            return dates;
        },
        getRandomPassages:async ({commit})=>{
            const res=await getRandomPassagesAPI()
            console.log(res)
            commit('set_passageList',res);
        },
    }

}
export default passages;