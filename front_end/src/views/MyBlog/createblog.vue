<template>
    <div>
        <a-row type="flex" justify="center">
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
          <a-col :span="16">
            <a-card hoverable class="whole_card">
                <img
                slot="cover"
                alt="example"
                src="../../assets/post-bg-re-vs-ng2.jpg"
                />
                  <a-input placeholder="标题" allow-clear>
                      <a-icon slot="prefix" type="edit" />
                  </a-input>
                <a-textarea placeholder="Basic usage" :autosize="{minRows: 9, maxRows: 11}"/>
                <template slot="actions">
                <a-icon key="picture" type="picture" />
                <a-icon key="delete" type="delete" />
                <a-icon key="setting" type="setting" />
                <a-icon key="upload" type="upload" />
                <a-icon key="save" type="save" />
                </template>
            </a-card>
          </a-col>
          <a-col :span="4"></a-col>
        </a-row>
        
    </div>
</template>

<script>
export default {
    name:'CreateBlog',
    methods: {
        onPanelChange(value, mode) {
        console.log(value, mode);
        },
    },
}
</script>

<style scoped>
.whole_card{
width: 700px;
height: 680px;
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