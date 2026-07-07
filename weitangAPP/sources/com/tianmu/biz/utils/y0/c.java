package com.tianmu.biz.utils.y0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f10909a = new c();
    }

    private com.tianmu.biz.utils.y0.a b() throws IllegalAccessException, InvocationTargetException {
        String strA = a("ro.product.board");
        if (strA == null) {
            return new com.tianmu.biz.utils.y0.a(0, null);
        }
        String lowerCase = strA.toLowerCase();
        return new com.tianmu.biz.utils.y0.a((lowerCase.contains(DispatchConstants.ANDROID) || lowerCase.contains("goldfish")) ? 1 : 2, strA);
    }

    private com.tianmu.biz.utils.y0.a c() throws IllegalAccessException, InvocationTargetException {
        String strA = a("ro.build.flavor");
        if (strA == null) {
            return new com.tianmu.biz.utils.y0.a(0, null);
        }
        String lowerCase = strA.toLowerCase();
        return new com.tianmu.biz.utils.y0.a((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, strA);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tianmu.biz.utils.y0.a d() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r7 = this;
            java.lang.String r0 = "ro.hardware"
            java.lang.String r0 = r7.a(r0)
            r1 = 0
            if (r0 != 0) goto L10
            com.tianmu.biz.utils.y0.a r0 = new com.tianmu.biz.utils.y0.a
            r2 = 0
            r0.<init>(r1, r2)
            return r0
        L10:
            java.lang.String r2 = r0.toLowerCase()
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 2
            r6 = 1
            switch(r4) {
                case -1367724016: goto L65;
                case -822798509: goto L5a;
                case 109271: goto L4f;
                case 3570999: goto L44;
                case 3613077: goto L39;
                case 100361430: goto L2e;
                case 937844646: goto L23;
                default: goto L21;
            }
        L21:
            r1 = -1
            goto L6e
        L23:
            java.lang.String r1 = "android_x86"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L2c
            goto L21
        L2c:
            r1 = 6
            goto L6e
        L2e:
            java.lang.String r1 = "intel"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L37
            goto L21
        L37:
            r1 = 5
            goto L6e
        L39:
            java.lang.String r1 = "vbox"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L42
            goto L21
        L42:
            r1 = 4
            goto L6e
        L44:
            java.lang.String r1 = "ttvm"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L4d
            goto L21
        L4d:
            r1 = 3
            goto L6e
        L4f:
            java.lang.String r1 = "nox"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L58
            goto L21
        L58:
            r1 = 2
            goto L6e
        L5a:
            java.lang.String r1 = "vbox86"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L63
            goto L21
        L63:
            r1 = 1
            goto L6e
        L65:
            java.lang.String r4 = "cancro"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L6e
            goto L21
        L6e:
            switch(r1) {
                case 0: goto L72;
                case 1: goto L72;
                case 2: goto L72;
                case 3: goto L72;
                case 4: goto L72;
                case 5: goto L72;
                case 6: goto L72;
                default: goto L71;
            }
        L71:
            goto L73
        L72:
            r5 = 1
        L73:
            com.tianmu.biz.utils.y0.a r1 = new com.tianmu.biz.utils.y0.a
            r1.<init>(r5, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.biz.utils.y0.c.d():com.tianmu.biz.utils.y0.a");
    }

    private com.tianmu.biz.utils.y0.a e() throws IllegalAccessException, InvocationTargetException {
        String strA = a("ro.product.manufacturer");
        if (strA == null) {
            return new com.tianmu.biz.utils.y0.a(0, null);
        }
        String lowerCase = strA.toLowerCase();
        return new com.tianmu.biz.utils.y0.a((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, strA);
    }

    private com.tianmu.biz.utils.y0.a f() throws IllegalAccessException, InvocationTargetException {
        String strA = a("ro.product.model");
        if (strA == null) {
            return new com.tianmu.biz.utils.y0.a(0, null);
        }
        String lowerCase = strA.toLowerCase();
        return new com.tianmu.biz.utils.y0.a((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2, strA);
    }

    private com.tianmu.biz.utils.y0.a g() throws IllegalAccessException, InvocationTargetException {
        String strA = a("ro.board.platform");
        if (strA == null) {
            return new com.tianmu.biz.utils.y0.a(0, null);
        }
        return new com.tianmu.biz.utils.y0.a(strA.toLowerCase().contains(DispatchConstants.ANDROID) ? 1 : 2, strA);
    }

    public static final c h() {
        return b.f10909a;
    }

    public boolean a(Context context) {
        int i2;
        if (context == null) {
            return true;
        }
        try {
            int i3 = d().f10907a;
            if (i3 == 0) {
                i2 = 1;
            } else {
                if (i3 == 1) {
                    return true;
                }
                i2 = 0;
            }
            int i4 = c().f10907a;
            if (i4 == 0) {
                i2++;
            } else if (i4 == 1) {
                return true;
            }
            int i5 = f().f10907a;
            if (i5 == 0) {
                i2++;
            } else if (i5 == 1) {
                return true;
            }
            int i6 = e().f10907a;
            if (i6 == 0) {
                i2++;
            } else if (i6 == 1) {
                return true;
            }
            int i7 = b().f10907a;
            if (i7 == 0) {
                i2++;
            } else if (i7 == 1) {
                return true;
            }
            int i8 = g().f10907a;
            if (i8 == 0) {
                i2++;
            } else if (i8 == 1) {
                return true;
            }
            int i9 = a().f10907a;
            if (i9 == 0) {
                i2 += 2;
            } else if (i9 == 1) {
                return true;
            }
            if (!c(context)) {
                i2++;
            }
            if (!b(context)) {
                i2++;
            }
            return i2 > 3;
        } catch (Throwable unused) {
            return true;
        }
    }

    private c() {
    }

    private boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private boolean c(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private String a(String str) throws IllegalAccessException, InvocationTargetException {
        String strA = com.tianmu.biz.utils.y0.b.a().a(str);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA;
    }

    private com.tianmu.biz.utils.y0.a a() throws IllegalAccessException, InvocationTargetException {
        String strA = a("gsm.version.baseband");
        if (strA == null) {
            return new com.tianmu.biz.utils.y0.a(0, null);
        }
        return new com.tianmu.biz.utils.y0.a(strA.contains("1.0.0.0") ? 1 : 2, strA);
    }
}
