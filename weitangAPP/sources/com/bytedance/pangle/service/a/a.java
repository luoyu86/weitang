package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f6235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<ComponentName, IBinder> f6237c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<ComponentName, b> f6238d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0108a<Intent> f6239e = new C0108a<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f6240f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashSet<ComponentName> f6241g = new HashSet<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashSet<ComponentName> f6242h = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f6236a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.bytedance.pangle.service.a.a$a, reason: collision with other inner class name */
    public class C0108a<T> extends HashMap<g, T> {
        public C0108a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Iterator<g> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            g next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<g> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (next.a() == ((g) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(next);
        }
    }

    public class b extends HashSet<g> {
        public b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Iterator<g> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            Object obj2 = null;
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (gVar.a() == ((g) obj).a()) {
                    obj2 = gVar;
                    break;
                }
            }
            return super.remove(obj2);
        }
    }

    private a() {
    }

    public static a b() {
        if (f6235b == null) {
            synchronized (a.class) {
                if (f6235b == null) {
                    f6235b = new a();
                }
            }
        }
        return f6235b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f6240f.containsKey(component)) {
            com.bytedance.pangle.service.a aVarD = d(intent, str);
            if (aVarD == null) {
                return component;
            }
            this.f6240f.put(component, aVarD);
            this.f6241g.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.f6240f.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a aVarE = e(intent, str);
        if (aVarE != null) {
            aVarE.onCreate();
        }
        return aVarE;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e2) {
                e = e2;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            zLoadPlugin = false;
        }
    }

    @Override // com.bytedance.pangle.e.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.e
    public final ComponentName a(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(intent, str);
        }
        this.f6236a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.e
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f6236a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (!this.f6240f.containsKey(componentName)) {
            return false;
        }
        this.f6242h.add(componentName);
        return b(componentName);
    }

    private boolean b(ComponentName componentName) {
        if (!this.f6241g.contains(componentName)) {
            if (this.f6238d.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.f6242h.contains(componentName) || this.f6238d.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a aVarRemove = this.f6240f.remove(componentName);
        this.f6242h.remove(componentName);
        this.f6237c.remove(componentName);
        this.f6241g.remove(componentName);
        if (aVarRemove != null) {
            aVarRemove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.e
    public final boolean a(final Intent intent, final g gVar, final int i2, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return a(intent, gVar, str);
        }
        this.f6236a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, gVar, str);
                } catch (RemoteException e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, g gVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f6240f.containsKey(component)) {
            com.bytedance.pangle.service.a aVarD = d(intent, str);
            if (aVarD == null) {
                return false;
            }
            this.f6240f.put(component, aVarD);
        }
        com.bytedance.pangle.service.a aVar = this.f6240f.get(component);
        if (!this.f6237c.containsKey(component)) {
            this.f6237c.put(component, aVar.onBind(intent));
        }
        IBinder iBinder = this.f6237c.get(component);
        if (iBinder != null) {
            if (this.f6238d.containsKey(component)) {
                if (!this.f6238d.get(component).contains(gVar)) {
                    this.f6238d.get(component).add(gVar);
                    this.f6239e.put(gVar, intent);
                    gVar.a(component, iBinder);
                }
            } else {
                b bVar = new b();
                bVar.add(gVar);
                this.f6238d.put(component, bVar);
                this.f6239e.put(gVar, intent);
                gVar.a(component, iBinder);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(g gVar) {
        for (ComponentName componentName : this.f6238d.keySet()) {
            b bVar = this.f6238d.get(componentName);
            if (bVar.contains(gVar)) {
                bVar.remove(gVar);
                Intent intentRemove = this.f6239e.remove(gVar);
                if (bVar.size() == 0) {
                    this.f6238d.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.f6240f.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(intentRemove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.e
    public final void a(final g gVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(gVar);
        } else {
            this.f6236a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(gVar);
                }
            });
        }
    }
}
