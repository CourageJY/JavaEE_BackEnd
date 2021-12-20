package com.pet.login.service;

import com.pet.login.entity.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("MailService")
@EnableAutoConfiguration
@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;//一定要用@Autowired

    @Autowired
    private MailProperties mailProperties;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 给前端输入的邮箱，发送验证码
     *
     * @param email 要给发送的邮箱的地址
     * @param map   来存一对邮箱和验证码的键值对
     * @return 发送验证码成功与否
     */
    public boolean sendMimeMail(String email, Map<String, Code> map, String code) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject("验证码邮件");//主题

            Code cd=new Code(code);

            //将随机数放置到session中
            map.put(email, cd);

            mailMessage.setText("您收到的验证码是：" + code);//内容

            mailMessage.setTo(email);//发给谁

            mailMessage.setFrom(mailProperties.getUsername());//你自己的邮箱

            mailSender.send(mailMessage);//发送

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}