package com.example.b.robot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Change extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_layout);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText psw = (EditText) findViewById(R.id.psw);
        final EditText newpsw = (EditText) findViewById(R.id.newpsw);
        ImageButton btn = (ImageButton) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString().trim();
                String Psw = psw.getText().toString().trim();
                String Newpsw = newpsw.getText().toString().trim();

                if (Newpsw.isEmpty() || Psw.isEmpty() || Newpsw.isEmpty()) {
                    Toast.makeText(Change.this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();

                } else {
                    //判断用户是否存在
                    SharedPreferences sp = getSharedPreferences("user", 0);
                    if (sp.getString(Name, "").isEmpty()) {
                        Toast.makeText(Change.this, "用户不存在", Toast.LENGTH_LONG).show();

                    } else {
                        //判断密码是否错误
                        if (!sp.getString(Name + " ", "").equals(Psw)) {
                            Toast.makeText(Change.this, "密码错误", Toast.LENGTH_LONG).show();
                        } else {
                            if (Newpsw.equals(Psw)) {
                                Toast.makeText(Change.this, "你丫的改啥密码鸭", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences.Editor key = sp.edit();
                                key.putString(Name + " ", Newpsw);
                                key.apply();
                                Toast.makeText(Change.this, "密码修改成功", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Change.this, MainActivity.class);
                                startActivity(intent);
                            }

                        }
                    }
                }

            }
        });
    }
}
