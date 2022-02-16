package com.app.hubert.guide;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.app.hubert.guide.core.Builder;

import androidx.fragment.app.Fragment;

/**
 * Created by hubert
 * <p>
 * Created on 2017/7/27.
 */
public class NewbieGuide {

    public static final String TAG = "NewbieGuide";

    /**
     * 成功显示标示
     */
    public static final int SUCCESS = 1;

    /**
     * 显示失败标示，即已经显示过一次
     */
    public static final int FAILED = -1;

    /**
     * 新手指引入口
     *
     * @param activity activity
     * @return builder对象，设置参数
     */
    public static Builder with(Activity activity) {
        return new Builder(activity);
    }

    public static Builder with(Fragment fragment) {
        return new Builder(fragment);
    }


    /**
     * 重置标签的显示次数
     *
     * @param context
     * @param label   标签名
     */
    public static void resetLabel(Context context, String label) {
        SharedPreferences sp = context.getSharedPreferences(NewbieGuide.TAG, Activity.MODE_PRIVATE);
        sp.edit().putInt(label, 0).apply();
    }

    /**
     * @author savion
     * @date 2021/3/22
     * @desc 是否显示过此lable的引导图层
     **/
    public static boolean isLableShown(Context context, String lable) {
        SharedPreferences sp = context.getSharedPreferences(NewbieGuide.TAG, Activity.MODE_PRIVATE);
        int result = sp.getInt(lable, 0);
        return result >= 1;
    }
}

