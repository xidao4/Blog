package com.network_blog.back_end.Controller.passage;

import com.network_blog.back_end.bl.passage.PassageService;
import com.network_blog.back_end.bl.passage.CollectionService;
import com.network_blog.back_end.po.Collection;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.PassageVO;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/passages")
public class PassageController {
    @Autowired
    private PassageService passageService;
    @Autowired
    private CollectionService collectionService;

    /**
     * 获取某用户自己写的全部博客
     * @param userId
     * @return PassageVO
     */
    @GetMapping("/list")
    @ResponseBody
    public ResponseVO retrieveUserBlogs(@RequestParam int userId){
        try{
            return ResponseVO.buildSuccess(passageService.getAllBlogsByUserId(userId));
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("获取所写博客列表失败");
        }
    }
    /**
     * 某用户写完博客后点击保存
     * @param userId
     * @param title
     * @param content
     * @param createTime
     * @return
     */
    @GetMapping("/save")
    @ResponseBody
    public ResponseVO save(@RequestParam("userId") Integer userId,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content,
                           @RequestParam("createTime") Date createTime){
        return passageService.insert(userId,title,content,createTime);

    }
    /**
     * 某用户修改自己写的博客
     * @param id
     * @param title
     * @param content
     * @param updateTime
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseVO update(@RequestParam("id") Integer id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("updateTime") Date updateTime){
        return passageService.updateBlog(id,title,content,updateTime);

    }
    /**
     * 某用户删除某篇博客
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResponseVO delete(@RequestBody Integer id) {
        return passageService.delete(id);
    }


    @GetMapping("/{key}/searchPassages")
    public ResponseVO searchPassages(@PathVariable String key){
        return ResponseVO.buildSuccess(passageService.searchPassages(key));
    }

    @PostMapping("/createCollection")
    public ResponseVO createCollection(@RequestBody Collection collection){
        collectionService.createCollection(collection);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/deleteCollection")
    public ResponseVO deleteCollection(@RequestBody Collection collection){
        collectionService.deleteCollection(collection);
        return ResponseVO.buildSuccess(true);
    }

    @GetMapping("/{userId}/searchCollection")
    public ResponseVO searchCollection(@PathVariable Integer userId){
        return ResponseVO.buildSuccess(collectionService.searchCollection(userId));
    }


}
