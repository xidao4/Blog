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
                        <span class="collect" style="text-align: right;margin-left: 400px;font-size: medium;font-style: inherit"><a-icon type="star" key="star" @click="addtoCollection(passageDetail.id) " style="font-size: xx-large;color:black"/> </span>
                    </a-col>
                </a-row>
                <br>
                <h1 class="'title'" style="text-align: left;margin-left: 250px;margin-top: 20px;align-self: auto;font-size: xx-large">{{passageDetail.title}}</h1><br>
                <a-row class="text" style="text-align:left;margin-right: 300px;margin-left: 250px;font-size: large">
                    &ensp;&ensp;{{passageDetail.content}}
                </a-row><br><br>
                <a-menu  >
                    <a-menu-item key="1" >
                        <a-col style="text-align: left;margin-left: 250px">
                                <a-icon type="user" />评论
                            <a-button type="primary" style="margin-left: 600px">发表评论</a-button>
                        </a-col>
                        <a-list item-layout="horizontal" size="large" v-bind:data-source="commentList" style="text-align: left;margin-left: 250px;margin-right: 250px">
                            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                                <row style="text-align: left;margin-left: 100px;margin-right: 200px">
                                    <br>
                                    <a-row class="information" style="text-align: left;margin-left: 250px;margin-right: 100px;margin-top: 50px">
                                        <a-col class="'userLogo'" span="3" >
                                            <a-icon type="user" style="font-size: x-large"></a-icon>
                                        </a-col>
                                        <a-col class="'userName'" style="text-align:left;margin-left: 20px;"><br><br>
                                            <span class="'name'" style="font-size: large;color: darkgray" >Mr.林娟娟</span><br>
                                            <span class="'time'" style="font-size: large;color: darkgray">发表于 {{item.commentTime.substring(0,10)}}</span>
                                            <span class="collect" style="text-align: right;margin-left: 400px;font-size: medium;font-style: inherit"><a-icon type="star" key="star" @click="addtoCollection(passageDetail.id) " style="font-size: xx-large;color:black"/> </span>
                                        </a-col>
                                    </a-row>
                                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis" @click="jumpToDetails(item.id)">
                                        {{item.content}}
                                    </a-row>
                                </row>
                            </a-list-item>
                        </a-list>
                    </a-menu-item>
                </a-menu>
            </div>
        </a-layout-content>
    </a-layout>
</template>

<script>
    import {mapGetters,mapActions} from 'vuex';
    export default {
        name: "details",
        data(){
            return{

            }
        },
        computed:{
          ...mapGetters([
              'passageDetail',
              'commentList'
          ])
        },
        methods:{
            ...mapActions([
                'addCollection',
            ]),
            addtoCollection(id){
                this.addCollection(id)
            }
        }
    }
</script>

<style scoped>

</style>