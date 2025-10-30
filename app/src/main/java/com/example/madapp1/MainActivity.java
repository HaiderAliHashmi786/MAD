package com.example.madapp1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        layout=findViewById(R.id.main);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.CYAN);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.GREEN);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.MAGENTA);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity();
            }
        });
        Toast.makeText(this, "This on create function", Toast.LENGTH_SHORT).show();
    }
    private void startActivity(){
        Intent myintent=new Intent(this,MainActivity2.class);
        startActivity(myintent);
    }
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "This on Start function", Toast.LENGTH_SHORT).show();
    }
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "This on Resume function", Toast.LENGTH_SHORT).show();
    }
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "This on Pause function", Toast.LENGTH_SHORT).show();
    }
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "This on Stop function", Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "This on Destroy function", Toast.LENGTH_SHORT).show();
    }
}