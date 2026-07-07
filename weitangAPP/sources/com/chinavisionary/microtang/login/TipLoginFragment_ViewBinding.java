package com.chinavisionary.microtang.login;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class TipLoginFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TipLoginFragment f7339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7340c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TipLoginFragment f7341c;

        public a(TipLoginFragment tipLoginFragment) {
            this.f7341c = tipLoginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7341c.openLoginActivity();
        }
    }

    @UiThread
    public TipLoginFragment_ViewBinding(TipLoginFragment tipLoginFragment, View view) {
        this.f7339b = tipLoginFragment;
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_login, "method 'openLoginActivity'");
        this.f7340c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tipLoginFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f7339b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7339b = null;
        this.f7340c.setOnClickListener(null);
        this.f7340c = null;
    }
}
