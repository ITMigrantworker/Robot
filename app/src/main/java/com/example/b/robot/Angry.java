package com.example.b.robot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

public class Angry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angry_layout);

        final ImageButton ibtn = (ImageButton) findViewById(R.id.back);
        WebView web = (WebView)findViewById(R.id.web_view);

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Angry.this, Main.class);
                startActivity(intent);

            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        Toast.makeText(Angry.this,"书籍是人类进步的阶梯",Toast.LENGTH_LONG).show();
        web.loadUrl("https://www.zhihu.com/signup?next=%2F");
    }
}
