import Vue from 'vue'
import router from '@/router'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {message} from 'ant-design-vue'
import {
    searchAPI
} from "../../api/passages";
const passages={
    state:{
        searchResult:[],
    },
    mutations:{
        set_searchResult:function (state,data) {
            state.searchResult=data
        }
    },
    actions:{
        searchPassage:async ({commit},value)=>{
            let res=await searchAPI(value)
            if(res){
                commit("set_searchResult",res)
            }
        }
    }

}
export default passages;