package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f5032b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.c f130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f132a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private ExecutorService f135b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.a f131a = new com.alibaba.sdk.android.utils.crashdefend.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final List<c> f133a = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f5034e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int[] f134a = new int[5];

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f5035a;

        public a(d dVar) {
            this.f5035a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            int i2;
            do {
                try {
                    Thread.sleep(1000L);
                    dVar = this.f5035a;
                    i2 = dVar.f5042d - 1;
                    dVar.f5042d = i2;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    Log.d("UtilsSDK", e2.getMessage(), e2);
                }
            } while (i2 > 0);
            if (i2 <= 0) {
                b.this.b(dVar.f5041b);
                e.a(b.this.f5033a, b.this.f131a, (List<c>) b.this.f133a);
                return;
            }
            return;
        }
    }

    private b(Context context, com.alibaba.sdk.android.utils.c cVar) {
        this.f135b = null;
        this.f5033a = context;
        this.f130a = cVar;
        this.f135b = new f().a();
        for (int i2 = 0; i2 < 5; i2++) {
            this.f134a[i2] = (i2 * 5) + 5;
        }
        this.f5034e.put("sdkId", "utils");
        this.f5034e.put(Constants.KEY_SDK_VERSION, "1.1.4");
        try {
            a();
            b();
        } catch (Exception e2) {
            Log.d("UtilsSDK", e2.getMessage(), e2);
        }
    }

    private void b() {
        this.f132a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f133a) {
            for (c cVar : this.f133a) {
                if (cVar.crashCount >= cVar.f5037a) {
                    arrayList.add(cVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar2 = (c) it.next();
                int i2 = cVar2.f5039c;
                if (i2 < 5) {
                    if (cVar2.f136a < this.f131a.f5031a - ((long) this.f134a[i2])) {
                        this.f132a = cVar2;
                        break;
                    }
                } else {
                    Log.i("UtilsSDK", "SDK " + cVar2.f138a + " has been closed");
                }
            }
            c cVar3 = this.f132a;
            if (cVar3 == null) {
                Log.i("UtilsSDK", "NO SDK restore");
            } else {
                cVar3.f5039c++;
                Log.i("UtilsSDK", this.f132a.f138a + " will restore --- startSerialNumber:" + this.f132a.f136a + "   crashCount:" + this.f132a.crashCount);
            }
        }
    }

    public void d(String str, String str2) {
    }

    public static synchronized b a(Context context, com.alibaba.sdk.android.utils.c cVar) {
        if (f5032b == null) {
            f5032b = new b(context, cVar);
        }
        return f5032b;
    }

    private void a() {
        if (e.m63a(this.f5033a, this.f131a, this.f133a)) {
            this.f131a.f5031a++;
        } else {
            this.f131a.f5031a = 1L;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m61a(c cVar, SDKMessageCallback sDKMessageCallback) {
        c cVarA;
        if (cVar != null && sDKMessageCallback != null) {
            try {
                if (TextUtils.isEmpty(cVar.f140b) || TextUtils.isEmpty(cVar.f138a) || (cVarA = a(cVar, sDKMessageCallback)) == null) {
                    return false;
                }
                boolean zM60a = m60a(cVarA);
                int i2 = cVarA.crashCount;
                int i3 = cVarA.f5037a;
                if (i2 == i3) {
                    a(cVarA.f138a, cVarA.f140b, i2, i3);
                }
                cVarA.crashCount++;
                e.a(this.f5033a, this.f131a, this.f133a);
                if (zM60a) {
                    a(cVarA);
                    Log.i("UtilsSDK", "START:" + cVarA.f138a + " --- limit:" + cVarA.f5037a + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f5039c + "  startSerialNumber:" + cVarA.f136a + "  registerSerialNumber:" + cVarA.f139b);
                } else {
                    sDKMessageCallback.crashDefendMessage(cVarA.f5037a, cVarA.crashCount - 1);
                    Log.i("UtilsSDK", "STOP:" + cVarA.f138a + " --- limit:" + cVarA.f5037a + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f5039c + "  startSerialNumber:" + cVarA.f136a + "  registerSerialNumber:" + cVarA.f139b);
                }
                return true;
            } catch (Exception e2) {
                Log.d("UtilsSDK", e2.getMessage(), e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        int i2 = cVar.f5039c;
        if (i2 > 0) {
            b(cVar.f138a, cVar.f140b, i2, 5);
        }
        cVar.crashCount = 0;
        cVar.f5039c = 0;
    }

    private void b(String str, String str2, int i2, int i3) {
        if (this.f130a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f5034e);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("recoverCount", String.valueOf(i2));
        map.put("recoverThreshold", String.valueOf(i3));
        this.f130a.sendCustomHit("utils_biz_recover", 0L, map);
    }

    private c a(c cVar, SDKMessageCallback sDKMessageCallback) {
        synchronized (this.f133a) {
            List<c> list = this.f133a;
            c cVar2 = null;
            if (list != null && list.size() > 0) {
                Iterator<c> it = this.f133a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && next.f138a.equals(cVar.f138a)) {
                        if (!next.f140b.equals(cVar.f140b)) {
                            next.f140b = cVar.f140b;
                            next.f5037a = cVar.f5037a;
                            next.f5038b = cVar.f5038b;
                            next.crashCount = 0;
                            next.f5039c = 0;
                        }
                        if (next.f5040d) {
                            Log.i("UtilsSDK", "SDK " + cVar.f138a + " has been registered");
                            return null;
                        }
                        next.f5040d = true;
                        next.f137a = sDKMessageCallback;
                        next.f139b = this.f131a.f5031a;
                        cVar2 = next;
                    }
                }
            }
            if (cVar2 == null) {
                cVar2 = (c) cVar.clone();
                cVar2.f5040d = true;
                cVar2.f137a = sDKMessageCallback;
                cVar2.crashCount = 0;
                cVar2.f139b = this.f131a.f5031a;
                this.f133a.add(cVar2);
            }
            return cVar2;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m60a(c cVar) {
        if (cVar.crashCount < cVar.f5037a) {
            cVar.f136a = cVar.f139b;
            return true;
        }
        c cVar2 = this.f132a;
        if (cVar2 == null || !cVar2.f138a.equals(cVar.f138a)) {
            return false;
        }
        cVar.crashCount = cVar.f5037a - 1;
        cVar.f136a = cVar.f139b;
        return true;
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d dVar = new d();
        dVar.f5041b = cVar;
        dVar.f5042d = cVar.f5038b;
        a(dVar);
        SDKMessageCallback sDKMessageCallback = cVar.f137a;
        if (sDKMessageCallback != null) {
            sDKMessageCallback.crashDefendMessage(cVar.f5037a, cVar.crashCount - 1);
        }
    }

    private void a(d dVar) {
        if (dVar == null || dVar.f5041b == null) {
            return;
        }
        this.f135b.execute(new a(dVar));
    }

    private void a(String str, String str2, int i2, int i3) {
        if (this.f130a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f5034e);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("curCrashCount", String.valueOf(i2));
        map.put("crashThreshold", String.valueOf(i3));
        this.f130a.sendCustomHit("utils_biz_crash", 0L, map);
    }
}
