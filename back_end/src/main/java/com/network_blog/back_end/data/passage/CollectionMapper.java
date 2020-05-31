package com.network_blog.back_end.data.passage;

import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.po.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CollectionMapper {

    int insert(@Param("collection") Collection collection);

    int delete(@Param("collection") Collection collection);

    List<Integer> search(@Param("userId") Integer userId);

}
