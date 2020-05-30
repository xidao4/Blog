package com.network_blog.back_end.bl.passage;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;

import java.util.List;

public interface PassageService {
    /**
     * 获取并显示文章
     * @param userid
     * @return
     */
    List<Passage> getUserPassages(int userid);

    /**
     * 文章：增
     * @param blog
     * @return 添加是否成功的信息
     */
    String insertBlog(Passage blog);

    /**
     * 文章：删
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 文章：改
     * @param blog
     * @return
     */
    String updateBlog(Passage blog);
    ResponseVO SearchPassage();
}
