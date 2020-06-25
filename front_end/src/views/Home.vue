<template>
    <div class="wrapper" style="background-color: white">
        <div class="slide">
            <h3 style="color: white;font-size:40px;font-weight: bolder;text-shadow: 0 2px 3px rgba(0,0,0,.4);margin-bottom: 30px">革新你的在线文字编辑体验</h3>
            <h3 style="color: white;font-size: 37px;font-weight: bolder;text-shadow: 0 2px 3px rgba(0,0,0,.4)">简洁、可靠、专业、便捷的工作娱乐文字书写平台</h3>
        </div>
        <div style="margin-top: 80px;padding-bottom:80px;margin-bottom: 10px">
            <h3 style="color: #0E141E;font-size:40px;font-weight: bolder;text-shadow: 0 1px 3px rgba(0,0,0,.1);">开始你的高效文字编辑之旅</h3>
            <a-row style="margin-top: 45px">
                <a-col :span="4" ></a-col>
                <a-col :span="3" style="margin-left: 30px">
                    <a-row>
                        <a-icon type="github" theme="filled" style="font-size: 50px;color: #0E141E"></a-icon>
                    </a-row>
                    <a-row style="margin-top: 20px;">
                        <h3 style="font-size: 25px;font-weight: bolder;text-shadow: 0 1px 3px rgba(0,0,0,.1);">
                            好友链接
                        </h3>
                    </a-row>
                </a-col>
                <a-col :span="3">
                    <a-row>
                        <a-icon type="tags" theme="filled" style="font-size: 50px;color: #0E141E"></a-icon>
                    </a-row>
                    <a-row style="margin-top: 20px;">
                        <h3 style="font-size: 25px;font-weight: bolder;text-shadow: 0 1px 3px rgba(0,0,0,.1);">
                            创建标签
                        </h3>
                    </a-row>
                </a-col>
                <a-col :span="3">
                    <a-row>
                        <a-icon type="edit" theme="filled" style="font-size: 50px;color: #0E141E"></a-icon>
                    </a-row>
                    <a-row style="margin-top: 20px;">
                        <h3 style="font-size: 25px;font-weight: bolder;text-shadow: 0 1px 3px rgba(0,0,0,.1);">
                            创建博客
                        </h3>
                    </a-row>
                </a-col>
                <a-col :span="3">
                    <a-row>
                        <a-icon type="star" theme="filled" style="font-size: 50px;color: #0E141E"></a-icon>
                    </a-row>
                    <a-row style="margin-top: 20px;">
                        <h3 style="font-size: 25px;font-weight: bolder;text-shadow: 0 1px 3px rgba(0,0,0,.1);">
                            收藏博客
                        </h3>
                    </a-row>
                </a-col>
                <a-col :span="3">
                    <a-row>
                        <a-icon type="eye" theme="filled" style="font-size: 50px;color: #0E141E"></a-icon>
                    </a-row>
                    <a-row style="margin-top: 20px;">
                        <h3 style="font-size: 25px;font-weight: bolder;text-shadow: 0 1px 3px rgba(0,0,0,.1);">
                            发现更多
                        </h3>
                    </a-row>
                </a-col>
                <a-col :span="4"></a-col>
            </a-row>
            <a-row style="margin-top: 5px">
                <a-col :span="4"></a-col>
                <a-col :span="15" style="margin-left: 35px">
                    <hr style="width: 93%;color: #0E141E;box-shadow: 0 1px 3px rgba(0,0,0,.1);">
                </a-col>
                <a-col :span="4"></a-col>
            </a-row>
        </div>
        <div style="background-color: #E4E6E9;height: 200px;padding-top: 80px">
            <a-row>
                <a-col :span="1"></a-col>
                <a-col :span="7" style="margin-left: 60px;">
                    <a-card hoverable style="width: 360px;">
                        <img
                                slot="cover"
                                alt="example"
                                src="https://pinru.oss-cn-shanghai.aliyuncs.com/slide/slide5.jpg"
                                style="border-radius: 5px 5px 0 0"
                        />
                        <a-card-meta title="Card title" description="This is the description">
                        </a-card-meta>
                    </a-card>
                </a-col>
                <a-col :span="7">
                    <a-card hoverable style="width: 360px;margin-top: 100px">
                        <img
                                slot="cover"
                                alt="example"
                                src="https://pinru.oss-cn-shanghai.aliyuncs.com/slide/slide4.jpg"
                                style="border-radius: 5px 5px 0 0"
                        />
                        <a-card-meta title="Card title" description="This is the description">
                        </a-card-meta>
                    </a-card>
                </a-col>
                <a-col :span="7">
                    <a-card hoverable style="width: 360px;margin-top: 200px">
                        <img
                                slot="cover"
                                alt="example"
                                src="https://pinru.oss-cn-shanghai.aliyuncs.com/slide/slide1.jpg"
                                style="border-radius: 5px 5px 0 0"
                        />
                        <a-card-meta title="Card title" description="This is the description">
                        </a-card-meta>
                    </a-card>
                </a-col>
                <a-col :span="1"></a-col>
            </a-row>
            <a-row>
                <a-col :span="24" style="height: 100px;background-color: #E4E6E9"></a-col>
            </a-row>
        </div>
    </div>
</template>

<script>
// @ is an alias to /src
import { mapGetters, mapActions, mapMutations } from 'vuex'

export default {
  name: 'Home',
  created() {
    
  },
    mounted(){
        this.getRandomPassages();
    },
    methods: {
        ...mapActions([
            'getRandomPassages'
        ]),
    },
  components: {
  }
}
</script>

<style>
  .slide{
    background: url("https://pinru.oss-cn-shanghai.aliyuncs.com/slide9.jpg");
    background-size: cover;
    width: 100%;
    height: 400px;
    text-align: center;
      padding-top: 130px;
  }
</style>
