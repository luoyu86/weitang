package com.intelligoo.sdk;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static void a(byte[] bArr) {
        l.a(bArr != null);
        k.b(bArr);
    }

    public static byte[] a() {
        return k.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(int r17) {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intelligoo.sdk.n.a(int):byte[]");
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}
