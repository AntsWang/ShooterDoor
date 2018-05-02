package com.qic.wechatWeGuess.version;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.qic.wechatWeGuess.MainActivity;

import java.io.File;

/**
 * Created by ml23 on 2017/09/15.
 */

public class AppVersion extends ReactContextBaseJavaModule {

    public AppVersion(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //返回插件名，在React.NativeModules.WeChatPay 中使用
    @Override
    public String getName() {
        return "AppVersion";
    }


    @ReactMethod
    public void install(String fileName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.android.package-archive");
        //为这个新apk开启一个新的activity栈
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        MainActivity.maintivity.startActivity(intent);
    }

    @ReactMethod
    public void getVersion(Callback callback){
        PackageInfo pi = null;
        try {
            Context context =  getReactApplicationContext();
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(), 0);
            callback.invoke(pi.versionName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
