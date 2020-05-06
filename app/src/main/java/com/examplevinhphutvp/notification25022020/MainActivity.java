package com.examplevinhphutvp.notification25022020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtnTao,mBtnDong ;
    String CHANNEL_ID = "channel_01";
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
        NotificationCompat.Builder build = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Có thông báo mới")
                .setContentText("Bạn nhận được thông báo có version mới cho app")
                .setWhen(System.currentTimeMillis())
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(
                                BitmapFactory.decodeResource(
                                        null ,
                                        R.drawable.ic_launcher_background)));
    }
}
