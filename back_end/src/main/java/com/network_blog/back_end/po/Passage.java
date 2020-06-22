package com.network_blog.back_end.po;
import java.util.Date;

public class Passage {

    private Integer id;
    private String content;
    private Integer userId;
    private String title;
    private Date recentEditTime;
    private Date createTime;
    private int status;//0草稿 1公开显示 2不公开显示
    private String url;
    private int collectionNum;


    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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
        return recentEditTime;
    }

    public void setRecentEditTime(Date recentEditTime) {
        this.recentEditTime = recentEditTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
