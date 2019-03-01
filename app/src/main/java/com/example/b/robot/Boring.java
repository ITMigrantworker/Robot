package com.example.b.robot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Boring extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boring_layout);

        Button robot = (Button)findViewById(R.id.robot);
        Button mathGame = (Button)findViewById(R.id.mathGame);
        ImageButton back = (ImageButton)findViewById(R.id.back);


        robot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent的跳转 运用图灵机器人的api
                Intent intent = new Intent(Boring.this,Robot.class);
                startActivity(intent);
            }
        });

        mathGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Boring.this,MathGame.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Boring.this,Main.class);
                startActivity(intent);
            }
        });
    }
}
