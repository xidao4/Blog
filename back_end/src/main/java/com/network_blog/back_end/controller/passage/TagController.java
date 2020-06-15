package com.network_blog.back_end.controller.passage;

import com.network_blog.back_end.bl.passage.TagService;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/{passageId}/list")
    public ResponseVO list(@PathVariable Integer passageId){
        return ResponseVO.buildSuccess(tagService.getTagsByPassageId(passageId));
    }


    @PostMapping("/{tagName}/{passageId}/save")
    public ResponseVO save(@PathVariable("tagName") String tagName, @PathVariable("passageId") Integer passageId){
        return tagService.save(tagName,passageId);
    }

    @PostMapping("/{id}/delete")
    public ResponseVO deleteByTagId(@PathVariable Integer id){
        return ResponseVO.buildSuccess(tagService.deleteByTagId(id));
    }
}
