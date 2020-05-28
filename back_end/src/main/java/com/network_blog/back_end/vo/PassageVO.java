package com.network_blog.back_end.vo;

import java.util.Date;

public class PassageVO {
    private Integer id;
    private String content;
    private Integer userId;
    private String title;
    private Date RecentEditTime;
    private Date createTime;
    private Date collectionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRecentEditTime() {
        return RecentEditTime;
    }

    public void setRecentEditTime(Date recentEditTime) {
        RecentEditTime = recentEditTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }


}
