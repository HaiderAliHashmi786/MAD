package com.example.madapp1;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView contentlist;
    ArrayList<String> dataList;
    String data[] = {"activity","intent"};
    NotificationChannel ch = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        contentlist=findViewById(R.id.list1);
        dataList=new ArrayList<>();
        dataList.add("Activity life cycle");
        dataList.add("Intent");
        dataList.add("Notifictaion");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ch = new NotificationChannel("ch_1000","chat_channel", NotificationManager.IMPORTANCE_DEFAULT);
        }
        ArrayAdapter adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dataList);
        contentlist.setAdapter(adapter);
        contentlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position)
                {
                    case 0:
                        Activity_lifecycle();
                        break;
                    case 1:
                        Intent_Activity();
                        break;
                    case 2:
                        Send_Notification();
                        break;
                }
            }
        });
    }
    protected void Activity_lifecycle()
    {
        //Explicit Intent
        Intent myintent = new Intent(this, activity_lifecycle.class);
        startActivity(myintent);

    }
    protected void Intent_Activity()
    {
        //Explicit Intent
        Intent myintent = new Intent(this, Intent_Lifecycle.class);
        startActivity(myintent);

    }
    protected void Send_Notification()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationManager nm = (NotificationManager)getSystemService(NotificationManager.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.createNotificationChannel(ch);
        }
        NotificationCompat.Builder NB = new NotificationCompat.Builder(this, "ch_1000")
                .setContentTitle("BS_7B")
                .setSmallIcon(R.drawable.image)
                .setContentText("this is your new message")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        nm.notify(1000,NB.build());
    }
}

