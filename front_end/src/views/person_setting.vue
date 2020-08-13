<template>
  <div>
      <a-row type="flex" style="margin-top: 70px">
          <a-col :span="3" class="wrapper">
          </a-col>
          <a-col :span="7" class="wrapper">
              <a-row :style="{height: '120px'}" type="flex" align="middle">
                  <a-col :span="6">
                      <div class="static_font">昵称</div>
                  </a-col>
                  <a-col :span="18">
                      <a-input size="large" class="input" v-model="userName" placeholder="name" style="width: 100%">
                          <a-icon slot="prefix" type="user" />
                          <a-tooltip slot="suffix" title="Extra information">
                              <a-icon type="info-circle" style="color: rgba(0,0,0,.45)" />
                          </a-tooltip>
                      </a-input>
                  </a-col>
              </a-row>
              <a-row :style="{height: '120px'}" type="flex" align="middle">
                  <a-col :span="6">
                      <div class="static_font">邮箱</div>
                  </a-col>
                  <a-col :span="18">
                      <a-input size="large" class="input" v-model="email" placeholder="mail" style="width: 100%" disabled>
                          <a-icon slot="prefix" type="mail" />
                          <a-tooltip slot="suffix" title="Extra information">
                              <a-icon type="info-circle" style="color: rgba(0,0,0,.45)" />
                          </a-tooltip>
                      </a-input>
                  </a-col>
              </a-row>
              <a-row :style="{height: '120px'}" type="flex" align="middle">
                  <a-col :span="6">
                      <div class="static_font">简介</div>
                  </a-col>
                  <a-col :span="18">
                      <a-input size="large" class="input" v-model="description" placeholder="description" style="width: 100%">
                          <a-icon slot="prefix" type="edit" />
                          <a-tooltip slot="suffix" title="Extra information">
                              <a-icon type="info-circle" style="color: rgba(0,0,0,.45)" />
                          </a-tooltip>
                      </a-input>
                  </a-col>
              </a-row>
              <a-row :style="{height: '120px'}" type="flex" align="middle">
                  <a-col :span="6">
                      <div class="static_font">修改密码</div>
                  </a-col>
                  <a-col :span="18">
                      <a-input-password class="input" size=large placeholder="input password" v-model="password"  style="width: 100%">
                          <a-icon slot="prefix" type="bank" />
                      </a-input-password>
                  </a-col>
              </a-row>
        <a-row :style="{height: '120px'}" type="flex" align="middle">
                  <a-col :span="6">
                      <div class="static_font">上传头像</div>
                  </a-col>
                  <a-col :span="18">
                      <a-button shape="round" type="dashed" icon="upload" @click="modifyAvatar">
                          上传头像
                      </a-button>
                  </a-col>
              </a-row>


<a-modal
            :visible="modifyAvatarVisible"
            title="上传头像"
            cancelText="取消"
            okText="确定"
            @cancel="handleCancel"
            @ok="handleSubmit"
    >
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
        <a-modal :visible="previewVisible" :footer="null" @cancel="handleCancel">
            <img alt="example" style="width: 100%" :src="previewImage" />
        </a-modal>

    </a-modal>


          </a-col>
          <a-col :span="4" class="wrapper">
              <a-row :style="{height: '340px'}" type="flex" align="middle">
              </a-row>
              <a-row :style="{height: '400px'}" type="flex" align="middle">
                  <a-col :span="3">
                  </a-col>
                  <a-col :span="14">
                      <a-button shape="round" type="primary" icon="upload"  @click="submit">
                          提交修改
                      </a-button>
                  </a-col>
              </a-row>
          </a-col>
          <a-col :span="7" class="wrapper">
              <a-row :style="{height: '80px'}" type="flex" align="middle">
                  <a-col :span="3">
                  </a-col>
                  <a-col :span="14">
                      <div class="static_font" :span="14" style="padding-bottom: 20px;">这里是您的友链</div>
                  </a-col>
              </a-row>
              <a-row :style="{height: '300px'}" type="flex" align="middle">
                  <a-col :span="24">
                      <a-card hoverable style="width: 360px">
                          <img
                                  slot="cover"
                                  alt="example"
                                  src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
                          />
                          <template slot="actions" class="ant-card-actions">
                              <a-icon key="edit" type="edit" @click="add"/>
                              <a-icon key="delete" type="delete" @click="del"/>
                          </template>
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
                  </a-col>
              </a-row>
          </a-col>
          <a-col :span="3" class="wrapper">
          </a-col>
      </a-row>
      <a-modal v-model="add_visible" title="输入需要添加的友链连接" @ok="handleOk">
          <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
              <a-form-item label="链接名">
                  <a-input
                          placeholder="请填写友链链接"
                          v-decorator="['url', { rules: [{ required: true, message: '请填写友链链接' }] }]"
                  />
              </a-form-item>
          </a-form>
      </a-modal>
  </div>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex'
