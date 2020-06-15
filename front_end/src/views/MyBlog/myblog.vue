<template>
    <div class="collection" >
        <br>
        <a-list item-layout="horizontal" size="large" v-bind:data-source="userBlogs" style="text-align: left;margin-left: 250px;margin-right: 250px">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <row style="text-align: left;margin-left: 100px;margin-right: 200px">
                    <br>
                    <a slot="title"  @click="jumpToDetails(item.id)" style="text-align: left;font-size: 200%;color:gray" v-if="item.title.length<10">
                        {{item.title}}
                    </a>
                    <a slot="title"  @click="jumpToDetails(item.id)" style="text-align: left;font-size: 200%;color:gray" v-else>
                        {{item.title.substring(0,10)}}...
                    </a>
                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis" @click="jumpToDetails(item.id)" v-if="item.content.length>100">
                        {{item.content.substring(0,100)}}...
                    </a-row>
                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis" @click="jumpToDetails(item.id)" v-else>
                        {{item.content}}
                    </a-row>
                    <a-col style="color: darkgray;text-align: left"><br>创建于 {{item.createTime.substring(0,10)}}</a-col>
                    <a-col style="color: darkgray;text-align: right"><a-button  @click="delCollection(item.id) " style="color: #192c3e"><a-icon type="star"></a-icon>取消收藏</a-button></a-col>
                </row>
            </a-list-item>
        </a-list>
    </div>
</template>

<script>
    import {mapGetters,mapMutations,mapActions} from 'vuex';
    export default {
        name: "myBlog",
        data(){
            return{

            }
        },
        async created() {
           await this.getUserBlogs(this.userId)
        },
        computed:{
            ...mapGetters([
                'userId',
                'userBlogs'
            ])
        },
        methods:{
            ...mapActions([
                'getUserBlogs',
                'getPassage',
                'getCommentList',
                'deleteCollection'
            ]),
            jumpToDetails(id){
                this.getPassage(id)
                this.getCommentList(id)
                this.$router.push({name:'details'})
            },
            delCollection(id){
                this.deleteCollection(id)
            }
        }
    }
</script>

<style scoped>

</style>