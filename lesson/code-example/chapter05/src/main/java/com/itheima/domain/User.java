package com.itheima.domain;

import com.itheima.validation.MyPasswordConstraint;
import com.itheima.validation.PasswordMatchConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@PasswordMatchConstraint
public class User {
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 4, max = 50, message = "用户名长度必须在4~50个字符之间")
    private String username;
    @NotNull
    @MyPasswordConstraint
    private String password;
    @NotNull
    private String matchingpwd;
    @Pattern(regexp = "^1[356789]\\d{9}$", message = "手机号不合法")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingpwd() {
        return matchingpwd;
    }

    public void setMatchingpwd(String matchingpwd) {
        this.matchingpwd = matchingpwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
