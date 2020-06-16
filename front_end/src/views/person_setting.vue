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
          </a-col>
          <a-col :span="4" class="wrapper">
              <a-row :style="{height: '340px'}" type="flex" align="middle">
              </a-row>
              <a-row :style="{height: '400px'}" type="flex" align="middle">
                  <a-col :span="3">
                  </a-col>
                  <a-col :span="14">
                      <a-button shape="round" type="primary" icon="upload" :size="size" @click="submit">
                          提交修改
                      </a-button>
                  </a-col>
              </a-row>
          </a-col>
          <a-col :span="7"class="wrapper">
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
                                      @click="onThisImage(Url)"
                                      style="backgroundColor:#87d068"
                                      icon="user"
                              />
                              <a-avatar>USER</a-avatar>
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
          'addFriendUrl'
      ]),
      onChange(checked) {
        console.log(`a-switch to ${checked}`);
      },
      async getInfo(){
        const userInfo=await this.getUserInfo();
        //console.log("info:",userInfo);
        this.userName=userInfo.userName;
        this.email=userInfo.email;
        this.description="hello world";
        this.password=userInfo.password;
      },
      async submit(){
          const data={
            userName:this.userName,
            //email:this.name,
            description:this.description,
            password:this.password,
          }
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
              window.open(this.myUrl.url)
          } else {
                await this.deleteFriendUrl(this.myUrl);
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
                }
            });
        },
      del(){
          this.state=1;
          message.success("请点击需要删除的友链图标")
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