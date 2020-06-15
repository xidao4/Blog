package com.network_blog.back_end.bl.passage;



import com.network_blog.back_end.po.Tag;
import com.network_blog.back_end.vo.PassageVO;
import com.network_blog.back_end.vo.ResponseVO;

import java.util.List;

public interface TagService {
    List<Tag> getTagsByPassageId(Integer passageId);
    ResponseVO save(String tagName, Integer passageId,Integer userId);
    ResponseVO deleteByTagId(Integer tagId);
    List<PassageVO> getPassagesByTag(int userId,String tagName);
    List<Tag> getTagsByUserId(Integer userId);
}
