package com.example.madapp1;

import android.app.Notification;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class Intent_Lifecycle extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_lifecycle);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implicit Intent
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0331 1234567"));
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thePlace = "University of Gujrat, Gujrat";
                Intent intent =new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=(" + thePlace + ")"));
                startActivity(intent);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: 0331 1234567"));
                intent.putExtra("sms_body",
                        "are you uni tomorrow?");
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"straight hitting golf clubs");
                startActivity(intent);
            }
        });
    }
}