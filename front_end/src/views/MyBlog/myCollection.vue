<template>
    <div class="collection" >
        <br>
        <a-list item-layout="horizontal" size="large" v-bind:data-source="collection" style="text-align: left;margin-left: 150px;margin-right: 150px">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <row style="text-align: left;margin-left: 150px;margin-right: 150px;">
                    <br>
                    <a slot="title" @click="jumpToDetails(item.id)" style="text-align: left;font-size: 200%;color:#2e2e2e" v-if="item.title.length<13">
                        {{item.title}}
                    </a>
                    <a slot="title"  @click="jumpToDetails(item.id)" style="text-align: left;font-size: 200%;color:#2e2e2e" v-else>
                        {{item.title.substring(0,13)}}...
                    </a>
                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis;margin-top: 20px" @click="jumpToDetails(item.id)" >
                        <a-col span="5">
                            <img src="../../assets/post-bg-swift.jpg" height="100" width="120"/>
                        </a-col>
                        <a-col  v-if="item.content.length>150">
                            <span>    {{item.content.substring(0,150)}}...</span>
                        </a-col>
                        <a-col style="margin-left: 140px" v-else>
                            <span>{{item.content}}</span>
                        </a-col>
                    </a-row>
                    <a-row>
                        <a-col style="color: darkgray;text-align: left" :span="12"><br>创建于 {{item.createTime.substring(0,10)}}</a-col>
                        <a-col style="color: darkgray;text-align: right;padding-right:10px;margin-top: 10px" :span="12"><a-button  @click="delCollection(item.id) " style="color: #192c3e"><a-icon type="star"></a-icon>取消收藏</a-button></a-col>
                    </a-row>
                    <a-row>
                        <hr style="width: 100%;margin-top: 20px">
                    </a-row>
                </row>
            </a-list-item>
        </a-list>
    </div>
</template>

<script>
    import {mapGetters,mapMutations,mapActions} from 'vuex';
    export default {
        name: "myCollection",
        data(){
            return{

            }
        },
        async created() {
           await this.getCollection()
        },
        computed:{
            ...mapGetters([
                'collection'
            ])
        },
        methods:{
            ...mapActions([
                'getCollection',
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