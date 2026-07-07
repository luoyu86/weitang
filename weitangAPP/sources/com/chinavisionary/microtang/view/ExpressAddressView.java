package com.chinavisionary.microtang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.ExpressVo;

/* JADX INFO: loaded from: classes2.dex */
public class ExpressAddressView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f8656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f8657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f8658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8659d;

    public ExpressAddressView(Context context) {
        super(context);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_express_address_layout, (ViewGroup) this, false);
        this.f8656a = (TextView) viewInflate.findViewById(R.id.tv_express_name);
        this.f8657b = (TextView) viewInflate.findViewById(R.id.tv_express_address);
        this.f8658c = (TextView) viewInflate.findViewById(R.id.tv_express_phone);
        addView(viewInflate);
    }

    public String getAddressKey() {
        return this.f8659d;
    }

    public void setupData(ExpressVo expressVo) {
        this.f8659d = expressVo.getAddressKey();
        this.f8656a.setText(x.getNotNullStr(expressVo.getPersonName(), ""));
        this.f8658c.setText(x.getNotNullStr(expressVo.getPhone(), ""));
        this.f8657b.setText(x.getNotNullStr(expressVo.getAddress(), ""));
    }

    public ExpressAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_express_address_layout, (ViewGroup) this, false);
        this.f8656a = (TextView) viewInflate.findViewById(R.id.tv_express_name);
        this.f8657b = (TextView) viewInflate.findViewById(R.id.tv_express_address);
        this.f8658c = (TextView) viewInflate.findViewById(R.id.tv_express_phone);
        addView(viewInflate);
    }

    public ExpressAddressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_express_address_layout, (ViewGroup) this, false);
        this.f8656a = (TextView) viewInflate.findViewById(R.id.tv_express_name);
        this.f8657b = (TextView) viewInflate.findViewById(R.id.tv_express_address);
        this.f8658c = (TextView) viewInflate.findViewById(R.id.tv_express_phone);
        addView(viewInflate);
    }
}
