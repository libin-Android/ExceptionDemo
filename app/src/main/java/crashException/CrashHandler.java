package crashException;

import android.os.Looper;
import android.util.Log;

/**
 *UncaughtExceptionHandler： 线程未捕获异常控制器是用来处理未捕获异常的。
 如果程序出现了未捕获异常默认情况下则会出现强行关闭对话框
 实现该接口并注册为程序中的默认未捕获异常处理
 这样当未捕获异常发生时，就可以做些异常处理操作
 例如：收集异常信息，发送错误报告 等。
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler{
    private static CrashHandler INSTANCE=new CrashHandler();
    private String TAG=CrashHandler.class.getSimpleName();

    /**
     * 获取单例对象
     * @return
     */
    public static CrashHandler getInstance(){
        return INSTANCE;
    }

    /**
     * 初始化异常类
     */
    public void init(){
        Thread.UncaughtExceptionHandler mUncaughtExceptionHandler=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    /**
     * 当UncaughtException发生时会转入该函数来处理,发现异常的回调处理
     */
    @Override
    public void uncaughtException(Thread thread, final Throwable throwable) {
        new Thread(){
            @Override
            public void run() {
                Looper.prepare();
                Log.e(TAG, throwable.getMessage()+"sss");
                Looper.loop();
            }
        }.start();
    }
}
