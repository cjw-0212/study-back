package com.itheima.domain;

/**
 * 用户包装类
 */
public class UserVO {
    private User[] users;
    private User user;
    private Integer[] ids;

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
