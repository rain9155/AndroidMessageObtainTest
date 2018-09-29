package com.example.hy.androidmessageobtaintest.apkMessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hy.androidmessageobtaintest.R;

import java.util.List;

/**
 * Created by 陈健宇 at 2018/9/29
 */
public class PMAppAdapter extends BaseAdapter {

    private List<PMAppInfo> mAppInfoList = null;
    private LayoutInflater mInflater = null;

    public PMAppAdapter(Context context, List<PMAppInfo> appInfoList) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mAppInfoList = appInfoList;
    }

    @Override
    public int getCount() {
        return mAppInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAppInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_app_ist, null);
            holder.appIcon = convertView.findViewById(R.id.iv_icon);
            holder.appLabel = convertView.findViewById(R.id.tv_label);
            holder.appPackage =  convertView.findViewById(R.id.tv_pkg);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PMAppInfo appInfo = (PMAppInfo) getItem(position);
        holder.appIcon.setImageDrawable(appInfo.getAppIcon());
        holder.appLabel.setText(appInfo.getAppLabel());
        holder.appPackage.setText(appInfo.getPkgName());
        return convertView;
    }

    class ViewHolder {
        ImageView appIcon;
        TextView appLabel;
        TextView appPackage;
    }

}
