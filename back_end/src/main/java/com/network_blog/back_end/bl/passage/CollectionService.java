package com.network_blog.back_end.bl.passage;

import com.network_blog.back_end.vo.ResponseVO;

public interface CollectionService {
    /**
     * 建立、删除、查看收藏关系*/
    ResponseVO createCollection();
    ResponseVO DeleteCollection();
    ResponseVO searchCollection();
}
