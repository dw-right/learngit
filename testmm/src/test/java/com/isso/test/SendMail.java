package com.isso.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;

public class SendMail {

    //笑话接口api Key
    private final static String apiKey = "28cb4b6493124d8e8c898f9ce89a0fd4";

    /**
     * 主程序
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //用okHttp调用笑话接口
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.avatardata.cn/Joke/NewstJoke?key=" +apiKey)
                .build();
        Response response = client.newCall(request).execute();//返回结果

        //处理返回结果，找到最短的笑话，因为139邮箱的短信提示最多显示140个字
        JSONObject shortJoke = null;
        if (response.isSuccessful()) {
            //将返回结果转换为Json对象（返回结果为json格式，具体返回参数
            // 
            JSONObject resp = JSON.parseObject(response.body().string());
            System.out.println(resp);
            JSONArray contentList = resp.getJSONArray("result");

            //遍历查找最短的笑话
            int min = 10000;
            for (int j = 0; j < contentList.size(); j++) {
                JSONObject one = contentList.getJSONObject(j);
                int length = one.getString("content").length();
                if (length < min) {
                    shortJoke = one;
                    min = length;
                }
            }

        }

        //打印输出得到的笑话，便于调试
        System.out.println(shortJoke.toJSONString());

        //注：建议使用主流邮箱，我曾遇到用sohu发出邮件丢失的情况，
        //不仅仅是在程序这里，包括在sohu邮箱客户端测试也发生了邮件丢失
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
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
        Transport ts = session.getTransport();
        //3、发件邮箱的帐号和密码。
        ts.connect("578486558@qq.com", "dingwei58709787");
        //4、创建邮件（Java用Message对象封装（代表）邮件），其中，最后一个参数含义：
        //（收件人<-->RecipientType.TO，抄送<-->RecipientType.CC，密送<-->RecipientType.BBC）
        Message message = createSimpleMail(session, "nice dream", shortJoke.getString("content"), Message.RecipientType.TO);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }


    public static MimeMessage createSimpleMail(Session session, String title, String content, Message.RecipientType type)
            throws Exception {
        //创建MIME邮件对象
        MimeMessage message = new MimeMessage(session);

        //指定发件人昵称
        String nick = MimeUtility.encodeText("听个笑话睡个觉", "utf-8", "B");//避免乱码

        //指明邮件的发件人
        message.setFrom(new InternetAddress(nick + "<578486558@qq.com>"));

        //指明邮件的收件人
        //message.addRecipient(type, new InternetAddress("flower.monk@foxmail.com"));
        message.addRecipient(type, new InternetAddress("15825923591@139.com"));

        //邮件主题
        message.setSubject(title);

        //邮件的文本内容，加入一些符号让结尾美美哒(^.^)(^.^)
        message.setContent(content.substring(0, content.length() - 1) + "==>>(^.^)(^.^)晚安!", "text/html;charset=UTF-8");

        //返回创建好的邮件对象
        return message;
    }
}