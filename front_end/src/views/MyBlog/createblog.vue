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
                    这是您的第100篇blog
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
                <a-icon key="delete" type="delete" />
                <a-icon key="setting" type="setting" />
                <a-icon key="upload" type="upload" />
                <a-icon key="save" type="save" @click="save"/>
                </template>
            </a-card>
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
        }
    },
    computed: {
    ...mapGetters([
                'userId',
            ])
    },  
    methods: {
        ...mapActions([
            'savePassage',
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
            }
            await this.savePassage(passage);
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