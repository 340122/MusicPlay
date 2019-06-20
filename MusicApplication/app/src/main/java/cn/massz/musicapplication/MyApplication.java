package cn.massz.musicapplication;


import android.app.Application;
import cn.massz.musicapplication.helps.RealmHelper;
import com.blankj.utilcode.util.Utils;
import io.realm.Realm;


/**
 * Created by YL on 2019/6/12.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        Realm.init(this);

        RealmHelper.migration();
    }
}
