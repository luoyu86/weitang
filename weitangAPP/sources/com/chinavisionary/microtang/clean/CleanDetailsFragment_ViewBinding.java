package com.chinavisionary.microtang.clean;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CleanDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CleanDetailsFragment f6923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6925d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CleanDetailsFragment f6926c;

        public a(CleanDetailsFragment cleanDetailsFragment) {
            this.f6926c = cleanDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6926c.subscribeClean(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CleanDetailsFragment f6928c;

        public b(CleanDetailsFragment cleanDetailsFragment) {
            this.f6928c = cleanDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6928c.backClick(view);
        }
    }

    @UiThread
    public CleanDetailsFragment_ViewBinding(CleanDetailsFragment cleanDetailsFragment, View view) {
        this.f6923b = cleanDetailsFragment;
        cleanDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cleanDetailsFragment.mTitleLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleLineTv'", TextView.class);
        cleanDetailsFragment.mTitleBgView = d.findRequiredView(view, R.id.view_title_bg, "field 'mTitleBgView'");
        cleanDetailsFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_clean_details, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_subscribe_clean, "method 'subscribeClean'");
        this.f6924c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cleanDetailsFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f6925d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(cleanDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CleanDetailsFragment cleanDetailsFragment = this.f6923b;
        if (cleanDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6923b = null;
        cleanDetailsFragment.mTitleTv = null;
        cleanDetailsFragment.mTitleLineTv = null;
        cleanDetailsFragment.mTitleBgView = null;
        cleanDetailsFragment.mBaseSwipeRefreshLayout = null;
        this.f6924c.setOnClickListener(null);
        this.f6924c = null;
        this.f6925d.setOnClickListener(null);
        this.f6925d = null;
    }
}
