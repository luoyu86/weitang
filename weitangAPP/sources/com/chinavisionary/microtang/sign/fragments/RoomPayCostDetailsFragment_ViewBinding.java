package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoomPayCostDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomPayCostDetailsFragment f8522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8523c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomPayCostDetailsFragment f8524c;

        public a(RoomPayCostDetailsFragment roomPayCostDetailsFragment) {
            this.f8524c = roomPayCostDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8524c.finishFragment(view);
        }
    }

    @UiThread
    public RoomPayCostDetailsFragment_ViewBinding(RoomPayCostDetailsFragment roomPayCostDetailsFragment, View view) {
        this.f8522b = roomPayCostDetailsFragment;
        roomPayCostDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomPayCostDetailsFragment.mConfirmPayCostBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_confirm_pay_cost, "field 'mConfirmPayCostBtn'", Button.class);
        roomPayCostDetailsFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_pay_cost, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8523c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomPayCostDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomPayCostDetailsFragment roomPayCostDetailsFragment = this.f8522b;
        if (roomPayCostDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8522b = null;
        roomPayCostDetailsFragment.mTitleTv = null;
        roomPayCostDetailsFragment.mConfirmPayCostBtn = null;
        roomPayCostDetailsFragment.mSwipeRefreshLayout = null;
        this.f8523c.setOnClickListener(null);
        this.f8523c = null;
    }
}
