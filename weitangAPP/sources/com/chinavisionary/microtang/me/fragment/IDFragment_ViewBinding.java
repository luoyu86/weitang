package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class IDFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IDFragment f7635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7637d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IDFragment f7638c;

        public a(IDFragment iDFragment) {
            this.f7638c = iDFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7638c.nextClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IDFragment f7640c;

        public b(IDFragment iDFragment) {
            this.f7640c = iDFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7640c.backClick();
        }
    }

    @UiThread
    public IDFragment_ViewBinding(IDFragment iDFragment, View view) {
        this.f7635b = iDFragment;
        iDFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        iDFragment.mRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler, "field 'mRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_next, "field 'mSubmitBtn' and method 'nextClick'");
        iDFragment.mSubmitBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.btn_next, "field 'mSubmitBtn'", AppCompatButton.class);
        this.f7636c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(iDFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7637d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(iDFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDFragment iDFragment = this.f7635b;
        if (iDFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7635b = null;
        iDFragment.mTitleTv = null;
        iDFragment.mRecyclerView = null;
        iDFragment.mSubmitBtn = null;
        this.f7636c.setOnClickListener(null);
        this.f7636c = null;
        this.f7637d.setOnClickListener(null);
        this.f7637d = null;
    }
}
