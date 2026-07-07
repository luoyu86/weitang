package com.tianmu.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.c.f.c;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuViewUtil {
    private static void a(View view) {
        if (view != null) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
            view.setClickable(false);
        }
    }

    public static void addAdViewToAdContainer(ViewGroup viewGroup, View view) {
        addAdViewToAdContainer(viewGroup, view, null);
    }

    public static void addDefaultAdTargetView(int i2, RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            try {
                ImageView imageView = new ImageView(relativeLayout.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(i2);
                int i3 = (int) (relativeLayout.getResources().getDisplayMetrics().density * 12.0f);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((i3 * 46) / 18, i3);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                imageView.setLayoutParams(layoutParams);
                relativeLayout.addView(imageView);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void addDefaultAdTargetViewToBottomRight(String str, RelativeLayout relativeLayout, int i2) {
        if (relativeLayout != null) {
            try {
                TextView textView = new TextView(relativeLayout.getContext());
                textView.setTextSize(10.0f);
                textView.setPadding(TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(3), TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(3));
                textView.setTextColor(-1);
                textView.setBackgroundResource(c.p);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(TianmuDisplayUtil.dp2px(i2), TianmuDisplayUtil.dp2px(i2), TianmuDisplayUtil.dp2px(i2), TianmuDisplayUtil.dp2px(i2));
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                textView.setText(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void addDefaultAdTargetViewToTop(String str, RelativeLayout relativeLayout, int i2, int i3) {
        if (relativeLayout != null) {
            try {
                TextView textView = new TextView(relativeLayout.getContext());
                textView.setTextSize(10.0f);
                textView.setPadding(TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(3), TianmuDisplayUtil.dp2px(5), TianmuDisplayUtil.dp2px(3));
                textView.setTextColor(-1);
                textView.setBackgroundResource(c.p);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (i3 == 1) {
                    layoutParams.addRule(11);
                    layoutParams.addRule(10);
                } else {
                    layoutParams.addRule(9);
                    layoutParams.addRule(10);
                }
                layoutParams.setMargins(TianmuDisplayUtil.dp2px(i2), TianmuDisplayUtil.dp2px(i2), TianmuDisplayUtil.dp2px(i2), TianmuDisplayUtil.dp2px(i2));
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                textView.setText(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void addDefaultCloseIcon(View view, RelativeLayout relativeLayout) {
        if (view == null || relativeLayout == null) {
            return;
        }
        float f2 = relativeLayout.getResources().getDisplayMetrics().density;
        int i2 = (int) (20.0f * f2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = (int) (f2 * 8.0f);
        layoutParams.topMargin = (int) (5.0f * f2);
        removeSelfFromParent(view);
        relativeLayout.addView(view, layoutParams);
    }

    public static RelativeLayout.LayoutParams getCustomInterstitialLayoutParams(int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams.bottomMargin = i4;
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        return layoutParams;
    }

    public static ImageView getDefaultCloseView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setAlpha(0.7f);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(c.n);
        return imageView;
    }

    public static RelativeLayout.LayoutParams getDefaultJumpViewLayoutParams(boolean z, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams.topMargin = TianmuDisplayUtil.dp2px(40);
        } else {
            layoutParams.topMargin = TianmuDisplayUtil.dp2px(20);
        }
        if (i3 == 1) {
            layoutParams.addRule(9);
            layoutParams.leftMargin = TianmuDisplayUtil.dp2px(i2);
        } else {
            layoutParams.addRule(11);
            layoutParams.rightMargin = TianmuDisplayUtil.dp2px(i2);
        }
        return layoutParams;
    }

    public static RelativeLayout.LayoutParams getDefaultShakeViewLayoutParams(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = i2;
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        return layoutParams;
    }

    public static TextView getDefaultSkipView(Context context) {
        int i2 = (int) (context.getResources().getDisplayMetrics().density * 5.0f);
        TextView textView = new TextView(context);
        textView.setAlpha(0.7f);
        textView.setPadding(i2, 0, i2, 0);
        textView.setBackgroundResource(c.o);
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setText("5 | 跳过");
        textView.setMinWidth(TianmuDisplayUtil.dp2px(60));
        textView.setMinHeight(TianmuDisplayUtil.dp2px(30));
        return textView;
    }

    public static RelativeLayout.LayoutParams getDefaultSlideAnimalViewLayoutParams(int i2, int i3) {
        return new RelativeLayout.LayoutParams(i2, i3);
    }

    public static RelativeLayout.LayoutParams getDefaultSlideViewLayoutParams(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = i2;
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        return layoutParams;
    }

    public static TextView getDefaultTipView(Context context) {
        int i2 = (int) (context.getResources().getDisplayMetrics().density * 5.0f);
        TextView textView = new TextView(context);
        textView.setAlpha(0.7f);
        textView.setPadding(i2, 0, i2, 0);
        textView.setBackgroundResource(c.o);
        textView.setTextColor(-1);
        textView.setTextSize(10.0f);
        textView.setGravity(17);
        textView.setMinWidth(TianmuDisplayUtil.dp2px(40));
        textView.setMinHeight(TianmuDisplayUtil.dp2px(22));
        return textView;
    }

    public static RelativeLayout.LayoutParams getSplashHotAreaViewLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        return layoutParams;
    }

    public static void releaseClickTouchListener(ViewGroup viewGroup, View... viewArr) {
        a(viewGroup);
        if (viewArr == null || viewArr.length <= 0) {
            return;
        }
        for (View view : viewArr) {
            a(view);
        }
    }

    public static void removeSelfFromParent(View... viewArr) {
        if (viewArr == null || viewArr.length <= 0) {
            return;
        }
        for (View view : viewArr) {
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }

    public static void addAdViewToAdContainer(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null) {
            return;
        }
        if (view == null) {
            viewGroup.removeAllViews();
            return;
        }
        if (viewGroup.getChildCount() <= 0 || viewGroup.getChildAt(0) != view) {
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (layoutParams != null) {
                viewGroup.addView(view, layoutParams);
            } else {
                viewGroup.addView(view);
            }
        }
    }
}
