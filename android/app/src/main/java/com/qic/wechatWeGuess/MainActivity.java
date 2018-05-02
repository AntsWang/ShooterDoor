package com.qic.wechatWeGuess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.cboy.rn.splashscreen.SplashScreen;
import com.facebook.react.bridge.Callback;
import com.qic.wechatWeGuess.pay.PayCallBack;

public class MainActivity extends ReactActivity {

    public static MainActivity maintivity;
    @Override
       protected void onCreate(Bundle savedInstanceState) {
           SplashScreen.show(this);
            maintivity = this;
           super.onCreate(savedInstanceState);
        }
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "wechatWeGuess";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data==null){
            Toast.makeText(MainActivity.this, "支付失败", Toast.LENGTH_LONG).show();
            return;
        }
        String respCode = data.getExtras().getString("resultCode");
        boolean isSuccess = false;
        if(!TextUtils.isEmpty(respCode)&&respCode.equalsIgnoreCase("success")){
            Toast.makeText(MainActivity.this, "支付成功", Toast.LENGTH_LONG).show();
            isSuccess=true;
        }else{
            Toast.makeText(MainActivity.this, "未支付", Toast.LENGTH_LONG).show();
        }
        Callback callback = PayCallBack.getCallback();
        callback.invoke(isSuccess);
        super.onActivityResult(requestCode,resultCode,data);
    }
}
