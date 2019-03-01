package com.example.b.robot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RedRock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redrock_layout);

        Button button = (Button)findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RedRock.this,"欢迎来到大佬的世界",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RedRock.this,ColorFulEgg.class);
                startActivity(intent);
            }
        });

    }
}
