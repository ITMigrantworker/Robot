package com.example.b.robot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageButton boring = (ImageButton)findViewById(R.id.boring);
        ImageButton money  = (ImageButton)findViewById(R.id.money);
        ImageButton said = (ImageButton)findViewById(R.id.said);
        ImageButton angry = (ImageButton)findViewById(R.id.angry);
        ImageButton hurt = (ImageButton)findViewById(R.id.hurt);

        boring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Boring.class);
                startActivity(intent);
            }
        });
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Money.class);
                startActivity(intent);

            }
        });
        //关于pagerView的内容
        said.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Said.class);
                startActivity(intent);
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Angry.class);
                startActivity(intent);
            }
        });

        hurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Know.class);
                startActivity(intent);
                Toast.makeText(Main.this,"未完待续",Toast.LENGTH_LONG).show();
            }
        });



    }
}
