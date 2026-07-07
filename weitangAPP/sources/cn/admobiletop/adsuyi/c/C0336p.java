package cn.admobiletop.adsuyi.c;

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
import cn.admobiletop.adsuyi.c.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0336p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f4243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f4244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0337q f4245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, RunnableC0329i> f4246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Object, AbstractC0321a> f4247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, AbstractC0321a> f4248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<Object> f4249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f4250i;
    public final Handler j;
    public final InterfaceC0331k k;
    public final L l;
    public final List<RunnableC0329i> m;
    public final c n;
    public final boolean o;
    public boolean p;

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.p$a */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0336p f4251a;

        public a(Looper looper, C0336p c0336p) {
            super(looper);
            this.f4251a = c0336p;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f4251a.r((AbstractC0321a) message.obj);
                    break;
                case 2:
                    this.f4251a.p((AbstractC0321a) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    A.f4107a.post(new RunnableC0335o(this, message));
                    break;
                case 4:
                    this.f4251a.s((RunnableC0329i) message.obj);
                    break;
                case 5:
                    this.f4251a.u((RunnableC0329i) message.obj);
                    break;
                case 6:
                    this.f4251a.f((RunnableC0329i) message.obj, false);
                    break;
                case 7:
                    this.f4251a.a();
                    break;
                case 9:
                    this.f4251a.k((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.f4251a.o(message.arg1 == 1);
                    break;
                case 11:
                    this.f4251a.g(message.obj);
                    break;
                case 12:
                    this.f4251a.n(message.obj);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.p$b */
    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.p$c */
    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0336p f4252a;

        public c(C0336p c0336p) {
            this.f4252a = c0336p;
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f4252a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f4252a.f4243b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.f4252a.i(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f4252a.b(((ConnectivityManager) S.f(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    public C0336p(Context context, ExecutorService executorService, Handler handler, InterfaceC0337q interfaceC0337q, InterfaceC0331k interfaceC0331k, L l) {
        b bVar = new b();
        this.f4242a = bVar;
        bVar.start();
        S.m(bVar.getLooper());
        this.f4243b = context;
        this.f4244c = executorService;
        this.f4246e = new LinkedHashMap();
        this.f4247f = new WeakHashMap();
        this.f4248g = new WeakHashMap();
        this.f4249h = new HashSet();
        this.f4250i = new a(bVar.getLooper(), this);
        this.f4245d = interfaceC0337q;
        this.j = handler;
        this.k = interfaceC0331k;
        this.l = l;
        this.m = new ArrayList(4);
        this.p = S.x(context);
        this.o = S.t(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar = new c(this);
        this.n = cVar;
        cVar.a();
    }

    public void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        h(arrayList);
    }

    public void b(NetworkInfo networkInfo) {
        Handler handler = this.f4250i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    public void c(AbstractC0321a abstractC0321a) {
        Handler handler = this.f4250i;
        handler.sendMessage(handler.obtainMessage(2, abstractC0321a));
    }

    public void d(AbstractC0321a abstractC0321a, boolean z) {
        if (this.f4249h.contains(abstractC0321a.i())) {
            this.f4248g.put(abstractC0321a.j(), abstractC0321a);
            if (abstractC0321a.f().p) {
                S.p("Dispatcher", "paused", abstractC0321a.f4209b.d(), "because tag '" + abstractC0321a.i() + "' is paused");
                return;
            }
            return;
        }
        RunnableC0329i runnableC0329i = this.f4246e.get(abstractC0321a.c());
        if (runnableC0329i != null) {
            runnableC0329i.f(abstractC0321a);
            return;
        }
        if (this.f4244c.isShutdown()) {
            if (abstractC0321a.f().p) {
                S.p("Dispatcher", "ignored", abstractC0321a.f4209b.d(), "because shut down");
                return;
            }
            return;
        }
        RunnableC0329i runnableC0329iD = RunnableC0329i.d(abstractC0321a.f(), this, this.k, this.l, abstractC0321a);
        runnableC0329iD.r = this.f4244c.submit(runnableC0329iD);
        this.f4246e.put(abstractC0321a.c(), runnableC0329iD);
        if (z) {
            this.f4247f.remove(abstractC0321a.j());
        }
        if (abstractC0321a.f().p) {
            S.o("Dispatcher", "enqueued", abstractC0321a.f4209b.d());
        }
    }

    public void e(RunnableC0329i runnableC0329i) {
        Handler handler = this.f4250i;
        handler.sendMessage(handler.obtainMessage(4, runnableC0329i));
    }

    public void f(RunnableC0329i runnableC0329i, boolean z) {
        if (runnableC0329i.r().p) {
            String strJ = S.j(runnableC0329i);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            S.p("Dispatcher", "batched", strJ, sb.toString());
        }
        this.f4246e.remove(runnableC0329i.o());
        v(runnableC0329i);
    }

    public void g(Object obj) {
        if (this.f4249h.add(obj)) {
            Iterator<RunnableC0329i> it = this.f4246e.values().iterator();
            while (it.hasNext()) {
                RunnableC0329i next = it.next();
                boolean z = next.r().p;
                AbstractC0321a abstractC0321aJ = next.j();
                List<AbstractC0321a> listL = next.l();
                boolean z2 = (listL == null || listL.isEmpty()) ? false : true;
                if (abstractC0321aJ != null || z2) {
                    if (abstractC0321aJ != null && abstractC0321aJ.i().equals(obj)) {
                        next.k(abstractC0321aJ);
                        this.f4248g.put(abstractC0321aJ.j(), abstractC0321aJ);
                        if (z) {
                            S.p("Dispatcher", "paused", abstractC0321aJ.f4209b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listL.size() - 1; size >= 0; size--) {
                            AbstractC0321a abstractC0321a = listL.get(size);
                            if (abstractC0321a.i().equals(obj)) {
                                next.k(abstractC0321a);
                                this.f4248g.put(abstractC0321a.j(), abstractC0321a);
                                if (z) {
                                    S.p("Dispatcher", "paused", abstractC0321a.f4209b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.g()) {
                        it.remove();
                        if (z) {
                            S.p("Dispatcher", "canceled", S.j(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    public final void h(List<RunnableC0329i> list) {
        if (list == null || list.isEmpty() || !list.get(0).r().p) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (RunnableC0329i runnableC0329i : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(S.j(runnableC0329i));
        }
        S.o("Dispatcher", "delivered", sb.toString());
    }

    public void i(boolean z) {
        Handler handler = this.f4250i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    public final void j() {
        if (this.f4247f.isEmpty()) {
            return;
        }
        Iterator<AbstractC0321a> it = this.f4247f.values().iterator();
        while (it.hasNext()) {
            AbstractC0321a next = it.next();
            it.remove();
            if (next.f().p) {
                S.o("Dispatcher", "replaying", next.h().d());
            }
            d(next, false);
        }
    }

    public void k(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f4244c;
        if (executorService instanceof E) {
            ((E) executorService).b(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        j();
    }

    public void l(AbstractC0321a abstractC0321a) {
        Handler handler = this.f4250i;
        handler.sendMessage(handler.obtainMessage(1, abstractC0321a));
    }

    public void m(RunnableC0329i runnableC0329i) {
        Handler handler = this.f4250i;
        handler.sendMessage(handler.obtainMessage(6, runnableC0329i));
    }

    public void n(Object obj) {
        if (this.f4249h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<AbstractC0321a> it = this.f4248g.values().iterator();
            while (it.hasNext()) {
                AbstractC0321a next = it.next();
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

    public void o(boolean z) {
        this.p = z;
    }

    public void p(AbstractC0321a abstractC0321a) {
        String strC = abstractC0321a.c();
        RunnableC0329i runnableC0329i = this.f4246e.get(strC);
        if (runnableC0329i != null) {
            runnableC0329i.k(abstractC0321a);
            if (runnableC0329i.g()) {
                this.f4246e.remove(strC);
                if (abstractC0321a.f().p) {
                    S.o("Dispatcher", "canceled", abstractC0321a.h().d());
                }
            }
        }
        if (this.f4249h.contains(abstractC0321a.i())) {
            this.f4248g.remove(abstractC0321a.j());
            if (abstractC0321a.f().p) {
                S.p("Dispatcher", "canceled", abstractC0321a.h().d(), "because paused request got canceled");
            }
        }
        AbstractC0321a abstractC0321aRemove = this.f4247f.remove(abstractC0321a.j());
        if (abstractC0321aRemove == null || !abstractC0321aRemove.f().p) {
            return;
        }
        S.p("Dispatcher", "canceled", abstractC0321aRemove.h().d(), "from replaying");
    }

    public void q(RunnableC0329i runnableC0329i) {
        Handler handler = this.f4250i;
        handler.sendMessageDelayed(handler.obtainMessage(5, runnableC0329i), 500L);
    }

    public void r(AbstractC0321a abstractC0321a) {
        d(abstractC0321a, true);
    }

    public void s(RunnableC0329i runnableC0329i) {
        if (w.b(runnableC0329i.q())) {
            this.k.a(runnableC0329i.o(), runnableC0329i.t());
        }
        this.f4246e.remove(runnableC0329i.o());
        v(runnableC0329i);
        if (runnableC0329i.r().p) {
            S.p("Dispatcher", "batched", S.j(runnableC0329i), "for completion");
        }
    }

    public final void t(AbstractC0321a abstractC0321a) {
        Object objJ = abstractC0321a.j();
        if (objJ != null) {
            abstractC0321a.k = true;
            this.f4247f.put(objJ, abstractC0321a);
        }
    }

    public void u(RunnableC0329i runnableC0329i) {
        if (runnableC0329i.v()) {
            return;
        }
        boolean z = false;
        if (this.f4244c.isShutdown()) {
            f(runnableC0329i, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) S.f(this.f4243b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zI = runnableC0329i.i(this.p, activeNetworkInfo);
        boolean zW = runnableC0329i.w();
        if (!zI) {
            if (this.o && zW) {
                z = true;
            }
            f(runnableC0329i, z);
            if (z) {
                w(runnableC0329i);
                return;
            }
            return;
        }
        if (this.o && !z2) {
            f(runnableC0329i, zW);
            if (zW) {
                w(runnableC0329i);
                return;
            }
            return;
        }
        if (runnableC0329i.r().p) {
            S.o("Dispatcher", "retrying", S.j(runnableC0329i));
        }
        if (runnableC0329i.n() instanceof y.a) {
            runnableC0329i.m |= x.NO_CACHE.f4287e;
        }
        runnableC0329i.r = this.f4244c.submit(runnableC0329i);
    }

    public final void v(RunnableC0329i runnableC0329i) {
        if (runnableC0329i.v()) {
            return;
        }
        this.m.add(runnableC0329i);
        if (this.f4250i.hasMessages(7)) {
            return;
        }
        this.f4250i.sendEmptyMessageDelayed(7, 200L);
    }

    public final void w(RunnableC0329i runnableC0329i) {
        AbstractC0321a abstractC0321aJ = runnableC0329i.j();
        if (abstractC0321aJ != null) {
            t(abstractC0321aJ);
        }
        List<AbstractC0321a> listL = runnableC0329i.l();
        if (listL != null) {
            int size = listL.size();
            for (int i2 = 0; i2 < size; i2++) {
                t(listL.get(i2));
            }
        }
    }
}
