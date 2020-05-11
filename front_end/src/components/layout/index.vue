<template>
    <a-layout >
        <a-layout-header id="components-layout-demo-fixed">
            <Header></Header>
        </a-layout-header>
    </a-layout>
</template>

<script>
import Header from './component/header.vue'

export default {
    name:'Layout',
    components:{
        Header,
    },
}
</script>

<style>
#components-layout-demo-fixed {
  position: fixed;
  width: 100%;
  height: 10%;
  background: rgba(0, 0, 0, 0.65);
  margin: 0% 0% 2% 0%;
}
</style>