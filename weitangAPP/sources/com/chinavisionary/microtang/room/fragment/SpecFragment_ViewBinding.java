package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.view.SpecView;
import com.nex3z.flowlayout.FlowLayout;

/* JADX INFO: loaded from: classes2.dex */
public class SpecFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpecFragment f8375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8377d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SpecFragment f8378c;

        public a(SpecFragment specFragment) {
            this.f8378c = specFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8378c.closeFragment(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SpecFragment f8380c;

        public b(SpecFragment specFragment) {
            this.f8380c = specFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8380c.closeFragment(view);
        }
    }

    @UiThread
    public SpecFragment_ViewBinding(SpecFragment specFragment, View view) {
        this.f8375b = specFragment;
        specFragment.mBgView = d.findRequiredView(view, R.id.view_bg, "field 'mBgView'");
        specFragment.mSpecCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_product_cover, "field 'mSpecCoverImg'", CoreRoundedImageView.class);
        specFragment.mSpecPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_price, "field 'mSpecPriceTv'", TextView.class);
        specFragment.mSelectSpecNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_select_spec_name, "field 'mSelectSpecNameTv'", TextView.class);
        specFragment.mSurplusNumberTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_surplus_number, "field 'mSurplusNumberTv'", TextView.class);
        specFragment.mLimitNumberTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_buy_number_limit_title, "field 'mLimitNumberTv'", TextView.class);
        specFragment.mSpecLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_spec, "field 'mSpecLayout'", FlowLayout.class);
        specFragment.mSpecView = (SpecView) d.findRequiredViewAsType(view, R.id.spec_add_reduce_layout, "field 'mSpecView'", SpecView.class);
        specFragment.mNextBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_next, "field 'mNextBtn'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.img_close, "method 'closeFragment'");
        this.f8376c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(specFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.view_transparent_bg, "method 'closeFragment'");
        this.f8377d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(specFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SpecFragment specFragment = this.f8375b;
        if (specFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8375b = null;
        specFragment.mBgView = null;
        specFragment.mSpecCoverImg = null;
        specFragment.mSpecPriceTv = null;
        specFragment.mSelectSpecNameTv = null;
        specFragment.mSurplusNumberTv = null;
        specFragment.mLimitNumberTv = null;
        specFragment.mSpecLayout = null;
        specFragment.mSpecView = null;
        specFragment.mNextBtn = null;
        this.f8376c.setOnClickListener(null);
        this.f8376c = null;
        this.f8377d.setOnClickListener(null);
        this.f8377d = null;
    }
}
