package com.network_blog.back_end.blImpl.comment;

import com.network_blog.back_end.bl.comment.CommentService;
import com.network_blog.back_end.data.comment.CommentMapper;
import com.network_blog.back_end.po.Comment;
import com.network_blog.back_end.vo.CommentVO;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final static String CREATE_ERROR = "创建评论失败";
    private final static String DELETE_ERROR = "删除评论失败";
    @Autowired
    CommentMapper commentMapper;

    @Override
    public ResponseVO createComment(Comment comment) {
        try {
            commentMapper.createComment(comment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(CREATE_ERROR);
        }
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO deleteComment(int id) {
        try {
            commentMapper.deleteComment(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(DELETE_ERROR);
        }
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public List<Comment> getCommentByPassageId(int passageId) {
        return commentMapper.getCommentByPassageId(passageId);
    }
}
