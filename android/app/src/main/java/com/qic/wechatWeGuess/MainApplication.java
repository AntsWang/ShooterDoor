package com.qic.wechatWeGuess;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.facebook.react.ReactApplication;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.qic.wechatWeGuess.version.VersionReactPackage;
import com.rnfs.RNFSPackage;
import com.facebook.react.bridge.Callback;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.cboy.rn.splashscreen.SplashScreenReactPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.qic.wechatWeGuess.pay.PayReactPackage;
import com.reactnativenavigation.bridge.NavigationReactPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
            new RNDeviceInfo(),
                    new RNFSPackage(),
                    new BackgroundTimerPackage(),
                    new SplashScreenReactPackage(),
                    new VectorIconsPackage(),
                    new NavigationReactPackage(),
                    new VersionReactPackage(),
                    new PayReactPackage() //添加新模块
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        SoLoader.init(this, /* native exopackage */ false);
    }

    private void checkVersion() {
        if (true) {
            Toast.makeText(this, "新版本开始下载", Toast.LENGTH_SHORT).show();
        }
    }
}
