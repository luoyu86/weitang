package cn.admobiletop.adsuyi.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.R;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiViewUtil {
    public static void a(View view) {
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

    public static void addIvToRl(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5, int i6, float f2) {
        if (relativeLayout == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i6);
        if (i2 == 0) {
            layoutParams.addRule(9);
        } else if (i2 == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
        } else if (i2 == 2) {
            layoutParams.addRule(11);
        } else if (i2 == 3) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
        }
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = i4;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i4;
        ImageView imageView = new ImageView(relativeLayout.getContext());
        imageView.setImageResource(i3);
        imageView.setAlpha(f2);
        relativeLayout.addView(imageView, layoutParams);
    }

    public static void addLogoToAdView(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5, int i6, float f2) {
        if (ADSuyiSdk.getInstance().isShowAdLogo()) {
            addIvToRl(relativeLayout, i2, i3, i4, i5, i6, f2);
        }
    }

    public static ViewGroup getActionButtonView(Context context, String str) {
        float f2 = context.getResources().getDisplayMetrics().density;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundResource(R.drawable.adsuyi_shape_action_button);
        TextView textView = new TextView(relativeLayout.getContext());
        textView.setText(str);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.leftMargin = (int) (37.0f * f2);
        layoutParams.rightMargin = (int) (43.0f * f2);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.adsuyi_icon_action_btn_right_arrow);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (7.0f * f2), (int) (16.0f * f2));
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = (int) (f2 * 12.0f);
        relativeLayout.addView(imageView, layoutParams2);
        return relativeLayout;
    }

    public static RelativeLayout.LayoutParams getActionButtonViewLayoutParams(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (40.0f * f2));
        layoutParams.addRule(12);
        int i2 = (int) (27.0f * f2);
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = (int) (f2 * 60.0f);
        return layoutParams;
    }

    public static ImageView getDefaultCloseView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setAlpha(0.7f);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.adsuyi_icon_close);
        return imageView;
    }

    public static TextView getDefaultSkipView(Context context) {
        int i2 = (int) (context.getResources().getDisplayMetrics().density * 5.0f);
        TextView textView = new TextView(context);
        textView.setAlpha(0.7f);
        textView.setPadding(i2, 0, i2, 0);
        textView.setBackgroundResource(R.drawable.adsuyi_shape_66000000_radius12);
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setText("5 跳过");
        textView.setMinWidth(ADSuyiDisplayUtil.dp2px(60));
        textView.setMinHeight(ADSuyiDisplayUtil.dp2px(22));
        return textView;
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
