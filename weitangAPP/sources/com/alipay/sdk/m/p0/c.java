package com.alipay.sdk.m.p0;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String A = null;
    public static volatile c B = null;
    public static volatile b C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5586a = "VMS_IDLG_SDK_Client";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5587b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5588c = "persist.sys.identifierid.supported";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5589d = "appid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5590e = "type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5591f = "OAID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5592g = "VAID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5593h = "AAID";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5594i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public static final int m = 11;
    public static final int n = 2000;
    public static Context o = null;
    public static boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static d f5595q;
    public static d r;
    public static d s;
    public static Object t = new Object();
    public static HandlerThread u;
    public static Handler v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e(c.f5586a, "message type valid");
                return;
            }
            String unused = c.w = c.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
            synchronized (c.t) {
                c.t.notify();
            }
        }
    }

    public static c a(Context context) {
        if (B == null) {
            synchronized (c.class) {
                o = context.getApplicationContext();
                B = new c();
            }
        }
        if (C == null) {
            synchronized (c.class) {
                o = context.getApplicationContext();
                g();
                C = new b(o);
                f();
            }
        }
        return B;
    }

    public static void f() {
        p = "1".equals(a(f5588c, "0"));
    }

    public static void g() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new a(u.getLooper());
    }

    public String b(String str) {
        if (!c()) {
            return null;
        }
        String str2 = y;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (r == null && y != null) {
            a(o, 1, str);
        }
        return y;
    }

    public boolean c() {
        return p;
    }

    public String b() {
        if (!c()) {
            return null;
        }
        a(4, (String) null);
        return A;
    }

    private void b(int i2, String str) {
        Message messageObtainMessage = v.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        v.sendMessage(messageObtainMessage);
    }

    public String a() {
        if (!c()) {
            return null;
        }
        String str = x;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (f5595q == null) {
            a(o, 0, null);
        }
        return x;
    }

    public String a(String str) {
        if (!c()) {
            return null;
        }
        String str2 = z;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (s == null && z != null) {
            a(o, 2, str);
        }
        return z;
    }

    public void a(int i2, String str) {
        synchronized (t) {
            b(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d(f5586a, "query timeout");
            } else if (i2 == 0) {
                x = w;
                w = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = w;
                    if (str2 != null) {
                        z = str2;
                        w = null;
                    } else {
                        Log.e(f5586a, "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                A = w;
                w = null;
            } else {
                String str3 = w;
                if (str3 != null) {
                    y = str3;
                    w = null;
                } else {
                    Log.e(f5586a, "get vaid failed");
                }
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            f5595q = new d(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f5595q);
            return;
        }
        if (i2 == 1) {
            r = new d(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
            return;
        }
        if (i2 != 2) {
            return;
        }
        s = new d(B, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
    }
}
