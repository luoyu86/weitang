package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ta.a.c.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f10220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.ta.utdid2.b.a.a f150a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10225d = null;
    private Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Pattern f10221b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f149a = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10223f = ".UTSystemConfig" + File.separator + "Global";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f10222e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f10224g = "";

    private d(Context context) {
        this.mContext = null;
        this.f150a = null;
        this.mContext = context;
        com.ta.a.a.a().a(context);
        this.f150a = new com.ta.utdid2.b.a.a(context, f10223f, "Alvin2");
    }

    public static d a(Context context) {
        if (context != null && f10220a == null) {
            synchronized (f149a) {
                if (f10220a == null) {
                    f10220a = new d(context);
                }
            }
        }
        return f10220a;
    }

    private static String b(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.ta.a.c.e.b(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.a.encodeToString(mac.doFinal(bArr), 2);
    }

    private void c(String str) {
        if (m83c(str)) {
            f10222e = 6;
            f.m80a("UTUtdid", "utdid type:", 6);
            this.f150a.a(str, f10222e);
        }
    }

    private String p() {
        String strQ = q();
        if (m83c(strQ)) {
            if (TextUtils.isEmpty(strQ) || !strQ.endsWith("\n")) {
                this.f10225d = strQ;
            } else {
                this.f10225d = strQ.substring(0, strQ.length() - 1);
            }
            return this.f10225d;
        }
        try {
            byte[] bArrA = a();
            if (bArrA == null) {
                return null;
            }
            String strEncodeToString = com.ta.utdid2.a.a.a.encodeToString(bArrA, 2);
            this.f10225d = strEncodeToString;
            f10222e = 6;
            c(strEncodeToString);
            return this.f10225d;
        } catch (Exception e2) {
            f.a("", e2, new Object[0]);
            return null;
        }
    }

    private String q() {
        String strK = this.f150a.k();
        if (!m83c(strK)) {
            f.m80a("UTUtdid", "read utdid is null");
            Log.d("UTUtdid", "read utdid is null");
            return null;
        }
        int iA = this.f150a.a();
        if (iA == 0) {
            f10222e = 1;
        } else {
            f10222e = iA;
        }
        f.m80a("UTUtdid", "get utdid from sp. type", Integer.valueOf(f10222e));
        return strK;
    }

    public static void setExtendFactor(String str) {
        f10224g = str;
    }

    public static void setType(int i2) {
        f10222e = i2;
    }

    public synchronized String getValue() {
        String str = this.f10225d;
        if (str != null) {
            return str;
        }
        return p();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m83c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f10221b.matcher(str).find();
        }
        return false;
    }

    private byte[] a() throws Exception {
        String str;
        f.m80a("UTUtdid", "generateUtdid");
        Log.d("UTUtdid", "generateUtdid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.a.a.b.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.a.a.b.getBytes(iNextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = f10224g + com.ta.utdid2.a.a.c.b(this.mContext);
        } catch (Exception unused) {
            str = f10224g + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.b.getBytes(com.ta.utdid2.a.a.d.a(str)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.a.a.b.getBytes(com.ta.utdid2.a.a.d.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }
}
