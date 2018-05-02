package com.qic.wechatWeGuess.pay;

import com.facebook.react.bridge.Callback;

/**
 * Created by ml23 on 2017/09/05.
 */

public class PayCallBack {

    private static Callback callback;


    public static Callback getCallback() {
        return callback;
    }

    public static void setCallback(Callback cb) {
        callback = cb;
    }
}
