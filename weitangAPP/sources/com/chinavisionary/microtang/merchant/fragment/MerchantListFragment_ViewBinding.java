package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MerchantListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MerchantListFragment f7885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7888e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantListFragment f7889c;

        public a(MerchantListFragment merchantListFragment) {
            this.f7889c = merchantListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7889c.openScan();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantListFragment f7891c;

        public b(MerchantListFragment merchantListFragment) {
            this.f7891c = merchantListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7891c.msgClickView();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MerchantListFragment f7893c;

        public c(MerchantListFragment merchantListFragment) {
            this.f7893c = merchantListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7893c.serverClick();
        }
    }

    @UiThread
    public MerchantListFragment_ViewBinding(MerchantListFragment merchantListFragment, View view) {
        this.f7885b = merchantListFragment;
        merchantListFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_main, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f7886c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(merchantListFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f7887d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(merchantListFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f7888e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(merchantListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MerchantListFragment merchantListFragment = this.f7885b;
        if (merchantListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7885b = null;
        merchantListFragment.mBaseSwipeRefreshLayout = null;
        this.f7886c.setOnClickListener(null);
        this.f7886c = null;
        this.f7887d.setOnClickListener(null);
        this.f7887d = null;
        this.f7888e.setOnClickListener(null);
        this.f7888e = null;
    }
}
