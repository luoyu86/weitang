package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSignContractNearbyFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomSignContractNearbyFragment f8534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8536d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSignContractNearbyFragment f8537c;

        public a(RoomSignContractNearbyFragment roomSignContractNearbyFragment) {
            this.f8537c = roomSignContractNearbyFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8537c.confirmClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSignContractNearbyFragment f8539c;

        public b(RoomSignContractNearbyFragment roomSignContractNearbyFragment) {
            this.f8539c = roomSignContractNearbyFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8539c.finishFragment(view);
        }
    }

    @UiThread
    public RoomSignContractNearbyFragment_ViewBinding(RoomSignContractNearbyFragment roomSignContractNearbyFragment, View view) {
        this.f8534b = roomSignContractNearbyFragment;
        roomSignContractNearbyFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomSignContractNearbyFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.recycler_view_sign_contract_nearby, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_confirm, "method 'confirmClick'");
        this.f8535c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomSignContractNearbyFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8536d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomSignContractNearbyFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomSignContractNearbyFragment roomSignContractNearbyFragment = this.f8534b;
        if (roomSignContractNearbyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8534b = null;
        roomSignContractNearbyFragment.mTitleTv = null;
        roomSignContractNearbyFragment.mSwipeRefreshLayout = null;
        this.f8535c.setOnClickListener(null);
        this.f8535c = null;
        this.f8536d.setOnClickListener(null);
        this.f8536d = null;
    }
}
