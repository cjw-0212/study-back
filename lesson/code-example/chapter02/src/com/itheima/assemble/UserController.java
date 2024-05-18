package com.itheima.assemble;

public class UserController {
    private UserService userService;

    public UserController() {
        super();
    }

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    public void save() {
        this.userService.save();
        System.out.println("userController…save…");
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
