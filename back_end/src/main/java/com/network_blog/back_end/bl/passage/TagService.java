package com.network_blog.back_end.bl.passage;



import com.network_blog.back_end.po.Tag;
import com.network_blog.back_end.vo.ResponseVO;

import java.util.List;

public interface TagService {
    List<Tag> getTagsByPassageId(Integer passageId);
    ResponseVO save(String tagName, Integer passageId);
    ResponseVO deleteByTagId(Integer tagId);
}
