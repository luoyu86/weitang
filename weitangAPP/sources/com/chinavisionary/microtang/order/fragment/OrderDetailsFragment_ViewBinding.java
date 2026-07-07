package com.chinavisionary.microtang.order.fragment;

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
public class OrderDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrderDetailsFragment f8091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8093d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderDetailsFragment f8094c;

        public a(OrderDetailsFragment orderDetailsFragment) {
            this.f8094c = orderDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8094c.keepPayClickView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderDetailsFragment f8096c;

        public b(OrderDetailsFragment orderDetailsFragment) {
            this.f8096c = orderDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8096c.backClick(view);
        }
    }

    @UiThread
    public OrderDetailsFragment_ViewBinding(OrderDetailsFragment orderDetailsFragment, View view) {
        this.f8091b = orderDetailsFragment;
        orderDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        orderDetailsFragment.mCountPayPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_count_pay_price, "field 'mCountPayPriceTv'", TextView.class);
        orderDetailsFragment.mBgView = d.findRequiredView(view, R.id.view_bottom_bg, "field 'mBgView'");
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_keep_pay, "field 'mKeepPayBtn' and method 'keepPayClickView'");
        orderDetailsFragment.mKeepPayBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_keep_pay, "field 'mKeepPayBtn'", AppCompatButton.class);
        this.f8092c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(orderDetailsFragment));
        orderDetailsFragment.mCountPayTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_count_pay_title, "field 'mCountPayTitleTv'", TextView.class);
        orderDetailsFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_order_details, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8093d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(orderDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OrderDetailsFragment orderDetailsFragment = this.f8091b;
        if (orderDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8091b = null;
        orderDetailsFragment.mTitleTv = null;
        orderDetailsFragment.mCountPayPriceTv = null;
        orderDetailsFragment.mBgView = null;
        orderDetailsFragment.mKeepPayBtn = null;
        orderDetailsFragment.mCountPayTitleTv = null;
        orderDetailsFragment.mBaseSwipeRefreshLayout = null;
        this.f8092c.setOnClickListener(null);
        this.f8092c = null;
        this.f8093d.setOnClickListener(null);
        this.f8093d = null;
    }
}
