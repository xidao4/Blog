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
                <a-row style="text-align: left;margin-left: 250px;font-size: x-large;color: darkslategray">
                        <a @click="addComment(passageDetail.id) " style="color: darkslategray">
                                <a-icon type="book"/>评论
                        </a>
                </a-row>
                <a-list v-bind:data-source="commentList" style="text-align: left;margin-left: 200px;margin-right: 250px">
                    <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                        <row style="text-align: left;margin-left: 100px;margin-right: 200px">
                            <a-row class="information" style="text-align: left">
                                <a-col class="'userName'" style="text-align:left;">
                                    <span><a-icon type="user" style="font-size:300%"></a-icon></span>
                                    <span class="'name'" style="font-size: medium;color: darkgray" >Mr.林娟娟</span>
                                    <span class="'time'" style="font-size: medium;color: darkgray;margin-left: 20px">{{item.commentTime.substring(0,10)}}  {{item.commentTime.substring(11,19)}}
                            </span>
                                </a-col>
                            </a-row><br>
                            <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis" @click="jumpToDetails(item.id)">
                                {{item.content}}
                            </a-row><br>
                        </row>
                    </a-list-item>
                </a-list>
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
              'commentList',
          ])
        },
        methods:{
            ...mapActions([
                'addCollection',
                'getCommentList'
            ]),
            addtoCollection(id){
                this.addCollection(id)
            },
            getComment(id){
                this.getCommentList(id)
            }
        }
    }
</script>

<style scoped>

</style>