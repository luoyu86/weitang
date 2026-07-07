package com.chinavisionary.microtang.repair.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.nex3z.flowlayout.FlowLayout;

/* JADX INFO: loaded from: classes2.dex */
public class AddRepairInfoFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AddRepairInfoFragment f8233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8235d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AddRepairInfoFragment f8236c;

        public a(AddRepairInfoFragment addRepairInfoFragment) {
            this.f8236c = addRepairInfoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8236c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AddRepairInfoFragment f8238c;

        public b(AddRepairInfoFragment addRepairInfoFragment) {
            this.f8238c = addRepairInfoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8238c.nextClick(view);
        }
    }

    @UiThread
    public AddRepairInfoFragment_ViewBinding(AddRepairInfoFragment addRepairInfoFragment, View view) {
        this.f8233b = addRepairInfoFragment;
        addRepairInfoFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        addRepairInfoFragment.mProductNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_product_name, "field 'mProductNameTv'", TextView.class);
        addRepairInfoFragment.mInputInfoEdt = (AppCompatTextView) d.findRequiredViewAsType(view, R.id.edt_input_info, "field 'mInputInfoEdt'", AppCompatTextView.class);
        addRepairInfoFragment.mRepairPlaceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_repair_place, "field 'mRepairPlaceTv'", TextView.class);
        addRepairInfoFragment.mFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_place, "field 'mFlowLayout'", FlowLayout.class);
        addRepairInfoFragment.mFlowRepairInfoLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_repair_info, "field 'mFlowRepairInfoLayout'", FlowLayout.class);
        addRepairInfoFragment.mRemarkEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_remark, "field 'mRemarkEdt'", AppCompatEditText.class);
        addRepairInfoFragment.mAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_address_value, "field 'mAddressTv'", TextView.class);
        addRepairInfoFragment.mPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_contact_mode_value, "field 'mPhoneTv'", TextView.class);
        addRepairInfoFragment.mServiceTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_service_time, "field 'mServiceTimeTv'", TextView.class);
        addRepairInfoFragment.mOpenDoorTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_open_door_time, "field 'mOpenDoorTimeTv'", TextView.class);
        addRepairInfoFragment.mAuthCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_auth, "field 'mAuthCb'", CheckBox.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8234c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addRepairInfoFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_next, "method 'nextClick'");
        this.f8235d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addRepairInfoFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddRepairInfoFragment addRepairInfoFragment = this.f8233b;
        if (addRepairInfoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8233b = null;
        addRepairInfoFragment.mTitleTv = null;
        addRepairInfoFragment.mProductNameTv = null;
        addRepairInfoFragment.mInputInfoEdt = null;
        addRepairInfoFragment.mRepairPlaceTv = null;
        addRepairInfoFragment.mFlowLayout = null;
        addRepairInfoFragment.mFlowRepairInfoLayout = null;
        addRepairInfoFragment.mRemarkEdt = null;
        addRepairInfoFragment.mAddressTv = null;
        addRepairInfoFragment.mPhoneTv = null;
        addRepairInfoFragment.mServiceTimeTv = null;
        addRepairInfoFragment.mOpenDoorTimeTv = null;
        addRepairInfoFragment.mAuthCb = null;
        this.f8234c.setOnClickListener(null);
        this.f8234c = null;
        this.f8235d.setOnClickListener(null);
        this.f8235d = null;
    }
}
