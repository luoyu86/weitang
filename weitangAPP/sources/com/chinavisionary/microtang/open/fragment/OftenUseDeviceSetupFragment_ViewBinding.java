package com.chinavisionary.microtang.open.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class OftenUseDeviceSetupFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OftenUseDeviceSetupFragment f7997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7999d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OftenUseDeviceSetupFragment f8000c;

        public a(OftenUseDeviceSetupFragment oftenUseDeviceSetupFragment) {
            this.f8000c = oftenUseDeviceSetupFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8000c.saveUpdate(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OftenUseDeviceSetupFragment f8002c;

        public b(OftenUseDeviceSetupFragment oftenUseDeviceSetupFragment) {
            this.f8002c = oftenUseDeviceSetupFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8002c.backClick(view);
        }
    }

    @UiThread
    public OftenUseDeviceSetupFragment_ViewBinding(OftenUseDeviceSetupFragment oftenUseDeviceSetupFragment, View view) {
        this.f7997b = oftenUseDeviceSetupFragment;
        oftenUseDeviceSetupFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        oftenUseDeviceSetupFragment.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        oftenUseDeviceSetupFragment.mSearchRoomEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchRoomEdt'", EditText.class);
        oftenUseDeviceSetupFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_submit, "method 'saveUpdate'");
        this.f7998c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(oftenUseDeviceSetupFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7999d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(oftenUseDeviceSetupFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OftenUseDeviceSetupFragment oftenUseDeviceSetupFragment = this.f7997b;
        if (oftenUseDeviceSetupFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7997b = null;
        oftenUseDeviceSetupFragment.mTitleTv = null;
        oftenUseDeviceSetupFragment.mRightTv = null;
        oftenUseDeviceSetupFragment.mSearchRoomEdt = null;
        oftenUseDeviceSetupFragment.mBaseSwipeRefreshLayout = null;
        this.f7998c.setOnClickListener(null);
        this.f7998c = null;
        this.f7999d.setOnClickListener(null);
        this.f7999d = null;
    }
}
