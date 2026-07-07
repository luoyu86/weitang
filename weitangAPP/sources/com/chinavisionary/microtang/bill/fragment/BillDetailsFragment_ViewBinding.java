package com.chinavisionary.microtang.bill.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class BillDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BillDetailsFragment f6864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6866d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BillDetailsFragment f6867c;

        public a(BillDetailsFragment billDetailsFragment) {
            this.f6867c = billDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6867c.nextClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BillDetailsFragment f6869c;

        public b(BillDetailsFragment billDetailsFragment) {
            this.f6869c = billDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6869c.backClick(view);
        }
    }

    @UiThread
    public BillDetailsFragment_ViewBinding(BillDetailsFragment billDetailsFragment, View view) {
        this.f6864b = billDetailsFragment;
        billDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mNextBtn' and method 'nextClick'");
        billDetailsFragment.mNextBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mNextBtn'", AppCompatButton.class);
        this.f6865c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(billDetailsFragment));
        billDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f6866d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(billDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BillDetailsFragment billDetailsFragment = this.f6864b;
        if (billDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6864b = null;
        billDetailsFragment.mTitleTv = null;
        billDetailsFragment.mNextBtn = null;
        billDetailsFragment.mSwipeRefreshLayout = null;
        this.f6865c.setOnClickListener(null);
        this.f6865c = null;
        this.f6866d.setOnClickListener(null);
        this.f6866d = null;
    }
}
