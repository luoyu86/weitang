package com.alipay.sdk.m.n0;

import android.content.Context;
import android.text.TextUtils;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static d j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5534a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f5536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.alipay.sdk.m.m0.a f5539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.alipay.sdk.m.m0.a f5540g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f5533i = new Object();
    public static final String k = ".UTSystemConfig" + File.separator + "Global";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5535b = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Pattern f5541h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(Context context) {
        this.f5534a = null;
        this.f5536c = null;
        this.f5537d = "xx_utdid_key";
        this.f5538e = "xx_utdid_domain";
        this.f5539f = null;
        this.f5540g = null;
        this.f5534a = context;
        this.f5540g = new com.alipay.sdk.m.m0.a(context, k, "Alvin2", false, true);
        this.f5539f = new com.alipay.sdk.m.m0.a(context, ".DataStorage", "ContextData", false, true);
        this.f5536c = new e();
        this.f5537d = String.format("K_%d", Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.f5537d)));
        this.f5538e = String.format("D_%d", Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.f5538e)));
    }

    public static d a(Context context) {
        if (context != null && j == null) {
            synchronized (f5533i) {
                if (j == null) {
                    d dVar = new d(context);
                    j = dVar;
                    dVar.d();
                }
            }
        }
        return j;
    }

    private void b(String str) {
        com.alipay.sdk.m.m0.a aVar;
        if (a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (aVar = this.f5540g) == null) {
                return;
            }
            aVar.a("UTDID2", str);
            this.f5540g.a();
        }
    }

    private void c(String str) {
        com.alipay.sdk.m.m0.a aVar;
        if (str == null || (aVar = this.f5539f) == null || str.equals(aVar.a(this.f5537d))) {
            return;
        }
        this.f5539f.a(this.f5537d, str);
        this.f5539f.a();
    }

    private void d() {
        com.alipay.sdk.m.m0.a aVar = this.f5540g;
        if (aVar != null) {
            if (com.alipay.sdk.m.l0.f.m66a(aVar.a("UTDID2"))) {
                String strA = this.f5540g.a("UTDID");
                if (!com.alipay.sdk.m.l0.f.m66a(strA)) {
                    b(strA);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!com.alipay.sdk.m.l0.f.m66a(this.f5540g.a("DID"))) {
                this.f5540g.b("DID");
                z = true;
            }
            if (!com.alipay.sdk.m.l0.f.m66a(this.f5540g.a(OperatorName.END_INLINE_IMAGE))) {
                this.f5540g.b(OperatorName.END_INLINE_IMAGE);
                z = true;
            }
            if (com.alipay.sdk.m.l0.f.m66a(this.f5540g.a("SI"))) {
                z2 = z;
            } else {
                this.f5540g.b("SI");
            }
            if (z2) {
                this.f5540g.a();
            }
        }
    }

    private byte[] e() throws Exception {
        String strA;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrA = com.alipay.sdk.m.l0.c.a(iCurrentTimeMillis);
        byte[] bArrA2 = com.alipay.sdk.m.l0.c.a(iNextInt);
        byteArrayOutputStream.write(bArrA, 0, 4);
        byteArrayOutputStream.write(bArrA2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strA = com.alipay.sdk.m.l0.d.a(this.f5534a);
        } catch (Exception unused) {
            strA = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(strA)), 0, 4);
        byteArrayOutputStream.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private String f() {
        com.alipay.sdk.m.m0.a aVar = this.f5540g;
        if (aVar == null) {
            return null;
        }
        String strA = aVar.a("UTDID2");
        if (com.alipay.sdk.m.l0.f.m66a(strA) || this.f5536c.a(strA) == null) {
            return null;
        }
        return strA;
    }

    public synchronized String c() {
        String strF = f();
        if (a(strF)) {
            c(this.f5536c.a(strF));
            this.f5535b = strF;
            return strF;
        }
        String strA = this.f5539f.a(this.f5537d);
        if (!com.alipay.sdk.m.l0.f.m66a(strA)) {
            String strA2 = new f().a(strA);
            if (!a(strA2)) {
                strA2 = this.f5536c.b(strA);
            }
            if (a(strA2) && !com.alipay.sdk.m.l0.f.m66a(strA2)) {
                this.f5535b = strA2;
                b(strA2);
                return this.f5535b;
            }
        }
        return null;
    }

    private boolean a(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f5541h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String b() {
        String str = this.f5535b;
        if (str != null) {
            return str;
        }
        return a();
    }

    public synchronized String a() {
        String strC = c();
        this.f5535b = strC;
        if (!TextUtils.isEmpty(strC)) {
            return this.f5535b;
        }
        try {
            byte[] bArrE = e();
            if (bArrE != null) {
                String strC2 = com.alipay.sdk.m.l0.b.c(bArrE, 2);
                this.f5535b = strC2;
                b(strC2);
                String strA = this.f5536c.a(bArrE);
                if (strA != null) {
                    c(strA);
                }
                return this.f5535b;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static String a(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.alipay.sdk.m.l0.e.a(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.alipay.sdk.m.l0.b.c(mac.doFinal(bArr), 2);
    }
}
