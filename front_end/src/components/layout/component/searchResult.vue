<template>
    <div class="collection" >
        <br>
        <h3 style="text-align: left;margin-left: 250px;color: #595959">"{{this.$route.params.value}}"的搜索结果：</h3>
        <h3 style="text-align: left;margin-left: 250px;color: #595959">为您搜索到{{searchResult.length}}条结果。</h3>
        <a-list item-layout="horizontal" size="large" v-bind:data-source="searchResult" style="text-align: left;margin-left: 250px;margin-right: 250px">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <row style="text-align: left;margin-left: 100px;margin-right: 200px">
                    <a-row slot="title" style="text-align: left;margin-left:200px;font-size: 200%" @click="jumpToDetails(item.id)">
                        {{item.title}}
                    </a-row><br>
                    <a-row style="text-align: left;font-size: 120%;overflow:hidden;text-overflow:ellipsis" @click="jumpToDetails(item.id)">
                        {{item.content.substring(0,100)}}...
                    </a-row>
                    <a-col style="color: darkgray;text-align: left"><br>编辑于 {{item.createTime.substring(0,10)}}</a-col>
                    <a-col style="color: darkgray;text-align: right"><a-button  @click="deleteCollection(item.id) " style="color: #192c3e"><a-icon type="star"></a-icon>收藏</a-button></a-col>
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
                'searchResult'
            ])
        },
        methods:{
            jumpToDetails(id){
                this.$router.push({name:'details',params:{Id:id}})
            }
        }
    }
</script>

<style scoped>

</style>