<template>
    <div>
        <a-row >
          <a-col :span="4">
              <div :style="{ borderRadius: '4px' }" class="calendar">
                <a-calendar :fullscreen="false" @panelChange="onPanelChange"
                />
            </div>
            <div class="personal_info">
                <a-avatar size="large" :src="ava_url" />
                <p>
                    {{userName}}
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
                :src="myUrl"
                />
                  <a-input placeholder="标题" allow-clear v-model="title">
                      <a-icon slot="prefix" type="edit" />
                  </a-input>
                <a-textarea placeholder="内容" :autosize="{minRows: 9, maxRows: 11}" v-model="content"/>
                <template slot="actions">
                <a-icon key="picture" type="picture" @click="showPic" />
                <a-icon key="delete" type="delete" @click="showConfirmDelete"/>
                <a-icon key="setting" type="setting" @click="showSettings" />
                <a-icon key="upload" type="upload" @click="upload"/>
                <a-icon key="save" type="save" @click="save"/>
                </template>
            </a-card>
            <a-modal v-model="setting_visible" title="为你的博客添加标签" @ok="close_setting">
                    <template v-for="(tag, index) in tags">
                        <a-tooltip v-if="tag.length > 20" :key="tag" :title="tag">
                            <a-checkable-tag v-model="checked[index]" :key="tag">
                                {{ `${tag.slice(0, 20)}...` }}
                            </a-checkable-tag>
                        </a-tooltip>
                        <a-checkable-tag v-else v-model="checked[index]" :key="tag" >
                            {{ tag }}
                        </a-checkable-tag>
                    </template>
                    <p>
                            <a-input
                            v-if="inputVisible"
                            ref="input"
                            type="text"
                            size="small"
                            :style="{ width: '78px' }"
                            :value="inputValue"
                            @change="handleInputChange"
                            @blur="handleInputConfirm"
                            @keyup.enter="handleInputConfirm"
                            />
                            <a-tag v-else style="background: #fff; borderStyle: dashed;" @click="showInput">
                            <a-icon type="plus" /> New Tag
                            </a-tag>
                    </p>
                    <p>是否公开展示博客
                    <a-switch v-model="pub" />
                    </p>
            </a-modal>
            <a-modal v-model="picVisible" title="选择封面图片" @ok="closePic">
                <a-upload
                    list-type="picture-card"
                    @change="handleChange1"
                    :customRequest="beginUpload"
                    :show-upload-list="false"
            >
                <img alt="example" style="width: 100%" v-if="uploaded" :src="previewImage" />
                <div v-else>
                    <a-icon type="plus" />
                    <div class="ant-upload-text">
                        Upload
                    </div>
                </div>
            </a-upload>

            </a-modal>

          </a-col>
          <a-col :span="8" >
                <a-card title="Friends" style="width: 70%;margin-left:25%">
                          <a-card-meta>
                              <a-avatar
                                      v-for="Url in this.friendURL"
                                      @click="onThisImage(Url)"
                                      size="large"
                                      slot="avatar"
                                      style="color: white;background-color: #E4E6E9;font-size: 25px;margin-right: 30px">
                                  {{Url.substring(11,16)}}
                              </a-avatar>
                          </a-card-meta>
                </a-card>
                <a-card title="tags" style="width: 70%;margin-left:25%;margin-top:5%">
                    <template v-for="(tag) in userTags">
                        <a-tooltip v-if="tag.length > 20" :key="tag" :title="tag">
                            <a-tag :key="tag">
                            {{ `${tag.slice(0, 20)}...` }}
                            </a-tag>
                        </a-tooltip>
                        <a-tag v-else :key="tag" >
                            {{ tag }}
                        </a-tag>
                    </template>
                </a-card>
                <a-card title="最受欢迎的文章" style="width: 70%;margin-left:25%;margin-top:5%">
                    <a-list :grid="{ gutter: 16, column: 3 }" :data-source="popular">
                        <a-list-item slot="renderItem" slot-scope="item,index">
                        <a-card :title="index+1" v-if="item.title.length<5">
                            {{item.title}}
                        </a-card>
                        <a-card :title="index+1" v-else>
                            {{item.title.substring(0,6)}}
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
import OSS from 'ali-oss'


