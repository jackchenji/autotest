/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aardemo.cn.com.uiautomator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SdkSuppress;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Direction;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ChangeTextBehaviorTest {

    private static final String TAG = "Account";

    //    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.tencent.mobileqq";
    private static final String BASIC_SAMPLE_PACKAGE = "com.tencent.mm";
//    private static final String BASIC_SAMPLE_PACKAGE  = "com.example.android.testing.uiautomator.BasicSample";

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final int TIMEOUT = 1000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    public static final String constStr = "你不是收款方好友，对方添加你为好友后才能发起转账";

    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);


        // Launch the blueprint app
        Context context = getApplicationContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);    // Clear out any previous instances
        context.startActivity(intent);


        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void loginQQ() {
//        assertThat(mDevice, notNullValue());

        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "btn_login")).click();
        UiObject2 login = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "login")),
                        500 /* wait 500ms */);
        final UiObject2 qq = mDevice.findObject(By.desc("请输入QQ号码或手机或邮箱"));
        final UiObject2 pwd = mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "password"));
        qq.setText("1138239636");
//        pwd.setText("Xw8ax6pihvFGSr$%");
        login.click();

    }

    @Test
    public void loginWinxin() {


        UiObject2 txl = mDevice
                .wait(Until.findObject(By.text("通讯录")),
                        TIMEOUT /* wait 500ms */);
        txl.getParent().getParent().click();
        mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "f4")),
                TIMEOUT /* wait 500ms */).scroll(Direction.UP, 0, 100);
        int i = 0;
        while (true) {
            try {


                UiObject2 list = mDevice
                        .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "f4")),
                                TIMEOUT /* wait 500ms */);
                final List<UiObject2> children = list.getChildren();
                final int size = children.size();
                for (; i < size; i++) {
                    final UiObject2 object2 = children.get(i);
                    final UiObject2 object = object2.findObject(By.res(BASIC_SAMPLE_PACKAGE, "dy5"));
                    if (object != null) {
                        object.click();
                        mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "g6f")),
                                TIMEOUT /* wait 500ms */).click();

                        mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "aks")),
                                TIMEOUT /* wait 500ms */).click();


                        final UiObject2 object21 = mDevice.wait(Until.findObject(By.text("转账")),
                                TIMEOUT /* wait 500ms */).getParent().getParent().getParent();
                        if (object21 == null) {
                            while (mDevice
                                    .wait(Until.findObject(By.text("通讯录")),
                                            10 /* wait 500ms */) == null) {
                                mDevice.pressBack();
                            }
                            txl.getParent().getParent().click();
                            continue;
                        } else {
                            object21.click();
                        }

                        // 名字
                        final String ez7 = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "ez7")),
                                TIMEOUT /* wait 500ms */).getText();

                        mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "cx_")),
                                TIMEOUT /* wait 500ms */).click();

                        mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "cxi")),
                                TIMEOUT /* wait 500ms */).click();

                        final UiObject2 dos = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "dos")),  // tip
                                TIMEOUT /* wait 500ms */);
                        if (dos != null) {
                            if (constStr.equals(dos.getText())) {
                                Log.d(TAG, "loginWinxin: " + ez7);
                            }

                            mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "doz")),  // 确定
                                    TIMEOUT /* wait 500ms */).click();


                        }

                        while (mDevice
                                .wait(Until.findObject(By.text("通讯录")),
                                        10 /* wait 500ms */) == null) {
                            mDevice.pressBack();
                        }
                        txl.getParent().getParent().click();
                    }
                }
                list.scroll(Direction.DOWN, 1);
                i = 1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }



    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
