package com.network_blog.back_end.controller.user;

import com.network_blog.back_end.bl.user.AccountService;
import com.network_blog.back_end.po.User;
import com.network_blog.back_end.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/api/user")
public class AccountController {
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm) {
        User user = accountService.login(userForm);
        if (user == null) {
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserVO userVO) {
        return accountService.registerAccount(userVO);
    }

    @GetMapping("/{id}/getUserInfo")
    public ResponseVO getUserInfo(@PathVariable int id) {
        User user = accountService.getUserInfo(id);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

    @GetMapping("/{id}/getUserName")
    public ResponseVO getUserName(@PathVariable int id){
        User user=accountService.getUserInfo(id);
        if(user==null)
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        return ResponseVO.buildSuccess(user.getUserName());
    }

    @PostMapping("/{id}/userInfo/update")
    public ResponseVO updateInfo(@RequestBody UserInfoVO userInfoVO, @PathVariable int id){
        return accountService.updateUserInfo(id,userInfoVO.getPassword(),userInfoVO.getUserName(),userInfoVO.getDescription());
    }

    @PostMapping("/addFriendUrl")
    public ResponseVO addFriendUrl(@RequestBody FriendUrlVO friendUrlVO){
        return accountService.addFriendUrl(friendUrlVO);
    }

    @PostMapping("/deleteFriendUrl")
    public ResponseVO deleteFriendUrl(@RequestBody FriendUrlVO friendUrlVO){
        return accountService.deleteFriendUrl(friendUrlVO);
    }

    @GetMapping("/{id}/getFriendUrl")
    public ResponseVO getFriendUrl(@PathVariable Integer id){
        List<String> urls=accountService.getFriendUrl(id);
        if(urls.size()==0) return ResponseVO.buildFailure("FriendUrl not exist!");
        else return ResponseVO.buildSuccess(urls);
    }
}

