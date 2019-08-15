package com.yhchdev.rosesorting.controller;


import com.yhchdev.rosesorting.entity.User;
import com.yhchdev.rosesorting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    @Autowired
    UserRepository userRepository;

    @PostMapping(value ="/user/login") //接收post请求
    public String Login(@RequestParam("userName") String username,
                        @RequestParam("userPassword") String userpassword,
                        Map<String,Object> map, HttpSession session)
    {
        User user = userRepository.findUserByUserName(username);
        System.out.println(user.toString());

        if(user == null){
            map.put("msg","用户名或密码错误");
            return "login";
        }else {
            if (user.getUserPassword().equals(userpassword)){
            //将登陆信息绑定到session中
            session.setAttribute("loginUser",username);
            //登录成功，为防止表单重复提交,重定向到主页
            return "redirect:/Main.html";
            }else {
                map.put("msg","用户名或密码错误");
                return "login";
            }
        }

    }


}
