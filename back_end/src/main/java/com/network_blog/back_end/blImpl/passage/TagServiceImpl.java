package com.network_blog.back_end.blImpl.passage;


import com.network_blog.back_end.bl.passage.TagService;
import com.network_blog.back_end.data.passage.PassageMapper;
import com.network_blog.back_end.data.passage.TagMapper;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.po.Tag;
import com.network_blog.back_end.vo.PassageVO;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;
    @Autowired
    private PassageMapper blogMapper;

    @Override
    public List<Tag> getTagsByPassageId(Integer passageId) {
        return tagMapper.getTagsByPassageId(passageId);
    }

    @Override
    public ResponseVO deleteByTagId(Integer tagId) {
        return ResponseVO.buildSuccess(tagMapper.deleteByTagId(tagId));
    }

    @Override
    public List<PassageVO> getPassagesByTag(int userId,String tagName) {
        List<Tag> tags=tagMapper.getPassageIdsByTag(userId,tagName);
        List<PassageVO> vos=new ArrayList<>();
        for(Tag tag:tags){
            int passageId=tag.getPassageId();
            Passage p=blogMapper.selectById(passageId);
            PassageVO pvo=new PassageVO();
            pvo.setContent(p.getContent());
            pvo.setTitle(p.getTitle());
            pvo.setId(p.getId());
            pvo.setUserId(p.getUserId());
            pvo.setRecentEditTime(p.getRecentEditTime());
            pvo.setCreateTime(p.getCreateTime());
            pvo.setCollectionNum(p.getCollectionNum());
            vos.add(pvo);
        }
        return vos;
    }

    @Override
    public List<Tag> getTagsByUserId(Integer userId) {
        List<Tag> tags=tagMapper.getTagsByUserId(userId);
        List<Tag> distinct_tags=new ArrayList<>();
        for(Tag tag:tags){
            boolean isDistinct=true;
            for(Tag distinct_tag:distinct_tags){
                if(tag.getTagName().equals(distinct_tag.getTagName())){
                    isDistinct=false;
                    break;
                }
            }
            if(isDistinct){
                distinct_tags.add(tag);
            }
        }
        return distinct_tags;
    }

    @Override
    public ResponseVO save(String tagName,Integer passageId,Integer userId) {
        if(tagMapper.selectByPassageIdAndTagName(tagName,passageId).size()!=0)//!=null
            return ResponseVO.buildFailure("请勿重复添加此标签！");
        Tag tag=new Tag();
        tag.setPassageId(passageId);
        tag.setTagName(tagName);
        tag.setUserId(userId);
        tagMapper.insert(tag);
        return ResponseVO.buildSuccess(true);
    }

}
