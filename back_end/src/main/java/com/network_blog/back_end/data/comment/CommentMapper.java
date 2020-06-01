package com.network_blog.back_end.data.comment;

import com.network_blog.back_end.po.Comment;
import com.network_blog.back_end.vo.CommentVO;
import com.network_blog.back_end.vo.ResponseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    int createComment(Comment comment);

    int deleteComment(@Param("id") int id);

    List<Comment> getCommentByPassageId(@Param("passageId") int passageId);
}
