package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.RomInfoCollector;
import com.taobao.accs.utl.UtilityImpl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class Message {
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BIND_APP = "ctrl_bindapp";
    public static final String KEY_BIND_SERVICE = "ctrl_bindservice";
    public static final String KEY_BIND_USER = "ctrl_binduser";
    public static final String KEY_UNBIND_APP = "ctrl_unbindapp";
    public static final String KEY_UNBIND_SERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBIND_USER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10264a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f10265b = 1;
    public byte[] N;
    public String O;
    public int P;
    public long T;
    public long U;
    public transient NetPerformanceMonitor W;
    public a Y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public URL f10269f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public short f10272i;
    public short j;
    public short k;
    public byte l;
    public byte m;
    public String n;
    public String o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10273q;
    public Map<Integer, String> r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10266c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10267d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10268e = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f10270g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f10271h = 0;
    public int p = -1;
    public String s = null;
    public Integer t = null;
    public Integer u = 0;
    public String v = null;
    public String w = null;
    public Integer x = null;
    public String y = null;
    public String z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public Integer D = null;
    public String E = null;
    public String F = null;
    public String G = null;
    public String H = null;
    public String I = null;
    public String J = null;
    public String K = null;
    public String L = null;
    public String M = null;
    public long Q = 0;
    public int R = 0;
    public int S = com.taobao.accs.net.b.ACCS_RECEIVE_TIMEOUT;
    public String V = null;
    public String X = null;

    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? DATA : RES : REQ : ACK : DATA;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10275b;

        public a(int i2, String str) {
            this.f10274a = i2;
            this.f10275b = str;
        }

        public int a() {
            return this.f10274a;
        }

        public String b() {
            return this.f10275b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10274a == aVar.a() || this.f10275b.equals(aVar.b());
        }

        public int hashCode() {
            return this.f10275b.hashCode();
        }
    }

    public static class b {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String a(int i2) {
            return i2 != 0 ? i2 != 1 ? "INVALID" : "NEED_ACK" : "NO_ACK";
        }
    }

    public static class c {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static int a(int i2) {
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    i3 = 3;
                    if (i2 != 3) {
                        return 0;
                    }
                }
            }
            return i3;
        }

        public static String b(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "INVALID" : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.T = System.currentTimeMillis();
            String str = String.valueOf(this.T) + Consts.DOT + String.valueOf(f10265b);
            this.f10273q = str;
            long j = f10265b;
            f10265b = 1 + j;
            this.Y = new a((int) j, str);
        }
    }

    private String j() {
        return "Msg_" + this.X;
    }

    public int a() {
        return this.p;
    }

    public String b() {
        return this.f10273q;
    }

    public boolean c() {
        return Constants.TARGET_CONTROL.equals(this.n);
    }

    public a d() {
        return this.Y;
    }

    public NetPerformanceMonitor e() {
        return this.W;
    }

    public String f() {
        String str = this.s;
        return str == null ? "" : str;
    }

    public boolean g() {
        boolean z = (System.currentTimeMillis() - this.T) + this.Q >= ((long) this.S);
        if (z) {
            ALog.e(j(), "delay time:" + this.Q + " beforeSendTime:" + (System.currentTimeMillis() - this.T) + " timeout" + this.S, new Object[0]);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0049 A[Catch: Exception -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x004f, blocks: (B:13:0x0029, B:14:0x002c, B:24:0x0049), top: B:40:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            r7 = this;
            r0 = 0
            byte[] r1 = r7.N     // Catch: java.lang.Throwable -> L37
            if (r1 != 0) goto L6
            return
        L6:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L32
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L32
            byte[] r0 = r7.N     // Catch: java.lang.Throwable -> L30
            r2.write(r0)     // Catch: java.lang.Throwable -> L30
            r2.finish()     // Catch: java.lang.Throwable -> L30
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L29
            int r3 = r0.length     // Catch: java.lang.Throwable -> L30
            byte[] r4 = r7.N     // Catch: java.lang.Throwable -> L30
            int r4 = r4.length     // Catch: java.lang.Throwable -> L30
            if (r3 >= r4) goto L29
            r7.N = r0     // Catch: java.lang.Throwable -> L30
            r0 = 1
            r7.f10270g = r0     // Catch: java.lang.Throwable -> L30
        L29:
            r2.close()     // Catch: java.lang.Exception -> L4f
        L2c:
            r1.close()     // Catch: java.lang.Exception -> L4f
            goto L4f
        L30:
            r0 = move-exception
            goto L3b
        L32:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L3b
        L37:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L3b:
            java.lang.String r3 = r7.j()     // Catch: java.lang.Throwable -> L50
            java.lang.String r4 = "compressData fail"
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L50
            com.taobao.accs.utl.ALog.w(r3, r4, r0, r5)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.lang.Exception -> L4f
        L4c:
            if (r1 == 0) goto L4f
            goto L2c
        L4f:
            return
        L50:
            r0 = move-exception
            if (r2 == 0) goto L56
            r2.close()     // Catch: java.lang.Exception -> L5b
        L56:
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.lang.Exception -> L5b
        L5b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.Message.h():void");
    }

    public void i() throws JSONException, UnsupportedEncodingException {
        Integer num = this.t;
        if (num == null || num.intValue() == 100 || this.t.intValue() == 102) {
            return;
        }
        this.N = new JsonUtility.JsonObjectBuilder().put("command", this.t.intValue() == 100 ? null : this.t).put(Constants.KEY_APP_KEY, this.v).put(Constants.KEY_OS_TYPE, this.x).put("sign", this.w).put(Constants.KEY_SDK_VERSION, this.D).put("appVersion", this.C).put(Constants.KEY_TTID, this.E).put(Constants.KEY_MODEL, this.I).put(Constants.KEY_BRAND, this.J).put(Constants.KEY_IMEI, this.K).put(Constants.KEY_IMSI, this.L).put("os", this.y).put(Constants.KEY_EXTS, this.B).build().toString().getBytes("utf-8");
    }

    public static Message b(com.taobao.accs.net.b bVar, Intent intent) {
        Message messageA = null;
        try {
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            messageA = a(stringExtra, stringExtra2);
            messageA.X = bVar.m;
            a(bVar, messageA);
            return messageA;
        } catch (Throwable th) {
            ALog.e("Msg", "buildBindService", th, new Object[0]);
            th.printStackTrace();
            return messageA;
        }
    }

    public static Message c(com.taobao.accs.net.b bVar, Intent intent) {
        Message messageB = null;
        try {
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            messageB = b(stringExtra, stringExtra2);
            messageB.X = bVar.m;
            a(bVar, messageB);
            return messageB;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindService", e2, new Object[0]);
            e2.printStackTrace();
            return messageB;
        }
    }

    public static Message d(com.taobao.accs.net.b bVar, Intent intent) {
        Message messageC = null;
        try {
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            messageC = c(stringExtra, stringExtra2);
            if (messageC != null) {
                messageC.X = bVar.m;
                a(bVar, messageC);
            }
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindUser", e2, new Object[0]);
            e2.printStackTrace();
        }
        return messageC;
    }

    public static Message e(com.taobao.accs.net.b bVar, Intent intent) {
        Message messageA = null;
        try {
            String stringExtra = intent.getStringExtra("packageName");
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            messageA = a(stringExtra);
            messageA.X = bVar.m;
            a(bVar, messageA);
            return messageA;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindUser", e2, new Object[0]);
            e2.printStackTrace();
            return messageA;
        }
    }

    public void a(long j) {
        this.U = j;
    }

    public byte[] a(Context context, int i2) {
        byte[] bytes;
        try {
            i();
        } catch (UnsupportedEncodingException e2) {
            ALog.e(j(), "build2", e2, new Object[0]);
        } catch (JSONException e3) {
            ALog.e(j(), "build1", e3, new Object[0]);
        }
        String str = this.N != null ? new String(this.N) : "";
        h();
        if (!this.f10266c) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilityImpl.getDeviceId(context));
            sb.append("|");
            sb.append(this.s);
            sb.append("|");
            String str2 = this.H;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("|");
            String str3 = this.G;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.o = sb.toString();
        }
        try {
            bytes = (this.f10273q + "").getBytes("utf-8");
            this.m = (byte) this.o.getBytes("utf-8").length;
            this.l = (byte) this.n.getBytes("utf-8").length;
        } catch (Exception e4) {
            e4.printStackTrace();
            ALog.e(j(), "build3", e4, new Object[0]);
            bytes = (this.f10273q + "").getBytes();
            this.m = (byte) this.o.getBytes().length;
            this.l = (byte) this.n.getBytes().length;
        }
        short sA = a(this.r);
        int length = this.l + 3 + 1 + this.m + 1 + bytes.length;
        byte[] bArr = this.N;
        short length2 = (short) (length + (bArr == null ? 0 : bArr.length) + sA + 2);
        this.j = length2;
        this.f10272i = (short) (length2 + 2);
        com.taobao.accs.utl.g gVar = new com.taobao.accs.utl.g(this.f10272i + 2 + 4);
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(j(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            gVar.a((byte) (this.f10270g | 32));
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tversion:2 compress:" + ((int) this.f10270g), new Object[0]);
            }
            if (i2 == 0) {
                gVar.a((byte) -128);
                if (ALog.isPrintLog(level)) {
                    ALog.d(j(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                gVar.a((byte) 64);
                if (ALog.isPrintLog(level)) {
                    ALog.d(j(), "\tflag: 0x40", new Object[0]);
                }
            }
            gVar.a(this.f10272i);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\ttotalLength:" + ((int) this.f10272i), new Object[0]);
            }
            gVar.a(this.j);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tdataLength:" + ((int) this.j), new Object[0]);
            }
            gVar.a(this.k);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tflags:" + Integer.toHexString(this.k), new Object[0]);
            }
            gVar.a(this.l);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\ttargetLength:" + ((int) this.l), new Object[0]);
            }
            gVar.write(this.n.getBytes("utf-8"));
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\ttarget:" + this.n, new Object[0]);
            }
            gVar.a(this.m);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tsourceLength:" + ((int) this.m), new Object[0]);
            }
            gVar.write(this.o.getBytes("utf-8"));
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tsource:" + this.o, new Object[0]);
            }
            gVar.a((byte) bytes.length);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            gVar.write(bytes);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tdataId:" + new String(bytes), new Object[0]);
            }
            gVar.a(sA);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\textHeader len:" + ((int) sA), new Object[0]);
            }
            Map<Integer, String> map = this.r;
            if (map != null) {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    String str4 = this.r.get(Integer.valueOf(iIntValue));
                    if (!TextUtils.isEmpty(str4)) {
                        gVar.a((short) ((((short) iIntValue) << 10) | ((short) (str4.getBytes("utf-8").length & 1023))));
                        gVar.write(str4.getBytes("utf-8"));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(j(), "\textHeader key:" + iIntValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            byte[] bArr2 = this.N;
            if (bArr2 != null) {
                gVar.write(bArr2);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(j(), "\toriData:" + str, new Object[0]);
            }
            gVar.flush();
        } catch (IOException e5) {
            ALog.e(j(), "build4", e5, new Object[0]);
        }
        byte[] byteArray = gVar.toByteArray();
        try {
            gVar.close();
        } catch (IOException e6) {
            ALog.e(j(), "build5", e6, new Object[0]);
        }
        return byteArray;
    }

    public static Message b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.H = str2;
        message.n = Constants.TARGET_CONTROL;
        message.t = 6;
        message.s = str;
        message.H = str2;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_UNBIND_SERVICE;
        return message;
    }

    public static Message c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.G = str2;
        message.n = Constants.TARGET_CONTROL;
        message.t = 3;
        message.s = str;
        message.G = str2;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_BIND_USER;
        return message;
    }

    public short a(Map<Integer, String> map) {
        short length = 0;
        if (map != null) {
            try {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = map.get(Integer.valueOf(it.next().intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        length = (short) (length + ((short) (str.getBytes("utf-8").length & 1023)) + 2);
                    }
                }
            } catch (Exception e2) {
                e2.toString();
            }
        }
        return length;
    }

    public static Message a(boolean z, int i2) {
        Message message = new Message();
        message.p = 2;
        message.t = 201;
        message.f10267d = z;
        message.Q = i2;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        Message messageA = null;
        try {
            String stringExtra = intent.getStringExtra("packageName");
            intent.getStringExtra(Constants.KEY_USER_ID);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            messageA = a(context, bVar.m, stringExtra2, intent.getStringExtra("app_sercet"), stringExtra, stringExtra3, intent.getStringExtra("appVersion"));
            a(bVar, messageA);
            return messageA;
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindApp", e2.getMessage());
            return messageA;
        }
    }

    public static Message a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.x = 1;
        message.y = Build.VERSION.SDK_INT + "";
        message.s = str4;
        message.n = Constants.TARGET_CONTROL;
        message.t = 1;
        message.v = str2;
        message.w = UtilityImpl.a(str2, str3, UtilityImpl.getDeviceId(context));
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.C = str6;
        message.s = str4;
        message.E = str5;
        message.I = Build.MODEL;
        message.J = Build.BRAND;
        message.O = KEY_BIND_APP;
        message.X = str;
        message.B = new JsonUtility.JsonObjectBuilder().put("notifyEnable", UtilityImpl.k(context)).put("romInfo", RomInfoCollector.getCollector().collect()).build().toString();
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Intent intent) {
        ALog.e("Msg", "buildUnbindApp1" + UtilityImpl.a(new Exception()), new Object[0]);
        Message messageA = null;
        try {
            String stringExtra = intent.getStringExtra("packageName");
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            messageA = a(bVar, stringExtra);
            a(bVar, messageA);
            return messageA;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindApp1", e2.getMessage());
            return messageA;
        }
    }

    public static Message a(com.taobao.accs.net.b bVar, String str) {
        Message message = null;
        try {
            ALog.e("Msg", "buildUnbindApp" + UtilityImpl.a(new Exception()), new Object[0]);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Message message2 = new Message();
            try {
                message2.P = 1;
                message2.a(1, ReqType.DATA, 1);
                message2.s = str;
                message2.n = Constants.TARGET_CONTROL;
                message2.t = 2;
                message2.s = str;
                message2.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
                message2.O = KEY_UNBIND_APP;
                a(bVar, message2);
                return message2;
            } catch (Exception e2) {
                e = e2;
                message = message2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        ALog.e("Msg", "buildUnbindApp", e.getMessage());
        return message;
    }

    public static Message a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.H = str2;
        message.n = Constants.TARGET_CONTROL;
        message.t = 5;
        message.s = str;
        message.H = str2;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_BIND_SERVICE;
        return message;
    }

    public static Message a(String str, String str2, String str3, int i2) {
        Message message = new Message();
        try {
            message.f10269f = new URL(str3);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        message.n = Constants.TARGET_SERVICE_ST;
        message.a(1, ReqType.DATA, 0);
        message.t = 100;
        message.N = ("0|" + i2 + "|" + str + "|" + AdapterUtilityImpl.getDeviceId(GlobalClientInfo.getContext()) + "|" + str2).getBytes();
        return message;
    }

    public static Message a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.n = Constants.TARGET_CONTROL;
        message.t = 4;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_UNBIND_USER;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, ACCSManager.AccsRequest accsRequest) {
        return a(bVar, context, str, accsRequest, true);
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.t = 100;
        message.s = str;
        message.H = accsRequest.serviceId;
        message.G = accsRequest.userId;
        message.N = accsRequest.data;
        String str2 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str2);
        sb.append("|");
        String str3 = accsRequest.target;
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        message.n = sb.toString();
        message.O = accsRequest.dataId;
        message.V = accsRequest.businessId;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.S = i2;
        }
        if (z) {
            a(bVar, message, accsRequest);
        } else {
            message.f10269f = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(bVar.m), GlobalClientInfo.getInstance(context).getUserId(bVar.m), bVar.f10359i.getStoreId(), GlobalClientInfo.f10250b, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.W = netPerformanceMonitor;
        netPerformanceMonitor.setMsgType(0);
        message.W.setDataId(accsRequest.dataId);
        message.W.setServiceId(accsRequest.serviceId);
        NetPerformanceMonitor netPerformanceMonitor2 = message.W;
        URL url = message.f10269f;
        netPerformanceMonitor2.setHost(url != null ? url.toString() : "");
        message.X = bVar.m;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.REQ, 1);
        message.t = 100;
        message.s = str;
        message.H = accsRequest.serviceId;
        message.G = accsRequest.userId;
        message.N = accsRequest.data;
        String str3 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str3);
        sb.append("|");
        String str4 = accsRequest.target;
        if (str4 == null) {
            str4 = "";
        }
        sb.append(str4);
        message.n = sb.toString();
        message.O = accsRequest.dataId;
        message.V = accsRequest.businessId;
        message.X = bVar.m;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.S = i2;
        }
        if (z) {
            a(bVar, message, accsRequest);
        } else {
            message.f10269f = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(bVar.m), GlobalClientInfo.getInstance(context).getUserId(bVar.m), bVar.f10359i.getStoreId(), GlobalClientInfo.f10250b, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.W = netPerformanceMonitor;
        netPerformanceMonitor.setDataId(accsRequest.dataId);
        message.W.setServiceId(accsRequest.serviceId);
        NetPerformanceMonitor netPerformanceMonitor2 = message.W;
        URL url = message.f10269f;
        netPerformanceMonitor2.setHost(url != null ? url.toString() : "");
        message.X = bVar.m;
        return message;
    }

    private static void a(com.taobao.accs.net.b bVar, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.f10269f = new URL(bVar.b((String) null));
                return;
            } catch (MalformedURLException e2) {
                ALog.e("Msg", "setUnit", e2, new Object[0]);
                e2.printStackTrace();
                return;
            }
        }
        message.f10269f = url;
    }

    private static void a(com.taobao.accs.net.b bVar, Message message) {
        try {
            message.f10269f = new URL(bVar.b((String) null));
        } catch (Exception e2) {
            ALog.e("Msg", "setControlHost", e2, new Object[0]);
        }
    }

    public static Message a(com.taobao.accs.net.b bVar, String str, String str2, String str3, boolean z, short s, String str4, Map<Integer, String> map) {
        Message message = new Message();
        message.P = 1;
        message.a(s, z);
        message.o = str;
        message.n = str2;
        message.f10273q = str3;
        message.f10266c = true;
        message.r = map;
        try {
            try {
                if (TextUtils.isEmpty(str4)) {
                    message.f10269f = new URL(bVar.b((String) null));
                } else {
                    message.f10269f = new URL(str4);
                }
                message.X = bVar.m;
                if (message.f10269f == null) {
                    message.f10269f = new URL(bVar.b((String) null));
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ALog.e("Msg", "buildPushAck", th, new Object[0]);
                if (message.f10269f == null) {
                    message.f10269f = new URL(bVar.b((String) null));
                }
            } catch (Throwable th2) {
                if (message.f10269f == null) {
                    try {
                        message.f10269f = new URL(bVar.b((String) null));
                    } catch (MalformedURLException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th2;
            }
        }
        return message;
    }

    public static Message a(String str, int i2) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.t = Integer.valueOf(i2);
        message.s = str;
        return message;
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.r = new HashMap();
        if (str5 != null && UtilityImpl.a(str5) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.a(str) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.a(str2) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.a(str6) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.a(str4) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.a(str3) > 1023) {
            return;
        }
        message.r.put(19, str3);
    }

    private void a(int i2, ReqType reqType, int i3) {
        this.p = i2;
        if (i2 != 2) {
            this.k = (short) (((((i2 & 1) << 4) | (reqType.ordinal() << 2)) | i3) << 11);
        }
    }

    private void a(short s, boolean z) {
        this.p = 1;
        this.k = s;
        short s2 = (short) (s & (-16385));
        this.k = s2;
        short s3 = (short) (s2 | 8192);
        this.k = s3;
        short s4 = (short) (s3 & (-2049));
        this.k = s4;
        short s5 = (short) (s4 & (-65));
        this.k = s5;
        if (z) {
            this.k = (short) (s5 | 32);
        }
    }
}
