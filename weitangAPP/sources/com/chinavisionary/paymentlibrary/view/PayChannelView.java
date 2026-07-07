package com.chinavisionary.paymentlibrary.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.e.a.d.x;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.PayChannelVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PayChannelView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<CheckBox> f8774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f8775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f8776d;

    public PayChannelView(Context context) {
        super(context);
        this.f8773a = -1;
        this.f8776d = new View.OnClickListener() { // from class: c.e.d.d0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2302a.d(view);
            }
        };
        b();
    }

    public final View a(PayChannelVo payChannelVo, int i2) {
        boolean zIsAddClickListener = payChannelVo.isAddClickListener();
        View viewInflate = this.f8775c.inflate(R.layout.payment_lib_item_pay_channel_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_pay);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_account_surplus);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.cb_pay);
        checkBox.setTag(Integer.valueOf(i2));
        checkBox.setTag(checkBox.getId(), Integer.valueOf(payChannelVo.getPayType()));
        checkBox.setChecked(payChannelVo.isCheck());
        checkBox.setVisibility(zIsAddClickListener ? 0 : 8);
        if (payChannelVo.isCheck()) {
            this.f8773a = payChannelVo.getPayType();
        }
        if (zIsAddClickListener) {
            checkBox.setOnClickListener(this.f8776d);
            viewInflate.setTag(Integer.valueOf(i2));
            viewInflate.setOnClickListener(this.f8776d);
        } else {
            viewInflate.setBackgroundColor(getResources().getColor(R.color.color_bg));
            Resources resources = getResources();
            int i3 = R.color.core_lib_colore757575;
            textView.setTextColor(resources.getColor(i3));
            textView2.setTextColor(getResources().getColor(i3));
        }
        if (payChannelVo.getSurplus() != null) {
            textView2.setText(x.appendStringToResId(zIsAddClickListener ? R.string.payment_lib_placeholder_account_surplus : R.string.payment_lib_placeholder_surplus_lack_account_surplus, x.bigDecimalToString(payChannelVo.getSurplus())));
        }
        textView.setText(x.getNotNullStr(payChannelVo.getTitle(), ""));
        textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(payChannelVo.getDrawableId()), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f8774b.add(checkBox);
        return viewInflate;
    }

    public final void b() {
        setOrientation(1);
        this.f8774b = new ArrayList();
        this.f8775c = LayoutInflater.from(getContext());
    }

    public final void d(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        int size = this.f8774b.size();
        int i2 = 0;
        while (i2 < size) {
            CheckBox checkBox = this.f8774b.get(i2);
            boolean z = i2 == iIntValue;
            if (z) {
                this.f8773a = ((Integer) checkBox.getTag(checkBox.getId())).intValue();
            }
            this.f8774b.get(i2).setChecked(z);
            i2++;
        }
    }

    public int getSelectPayType() {
        return this.f8773a;
    }

    public void setupPayChannelList(@NonNull List<PayChannelVo> list) {
        removeAllViews();
        this.f8774b.clear();
        this.f8773a = -1;
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            PayChannelVo payChannelVo = list.get(i2);
            if (payChannelVo != null) {
                addView(a(payChannelVo, i2));
            }
        }
    }

    public PayChannelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8773a = -1;
        this.f8776d = new View.OnClickListener() { // from class: c.e.d.d0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2302a.d(view);
            }
        };
        b();
    }

    public PayChannelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8773a = -1;
        this.f8776d = new View.OnClickListener() { // from class: c.e.d.d0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2302a.d(view);
            }
        };
        b();
    }
}
