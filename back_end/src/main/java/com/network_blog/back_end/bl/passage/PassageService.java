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
     * 增
     * @param userId
     * @param title
     * @param content
     * @param createTime
     * @return
     */
    ResponseVO insert(int userId,String title,String content,Date createTime);
    /**
     * 改
     * @param id
     * @param title
     * @param content
     * @param updateTime
     * @return
     */
    ResponseVO updateBlog(int id, String title, String content, Date updateTime);
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
