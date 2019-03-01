package com.example.b.robot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorFulEgg extends AppCompatActivity {

    private String[] name = {"黄师姐", "里脊", "清夏学姐", "大锤学姐", "子来学姐", "海航学长", "约饭学长"};
    private String[] say = {"为什么我这么屌", "楼上的那个，是不是不想混了", "唉好烦鸭，今天又被表白了", "那个谁谁谁，来个禁言套餐？", "开车了，请准备", "重感冒", "我想找一个女朋友"};
    private int[] image = {R.drawable.resource3, R.drawable.resourceimage1, R.drawable.resource5, R.drawable.resource4, R.drawable.resourceimage2, R.drawable.resourceimage7, R.drawable.resourceimage9,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorfulegg_layout);

        ListView lv = (ListView) findViewById(R.id.list);

        List<Map<String, Object>> date = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", image[i]);
            map.put("name", name[i]);
            map.put("say", say[i]);
            date.add(map);
            SimpleAdapter adapter = new SimpleAdapter(ColorFulEgg.this, date, R.layout.end_item, new String[]{"image", "name", "say"}, new int[]{R.id.image, R.id.name, R.id.say});
            lv.setAdapter(adapter);
        }



    }
}
