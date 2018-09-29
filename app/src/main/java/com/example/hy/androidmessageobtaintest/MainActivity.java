package com.example.hy.androidmessageobtaintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hy.androidmessageobtaintest.apkMessage.PMActivity;
import com.example.hy.androidmessageobtaintest.systemMessage.SystemMessageObtainActivity;

public class MainActivity extends AppCompatActivity {

    Button btnToSystem, btnToApk, btnToApk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToSystem = findViewById(R.id.btn_toSystem);
        btnToSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SystemMessageObtainActivity.class);
                startActivity(intent);
            }
        });

        btnToApk = findViewById(R.id.btn_toApk);
        btnToApk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PMActivity.class);
                startActivity(intent);
            }
        });

        btnToApk2 = findViewById(R.id.btn_toApk2);
        btnToApk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
