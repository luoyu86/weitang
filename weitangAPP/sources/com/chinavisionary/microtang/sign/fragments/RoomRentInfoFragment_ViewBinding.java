package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoomRentInfoFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomRentInfoFragment f8526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8528d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomRentInfoFragment f8529c;

        public a(RoomRentInfoFragment roomRentInfoFragment) {
            this.f8529c = roomRentInfoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8529c.confirmClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomRentInfoFragment f8531c;

        public b(RoomRentInfoFragment roomRentInfoFragment) {
            this.f8531c = roomRentInfoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8531c.finishFragment(view);
        }
    }

    @UiThread
    public RoomRentInfoFragment_ViewBinding(RoomRentInfoFragment roomRentInfoFragment, View view) {
        this.f8526b = roomRentInfoFragment;
        roomRentInfoFragment.mBackImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImg'", ImageView.class);
        roomRentInfoFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomRentInfoFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.recycler_rent_info, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_confirm, "field 'mConfirmBtn' and method 'confirmClick'");
        roomRentInfoFragment.mConfirmBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mConfirmBtn'", AppCompatButton.class);
        this.f8527c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomRentInfoFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8528d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomRentInfoFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomRentInfoFragment roomRentInfoFragment = this.f8526b;
        if (roomRentInfoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8526b = null;
        roomRentInfoFragment.mBackImg = null;
        roomRentInfoFragment.mTitleTv = null;
        roomRentInfoFragment.mSwipeRefreshLayout = null;
        roomRentInfoFragment.mConfirmBtn = null;
        this.f8527c.setOnClickListener(null);
        this.f8527c = null;
        this.f8528d.setOnClickListener(null);
        this.f8528d = null;
    }
}
