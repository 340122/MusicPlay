package cn.massz.musicapplication.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by YL on 2019/6/14.
 */

public class WequalHImageView extends AppCompatImageView {
    public WequalHImageView(Context context) {
        super(context);
    }

    public WequalHImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WequalHImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //重新宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        /*//获取View宽度
        int width = MeasureSpec.getSize(widthMeasureSpec);
//获取模式:match_parent、warp_parent、具体的dp
        int mode = MeasureSpec.getMode(widthMeasureSpec);*/

    }
}
