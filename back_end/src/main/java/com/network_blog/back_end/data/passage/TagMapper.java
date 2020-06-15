package com.network_blog.back_end.data.passage;


import com.network_blog.back_end.po.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
    List<Tag> getTagsByPassageId(int passageId);
    int deleteByTagId(int tagId);
    int insert(Tag tag);
    List<Tag> selectByPassageIdAndTagName(String tagName, int passageId);
}
