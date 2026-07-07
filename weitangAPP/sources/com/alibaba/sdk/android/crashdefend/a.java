package com.alibaba.sdk.android.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.crashdefend.a.b;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f4622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f4623b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f4625d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.alibaba.sdk.android.crashdefend.a.a f4624c = new com.alibaba.sdk.android.crashdefend.a.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, String> f4627f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f4628g = new int[5];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<b> f4629h = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExecutorService f4626e = new com.alibaba.sdk.android.crashdefend.b.a().a();

    /* JADX INFO: renamed from: com.alibaba.sdk.android.crashdefend.a$a, reason: collision with other inner class name */
    public class RunnableC0058a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f4631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4632c;

        public RunnableC0058a(b bVar, int i2) {
            this.f4631b = bVar;
            this.f4632c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            do {
                try {
                    Thread.sleep(1000L);
                    i2 = this.f4632c - 1;
                    this.f4632c = i2;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    Log.d("CrashDefend", e2.getMessage(), e2);
                }
            } while (i2 > 0);
            if (i2 <= 0) {
                a.this.c(this.f4631b);
                com.alibaba.sdk.android.crashdefend.c.a.a(a.this.f4623b, a.this.f4624c, a.this.f4629h);
                return;
            }
            return;
        }
    }

    private a(Context context) {
        this.f4623b = context.getApplicationContext();
        for (int i2 = 0; i2 < 5; i2++) {
            this.f4628g[i2] = (i2 * 5) + 5;
        }
        this.f4627f.put("sdkId", "crashdefend");
        this.f4627f.put(Constants.KEY_SDK_VERSION, "0.0.6");
        try {
            a();
            b();
        } catch (Exception e2) {
            Log.d("CrashDefend", e2.getMessage(), e2);
        }
    }

    public static a a(Context context) {
        if (f4622a == null) {
            synchronized (a.class) {
                if (f4622a == null) {
                    f4622a = new a(context);
                }
            }
        }
        return f4622a;
    }

    private void a() {
        if (!com.alibaba.sdk.android.crashdefend.c.a.b(this.f4623b, this.f4624c, this.f4629h)) {
            this.f4624c.f4633a = 1L;
        } else {
            this.f4624c.f4633a++;
        }
    }

    private boolean a(b bVar) {
        if (bVar.f4637d >= bVar.f4636c) {
            b bVar2 = this.f4625d;
            if (bVar2 == null || !bVar2.f4634a.equals(bVar.f4634a)) {
                return false;
            }
            bVar.f4637d = bVar.f4636c - 1;
        }
        bVar.f4640g = bVar.f4639f;
        return true;
    }

    private boolean a(b bVar, CrashDefendCallback crashDefendCallback) {
        b bVarB;
        String str;
        if (bVar != null && crashDefendCallback != null) {
            try {
                if (TextUtils.isEmpty(bVar.f4635b) || TextUtils.isEmpty(bVar.f4634a) || (bVarB = b(bVar, crashDefendCallback)) == null) {
                    return false;
                }
                boolean zA = a(bVarB);
                bVarB.f4637d++;
                com.alibaba.sdk.android.crashdefend.c.a.a(this.f4623b, this.f4624c, this.f4629h);
                if (zA) {
                    b(bVarB);
                    str = "START:" + bVarB.f4634a + " --- limit:" + bVarB.f4636c + "  count:" + (bVarB.f4637d - 1) + "  restore:" + bVarB.f4641h + "  startSerialNumber:" + bVarB.f4640g + "  registerSerialNumber:" + bVarB.f4639f;
                } else {
                    int i2 = bVarB.f4641h;
                    if (i2 >= 5) {
                        crashDefendCallback.onSdkClosed(i2);
                        str = "CLOSED: " + bVarB.f4634a + " --- restored " + bVarB.f4641h + ", has more than retry limit, so closed it";
                    } else {
                        crashDefendCallback.onSdkStop(bVarB.f4636c, bVarB.f4637d - 1, i2, bVarB.f4642i);
                        str = "STOP:" + bVarB.f4634a + " --- limit:" + bVarB.f4636c + "  count:" + (bVarB.f4637d - 1) + "  restore:" + bVarB.f4641h + "  startSerialNumber:" + bVarB.f4640g + "  registerSerialNumber:" + bVarB.f4639f;
                    }
                }
                com.alibaba.sdk.android.crashdefend.c.b.b("CrashDefend", str);
                return true;
            } catch (Exception e2) {
                Log.d("CrashDefend", e2.getMessage(), e2);
            }
        }
        return false;
    }

    private synchronized b b(b bVar, CrashDefendCallback crashDefendCallback) {
        b bVar2 = null;
        if (this.f4629h.size() > 0) {
            Iterator<b> it = this.f4629h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.f4634a.equals(bVar.f4634a)) {
                    if (!next.f4635b.equals(bVar.f4635b)) {
                        next.f4635b = bVar.f4635b;
                        next.f4636c = bVar.f4636c;
                        next.f4638e = bVar.f4638e;
                        next.f4637d = 0;
                        next.f4641h = 0;
                        next.f4642i = 0L;
                    }
                    if (next.j) {
                        com.alibaba.sdk.android.crashdefend.c.b.b("CrashDefend", "SDK " + bVar.f4634a + " has been registered");
                        return null;
                    }
                    next.j = true;
                    next.k = crashDefendCallback;
                    next.f4639f = this.f4624c.f4633a;
                    bVar2 = next;
                }
            }
        }
        if (bVar2 == null) {
            bVar2 = (b) bVar.clone();
            bVar2.j = true;
            bVar2.k = crashDefendCallback;
            bVar2.f4637d = 0;
            bVar2.f4639f = this.f4624c.f4633a;
            this.f4629h.add(bVar2);
        }
        return bVar2;
    }

    private void b() {
        String str;
        String str2;
        this.f4625d = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f4629h) {
            for (b bVar : this.f4629h) {
                if (bVar.f4637d >= bVar.f4636c) {
                    arrayList.add(bVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b bVar2 = (b) it.next();
                int i2 = bVar2.f4641h;
                if (i2 < 5) {
                    long j = this.f4624c.f4633a - ((long) this.f4628g[i2]);
                    long j2 = (bVar2.f4640g - j) + 1;
                    com.alibaba.sdk.android.crashdefend.c.b.a("CrashDefend", "after restart " + j2 + " times, sdk will be restore");
                    bVar2.f4642i = j2;
                    if (bVar2.f4640g < j) {
                        this.f4625d = bVar2;
                        break;
                    }
                } else {
                    com.alibaba.sdk.android.crashdefend.c.b.b("CrashDefend", "SDK " + bVar2.f4634a + " has been closed");
                }
            }
            b bVar3 = this.f4625d;
            if (bVar3 == null) {
                str = "CrashDefend";
                str2 = "NO SDK restore";
            } else {
                bVar3.f4641h++;
                str = "CrashDefend";
                str2 = this.f4625d.f4634a + " will restore --- startSerialNumber:" + this.f4625d.f4640g + "   crashCount:" + this.f4625d.f4637d;
            }
            com.alibaba.sdk.android.crashdefend.c.b.b(str, str2);
        }
    }

    private void b(b bVar) {
        if (bVar == null) {
            return;
        }
        d(bVar);
        CrashDefendCallback crashDefendCallback = bVar.k;
        if (crashDefendCallback != null) {
            crashDefendCallback.onSdkStart(bVar.f4636c, bVar.f4637d - 1, bVar.f4641h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.f4637d = 0;
        bVar.f4641h = 0;
    }

    private void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f4626e.execute(new RunnableC0058a(bVar, bVar.f4638e));
    }

    public boolean a(String str, String str2, int i2, int i3, CrashDefendCallback crashDefendCallback) {
        b bVar = new b();
        bVar.f4634a = str;
        bVar.f4635b = str2;
        bVar.f4636c = i2;
        bVar.f4638e = i3;
        return a(bVar, crashDefendCallback);
    }
}
