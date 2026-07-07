package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractExitRentFragment f7127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7129d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractExitRentFragment f7130c;

        public a(ContractExitRentFragment contractExitRentFragment) {
            this.f7130c = contractExitRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7130c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractExitRentFragment f7132c;

        public b(ContractExitRentFragment contractExitRentFragment) {
            this.f7132c = contractExitRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7132c.nextClick(view);
        }
    }

    @UiThread
    public ContractExitRentFragment_ViewBinding(ContractExitRentFragment contractExitRentFragment, View view) {
        this.f7127b = contractExitRentFragment;
        contractExitRentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractExitRentFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7128c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractExitRentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_next, "method 'nextClick'");
        this.f7129d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(contractExitRentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractExitRentFragment contractExitRentFragment = this.f7127b;
        if (contractExitRentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7127b = null;
        contractExitRentFragment.mTitleTv = null;
        contractExitRentFragment.mSwipeRefreshLayout = null;
        this.f7128c.setOnClickListener(null);
        this.f7128c = null;
        this.f7129d.setOnClickListener(null);
        this.f7129d = null;
    }
}
