package com.example.hy.androidmessageobtaintest.apkMessage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.hy.androidmessageobtaintest.R;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageManager,获取应用的包信息
 */
public class PMActivity extends AppCompatActivity {

    public static final int ALL_APP = 0;//列出所有app
    public static final int SYSTEM_APP = 1;//列出系统app
    public static final int THIRD_APP = 2;//列出第三方app
    public static final int SDCARD_APP = 3;//列出sd卡app

    private PackageManager pm;
    private Button btnAll, btnSystem, btn3RD, btnSd;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm);
        listView = findViewById(R.id.lv_appList);

        btnAll = findViewById(R.id.btn_all);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setListDatas(ALL_APP);
            }
        });

        btnSystem = findViewById(R.id.btn_system);
        btnSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setListDatas(SYSTEM_APP);
            }
        });

        btn3RD = findViewById(R.id.btn_3RD);
        btn3RD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setListDatas(THIRD_APP);
            }
        });

        btnSd = findViewById(R.id.btn_sd);
        btnSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setListDatas(SDCARD_APP);
            }
        });
    }

    /**
     * 获得app信息列表
     * @param flag 标志
     * @return
     */
    private List<PMAppInfo> getAppInfoList(int flag){
        pm = this.getPackageManager();
        //获取应用信息
        List<ApplicationInfo> applicationInfoList = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        List<PMAppInfo> appInfoList = new ArrayList<>();
        //判断应用类型
        switch (flag){
            case ALL_APP:
                appInfoList.clear();
                for (ApplicationInfo app : applicationInfoList) {
                    appInfoList.add(new PMAppInfo(
                            ((String) app.loadLabel(pm)),
                            app.loadIcon(pm),
                            app.packageName));
                }
                break;
            case SYSTEM_APP:
                appInfoList.clear();
                for (ApplicationInfo app : applicationInfoList) {
                    if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                        appInfoList.add(new PMAppInfo(
                                ((String) app.loadLabel(pm)),
                                app.loadIcon(pm),
                                app.packageName));
                    }
                }
                break;
            case THIRD_APP:
                appInfoList.clear();
                for (ApplicationInfo app : applicationInfoList) {
                    if ((app.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                        appInfoList.add(new PMAppInfo(
                                ((String) app.loadLabel(pm)),
                                app.loadIcon(pm),
                                app.packageName));
                    } else if ((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                        appInfoList.add(new PMAppInfo(
                                ((String) app.loadLabel(pm)),
                                app.loadIcon(pm),
                                app.packageName));
                    }
                }
                break;
            case SDCARD_APP:
                appInfoList.clear();
                for (ApplicationInfo app : applicationInfoList) {
                    if ((app.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
                        appInfoList.add(new PMAppInfo(
                                ((String) app.loadLabel(pm)),
                                app.loadIcon(pm),
                                app.packageName));
                    }
                }
                break;
            default:
                return null;
            }
        return appInfoList;
    }

    /**
     * 填充ListView数据
     * @param flag
     */
    private void setListDatas(int flag){
        listView.setAdapter(new PMAppAdapter(this, getAppInfoList(flag)));
    }

}
