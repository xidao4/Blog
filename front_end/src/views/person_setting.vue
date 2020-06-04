<template>
  <div>
    <a-row :style="{height: '80px'}" type="flex" align="middle">
      <a-col :span="4">
        <div class="static_font">昵称</div>
      </a-col>
      <a-col :span="12">
        <a-input size="large" class="input" v-model="userName" placeholder="name">
            <a-icon slot="prefix" type="user" />
            <a-tooltip slot="suffix" title="Extra information">
            <a-icon type="info-circle" style="color: rgba(0,0,0,.45)" />
            </a-tooltip>
        </a-input>
      </a-col>
    </a-row>

    <a-row :style="{height: '250px'}" type="flex" align="middle">
      <a-col :span="4">
        <div class="static_font">邮箱</div>
      </a-col>
      <a-col :span="12">
        <a-input size="large" class="input" v-model="userName" placeholder="mail">
            <a-icon slot="prefix" type="mail" />
            <a-tooltip slot="suffix" title="Extra information">
            <a-icon type="info-circle" style="color: rgba(0,0,0,.45)" />
            </a-tooltip>
        </a-input>
      </a-col>
      <a-col :span="8">
        <a-card hoverable style="width: 300px">
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

    <a-row :style="{height: '90px'}" type="flex" align="middle">
      <a-col :span="4">
        <div class="static_font">简介</div>
      </a-col>
      <a-col :span="12">
        <a-input size="large" class="input" v-model="description" placeholder="description">
            <a-icon slot="prefix" type="edit" />
            <a-tooltip slot="suffix" title="Extra information">
            <a-icon type="info-circle" style="color: rgba(0,0,0,.45)" />
            </a-tooltip>
        </a-input>
      </a-col>
    </a-row>

    <a-row :style="{height: '100px'}" type="flex" align="middle">
      <a-col :span="4">
        <div class="static_font">修改密码</div>
      </a-col>
      <a-col :span="12">
        <a-input-password class="input" size=large placeholder="input password">
                <a-icon slot="prefix" type="bank" />
        </a-input-password>
      </a-col>
    </a-row>

    <a-row :style="{height: '155px'}" type="flex" align="middle">
      <a-col :span="5">
        <div class="static_font">是否公开展示博客</div>
      </a-col>
      <a-col :span="5">
            <a-switch default-checked @change="onChange" />
      </a-col>
      <a-col :span="14">
          <a-button shape="round" type="primary" icon="upload" :size="size">
            提交修改
        </a-button>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
    name: 'Setting',
    methods: {
        onChange(checked) {
            console.log(`a-switch to ${checked}`);
        },
    },
}
</script>

<style scoped>
.static_font{
    font-size: 20px;
}
.input{
    width: 40%;
    float: left;
}
</style>