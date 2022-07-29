package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;

import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.core.GuideLayout;
import com.app.hubert.guide.listener.OnGuideClickListener;
import com.app.hubert.guide.listener.OnHighlightCallBack;
import com.app.hubert.guide.listener.OnHighlightDrewListener;

/**
 * Created by hubert on 2018/7/9.
 */
public class HighlightOptions {
    public OnGuideClickListener onClickListener;
    public OnScrollListener onScrollChangeListener;
    public RelativeGuide relativeGuide;
    public OnHighlightDrewListener onHighlightDrewListener;
    public OnHighlightCallBack onHighlightCallBack;
    public boolean fetchLocationEveryTime;
    /**
     * @author savion
     * @date 2022/2/17
     * @desc 忽略绘制高亮区域
     **/
    public boolean ignoreDrawHighLightMask;

    public interface OnScrollListener {
        void onScrollChange(View view, float startX, float startY, float endX, float endY);
    }

    public static class Builder {

        private HighlightOptions options;

        public Builder() {
            options = new HighlightOptions();
        }

        /**
         * 高亮点击事件
         */
        public Builder setOnClickListener(OnGuideClickListener listener) {
            options.onClickListener = listener;
            return this;
        }

        public Builder setOnScrollChangeListener(OnScrollListener onScrollChangeListener) {
            options.onScrollChangeListener = onScrollChangeListener;
            return this;
        }

        /**
         * @param relativeGuide 高亮相对位置引导布局
         */
        public Builder setRelativeGuide(RelativeGuide relativeGuide) {
            options.relativeGuide = relativeGuide;
            return this;
        }

        /**
         * @param listener 高亮绘制后回调该监听，用于绘制额外内容
         */
        public Builder setOnHighlightDrewListener(OnHighlightDrewListener listener) {
            options.onHighlightDrewListener = listener;
            return this;
        }

        /**
         * @author savion
         * @date 2022/2/17
         * @desc guidePage加载时马上回调
        **/
        public Builder setOnHighlightCallBack(OnHighlightCallBack listener) {
            options.onHighlightCallBack = listener;
            return this;
        }
        /**
         * @author savion
         * @date 2022/2/17
         * @desc 忽略绘制高亮区域mask,可与 {@link OnHighlightCallBack#onHighlightCallBack(GuideLayout, View, Controller, HighLight, RectF)}配合自己在高亮区域添加组件
        **/
        public Builder ignoreDrawHighLightMask(boolean ignore) {
            options.ignoreDrawHighLightMask = ignore;
            return this;
        }

        /**
         * 是否每次显示引导层都重新获取高亮位置
         */
        public Builder isFetchLocationEveryTime(boolean b) {
            options.fetchLocationEveryTime = b;
            return this;
        }

        public HighlightOptions build() {
            return options;
        }
    }

}
