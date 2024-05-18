package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
public class RegisterController {
    //跳转到注册页register.html
    @GetMapping("/toRegisterPage")
    public String toRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/checkUser")
    public String checkUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        return "results";
    }

    @ModelAttribute("currentYear")
    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @ModelAttribute("institute")
    public String getInstitute() {
        return "广东财经大学";
    }

}
