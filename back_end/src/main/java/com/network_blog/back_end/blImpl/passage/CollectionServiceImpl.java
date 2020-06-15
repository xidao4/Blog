package com.network_blog.back_end.blImpl.passage;

import com.network_blog.back_end.bl.passage.CollectionService;
import com.network_blog.back_end.bl.passage.PassageService;
import com.network_blog.back_end.data.passage.CollectionMapper;
import com.network_blog.back_end.data.passage.PassageMapper;
import com.network_blog.back_end.po.Collection;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.vo.PassageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private PassageMapper passageMapper;

    @Override
    public ResponseVO createCollection(Collection collection){
        List<Integer> collections=collectionMapper.search(collection.getUserId());
        for(int i=0;i<collections.size();i++){
            if(collections.get(i)==collection.getPassageId())
                return ResponseVO.buildFailure("收藏已存在");
        }

        collectionMapper.insert(collection);
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public void deleteCollection(Collection collection){
        collectionMapper.delete(collection);
    }

    @Override
    public List<PassageVO> searchCollection(Integer userId){
        List<Integer> collections=collectionMapper.search(userId);
        List<Passage> passages=new ArrayList<>();
        for(int i=0;i<collections.size();i++){
            passages.add(passageMapper.selectById(collections.get(i)));
        }
        List<PassageVO> passageVOS=passages.stream().map(p->{
            PassageVO passageVO=new PassageVO();
            passageVO.setUserId(p.getUserId());
            passageVO.setTitle(p.getTitle());
            passageVO.setRecentEditTime(p.getRecentEditTime());
            passageVO.setCreateTime(p.getCreateTime());
            passageVO.setContent(p.getContent());
            passageVO.setId(p.getId());
            passageVO.setCollectionTime(p.getCreateTime());
            return passageVO;
        }).collect(Collectors.toList());
        return passageVOS;
    }
}
