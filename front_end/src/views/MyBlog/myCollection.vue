<template>
    <div class="collection" >
        <a-list item-layout="horizontal" size="large">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <a-list-item-meta>
                    <a slot="title" @click=jumpToDetails(item.id) style="position:relative;top: 10px;left:45px;font-size: 200%">{{item.title}}</a>
                    <span  slot="description" style="position:absolute;margin-top:30px;margin-left:40px;color: black;white-space: pre">{{item.details}}}<br><br></span>
                    <a-row>
                        <a-col style="color: darkgray">{{item.userId}} 编辑于 {{item.time}}</a-col>
                        <a-col style="color: darkgray"><a-button @click="deleteCollection(item.id)">取消收藏</a-button></a-col>
                    </a-row>
                </a-list-item-meta>
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
        computed:{
            ...mapGetters([
                'Collection'
            ])
        }

    }
</script>

<style scoped>

</style>