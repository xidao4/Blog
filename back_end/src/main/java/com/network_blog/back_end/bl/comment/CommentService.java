package com.network_blog.back_end.bl.comment;

import com.network_blog.back_end.po.Comment;
import com.network_blog.back_end.vo.CommentVO;
import com.network_blog.back_end.vo.ResponseVO;

import java.util.List;

public interface CommentService {
    /**评论、删除评论功能、根据文章id获得评论**/
    ResponseVO createComment(Comment comment);

    ResponseVO deleteComment(int id);

    List<Comment> getCommentByPassageId(int passageId);
}
