package com.network_blog.back_end.blImpl.passage;

import com.network_blog.back_end.bl.passage.PassageService;
import com.network_blog.back_end.data.passage.PassageMapper;
import com.network_blog.back_end.po.Passage;
import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.vo.PassageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassageServiceImpl implements PassageService {
    @Autowired
    private PassageMapper blogMapper;


    /**
     * 获取某用户自己写的全部文章
     *
     * @param userId
     * @return
     */
    @Override
    public List<PassageVO> getAllBlogsByUserId(int userId) {
        List<Passage> blogs=blogMapper.getAllBlogsByUserId(userId);
        List<PassageVO> vos=new ArrayList<>();
        for(Passage blog:blogs){
            PassageVO vo=new PassageVO();
            vo.setId(blog.getId());
            vo.setTitle(blog.getTitle());
            vo.setUserId(blog.getUserId());
            vo.setContent(blog.getContent());
            vo.setCreateTime(blog.getCreateTime());
            vo.setRecentEditTime(blog.getRecentEditTime());
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 获取单篇文章
     *
     * @param id
     * @return
     */
    @Override
    public PassageVO getBlogById(int id) {
        PassageVO vo=new PassageVO();
        Passage blog=blogMapper.selectById(id);
        vo.setId(blog.getId());
        vo.setTitle(blog.getTitle());
        vo.setUserId(blog.getUserId());
        vo.setContent(blog.getContent());
        vo.setCreateTime(blog.getCreateTime());
        vo.setRecentEditTime(blog.getRecentEditTime());
        return vo;
    }

    /**
     * 增
     *
     * @param userId
     * @param title
     * @param content
     * @param createTime
     * @return
     */
    @Override
    public ResponseVO insert(int userId, String title, String content, Date createTime) {
        if(title.equals(""))
            return ResponseVO.buildFailure("请输入文章标题");
        if (title.length() > 150)
            return ResponseVO.buildFailure("标题过长");
        if (content.equals(""))
            return ResponseVO.buildFailure("请输入文章内容");
        try {
            Passage p=new Passage();
            p.setUserId(userId);
            p.setContent(content);
            p.setTitle(title);
            p.setCreateTime(createTime);
            blogMapper.insert(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("保存失败");
        }
        return ResponseVO.buildSuccess(true);
    }

    /**
     * 文章：改
     *
     * @param id
     * @param title
     * @param content
     * @param updateTime
     * @return
     */
    @Override
    public ResponseVO updateBlog(int id, String title, String content, Date updateTime) {
        if(title.equals(""))
            return ResponseVO.buildFailure("请输入文章标题");
        if (title.length() > 150)
            return ResponseVO.buildFailure("标题过长");
        if (content.equals(""))
            return ResponseVO.buildFailure("请输入文章内容");
        try {
            Passage p=new Passage();
            p.setId(id);
            p.setContent(content);
            p.setTitle(title);
            p.setRecentEditTime(updateTime);
            blogMapper.update(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("更新失败");
        }
        return ResponseVO.buildSuccess(true);
    }

    /**
     * 文章：删
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVO delete(Integer id) {
        try {
            blogMapper.delete(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("删除失败");
        }
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public List<PassageVO> searchPassages(String key) {
        System.out.println(key);
        List<Passage> passages=blogMapper.selectByKey("%"+key+"%");
        List<PassageVO> passageVOS=passages.stream().map(p -> {
            PassageVO passageVO = new PassageVO();
            passageVO.setId(p.getId());
            passageVO.setContent(p.getContent());
            passageVO.setCreateTime(p.getCreateTime());
            passageVO.setRecentEditTime(p.getRecentEditTime());
            passageVO.setTitle(p.getTitle());
            passageVO.setUserId(p.getUserId());
            return passageVO;
        }).collect(Collectors.toList());
        return passageVOS;
    }
}
