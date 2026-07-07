package com.bytedance.sdk.openadsdk.api.plugin.a;

import com.alibaba.android.arouter.utils.Consts;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class ok implements HostnameVerifier {
    public static final ok ok = new ok();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6345a = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private ok() {
    }

    private boolean a(String str, X509Certificate x509Certificate) {
        List<String> listOk = ok(x509Certificate, 7);
        int size = listOk.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(listOk.get(i2))) {
                return true;
            }
        }
        return false;
    }

    private boolean bl(String str, X509Certificate x509Certificate) {
        String strOk;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listOk = ok(x509Certificate, 2);
        int size = listOk.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            if (ok(lowerCase, listOk.get(i2))) {
                return true;
            }
            i2++;
            z = true;
        }
        if (z || (strOk = new a(x509Certificate.getSubjectX500Principal()).ok("cn")) == null) {
            return false;
        }
        return ok(lowerCase, strOk);
    }

    private boolean ok(String str, X509Certificate x509Certificate) {
        return ok(str) ? a(str, x509Certificate) : bl(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return ok(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean ok(String str) {
        return f6345a.matcher(str).matches();
    }

    private static List<String> ok(X509Certificate x509Certificate, int i2) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean ok(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(Consts.DOT) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(Consts.DOT) && !str2.endsWith("..")) {
            if (!str.endsWith(Consts.DOT)) {
                str = str + '.';
            }
            if (!str2.endsWith(Consts.DOT)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
