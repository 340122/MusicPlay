package cn.massz.musicapplication.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.massz.musicapplication.R;
import cn.massz.musicapplication.saveData.SaveData;
import cn.massz.musicapplication.utils.UserUtils;
import cn.massz.musicapplication.views.InputView;

// NavigationBar
public class LoginActivity extends BaseActivity {
    private InputView mInputPhone,mInputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView(){
        initNavBar(false,"登陆",false);
        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }

    /**
     * 注册页面点击事件
     */
    public void onRegisterClick(View v){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    /**
     * 登陆按钮带点击事件
     */
    public void onCommitClick(View v){
        String phone = mInputPhone.getInputStr().trim();
        String  password = mInputPassword.getInputStr().trim();
        /*SaveData.saveInfo(this, phone, password);*/
        //验证用户输入是否合法
        if (!UserUtils.validateLogin(this,phone,password)){
            return;
        }
        //跳转道应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
