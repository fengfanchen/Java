package com.email.demo.async;


import com.email.demo.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


public class MailTask implements Runnable {


    private String code;
    private String email;
    private String mailFrom;
    private String domainName;
    private JavaMailSender javaMailSender;

    public MailTask(String code, String email, String mailFrom, String domainName, JavaMailSender javaMailSender){

        this.code = code;
        this.email = email;
        this.mailFrom = mailFrom;
        this.domainName = domainName;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void run() {

        //发送邮件
        javaMailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {

                System.out.println("开始发送邮件");
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setFrom(mailFrom);
                mimeMessageHelper.setTo(email);
                mimeMessageHelper.setSubject("一封激活邮件");
                StringBuilder sb = new StringBuilder();
                sb.append("<html><head></head><body>");
                sb.append("<a href=" + domainName + "activate?code=");
                sb.append(code);
                sb.append(">点击激活</a></body>");
                mimeMessageHelper.setText(sb.toString(), true);
                System.out.println("发送结束");
            }
        });
    }
}
