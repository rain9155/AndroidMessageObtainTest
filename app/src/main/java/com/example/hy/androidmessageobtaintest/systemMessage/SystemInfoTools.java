package com.example.hy.androidmessageobtaintest.systemMessage;

import android.os.Build;

/**
 * 系统信息获取工具类
 * Created by 陈健宇 at 2018/9/29
 */
public class SystemInfoTools {


    /**
     * 拼接俩个字符串
     * @param description 前缀
     * @param prop 后缀
     * @return
     */
    public static String makeInfoString(String[] description, String[] prop) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prop.length; i++) {
            sb.append(description[i]).append(" : ").append(prop[i]).append("\r\n");
        }
        return sb.toString();
    }

    /**
     * 通过android.os.Build，获得一些Build提供的系统信息
     */
    public static String getBuildInfo() {
        String board = Build.BOARD; //主板
        String brand = Build.BRAND; //Android系统指定商
        String supported_abis = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            supported_abis = Build.SUPPORTED_ABIS[0];//CPU指令集
        }
        String device = Build.DEVICE;//设备参数
        String display = Build.DISPLAY;//显示屏参数
        String fingerprint = Build.FINGERPRINT;//唯一编号
        String serial = Build.SERIAL;//硬件序列号
        String id = Build.ID;//修订版本列表
        String manufacturer = Build.MANUFACTURER;//硬件制造商
        String model = Build.MODEL;//版本
        String hardware = Build.HARDWARE;//硬件名
        String product = Build.PRODUCT;//手机产品名
        String tags = Build.TAGS;//描述Build的标签
        String type = Build.TYPE;//Builder类型
        String codename = Build.VERSION.CODENAME;//当前开发号
        String incremental = Build.VERSION.INCREMENTAL;//源码版本控制号
        String release = Build.VERSION.RELEASE;//版本字符串
        String sdk_int = "" + Build.VERSION.SDK_INT;//版本号
        String host = Build.HOST;//Host值
        String user = Build.USER;//User名
        String time = "" + Build.TIME;//编译时间
        String[] prop = {
                board,
                brand,
                supported_abis,
                device,
                display,
                fingerprint,
                serial,
                id,
                manufacturer,
                model,
                hardware,
                product,
                tags,
                type,
                codename,
                incremental,
                release,
                sdk_int,
                host,
                user,
                time
        };
        String[] description = {
                "board",
                "brand",
                "supported_abis",
                "device",
                "display",
                "fingerprint",
                "serial",
                "id",
                "manufacturer",
                "model",
                "hardware",
                "product",
                "tags",
                "type",
                "codename",
                "incremental",
                "release",
                "sdk_int",
                "host",
                "user",
                "time"
        };
        return makeInfoString(description, prop);
    }

    /**
     * 通过SystemProperty，获得一些Build提供的系统信息
     */
    public static String getSystemPropertyInfo() {
        String os_version = System.getProperty("os.version");//os 版本
        String os_name = System.getProperty("os.name");//os 名称
        String os_arch = System.getProperty("os.arch");//os 架构
        String user_home = System.getProperty("user.home");//Home 属性
        String user_name = System.getProperty("user.name");//Name 属性
        String user_dir = System.getProperty("user.dir");//Dir 属性
        String user_timezone = System.getProperty("user.timezone");//时区
        String path_separator = System.getProperty("path.separator");//路径分隔符
        String line_separator = System.getProperty("line.separator");//行分隔符
        String file_separator = System.getProperty("file.separator");//文件分隔符
        String java_vendor_url = System.getProperty("java.vendor.url");//java vender URL 属性
        String java_class_path = System.getProperty("java.class.path");//java Class 路径
        String java_class_version = System.getProperty("java.class.version");//java Class 版本
        String java_vendor = System.getProperty("java.vendor");//java Vender 属性
        String java_version = System.getProperty("java.version");//java 版本
        String java_home = System.getProperty("java_home");//java HOME属性
        String[] prop = {
                os_version,
                os_name,
                os_arch,
                user_home,
                user_name,
                user_dir,
                user_timezone,
                path_separator,
                line_separator,
                file_separator,
                java_vendor_url,
                java_class_path,
                java_class_version,
                java_vendor,
                java_version,
                java_home
        };
        String[] description = {
                "os_version",
                "os_name",
                "os_arch",
                "user_home",
                "user_name",
                "user_dir",
                "user_timezone",
                "path_separator",
                "line_separator",
                "file_separator",
                "java_vendor_url",
                "java_class_path",
                "java_class_version",
                "java_vendor",
                "java_version",
                "java_home"
        };
        return makeInfoString(description, prop);
    }

}
