package com.trvqd.store.test;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class TestEmail {
    public static void main(String[] atgs){

        try {
            //发送方邮件服务器相关配置
            Properties props= new Properties();
            props.setProperty("mail.host","smtp.qq.com");
            props.setProperty("mail.smtp.auth","true");
            //设置验证器
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("839853185@qq.com","aytyfpnmibimbcgg");
                }
            };
            //1.与服务器建立连接
            Session session = Session.getDefaultInstance(props,authenticator);
            //2.编写邮件
            Message message = new MimeMessage(session);
            //2.1发件人
            message.setFrom(new InternetAddress("839853185@qq.com"));
            //2.2收件人： to(收件人)，cc（抄送），bcc（暗送，密送）
            message.setRecipient(Message.RecipientType.TO,new InternetAddress("xiaopeng.wang@qaii.ac.cn"));
            //2.3主题
            message.setSubject("这是一封来自java的测试邮件");
            //2.4内容
            message.setContent("这是来自java的测试内容","text/html;charset=utf-8");
            //Multipart multipart = new MimeMultipart("这是一封来自java的测试邮件");
            //3.将消息发出
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
