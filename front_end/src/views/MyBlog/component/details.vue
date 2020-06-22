<template>
    <a-layout>
        <a-layout-content>
            <div class="details" style="margin-bottom: 40px">
                <a-row class="information" style="text-align: left;margin-left: 250px;margin-right: 100px;margin-top: 50px">
                    <a-col class="'userLogo'" :span="2" >
                        <img src="../../../assets/icon.jpg" height="70" width="70" />
                    </a-col>
                    <a-col class="'userName'" style="text-align:left;margin-left: 20px;;margin-top: 5px">
                        <span class="'name'" style="font-size: large;color: darkgray" >{{passageDetail.userName}}</span><br>
                        <span class="'time'" style="font-size: large;color: darkgray">发表于 {{passageDetail.createTime.substring(0,10)}} {{passageDetail.createTime.substring(11,19)}}</span>
                        <span class="collect" style="text-align: right;margin-left: 570px;font-size: medium;font-style: inherit" v-if="!inCollection"><a-icon type="star" key="star" @click="addtoCollection(passageDetail.id) " style="font-size: xx-large;color:black"/> </span>
                        <span class="delCollect" style="text-align: right;margin-left: 570px;font-size: medium;font-style: inherit" v-else><img src="../../../assets/shoucang.png" height="35" width="35" @click="delCollection(passageDetail.id)"/></span>
                    </a-col>
                </a-row>
                <h1 class="'title'" style="text-align: left;margin-left: 250px;align-self: auto;font-size:25px;margin-top: 30px">{{passageDetail.title}}</h1>
                <a-row class="tag" style="text-align: left;margin-left: 250px;margin-top: 20px">
                    <template v-for="tag in this.tags">
                        <a-tag style="font-size: medium" color="#abc2e8">{{tag.tagName}}</a-tag>
                    </template>
                </a-row>
                <a-row class="text" style="text-align:left;margin-right: 300px;margin-left: 250px;font-size: large;margin-top: 20px">
                    <a-col span="6">
                        <img :src="passageDetail.url" height="200px" width="200px"></img>
                    </a-col>
                    <a-col> &ensp;&ensp;{{passageDetail.content}}</a-col>
                </a-row><br><br>


                <a-row style="text-align: left;margin-left: 250px;font-size: x-large;color: darkslategray">
                        <a @click="addComment(passageDetail.id) " style="color: darkslategray">
                                <a-icon type="book" style="margin-right: 10px;font-size: 90%"/>评论
                        </a>
                </a-row>
                <a-row>
                    <hr style="width: 30%;margin-left: 250px;margin-top: 5px">
                </a-row>
                <a-list v-bind:data-source="commentList" style="text-align: left;margin-left: 150px;margin-right: 150px">
                    <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                        <row style="text-align: left;margin-left: 100px;margin-right: 200px">
                            <a-row class="information" style="text-align: left">
                                <a-col class="'userName'" style="text-align:left;">
                                    <span><a-icon type="user" style="font-size:250%;margin-right: 5px"></a-icon></span>
                                    <span class="'name'" style="font-size: medium;color: darkgray" >{{item.userName}}</span>
                                    <span class="'time'" style="font-size: medium;color: darkgray;margin-left: 20px">{{item.commentTime.substring(0,10)}}  {{item.commentTime.substring(11,19)}}
                            </span>
                                </a-col>
                            </a-row>
                            <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis;margin-top: 10px" @click="jumpToDetails(item.id)">
                                {{item.content}}
                            </a-row><br>
                        </row>
                    </a-list-item>
                </a-list>
                <a-row>
                        <a-col :span="24" style="text-align: center">
                            <a-textarea placeholder="想对作者说些什么？" style="width: 930px;height: 150px;font-size: 20px;margin-left: -60px" v-model="comment"></a-textarea>
                        </a-col>
                </a-row>
                 <a-row style="margin-top: 30px">
                        <a-col :span="24" style="text-align: center">
                            <span><a-button @click="addNewComment(passageDetail.id,userId,userName)" style="margin-left: -40px">发表评论</a-button></span>
                        </a-col>
                 </a-row>
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
                comment:'',
            }
        },
        computed:{
          ...mapGetters([
              'passageDetail',
              'commentList',
              'userId',
              'inCollection',
              'userName',
              'tags'
          ])
        },
        async mounted() {
            const collect = {
                userId: this.userId,
                passageId: this.passageDetail.id
            }
            this.isInCollection(collect)
            await this.getPassageTags(this.passageDetail.id)
        },
        methods:{
            ...mapActions([
                'addCollection',
                'getCommentList',
                'addComment',
                'deleteCollection',
                'isInCollection',
                'getPassageTags'
            ]),
            addtoCollection(id){
                this.addCollection(id)
            },
            getComment(id){
                this.getCommentList(id)
            },
            addNewComment(id,userid,username){
                console.log(this.comment)
                const comment={
                    passageId:id,
                    userId:userid,
                    userName:username,
                    content:this.comment,
                    commentTime:new Date()
                }
                this.addComment(comment)
                this.comment=''
            },
            delCollection(id){
                this.deleteCollection(id)
                this.isInCollection(
                    {userId:this.userId,
                    passageId:this.passageDetail.id
                    })
            }
        }
    }
</script>

<style scoped>
    .details{
        white-space: pre-line;
    }
</style>