package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.BaseWebView;

/* JADX INFO: loaded from: classes2.dex */
public class RoomContractConfirmFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomContractConfirmFragment f8518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8519c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomContractConfirmFragment f8520c;

        public a(RoomContractConfirmFragment roomContractConfirmFragment) {
            this.f8520c = roomContractConfirmFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8520c.finishFragment(view);
        }
    }

    @UiThread
    public RoomContractConfirmFragment_ViewBinding(RoomContractConfirmFragment roomContractConfirmFragment, View view) {
        this.f8518b = roomContractConfirmFragment;
        roomContractConfirmFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomContractConfirmFragment.mBaseWebView = (BaseWebView) d.findRequiredViewAsType(view, R.id.web_view_contract, "field 'mBaseWebView'", BaseWebView.class);
        roomContractConfirmFragment.mConfirmBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mConfirmBtn'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8519c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomContractConfirmFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomContractConfirmFragment roomContractConfirmFragment = this.f8518b;
        if (roomContractConfirmFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8518b = null;
        roomContractConfirmFragment.mTitleTv = null;
        roomContractConfirmFragment.mBaseWebView = null;
        roomContractConfirmFragment.mConfirmBtn = null;
        this.f8519c.setOnClickListener(null);
        this.f8519c = null;
    }
}
