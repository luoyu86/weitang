package com.chinavisionary.microtang;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.CoreRoundedImageView;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SplashActivity f6791b;

    @UiThread
    public SplashActivity_ViewBinding(SplashActivity splashActivity) {
        this(splashActivity, splashActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SplashActivity splashActivity = this.f6791b;
        if (splashActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6791b = null;
        splashActivity.mTimerTv = null;
        splashActivity.mSplashImg = null;
        splashActivity.mBottomLauncherImg = null;
    }

    @UiThread
    public SplashActivity_ViewBinding(SplashActivity splashActivity, View view) {
        this.f6791b = splashActivity;
        splashActivity.mTimerTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_timer, "field 'mTimerTv'", TextView.class);
        splashActivity.mSplashImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_launcher, "field 'mSplashImg'", CoreRoundedImageView.class);
        splashActivity.mBottomLauncherImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_bottom_launcher, "field 'mBottomLauncherImg'", ImageView.class);
    }
}
