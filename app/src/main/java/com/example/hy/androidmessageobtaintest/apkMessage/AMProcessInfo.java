package com.example.hy.androidmessageobtaintest.apkMessage;

/**
 * 保存进程相关信息
 * Created by 陈健宇 at 2018/9/29
 */
public class AMProcessInfo {

    private String uid;
    private String pid;
    private String memorySize;
    private String processName;

    public AMProcessInfo() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