import { message } from 'ant-design-vue'
import OSS from 'ali-oss'

function getBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
            //console.log(file.thumbUrl)
        });
    }

export default {
    name: 'Setting',
    data() {
      return {
        userName:"",
        email:"",
        description:"",
        password:"",
        myUrl:{
            userId:"",
            url:''
        },
        state:0,
        previewVisible: false,
        uploaded: false,
        previewImage: '',
        myUrl:'',
        client:null,
        modifyAvatarVisible:false,
        add_visible:false,
        formItemLayout: {
              labelCol: {
                  xs: { span: 12 },
                  sm: { span: 6 },
              },
              wrapperCol: {
                  xs: { span: 24 },
                  sm: { span: 16 },
              },
        },
      }
    },
    beforeCreate() {
        this.form = this.$form.createForm(this, { name: 'addFriendURLModal' });
    },
    created() {
            this.client = new OSS({
            region: 'oss-cn-shanghai',
            
            bucket: 'pinru',
            secure: false
            })
        },
computed: {
  ...mapGetters([
            'userId',
            'friendURL'
        ])
  },

    async mounted() {
      await this.getInfo()
        await this.getFriendUrl(this.userId)
        console.log(this.friendURL)
    },
    methods: {
      ...mapActions([
      'getUserInfo',
      'updateInfo',
          'getFriendUrl',
          'deleteFriendUrl',
          'addFriendUrl',
        'uploadAvatar',
      ]),
      onChange(checked) {
        console.log(`a-switch to ${checked}`);
      },
      async getInfo(){
        const userInfo=await this.getUserInfo();
        //console.log("info:",userInfo);
        this.userName=userInfo.userName;
        this.email=userInfo.email;
        this.description=userInfo.description;
        //this.password=userInfo.password;
      },
      async submit(){
          const data={
            userName:this.userName,
            //email:this.name,
            description:this.description,
            //password:this.password,
          }
          if(this.password!="") data.password=this.password;
          const res=await this.updateInfo(data);
          if(res){
                message.success('修改成功')
            }else{
                message.error('修改失败')
            }
            this.getInfo()
      },
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

      add(){
          this.add_visible=true
      },
        handleOk(e) {
            e.preventDefault();
            this.form.validateFieldsAndScroll((err, values) => {
                if (!err) {
                    const data = {
                        url: this.form.getFieldValue('url'),
                        userId: Number(this.userId),
                    }
                    this.addFriendUrl(data);
                    this.add_visible=false;
                    location.reload()
                }
            });
        },
      del(){
          this.state=1;
          message.success("请点击需要删除的友链图标")
      },
      modifyAvatar(){
          this.modifyAvatarVisible=true;
      },

        async handleSubmit(e){
                e.preventDefault();
               
                console.log('myurl',this.myUrl)
                this.modifyAvatarVisible=false;
                await this.uploadAvatar(this.myUrl)

            },
            handleCancel() {
                this.previewVisible = false;
                this.modifyAvatarVisible=false;
            },
            
            async handleChange1(info) {
                info.file.status='done'
                this.uploaded=true;
                this.previewImage=await getBase64(info.file.originFileObj);
                console.log('info',info,this.uploaded,this.previewImage)
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


    }
}
</script>

<style scoped>
    .wrapper{
        height: 700px;
    }
.static_font{
    font-size: 20px;
}
.input{
    width: 40%;
    float: left;
}
</style>