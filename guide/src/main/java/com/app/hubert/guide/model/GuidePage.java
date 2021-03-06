package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;

import com.app.hubert.guide.core.GuideLayout;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.listener.OnHighlightDrewListener;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

/**
 * Created by hubert
 * <p>
 * Created on 2017/11/16.
 */

public class GuidePage {

    private List<HighLight> highLights = new ArrayList<>();
    private boolean everywhereCancelable = true;
    private int backgroundColor = GuideLayout.DEFAULT_BACKGROUND_COLOR;

    private int layoutResId;
    private int[] clickToDismissIds;
    private OnLayoutInflatedListener onLayoutInflatedListener;
    private OnGuideChangedListener onGuideChangedListener;
    private OnHighlightDrewListener onHighlightDrewListener;
    private Animation enterAnimation, exitAnimation;

    public static GuidePage newInstance() {
        return new GuidePage();
    }

    public GuidePage addHighLight(View view) {
        return addHighLight(view, HighLight.Shape.RECTANGLE, false, 0, 0, null);
    }

    public GuidePage addHighLight(View view, RelativeGuide relativeGuide) {
        return addHighLight(view, HighLight.Shape.RECTANGLE, false, 0, 0, relativeGuide);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape) {
        return addHighLight(view, shape, false, 0, 0, null);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, boolean isdash) {
        return addHighLight(view, shape, isdash, 0, 0, null);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, boolean isdash, RelativeGuide relativeGuide) {
        return addHighLight(view, shape, isdash, 0, 0, relativeGuide);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, boolean isdash, int padding) {
        return addHighLight(view, shape, isdash, 0, padding, null);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, boolean isdash, int padding, RelativeGuide relativeGuide) {
        return addHighLight(view, shape, isdash, 0, padding, relativeGuide);
    }

    public GuidePage addHighLight(View view, HighLight.Shape shape, boolean isdash, int round, int padding) {
        return addHighLight(view, shape, isdash, round, padding, null);
    }

    /**
     * ?????????????????????view
     *
     * @param view          ???????????????view
     * @param shape         ????????????{@link HighLight.Shape}
     * @param round         ?????????????????????dp??????{@link HighLight.Shape#ROUND_RECTANGLE}??????
     * @param padding       ????????????view???padding,??????px
     * @param relativeGuide ??????????????????????????????
     */
    public GuidePage addHighLight(View view, HighLight.Shape shape, boolean isDash, int round, int padding,
                                  @Nullable RelativeGuide relativeGuide) {
        HighlightView highlight = new HighlightView(view, shape, isDash, round, padding);
        if (relativeGuide != null) {
            relativeGuide.highLight = highlight;
            highlight.setOptions(new HighlightOptions.Builder().setRelativeGuide(relativeGuide).build());
        }
        highLights.add(highlight);
        return this;
    }

    public GuidePage addHighLight(RectF rectF) {
        return addHighLight(rectF, HighLight.Shape.RECTANGLE, false, 0, null);
    }

