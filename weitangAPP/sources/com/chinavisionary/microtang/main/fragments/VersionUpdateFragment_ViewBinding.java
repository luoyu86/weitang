package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class VersionUpdateFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VersionUpdateFragment f7476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7479e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VersionUpdateFragment f7480c;

        public a(VersionUpdateFragment versionUpdateFragment) {
            this.f7480c = versionUpdateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7480c.cancelView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VersionUpdateFragment f7482c;

        public b(VersionUpdateFragment versionUpdateFragment) {
            this.f7482c = versionUpdateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7482c.clickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VersionUpdateFragment f7484c;

        public c(VersionUpdateFragment versionUpdateFragment) {
            this.f7484c = versionUpdateFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7484c.confirmView(view);
        }
    }

    @UiThread
    public VersionUpdateFragment_ViewBinding(VersionUpdateFragment versionUpdateFragment, View view) {
        this.f7476b = versionUpdateFragment;
        versionUpdateFragment.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_alert_content, "field 'mContentTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_alert_cancel, "field 'mCancelBtn' and method 'cancelView'");
        versionUpdateFragment.mCancelBtn = (Button) d.castView(viewFindRequiredView, R.id.btn_alert_cancel, "field 'mCancelBtn'", Button.class);
        this.f7477c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(versionUpdateFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.view_bg, "method 'clickView'");
        this.f7478d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(versionUpdateFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.btn_alert_confirm, "method 'confirmView'");
        this.f7479e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(versionUpdateFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VersionUpdateFragment versionUpdateFragment = this.f7476b;
        if (versionUpdateFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7476b = null;
        versionUpdateFragment.mContentTv = null;
        versionUpdateFragment.mCancelBtn = null;
        this.f7477c.setOnClickListener(null);
        this.f7477c = null;
        this.f7478d.setOnClickListener(null);
        this.f7478d = null;
        this.f7479e.setOnClickListener(null);
        this.f7479e = null;
    }
}
