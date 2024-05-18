package com.itheima.assemble;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void save() {
        this.userDao.save();
        System.out.println("userService…save…");
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}