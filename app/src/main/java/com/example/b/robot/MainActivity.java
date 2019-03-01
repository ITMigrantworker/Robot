package com.example.b.robot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final SharedPreferences sp = getSharedPreferences("user", 0);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText psw = (EditText) findViewById(R.id.psw);
        final TextView text = (TextView) findViewById(R.id.text);
        TextView change =(TextView)findViewById(R.id.change);
        Button btn = (Button) findViewById(R.id.btn);
        final CheckBox box = (CheckBox) findViewById(R.id.box);



        //存checkBox状态的sp
        final SharedPreferences spc = getSharedPreferences("checkBoxCondition", 0);
        final SharedPreferences.Editor condition = spc.edit();


        //向edit里面传入用户名
        String names = sp.getString("lastUsername", "");
        name.setText(names);

        //如果checkBox被勾选 就传入密码
        if (spc.getString("checkBoxCondition", "").equals("true")) {
            box.setChecked(true);
            String psws = sp.getString(names + " ", "");
            psw.setText(psws);
        }
        //如何保存checkBox的状态


        //实现的注册跳转
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        //实现更改密码
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Change.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString().trim();
                String Psw = psw.getText().toString().trim();
                //判断是否为空
                if (Name.isEmpty() || Psw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "账号或密码不能为空", Toast.
                            LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor key = sp.edit();
                    //判断账号是否存在
                    if (!Name.equals(sp.getString(Name, ""))) {
                        Toast.makeText(MainActivity.this, "该用户不存在", Toast.LENGTH_LONG).show();
                    } else {
                        //判断密码是否正确
                        if (!Psw.equals(sp.getString(Name + " ", ""))) {
                            Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.
                                    LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, Main.class);

                            //保存上一次登陆的账号
                            key.putString("lastUsername", Name);
                            key.apply();
                            //存checkBox的勾选状态而建立的一个sp

                            if (box.isChecked()) {
                                condition.putString("checkBoxCondition", "true");
                                condition.apply();

                            }else{
                                condition.putString("checkBoxCondition","false");
                                condition.apply();
                            }

                            startActivity(intent);
                            //判断程序是否保存成功可以用.commit方法
                        }
                    }
                }
            }
        });
    }
}
