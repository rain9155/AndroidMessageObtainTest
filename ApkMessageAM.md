### ActivityManager
    前面使用了PackageManager获得了应用包的信息，PackageMessager重点在于获得应用的包信息，而ActivityManager重点在于获得在运行时的应用程序信息，
    同packageManager一样， ActivityManager也封装了很多Bean对象
* **ActivityManager.MemoryInfo** <br> <br>
它封装了内存信息，MemoryInfo中有几个重要的字段：availMem - 系统可用内存，totalMen - 总内存，threshold - 低内存的阈值，即区分是否是低内存，
lowMemory - 是否处于低内存 <br> <br>
* **Debug.MemoryInfo** <br> <br>
android中还有一个MemoryInfo，它来自Debug.MemoryInfo,前面的MemoryInfo通常用于获取全局的内存使用信息，而它用于统计进程下的内存信息 <br> <br>
* **RunningAppProcessInfo** <br> <br>
顾名思义，就是运行间进程信息，储存的字段自然进程相关的信息，processName - 进程名， pid - 进程pid, uid - 进程uid，pkgList - 该进程下所有的包 <br> <br>
* **RunningServiceInfo** <br> <br>
RunningServiceInfo与RunningAppProcessInfo类似，用于封装运行时的服务信息，它包含了进程信息的同时还包含了其他的信息，activeSince - 第一次被激活
的时间，方式，foreground - 服务是否在后台运行 <br> <br>
下面同样通过一个例子来使用ActivityManager，先封装一个Bean来保存一个我们需要的字段：
```java
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
```
通过调用getRunningAppProcesses（）返回当前运行时的进程信息集合：
```java
  private List<AMProcessInfo> getRunningProcessesInfo() {
        amProcessInfoList = new ArrayList<>();
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
```
效果图：<br> <br>

