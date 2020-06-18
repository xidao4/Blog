<template>
    <div class="collection" >
        <br>
        <h3 style="text-align: left;margin-left: 300px;color: #2c3e50">"{{this.$route.params.value}}"的搜索结果：</h3>
        <h3 style="text-align: left;margin-left: 300px;color: #2c3e50">为您搜索到{{searchResult.length}}条结果^ _ ^</h3>
        <a-list item-layout="horizontal" size="large" v-bind:data-source="searchResult" style="text-align: left;margin-left: 150px;margin-right: 150px">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <row style="text-align: left;margin-left: 150px;margin-right: 150px">
                    <br>
                    <div style="display: flex;padding-right: 15px">
                        <a slot="title" @click="jumpToDetails(item.id,userId)" style="margin-right: auto;text-align: left;font-size: 200%;color:#2e2e2e" v-if="item.title.length<10">
                            {{item.title}}
                        </a>
                        <a slot="title"  @click="jumpToDetails(item.id,userId)" style="margin-right: auto;text-align: left;font-size: 200%;color:#2e2e2e" v-else>
                            {{item.title.substring(0,10)}}...
                        </a>
                        <div style="color: #192c3e;font-size: x-large"><a-icon type="star" @click="addtoCollection(item.id) "></a-icon></div>
                    </div>
                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis;margin-top: 20px" @click="jumpToDetails(item.id)" v-if="item.content.length>100">
                        {{item.content.substring(0,150)}}...
                    </a-row>
                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis;margin-top: 20px" @click="jumpToDetails(item.id)" v-else>
                        {{item.content}}
                    </a-row>
                    <a-col style="color: darkgray;text-align: left"><br>编辑于 {{item.createTime.substring(0,10)}}</a-col>
                    <hr style="margin-top: 20px">
                </row>
            </a-list-item>
        </a-list>
    </div>
</template>

<script>
    import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default {
        name: "searchResult",
        data(){
            return {

            }
        },
        computed:{
            ...mapGetters([
                'searchResult',
                'userId'
            ])
        },
        methods:{
            ...mapActions([
                'addCollection',
                'getPassage',
                'getCommentList',
                'updateInCollection'
            ]),
            jumpToDetails(id,userid){
                this.getCommentList(id)
                this.getPassage(id)
                this.updateInCollection(id,userid)
                this.$router.push({name:'details'})
            },
            addtoCollection(id){
                this.addCollection(id)
            }
        }
    }
</script>

<style scoped>


</style>