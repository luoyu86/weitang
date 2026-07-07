package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MeFragment f7648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7651e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MeFragment f7652c;

        public a(MeFragment meFragment) {
            this.f7652c = meFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7652c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MeFragment f7654c;

        public b(MeFragment meFragment) {
            this.f7654c = meFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7654c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MeFragment f7656c;

        public c(MeFragment meFragment) {
            this.f7656c = meFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7656c.serverClick(view);
        }
    }

    @UiThread
    public MeFragment_ViewBinding(MeFragment meFragment, View view) {
        this.f7648b = meFragment;
        meFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        meFragment.mBadgeValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_value, "field 'mBadgeValueTv'", TextView.class);
        meFragment.mBadgePaintTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_paint, "field 'mBadgePaintTv'", TextView.class);
        meFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.recycler_clean, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7649c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(meFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7650d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(meFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7651e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(meFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MeFragment meFragment = this.f7648b;
        if (meFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7648b = null;
        meFragment.mTitleTv = null;
        meFragment.mBadgeValueTv = null;
        meFragment.mBadgePaintTv = null;
        meFragment.mBaseSwipeRefreshLayout = null;
        this.f7649c.setOnClickListener(null);
        this.f7649c = null;
        this.f7650d.setOnClickListener(null);
        this.f7650d = null;
        this.f7651e.setOnClickListener(null);
        this.f7651e = null;
    }
}
