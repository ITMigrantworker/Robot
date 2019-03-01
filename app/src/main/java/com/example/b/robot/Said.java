package com.example.b.robot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class Said extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.said_layout);

        ImageButton ibtn = (ImageButton) findViewById(R.id.back);
        final WebView web = (WebView) findViewById(R.id.web_view);

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Said.this, Main.class);
                startActivity(intent);

            }

        });
        web.loadUrl("https://www.bilibili.com/video/av40539572?from=search&seid=5306476619276241258");
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    if (url.startsWith("http") || url.startsWith("https")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    return true;
                }
                web.loadUrl(url);
                return true;
            }


        });
    }
}
