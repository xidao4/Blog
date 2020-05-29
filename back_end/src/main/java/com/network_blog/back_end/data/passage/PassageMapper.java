package com.network_blog.back_end.data.passage;

import com.network_blog.back_end.po.Passage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PassageMapper {
    Passage selectByPrimaryKey(int blogId);
    int updateByPrimaryKeySelective(Passage record);
    int deleteBatch(Integer[] ids);
}
