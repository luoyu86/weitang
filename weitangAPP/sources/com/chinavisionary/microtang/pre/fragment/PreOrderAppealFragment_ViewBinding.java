package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class PreOrderAppealFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreOrderAppealFragment f8143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8145d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreOrderAppealFragment f8146c;

        public a(PreOrderAppealFragment preOrderAppealFragment) {
            this.f8146c = preOrderAppealFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8146c.submitClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreOrderAppealFragment f8148c;

        public b(PreOrderAppealFragment preOrderAppealFragment) {
            this.f8148c = preOrderAppealFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8148c.backClick(view);
        }
    }

    @UiThread
    public PreOrderAppealFragment_ViewBinding(PreOrderAppealFragment preOrderAppealFragment, View view) {
        this.f8143b = preOrderAppealFragment;
        preOrderAppealFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        preOrderAppealFragment.mAppealRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_appeal, "field 'mAppealRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_submit, "method 'submitClick'");
        this.f8144c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(preOrderAppealFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8145d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(preOrderAppealFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreOrderAppealFragment preOrderAppealFragment = this.f8143b;
        if (preOrderAppealFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8143b = null;
        preOrderAppealFragment.mTitleTv = null;
        preOrderAppealFragment.mAppealRecyclerView = null;
        this.f8144c.setOnClickListener(null);
        this.f8144c = null;
        this.f8145d.setOnClickListener(null);
        this.f8145d = null;
    }
}
