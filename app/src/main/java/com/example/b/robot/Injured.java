package com.example.b.robot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Injured extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injured_layout);

        new Thread() {
            @Override
            public void run() {
                String path = "https://news-at.zhihu.com/api/4/news/latest";
                try {
                    URL url = new URL(path);
                    HttpURLConnection coon = (HttpURLConnection) url.openConnection();
                    coon.setDoOutput(true);
                    coon.setRequestMethod("GET");
                    coon.setConnectTimeout(5000);


                    int code = coon.getResponseCode();


                    InputStream in = coon.getInputStream();


                    //


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }.start();
    }


    //封装一个把流转化成String类型的方法
    private static String getStringFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        is.close();
        String state = os.toString();// 把流中的数据转换成字符串,采用的编码是utf-8(模拟器默认编码)
        os.close();
        return state;

    }


}

