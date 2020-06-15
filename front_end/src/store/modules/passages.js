import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    searchAPI,
    getPassageAPI,
    savePassageAPI,
    getUserBlogsAPI,
    isInCollectionAPI,
} from "../../api/passages";
const passages={
    state:{
        searchResult:[],
        passageDetail:[],
        userBlogs:[],
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
        }
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
                commit('set_passage',res)
            }
        },
        savePassage:async({commit},data)=>{
            //console.log("passage",data)
            const res=await savePassageAPI(data)
        },
        getUserBlogs:async({commit},id)=>{
            //console.log(id)
            const res=await getUserBlogsAPI(id)
            commit('set_userblogs',res)
            console.log('pa',res)
            return res
        },
        isInCollection:async({state},data)=>{
            const res=await isInCollectionAPI(data)
            console.log(res)
            return res
        }
    }

}
export default passages;