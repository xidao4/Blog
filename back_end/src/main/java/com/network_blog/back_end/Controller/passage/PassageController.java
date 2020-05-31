package com.network_blog.back_end.controller.passage;

import com.network_blog.back_end.bl.passage.PassageService;
import com.network_blog.back_end.bl.passage.CollectionService;
import com.network_blog.back_end.po.Collection;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/passages")
public class PassageController {
    @Autowired
    private PassageService passageService;
    @Autowired
    private CollectionService collectionService;

    @GetMapping("/{userid}/list")
    @ResponseBody
    public ResponseVO retrieveUserPassages(@PathVariable int userid){
        return ResponseVO.buildSuccess(passageService.getUserPassages(userid));
    }

    @GetMapping("/write")
    @ResponseBody
    public ResponseVO write(@RequestParam("blogTitle") String blogTitle,
                           @RequestParam("blogContent") String blogContent){
        if(StringUtils.isEmpty(blogTitle))
            return ResponseVO.buildFailure("请输入文章标题");
        if (blogTitle.trim().length() > 150)
            return ResponseVO.buildFailure("标题过长");
        if (StringUtils.isEmpty(blogContent)) {
            return ResponseVO.buildFailure("请输入文章内容");
        }
        Passage passage=new Passage();
        passage.setTitle(blogTitle);
        passage.setContent(blogContent);
        String saveBlogRet=passageService.insertBlog(passage);
        if("success".equals(saveBlogRet))
            return ResponseVO.buildSuccess("添加成功");
        else
            return ResponseVO.buildFailure(saveBlogRet);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseVO update(@RequestParam("blogId") Integer blogId,
                             @RequestParam("blogTitle") String blogTitle,
                             @RequestParam("blogContent") String blogContent){
        if (StringUtils.isEmpty(blogTitle)) {
            return ResponseVO.buildFailure("请输入文章标题");
        }
        if (blogTitle.trim().length() > 150) {
            return ResponseVO.buildFailure("标题过长");
        }
        if (StringUtils.isEmpty(blogContent)) {
            return ResponseVO.buildFailure("请输入文章内容");
        }
        Passage blog=new Passage();
        blog.setId(blogId);
        blog.setTitle(blogTitle);
        blog.setContent(blogContent);
        String updateBlogRet=passageService.updateBlog(blog);
        if("success".equals(updateBlogRet))
            return ResponseVO.buildSuccess("添加成功");
        else
            return ResponseVO.buildFailure(updateBlogRet);

    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseVO delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResponseVO.buildFailure("参数异常！");
        }
        if (passageService.deleteBatch(ids)) {
            return ResponseVO.buildSuccess();
        } else {
            return ResponseVO.buildFailure("删除失败");
        }
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
