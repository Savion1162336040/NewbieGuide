package com.savion.newbieguide;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.core.GuideLayout;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.listener.OnGuideClickListener;
import com.app.hubert.guide.listener.OnHighlightCallBack;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.guide.model.RelativeGuide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView hello = findViewById(R.id.hello);
        showGuide(this, hello);
    }

    Controller controller;

    private void showGuide(Activity activity, View relatedview) {
        if (relatedview != null) {
            controller = NewbieGuide.with(activity)
                    .setLabel("FQA_ENTER")
                    .alwaysShow(true)
                    .addGuidePage(GuidePage.newInstance()
                            .setOnGuideChangedListener(new OnGuideChangedListener() {
                                @Override
                                public void onGuideCallBack(Controller controller, GuidePage guidePage, GuideLayout viewGroup) {
                                    if (guidePage.getHighLights() != null
                                            && guidePage.getHighLights().size() > 0
                                            && viewGroup != null
                                            && guidePage.getRelativeGuides() != null
                                            && guidePage.getRelativeGuides().size() > 0
                                            && guidePage.getRelativeGuides().get(0).layout == R.layout.layout_guide_qa_enter) {
                                        RectF rectF = guidePage.getHighLights().get(0).getRectF((ViewGroup) viewGroup.getParent());
                                        if (rectF != null) {
                                            Log.e("savion", "get rectf : " + rectF.toString());
                                        }
                                    }
                                }
                            })
                            .addHighLightWithOptions(relatedview,
                                    HighLight.Shape.CIRCLE,
                                    false,
                                    10,
                                    0,
                                    new HighlightOptions.Builder()
                                            .setRelativeGuide(new RelativeGuide(R.layout.layout_guide_qa_enter, Gravity.BOTTOM, 0) {
                                                @Override
                                                protected void onLayoutInflated(View view) {
                                                    super.onLayoutInflated(view);
                                                    View arrow = view.findViewById(R.id.arrow);
                                                    View desc = view.findViewById(R.id.desc);
                                                    if (arrow != null && desc != null) {
                                                        calGuideAlignCenter(arrow, relatedview);
                                                        calGuideAlignCenter(desc, relatedview);
                                                    }
                                                }

                                                @Override
                                                protected void onLayoutCallBack(View view, Controller controller, HighLight highLight, RectF rectF) {
                                                    super.onLayoutCallBack(view, controller, highLight, rectF);
                                                    Log.e("savion", "get rectf222 : " + rectF.toString());
                                                }
                                            })
                                            .setOnHighlightCallBack(new OnHighlightCallBack() {
                                                @Override
                                                public void onHighlightCallBack(GuideLayout guideLayout, View view, Controller controller, HighLight highLight, RectF rectF) {
                                                    Log.e("savion", "get rectf333 : " + rectF.toString());
                                                }
                                            })
                                            .setOnClickListener(new OnGuideClickListener() {
                                                @Override
                                                public void onClick(View view, Controller controller) {
                                                    if (controller != null) {
                                                        controller.remove();
                                                    }
                                                }
                                            })
                                            .ignoreDrawHighLightMask(true)
                                            .build())
                            .setEverywhereCancelable(false))
                    .build();
            controller.show();
        }
    }

    public int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public void calGuideAlignCenter(View guideView, View relatView) {
        try {
            int[] loc = new int[2];
            relatView.getLocationOnScreen(loc);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) guideView.getLayoutParams();
            float relatWidth = relatView.getWidth();
            float guideContentWidth = layoutParams.matchConstraintPercentWidth * getScreenWidth();
            layoutParams.horizontalBias = 1f;//(loc[0] + relatWidth / 2f - guideContentWidth / 2f) * 1f / (ScreenUtils.getScreenWidth() - guideContentWidth);
            guideView.setLayoutParams(layoutParams);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

}