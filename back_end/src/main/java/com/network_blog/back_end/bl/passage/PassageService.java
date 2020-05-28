package com.network_blog.back_end.bl.passage;
import com.network_blog.back_end.vo.ResponseVO;

public interface PassageService {
    /**文章增删改查**/
    ResponseVO CreatePassage();
    ResponseVO DeletePassage();
    ResponseVO UpdatePassage();
    ResponseVO SearchPassage();
}
