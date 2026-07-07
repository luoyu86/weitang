package com.chinavisionary.microtang.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.vo.SelfAddressVo;

/* JADX INFO: loaded from: classes2.dex */
public class SelfAddressView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomTextView f8675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomTextView f8676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CustomTextView f8677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatCheckBox f8678d;

    public SelfAddressView(Context context) {
        super(context);
    }

    public final void a() {
        this.f8675a = (CustomTextView) findViewById(R.id.tv_self_phone);
        this.f8677c = (CustomTextView) findViewById(R.id.tv_self_time);
        this.f8676b = (CustomTextView) findViewById(R.id.tv_self_address);
        this.f8678d = (AppCompatCheckBox) findViewById(R.id.cb_agree_protocol);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public void setupSelfAddressVo(SelfAddressVo selfAddressVo) {
        if (selfAddressVo != null) {
            this.f8675a.setText(x.getString(R.string.placeholder_self_phone, selfAddressVo.getPhone()));
            this.f8677c.setText(x.getString(R.string.placeholder_self_time, z.getTime(Long.valueOf(selfAddressVo.getStartTime()), z.l)));
            this.f8676b.setText(selfAddressVo.getAddress());
            this.f8678d.setChecked(selfAddressVo.isAgreeProtocol());
        }
    }

    public SelfAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelfAddressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
