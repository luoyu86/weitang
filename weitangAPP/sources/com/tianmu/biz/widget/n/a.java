package com.tianmu.biz.widget.n;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.biz.utils.v;
import com.tianmu.c.f.k;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f11109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0198a f11110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f11111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11114f;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.n.a$a, reason: collision with other inner class name */
    public interface InterfaceC0198a {
        void onClick(ViewGroup viewGroup, int i2);
    }

    public a(@NonNull Context context, boolean z) {
        super(context);
        this.f11112d = z;
    }

    public void a(double d2) {
    }

    public void a(String str) {
        View view;
        if (this.f11112d && (view = this.f11109a) != null) {
            TextView textView = (TextView) view.findViewById(k.f11407a);
            this.f11111c = textView;
            if (textView != null) {
                textView.setText(str);
                this.f11111c.setVisibility(0);
            }
        }
    }

    public void b() {
        this.f11110b = null;
    }

    public void b(boolean z) {
    }

    public void c() {
    }

    public void d() {
    }

    public String a(int i2, int i3, String str, int i4) {
        return v.a(getContext(), i2, i3, str, i4);
    }

    public void a(float f2, int i2, boolean z, int i3, Typeface typeface) {
        TextView textView;
        View view = this.f11109a;
        if (view == null || (textView = (TextView) view.findViewById(k.f11407a)) == null) {
            return;
        }
        textView.setTextSize(f2);
        textView.setTextColor(i2);
        textView.setTypeface(typeface);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = i3;
        textView.setLayoutParams(layoutParams);
        if (z) {
            return;
        }
        textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    public void a(boolean z) {
        TextView textView;
        View view = this.f11109a;
        if (view == null || (textView = (TextView) view.findViewById(k.f11407a)) == null || z) {
            return;
        }
        textView.setBackground(null);
    }

    public void a(InterfaceC0198a interfaceC0198a) {
        this.f11110b = interfaceC0198a;
    }

    public int a() {
        return this.f11113e;
    }

    public void a(int i2) {
        this.f11113e = i2;
    }
}
