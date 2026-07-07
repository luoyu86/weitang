package com.chinavisionary.microtang.open.record;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomOpenLockRecordDetailsFragment f8038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8041e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomOpenLockRecordDetailsFragment f8042c;

        public a(RoomOpenLockRecordDetailsFragment roomOpenLockRecordDetailsFragment) {
            this.f8042c = roomOpenLockRecordDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8042c.doSearchClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomOpenLockRecordDetailsFragment f8044c;

        public b(RoomOpenLockRecordDetailsFragment roomOpenLockRecordDetailsFragment) {
            this.f8044c = roomOpenLockRecordDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8044c.doResetClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomOpenLockRecordDetailsFragment f8046c;

        public c(RoomOpenLockRecordDetailsFragment roomOpenLockRecordDetailsFragment) {
            this.f8046c = roomOpenLockRecordDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8046c.finishFragment(view);
        }
    }

    @UiThread
    public RoomOpenLockRecordDetailsFragment_ViewBinding(RoomOpenLockRecordDetailsFragment roomOpenLockRecordDetailsFragment, View view) {
        this.f8038b = roomOpenLockRecordDetailsFragment;
        roomOpenLockRecordDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        roomOpenLockRecordDetailsFragment.mStartDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_start_date, "field 'mStartDateTv'", TextView.class);
        roomOpenLockRecordDetailsFragment.mEndDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_end_date, "field 'mEndDateTv'", TextView.class);
        roomOpenLockRecordDetailsFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_record, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_search, "method 'doSearchClick'");
        this.f8039c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(roomOpenLockRecordDetailsFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_reset, "method 'doResetClick'");
        this.f8040d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(roomOpenLockRecordDetailsFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.tv_back, "method 'finishFragment'");
        this.f8041e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(roomOpenLockRecordDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RoomOpenLockRecordDetailsFragment roomOpenLockRecordDetailsFragment = this.f8038b;
        if (roomOpenLockRecordDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8038b = null;
        roomOpenLockRecordDetailsFragment.mTitleTv = null;
        roomOpenLockRecordDetailsFragment.mStartDateTv = null;
        roomOpenLockRecordDetailsFragment.mEndDateTv = null;
        roomOpenLockRecordDetailsFragment.mBaseSwipeRefreshLayout = null;
        this.f8039c.setOnClickListener(null);
        this.f8039c = null;
        this.f8040d.setOnClickListener(null);
        this.f8040d = null;
        this.f8041e.setOnClickListener(null);
        this.f8041e = null;
    }
}
