package com.chinavisionary.core.weight.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class NoScrollViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6769a;

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6769a = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f6769a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6769a) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2, boolean z) {
        super.setCurrentItem(i2, z);
    }

    public void setNoScroll(boolean z) {
        this.f6769a = z;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2) {
        super.setCurrentItem(i2);
    }

    public NoScrollViewPager(Context context) {
        super(context);
        this.f6769a = false;
    }
}
