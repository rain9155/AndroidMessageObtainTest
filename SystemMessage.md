### 要获取系统的配置信息，通常可以从以下俩方面获取：
 * android.os.Build
 * SystemProperty
#### 1、android.os.Build包含了系统编译时的大量设备，配置信息
* Build.BOARD; //主板
* Build.BRAND; //Android系统指定商
* supported_abis = null;//CPU指令集
* Build.DEVICE;//设备参数
*  Build.DISPLAY;//显示屏参数
* Build.FINGERPRINT;//唯一编号
* Build.SERIAL;//硬件序列号
* Build.ID;//修订版本列表
*  Build.MANUFACTURER;//硬件制造商
* Build.MODEL;//版本
* Build.HARDWARE;//硬件名
* Build.PRODUCT;//手机产品名
* Build.TAGS;//描述Build的标签
* Build.TYPE;//Builder类型
* Build.VERSION.CODENAME;//当前开发号
* Build.VERSION.INCREMENTAL;//源码版本控制号
* Build.VERSION.RELEASE;//版本字符串
* Build.VERSION.SDK_INT;//版本号
* Build.HOST;//Host值
* Build.USER;//User名
* Build.TIME;//编译时间
#### 2、SystemProperty包含许多系统，配置属性值和参数，很多与上面通过android.os.Build获取的相同,下面给出常用的信息
* System.getProperty("os.version");//os 版本
* System.getProperty("os.name");//os 名称
* System.getProperty("os.arch");//os 架构
* System.getProperty("user.home");//Home 属性
* System.getProperty("user.name");//Name 属性
* System.getProperty("user.dir");//Dir 属性
* System.getProperty("user.timezone");//时区
* System.getProperty("path.separator");//路径分隔符
* System.getProperty("line.separator");//行分隔符
* System.getProperty("file.separator");//文件分隔符
* System.getProperty("java.vendor.url");//java vender URL 属性
* System.getProperty("java.class.path");//java Class 路径
* System.getProperty("java.class.version");//java Class 版本
* System.getProperty("java.vendor");//java Vender 属性
* System.getProperty("java.version");//java 版本
* System.getProperty("java_home");//java HOME属性
### 实例
```java
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
```
