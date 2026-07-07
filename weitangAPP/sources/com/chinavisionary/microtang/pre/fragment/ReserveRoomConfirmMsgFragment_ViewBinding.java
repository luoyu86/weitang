package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveRoomConfirmMsgFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReserveRoomConfirmMsgFragment f8174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8176d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReserveRoomConfirmMsgFragment f8177c;

        public a(ReserveRoomConfirmMsgFragment reserveRoomConfirmMsgFragment) {
            this.f8177c = reserveRoomConfirmMsgFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8177c.nextClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReserveRoomConfirmMsgFragment f8179c;

        public b(ReserveRoomConfirmMsgFragment reserveRoomConfirmMsgFragment) {
            this.f8179c = reserveRoomConfirmMsgFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8179c.backClick(view);
        }
    }

    @UiThread
    public ReserveRoomConfirmMsgFragment_ViewBinding(ReserveRoomConfirmMsgFragment reserveRoomConfirmMsgFragment, View view) {
        this.f8174b = reserveRoomConfirmMsgFragment;
        reserveRoomConfirmMsgFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        reserveRoomConfirmMsgFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mNextBtn' and method 'nextClick'");
        reserveRoomConfirmMsgFragment.mNextBtn = (Button) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mNextBtn'", Button.class);
        this.f8175c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reserveRoomConfirmMsgFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8176d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reserveRoomConfirmMsgFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReserveRoomConfirmMsgFragment reserveRoomConfirmMsgFragment = this.f8174b;
        if (reserveRoomConfirmMsgFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8174b = null;
        reserveRoomConfirmMsgFragment.mTitleTv = null;
        reserveRoomConfirmMsgFragment.mSwipeRefreshLayout = null;
        reserveRoomConfirmMsgFragment.mNextBtn = null;
        this.f8175c.setOnClickListener(null);
        this.f8175c = null;
        this.f8176d.setOnClickListener(null);
        this.f8176d = null;
    }
}
