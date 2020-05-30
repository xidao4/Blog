package com.network_blog.back_end.blImpl.passage;

import com.network_blog.back_end.bl.passage.PassageService;
import com.network_blog.back_end.data.passage.PassageMapper;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageServiceImpl implements PassageService {
    @Autowired
    private PassageMapper blogMapper;


    /**
     * 获取并显示文章
     *
     * @param userid
     * @return
     */
    @Override
    public List<Passage> getUserPassages(int userid) {
        return blogMapper.getUserBlogs(userid);
    }

    /**
     * 文章：增
     *
     * @param blog
     * @return
     */
    @Override
    public String insertBlog(Passage blog) {
        if (blogMapper.insert(blog) > 0) {
            return "success";
        }
        return "failure";
    }

    /**
     * 文章：删
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return blogMapper.deleteBatch(ids)>0;
    }


    /**
     * 文章： 改
     * @param blog
     * @return
     */
    @Override
    public String updateBlog(Passage blog) {
        Passage blogForUpdate=blogMapper.selectByPrimaryKey(blog.getId());
        if (blogForUpdate == null) {
            return "数据不存在";
        }
        blogForUpdate.setTitle(blog.getTitle());
        blogForUpdate.setContent(blog.getContent());
        if(blogMapper.updateByPrimaryKeySelective(blogForUpdate)>0){
            return "修改成功";
        }
        return "修改失败";
    }


    @Override
    public ResponseVO SearchPassage() {
        return null;
    }
}
