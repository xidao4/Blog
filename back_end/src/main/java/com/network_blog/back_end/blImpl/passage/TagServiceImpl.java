package com.network_blog.back_end.blImpl.passage;


import com.network_blog.back_end.bl.passage.TagService;
import com.network_blog.back_end.data.passage.TagMapper;
import com.network_blog.back_end.po.Tag;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;


    @Override
    public List<Tag> getTagsByPassageId(Integer passageId) {
        return tagMapper.getTagsByPassageId(passageId);
    }

    @Override
    public ResponseVO deleteByTagId(Integer tagId) {
        return ResponseVO.buildSuccess(tagMapper.deleteByTagId(tagId));
    }

    @Override
    public ResponseVO save(String tagName,Integer passageId) {
        if(tagMapper.selectByPassageIdAndTagName(tagName,passageId).size()!=0)//!=null
            return ResponseVO.buildFailure("请勿重复添加此标签！");
        Tag tag=new Tag();
        tag.setPassageId(passageId);
        tag.setTagName(tagName);
        tagMapper.insert(tag);
        return ResponseVO.buildSuccess(true);
    }

}
