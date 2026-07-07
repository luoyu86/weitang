package com.chinavisionary.microtang.me.handler;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePwdHandle_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdatePwdHandle f7745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7749f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdHandle f7750c;

        public a(UpdatePwdHandle updatePwdHandle) {
            this.f7750c = updatePwdHandle;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7750c.openUpdatePwdFragment();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdHandle f7752c;

        public b(UpdatePwdHandle updatePwdHandle) {
            this.f7752c = updatePwdHandle;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7752c.showOldPwdClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdHandle f7754c;

        public c(UpdatePwdHandle updatePwdHandle) {
            this.f7754c = updatePwdHandle;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7754c.showNewPwdClickView(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdHandle f7756c;

        public d(UpdatePwdHandle updatePwdHandle) {
            this.f7756c = updatePwdHandle;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7756c.showNewAginPwdClickView(view);
        }
    }

    @UiThread
    public UpdatePwdHandle_ViewBinding(UpdatePwdHandle updatePwdHandle, View view) {
        this.f7745b = updatePwdHandle;
        updatePwdHandle.mPwdEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_pwd, "field 'mPwdEdt'", EditText.class);
        updatePwdHandle.mPwdAgainEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_again_pwd, "field 'mPwdAgainEdt'", EditText.class);
        updatePwdHandle.mPwdNewAgainEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_new_again_pwd, "field 'mPwdNewAgainEdt'", EditText.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.tv_forget_pwd, "field 'mForgetPwdTv' and method 'openUpdatePwdFragment'");
        updatePwdHandle.mForgetPwdTv = (TextView) b.c.d.castView(viewFindRequiredView, R.id.tv_forget_pwd, "field 'mForgetPwdTv'", TextView.class);
        this.f7746c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updatePwdHandle));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_show_pwd, "method 'showOldPwdClickView'");
        this.f7747d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(updatePwdHandle));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_show_again_pwd, "method 'showNewPwdClickView'");
        this.f7748e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(updatePwdHandle));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_show_new_again_pwd, "method 'showNewAginPwdClickView'");
        this.f7749f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(updatePwdHandle));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdatePwdHandle updatePwdHandle = this.f7745b;
        if (updatePwdHandle == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7745b = null;
        updatePwdHandle.mPwdEdt = null;
        updatePwdHandle.mPwdAgainEdt = null;
        updatePwdHandle.mPwdNewAgainEdt = null;
        updatePwdHandle.mForgetPwdTv = null;
        this.f7746c.setOnClickListener(null);
        this.f7746c = null;
        this.f7747d.setOnClickListener(null);
        this.f7747d = null;
        this.f7748e.setOnClickListener(null);
        this.f7748e = null;
        this.f7749f.setOnClickListener(null);
        this.f7749f = null;
    }
}
