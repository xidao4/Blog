package com.network_blog.back_end.controller.passage;

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
    public ResponseVO retrieveUserBlogs(@RequestParam int userId){
        try{
            return ResponseVO.buildSuccess(passageService.getAllBlogsByUserId(userId));
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("获取所写博客列表失败");
        }
    }

    /**
     * 根据博客的ID获取单篇文章内容
     * @param id
     * @return
     */
    @GetMapping("/{id}/passage")
    public ResponseVO getBlogById(@PathVariable int id){
        try{
            return ResponseVO.buildSuccess(passageService.getBlogById(id));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("获取单篇博客失败");
        }

    }


    /**
     * 某用户写完博客后点击保存
     * @param vo
     * userId
     * title
     * content
     * createTime
     * @return
     */
    @GetMapping("/save")
    public ResponseVO save(@RequestBody PassageVO vo){
        return passageService.insert(vo.getUserId(),vo.getTitle(),vo.getContent(),vo.getCreateTime());

    }
    /**
     * 某用户修改自己写的博客
     * @param vo
     * id
     * title
     * content
     * updateTime
     * @return
     */
    @PostMapping("/update")
    public ResponseVO update(@RequestBody PassageVO vo){
        return passageService.updateBlog(vo.getUserId(),vo.getTitle(),vo.getContent(),vo.getRecentEditTime());

    }
    /**
     * 某用户删除某篇博客
     * @param id
     * @return
     */
    @PostMapping("/delete")
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
