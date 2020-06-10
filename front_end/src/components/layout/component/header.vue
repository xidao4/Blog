<template>
  <div>
    <a-row :gutter="16">
      <a-col :span="4 " :order="1"><div class="logo"></div></a-col>
      <a-col :span="16"  :order="2">
        <a-menu v-model="current" id="up_menu" theme="dark" mode="horizontal" >
          <a-menu-item key="main"> <a-icon type="appstore" />首页</a-menu-item>
          <a-menu-item key="app" > <a-icon type="profile" />我的收藏
            <router-link :to="'myCollection'"></router-link>
          </a-menu-item>
          <a-sub-menu>
        <span slot="title" class="submenu-title-wrapper"
        ><a-icon type="star" />我的博客</span
        >
            <a-menu-item key="person">
              <a-icon type="edit" />
              写博客
              <router-link :to="'createblog'"></router-link>
            </a-menu-item>
            <a-menu-item key="setting:2">
              Option 2
              <router-link :to="'details'"></router-link>
            </a-menu-item>
          </a-sub-menu>
          <a-sub-menu>
        <span slot="title" class="submenu-title-wrapper"
        >                <a-avatar size="large" >User</a-avatar>
        </span>
            <a-menu-item key="person">
            <a-icon type="setting" />
            个人中心
            <router-link :to="'setting'"></router-link>
          </a-menu-item>
            <a-menu-item key="logout" @click="quit">
              <a-icon type="logout" />
              退出登录
            </a-menu-item>
          </a-sub-menu>
          

        </a-menu>
      </a-col>

      <a-col  :span="4"  :order="3" id="search">
        <a-input-search
                enter-button="Search"
                size="large"
                @search="onSearch"
        >
        </a-input-search>
      </a-col>
    </a-row>
  </div>
</template>

<script>
  import { mapGetters, mapActions, mapMutations } from 'vuex'
  import searchResult from "./searchResult";
  export default {
    name:'Header',
    data() {
      return {
        current: ['main'],
      };
    },
    computed:{
      ...mapGetters([
              'searchResult'
      ])
    },
    methods: {
      ...mapMutations([
      ]),
      ...mapActions([
        'logout',
        'searchPassage',
      ]),
      onSearch(value) {
        this.searchPassage(value)
        this.$router.push({name:'searchResult',params:{value:value}})
      },
      async quit() {
            await this.$store.dispatch('logout')
            this.$router.push(`/login?redirect=${this.$route.fullPath}`)
        },
      
    },
  };
</script>
<style scoped>
  .logo {
    width: 5%;
    height: 60%;
    background: rgba(255, 255, 255, 0.2);
    float: left;
  }
  #up_menu{
    height: 100%;
    background: rgba(255, 255, 255, 0);
    padding: 1.4% 0 0 0;
    font-size: 120%;
    text-align: right;
  }
  #search{
    padding: 1.2% 0 0 0%;
    text-align: right;
    float: right;
  }
</style>
