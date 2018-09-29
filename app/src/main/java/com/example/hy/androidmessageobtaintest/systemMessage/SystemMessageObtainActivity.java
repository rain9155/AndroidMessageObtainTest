package com.example.hy.androidmessageobtaintest.systemMessage;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hy.androidmessageobtaintest.R;

import org.w3c.dom.Text;

/**
 * Android系统信息的获取
 * 要获取系统的配置信息，通常可以从以下俩方面获取：
 * android.os.Build
 * SystemProperty
 * 1、android.os.Build包含了系统编译时的大量设备，配置信息
 * 2、SystemProperty包含许多系统，配置属性值和参数，很多与上面通过android.os.Build获取的相同
 */
public class SystemMessageObtainActivity extends AppCompatActivity {
    private static final String TAG = "rain";
    TextView tvSystemInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_message_obtain);

        tvSystemInfo = findViewById(R.id.tv_systemInfo);
        String s = SystemInfoTools.getBuildInfo();
        s += "-----------------------------------\n";
        s += SystemInfoTools.getSystemPropertyInfo();
        tvSystemInfo.setText(s);

        /* 通过android.os.Build，可以直接获得一些Build提供的系统信息 */
        String board = Build.BOARD;
        String brand = Build.BRAND;
        Log.d(TAG, "android.os.Build，board：" + board);
        Log.d(TAG, "android.os.Build，brand： " + brand);
        /* 通过SystemProperty，要使用System.getProperty("XXX") */
        String os_version = System.getProperty("os.version");
        String os_name = System.getProperty("os.name");
        Log.d(TAG, "SystemProperty，os_version: " + os_version);
        Log.d(TAG, "SystemProperty, os_name: " + os_name);
    }
}
