package com.chinavisionary.microtang.open.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class SwitchRoomFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SwitchRoomFragment f8026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8028d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SwitchRoomFragment f8029c;

        public a(SwitchRoomFragment switchRoomFragment) {
            this.f8029c = switchRoomFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8029c.customSortClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SwitchRoomFragment f8031c;

        public b(SwitchRoomFragment switchRoomFragment) {
            this.f8031c = switchRoomFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8031c.backClick(view);
        }
    }

    @UiThread
    public SwitchRoomFragment_ViewBinding(SwitchRoomFragment switchRoomFragment, View view) {
        this.f8026b = switchRoomFragment;
        switchRoomFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        switchRoomFragment.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        switchRoomFragment.mRoomRecyclerList = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_room_list, "field 'mRoomRecyclerList'", BaseRecyclerView.class);
        switchRoomFragment.mAppCompatButton = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_retry_load_page, "field 'mAppCompatButton'", AppCompatButton.class);
        switchRoomFragment.mTipMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_msg, "field 'mTipMsgTv'", TextView.class);
        switchRoomFragment.mTipRoomTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_room_list_title, "field 'mTipRoomTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_custom_sort, "field 'mCustomSortTv' and method 'customSortClick'");
        switchRoomFragment.mCustomSortTv = (TextView) d.castView(viewFindRequiredView, R.id.tv_custom_sort, "field 'mCustomSortTv'", TextView.class);
        this.f8027c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(switchRoomFragment));
        switchRoomFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8028d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(switchRoomFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SwitchRoomFragment switchRoomFragment = this.f8026b;
        if (switchRoomFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8026b = null;
        switchRoomFragment.mTitleTv = null;
        switchRoomFragment.mSplitLineTv = null;
        switchRoomFragment.mRoomRecyclerList = null;
        switchRoomFragment.mAppCompatButton = null;
        switchRoomFragment.mTipMsgTv = null;
        switchRoomFragment.mTipRoomTitleTv = null;
        switchRoomFragment.mCustomSortTv = null;
        switchRoomFragment.mSearchRoomEdt = null;
        this.f8027c.setOnClickListener(null);
        this.f8027c = null;
        this.f8028d.setOnClickListener(null);
        this.f8028d = null;
    }
}
