package com.network_blog.back_end.bl.passage;

import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.po.Collection;
import com.network_blog.back_end.vo.PassageVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CollectionService {
    /**
     * 建立、删除、查看收藏关系*/
    ResponseVO createCollection(Collection collection);

    void deleteCollection(Collection collection);

    List<PassageVO> searchCollection(Integer userId);

    Boolean isInCollection(Integer userId, Integer passageId);

    List<PassageVO> getMostPopularPassages(Integer userId);

}
