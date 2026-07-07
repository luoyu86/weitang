package com.tianmu.biz.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.biz.widget.gravityrotation.GravityRotationView;
import com.tianmu.c.f.o;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f10964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f10965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f10966c;

    public c(@NonNull Context context, String str) {
        super(context);
        h();
        a(str);
    }

    private void f() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10965b.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        int iDp2px = TianmuDisplayUtil.dp2px(4);
        this.f10965b.setPadding(iDp2px, 0, iDp2px, 0);
        this.f10965b.setLayoutParams(layoutParams);
    }

    private void g() {
        TextView textView = this.f10966c;
        if (textView != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            this.f10966c.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], null, compoundDrawables[3]);
        }
    }

    private void h() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(o.f11465a, (ViewGroup) this, true);
        this.f10964a = viewInflate;
        this.f10965b = (LinearLayout) this.f10964a.findViewById(o.f11467c);
        this.f10966c = (TextView) this.f10964a.findViewById(o.f11468d);
        a((int) (((double) TianmuDisplayUtil.getScreenWidth()) * 0.9d), -2);
    }

    public void a(int i2, int i3) {
        if (i2 <= 0) {
            i2 = -1;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        int iDp2px = TianmuDisplayUtil.dp2px(5);
        int iDp2px2 = TianmuDisplayUtil.dp2px(15);
        this.f10965b.setPadding(iDp2px, iDp2px2, iDp2px, iDp2px2);
        this.f10965b.setLayoutParams(layoutParams);
    }

    public GravityRotationView b() {
        return (GravityRotationView) this.f10964a.findViewById(o.f11469e);
    }

    public void c(int i2) {
        if (i2 <= 0 || this.f10966c == null) {
            return;
        }
        Drawable drawable = getResources().getDrawable(i2);
        drawable.setBounds(0, 0, TianmuDisplayUtil.dp2px(20), TianmuDisplayUtil.dp2px(20));
        Drawable drawable2 = getResources().getDrawable(com.tianmu.c.f.c.x);
        drawable2.setBounds(0, 0, TianmuDisplayUtil.dp2px(10), TianmuDisplayUtil.dp2px(18));
        this.f10966c.setCompoundDrawables(drawable, null, drawable2, null);
        this.f10966c.setCompoundDrawablePadding(TianmuDisplayUtil.dp2px(10));
    }

    public void d() {
    }

    public void e() {
        g();
        f();
    }

    public void b(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b().getLayoutParams();
        layoutParams.height = TianmuDisplayUtil.dp2px(i2);
        b().setLayoutParams(layoutParams);
    }

    public void a(int i2) {
        LinearLayout linearLayout = this.f10965b;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(i2);
        }
    }

    public void a(String str) {
        TextView textView = this.f10966c;
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                str = "点击跳转至详情页或第三方应用";
            }
            textView.setText(str);
        }
    }

    public void c() {
        this.f10966c.setCompoundDrawables(null, null, this.f10966c.getCompoundDrawables()[2], null);
    }

    public View a() {
        return this.f10965b;
    }

    public void a(float f2) {
        TextView textView = (TextView) this.f10964a.findViewById(o.f11468d);
        this.f10966c = textView;
        textView.setTextSize(f2);
    }
}
