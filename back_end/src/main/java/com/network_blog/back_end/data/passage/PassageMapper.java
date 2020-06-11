package com.network_blog.back_end.data.passage;

import com.network_blog.back_end.po.Passage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface PassageMapper {
    List<Passage> getAllBlogsByUserId(@Param("userId") int userId);
    int insert(@Param("userId")int userId,@Param("title") String title,@Param("content") String content,@Param("createTime") Date createTime);
    int update(@Param("id")int id,@Param("title") String title,@Param("content") String content,@Param("recentEditTime") Date recentEditTime);
    int delete(@Param("id") Integer id);
    Passage selectById(@Param("id") int id);
    List<Passage> selectByKey(@Param("key") String key);
}
