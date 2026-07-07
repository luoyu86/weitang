package com.alipay.sdk.m.o;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.taobao.accs.utl.UtilityImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5542a = "msp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5543b = "application/octet-stream;binary/octet-stream";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CookieManager f5544c = new CookieManager();

    /* JADX INFO: renamed from: com.alipay.sdk.m.o.a$a, reason: collision with other inner class name */
    public static final class C0085a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f5546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f5547c;

        public C0085a(String str, Map<String, String> map, byte[] bArr) {
            this.f5545a = str;
            this.f5546b = bArr;
            this.f5547c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f5545a, this.f5547c);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f5548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f5550c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f5548a = map;
            this.f5549b = str;
            this.f5550c = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alipay.sdk.m.o.a.b a(android.content.Context r11, com.alipay.sdk.m.o.a.C0085a r12) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.o.a.a(android.content.Context, com.alipay.sdk.m.o.a$a):com.alipay.sdk.m.o.a$b");
    }

    public static Proxy b(Context context) {
        String strA = a(context);
        if (strA != null && !strA.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            NetworkInfo networkInfoA = com.alipay.sdk.m.w.b.a(null, context);
            if (networkInfoA != null && networkInfoA.isAvailable()) {
                return networkInfoA.getType() == 1 ? UtilityImpl.NET_TYPE_WIFI : networkInfoA.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 1024);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
