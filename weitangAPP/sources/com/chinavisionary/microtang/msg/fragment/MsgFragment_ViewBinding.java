package com.chinavisionary.microtang.msg.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MsgFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MsgFragment f7954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7955c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MsgFragment f7956c;

        public a(MsgFragment msgFragment) {
            this.f7956c = msgFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7956c.backClick(view);
        }
    }

    @UiThread
    public MsgFragment_ViewBinding(MsgFragment msgFragment, View view) {
        this.f7954b = msgFragment;
        msgFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        msgFragment.mReadAllTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mReadAllTv'", TextView.class);
        msgFragment.mMsgSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_msg, "field 'mMsgSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        msgFragment.mBadgeValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_value, "field 'mBadgeValueTv'", TextView.class);
        msgFragment.mBadgePaintTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_paint, "field 'mBadgePaintTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7955c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(msgFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MsgFragment msgFragment = this.f7954b;
        if (msgFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7954b = null;
        msgFragment.mTitleTv = null;
        msgFragment.mReadAllTv = null;
        msgFragment.mMsgSwipeRefreshLayout = null;
        msgFragment.mBadgeValueTv = null;
        msgFragment.mBadgePaintTv = null;
        this.f7955c.setOnClickListener(null);
        this.f7955c = null;
    }
}
