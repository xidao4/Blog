<template>
    <div>
        <a-row >
          <a-col :span="4">
              <div :style="{ borderRadius: '4px' }" class="calendar">
                <a-calendar :fullscreen="false" @panelChange="onPanelChange"  />
            </div>
            <div class="personal_info">
                <a-avatar size="large" icon="user" />
                <p>
                    serenity,
                </p>
                <p>
                    这是您的第{{userBlogs.length+1}}篇blog
                </p>
            </div>
          </a-col>
          <a-col :span="12">
            <a-card hoverable class="whole_card">
                <img
                slot="cover"
                alt="example"
                src="../../assets/post-bg-re-vs-ng2.jpg"
                />
                  <a-input placeholder="标题" allow-clear v-model="title">
                      <a-icon slot="prefix" type="edit" />
                  </a-input>
                <a-textarea placeholder="内容" :autosize="{minRows: 9, maxRows: 11}" v-model="content"/>
                <template slot="actions">
                <a-icon key="picture" type="picture" />
                <a-icon key="delete" type="delete" @click="showConfirmDelete"/>
                <a-icon key="setting" type="setting" @click="showSettings" />
                <a-icon key="upload" type="upload" @click="upload"/>
                <a-icon key="save" type="save" @click="save"/>
                </template>
            </a-card>
            <a-modal v-model="setting_visible" title="为你的博客添加标签" @ok="handleOk">
            <p>Some contents...</p>
            <p>Some contents...</p>
            <p>是否公开展示博客
                <a-switch v-model="pub" />
            </p>
            </a-modal>
          </a-col>
          <a-col :span="8" >
                <a-card title="Friends" style="width: 70%;margin-left:25%">
                <p>
                    <a-icon type="github" style="font-size: 30px"></a-icon>
                </p>
                <p>
                    <a-icon type="zhihu" style="font-size: 30px"></a-icon>
                </p>
                <!-- <p>
                    <a-icon type="linkedin" style="font-size: 30px"></a-icon>
                </p> -->
                </a-card>
                <a-card title="tags" style="width: 70%;margin-left:25%;margin-top:5%">
                    <a-tag>Tag 1</a-tag>
                    <a-tag>Tag 1</a-tag>
                    <a-tag>Tag 1</a-tag>
                    <a-tag>Tag 1</a-tag>
                    <a-tag>Tag 1</a-tag>
                    <a-tag>Tag 1</a-tag>
                    <a-tag>Tag 1</a-tag>
                </a-card>
                <a-card title="passages" style="width: 70%;margin-left:25%;margin-top:5%">
                    <a-list :grid="{ gutter: 16, column: 3 }" :data-source="data">
                        <a-list-item slot="renderItem" slot-scope="item">
                        <a-card :title="'num'">
                            {{item.title}}
                        </a-card>
                        </a-list-item>
                    </a-list>
                </a-card>
          </a-col>
        </a-row>
        
    </div>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex'
import {message} from 'ant-design-vue'
const data = [
  {
    title: 'Title 1',
  },
  {
    title: 'Title 2',
  },
  {
    title: 'Title 3',
  },
];
export default {
    name:'CreateBlog',
    data() {
        return {
            data,
            title:"",
            content:"",
            setting_visible:false,
            status:0,
            pub:true,
        }
    },
    computed: {
    ...mapGetters([
                'userId',
                'userBlogs',
                'userTags',
            ])
    },
    async mounted() {
        this.getTagsByUser();
    },  
    methods: {
        ...mapActions([
            'savePassage',
            'getTagsByUser',
      ]),

        onPanelChange(value, mode) {
        console.log(value, mode);
        },
        async save(){
            const passage={
                userId:this.userId,
                title:this.title,
                content:this.content,
                createTime:this.getTime(),
                status:0,
            }
            const res=await this.savePassage(passage);

             if(res){
                //this.message.success("暂存成功")
                //console.log('res',res)
                this.title='';
                this.content=''
            } 
        },
        async upload(){
            var status=1;
            if(this.pub==false){
                status=2
            }
            const passage={
                userId:this.userId,
                title:this.title,
                content:this.content,
                createTime:this.getTime(),
                status:status,
            }
            const res=await this.savePassage(passage)
            if(res){
                this.title='';
                this.content=''
                //this.message.success("上传成功")
            } 
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
        showConfirmDelete() {
            var that=this
            this.$confirm({
            title: '确定删除这篇博客吗？',
            content: '确认后，您的内容将丢失',
            onOk() {
                that.title='';
                that.content='';
            },
            onCancel() {},
        });
        },
        showSettings(){
            this.setting_visible=true;
        }

    },
}
</script>

<style scoped>
.whole_card{
width: 98%;
height: 100%;
margin: 0 0 0 10%;
}
.calendar{
    float:left;
    border: 1px solid #d9d9d9;
    width: 300px;
}
.personal_info{
    margin: 0% 0 0 15%;
    font-size: 30px;
}
</style>