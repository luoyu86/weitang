package com.chinavisionary.microtang.address;

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
public class AddressFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AddressFragment f6793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6794c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AddressFragment f6795c;

        public a(AddressFragment addressFragment) {
            this.f6795c = addressFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6795c.backClick();
        }
    }

    @UiThread
    public AddressFragment_ViewBinding(AddressFragment addressFragment, View view) {
        this.f6793b = addressFragment;
        addressFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        addressFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f6794c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addressFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddressFragment addressFragment = this.f6793b;
        if (addressFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6793b = null;
        addressFragment.mSwipeRefreshLayout = null;
        addressFragment.mTitleTv = null;
        this.f6794c.setOnClickListener(null);
        this.f6794c = null;
    }
}
