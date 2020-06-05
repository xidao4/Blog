<template>
    <a-layout>
        <a-layout-content>
            <div class="details">
                <a-row class="information" style="text-align: left;margin-left: 250px;margin-right: 100px;margin-top: 50px">
                    <a-col class="'userLogo'" span="3" >
                        <img src="../../../assets/icon.jpg" height="100" width="100" />
                    </a-col>
                    <a-col class="'userName'" style="text-align:left;margin-left: 20px;"><br><br>
                        <span class="'name'" style="font-size: large;color: darkgray" >Mr.林娟娟</span><br>
                        <span class="'time'" style="font-size: large;color: darkgray">发表于 2020-02-29</span>
                    </a-col>
                    <a-col style="text-align: right;margin-right: 200px">
                        <a-button >收藏</a-button>
                    </a-col>
                </a-row>
                <h1 class="'title'" style="text-align: left;margin-left: 250px;margin-top: 20px;align-self: auto;font-size: xx-large">震惊！某男星头围居然这么大！原因竟然是。。</h1><br>
                <a-row class="text" style="text-align:left;margin-right: 300px;margin-left: 250px;font-size: large">
                    &ensp;&ensp;为了能证明雷佳音的“巨头”，网友们也是煞费苦心，各出奇招。有网友还拿雷佳音的头围和佟丽娅的腰围做对比，“花式量尺寸”，意外发现雷佳音头围堪比佟丽娅腰围？雷佳音额头围和佟丽娅的腰围一样？半张脸能抵一张脸？雷佳音看了怕是要哭的，不过由此也有网友总结：丫丫的腰能这么细，也是妥妥的服气，只不过这个尺寸若是“长错了地方”，那真的就不太“好看”了，比如雷佳音的“大头”。哈哈哈，我就笑笑不说话。
                </a-row><br><br>
                <a-menu  >
                    <a-menu-item key="1" >
                        <a-col style="text-align: left;margin-left: 250px">
                            <router-link to="reviews">
                                <a-icon type="user" />评论
                            </router-link>
                        </a-col>
                    </a-menu-item>
                    <a-col style="text-align: right;margin-right: 300px">
                        <a-button type="primary">添加评论</a-button>
                    </a-col>
                </a-menu>
            </div>
        </a-layout-content>
    </a-layout>
</template>

<script>
    import {mapGetters} from 'vuex';
    export default {
        name: "details",
        data(){
            return{

            }
        },
        computed:{
          ...mapGetters([
              'searchResult'
          ])
        },
    }
</script>

<style scoped>

</style>