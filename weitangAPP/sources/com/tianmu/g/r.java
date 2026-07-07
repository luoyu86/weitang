package com.tianmu.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import com.tianmu.g.a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static final Handler p = new a(Looper.getMainLooper());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile r f12114q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f12115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f12116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f12117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<x> f12118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f12119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f12120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.tianmu.g.d f12121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z f12122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Object, com.tianmu.g.a> f12123i;
    public final Map<ImageView, com.tianmu.g.g> j;
    public final ReferenceQueue<Object> k;
    public final Bitmap.Config l;
    public boolean m;
    public volatile boolean n;
    public boolean o;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 3) {
                com.tianmu.g.a aVar = (com.tianmu.g.a) message.obj;
                if (aVar.f().n) {
                    f0.a("Main", "canceled", aVar.f12024b.d(), "target got garbage collected");
                }
                aVar.f12023a.a(aVar.j());
                return;
            }
            int i3 = 0;
            if (i2 == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i3 < size) {
                    com.tianmu.g.c cVar = (com.tianmu.g.c) list.get(i3);
                    cVar.f12045b.a(cVar);
                    i3++;
                }
                return;
            }
            if (i2 != 13) {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list2 = (List) message.obj;
            int size2 = list2.size();
            while (i3 < size2) {
                com.tianmu.g.a aVar2 = (com.tianmu.g.a) list2.get(i3);
                aVar2.f12023a.b(aVar2);
                i3++;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f12124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f12125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ExecutorService f12126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.tianmu.g.d f12127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d f12128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g f12129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<x> f12130g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Bitmap.Config f12131h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f12132i;
        private boolean j;

        public b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f12124a = context.getApplicationContext();
        }

        public r a() {
            Context context = this.f12124a;
            if (this.f12125b == null) {
                this.f12125b = f0.c(context);
            }
            if (this.f12127d == null) {
                this.f12127d = new l(context);
            }
            if (this.f12126c == null) {
                this.f12126c = new t();
            }
            if (this.f12129f == null) {
                this.f12129f = g.f12143a;
            }
            z zVar = new z(this.f12127d);
            return new r(context, new h(context, this.f12126c, r.p, this.f12125b, this.f12127d, zVar), this.f12127d, this.f12128e, this.f12129f, this.f12130g, zVar, this.f12131h, this.f12132i, this.j);
        }
    }

    public static class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReferenceQueue<Object> f12133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f12134b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Exception f12135a;

            public a(c cVar, Exception exc) {
                this.f12135a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.f12135a);
            }
        }

        public c(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f12133a = referenceQueue;
            this.f12134b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0221a c0221a = (a.C0221a) this.f12133a.remove(1000L);
                    Message messageObtainMessage = this.f12134b.obtainMessage();
                    if (c0221a != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = c0221a.f12032a;
                        this.f12134b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f12134b.post(new a(this, e2));
                    return;
                }
            }
        }
    }

    public interface d {
        void a(r rVar, Uri uri, Exception exc);
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f12136b = new e("MEMORY", 0, -16711936);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f12137c = new e("DISK", 1, -16776961);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f12138d = new e("NETWORK", 2, SupportMenu.CATEGORY_MASK);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12139a;

        private e(String str, int i2, int i3) {
            this.f12139a = i3;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f12140a = new f("LOW", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f12141b = new f("NORMAL", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f12142c = new f("HIGH", 2);

        private f(String str, int i2) {
        }
    }

    public interface g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f12143a = new a();

        public static class a implements g {
            @Override // com.tianmu.g.r.g
            public v a(v vVar) {
                return vVar;
            }
        }

        v a(v vVar);
    }

    public r(Context context, h hVar, com.tianmu.g.d dVar, d dVar2, g gVar, List<x> list, z zVar, Bitmap.Config config, boolean z, boolean z2) {
        this.f12119e = context;
        this.f12120f = hVar;
        this.f12121g = dVar;
        this.f12115a = dVar2;
        this.f12116b = gVar;
        this.l = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 6);
        arrayList.add(new y(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new n(context));
        arrayList.add(new com.tianmu.g.f(context));
        arrayList.add(new com.tianmu.g.b(context));
        arrayList.add(new j(context));
        arrayList.add(new q(hVar.f12071d, zVar));
        this.f12118d = Collections.unmodifiableList(arrayList);
        this.f12122h = zVar;
        this.f12123i = new WeakHashMap();
        this.j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.k = referenceQueue;
        c cVar = new c(referenceQueue, p);
        this.f12117c = cVar;
        cVar.start();
    }

    public Bitmap b(String str) {
        Bitmap bitmap = this.f12121g.get(str);
        if (bitmap != null) {
            this.f12122h.b();
        } else {
            this.f12122h.c();
        }
        return bitmap;
    }

    public void c(com.tianmu.g.a aVar) {
        this.f12120f.b(aVar);
    }

    public void a(ImageView imageView) {
        a((Object) imageView);
    }

    public void a(b0 b0Var) {
        a((Object) b0Var);
    }

    public w a(Uri uri) {
        return new w(this, uri, 0);
    }

    public void b(com.tianmu.g.a aVar) {
        Bitmap bitmapB = o.a(aVar.f12027e) ? b(aVar.c()) : null;
        if (bitmapB != null) {
            e eVar = e.f12136b;
            a(bitmapB, eVar, aVar);
            if (this.n) {
                f0.a("Main", "completed", aVar.f12024b.d(), "from " + eVar);
                return;
            }
            return;
        }
        a(aVar);
        if (this.n) {
            f0.a("Main", "resumed", aVar.f12024b.d());
        }
    }

    public w a(String str) {
        if (str == null) {
            return new w(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str.trim()));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public List<x> a() {
        return this.f12118d;
    }

    public v a(v vVar) {
        v vVarA = this.f12116b.a(vVar);
        if (vVarA != null) {
            return vVarA;
        }
        throw new IllegalStateException("Request transformer " + this.f12116b.getClass().getCanonicalName() + " returned null for " + vVar);
    }

    public void a(ImageView imageView, com.tianmu.g.g gVar) {
        this.j.put(imageView, gVar);
    }

    public void a(com.tianmu.g.a aVar) {
        Object objJ = aVar.j();
        if (objJ != null && this.f12123i.get(objJ) != aVar) {
            a(objJ);
            this.f12123i.put(objJ, aVar);
        }
        c(aVar);
    }

    public void a(com.tianmu.g.c cVar) {
        com.tianmu.g.a aVarB = cVar.b();
        List<com.tianmu.g.a> listC = cVar.c();
        boolean z = true;
        boolean z2 = (listC == null || listC.isEmpty()) ? false : true;
        if (aVarB == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = cVar.d().f12159d;
            Exception excE = cVar.e();
            Bitmap bitmapK = cVar.k();
            e eVarG = cVar.g();
            if (aVarB != null) {
                a(bitmapK, eVarG, aVarB);
            }
            if (z2) {
                int size = listC.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(bitmapK, eVarG, listC.get(i2));
                }
            }
            d dVar = this.f12115a;
            if (dVar == null || excE == null) {
                return;
            }
            dVar.a(this, uri, excE);
        }
    }

    private void a(Bitmap bitmap, e eVar, com.tianmu.g.a aVar) {
        if (aVar.k()) {
            return;
        }
        if (!aVar.l()) {
            this.f12123i.remove(aVar.j());
        }
        if (bitmap == null) {
            aVar.b();
            if (this.n) {
                f0.a("Main", "errored", aVar.f12024b.d());
                return;
            }
            return;
        }
        if (eVar != null) {
            aVar.a(bitmap, eVar);
            if (this.n) {
                f0.a("Main", "completed", aVar.f12024b.d(), "from " + eVar);
                return;
            }
            return;
        }
        throw new AssertionError("LoadedFrom cannot be null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        f0.a();
        com.tianmu.g.a aVarRemove = this.f12123i.remove(obj);
        if (aVarRemove != null) {
            aVarRemove.a();
            this.f12120f.a(aVarRemove);
        }
        if (obj instanceof ImageView) {
            com.tianmu.g.g gVarRemove = this.j.remove((ImageView) obj);
            if (gVarRemove != null) {
                gVarRemove.a();
            }
        }
    }

    public static r a(Context context) {
        if (f12114q == null) {
            synchronized (r.class) {
                if (f12114q == null) {
                    f12114q = new b(context).a();
                }
            }
        }
        return f12114q;
    }
}
