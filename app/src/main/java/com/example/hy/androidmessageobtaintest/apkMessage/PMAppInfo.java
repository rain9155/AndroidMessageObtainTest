package com.example.hy.androidmessageobtaintest.apkMessage;

import android.graphics.drawable.Drawable;

/**
 * 封装ap的基本信息
 * Created by 陈健宇 at 2018/9/29
 */
public class PMAppInfo {

    private String appName;//app名称
    private Drawable appIcon;//图标
    private String pkgName;//所在包名

    public PMAppInfo(String appLabel, Drawable appIcon, String pkgName) {
        this.appName = appLabel;
        this.appIcon = appIcon;
        this.pkgName = pkgName;
    }

    public String getAppLabel() {
        return appName;
    }

    public void setAppLabel(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

}
