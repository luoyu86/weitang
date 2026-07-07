package com.chinavisionary.core.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes.dex */
public class BaseSwipeRefreshLayout extends SwipeRefreshLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseRecyclerView f6689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SwipeRefreshLayout.OnRefreshListener f6692d;

    public class a implements SwipeRefreshLayout.OnRefreshListener {
        public a() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            if (BaseSwipeRefreshLayout.this.f6689a == null || BaseSwipeRefreshLayout.this.f6689a.getOnRecyclerScrollListener() == null) {
                return;
            }
            BaseSwipeRefreshLayout.this.f6689a.getOnRecyclerScrollListener().onRefresh();
        }
    }

    public BaseSwipeRefreshLayout(@NonNull Context context) {
        super(context);
        this.f6692d = new a();
        b();
    }

    public final void b() {
        this.f6690b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f6689a = new BaseRecyclerView(getContext());
        addView(this.f6689a, new ViewGroup.LayoutParams(-1, -1));
        setOnRefreshListener(this.f6692d);
    }

    public BaseRecyclerView getBaseRecyclerView() {
        return this.f6689a;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6691c = motionEvent.getX();
        } else if (action == 2 && Math.abs(motionEvent.getX() - this.f6691c) > this.f6690b + 40) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public BaseSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6692d = new a();
        b();
    }
}
