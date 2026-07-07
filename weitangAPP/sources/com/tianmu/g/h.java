package com.tianmu.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tianmu.g.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f12070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f12071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, com.tianmu.g.c> f12072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Object, com.tianmu.g.a> f12073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, com.tianmu.g.a> f12074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<Object> f12075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f12076i;
    public final Handler j;
    public final d k;
    public final z l;
    public final List<com.tianmu.g.c> m;
    public final c n;
    public final boolean o;
    public boolean p;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f12077a;

        /* JADX INFO: renamed from: com.tianmu.g.h$a$a, reason: collision with other inner class name */
        public class RunnableC0223a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Message f12078a;

            public RunnableC0223a(a aVar, Message message) {
                this.f12078a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f12078a.what);
            }
        }

        public a(Looper looper, h hVar) {
            super(looper);
            this.f12077a = hVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f12077a.d((com.tianmu.g.a) message.obj);
                    break;
                case 2:
                    this.f12077a.c((com.tianmu.g.a) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    r.p.post(new RunnableC0223a(this, message));
                    break;
                case 4:
                    this.f12077a.d((com.tianmu.g.c) message.obj);
                    break;
                case 5:
                    this.f12077a.e((com.tianmu.g.c) message.obj);
                    break;
                case 6:
                    this.f12077a.a((com.tianmu.g.c) message.obj, false);
                    break;
                case 7:
                    this.f12077a.a();
                    break;
                case 9:
                    this.f12077a.b((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.f12077a.b(message.arg1 == 1);
                    break;
                case 11:
                    this.f12077a.a(message.obj);
                    break;
                case 12:
                    this.f12077a.b(message.obj);
                    break;
            }
        }
    }

    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f12079a;

        public c(h hVar) {
            this.f12079a = hVar;
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f12079a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f12079a.f12069b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.f12079a.a(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f12079a.a(((ConnectivityManager) f0.a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    public h(Context context, ExecutorService executorService, Handler handler, i iVar, d dVar, z zVar) {
        b bVar = new b();
        this.f12068a = bVar;
        bVar.start();
        f0.a(bVar.getLooper());
        this.f12069b = context;
        this.f12070c = executorService;
        this.f12072e = new LinkedHashMap();
        this.f12073f = new WeakHashMap();
        this.f12074g = new WeakHashMap();
        this.f12075h = new HashSet();
        this.f12076i = new a(bVar.getLooper(), this);
        this.f12071d = iVar;
        this.j = handler;
        this.k = dVar;
        this.l = zVar;
        this.m = new ArrayList(4);
        this.p = f0.d(context);
        this.o = f0.b(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar = new c(this);
        this.n = cVar;
        cVar.a();
    }

    private void f(com.tianmu.g.c cVar) {
        if (cVar.m()) {
            return;
        }
        this.m.add(cVar);
        if (this.f12076i.hasMessages(7)) {
            return;
        }
        this.f12076i.sendEmptyMessageDelayed(7, 200L);
    }

    private void g(com.tianmu.g.c cVar) {
        com.tianmu.g.a aVarB = cVar.b();
        if (aVarB != null) {
            e(aVarB);
        }
        List<com.tianmu.g.a> listC = cVar.c();
        if (listC != null) {
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                e(listC.get(i2));
            }
        }
    }

    public void a(com.tianmu.g.a aVar) {
        Handler handler = this.f12076i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    public void b(com.tianmu.g.a aVar) {
        Handler handler = this.f12076i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    public void c(com.tianmu.g.c cVar) {
        Handler handler = this.f12076i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500L);
    }

    public void d(com.tianmu.g.a aVar) {
        a(aVar, true);
    }

    public void e(com.tianmu.g.c cVar) {
        if (cVar.m()) {
            return;
        }
        boolean z = false;
        if (this.f12070c.isShutdown()) {
            a(cVar, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) f0.a(this.f12069b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zA = cVar.a(this.p, activeNetworkInfo);
        boolean zN = cVar.n();
        if (!zA) {
            if (this.o && zN) {
                z = true;
            }
            a(cVar, z);
            if (z) {
                g(cVar);
                return;
            }
            return;
        }
        if (this.o && !z2) {
            a(cVar, zN);
            if (zN) {
                g(cVar);
                return;
            }
            return;
        }
        if (cVar.i().n) {
            f0.a("Dispatcher", "retrying", f0.a(cVar));
        }
        if (cVar.e() instanceof q.a) {
            cVar.f12052i |= p.f12108b.f12111a;
        }
        cVar.n = this.f12070c.submit(cVar);
    }

    public void a(com.tianmu.g.c cVar) {
        Handler handler = this.f12076i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    public void b(com.tianmu.g.c cVar) {
        Handler handler = this.f12076i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    public void c(com.tianmu.g.a aVar) {
        String strC = aVar.c();
        com.tianmu.g.c cVar = this.f12072e.get(strC);
        if (cVar != null) {
            cVar.b(aVar);
            if (cVar.a()) {
                this.f12072e.remove(strC);
                if (aVar.f().n) {
                    f0.a("Dispatcher", "canceled", aVar.h().d());
                }
            }
        }
        if (this.f12075h.contains(aVar.i())) {
            this.f12074g.remove(aVar.j());
            if (aVar.f().n) {
                f0.a("Dispatcher", "canceled", aVar.h().d(), "because paused request got canceled");
            }
        }
        com.tianmu.g.a aVarRemove = this.f12073f.remove(aVar.j());
        if (aVarRemove == null || !aVarRemove.f().n) {
            return;
        }
        f0.a("Dispatcher", "canceled", aVarRemove.h().d(), "from replaying");
    }

    public void d(com.tianmu.g.c cVar) {
        if (o.b(cVar.h())) {
            this.k.a(cVar.f(), cVar.k());
        }
        this.f12072e.remove(cVar.f());
        f(cVar);
        if (cVar.i().n) {
            f0.a("Dispatcher", "batched", f0.a(cVar), "for completion");
        }
    }

    public void a(NetworkInfo networkInfo) {
        Handler handler = this.f12076i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    public void b(Object obj) {
        if (this.f12075h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<com.tianmu.g.a> it = this.f12074g.values().iterator();
            while (it.hasNext()) {
                com.tianmu.g.a next = it.next();
                if (next.i().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    public void a(boolean z) {
        Handler handler = this.f12076i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    public void a(com.tianmu.g.a aVar, boolean z) {
        if (this.f12075h.contains(aVar.i())) {
            this.f12074g.put(aVar.j(), aVar);
            if (aVar.f().n) {
                f0.a("Dispatcher", "paused", aVar.f12024b.d(), "because tag '" + aVar.i() + "' is paused");
                return;
            }
            return;
        }
        com.tianmu.g.c cVar = this.f12072e.get(aVar.c());
        if (cVar != null) {
            cVar.a(aVar);
            return;
        }
        if (this.f12070c.isShutdown()) {
            if (aVar.f().n) {
                f0.a("Dispatcher", "ignored", aVar.f12024b.d(), "because shut down");
                return;
            }
            return;
        }
        com.tianmu.g.c cVarA = com.tianmu.g.c.a(aVar.f(), this, this.k, this.l, aVar);
        cVarA.n = this.f12070c.submit(cVarA);
        this.f12072e.put(aVar.c(), cVarA);
        if (z) {
            this.f12073f.remove(aVar.j());
        }
        if (aVar.f().n) {
            f0.a("Dispatcher", "enqueued", aVar.f12024b.d());
        }
    }

    public void b(boolean z) {
        this.p = z;
    }

    public void b(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f12070c;
        if (executorService instanceof t) {
            ((t) executorService).a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        b();
    }

    private void b() {
        if (this.f12073f.isEmpty()) {
            return;
        }
        Iterator<com.tianmu.g.a> it = this.f12073f.values().iterator();
        while (it.hasNext()) {
            com.tianmu.g.a next = it.next();
            it.remove();
            if (next.f().n) {
                f0.a("Dispatcher", "replaying", next.h().d());
            }
            a(next, false);
        }
    }

    private void e(com.tianmu.g.a aVar) {
        Object objJ = aVar.j();
        if (objJ != null) {
            aVar.k = true;
            this.f12073f.put(objJ, aVar);
        }
    }

    public void a(Object obj) {
        if (this.f12075h.add(obj)) {
            Iterator<com.tianmu.g.c> it = this.f12072e.values().iterator();
            while (it.hasNext()) {
                com.tianmu.g.c next = it.next();
                boolean z = next.i().n;
                com.tianmu.g.a aVarB = next.b();
                List<com.tianmu.g.a> listC = next.c();
                boolean z2 = (listC == null || listC.isEmpty()) ? false : true;
                if (aVarB != null || z2) {
                    if (aVarB != null && aVarB.i().equals(obj)) {
                        next.b(aVarB);
                        this.f12074g.put(aVarB.j(), aVarB);
                        if (z) {
                            f0.a("Dispatcher", "paused", aVarB.f12024b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listC.size() - 1; size >= 0; size--) {
                            com.tianmu.g.a aVar = listC.get(size);
                            if (aVar.i().equals(obj)) {
                                next.b(aVar);
                                this.f12074g.put(aVar.j(), aVar);
                                if (z) {
                                    f0.a("Dispatcher", "paused", aVar.f12024b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.a()) {
                        it.remove();
                        if (z) {
                            f0.a("Dispatcher", "canceled", f0.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    public void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        a((List<com.tianmu.g.c>) arrayList);
    }

    public void a(com.tianmu.g.c cVar, boolean z) {
        if (cVar.i().n) {
            String strA = f0.a(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            f0.a("Dispatcher", "batched", strA, sb.toString());
        }
        this.f12072e.remove(cVar.f());
        f(cVar);
    }

    private void a(List<com.tianmu.g.c> list) {
        if (list == null || list.isEmpty() || !list.get(0).i().n) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (com.tianmu.g.c cVar : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(f0.a(cVar));
        }
        f0.a("Dispatcher", "delivered", sb.toString());
    }
}
