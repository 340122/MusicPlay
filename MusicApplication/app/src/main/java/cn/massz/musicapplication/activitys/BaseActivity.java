package cn.massz.musicapplication.activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.massz.musicapplication.R;

/**
 * Created by YL on 2019/6/12.
 */

public class BaseActivity extends Activity {
    private ImageView mIvBack,mIvMe;
    private TextView mTvTitle;

    /**
     * findViewById
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View>T fd (@IdRes int id)
    {
        return (T) findViewById(id);
    }
    protected  void initNavBar(boolean isShowBack,String title,boolean isShowMe){
        mIvBack = fd(R.id.iv_back);
        mIvMe = fd(R.id.tv_me);
        mTvTitle = fd(R.id.tv_title);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,MeActivity.class));
            }
        });
    }

}
