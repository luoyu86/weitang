package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePhoneOrPwdFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdatePhoneOrPwdFragment f7703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7706e;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePhoneOrPwdFragment f7707c;

        public a(UpdatePhoneOrPwdFragment updatePhoneOrPwdFragment) {
            this.f7707c = updatePhoneOrPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7707c.confirmUpdate();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePhoneOrPwdFragment f7709c;

        public b(UpdatePhoneOrPwdFragment updatePhoneOrPwdFragment) {
            this.f7709c = updatePhoneOrPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7709c.sendSmsCodeClick();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePhoneOrPwdFragment f7711c;

        public c(UpdatePhoneOrPwdFragment updatePhoneOrPwdFragment) {
            this.f7711c = updatePhoneOrPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7711c.backClick(view);
        }
    }

    @UiThread
    public UpdatePhoneOrPwdFragment_ViewBinding(UpdatePhoneOrPwdFragment updatePhoneOrPwdFragment, View view) {
        this.f7703b = updatePhoneOrPwdFragment;
        updatePhoneOrPwdFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_confirm, "field 'mConfirmBtn' and method 'confirmUpdate'");
        updatePhoneOrPwdFragment.mConfirmBtn = (AppCompatButton) d.castView(viewFindRequiredView, R.id.tv_confirm, "field 'mConfirmBtn'", AppCompatButton.class);
        this.f7704c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updatePhoneOrPwdFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_send_sms, "method 'sendSmsCodeClick'");
        this.f7705d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(updatePhoneOrPwdFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7706e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(updatePhoneOrPwdFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdatePhoneOrPwdFragment updatePhoneOrPwdFragment = this.f7703b;
        if (updatePhoneOrPwdFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7703b = null;
        updatePhoneOrPwdFragment.mTitleTv = null;
        updatePhoneOrPwdFragment.mConfirmBtn = null;
        this.f7704c.setOnClickListener(null);
        this.f7704c = null;
        this.f7705d.setOnClickListener(null);
        this.f7705d = null;
        this.f7706e.setOnClickListener(null);
        this.f7706e = null;
    }
}
