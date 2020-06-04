<template>
    <div class="collection" >
        <h3 style="text-align: left;margin-left: 50px">"{{this.$route.params.value}}"的搜索结果：</h3>
        <h3 style="text-align: left;margin-left: 50px">为您搜索到xx条结果。</h3>

        <a-list item-layout="horizontal" size="large" v-bind:data-source="searchResult">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <a-list-item-meta>
                    <a slot="title" @click=jumpToDetails(item.id) style="position:relative;top: 10px;left:45px;font-size: 200%">{{item.title}}</a>
                    <span  slot="description" style="position:absolute;margin-top:30px;margin-left:40px;color: black;white-space: pre">{{item.content}}}<br><br></span>
                    <a-row>
                        <a-col style="color: darkgray">{{item.userId}} 编辑于 {{item.createTime}}</a-col>
                        <a-col style="color: darkgray"><a-button @click="deleteCollection(item.id)">取消收藏</a-button></a-col>
                    </a-row>
                </a-list-item-meta>
            </a-list-item>
        </a-list>
    </div>
</template>

<script>
    import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default {
        name: "searchResult",
        data(){

        },
        computed:{
            ...mapGetters([
                'searchResult'
            ])
        },
        methods:{

        }
    }
</script>

<style scoped>

</style>