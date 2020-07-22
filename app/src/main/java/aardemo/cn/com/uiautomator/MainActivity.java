package aardemo.cn.com.uiautomator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.uiautomator.UiObjectNotFoundException;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.junit.Test;

public class MainActivity extends AppCompatActivity {
   Button test;
   String  cmda="adb shell am instrument -w -r    -e debug false -e class 'aardemo.cn.com.uiautomator.ChangeTextBehaviorTest#loginWinxin' aardemo.cn.com.uiautomator.test/androidx.test.runner.AndroidJUnitRunner";
   String  cmdb="am instrument -w -r    -e debug false -e class 'aardemo.cn.com.uiautomator.ChangeTextBehaviorTest#loginWinxin' aardemo.cn.com.uiautomator.test/androidx.test.runner.AndroidJUnitRunner";

   String  cmdc="am instrument -w -r    -e debug false -e class 'aardemo.cn.com.uiautomator.ChangeTextBehaviorTest' aardemo.cn.com.uiautomator.test/androidx.test.runner.AndroidJUnitRunner";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test=findViewById(R.id.autotest);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* TestUiDemo  testUiDemo=new TestUiDemo();*/
                try {
              //      Runtime.getRuntime().exec(cmda);
                    Runtime.getRuntime().exec(cmdc);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
