package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class PreOrderCancelFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreOrderCancelFragment f8150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f8154f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreOrderCancelFragment f8155c;

        public a(PreOrderCancelFragment preOrderCancelFragment) {
            this.f8155c = preOrderCancelFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8155c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreOrderCancelFragment f8157c;

        public b(PreOrderCancelFragment preOrderCancelFragment) {
            this.f8157c = preOrderCancelFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8157c.catCancelInfoClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreOrderCancelFragment f8159c;

        public c(PreOrderCancelFragment preOrderCancelFragment) {
            this.f8159c = preOrderCancelFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8159c.submitClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreOrderCancelFragment f8161c;

        public d(PreOrderCancelFragment preOrderCancelFragment) {
            this.f8161c = preOrderCancelFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8161c.helpClick(view);
        }
    }

    @UiThread
    public PreOrderCancelFragment_ViewBinding(PreOrderCancelFragment preOrderCancelFragment, View view) {
        this.f8150b = preOrderCancelFragment;
        preOrderCancelFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        preOrderCancelFragment.mCancelReasonEdt = (AppCompatEditText) b.c.d.findRequiredViewAsType(view, R.id.edt_cancel_reason, "field 'mCancelReasonEdt'", AppCompatEditText.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8151c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(preOrderCancelFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_cat_cancel_info, "method 'catCancelInfoClick'");
        this.f8152d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(preOrderCancelFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_submit, "method 'submitClick'");
        this.f8153e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(preOrderCancelFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_help, "method 'helpClick'");
        this.f8154f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(preOrderCancelFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreOrderCancelFragment preOrderCancelFragment = this.f8150b;
        if (preOrderCancelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8150b = null;
        preOrderCancelFragment.mTitleTv = null;
        preOrderCancelFragment.mCancelReasonEdt = null;
        this.f8151c.setOnClickListener(null);
        this.f8151c = null;
        this.f8152d.setOnClickListener(null);
        this.f8152d = null;
        this.f8153e.setOnClickListener(null);
        this.f8153e = null;
        this.f8154f.setOnClickListener(null);
        this.f8154f = null;
    }
}
