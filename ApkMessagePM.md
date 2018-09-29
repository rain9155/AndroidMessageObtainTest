### PackageManager
    通过PackageManager可以获得应用的包信息，先看下面一张图, <br> <br>
![](https://github.com/13660139155/AndroidMessageObtainTest/raw/master/image/android_manifestpng.png) 

    最里面的框代表了整个Activity的信息，系统提供了ActivityInfo类来进行封装，以此类推。<br>
#### 下面列举一些常用的系统封装信息
* **ActivityInfo** <br>
ActivityInfo 封装了在Manifest文件中\<activity>\</activity>和\<receiver>\</receiver>之间的所有信息，包括name，icon，label，launchmod等
* **ServiceInfo** <br>
和ActivityInfo类似，它封装了\<service>\</service>之间的所有信息
* **ApplicationInfo** <br>
它封装了\<application>\</application>之间的信息，特别的是，Application包含很多Flag，FLAG_SYSTEM表示为系统应用，FLAG_EXTERNAL_STORAGE表示为安装在sd卡上的应用等，通过这些FLAG可以很方便的判断应用类型
* **PackageInfo** <br>
它用于封装Manifest文件相关节点的信息，包含了所有Activity、Service等信息
* **ResolveInfo** <br>
这个比较特殊，它封装的是包含\<intent>信息的上一级信息，所以它可以返回ActivityInfo，ServiceInfo等包含<intent>的信息，它经常用来帮助我们找到那些包含特定intent条件的信息，如带分享，播放功能的应用 <br>
____
    通过上面的对象，Packageanager 就可以通过调用各种方法来返回不同类型的Bean
  
#### PackageManager常用方法
* **getPackagerManager**: 通过调用这个方法返回一个PackageManager对象
* **getApplicationInfo**: 以ApplicationInfo形式返回指定包名的Application
* **getApplicationIcon**：返回指定包名的icon
* **getInstalledApplications**： 以ApplicationInfo形式返回安装的应用
* **getInstalledPackages**：以PackageInfo的形式返回安装的应用
* **queryIntentActivities**: 返回指定intent的ResolveInfo对象、Activity集合
* **queryIntentServices**：返回指定intent的ResolveInfo对象、service集合
* **resolveActivity**：返回指定intent的Activity
* **resolveService**：返回指定的intentService
____

    下面通过一个例子来了解如何通过PackageManager来选出不同类型的app，判断app类型的依据，就是利用Applicationinfo中的FLAG_SYSTEM来进行判断
```java
app.flags & Applicationinfo.FLAG_SYSTEM
```
* **如果flags & Applicationinfo.FLAG_SYSTEM ！= 0，则为系统应用** <br>
* **如果flags & Applicationinfo.FLAG_SYSTEM <= 0, 则为第三方应用** <br>
* **如果flags & Applicationinfo.FLAG_EXTERNAL_STORAGE != 0, 则为SD卡上的应用** <br>
* **特殊的，当系统应用经过升级后，也将成为第三方应用：flags & Applicationinfo.FLAG_UPDATED_SYSTEM_APP != 0**
<br>
首先封装一个Bean保存我所需要的app信息：<br>

```java
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
```

接下来，通过上面所说的方法判断各种类型的app：<br>

```java
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
```
效果图：<br> <br>

![](https://github.com/13660139155/AndroidMessageObtainTest/raw/master/image/android_apk_pm.png) 
