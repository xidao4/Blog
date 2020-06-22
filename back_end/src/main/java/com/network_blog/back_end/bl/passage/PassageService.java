package com.network_blog.back_end.bl.passage;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.vo.PassageVO;

import java.util.Date;
import java.util.List;

public interface PassageService {
    /**
     * 获取某用户自己写的全部文章
     * @param userId
     * @return
     */
    List<PassageVO> getAllBlogsByUserId(int userId);

    /**
     *获取某用户所有的写作日期
     * @param userId
     * @return
     */
    List<Date> getCreateTimeByUserId(int userId);

    /**
     * 获取单篇文章
     * @param id
     * @return
     */
    PassageVO getBlogById(int id);

    /**
     * 增
     * @param userId
     * @param title
     * @param content
     * @param createTime
     * @param status
     * @param url
     * @return
     */
    ResponseVO insert(int userId,String title,String content,Date createTime,int status,String url);
    /**
     * 改
     * @param id
     * @param title
     * @param content
     * @param updateTime
     * @param status
     * @param url
     * @return
     */
    ResponseVO updateBlog(int id, String title, String content, Date updateTime,int status,String url);
    /**
     * 删
     * @param id
     * @return
     */
    ResponseVO delete(Integer id);


    /**
     * 文章搜索
     * @param key
     * @return
     */
    List<PassageVO> searchPassages(String key);


}
