package com.chinavisionary.microtang.open.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class OpenRoomListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpenRoomListFragment f8011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f8015f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenRoomListFragment f8016c;

        public a(OpenRoomListFragment openRoomListFragment) {
            this.f8016c = openRoomListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8016c.customSortClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenRoomListFragment f8018c;

        public b(OpenRoomListFragment openRoomListFragment) {
            this.f8018c = openRoomListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8018c.backClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenRoomListFragment f8020c;

        public c(OpenRoomListFragment openRoomListFragment) {
            this.f8020c = openRoomListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8020c.clickBack();
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenRoomListFragment f8022c;

        public d(OpenRoomListFragment openRoomListFragment) {
            this.f8022c = openRoomListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8022c.clickEditOftenUse();
        }
    }

    @UiThread
    public OpenRoomListFragment_ViewBinding(OpenRoomListFragment openRoomListFragment, View view) {
        this.f8011b = openRoomListFragment;
        openRoomListFragment.mRoomRecyclerList = (BaseRecyclerView) b.c.d.findRequiredViewAsType(view, R.id.recycler_room_list, "field 'mRoomRecyclerList'", BaseRecyclerView.class);
        openRoomListFragment.mOftenUseRoomRecyclerList = (BaseRecyclerView) b.c.d.findRequiredViewAsType(view, R.id.recycler_often_use, "field 'mOftenUseRoomRecyclerList'", BaseRecyclerView.class);
        openRoomListFragment.mAppCompatButton = (AppCompatButton) b.c.d.findRequiredViewAsType(view, R.id.btn_retry_load_page, "field 'mAppCompatButton'", AppCompatButton.class);
        openRoomListFragment.mTipMsgTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_tip_msg, "field 'mTipMsgTv'", TextView.class);
        openRoomListFragment.mTipRoomTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_tip_room_list_title, "field 'mTipRoomTitleTv'", TextView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.tv_custom_sort, "field 'mCustomSortTv' and method 'customSortClick'");
        openRoomListFragment.mCustomSortTv = (TextView) b.c.d.castView(viewFindRequiredView, R.id.tv_custom_sort, "field 'mCustomSortTv'", TextView.class);
        this.f8012c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(openRoomListFragment));
        openRoomListFragment.mSearchRoomEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.view_bg, "method 'backClick'");
        this.f8013d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(openRoomListFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.view_bg_bottom, "method 'clickBack'");
        this.f8014e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(openRoomListFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_device_often_use_edit, "method 'clickEditOftenUse'");
        this.f8015f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(openRoomListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OpenRoomListFragment openRoomListFragment = this.f8011b;
        if (openRoomListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8011b = null;
        openRoomListFragment.mRoomRecyclerList = null;
        openRoomListFragment.mOftenUseRoomRecyclerList = null;
        openRoomListFragment.mAppCompatButton = null;
        openRoomListFragment.mTipMsgTv = null;
        openRoomListFragment.mTipRoomTitleTv = null;
        openRoomListFragment.mCustomSortTv = null;
        openRoomListFragment.mSearchRoomEdt = null;
        this.f8012c.setOnClickListener(null);
        this.f8012c = null;
        this.f8013d.setOnClickListener(null);
        this.f8013d = null;
        this.f8014e.setOnClickListener(null);
        this.f8014e = null;
        this.f8015f.setOnClickListener(null);
        this.f8015f = null;
    }
}
