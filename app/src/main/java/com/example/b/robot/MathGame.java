package com.example.b.robot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MathGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_layout);

        ImageButton button = (ImageButton) findViewById(R.id.btn);
        final EditText text = (EditText) findViewById(R.id.answer);
        final int n = (int) (Math.random() * 100);
        final ImageButton ibtn = (ImageButton) findViewById(R.id.back);

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathGame.this, Boring.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //猜数游戏
            public void onClick(View v) {
                String answer = text.getText().toString().trim();
                if (answer.isEmpty()) {
                    Toast.makeText(MathGame.this, "您未输入数字", Toast.LENGTH_LONG).show();
                } else {
                    Integer answers = Integer.parseInt(answer);

                    if (answers == 666) {
                        Intent intent = new Intent(MathGame.this, RedRock.class);
                        startActivity(intent);

                    } else {
                        if (answers > 100 || answers < 0) {
                            Toast.makeText(MathGame.this, "输入错误，请重新输入", Toast.LENGTH_LONG).show();
                        } else {
                            if (n == answers) {
                                Toast.makeText(MathGame.this, "Congratulation", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MathGame.this, MathGameOutCome.class);
                                startActivity(intent);
                            } else {
                                if (n < answers) {
                                    Toast.makeText(MathGame.this, "你猜的数偏大", Toast.LENGTH_LONG).show();
                                    text.getText().clear();

                                } else {
                                    Toast.makeText(MathGame.this, "你猜的数偏小", Toast.LENGTH_LONG).show();
                                    text.getText().clear();

                                }
                            }

                        }
                    }
                }

            }


        });


    }
}
