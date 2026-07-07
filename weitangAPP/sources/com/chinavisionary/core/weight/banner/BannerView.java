package com.chinavisionary.core.weight.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.e.a.d.c0.d;
import c.e.a.d.k;
import com.chinavisionary.core.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BannerView extends RelativeLayout implements ViewPager.OnPageChangeListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f6735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPager f6737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f6738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ImageView> f6739e;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int currentItem;
            if (message.what == 0) {
                if (BannerView.this.f6739e.size() != 0 && (currentItem = (BannerView.this.f6737c.getCurrentItem() + 1) % BannerView.this.f6739e.size()) < BannerView.this.f6739e.size()) {
                    BannerView.this.f6737c.setCurrentItem(currentItem);
                }
                BannerView.this.f6735a.removeMessages(0);
                BannerView.this.f6735a.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    public BannerView(Context context) {
        super(context);
        this.f6735a = new a();
        this.f6739e = new ArrayList();
        e(context);
    }

    public final void d(int i2) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bannerView_ll_dots);
        linearLayout.removeAllViews();
        this.f6739e.clear();
        for (int i3 = 0; i3 < i2; i3++) {
            ImageView imageView = new ImageView(this.f6736b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 10, 0);
            imageView.setLayoutParams(layoutParams);
            linearLayout.addView(imageView);
            this.f6739e.add(imageView);
        }
        h(0);
    }

    public final void e(Context context) {
        this.f6736b = context;
        View.inflate(context, R.layout.layout_banner_view, this);
        this.f6737c = (ViewPager) findViewById(R.id.bannerView_vp_images);
        this.f6738d = (ImageView) findViewById(R.id.homeHeader_iv_banner_bottom_bg);
        this.f6737c.setLayoutParams(new RelativeLayout.LayoutParams(-1, (k.getScreenWidth(context) * 300) / 750));
        this.f6738d.setLayoutParams(new RelativeLayout.LayoutParams(-1, (k.getScreenWidth(context) * 300) / 750));
        this.f6737c.setOnPageChangeListener(this);
        this.f6737c.setOnTouchListener(this);
    }

    public final void f() {
        this.f6735a.sendEmptyMessageDelayed(0, 3000L);
    }

    public final void g() {
        this.f6735a.removeMessages(0);
    }

    public final void h(int i2) {
        for (int i3 = 0; i3 < this.f6739e.size(); i3++) {
            if (i3 == i2) {
                this.f6739e.get(i3).setBackgroundResource(R.drawable.banner_indecator_normal);
            } else {
                this.f6739e.get(i3).setBackgroundResource(R.drawable.banner_indecator_selected);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        h(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            int r5 = r5.getAction()
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L1d
            if (r5 == r1) goto L11
            r2 = 2
            if (r5 == r2) goto L1d
            r1 = 3
            if (r5 == r1) goto L11
            goto L25
        L11:
            androidx.viewpager.widget.ViewPager r5 = r3.f6737c
            r5.requestDisallowInterceptTouchEvent(r0)
            r3.f()
            r4.performClick()
            goto L25
        L1d:
            androidx.viewpager.widget.ViewPager r4 = r3.f6737c
            r4.requestDisallowInterceptTouchEvent(r1)
            r3.g()
        L25:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.weight.banner.BannerView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAdapter(PagerAdapter pagerAdapter, String str, String str2) {
        this.f6737c.setAdapter(pagerAdapter);
        d(pagerAdapter.getCount());
        f();
        if (!"1".equals(str2)) {
            this.f6738d.setVisibility(8);
        } else {
            this.f6738d.setVisibility(0);
            d.getInstance().display(str, this.f6738d);
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6735a = new a();
        this.f6739e = new ArrayList();
        e(context);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6735a = new a();
        this.f6739e = new ArrayList();
        e(context);
    }
}
