package com.chinavisionary.microtang.alert;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class SharedAlertFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedAlertFragment f6813b;

    @UiThread
    public SharedAlertFragment_ViewBinding(SharedAlertFragment sharedAlertFragment, View view) {
        this.f6813b = sharedAlertFragment;
        sharedAlertFragment.mSharedWxImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_wx, "field 'mSharedWxImg'", ImageView.class);
        sharedAlertFragment.mSharedWxTimelineImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_wx_timeline, "field 'mSharedWxTimelineImg'", ImageView.class);
        sharedAlertFragment.mCancelSharedTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_alert_cancel, "field 'mCancelSharedTv'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SharedAlertFragment sharedAlertFragment = this.f6813b;
        if (sharedAlertFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6813b = null;
        sharedAlertFragment.mSharedWxImg = null;
        sharedAlertFragment.mSharedWxTimelineImg = null;
        sharedAlertFragment.mCancelSharedTv = null;
    }
}
