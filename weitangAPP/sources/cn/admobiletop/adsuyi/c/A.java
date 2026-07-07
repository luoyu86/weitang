package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import cn.admobiletop.adsuyi.c.AbstractC0321a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f4107a = new z(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile A f4108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f4109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f4110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f4111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<I> f4112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f4113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0336p f4114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC0331k f4115i;
    public final L j;
    public final Map<Object, AbstractC0321a> k;
    public final Map<ImageView, ViewTreeObserverOnPreDrawListenerC0334n> l;
    public final ReferenceQueue<Object> m;
    public final Bitmap.Config n;
    public boolean o;
    public volatile boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4116q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f4117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0337q f4118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ExecutorService f4119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public InterfaceC0331k f4120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f4121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f f4122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<I> f4123g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Bitmap.Config f4124h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f4125i;
        public boolean j;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f4117a = context.getApplicationContext();
        }

        public A a() {
            Context context = this.f4117a;
            if (this.f4118b == null) {
                this.f4118b = S.v(context);
            }
            if (this.f4120d == null) {
                this.f4120d = new t(context);
            }
            if (this.f4119c == null) {
                this.f4119c = new E();
            }
            if (this.f4122f == null) {
                this.f4122f = f.f4137a;
            }
            L l = new L(this.f4120d);
            return new A(context, new C0336p(context, this.f4119c, A.f4107a, this.f4118b, this.f4120d, l), this.f4120d, this.f4121e, this.f4122f, this.f4123g, l, this.f4124h, this.f4125i, this.j);
        }
    }

    public static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue<Object> f4126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f4127b;

        public b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f4126a = referenceQueue;
            this.f4127b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    AbstractC0321a.C0051a c0051a = (AbstractC0321a.C0051a) this.f4126a.remove(1000L);
                    Message messageObtainMessage = this.f4127b.obtainMessage();
                    if (c0051a != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = c0051a.f4217a;
                        this.f4127b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f4127b.post(new B(this, e2));
                    return;
                }
            }
        }
    }

    public interface c {
        void a(A a2, Uri uri, Exception exc);
    }

    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4132e;

        d(int i2) {
            this.f4132e = i2;
        }
    }

    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f4137a = new C();

        G a(G g2);
    }

    public A(Context context, C0336p c0336p, InterfaceC0331k interfaceC0331k, c cVar, f fVar, List<I> list, L l, Bitmap.Config config, boolean z, boolean z2) {
        this.f4113g = context;
        this.f4114h = c0336p;
        this.f4115i = interfaceC0331k;
        this.f4109c = cVar;
        this.f4110d = fVar;
        this.n = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 6);
        arrayList.add(new J(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new v(context));
        arrayList.add(new C0333m(context));
        arrayList.add(new C0322b(context));
        arrayList.add(new r(context));
        arrayList.add(new y(c0336p.f4245d, l));
        this.f4112f = Collections.unmodifiableList(arrayList);
        this.j = l;
        this.k = new WeakHashMap();
        this.l = new WeakHashMap();
        this.o = z;
        this.p = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.m = referenceQueue;
        b bVar = new b(referenceQueue, f4107a);
        this.f4111e = bVar;
        bVar.start();
    }

    public void a(ImageView imageView) {
        i(imageView);
    }

    public G b(G g2) {
        G gA = this.f4110d.a(g2);
        if (gA != null) {
            return gA;
        }
        throw new IllegalStateException("Request transformer " + this.f4110d.getClass().getCanonicalName() + " returned null for " + g2);
    }

    public List<I> c() {
        return this.f4112f;
    }

    public final void d(Bitmap bitmap, d dVar, AbstractC0321a abstractC0321a) {
        if (abstractC0321a.k()) {
            return;
        }
        if (!abstractC0321a.l()) {
            this.k.remove(abstractC0321a.j());
        }
        if (bitmap == null) {
            abstractC0321a.b();
            if (this.p) {
                S.o("Main", "errored", abstractC0321a.f4209b.d());
                return;
            }
            return;
        }
        if (dVar == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        abstractC0321a.a(bitmap, dVar);
        if (this.p) {
            S.p("Main", "completed", abstractC0321a.f4209b.d(), "from " + dVar);
        }
    }

    public void e(ImageView imageView, ViewTreeObserverOnPreDrawListenerC0334n viewTreeObserverOnPreDrawListenerC0334n) {
        this.l.put(imageView, viewTreeObserverOnPreDrawListenerC0334n);
    }

    public void g(AbstractC0321a abstractC0321a) {
        Object objJ = abstractC0321a.j();
        if (objJ != null && this.k.get(objJ) != abstractC0321a) {
            i(objJ);
            this.k.put(objJ, abstractC0321a);
        }
        l(abstractC0321a);
    }

    public void h(RunnableC0329i runnableC0329i) {
        AbstractC0321a abstractC0321aJ = runnableC0329i.j();
        List<AbstractC0321a> listL = runnableC0329i.l();
        boolean z = true;
        boolean z2 = (listL == null || listL.isEmpty()) ? false : true;
        if (abstractC0321aJ == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = runnableC0329i.m().f4153e;
            Exception excN = runnableC0329i.n();
            Bitmap bitmapT = runnableC0329i.t();
            d dVarP = runnableC0329i.p();
            if (abstractC0321aJ != null) {
                d(bitmapT, dVarP, abstractC0321aJ);
            }
            if (z2) {
                int size = listL.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d(bitmapT, dVarP, listL.get(i2));
                }
            }
            c cVar = this.f4109c;
            if (cVar == null || excN == null) {
                return;
            }
            cVar.a(this, uri, excN);
        }
    }

    public final void i(Object obj) {
        S.l();
        AbstractC0321a abstractC0321aRemove = this.k.remove(obj);
        if (abstractC0321aRemove != null) {
            abstractC0321aRemove.a();
            this.f4114h.c(abstractC0321aRemove);
        }
        if (obj instanceof ImageView) {
            ViewTreeObserverOnPreDrawListenerC0334n viewTreeObserverOnPreDrawListenerC0334nRemove = this.l.remove((ImageView) obj);
            if (viewTreeObserverOnPreDrawListenerC0334nRemove != null) {
                viewTreeObserverOnPreDrawListenerC0334nRemove.a();
            }
        }
    }

    public Bitmap j(String str) {
        Bitmap bitmapA = this.f4115i.a(str);
        if (bitmapA != null) {
            this.j.g();
        } else {
            this.j.j();
        }
        return bitmapA;
    }

    public void k(AbstractC0321a abstractC0321a) {
        Bitmap bitmapJ = w.a(abstractC0321a.f4212e) ? j(abstractC0321a.c()) : null;
        if (bitmapJ == null) {
            g(abstractC0321a);
            if (this.p) {
                S.o("Main", "resumed", abstractC0321a.f4209b.d());
                return;
            }
            return;
        }
        d dVar = d.MEMORY;
        d(bitmapJ, dVar, abstractC0321a);
        if (this.p) {
            S.p("Main", "completed", abstractC0321a.f4209b.d(), "from " + dVar);
        }
    }

    public void l(AbstractC0321a abstractC0321a) {
        this.f4114h.l(abstractC0321a);
    }

    public H a(Uri uri) {
        return new H(this, uri, 0);
    }

    public H a(String str) {
        if (str == null) {
            return new H(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public static A a(Context context) {
        if (f4108b == null) {
            synchronized (A.class) {
                if (f4108b == null) {
                    f4108b = new a(context).a();
                }
            }
        }
        return f4108b;
    }
}
