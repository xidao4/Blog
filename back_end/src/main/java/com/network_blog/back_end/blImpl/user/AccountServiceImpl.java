package com.network_blog.back_end.blImpl.user;

import com.network_blog.back_end.bl.user.AccountService;
import com.network_blog.back_end.data.user.AccountMapper;
import com.network_blog.back_end.po.User;
import com.network_blog.back_end.vo.FriendUrlVO;
import com.network_blog.back_end.vo.ResponseVO;
import com.network_blog.back_end.po.FriendUrl;
import com.network_blog.back_end.data.user.FriendUrlMapper;
import com.network_blog.back_end.vo.UserForm;
import com.network_blog.back_end.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String UPDATE_ERROR = "修改失败";
    private final static String VIP_EXIST = "已是会员";
    private final static String MD5_STR="tttt";
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private FriendUrlMapper friendUrlMapper;

    @Override
    public ResponseVO registerAccount(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()+MD5_STR).getBytes()));
        User user1=accountMapper.getAccountByName(userVO.getEmail());
        if(user1==null) {
            accountMapper.createNewAccount(user);
            return ResponseVO.buildSuccess(true);
        }
        else return ResponseVO.buildFailure(ACCOUNT_EXIST);

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

    @Override
    public List<String> getFriendUrl(Integer userId){
        return friendUrlMapper.retrieveFriendUrl(userId);
    }

    @Override
    public ResponseVO addFriendUrl(FriendUrlVO friendUrlVO){
        Integer userId=friendUrlVO.getUserId();
        FriendUrl friendUrl=new FriendUrl();
        friendUrl.setUrl(friendUrlVO.getUrl());
        friendUrl.setUserId(friendUrlVO.getUserId());
        List<String> urls=friendUrlMapper.retrieveFriendUrl(userId);
        for(int i=0;i<urls.size();i++){
            if(urls.get(i).equals(friendUrl.getUrl()))  return ResponseVO.buildFailure("Friendurl already exist!");

        }
        return ResponseVO.buildSuccess(friendUrlMapper.addFriendUrl(friendUrl));
    }

    @Override
    public ResponseVO deleteFriendUrl(FriendUrlVO friendUrlVO){
        List<String> urls=friendUrlMapper.retrieveFriendUrl(friendUrlVO.getUserId());
        FriendUrl friendUrl=new FriendUrl();
        friendUrl.setUserId(friendUrlVO.getUserId());
        friendUrl.setUrl(friendUrlVO.getUrl());
        for(int i=0;i<urls.size();i++){
            if(urls.get(i).equals(friendUrl.getUrl())){
                return ResponseVO.buildSuccess(friendUrlMapper.deleteFriendUrl(friendUrl));
            }
        }
        return ResponseVO.buildFailure("Friendurl not exist!");
    }

    @Override
    public ResponseVO setUrl(Integer id,String url){
        accountMapper.setUrl(id,url);
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public String getUrl(Integer id){
        return accountMapper.getAccountById(id).getUrl();
    }
}

