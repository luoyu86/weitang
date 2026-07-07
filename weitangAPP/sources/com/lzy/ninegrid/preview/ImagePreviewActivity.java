package com.lzy.ninegrid.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.lzy.ninegrid.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePreviewActivity extends Activity implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f9443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WatermarkView f9444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImagePreviewAdapter f9445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<c.k.b.a> f9446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9451i;
    public ViewPager j;
    public TextView k;

    public class a extends ViewPager.SimpleOnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        @SuppressLint({"StringFormatMatches"})
        public void onPageSelected(int i2) {
            ImagePreviewActivity.this.f9447e = i2;
            TextView textView = ImagePreviewActivity.this.k;
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            textView.setText(imagePreviewActivity.getString(R.string.select, new Object[]{Integer.valueOf(imagePreviewActivity.f9447e + 1), Integer.valueOf(ImagePreviewActivity.this.f9446d.size())}));
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f9453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.k.b.a f9454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f9455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f9456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f9457e;

        public b(View view, c.k.b.a aVar, ImageView imageView, float f2, float f3) {
            this.f9453a = view;
            this.f9454b = aVar;
            this.f9455c = imageView;
            this.f9456d = f2;
            this.f9457e = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            long duration = valueAnimator.getDuration();
            float currentPlayTime = duration > 0 ? valueAnimator.getCurrentPlayTime() / duration : 1.0f;
            float f2 = currentPlayTime <= 1.0f ? currentPlayTime : 1.0f;
            View view = this.f9453a;
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            c.k.b.a aVar = this.f9454b;
            view.setTranslationX(imagePreviewActivity.evaluateInt(f2, Integer.valueOf((aVar.imageViewX + (aVar.imageViewWidth / 2)) - (this.f9455c.getWidth() / 2)), 0).intValue());
            View view2 = this.f9453a;
            ImagePreviewActivity imagePreviewActivity2 = ImagePreviewActivity.this;
            c.k.b.a aVar2 = this.f9454b;
            view2.setTranslationY(imagePreviewActivity2.evaluateInt(f2, Integer.valueOf((aVar2.imageViewY + (aVar2.imageViewHeight / 2)) - (this.f9455c.getHeight() / 2)), 0).intValue());
            this.f9453a.setScaleX(ImagePreviewActivity.this.evaluateFloat(f2, Float.valueOf(this.f9456d), 1).floatValue());
            this.f9453a.setScaleY(ImagePreviewActivity.this.evaluateFloat(f2, Float.valueOf(this.f9457e), 1).floatValue());
            this.f9453a.setAlpha(f2);
            ImagePreviewActivity.this.f9443a.setBackgroundColor(ImagePreviewActivity.this.evaluateArgb(f2, 0, -16777216));
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f9459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.k.b.a f9460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f9461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f9462d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f9463e;

        public c(View view, c.k.b.a aVar, ImageView imageView, float f2, float f3) {
            this.f9459a = view;
            this.f9460b = aVar;
            this.f9461c = imageView;
            this.f9462d = f2;
            this.f9463e = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            long duration = valueAnimator.getDuration();
            float currentPlayTime = duration > 0 ? valueAnimator.getCurrentPlayTime() / duration : 1.0f;
            if (currentPlayTime > 1.0f) {
                currentPlayTime = 1.0f;
            }
            View view = this.f9459a;
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            c.k.b.a aVar = this.f9460b;
            view.setTranslationX(imagePreviewActivity.evaluateInt(currentPlayTime, 0, Integer.valueOf((aVar.imageViewX + (aVar.imageViewWidth / 2)) - (this.f9461c.getWidth() / 2))).intValue());
            View view2 = this.f9459a;
            ImagePreviewActivity imagePreviewActivity2 = ImagePreviewActivity.this;
            c.k.b.a aVar2 = this.f9460b;
            view2.setTranslationY(imagePreviewActivity2.evaluateInt(currentPlayTime, 0, Integer.valueOf((aVar2.imageViewY + (aVar2.imageViewHeight / 2)) - (this.f9461c.getHeight() / 2))).intValue());
            this.f9459a.setScaleX(ImagePreviewActivity.this.evaluateFloat(currentPlayTime, 1, Float.valueOf(this.f9462d)).floatValue());
            this.f9459a.setScaleY(ImagePreviewActivity.this.evaluateFloat(currentPlayTime, 1, Float.valueOf(this.f9463e)).floatValue());
            this.f9459a.setAlpha(1.0f - currentPlayTime);
            ImagePreviewActivity.this.f9443a.setBackgroundColor(ImagePreviewActivity.this.evaluateArgb(currentPlayTime, -16777216, 0));
        }
    }

    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ImagePreviewActivity.this.f9443a.setBackgroundColor(0);
        }
    }

    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ImagePreviewActivity.this.finish();
            ImagePreviewActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ImagePreviewActivity.this.f9443a.setBackgroundColor(0);
        }
    }

    public int evaluateArgb(float f2, int i2, int i3) {
        return ((((i2 >> 24) & 255) + ((int) ((((i3 >> 24) & 255) - r0) * f2))) << 24) | ((((i2 >> 16) & 255) + ((int) ((((i3 >> 16) & 255) - r1) * f2))) << 16) | ((((i2 >> 8) & 255) + ((int) ((((i3 >> 8) & 255) - r2) * f2))) << 8) | ((i2 & 255) + ((int) (f2 * ((i3 & 255) - r8))));
    }

    public Float evaluateFloat(float f2, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return Float.valueOf(fFloatValue + (f2 * (number2.floatValue() - fFloatValue)));
    }

    public Integer evaluateInt(float f2, Integer num, Integer num2) {
        return Integer.valueOf((int) (num.intValue() + (f2 * (num2.intValue() - r3))));
    }

    public final void f(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new d());
    }

    public void finishActivityAnim() {
        View primaryItem = this.f9445c.getPrimaryItem();
        ImageView primaryImageView = this.f9445c.getPrimaryImageView();
        if (primaryImageView != null) {
            h(primaryImageView);
            List<c.k.b.a> list = this.f9446d;
            if (list == null || list.size() <= 0) {
                return;
            }
            int size = this.f9446d.size();
            if (this.f9447e >= size) {
                this.f9447e = size - 1;
            }
            if (this.f9447e < 0) {
                this.f9447e = 0;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new c(primaryItem, this.f9446d.get(this.f9447e), primaryImageView, (r4.imageViewWidth * 1.0f) / this.f9449g, (r4.imageViewHeight * 1.0f) / this.f9448f));
            g(valueAnimatorOfFloat);
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.start();
        }
    }

    public final void g(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new e());
    }

    public final void h(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float f2 = intrinsicHeight;
        float f3 = (this.f9451i * 1.0f) / f2;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float f4 = (this.f9450h * 1.0f) / intrinsicWidth;
        if (f3 > f4) {
            f3 = f4;
        }
        this.f9448f = (int) (f2 * f3);
        this.f9449g = (int) (intrinsicWidth * f3);
    }

    public final void i(Intent intent) {
        String stringExtra = intent.getStringExtra("WatermarkView");
        if (TextUtils.isEmpty(stringExtra)) {
            this.f9444b.setVisibility(8);
        } else {
            this.f9444b.setVisibility(0);
            this.f9444b.setWatermarkText(stringExtra);
        }
        this.f9446d = (List) intent.getSerializableExtra("IMAGE_INFO");
        this.f9447e = intent.getIntExtra("CURRENT_ITEM", 0);
        ImagePreviewAdapter imagePreviewAdapter = new ImagePreviewAdapter(this, this.f9446d);
        this.f9445c = imagePreviewAdapter;
        this.j.setAdapter(imagePreviewAdapter);
        this.j.setCurrentItem(this.f9447e);
        this.j.getViewTreeObserver().addOnPreDrawListener(this);
        this.j.addOnPageChangeListener(new a());
        this.k.setText(getString(R.string.select, new Object[]{Integer.valueOf(this.f9447e + 1), Integer.valueOf(this.f9446d.size())}));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finishActivityAnim();
    }

    @Override // android.app.Activity
    @SuppressLint({"StringFormatMatches"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_preview);
        this.j = (ViewPager) findViewById(R.id.viewPager);
        this.k = (TextView) findViewById(R.id.tv_pager);
        this.f9443a = (RelativeLayout) findViewById(R.id.rootView);
        this.f9444b = (WatermarkView) findViewById(R.id.watermarkView);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f9450h = displayMetrics.widthPixels;
        this.f9451i = displayMetrics.heightPixels;
        i(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        i(intent);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f9443a.getViewTreeObserver().removeOnPreDrawListener(this);
        View primaryItem = this.f9445c.getPrimaryItem();
        ImageView primaryImageView = this.f9445c.getPrimaryImageView();
        if (primaryImageView != null) {
            h(primaryImageView);
            List<c.k.b.a> list = this.f9446d;
            if (list != null && list.size() > 0) {
                int size = this.f9446d.size();
                if (this.f9447e >= size) {
                    this.f9447e = size - 1;
                }
                if (this.f9447e < 0) {
                    this.f9447e = 0;
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new b(primaryItem, this.f9446d.get(this.f9447e), primaryImageView, (r4.imageViewWidth * 1.0f) / this.f9449g, (r4.imageViewHeight * 1.0f) / this.f9448f));
                f(valueAnimatorOfFloat);
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.start();
            }
        }
        return true;
    }
}
