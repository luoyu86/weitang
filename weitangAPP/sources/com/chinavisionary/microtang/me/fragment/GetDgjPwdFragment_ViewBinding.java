package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class GetDgjPwdFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GetDgjPwdFragment f7623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7626e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GetDgjPwdFragment f7627c;

        public a(GetDgjPwdFragment getDgjPwdFragment) {
            this.f7627c = getDgjPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7627c.copyPwd();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GetDgjPwdFragment f7629c;

        public b(GetDgjPwdFragment getDgjPwdFragment) {
            this.f7629c = getDgjPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7629c.getDgjPw();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GetDgjPwdFragment f7631c;

        public c(GetDgjPwdFragment getDgjPwdFragment) {
            this.f7631c = getDgjPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7631c.backClick();
        }
    }

    @UiThread
    public GetDgjPwdFragment_ViewBinding(GetDgjPwdFragment getDgjPwdFragment, View view) {
        this.f7623b = getDgjPwdFragment;
        getDgjPwdFragment.mSnEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_sn, "field 'mSnEdt'", EditText.class);
        getDgjPwdFragment.mPwdContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mPwdContentTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_copy_pwd, "method 'copyPwd'");
        this.f7624c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(getDgjPwdFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_get_pwd, "method 'getDgjPw'");
        this.f7625d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(getDgjPwdFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7626e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(getDgjPwdFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GetDgjPwdFragment getDgjPwdFragment = this.f7623b;
        if (getDgjPwdFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7623b = null;
        getDgjPwdFragment.mSnEdt = null;
        getDgjPwdFragment.mPwdContentTv = null;
        this.f7624c.setOnClickListener(null);
        this.f7624c = null;
        this.f7625d.setOnClickListener(null);
        this.f7625d = null;
        this.f7626e.setOnClickListener(null);
        this.f7626e = null;
    }
}
