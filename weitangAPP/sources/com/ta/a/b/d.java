package com.ta.a.b;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public class d implements HostnameVerifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10191b;

    public d(String str) {
        this.f10191b = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f10191b) || !(obj instanceof d)) {
            return false;
        }
        String str = ((d) obj).f10191b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f10191b.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f10191b, sSLSession);
    }
}
