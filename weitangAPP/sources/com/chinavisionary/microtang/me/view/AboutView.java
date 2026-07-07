package com.chinavisionary.microtang.me.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.open.bo.AboutVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AboutView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f7818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f7819b;

    public AboutView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setOrientation(1);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.f7819b = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.item_about_root_layout, (ViewGroup) this, false);
        this.f7818a = (LinearLayout) viewInflate.findViewById(R.id.llayout_about);
        addView(viewInflate);
    }

    public void setAboutList(List<AboutVo> list, View.OnClickListener onClickListener) {
        this.f7818a.removeAllViews();
        for (AboutVo aboutVo : list) {
            View viewInflate = this.f7819b.inflate(R.layout.item_about_layout, (ViewGroup) this, false);
            viewInflate.setId(R.id.id_about_item);
            viewInflate.setTag(aboutVo);
            ((TextView) viewInflate.findViewById(R.id.tv_title)).setText(x.getNotNullStr(aboutVo.getTitle(), ""));
            viewInflate.setOnClickListener(onClickListener);
            this.f7818a.addView(viewInflate);
        }
    }

    public AboutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public AboutView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
