<template>
    <div>
        <a-row type="flex" justify="center" :style="{height: '300px'}" align="middle">
          <a-col :span="12">
            <a-icon type="user" :style="{fontSize:'100px'}" />
          </a-col>
        </a-row>
        <a-row type="flex" justify="center" :style="{height: '375px'}">
          <a-col :span="7">
            <a-form
                id="components-form-demo-normal-login"
                :form="form"
                class="login-form"
                @submit="handleSubmit"
            >
                <a-form-item>
                <a-input
                    v-decorator="[
                    'userName',
                    { rules: [{ required: true, message: 'Please input your username!' }] },
                    ]"
                    placeholder="Username"
                >
                    <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
                </a-input>
                </a-form-item>
                <a-form-item>
                <a-input
                    v-decorator="[
                    'password',
                    { rules: [{ required: true, message: 'Please input your Password!' }] },
                    ]"
                    type="password"
                    placeholder="Password"
                >
                    <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
                </a-input>
                </a-form-item>
                <a-form-item>
                <a-checkbox
                    v-decorator="[
                    'remember',
                    {
                        valuePropName: 'checked',
                        initialValue: true,
                    },
                    ]"
                    class="login-form-remember"
                >
                    Remember me
                </a-checkbox>
                <a class="login-form-forgot" href="">
                    Forgot password
                </a>
                </a-form-item>
                <a-form-item>
                <a-button type="primary" html-type="submit" class="login-form-button">
                    Log in
                </a-button>
                </a-form-item>
                <a-form-item>
                <a @click="showModal">
                    register now!
                </a>
                <a-modal v-model="visible" title="注册账号" @ok="handleOk" :footer="null">
                    <a-form :form="registerform" @submit="handleSubmitOfRegister">
                        <a-form-item v-bind="formItemLayout" label="邮箱">
                        <a-input
                            v-decorator="[
                            'email',
                            {
                                rules: [
                                {
                                    type: 'email',
                                    message: 'The input is not valid E-mail!',
                                },
                                {
                                    required: true,
                                    message: 'Please input your E-mail!',
                                },
                                ],
                            },
                            ]"
                        />
                        </a-form-item>
                        <a-form-item v-bind="formItemLayout" label="密码" has-feedback>
                        <a-input
                            v-decorator="[
                            'password',
                            {
                                rules: [
                                {
                                    required: true,
                                    message: 'Please input your password!',
                                },
                                {
                                    validator: validateToNextPassword,
                                },
                                ],
                            },
                            ]"
                            type="password"
                        />
                        </a-form-item>
                        <a-form-item v-bind="formItemLayout" label="确认密码" has-feedback>
                        <a-input
                            v-decorator="[
                            'confirm',
                            {
                                rules: [
                                {
                                    required: true,
                                    message: 'Please confirm your password!',
                                },
                                {
                                    validator: compareToFirstPassword,
                                },
                                ],
                            },
                            ]"
                            type="password"
                            @blur="handleConfirmBlur"
                        />
                        </a-form-item>
                        <a-form-item v-bind="formItemLayout">
                        <span slot="label">
                            昵称&nbsp;
                            <a-tooltip title="What do you want others to call you?">
                            <a-icon type="question-circle-o" />
                            </a-tooltip>
                        </span>
                        <a-input
                            v-decorator="[
                            'nickname',
                            {
                                rules: [{ required: true, message: 'Please input your nickname!', whitespace: true }],
                            },
                            ]"
                        />
                        </a-form-item>
                        <a-form-item v-bind="tailFormItemLayout">
                        <a-checkbox v-decorator="['agreement', { valuePropName: 'checked' }]">
                            I have read the
                            <a href="">
                            agreement
                            </a>
                        </a-checkbox>
                        </a-form-item>
                        <a-form-item v-bind="tailFormItemLayout">
                        <a-button type="primary" html-type="submit">
                            Register
                        </a-button>
                        </a-form-item>
                    </a-form>
                </a-modal>
                </a-form-item>
            </a-form>
          </a-col>
        </a-row>
    </div>
</template>

<script>
export default {
    name:'Login',
  data() {
    return {
      visible: false,
      confirmDirty: false,
      autoCompleteResult: [],
      formItemLayout: {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 6 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
      },
      tailFormItemLayout: {
        wrapperCol: {
          xs: {
            span: 24,
            offset: 0,
          },
          sm: {
            span: 16,
            offset: 8,
          },
        },
      },
    };
  },
  beforeCreate() {
    this.form = this.$form.createForm(this, { name: 'normal_login' });
    this.registerform = this.$form.createForm(this, { name: 'register' });
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values);
        }
      });
    },
    showModal() {
      this.visible = true;
    },
    handleOk(e) {
      this.visible = false;
    },
    handleConfirmBlur(e) {
      const value = e.target.value;
      this.confirmDirty = this.confirmDirty || !!value;
    },
    compareToFirstPassword(rule, value, callback) {
      const registerform = this.registerform;
      if (value && value !== registerform.getFieldValue('password')) {
        callback('Two passwords that you enter is inconsistent!');
      } else {
        callback();
      }
    },
    validateToNextPassword(rule, value, callback) {
      const registerform = this.registerform;
      if (value && this.confirmDirty) {
        registerform.validateFields(['confirm'], { force: true });
      }
      callback();
    },
    handleSubmitOfRegister(e) {
      e.preventDefault();
      this.registerform.validateFieldsAndScroll((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values);
        }
      });
    },
  },
}
</script>

<style scoped>
#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-remember {
  float: left;
}
#components-form-demo-normal-login .login-form-button {
  width: 70%;
}
</style>