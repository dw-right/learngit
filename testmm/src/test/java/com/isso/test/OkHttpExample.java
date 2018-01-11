package com.isso.test;

import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;

;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import static com.isso.test.SendMail.createSimpleMail;


public class OkHttpExample {
    public static void main(String[] args) throws Exception {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
        int rows=3;
        int page=(int)(Math.random()*1001);
        String url="http://api.avatardata.cn/Joke/QueryJokeByTime?key=9e76e8444cf04de8b85f1d3841b46cc0&page="+page+"&rows="+rows+"rows+&sort=asc&time=1418745237";
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
                okhttp3.Response response= null;
                try {
                    response = okHttpClient.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String jsonstr = null;
        if(response.isSuccessful()){
            try {
                jsonstr=response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       QueryResultInfo queryResultInfo= JSON.parseObject(jsonstr,QueryResultInfo.class);
        for(int i=0;i<rows;i++) {
            if(queryResultInfo.getResult().get(i).getContent().length()<100) {
                jsonstr = queryResultInfo.getResult().get(i).getContent();
                break;
            }
               // System.out.println(queryResultInfo.getResult().get(i));
        }
        System.out.println(jsonstr);
        //注：建议使用主流邮箱，我曾遇到用sohu发出邮件丢失的情况，
        //不仅仅是在程序这里，包括在sohu邮箱客户端测试也发生了邮件丢失
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        //使用STARTTLS,对于其它协议（如pop3，imap），只需要将smtp改为相应协议即可（pop3要改为pop）
        // 若要使用SSL，只需要设置mail.smtp.ssl.enable为true
        prop.put("mail.smtp.starttls.enable", "true");

        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，便于看到发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
                Transport ts = null;
                try {
                    ts = session.getTransport();
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                }
                //3、发件邮箱的帐号和密码。
                try {
                    ts.connect("578486558@qq.com", "rxcvkchwmwjebbhg");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                //4、创建邮件（Java用Message对象封装（代表）邮件），其中，最后一个参数含义：
        //（收件人<-->RecipientType.TO，抄送<-->RecipientType.CC，密送<-->RecipientType.BBC）
                Message message = null;
                try {
                    message = createSimpleMail(session, "nice dream", jsonstr, Message.RecipientType.TO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //5、发送邮件
                try {
                    ts.sendMessage(message, message.getAllRecipients());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    ts.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 60 * 1000;
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    } // end of main


    public static MimeMessage createSimpleMail(Session session, String title, String content, Message.RecipientType type)
            throws Exception {
        //创建MIME邮件对象
        MimeMessage message = new MimeMessage(session);

        //指定发件人昵称
        String nick = MimeUtility.encodeText("笑话你懂得", "utf-8", "B");//避免乱码

        //指明邮件的发件人
        message.setFrom(new InternetAddress(nick + "<578486558@qq.com>"));

        //指明邮件的收件人
        //message.addRecipient(type, new InternetAddress("flower.monk@foxmail.com"));
        message.addRecipient(type, new InternetAddress("15825923591@139.com"));

        //邮件主题
        message.setSubject(title);

        //邮件的文本内容，加入一些符号让结尾美美哒(^.^)(^.^)
        message.setContent(content + "(^.^)(^.^)晚安!", "text/html;charset=UTF-8");

        //返回创建好的邮件对象
        return message;
    }
}
