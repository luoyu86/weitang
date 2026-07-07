package com.chinavisionary.microtang.hydropower;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RechargeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RechargeFragment f7217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7222g;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RechargeFragment f7223c;

        public a(RechargeFragment rechargeFragment) {
            this.f7223c = rechargeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7223c.confirmPayView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RechargeFragment f7225c;

        public b(RechargeFragment rechargeFragment) {
            this.f7225c = rechargeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7225c.touchOutside(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RechargeFragment f7227c;

        public c(RechargeFragment rechargeFragment) {
            this.f7227c = rechargeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7227c.alipayClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RechargeFragment f7229c;

        public d(RechargeFragment rechargeFragment) {
            this.f7229c = rechargeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7229c.wxPayClick(view);
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RechargeFragment f7231c;

        public e(RechargeFragment rechargeFragment) {
            this.f7231c = rechargeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7231c.backClick(view);
        }
    }

    @UiThread
    public RechargeFragment_ViewBinding(RechargeFragment rechargeFragment, View view) {
        this.f7217b = rechargeFragment;
        rechargeFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        rechargeFragment.mPayPriceTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mPayPriceTv'", TextView.class);
        rechargeFragment.mRechargeRv = (BaseRecyclerView) b.c.d.findRequiredViewAsType(view, R.id.recycler_recharge, "field 'mRechargeRv'", BaseRecyclerView.class);
        rechargeFragment.mPayCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_pay, "field 'mPayCb'", CheckBox.class);
        rechargeFragment.mWxPayCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_wx_pay, "field 'mWxPayCb'", CheckBox.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_pay, "method 'confirmPayView'");
        this.f7218c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(rechargeFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.view_bg, "method 'touchOutside'");
        this.f7219d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(rechargeFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_item, "method 'alipayClick'");
        this.f7220e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(rechargeFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_wx_item, "method 'wxPayClick'");
        this.f7221f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(rechargeFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.tv_bg, "method 'backClick'");
        this.f7222g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(rechargeFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RechargeFragment rechargeFragment = this.f7217b;
        if (rechargeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7217b = null;
        rechargeFragment.mTitleTv = null;
        rechargeFragment.mPayPriceTv = null;
        rechargeFragment.mRechargeRv = null;
        rechargeFragment.mPayCb = null;
        rechargeFragment.mWxPayCb = null;
        this.f7218c.setOnClickListener(null);
        this.f7218c = null;
        this.f7219d.setOnClickListener(null);
        this.f7219d = null;
        this.f7220e.setOnClickListener(null);
        this.f7220e = null;
        this.f7221f.setOnClickListener(null);
        this.f7221f = null;
        this.f7222g.setOnClickListener(null);
        this.f7222g = null;
    }
}
