package com.network_blog.back_end.bl.comment;

import com.network_blog.back_end.vo.ResponseVO;

public interface CommentService {
    /**评论、删除评论功能**/
    ResponseVO createComment();
    ResponseVO deleteComment();
}
