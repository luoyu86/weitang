package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class EditMeNewFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditMeNewFragment f7604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7606d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EditMeNewFragment f7607c;

        public a(EditMeNewFragment editMeNewFragment) {
            this.f7607c = editMeNewFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7607c.saveUpdateInfoClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EditMeNewFragment f7609c;

        public b(EditMeNewFragment editMeNewFragment) {
            this.f7609c = editMeNewFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7609c.backClick(view);
        }
    }

    @UiThread
    public EditMeNewFragment_ViewBinding(EditMeNewFragment editMeNewFragment, View view) {
        this.f7604b = editMeNewFragment;
        editMeNewFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_title_right, "field 'mTitleRightTv' and method 'saveUpdateInfoClick'");
        editMeNewFragment.mTitleRightTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_title_right, "field 'mTitleRightTv'", TextView.class);
        this.f7605c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(editMeNewFragment));
        editMeNewFragment.mTitleSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleSplitLineTv'", TextView.class);
        editMeNewFragment.mExitBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mExitBtn'", AppCompatButton.class);
        editMeNewFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7606d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(editMeNewFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditMeNewFragment editMeNewFragment = this.f7604b;
        if (editMeNewFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7604b = null;
        editMeNewFragment.mTitleTv = null;
        editMeNewFragment.mTitleRightTv = null;
        editMeNewFragment.mTitleSplitLineTv = null;
        editMeNewFragment.mExitBtn = null;
        editMeNewFragment.mSwipeRefreshLayout = null;
        this.f7605c.setOnClickListener(null);
        this.f7605c = null;
        this.f7606d.setOnClickListener(null);
        this.f7606d = null;
    }
}
