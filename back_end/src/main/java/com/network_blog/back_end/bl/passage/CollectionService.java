package com.network_blog.back_end.bl.passage;

import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.po.Collection;
import com.network_blog.back_end.vo.PassageVO;

import java.util.List;

public interface CollectionService {
    /**
     * 建立、删除、查看收藏关系*/
    void createCollection(Collection collection);

    void deleteCollection(Collection collection);

    List<PassageVO> searchCollection(Integer userId);

}
