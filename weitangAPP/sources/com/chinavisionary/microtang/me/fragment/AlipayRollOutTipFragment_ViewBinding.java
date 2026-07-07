package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.photo.photopicker.widget.TouchImageView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class AlipayRollOutTipFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlipayRollOutTipFragment f7572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7573c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AlipayRollOutTipFragment f7574c;

        public a(AlipayRollOutTipFragment alipayRollOutTipFragment) {
            this.f7574c = alipayRollOutTipFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7574c.finishFragment(view);
        }
    }

    @UiThread
    public AlipayRollOutTipFragment_ViewBinding(AlipayRollOutTipFragment alipayRollOutTipFragment, View view) {
        this.f7572b = alipayRollOutTipFragment;
        alipayRollOutTipFragment.mTouchImageView = (TouchImageView) d.findRequiredViewAsType(view, R.id.img_tip, "field 'mTouchImageView'", TouchImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.view_bg, "method 'finishFragment'");
        this.f7573c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(alipayRollOutTipFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlipayRollOutTipFragment alipayRollOutTipFragment = this.f7572b;
        if (alipayRollOutTipFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7572b = null;
        alipayRollOutTipFragment.mTouchImageView = null;
        this.f7573c.setOnClickListener(null);
        this.f7573c = null;
    }
}