export default {
    name:'CreateBlog',
    data() {
        return {
            title:"",
            content:"",
            setting_visible:false,
            status:0,
            pub:true,
            tags:[],
            checked:[],
            inputVisible: false,
            inputValue: '',
            picVisible:false,
            client:null,
            previewImage: '',
            myUrl:'https://pinru.oss-cn-shanghai.aliyuncs.com/network_blog/post-bg-rwd.jpg',
            uploaded:false,
            popular:[],
            state:0,
        }
    },
    created() {
            this.client = new OSS({
            region: 'oss-cn-shanghai',
            accessKeyId: 'LTAI4G8SS461QJNzW59evna6',
            accessKeySecret: '0rNlfgSesE8YCB1jqqRYZYxrr1ZMh5',
            bucket: 'pinru',
            secure: false
            })
        },
    computed: {
    ...mapGetters([
                'userId',
                'userBlogs',
                'userTags',
                'userName',
                'friendURL',
                'ava_url',
            ])
    },
    async mounted() {
        await this.getUserBlogs(this.userId);
        await this.getTagsByUser();
        await this.setChecked();
        await this.setpopuplar();
        await this.listCreateTime(this.userId);
        await this.getFriendUrl(this.userId)
        await this.getUserInfo()
        //console.log(this.friendURL)
    },  
    methods: {
        ...mapActions([
            'savePassage',
            'getTagsByUser',
            'getUserBlogs',
            'saveTag',
            'getMostPopularPassages',
            'listCreateTime',
            'getFriendUrl',
            'getUserInfo'
      ]),
        async onThisImage(Url) {
          this.myUrl = Url;
          if (this.state === 0) {
              window.open(this.myUrl)
          } else {
              console.log(this.myUrl)
                await this.deleteFriendUrl(
                    {url:this.myUrl,
                     userId:this.userId});
              location.reload();
          }
          this.state = 0
      },
        onPanelChange(value, mode) {
        console.log(value, mode);
        },
        setChecked(){
            //this.checked=this.userTags;
            this.tags=this.userTags;
            for (let index = 0; index < this.tags.length; index++) {
                this.checked.push(false);
            }
        },
        async setpopuplar(){
            const res=await this.getMostPopularPassages(this.userId);
            this.popular=res;
            console.log(this.popular)
        },
        async save(){
            const passage={
                userId:this.userId,
                title:this.title,
                content:this.content,
                createTime:this.getTime(),
                status:0,
                url:this.myUrl,
            }
            const res=await this.savePassage(passage);

             if(res){
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
            }
            await this.getUserBlogs(this.userId);
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
                url:this.myUrl,
            }
            const res=await this.savePassage(passage)
            if(res){
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
            }
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
            console.log('sett',this.checked)
            this.setting_visible=true;
        },
        showInput() {
            this.inputVisible = true;
            this.$nextTick(function() {
                this.$refs.input.focus();
            });
        },

        handleInputChange(e) {
            this.inputValue = e.target.value;
        },

        handleInputConfirm() {
            const inputValue = this.inputValue;
            let tags = this.tags;
            if (inputValue && tags.indexOf(inputValue) === -1) {
                tags = [...tags, inputValue];
            }
            console.log(tags);
            Object.assign(this, {
                tags,
                inputVisible: false,
                inputValue: '',
            });
            this.checked.push(true);
        },
        showPic(){
            this.picVisible=true;
        },
        getBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
            //console.log(file.thumbUrl)
            });
        },
        async handleChange1(info) {
                info.file.status='done'
                this.uploaded=true;
                this.previewImage=await this.getBase64(info.file.originFileObj);
                console.log('info',info,this.uploaded,this.previewImage)
                //this.fileList = fileList;
                //this.myUrl=fileList[0].thumbUrl;

        },
        async ossUpload (filename, file) {
                let _this = this
                try {
                    let result = await _this.client.multipartUpload(filename, file, {
                    progress: async function (p, checkpoint) {
                        _this.checkpoint = checkpoint
                        _this.percentage = p * 100
                    },
                    checkpoint: _this.checkpoint
                    })
                    console.log(result)
                    _this.myUrl='https://pinru.oss-cn-shanghai.aliyuncs.com'+result.name;
                } catch (e) {
                    console.log(e)
                }
            },
        async beginUpload (file) {
            let _this = this
            let filename = file.file.name
            filename ='/network_blog/'+ filename.split('.')[0] +  '.' + filename.split('.')[1]
            _this.file = file
            _this.filename = filename
            _this.ossUpload(filename, file.file)
        },
        close_setting(){
            this.setting_visible=false;
        },
        closePic(){
            this.picVisible=false;
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