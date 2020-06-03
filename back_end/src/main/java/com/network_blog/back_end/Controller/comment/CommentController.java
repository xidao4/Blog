package com.network_blog.back_end.controller.comment;

import com.network_blog.back_end.bl.comment.CommentService;
import com.network_blog.back_end.po.Comment;
import com.network_blog.back_end.vo.CommentVO;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseVO createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    };

    @PostMapping("/{id}/delete")
    public ResponseVO deleteComment(@PathVariable int id){
        return commentService.deleteComment(id);
    };

    @GetMapping("/{passageId}/getCommentByPassageId")
    public ResponseVO getCommentByPassageId(@PathVariable int passageId){
        List<Comment> comments = commentService.getCommentByPassageId(passageId);
        if(comments==null){
            return ResponseVO.buildFailure("获取评论失败");
        }
        return ResponseVO.buildSuccess(comments);
    };
}
