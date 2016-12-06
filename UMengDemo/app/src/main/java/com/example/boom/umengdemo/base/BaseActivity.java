package com.example.boom.umengdemo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Boom on 2016/12/6.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PushAgent mPushAgent = PushAgent.getInstance(getBaseContext());
        mPushAgent.setDebugMode(true);
        mPushAgent.onAppStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //注册推送服务，每次调用register方法都会回调该接口
                mPushAgent.register(new IUmengRegisterCallback() {

                    @Override
                    public void onSuccess(String deviceToken) {
                        //注册成功会返回device token

                    }
                    @Override
                    public void onFailure(String s, String s1) {

                    }
                });
            }
        }).start();
    }
}

