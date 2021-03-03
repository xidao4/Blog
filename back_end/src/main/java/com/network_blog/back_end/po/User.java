package com.network_blog.back_end.po;

//import lombok.Data;
//在编译阶段会根据注解自动生成对应的方法，data包含get/set/hashCode/equals/toString等方法
//使得实体类很简洁（可以在bean上直接使用这些方法），不用写一堆方法
//@Data
//@Slf4j
public class User {
    private Integer id;
    private String email;
    private String password;
    private String userName;
    private String description;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
