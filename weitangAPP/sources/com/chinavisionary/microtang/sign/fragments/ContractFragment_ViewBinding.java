package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.BaseWebView;

/* JADX INFO: loaded from: classes2.dex */
public class ContractFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContractFragment f8511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8513d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractFragment f8514c;

        public a(ContractFragment contractFragment) {
            this.f8514c = contractFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8514c.nextClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContractFragment f8516c;

        public b(ContractFragment contractFragment) {
            this.f8516c = contractFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8516c.backClick(view);
        }
    }

    @UiThread
    public ContractFragment_ViewBinding(ContractFragment contractFragment, View view) {
        this.f8511b = contractFragment;
        contractFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        contractFragment.mTitleSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleSplitLineTv'", TextView.class);
        contractFragment.mProtocolTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_protocol_title, "field 'mProtocolTitleTv'", TextView.class);
        contractFragment.mAgreeCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_agree, "field 'mAgreeCb'", CheckBox.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mNextBtn' and method 'nextClick'");
        contractFragment.mNextBtn = (Button) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mNextBtn'", Button.class);
        this.f8512c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(contractFragment));
        contractFragment.mWebView = (BaseWebView) d.findRequiredViewAsType(view, R.id.web_view, "field 'mWebView'", BaseWebView.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8513d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(contractFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContractFragment contractFragment = this.f8511b;
        if (contractFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8511b = null;
        contractFragment.mTitleTv = null;
        contractFragment.mTitleSplitLineTv = null;
        contractFragment.mProtocolTitleTv = null;
        contractFragment.mAgreeCb = null;
        contractFragment.mNextBtn = null;
        contractFragment.mWebView = null;
        this.f8512c.setOnClickListener(null);
        this.f8512c = null;
        this.f8513d.setOnClickListener(null);
        this.f8513d = null;
    }
}
