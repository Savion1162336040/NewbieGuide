package com.app.hubert.guide.listener;

import android.graphics.RectF;
import android.view.View;

import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.core.GuideLayout;
import com.app.hubert.guide.model.HighLight;

/**
 * Created by hubert on 2018/7/9.
 */
public interface OnHighlightCallBack {

    void onHighlightCallBack(GuideLayout guideLayout, View view, Controller controller, HighLight highLight, RectF rectF);
}
