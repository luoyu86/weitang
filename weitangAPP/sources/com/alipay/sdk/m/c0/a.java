package com.alipay.sdk.m.c0;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5297g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f5291a = str;
        this.f5292b = str2;
        this.f5293c = str3;
        this.f5294d = str4;
        this.f5295e = str5;
        this.f5296f = str6;
        this.f5297g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String strSubstring;
        StringBuilder sb2;
        String strSubstring2;
        StringBuilder sb3;
        String strSubstring3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f5291a);
        stringBuffer.append("," + this.f5292b);
        stringBuffer.append("," + this.f5293c);
        stringBuffer.append("," + this.f5294d);
        if (com.alipay.sdk.m.z.a.a(this.f5295e) || this.f5295e.length() < 20) {
            sb = new StringBuilder(",");
            strSubstring = this.f5295e;
        } else {
            sb = new StringBuilder(",");
            strSubstring = this.f5295e.substring(0, 20);
        }
        sb.append(strSubstring);
        stringBuffer.append(sb.toString());
        if (com.alipay.sdk.m.z.a.a(this.f5296f) || this.f5296f.length() < 20) {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f5296f;
        } else {
            sb2 = new StringBuilder(",");
            strSubstring2 = this.f5296f.substring(0, 20);
        }
        sb2.append(strSubstring2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.sdk.m.z.a.a(this.f5297g) || this.f5297g.length() < 20) {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.f5297g;
        } else {
            sb3 = new StringBuilder(",");
            strSubstring3 = this.f5297g.substring(0, 20);
        }
        sb3.append(strSubstring3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
