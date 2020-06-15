package com.network_blog.back_end.controller.passage;

import com.network_blog.back_end.bl.passage.TagService;
import com.network_blog.back_end.po.Tag;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 获得某篇文章的全部标签
     * @param passageId
     * @return
     */
    @GetMapping("/{passageId}/list")
    public ResponseVO list(@PathVariable Integer passageId){
        return ResponseVO.buildSuccess(tagService.getTagsByPassageId(passageId));
    }

    /**
     * 文章作者给自己写的某篇文章添加某条标签
     * @param tag
     * @return
     */
    @PostMapping("/saveTag")
    public ResponseVO save(@RequestBody Tag tag){
        return tagService.save(tag.getTagName(),tag.getPassageId(),tag.getUserId());
    }

    /**
     * 文章作者删除某个之前加的文章标签
     * @param tagId：tb_tag的唯一标识符
     * @return
     */
    @PostMapping("/{tagId}/delete")
    public ResponseVO deleteByTagId(@PathVariable Integer tagId){
        return ResponseVO.buildSuccess(tagService.deleteByTagId(tagId));
    }

    /**
     * 某位用户获取自己写的文章中贴上某标签的全部文章
     * @param tagName
     * @return
     */
    @GetMapping("/{userId}/{tagName}/listByTag")
    public ResponseVO listByTag(@PathVariable int userId,@PathVariable String tagName){
        return ResponseVO.buildSuccess(tagService.getPassagesByTag(userId,tagName));
    }

    /**
     * 获得用户所写文章的全部标签
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/getTagsByUser")
    public ResponseVO getTagsByUserId(@PathVariable int userId){
        return ResponseVO.buildSuccess(tagService.getTagsByUserId(userId));
    }
}
