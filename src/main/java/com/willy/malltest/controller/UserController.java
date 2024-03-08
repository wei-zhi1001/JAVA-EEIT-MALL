package com.willy.malltest.controller;


import com.willy.malltest.model.User;
import com.willy.malltest.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/register")
    public String goRegister() {
        return "users/registerPage";
    }

    @GetMapping("/users/login")
    public String goLoginPage() {
        return "users/loginPage";
    }

    @PostMapping("/users/login")
    public String postLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model, HttpSession httpSession) {

        User result = userService.checkLogin(email, password);

        if(result != null) {
            httpSession.setAttribute("loginUsername", result.getUsername());
            httpSession.setAttribute("loginUserId", result.getUserID());
            model.addAttribute("loginMsg", "登入成功");
        }else {
            model.addAttribute("loginMsg", "帳號密碼錯誤，請重新輸入");
        }

        return "users/loginPage";
    }

    @PostMapping("/users/register")
    public String postRegister(
            @RequestParam("name") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model){

        boolean isExist = userService.checkIfUsernameExist(email);

        if(isExist) {
            model.addAttribute("errorMsg", "已經有此帳號，請重新輸入");
        }else {
            User newUsers = new User();
            newUsers.setUsername(username);
            newUsers.setEmail(email);
            newUsers.setPassword(password);
            newUsers.setAuthentication("1");

            Date today = new Date();
            newUsers.setRegisterDate(today);
            newUsers.setLastLoginTime(today);

            userService.addUsers(newUsers);
            model.addAttribute("okMsg", "註冊成功");
        }

        return "users/registerPage";
    }
}
