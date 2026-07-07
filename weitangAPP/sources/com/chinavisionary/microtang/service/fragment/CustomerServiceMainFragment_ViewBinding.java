package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceMainFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomerServiceMainFragment f8440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f8444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f8445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f8446h;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceMainFragment f8447c;

        public a(CustomerServiceMainFragment customerServiceMainFragment) {
            this.f8447c = customerServiceMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8447c.viewClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceMainFragment f8449c;

        public b(CustomerServiceMainFragment customerServiceMainFragment) {
            this.f8449c = customerServiceMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8449c.viewClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceMainFragment f8451c;

        public c(CustomerServiceMainFragment customerServiceMainFragment) {
            this.f8451c = customerServiceMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8451c.viewClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceMainFragment f8453c;

        public d(CustomerServiceMainFragment customerServiceMainFragment) {
            this.f8453c = customerServiceMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8453c.submitReason();
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceMainFragment f8455c;

        public e(CustomerServiceMainFragment customerServiceMainFragment) {
            this.f8455c = customerServiceMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8455c.submitConsult();
        }
    }

    public class f extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceMainFragment f8457c;

        public f(CustomerServiceMainFragment customerServiceMainFragment) {
            this.f8457c = customerServiceMainFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8457c.backClick();
        }
    }

    @UiThread
    public CustomerServiceMainFragment_ViewBinding(CustomerServiceMainFragment customerServiceMainFragment, View view) {
        this.f8440b = customerServiceMainFragment;
        customerServiceMainFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        customerServiceMainFragment.mLineTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mLineTv'", TextView.class);
        customerServiceMainFragment.mBgView = b.c.d.findRequiredView(view, R.id.view_title_bg, "field 'mBgView'");
        customerServiceMainFragment.mTabLayout = (TabLayout) b.c.d.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        customerServiceMainFragment.mViewPager = (ViewPager) b.c.d.findRequiredViewAsType(view, R.id.view_page_reason, "field 'mViewPager'", ViewPager.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_cat_me_reason, "method 'viewClick'");
        this.f8441c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(customerServiceMainFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.img_btn_me_reason, "method 'viewClick'");
        this.f8442d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(customerServiceMainFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.img_btn_me_proposal, "method 'viewClick'");
        this.f8443e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(customerServiceMainFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.btn_submit_reason, "method 'submitReason'");
        this.f8444f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(customerServiceMainFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.btn_submit_consult, "method 'submitConsult'");
        this.f8445g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(customerServiceMainFragment));
        View viewFindRequiredView6 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8446h = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(customerServiceMainFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CustomerServiceMainFragment customerServiceMainFragment = this.f8440b;
        if (customerServiceMainFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8440b = null;
        customerServiceMainFragment.mTitleTv = null;
        customerServiceMainFragment.mLineTv = null;
        customerServiceMainFragment.mBgView = null;
        customerServiceMainFragment.mTabLayout = null;
        customerServiceMainFragment.mViewPager = null;
        this.f8441c.setOnClickListener(null);
        this.f8441c = null;
        this.f8442d.setOnClickListener(null);
        this.f8442d = null;
        this.f8443e.setOnClickListener(null);
        this.f8443e = null;
        this.f8444f.setOnClickListener(null);
        this.f8444f = null;
        this.f8445g.setOnClickListener(null);
        this.f8445g = null;
        this.f8446h.setOnClickListener(null);
        this.f8446h = null;
    }
}
