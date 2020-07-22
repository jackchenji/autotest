package aardemo.cn.com.uiautomator;

import android.provider.SyncStateContract;
import android.util.Log;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.IOException;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.Until;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;


/*
 *Created by user on 2020/7/21
 */


public class TestUiDemo extends TestCase {
     public     UiDevice mUiDevice;
     public  static  String TAG="TestUiDemo";


     public  void  testDemo() throws UiObjectNotFoundException{
         TMKeyLog.d(TAG, "开始自动化测试");
         mUiDevice=UiDevice.getInstance(getInstrumentation());
         openApp("微信");
     }       


    //启动宝玩app2，通过命令启动
    private void openApp(String string) {
        try {
            mUiDevice.executeShellCommand("am start -n " + string);//执行一个shell命令，需要5.0以上手机
            TMKeyLog.d(TAG, "启动app成功");
            mUiDevice.wait(Until.hasObject(By.pkg(string).depth(0)), 20);
        } catch (IOException e) {
            TMKeyLog.d(TAG, "openapp: 打开app失败\"");
            e.printStackTrace();
            Log.e(TAG, "openapp: 打开app失败");
            e.printStackTrace();
        }
    }


 }
