package com.chinavisionary.microtang.prelook.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.nex3z.flowlayout.FlowLayout;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookCommentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreLookCommentFragment f8194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8196d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreLookCommentFragment f8197c;

        public a(PreLookCommentFragment preLookCommentFragment) {
            this.f8197c = preLookCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8197c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreLookCommentFragment f8199c;

        public b(PreLookCommentFragment preLookCommentFragment) {
            this.f8199c = preLookCommentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8199c.submitClick(view);
        }
    }

    @UiThread
    public PreLookCommentFragment_ViewBinding(PreLookCommentFragment preLookCommentFragment, View view) {
        this.f8194b = preLookCommentFragment;
        preLookCommentFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        preLookCommentFragment.mScoreLLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_score, "field 'mScoreLLayout'", LinearLayout.class);
        preLookCommentFragment.mCommentContentEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mCommentContentEdt'", AppCompatEditText.class);
        preLookCommentFragment.mFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_comment_tag, "field 'mFlowLayout'", FlowLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8195c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(preLookCommentFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_next, "method 'submitClick'");
        this.f8196d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(preLookCommentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreLookCommentFragment preLookCommentFragment = this.f8194b;
        if (preLookCommentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8194b = null;
        preLookCommentFragment.mTitleTv = null;
        preLookCommentFragment.mScoreLLayout = null;
        preLookCommentFragment.mCommentContentEdt = null;
        preLookCommentFragment.mFlowLayout = null;
        this.f8195c.setOnClickListener(null);
        this.f8195c = null;
        this.f8196d.setOnClickListener(null);
        this.f8196d = null;
    }
}
