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
                  <a-col :span="15">
                      <div class="static_font">是否公开展示博客</div>
                  </a-col>
                  <a-col :span="9">
                      <a-switch default-checked @change="onChange" />
                  </a-col>
              </a-row>
          </a-col>
          <a-col :span="4" class="wrapper">
          </a-col>
          <a-col :span="7" class="wrapper">
              <a-row :style="{height: '40px'}" type="flex" align="middle">

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
                              <a-icon key="setting" type="setting" />
                              <a-icon key="edit" type="edit" />
                              <a-icon key="ellipsis" type="ellipsis" />
                          </template>
                          <a-card-meta title="Card title" description="This is the description">
                              <a-avatar
                                      slot="avatar"
                                      src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                              />
                          </a-card-meta>
                      </a-card>
                  </a-col>
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
          <a-col :span="3" class="wrapper">
          </a-col>
      </a-row>
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
      }
    },
computed: {
  ...mapGetters([
            'userId',
        ])
  },

    async mounted() {
      await this.getInfo()
    },
    methods: {
      ...mapActions([
      'getUserInfo',
      'updateInfo',
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
      }
    },
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