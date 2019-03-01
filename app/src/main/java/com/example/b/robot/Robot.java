package com.example.b.robot;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Robot extends AppCompatActivity {
//    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.robot_layout);

        //创建头像list
        final ArrayList photo = new ArrayList();
        //创建聊天记录list
        final ArrayList arrayList = new ArrayList();
        //创建时间list
        final ArrayList timeList = new ArrayList();





        final ImageButton back = (ImageButton) findViewById(R.id.back);
        Button sent = (Button) findViewById(R.id.sent);
        final EditText text = (EditText) findViewById(R.id.text);
        final ListView list = (ListView) findViewById(R.id.list);
        ImageView more = (ImageView)findViewById(R.id.more);




        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Robot.this,Setting.class);
                startActivity(intent);
            }
        });





//        //实例化 SQOpenHelper 传入上下文
//        CreatSQ creatSQ  = new CreatSQ(Rebort.this);
//
//        //获取一个可写的数据库
//        SQLiteDatabase sq = creatSQ.getReadableDatabase();
//



//          mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar == null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.yingyong);
//        }




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Robot.this, Boring.class);
                startActivity(intent);
            }
        });

        final File file = new File(getCacheDir(), "date.txt");


        //取出聊天记录
        try {

            FileInputStream in = new FileInputStream(file);
            String txt = getStringFromInputStream(in);
            // 用户 + 机器人 + 时间
            String chatRecord[] = txt.split("abdca");


            //判断文件夹是否为空
            if (chatRecord.length != 0) {
                ArrayList picture = new ArrayList();
                ArrayList user = new ArrayList();
                ArrayList time = new ArrayList();

                for (int i = 0; i < ((chatRecord.length + 1) / 3); i++) {
                    picture.add(R.drawable.resource5);
                    picture.add(R.drawable.tuling);

                    user.add(chatRecord[i * 3]);

                    user.add(chatRecord[i * 3 + 1]);

                    time.add(chatRecord[i * 3 + 2]);

                    time.add("");
                }


                List<Map<String, Object>> date = new ArrayList<>();

                for (int i = 0; i < picture.size(); i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("userText", user.get(i));
                    map.put("userPhoto", picture.get(i));
                    map.put("userTime", time.get(i));
                    map.put("rText", user.get(i + 1));
                    map.put("rPhoto", picture.get(i + 1));
                    i++;
                    date.add(map);
                    SimpleAdapter adapter = new SimpleAdapter(Robot.this, date, R.layout.information, new String[]{"userText", "userPhoto", "userTime", "rText", "rPhoto"}, new int[]{R.id.newText, R.id.newPhoto, R.id.newTime, R.id.text, R.id.photo});
                    list.setAdapter(adapter);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }




        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String message = text.getText().toString().trim();
                if (!message.isEmpty()) {
                    new Thread() {
                        @Override
                        public void run() {
                            String path = "http://openapi.tuling123.com/openapi/api/v2";
                            //创建url对象 ；路径
                            try {
                                URL url = new URL(path);

                                //获取httpUrlConnection 打开连接
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                                //发送请求 post
                                conn.setRequestMethod("POST");
                                conn.setReadTimeout(5000);


                                //   设置权限 可以让UrlConnection输出
                                conn.setDoOutput(true);
                                final OutputStream out = conn.getOutputStream();
                                out.write(transJson(message).toString().getBytes());
                                out.flush();
                                out.close();

                                text.getText().clear();

//                                //设置bar的状态 可见
//                                bar.setVisibility(View.VISIBLE);

                                //隐藏软键盘
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

                                //将listView拖到最后一个


                                //获取状态码 200 代表全部响应
                                int code = conn.getResponseCode();

                                if (code == 200) {
                                    showToast("发送成功");
                                    // 根据状态码 进行一系列的操作


                                    //获取json格式的返回信息
                                    InputStream text = conn.getInputStream();

                                    String response = getStringFromInputStream(text);

                                    JSONObject object = new JSONObject(response);
                                    String results = object.getString("results");

                                    final JSONArray array = new JSONArray(results);

                                    String information = "";
                                    for (int i = 0; i < array.length(); i++) {
                                        JSONObject result = array.getJSONObject(i);

                                        String values = result.getString("values");
                                        JSONObject object1 = new JSONObject(values);
                                        information = object1.getString("text");

                                    }
                                    final String finalInformation = information;
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            //创建txt文件存聊天记录
                                            try {

                                                FileOutputStream out = new FileOutputStream(file, true);

                                                Date now = new Date();
                                                SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                                                timeList.add(time.format(now));
                                                timeList.add("");
                                                photo.add(R.drawable.resource5);
                                                photo.add(R.drawable.tuling);
                                                arrayList.add(message);
                                                arrayList.add(finalInformation);

                                                String tidings = message + "abdca" + finalInformation + "abdca" + time.format(now) + "abdca";
                                                out.write(tidings.getBytes());
                                                out.flush();
                                                out.close();

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                            List<Map<String, Object>> date = new ArrayList<>();

                                            for (int i = 0; i < arrayList.size(); i++) {
                                                Map<String, Object> map = new HashMap<String, Object>();

                                                map.put("userText", arrayList.get(i));
                                                map.put("userPhoto", photo.get(i));
                                                map.put("userTime", timeList.get(i));
                                                map.put("rText", arrayList.get(i + 1));
                                                map.put("rPhoto", photo.get(i + 1));
                                                date.add(map);
                                                i++;
                                                SimpleAdapter adapter = new SimpleAdapter(Robot.this, date, R.layout.information, new String[]{"userText", "userPhoto", "userTime", "rText", "rPhoto"}, new int[]{R.id.newText, R.id.newPhoto, R.id.newTime, R.id.text, R.id.photo});
                                                list.setAdapter(adapter);
                                            }
                                            //listview 滑倒底部
                                            list.setSelection(list.getBottom());

                                        }


                                    });


                                } else {
                                    showToast("连接失败");
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } else {
                    Toast.makeText(Robot.this, "消息不能为空", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                mDrawerLayout.openDrawer(GravityCompat.END);
//                break;
//            default:
//        }
//        return true;
//    }






    public static JSONObject transJson(String text) throws JSONException {
        // 构造JSON请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reqType", "0");
        JSONObject perception = new JSONObject();
        JSONObject inputText = new JSONObject();
        inputText.put("text", text);
        perception.put("inputText", inputText);
        jsonObject.put("perception", perception);

        JSONObject inputImage = new JSONObject();
        inputImage.put("url", "imageUrl");
        jsonObject.put("inputImage", inputImage);

        JSONObject selfInfo = new JSONObject();
        JSONObject location = new JSONObject();
        location.put("city", "北京");
        location.put("province", "北京");
        location.put("street", "信息路");
        selfInfo.put("inputImage", inputImage);
        jsonObject.put("selfInfo", selfInfo);

        JSONObject userInfo = new JSONObject();
        userInfo.put("apiKey", "c1d87b9b698f413f88d9afe86133b4b7");
        userInfo.put("userId", "redRock");
        jsonObject.put("userInfo", userInfo);

        return jsonObject;
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


    //封装一个土司方法
    private void showToast(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Robot.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}
