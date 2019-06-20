package cn.massz.musicapplication.activitys;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import cn.massz.musicapplication.R;
import cn.massz.musicapplication.utils.UserUtils;

//1、延迟3秒
//2、跳转页面
public class WelcomeActivity extends BaseActivity {
    private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    /**
     * 初始化
     */
    private void init () {
        //自动登录
        final boolean isLogin = UserUtils.validateUserLogin(this);
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
//                toMain();
                if (isLogin) {
                    toMain();
                } else {
                    toLogin();
                }
            }
        }, 2 * 1300);
    }

    /**
     * 跳转道MainActivity页面
     */
    private void toMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    /**
     * 跳转道LoginActivity页面
     */
    private void toLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}