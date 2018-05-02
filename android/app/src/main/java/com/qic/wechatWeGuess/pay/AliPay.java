package com.qic.wechatWeGuess.pay;

/**
 * Created by ml23 on 2017/09/04.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.text.TextUtils;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.qic.wechatWeGuess.MainActivity;
import com.switfpass.pay.activity.PayPlugin;
import com.switfpass.pay.bean.RequestMsg;
import com.switfpass.pay.MainApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AliPay extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public AliPay(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //返回插件名，在React.NativeModules.WeChatPay 中使用
    @Override
    public String getName() {
        return "WFTPay";
    }

    //导出一个方法给JavaScript使用，Java方法需要使用注解 @ReactMethod
    //参数类型

    //导出给JavaScript使用的常量
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }
    //Boolean -> Bool
    //Integer -> Number
    //Double -> Number
    //Float -> Number
    //String -> String
    //Callback -> function
    //ReadableMap -> Object
    //ReadableArray -> Array
    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void pay(String payInfo, Callback callback) {

        //设置callback为全局变量
        PayCallBack.setCallback(callback);

        RequestMsg msg = new RequestMsg();
        msg.setTokenId(payInfo);//token_id为服务端预下单返回
        msg.setTradeType(MainApplication.PAY_NEW_ZFB_WAP);//app支付类型

        PayPlugin. unifiedH5Pay(MainActivity.maintivity, msg);
    }
}
