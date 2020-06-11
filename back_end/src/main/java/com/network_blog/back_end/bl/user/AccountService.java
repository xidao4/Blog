package com.network_blog.back_end.bl.user;

import com.network_blog.back_end.po.User;
import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.vo.UserForm;
import com.network_blog.back_end.vo.UserVO;

/**
 * @author huwen
 * @date 2019/3/23
 */
public interface AccountService {

    /**
     * 注册账号
     *
     * @return
     */
    ResponseVO registerAccount(UserVO userVO);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     *
     * @return
     */
    User login(UserForm userForm);

    /**
     * 获取用户个人信息
     * @param id
     * @return
     */
    User getUserInfo(int id);

    /**
     * 更新用户个人信息
     * @param id
     * @param password
     * @param username
     * @return
     */
    ResponseVO updateUserInfo(int id, String password, String username,String description);

}
