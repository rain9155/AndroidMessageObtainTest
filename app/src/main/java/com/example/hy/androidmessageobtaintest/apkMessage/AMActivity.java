package com.example.hy.androidmessageobtaintest.apkMessage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hy.androidmessageobtaintest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivityManager,获取运行的应用程序信息
 */
public class AMActivity extends AppCompatActivity {

    private ListView listView;
    private ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am);
        listView = findViewById(R.id.lv_processList);
        am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        listView.setAdapter(new AMProcessAdapter(this, getRunningProcessesInfo()));
    }

    /**
     * 获取正在运行的进程信息集合
     * @return
     */
    private List<AMProcessInfo> getRunningProcessesInfo() {
         List<AMProcessInfo> amProcessInfoList = new ArrayList<>();
        //获取正在运行的进程集合
        List<ActivityManager.RunningAppProcessInfo> appProcessList = am.getRunningAppProcesses();
        for (int i = 0; i < appProcessList.size(); i++) {
            ActivityManager.RunningAppProcessInfo info = appProcessList.get(i);
            int pid = info.pid;
            int uid = info.uid;
            String processName = info.processName;
            //获取该进程下的内存
            int[] memoryPid = new int[]{pid};
            Debug.MemoryInfo[] memoryInfo = am.getProcessMemoryInfo(memoryPid);
            int memorySize = memoryInfo[0].getTotalPss();
            AMProcessInfo processInfo = new AMProcessInfo();
            //
            processInfo.setPid("" + pid);
            processInfo.setUid("" + uid);
            processInfo.setMemorySize("" + memorySize);
            processInfo.setProcessName(processName);
            amProcessInfoList.add(processInfo);
        }
        return amProcessInfoList;
    }
}
