# 前端仓库
##  0.写在前面
这个就是我们前端的仓库啦，以后大家的代码往里面push就行。github有很多神秘操作，之后有缘安利给大家。

### 关于git
推荐的可视化工具有：github桌面版/TortoiseGit/git kraken
git使用守则：（请务必记住）
1. push之前先pull一下。和远端保持同步，不然conflict（冲突）会很头痛。
2. 确认自己写的东西能跑再push。
3. 遇事不决，量子力学（划掉），去群里问问看。
### commit规范（from 67）
feat：新功能（feature）

fix：修补bug

docs：文档（documentation）

style： 格式（不影响代码运行的变动）

refactor：重构（即不是新增功能，也不是修改bug的代码变动）

test：增加测试

chore：构建过程或辅助工具的变动



### 技术栈说明
vue
ant-design组件库
vuex 管理数据流
vue-cli的脚手架
vue-router路由

以上均有中文官方文档，先看文档再google（csdn有时候是坑你的）



## 1.项目说明

### 开始你的项目
1. git clone 之后进入front_end（不是项目根目录！！是readme这里！！之后我们后端的代码也会放这个仓库）
```npm install```
2. 跑项目预览效果
```npm run serve```

### 简单的结构说明
可搜索“vue”项目结构，简书里有一篇讲的很清楚。

我们要修改的代码全部放在src文件夹下。

components：放组件，一个.vue是一个组件
view：放页面，页面文件已经建好了，<template>标签里是html的部分
assets：放静态资源（图片、css文件……）

### 如果新加页面router配置有问题记得@我
