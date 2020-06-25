package com.network_blog.back_end.data.user;
import com.network_blog.back_end.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


@Mapper
@Repository
public interface AccountMapper {

    /**
     * 创建一个新的账号
     *
     * @return
     */
     int createNewAccount(User user);

    /**
     * 根据用户名查找账号
     * @param email
     * @return
     */
     User getAccountByName(@Param("email") String email);

     User getAccountById(@Param("id") int id);

    /**
     * 更新用户信息
     * @param id
     * @param password
     * @param username
     * @return
     */
     int updateAccount(@Param("id") int id, @Param("password") String password, @Param("userName") String username,@Param("description") String description);

     int setUrl(@Param("id") Integer id, @Param("url") String url);
}
