package com.app.hubert.guide.listener;

import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.core.GuideLayout;
import com.app.hubert.guide.model.GuidePage;

/**
 * Created by hubert  on 2017/7/27.
 * <p>
 * 引导层显示和消失的监听
 */
public interface OnGuideChangedListener {
    /**
     * 当引导层显示时回调
     *
     * @param controller
     */
    default void onShowed(Controller controller) {
    }

    /**
     * 当引导层消失时回调
     *
     * @param controller
     */
    default void onRemoved(Controller controller) {
    }

    default void onGuideCallBack(Controller controller, GuidePage guidePage, GuideLayout viewGroup) {
    }
}