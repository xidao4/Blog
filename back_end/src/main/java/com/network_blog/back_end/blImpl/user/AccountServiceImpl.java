package com.network_blog.back_end.blImpl.user;

import com.network_blog.back_end.bl.user.AccountService;
import com.network_blog.back_end.data.user.AccountMapper;
import com.network_blog.back_end.po.User;
import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.vo.UserForm;
import com.network_blog.back_end.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String UPDATE_ERROR = "修改失败";
    private final static String VIP_EXIST = "已是会员";
    private final static String MD5_STR="tttt";
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public ResponseVO registerAccount(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()+MD5_STR).getBytes()));
        try {
            accountMapper.createNewAccount(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public User login(UserForm userForm) {
        User user = accountMapper.getAccountByName(userForm.getEmail());
        if (null == user || !user.getPassword().equals(DigestUtils.md5DigestAsHex((userForm.getPassword()+MD5_STR).getBytes()))) {
            return null;
        }
        return user;
    }

    @Override
    public User getUserInfo(int id) {
        User user = accountMapper.getAccountById(id);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public ResponseVO updateUserInfo(int id, String password, String username,String description) {
        try {
            password=DigestUtils.md5DigestAsHex((password+MD5_STR).getBytes());
            accountMapper.updateAccount(id, password, username,description);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(UPDATE_ERROR);
        }
        return ResponseVO.buildSuccess(true);
    }
}

