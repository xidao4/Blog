import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user.js'
import passages from "./modules/passages";
import comment from "./modules/comment";
import getters from "./getter";
Vue.use(Vuex)

export default new Vuex.Store({
  modules:{
    user,
    comment,
    passages,
  },
  state: {
  },
  mutations: {
  },
  actions: {
  },
  getters
})
