package cn.massz.musicapplication.activitys;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.massz.musicapplication.R;
import cn.massz.musicapplication.helps.RealmHelper;
import cn.massz.musicapplication.models.MusicSourceModel;
import cn.massz.musicapplication.adapters.MusicGridAdapter;
import cn.massz.musicapplication.adapters.MusicListAdapter;
import cn.massz.musicapplication.saveData.SaveData;
import cn.massz.musicapplication.views.GridSpaceItemDecoration;
import cn.massz.musicapplication.views.InputView;

import java.util.Map;

public class MainActivity extends BaseActivity {
// 项目 project
// 模块  module
//    statusBar

    private RecyclerView mRvGrid, mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;
    private RealmHelper mRealmHelper;
    private MusicSourceModel mMusicSourceModel;
   /* private TextView phone;
    private TextView password;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

       /* phone = findViewById(R.id.input_phone);
        password =  findViewById(R.id.input_password);
        Map<String,String> usermap = SaveData.getInfo(this);
        if(usermap!=null){
            phone.setText(usermap.get("name"));
            password.setText(usermap.get("psd"));
        }*/
    }
    /*public void click(View view){
        String name = phone.getText().toString().trim();
        String psd = password.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(psd)){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

        //保存用户名和密码
        boolean issaved = SaveData.saveInfo(this, name,
                psd);
        if(issaved){
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
        }
    }*/

    private void initData () {
        mRealmHelper = new RealmHelper();
        mMusicSourceModel = mRealmHelper.getMusicSource();

    }

    private void initView () {
        initNavBar(false, "余音音乐", true);

        mRvGrid = fd(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);
        mGridAdapter = new MusicGridAdapter(this, mMusicSourceModel.getAlbum());
        mRvGrid.setAdapter(mGridAdapter);

        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要手动计算RecyclerView的高度
         */
        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mListAdapter = new MusicListAdapter(this, mRvList, mMusicSourceModel.getHot());
        mRvList.setAdapter(mListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealmHelper.close();
    }
}
