package com.network_blog.back_end.data.user;
import com.network_blog.back_end.po.FriendUrl;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface FriendUrlMapper {

    int addFriendUrl(FriendUrl friendUrl);

    int deleteFriendUrl(FriendUrl friendUrl);

    List<String> retrieveFriendUrl(@Param("userId") Integer userId);
}