    public GuidePage addHighLight(RectF rectF, RelativeGuide relativeGuide) {
        return addHighLight(rectF, HighLight.Shape.RECTANGLE, false, 0, relativeGuide);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, boolean isdash) {
        return addHighLight(rectF, shape, isdash, 0, null);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, boolean isdash, RelativeGuide relativeGuide) {
        return addHighLight(rectF, shape, isdash, 0, relativeGuide);
    }

    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, boolean isdash, int round) {
        return addHighLight(rectF, shape, isdash, round, null);
    }

    /**
     * ??????????????????
     *
     * @param rectF         ????????????????????????anchor view????????????decorView???
     * @param shape         ????????????{@link HighLight.Shape}
     * @param round         ?????????????????????dp??????{@link HighLight.Shape#ROUND_RECTANGLE}??????
     * @param relativeGuide ??????????????????????????????
     */
    public GuidePage addHighLight(RectF rectF, HighLight.Shape shape, boolean isdash, int round, RelativeGuide relativeGuide) {
        HighlightRectF highlight = new HighlightRectF(rectF, shape, isdash, round);
        if (relativeGuide != null) {
            relativeGuide.highLight = highlight;
            highlight.setOptions(new HighlightOptions.Builder().setRelativeGuide(relativeGuide).build());
        }
        highLights.add(highlight);
        return this;
    }

    public GuidePage addHighLightWithOptions(View view, HighlightOptions options) {
        return addHighLightWithOptions(view, HighLight.Shape.RECTANGLE, false, 0, 0, options);
    }

    public GuidePage addHighLightWithOptions(View view, HighLight.Shape shape, boolean isDash, HighlightOptions options) {
        return addHighLightWithOptions(view, shape, isDash, 0, 0, options);
    }

    public GuidePage addHighLightWithOptions(View view, HighLight.Shape shape, boolean isdash, int round, int padding, HighlightOptions options) {
        HighlightView highlight = new HighlightView(view, shape, isdash, round, padding);
        if (options != null) {
            if (options.relativeGuide != null) {
                options.relativeGuide.highLight = highlight;
            }
        }
        highlight.setOptions(options);
        highLights.add(highlight);
        return this;
    }

    public GuidePage addHighLightWithOptions(RectF rectF, HighlightOptions options) {
        return addHighLightWithOptions(rectF, HighLight.Shape.RECTANGLE, false, 0, options);
    }

    public GuidePage addHighLightWithOptions(RectF rectF, HighLight.Shape shape, boolean isdash, HighlightOptions options) {
        return addHighLightWithOptions(rectF, shape, isdash, 0, options);
    }

    public GuidePage addHighLightWithOptions(RectF rectF, HighLight.Shape shape, boolean isdash, int round, HighlightOptions options) {
        HighlightRectF highlight = new HighlightRectF(rectF, shape, isdash, round);
        if (options != null) {
            if (options.relativeGuide != null) {
                options.relativeGuide.highLight = highlight;
            }
        }
        highlight.setOptions(options);
        highLights.add(highlight);
        return this;
    }

    /**
     * ?????????????????????
     *
     * @param resId ??????id
     * @param id    ???????????????????????????????????????id
     */
    public GuidePage setLayoutRes(@LayoutRes int resId, int... id) {
        this.layoutResId = resId;
        clickToDismissIds = id;
        return this;
    }

    public GuidePage setEverywhereCancelable(boolean everywhereCancelable) {
        this.everywhereCancelable = everywhereCancelable;
        return this;
    }

    /**
     * ???????????????
     */
    public GuidePage setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * ???????????????layout??????????????????????????????layout?????????
     *
     * @param onLayoutInflatedListener listener
     */
    public GuidePage setOnLayoutInflatedListener(OnLayoutInflatedListener onLayoutInflatedListener) {
        this.onLayoutInflatedListener = onLayoutInflatedListener;
        return this;
    }

    /**
     * @author savion
     * @date 2021/3/19
     * @desc ???????????????layer????????????
     **/
    public GuidePage setOnGuideChangedListener(OnGuideChangedListener onGuideChangedListener) {
        this.onGuideChangedListener = onGuideChangedListener;
        return this;
    }

    /**
     * ??????????????????
     */
    public GuidePage setEnterAnimation(Animation enterAnimation) {
        this.enterAnimation = enterAnimation;
        return this;
    }

    /**
     * ??????????????????
     */
    public GuidePage setExitAnimation(Animation exitAnimation) {
        this.exitAnimation = exitAnimation;
        return this;
    }

    public boolean isEverywhereCancelable() {
        return everywhereCancelable;
    }

    public boolean isEmpty() {
        return layoutResId == 0 && highLights.size() == 0;
    }

    public List<HighLight> getHighLights() {
        return highLights;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getLayoutResId() {
        return layoutResId;
    }

    public int[] getClickToDismissIds() {
        return clickToDismissIds;
    }

    public OnLayoutInflatedListener getOnLayoutInflatedListener() {
        return onLayoutInflatedListener;
    }

    public OnGuideChangedListener getOnGuideChangedListener() {
        return onGuideChangedListener;
    }

    public Animation getEnterAnimation() {
        return enterAnimation;
    }

    public Animation getExitAnimation() {
        return exitAnimation;
    }

    public List<RelativeGuide> getRelativeGuides() {
        List<RelativeGuide> relativeGuides = new ArrayList<>();
        for (HighLight highLight : highLights) {
            HighlightOptions options = highLight.getOptions();
            if (options != null) {
                if (options.relativeGuide != null) {
                    relativeGuides.add(options.relativeGuide);
                }
            }
        }
        return relativeGuides;
    }
}
