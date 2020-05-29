package com.network_blog.back_end.bl.passage;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;

public interface PassageService {
    /**文章增删改查**/

    /**
     * 文章：增
     * @param blog
     * @return 添加是否成功的信息
     */
    String saveBlog(Passage blog);

    /**
     * 文章：删
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    String updateBlog(Passage blog);
    ResponseVO SearchPassage();
}
