package com.email.demo.controller;

import com.email.demo.async.MailTask;
import com.email.demo.config.EmailConfig;
import com.email.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Random;

@Controller
public class EmailController {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserService userService;

    @Autowired
    EmailConfig emailConfig;

    @GetMapping("/")
    public String goRegPage(){

        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@RequestParam("userName") String userName,
                      @RequestParam("password") String password,
                      @RequestParam("email") String email){

        //code = 当前时间 + 位随机数
        String activeCode = String.valueOf(new Date().getTime()) + String.valueOf(new Random().nextInt(9999999));

        taskExecutor.execute(new MailTask(activeCode, email, emailConfig.getMailMailFrom(), emailConfig.getMailDomainName(), javaMailSender));

        userService.addUser(userName, password, email, activeCode);

        return "reg";
    }

}
