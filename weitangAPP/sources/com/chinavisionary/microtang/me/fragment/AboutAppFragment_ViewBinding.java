package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class AboutAppFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AboutAppFragment f7556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7558d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AboutAppFragment f7559c;

        public a(AboutAppFragment aboutAppFragment) {
            this.f7559c = aboutAppFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7559c.clickBack();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AboutAppFragment f7561c;

        public b(AboutAppFragment aboutAppFragment) {
            this.f7561c = aboutAppFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7561c.clickOpenAppIcp();
        }
    }

    @UiThread
    public AboutAppFragment_ViewBinding(AboutAppFragment aboutAppFragment, View view) {
        this.f7556b = aboutAppFragment;
        aboutAppFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        aboutAppFragment.mAppVersionTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_app_version, "field 'mAppVersionTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7557c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aboutAppFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_app_icp, "method 'clickOpenAppIcp'");
        this.f7558d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aboutAppFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutAppFragment aboutAppFragment = this.f7556b;
        if (aboutAppFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7556b = null;
        aboutAppFragment.mTitleTv = null;
        aboutAppFragment.mAppVersionTv = null;
        this.f7557c.setOnClickListener(null);
        this.f7557c = null;
        this.f7558d.setOnClickListener(null);
        this.f7558d = null;
    }
}
