package com.examplevinhphutvp.notification25022020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtnTao,mBtnDong ;
    String CHANNEL_ID = "channel_01";
    int  mNotificationID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTao = findViewById(R.id.ButtonTaoNotification);
        mBtnDong = findViewById(R.id.ButtonDongNotification);

        // Giao diện Notification: NottibicationCompat.Builder
        // PendingIntent : sau khi xu ly xong muon ket noi voi intent de xu ly cho viec gi
        // Quan li tat ca Notification : NotificationMannager

        mBtnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateNotification();
            }
        });
    }

    private void CreateNotification() {
        //Intent : thao tac voi Notification
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder build = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Có thông báo mới")
                .setContentText("Bạn nhận được thông báo có version mới cho app")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(
                                BitmapFactory.decodeResource(
                                        null ,
                                        R.drawable.ic_launcher_background)));

        // hien thi ra Notification
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence Name = "Notification";
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID,Name,NotificationManager.IMPORTANCE_LOW);
            // chế độ rung
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        notificationManager.notify(mNotificationID,build.build());
    }
}
