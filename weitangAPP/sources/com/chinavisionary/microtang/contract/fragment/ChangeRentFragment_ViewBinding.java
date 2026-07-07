package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.BaseWebView;

/* JADX INFO: loaded from: classes.dex */
public class ChangeRentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ChangeRentFragment f7104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7109g;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChangeRentFragment f7110c;

        public a(ChangeRentFragment changeRentFragment) {
            this.f7110c = changeRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7110c.clickShowTimeView();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChangeRentFragment f7112c;

        public b(ChangeRentFragment changeRentFragment) {
            this.f7112c = changeRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7112c.clickKeepRentDate(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChangeRentFragment f7114c;

        public c(ChangeRentFragment changeRentFragment) {
            this.f7114c = changeRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7114c.clickHelp();
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChangeRentFragment f7116c;

        public d(ChangeRentFragment changeRentFragment) {
            this.f7116c = changeRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7116c.clickNewSignRentDate(view);
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChangeRentFragment f7118c;

        public e(ChangeRentFragment changeRentFragment) {
            this.f7118c = changeRentFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7118c.backClick(view);
        }
    }

    @UiThread
    public ChangeRentFragment_ViewBinding(ChangeRentFragment changeRentFragment, View view) {
        this.f7104b = changeRentFragment;
        changeRentFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        changeRentFragment.mBgView = b.c.d.findRequiredView(view, R.id.view_title_bg, "field 'mBgView'");
        changeRentFragment.mBaseWebView = (BaseWebView) b.c.d.findRequiredViewAsType(view, R.id.web_view_protocol, "field 'mBaseWebView'", BaseWebView.class);
        changeRentFragment.mAgreeCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_agree, "field 'mAgreeCb'", CheckBox.class);
        changeRentFragment.mRentBackTimeTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_rent_back_time_value, "field 'mRentBackTimeTv'", TextView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.tv_rent_back_time, "field 'mRentBackRoomTv' and method 'clickShowTimeView'");
        changeRentFragment.mRentBackRoomTv = (TextView) b.c.d.castView(viewFindRequiredView, R.id.tv_rent_back_time, "field 'mRentBackRoomTv'", TextView.class);
        this.f7105c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(changeRentFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.btn_keep_rent_date, "method 'clickKeepRentDate'");
        this.f7106d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(changeRentFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.img_info_tip, "method 'clickHelp'");
        this.f7107e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(changeRentFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.btn_new_rent, "method 'clickNewSignRentDate'");
        this.f7108f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(changeRentFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7109g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(changeRentFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangeRentFragment changeRentFragment = this.f7104b;
        if (changeRentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7104b = null;
        changeRentFragment.mTitleTv = null;
        changeRentFragment.mBgView = null;
        changeRentFragment.mBaseWebView = null;
        changeRentFragment.mAgreeCb = null;
        changeRentFragment.mRentBackTimeTv = null;
        changeRentFragment.mRentBackRoomTv = null;
        this.f7105c.setOnClickListener(null);
        this.f7105c = null;
        this.f7106d.setOnClickListener(null);
        this.f7106d = null;
        this.f7107e.setOnClickListener(null);
        this.f7107e = null;
        this.f7108f.setOnClickListener(null);
        this.f7108f = null;
        this.f7109g.setOnClickListener(null);
        this.f7109g = null;
    }
}
