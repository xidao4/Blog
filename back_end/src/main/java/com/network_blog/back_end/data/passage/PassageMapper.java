package com.network_blog.back_end.data.passage;

import com.network_blog.back_end.po.Passage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PassageMapper {
    int insert(Passage record);
    Passage selectByPrimaryKey(int blogId);
    int updateByPrimaryKeySelective(Passage record);
    int deleteBatch(Integer[] ids);
    List<Passage> getUserBlogs(@Param("userid") int userid);
}
