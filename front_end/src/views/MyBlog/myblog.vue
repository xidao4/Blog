<template>
    <div class="collection" >
        <br>
        <a-list item-layout="horizontal" size="large" v-bind:data-source="userBlogs" style="text-align: left;margin-left: 150px;margin-right: 150px">
            <a-list-item slot="renderItem" slot-scope="item" key="item.id" >
                <a-row style="text-align: left;margin-left: 150px;margin-right: 150px;">
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
                        <a-col style="color: darkgray;text-align: right;padding-right:10px;margin-top: 10px" :span="6">
                            <a-button v-if="item.status==0" @click="showEdit" style="color: #192c3e"><a-icon type="edit"></a-icon>编辑</a-button>
                            <a-modal v-model="editVisible" title="继续编辑" @ok="save(item)">
                                <a-input placeholder="标题" allow-clear v-model="item.title">
                                    <a-icon slot="prefix" type="edit" />
                                </a-input>
                                <a-textarea placeholder="内容" :autosize="{minRows: 9, maxRows: 11}" v-model="item.content"/>
                            </a-modal>

                        </a-col>
                        <a-col  style="color: darkgray;text-align: right;padding-right:10px;margin-top: 10px" :span="6"  >
                            <a-button v-if="!inCollections[item.id]"  @click="addtoCollection(item.id) " style="color: #192c3e"><a-icon type="star"></a-icon>收藏</a-button>
                            <a-button v-else @click="delCollection(item.id)" style="color: #192c3e"><a-icon type="star"></a-icon>取消收藏</a-button>
                        </a-col>
                    </a-row>
                    <a-row>
                        <hr style="width: 100%;margin-top: 20px">
                    </a-row>
                </a-row>
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
                inCollections:{},
                editVisible:false,
            }
        },
        async mounted() {
           //await this.getUserBlogs(this.userId)
           await this.getCollected()
        },
        computed:{
            ...mapGetters([
                'userId',
                'userBlogs'
            ]),

        },
        methods:{
            ...mapActions([
                'getUserBlogs',
                'getPassage',
                'getCommentList',
                'deleteCollection',
                'isInCollection',
                'addCollection',
                'updatePassage'
            ]),
            jumpToDetails(id){
                this.getPassage(id)
                this.getCommentList(id)
                this.$router.push({name:'details'})
            },
            async delCollection(id){
                await this.deleteCollection(id)
                await this.getUserBlogs(this.userId)
            },
            async judgeCollected(id){
                const data={
                    userId:this.userId,
                    passageId:id,
                }
                const res=await this.isInCollection(data)
                //console.log('ret',res)
                return res;
            },
            async addtoCollection(id){
                console.log(this.inCollections)
                await this.addCollection(id)
                await this.getUserBlogs(this.userId)
            },
            async getCollected(){
                const passages=await this.getUserBlogs(this.userId);
                const that=this
                for (var passage in passages) {
                    var temp=passages[passage].id
                   /*  const data={
                        temp:this.judgeCollected(temp),
                    } */
                    that.inCollections[temp]=await this.judgeCollected(temp)
                }
                console.log('collect',this.inCollections)
                await this.getUserBlogs(this.userId)
            },
            showEdit(){
                this.editVisible=true;
            },
            async save(passage){
            //passage[RecentEditTime]=this.getTime()
            passage={
                ...passage,
                RecentEditTime:this.getTime()
            }
            console.log(passage)
            const res=await this.updatePassage(passage);

             /* if(res){
                //this.message.success("暂存成功")
                //console.log('res',res)
                this.title='';
                this.content=''
                await this.getUserBlogs(this.userId);
            }
            for (let index = 0; index < this.checked.length; index++) {
                if(this.checked[index]){
                    let tagData={
                        tagName:this.tags[index],
                        passageId:this.userBlogs[this.userBlogs.length-1].id,
                        userId:this.userId
                    }
                    await this.saveTag(tagData);
                }
            } */
            this.editVisible=false;
            await this.getUserBlogs(this.userId);
        },
        getTime(){
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = '0' + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = '0' + strDate;
            }
            var currentdate = year + '-' + month + '-' + strDate;
            return currentdate
        },
        }
    }
</script>

<style scoped>

</style>
