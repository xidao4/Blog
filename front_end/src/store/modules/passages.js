import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    searchAPI,
    getPassageAPI,
    savePassageAPI,
} from "../../api/passages";
const passages={
    state:{
        searchResult:[],
        passageDetail:[],
    },
    mutations:{
        set_searchResult:function (state,data) {
            state.searchResult=data
        },
        set_passage:function (state,data) {
            state.passageDetail=data
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
                commit('set_passage',res)
            }
        },
        savePassage:async({commit},data)=>{
            const res=await savePassageAPI(data)
        }
    }

}
export default passages;