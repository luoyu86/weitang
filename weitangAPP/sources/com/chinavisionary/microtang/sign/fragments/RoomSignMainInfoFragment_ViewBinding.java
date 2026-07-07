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
public class RoomSignMainInfoFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomSignMainInfoFragment f8541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8543d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSignMainInfoFragment f8544c;

        public a(RoomSignMainInfoFragment roomSignMainInfoFragment) {
            this.f8544c = roomSignMainInfoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8544c.confirmClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomSignMainInfoFragment f8546c;

        public b(RoomSignMainInfoFragment roomSignMainInfoFragment) {
            this.f8546c = roomSignMainInfoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8546c.finishFragment(view);
        }
    }

    @UiThread
    public RoomSignMainInfoFragment_ViewBinding(RoomSignMainInfoFragment roomSignMainInfoFragment, View view) {
        this.f8541b = roomSignMainInfoFragment;
        roomSignMainInfoFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomSignMainInfoFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.recycler_view_sign_main_info, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_confirm, "method 'confirmClick'");
        this.f8542c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomSignMainInfoFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8543d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomSignMainInfoFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomSignMainInfoFragment roomSignMainInfoFragment = this.f8541b;
        if (roomSignMainInfoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8541b = null;
        roomSignMainInfoFragment.mTitleTv = null;
        roomSignMainInfoFragment.mSwipeRefreshLayout = null;
        this.f8542c.setOnClickListener(null);
        this.f8542c = null;
        this.f8543d.setOnClickListener(null);
        this.f8543d = null;
    }
}
