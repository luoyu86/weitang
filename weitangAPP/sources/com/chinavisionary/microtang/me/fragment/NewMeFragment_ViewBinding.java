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
public class NewMeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NewMeFragment f7660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7663e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewMeFragment f7664c;

        public a(NewMeFragment newMeFragment) {
            this.f7664c = newMeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7664c.openScan(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewMeFragment f7666c;

        public b(NewMeFragment newMeFragment) {
            this.f7666c = newMeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7666c.msgClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewMeFragment f7668c;

        public c(NewMeFragment newMeFragment) {
            this.f7668c = newMeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7668c.serverClick(view);
        }
    }

    @UiThread
    public NewMeFragment_ViewBinding(NewMeFragment newMeFragment, View view) {
        this.f7660b = newMeFragment;
        newMeFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        newMeFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.recycler_clean, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7661c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(newMeFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7662d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(newMeFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7663e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(newMeFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewMeFragment newMeFragment = this.f7660b;
        if (newMeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7660b = null;
        newMeFragment.mTitleTv = null;
        newMeFragment.mBaseSwipeRefreshLayout = null;
        this.f7661c.setOnClickListener(null);
        this.f7661c = null;
        this.f7662d.setOnClickListener(null);
        this.f7662d = null;
        this.f7663e.setOnClickListener(null);
        this.f7663e = null;
    }
}
