package com.tianmu.biz.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.ad.activity.AppPermissionsActivity;
import com.tianmu.ad.activity.WebViewActivity;

/* JADX INFO: loaded from: classes2.dex */
public class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f10949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f10950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f10951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f10952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f10953e;

    public class a extends com.tianmu.c.l.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.a f10954d;

        public a(com.tianmu.c.i.a aVar) {
            this.f10954d = aVar;
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            WebViewActivity.openUrl(b.this.getContext(), this.f10954d.h(), "权限信息");
        }
    }

    /* JADX INFO: renamed from: com.tianmu.biz.widget.b$b, reason: collision with other inner class name */
    public class C0189b extends com.tianmu.c.l.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.a f10956d;

        public C0189b(com.tianmu.c.i.a aVar) {
            this.f10956d = aVar;
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            AppPermissionsActivity.start(b.this.getContext(), this.f10956d.i());
        }
    }

    public class c extends com.tianmu.c.l.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.a f10958d;

        public c(com.tianmu.c.i.a aVar) {
            this.f10958d = aVar;
        }

        @Override // com.tianmu.c.l.a
        public void onSingleClick(View view) {
            WebViewActivity.openUrl(b.this.getContext(), this.f10958d.j(), "隐私政策");
        }
    }

    public class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.a f10960a;

        public d(com.tianmu.c.i.a aVar) {
            this.f10960a = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (!TextUtils.isEmpty(this.f10960a.h())) {
                WebViewActivity.openUrl(b.this.getContext(), this.f10960a.h(), "权限信息");
            } else {
                if (TextUtils.isEmpty(this.f10960a.i())) {
                    return;
                }
                AppPermissionsActivity.start(b.this.getContext(), this.f10960a.i());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
    }

    public class e extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.a f10962a;

        public e(com.tianmu.c.i.a aVar) {
            this.f10962a = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (TextUtils.isEmpty(this.f10962a.j())) {
                return;
            }
            WebViewActivity.openUrl(b.this.getContext(), this.f10962a.j(), "隐私政策");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
    }

    public b(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(com.tianmu.c.f.e.f11338a, (ViewGroup) this, true);
        this.f10949a = viewInflate;
        this.f10950b = (LinearLayout) this.f10949a.findViewById(com.tianmu.c.f.e.f11340c);
        this.f10951c = (TextView) this.f10949a.findViewById(com.tianmu.c.f.e.f11341d);
        this.f10952d = (TextView) this.f10949a.findViewById(com.tianmu.c.f.e.f11342e);
        this.f10953e = (TextView) this.f10949a.findViewById(com.tianmu.c.f.e.f11343f);
    }

    public void a(com.tianmu.c.i.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        if (!z) {
            if (this.f10952d != null) {
                if (!TextUtils.isEmpty(aVar.h())) {
                    this.f10952d.setOnClickListener(new a(aVar));
                } else if (!TextUtils.isEmpty(aVar.i())) {
                    this.f10952d.setOnClickListener(new C0189b(aVar));
                } else {
                    this.f10952d.setVisibility(8);
                }
            }
            if (this.f10953e != null) {
                if (!TextUtils.isEmpty(aVar.j())) {
                    this.f10953e.setOnClickListener(new c(aVar));
                } else {
                    this.f10953e.setVisibility(8);
                }
            }
            if ((TextUtils.isEmpty(aVar.h()) || TextUtils.isEmpty(aVar.i())) && TextUtils.isEmpty(aVar.j())) {
                this.f10950b.setVisibility(8);
            }
        } else {
            this.f10950b.setVisibility(8);
        }
        if (this.f10951c != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(aVar.d())) {
                spannableStringBuilder.append((CharSequence) "应用名称：");
                spannableStringBuilder.append((CharSequence) aVar.d());
                spannableStringBuilder.append((CharSequence) "；");
            }
            if (!TextUtils.isEmpty(aVar.f())) {
                spannableStringBuilder.append((CharSequence) "版本号：");
                spannableStringBuilder.append((CharSequence) aVar.f());
                spannableStringBuilder.append((CharSequence) "；");
            }
            if (!TextUtils.isEmpty(aVar.a())) {
                spannableStringBuilder.append((CharSequence) "开发者：");
                spannableStringBuilder.append((CharSequence) aVar.a());
                spannableStringBuilder.append((CharSequence) "；");
            }
            if (z) {
                if (!TextUtils.isEmpty(aVar.h()) || !TextUtils.isEmpty(aVar.i())) {
                    spannableStringBuilder.append((CharSequence) "权限信息");
                }
                if ((!TextUtils.isEmpty(aVar.h()) || !TextUtils.isEmpty(aVar.i())) && !TextUtils.isEmpty(aVar.j())) {
                    spannableStringBuilder.append((CharSequence) " | ");
                }
                if (!TextUtils.isEmpty(aVar.j())) {
                    spannableStringBuilder.append((CharSequence) "隐私政策");
                }
            }
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                return;
            }
            this.f10951c.setVisibility(0);
            if (spannableStringBuilder.toString().contains("权限信息")) {
                spannableStringBuilder.setSpan(new d(aVar), spannableStringBuilder.toString().indexOf("权限信息"), spannableStringBuilder.toString().indexOf("权限信息") + 4, 33);
            }
            if (spannableStringBuilder.toString().contains("隐私政策")) {
                spannableStringBuilder.setSpan(new e(aVar), spannableStringBuilder.toString().indexOf("隐私政策"), spannableStringBuilder.toString().indexOf("隐私政策") + 4, 33);
            }
            this.f10951c.setMovementMethod(LinkMovementMethod.getInstance());
            this.f10951c.setText(spannableStringBuilder);
        }
    }
}
