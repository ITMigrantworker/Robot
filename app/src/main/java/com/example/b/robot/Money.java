package com.example.b.robot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Money extends AppCompatActivity {

    String title[] = {"山东某男子月入百万，原因竟是这样", "X鱼某年轻女主播凭这样竟能轻松",
            "马云马化腾有钱的原因竟是","重邮移动开发部某男子入职今日头条原因竟是","月薪6位数的程序员需要具备的素质有",
            "想要入职腾讯，"+ "网易，阿里等企业需要具备的素质","黄师姐这么牛逼的原因竟然是因为他","山东某男子月入百万，原因竟是这样", "X鱼某年轻女主播凭这样竟能轻松",
            "马云马化腾有钱的原因竟是","重邮移动开发部某男子入职今日头条原因竟是","月薪6位数的程序员需要具备的素质有",
            "想要入职腾讯，"+ "网易，阿里等企业需要具备的素质","黄师姐这么牛逼的原因竟然是因为他","山东某男子月入百万，原因竟是这样", "X鱼某年轻女主播凭这样竟能轻松",
            "马云马化腾有钱的原因竟是","重邮移动开发部某男子入职今日头条原因竟是","月薪6位数的程序员需要具备的素质有",
            "想要入职腾讯，"+ "网易，阿里等企业需要具备的素质","黄师姐这么牛逼的原因竟然是因为他","山东某男子月入百万，原因竟是这样", "X鱼某年轻女主播凭这样竟能轻松",
            "马云马化腾有钱的原因竟是","重邮移动开发部某男子入职今日头条原因竟是","月薪6位数的程序员需要具备的素质有",
            "想要入职腾讯，"+ "网易，阿里等企业需要具备的素质","黄师姐这么牛逼的原因竟然是因为他"};
    String text[] = {"据悉，该男子姓王曾梦想自己能中五百万，为了每天都能买上巨额彩票，该男子努力工作终于有了百万收入", "X鱼一姐五五开，因刻苦钻研自瞄黑科技被许多人封杀，在科研最艰难的时候，她没有放弃最终在打出24杀吃鸡的华丽战绩", "马云有支付宝，马化腾有微信，而你有手机 2333","加入红岩移动开发部入职头条年薪百万不是梦","别做梦了 好好学习吧","答案很简单，你只要像xxx一样牛逼就行","黄师姐这么牛逼，其实我也不知道为什么","据悉，该男子姓王曾梦想自己能中五百万，为了每天都能买上巨额彩票，该男子努力工作终于有了百万收入", "X鱼一姐五五开，因刻苦钻研自瞄黑科技被许多人封杀，在科研最艰难的时候，她没有放弃最终在打出24杀吃鸡的华丽战绩", "马云有支付宝，马化腾有微信，而你有手机 2333","加入红岩移动开发部入职头条年薪百万不是梦","别做梦了 好好学习吧","答案很简单，你只要像xxx一样牛逼就行","黄师姐这么牛逼，其实我也不知道为什么","据悉，该男子姓王曾梦想自己能中五百万，为了每天都能买上巨额彩票，该男子努力工作终于有了百万收入", "X鱼一姐五五开，因刻苦钻研自瞄黑科技被许多人封杀，在科研最艰难的时候，她没有放弃最终在打出24杀吃鸡的华丽战绩", "马云有支付宝，马化腾有微信，而你有手机 2333","加入红岩移动开发部入职头条年薪百万不是梦","别做梦了 好好学习吧","答案很简单，你只要像xxx一样牛逼就行","黄师姐这么牛逼，其实我也不知道为什么","据悉，该男子姓王曾梦想自己能中五百万，为了每天都能买上巨额彩票，该男子努力工作终于有了百万收入", "X鱼一姐五五开，因刻苦钻研自瞄黑科技被许多人封杀，在科研最艰难的时候，她没有放弃最终在打出24杀吃鸡的华丽战绩", "马云有支付宝，马化腾有微信，而你有手机 2333","加入红岩移动开发部入职头条年薪百万不是梦","别做梦了 好好学习吧","答案很简单，你只要像xxx一样牛逼就行","黄师姐这么牛逼，其实我也不知道为什么"};

    int image[] = {R.drawable.programer,R.drawable.programer2,R.drawable.programer3,R.drawable.programer4,R.drawable.programer5,R.drawable.program6,R.drawable.program7,R.drawable.programer,R.drawable.programer2,R.drawable.programer3,R.drawable.programer4,R.drawable.programer5,R.drawable.program6,R.drawable.program7,R.drawable.programer,R.drawable.programer2,R.drawable.programer3,R.drawable.programer4,R.drawable.programer5,R.drawable.program6,R.drawable.program7,R.drawable.programer,R.drawable.programer2,R.drawable.programer3,R.drawable.programer4,R.drawable.programer5,R.drawable.program6,R.drawable.program7};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_layout);

        ImageButton ibtn = (ImageButton) findViewById(R.id.back);
        ListView lv = (ListView) findViewById(R.id.list);

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Money.this, Main.class);
                startActivity(intent);
            }
        });

        //创建集合date
        List<Map<String, Object>> date = new ArrayList<Map<String, Object>>();

        //循环 放入数组里面的东西
        for (int i = 0; i < title.length; i++) {
            //创建map
            Map<String, Object> listItem = new HashMap<String, Object>();

            listItem.put("image", image[i]);
            listItem.put("title", title[i]);
            listItem.put("text", text[i]);

            date.add(listItem);

            //SimpleAdapter 需要传入五个参数 上下文 集合date 布局 from to
            SimpleAdapter adapter = new SimpleAdapter(Money.this, date, R.layout.item, new String[]{"image", "title", "text"}, new int[]{R.id.image, R.id.title, R.id.text});

            lv.setAdapter(adapter);

        }


        //创建ArrayAdapter 传入四个参数 上下文 布局  传入数据的控件id 数组
//        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Money.this,R.layout.item,
//                R.id.title,title);
//        lv.setAdapter(adapter);


    }
    //定义数据适配器
    private class myAdapter extends BaseAdapter {

        //一共有多少数据
        @Override
        public int getCount() {
            return 100;
        }

        //位子和数组排列对应
        @Override
        public Object getItem(int position) {
            return null;
        }

        //返回position位子对应的id
        @Override
        public long getItemId(int position) {
            return 0;
        }

        //获取view 用来显示listView的数据 一个条目有多少东西

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null){
                //打气筒 View.inflate 获取系统服务
                //把一个xml的布局转化成一个view
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.item,null);
            }else{
                view = convertView;
            }
            return view;
        }



    }
}
