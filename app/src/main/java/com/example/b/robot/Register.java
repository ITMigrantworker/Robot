package com.example.b.robot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


        final EditText name = (EditText) findViewById(R.id.name);
        final EditText psw = (EditText) findViewById(R.id.psw);
        final EditText ensurepsw = (EditText) findViewById(R.id.ensurepsw);

        ImageButton btn = (ImageButton) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = name.getText().toString().trim();
                String psws = psw.getText().toString().trim();
                String ensurepsws = ensurepsw.getText().toString().trim();

                if (names.isEmpty() || psws.isEmpty() || ensurepsws.isEmpty()) {
                    Toast.makeText(Register.this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
                } else {
                    if (!psws.equals(ensurepsws)) {
                        Toast.makeText(Register.this, "两次输入的密码不一致", Toast.LENGTH_LONG).show();
                    } else {
                        SharedPreferences sp = getSharedPreferences("user", 0);
                        SharedPreferences.Editor key = sp.edit();
                        //判断用户名是否有重复
                        if (names.equals(sp.getString(names, ""))) {
                            Toast.makeText(Register.this, "用户名已存在", Toast.LENGTH_LONG).show();
                        } else {
                            key.putString(names,names);
                            key.putString("lastUsername", names);
                            //密码的key 是用户名+空格
                            key.putString(names + " ", psws);
                            key.apply();
                            //putString 方法 存数据
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(Register.this,"注册成功",Toast.LENGTH_LONG).show();
                        }


                    }
                    //注册界面跳转
                }
            }
        });
    }
}
