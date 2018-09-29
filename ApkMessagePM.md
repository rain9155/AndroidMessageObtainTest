### PackageManager
    通过PackageManager可以获得应用的包信息，先看下面一张图, <br> <br>
![](https://github.com/13660139155/AndroidMessageObtainTest/raw/master/image/android_manifestpng.png) <br> <br>
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
