package com.tianmu.biz.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tianmu.ad.activity.AppPermissionsActivity;
import com.tianmu.ad.activity.WebViewActivity;

/* JADX INFO: loaded from: classes2.dex */
public class q0 {

    public static class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f10895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f10896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f10897d;

        public a(String str, Context context, c cVar, String str2) {
            this.f10894a = str;
            this.f10895b = context;
            this.f10896c = cVar;
            this.f10897d = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (!TextUtils.isEmpty(this.f10894a)) {
                WebViewActivity.openUrl(this.f10895b, this.f10894a, "权限信息");
                c cVar = this.f10896c;
                if (cVar != null) {
                    cVar.click();
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(this.f10897d)) {
                return;
            }
            AppPermissionsActivity.start(this.f10895b, this.f10897d);
            c cVar2 = this.f10896c;
            if (cVar2 != null) {
                cVar2.click();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
    }

    public static class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f10899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f10900c;

        public b(String str, Context context, c cVar) {
            this.f10898a = str;
            this.f10899b = context;
            this.f10900c = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (TextUtils.isEmpty(this.f10898a)) {
                return;
            }
            WebViewActivity.openUrl(this.f10899b, this.f10898a, "隐私政策");
            c cVar = this.f10900c;
            if (cVar != null) {
                cVar.click();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
    }

    public interface c {
        void click();
    }

    public static SpannableStringBuilder a(Context context, com.tianmu.c.i.a aVar, boolean z) {
        return a(context, aVar, z, null);
    }

    public static SpannableStringBuilder a(Context context, com.tianmu.c.i.a aVar, boolean z, c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (aVar == null) {
            return spannableStringBuilder;
        }
        String strD = aVar.d();
        String strF = aVar.f();
        String strA = aVar.a();
        String strH = aVar.h();
        String strI = aVar.i();
        String strJ = aVar.j();
        if (!TextUtils.isEmpty(strD)) {
            spannableStringBuilder.append((CharSequence) "应用名称：");
            spannableStringBuilder.append((CharSequence) strD);
            spannableStringBuilder.append((CharSequence) "；");
        }
        if (!TextUtils.isEmpty(strF)) {
            spannableStringBuilder.append((CharSequence) "版本号：");
            spannableStringBuilder.append((CharSequence) strF);
            spannableStringBuilder.append((CharSequence) "；");
        }
        if (!TextUtils.isEmpty(strA)) {
            spannableStringBuilder.append((CharSequence) "开发者：");
            spannableStringBuilder.append((CharSequence) strA);
            spannableStringBuilder.append((CharSequence) "；");
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) "\n");
        }
        if (!TextUtils.isEmpty(strH) || !TextUtils.isEmpty(strI)) {
            spannableStringBuilder.append((CharSequence) "权限信息");
        }
        if ((!TextUtils.isEmpty(strH) || !TextUtils.isEmpty(strI)) && !TextUtils.isEmpty(strJ)) {
            spannableStringBuilder.append((CharSequence) " | ");
        }
        if (!TextUtils.isEmpty(strJ)) {
            spannableStringBuilder.append((CharSequence) "隐私政策");
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            if (spannableStringBuilder.toString().contains("权限信息")) {
                spannableStringBuilder.setSpan(new a(strH, context, cVar, strI), spannableStringBuilder.toString().indexOf("权限信息"), spannableStringBuilder.toString().indexOf("权限信息") + 4, 33);
            }
            if (spannableStringBuilder.toString().contains("隐私政策")) {
                spannableStringBuilder.setSpan(new b(strJ, context, cVar), spannableStringBuilder.toString().indexOf("隐私政策"), spannableStringBuilder.toString().indexOf("隐私政策") + 4, 33);
            }
        }
        return spannableStringBuilder;
    }
}
