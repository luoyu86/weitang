package com.chinavisionary.microtang.repair.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAuthOpenDoorTimeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdateAuthOpenDoorTimeFragment f8269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f8273f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateAuthOpenDoorTimeFragment f8274c;

        public a(UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment) {
            this.f8274c = updateAuthOpenDoorTimeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8274c.openDoorStartTimeClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateAuthOpenDoorTimeFragment f8276c;

        public b(UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment) {
            this.f8276c = updateAuthOpenDoorTimeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8276c.openDoorEndTimeClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateAuthOpenDoorTimeFragment f8278c;

        public c(UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment) {
            this.f8278c = updateAuthOpenDoorTimeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8278c.backClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateAuthOpenDoorTimeFragment f8280c;

        public d(UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment) {
            this.f8280c = updateAuthOpenDoorTimeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8280c.saveClick(view);
        }
    }

    @UiThread
    public UpdateAuthOpenDoorTimeFragment_ViewBinding(UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment, View view) {
        this.f8269b = updateAuthOpenDoorTimeFragment;
        updateAuthOpenDoorTimeFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        updateAuthOpenDoorTimeFragment.mAuthCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_auth, "field 'mAuthCb'", CheckBox.class);
        updateAuthOpenDoorTimeFragment.mOpenDoorStartTimeTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_open_door_start_time_value, "field 'mOpenDoorStartTimeTv'", TextView.class);
        updateAuthOpenDoorTimeFragment.mOpenDoorEndTimeTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_open_door_end_time_value, "field 'mOpenDoorEndTimeTv'", TextView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.tv_open_door_start_time, "field 'mOpenDoorStartTimeTitleTv' and method 'openDoorStartTimeClick'");
        updateAuthOpenDoorTimeFragment.mOpenDoorStartTimeTitleTv = (TextView) b.c.d.castView(viewFindRequiredView, R.id.tv_open_door_start_time, "field 'mOpenDoorStartTimeTitleTv'", TextView.class);
        this.f8270c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updateAuthOpenDoorTimeFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_open_door_end_time, "field 'mOpenDoorEndTimeTitleTv' and method 'openDoorEndTimeClick'");
        updateAuthOpenDoorTimeFragment.mOpenDoorEndTimeTitleTv = (TextView) b.c.d.castView(viewFindRequiredView2, R.id.tv_open_door_end_time, "field 'mOpenDoorEndTimeTitleTv'", TextView.class);
        this.f8271d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(updateAuthOpenDoorTimeFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8272e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(updateAuthOpenDoorTimeFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.btn_save, "method 'saveClick'");
        this.f8273f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(updateAuthOpenDoorTimeFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment = this.f8269b;
        if (updateAuthOpenDoorTimeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8269b = null;
        updateAuthOpenDoorTimeFragment.mTitleTv = null;
        updateAuthOpenDoorTimeFragment.mAuthCb = null;
        updateAuthOpenDoorTimeFragment.mOpenDoorStartTimeTv = null;
        updateAuthOpenDoorTimeFragment.mOpenDoorEndTimeTv = null;
        updateAuthOpenDoorTimeFragment.mOpenDoorStartTimeTitleTv = null;
        updateAuthOpenDoorTimeFragment.mOpenDoorEndTimeTitleTv = null;
        this.f8270c.setOnClickListener(null);
        this.f8270c = null;
        this.f8271d.setOnClickListener(null);
        this.f8271d = null;
        this.f8272e.setOnClickListener(null);
        this.f8272e = null;
        this.f8273f.setOnClickListener(null);
        this.f8273f = null;
    }
}
