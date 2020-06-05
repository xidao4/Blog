<template>
    <a-layout>
        <a-layout-content>
            <div class="details">
                <a-row class="information" style="text-align: left;margin-left: 250px;margin-right: 100px;margin-top: 50px">
                    <a-col class="'userLogo'" span="3" >
                        <img src="../../../assets/icon.jpg" height="100" width="100" />
                    </a-col>
                    <a-col class="'userName'" style="text-align:left;margin-left: 20px;"><br><br>
                        <span class="'name'" style="font-size: large;color: darkgray" >Mr.林娟娟</span><br>
                        <span class="'time'" style="font-size: large;color: darkgray">发表于 {{passageDetail.createTime.substring(0,10)}}</span>
                    </a-col>
                    <a-col style="text-align: right;margin-right: 200px">
                        <a-button >收藏</a-button>
                    </a-col>
                </a-row>
                <h1 class="'title'" style="text-align: left;margin-left: 250px;margin-top: 20px;align-self: auto;font-size: xx-large">{{passageDetail.title}}</h1><br>
                <a-row class="text" style="text-align:left;margin-right: 300px;margin-left: 250px;font-size: large">
                    &ensp;&ensp;{{passageDetail.content}}
                </a-row><br><br>
                <a-menu  >
                    <a-menu-item key="1" >
                        <a-col style="text-align: left;margin-left: 250px">
                            <router-link to="reviews">
                                <a-icon type="user" />评论
                            </router-link>
                        </a-col>
                    </a-menu-item>
                    <a-col style="text-align: right;margin-right: 300px">
                        <a-button type="primary">发表评论</a-button>
                    </a-col>
                </a-menu>
            </div>
        </a-layout-content>
    </a-layout>
</template>

<script>
    import {mapGetters} from 'vuex';
    export default {
        name: "details",
        data(){
            return{

            }
        },
        computed:{
          ...mapGetters([
              'passageDetail'
          ])
        },
    }
</script>

<style scoped>

</style>