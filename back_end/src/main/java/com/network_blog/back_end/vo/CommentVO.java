package com.network_blog.back_end.vo;

import java.util.Date;

public class CommentVO {
    private Integer id;
    private Integer passageId;
    private Integer userId;
    private String content;
    private String userName;
    private Date commentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassageId() {
        return passageId;
    }

    public void setPassageId(Integer passageId) {
        this.passageId = passageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
