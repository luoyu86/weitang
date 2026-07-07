package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, String> f9674a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public File f9678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f9679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DexClassLoader f9680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RandomAccessFile f9681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FileLock f9682i;
    public boolean j;
    public final f k;
    public volatile POFactory l;
    public int m;
    public Future<Boolean> n;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f9683q;
    public JSONObject r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f9675b = Executors.newSingleThreadExecutor();
    public boolean o = false;

    public class a implements Callable<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!PM.this.j) {
                PM pm = PM.this;
                pm.j = pm.tryLockUpdate();
            }
            if (PM.f(PM.this)) {
                PM.g(PM.this);
            }
            PM.this.m = (int) (System.currentTimeMillis() - jCurrentTimeMillis);
            return Boolean.TRUE;
        }
    }

    public static class b extends HashMap<Class<?>, String> {
        public b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.f9676c = context.getApplicationContext();
        this.k = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.util.Objects.requireNonNull(r5)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.h()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L44
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L56:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.f(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    public static void g(PM pm) {
        Objects.requireNonNull(pm);
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.f9678e;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (pm.f9677d == null || pm.f9678e == null) {
            pm.f9680g = null;
            return;
        }
        try {
            pm.f9680g = new DexClassLoader(pm.f9678e.getAbsolutePath(), h.a(pm.f9676c).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.k;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.k;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f9683q);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f9677d);
            jSONObject.put("appId", com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.f9676c));
            jSONObject.put("ict", this.m);
            jSONObject.put("mup", this.j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean e() {
        if (!this.j) {
            return false;
        }
        try {
            Context context = this.f9676c;
            com.qq.e.comm.managers.plugin.b.b(context, h.g(context), h.h(this.f9676c));
            this.f9677d = Sig.ASSET_PLUGIN_SIG;
            this.f9678e = h.g(this.f9676c);
            this.f9679f = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.n;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f9680g;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = f9674a.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> clsLoadClass = classLoader.loadClass(str);
            T tCast = cls.cast(clsLoadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(clsLoadClass, this.f9676c, b()));
            GDTLogger.d("ServiceDelegateFactory =" + tCast);
            return tCast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        return getPOFactory(true, false);
    }

    public POFactory getPOFactory(boolean z, boolean z2) throws e {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    try {
                        this.l = (POFactory) getFactory(POFactory.class);
                    } catch (e e2) {
                        if (!this.o) {
                            throw e2;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.p = true;
                        i();
                        this.l = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z && this.l != null) {
            this.l.start(getStartCaller(z2 ? 0 : 2));
        }
        return this.l;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.n;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f9679f;
    }

    public JSONObject getStartCaller(int i2) {
        if (this.r == null) {
            this.r = new JSONObject();
        }
        try {
            this.r.put("scr", i2);
        } catch (JSONException unused) {
        }
        return this.r;
    }

    public final boolean h() {
        if (this.p) {
            return false;
        }
        if (this.j) {
            g gVar = new g(h.e(this.f9676c), h.f(this.f9676c));
            if (gVar.b()) {
                GDTLogger.d("NextExist,Updated=" + gVar.c(h.g(this.f9676c), h.h(this.f9676c)));
            }
        }
        g gVar2 = new g(h.g(this.f9676c), h.h(this.f9676c));
        if (!gVar2.b()) {
            return false;
        }
        if (gVar2.f() >= SDKStatus.getBuildInPluginVersion()) {
            this.f9677d = gVar2.e();
            this.f9679f = gVar2.f();
            this.f9678e = h.g(this.f9676c);
            this.f9683q = gVar2.d();
            this.o = true;
            return true;
        }
        GDTLogger.d("last updated plugin version =" + this.f9679f + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
        return false;
    }

    public final void i() {
        this.o = false;
        SharedPreferences sharedPreferences = this.f9676c.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.p = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
        this.n = this.f9675b.submit(new a());
    }

    public boolean tryLockUpdate() {
        try {
            File fileD = h.d(this.f9676c);
            if (!fileD.exists()) {
                fileD.createNewFile();
                h.c("lock", fileD);
            }
            if (!fileD.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileD, "rw");
            this.f9681h = randomAccessFile;
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            this.f9682i = fileLockTryLock;
            if (fileLockTryLock == null) {
                return false;
            }
            this.f9681h.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
