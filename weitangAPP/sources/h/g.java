package h;

import h.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f14759a;

    public class a implements c<Object, h.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f14760a;

        public a(Type type) {
            this.f14760a = type;
        }

        @Override // h.c
        public Type responseType() {
            return this.f14760a;
        }

        @Override // h.c
        /* JADX INFO: renamed from: adapt */
        public h.b<?> adapt2(h.b<Object> bVar) {
            return new b(g.this.f14759a, bVar);
        }
    }

    public static final class b<T> implements h.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f14762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.b<T> f14763b;

        public class a implements d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f14764a;

            /* JADX INFO: renamed from: h.g$b$a$a, reason: collision with other inner class name */
            public class RunnableC0266a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ l f14766a;

                public RunnableC0266a(l lVar) {
                    this.f14766a = lVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f14763b.isCanceled()) {
                        a aVar = a.this;
                        aVar.f14764a.onFailure(b.this, new IOException("Canceled"));
                    } else {
                        a aVar2 = a.this;
                        aVar2.f14764a.onResponse(b.this, this.f14766a);
                    }
                }
            }

            /* JADX INFO: renamed from: h.g$b$a$b, reason: collision with other inner class name */
            public class RunnableC0267b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f14768a;

                public RunnableC0267b(Throwable th) {
                    this.f14768a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f14764a.onFailure(b.this, this.f14768a);
                }
            }

            public a(d dVar) {
                this.f14764a = dVar;
            }

            @Override // h.d
            public void onFailure(h.b<T> bVar, Throwable th) {
                b.this.f14762a.execute(new RunnableC0267b(th));
            }

            @Override // h.d
            public void onResponse(h.b<T> bVar, l<T> lVar) {
                b.this.f14762a.execute(new RunnableC0266a(lVar));
            }
        }

        public b(Executor executor, h.b<T> bVar) {
            this.f14762a = executor;
            this.f14763b = bVar;
        }

        @Override // h.b
        public void cancel() {
            this.f14763b.cancel();
        }

        @Override // h.b
        public void enqueue(d<T> dVar) {
            o.b(dVar, "callback == null");
            this.f14763b.enqueue(new a(dVar));
        }

        @Override // h.b
        public l<T> execute() throws IOException {
            return this.f14763b.execute();
        }

        @Override // h.b
        public boolean isCanceled() {
            return this.f14763b.isCanceled();
        }

        @Override // h.b
        public boolean isExecuted() {
            return this.f14763b.isExecuted();
        }

        @Override // h.b
        public Request request() {
            return this.f14763b.request();
        }

        @Override // h.b
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public h.b<T> m472clone() {
            return new b(this.f14762a, this.f14763b.m472clone());
        }
    }

    public g(Executor executor) {
        this.f14759a = executor;
    }

    @Override // h.c.a
    public c<?, ?> get(Type type, Annotation[] annotationArr, m mVar) {
        if (c.a.a(type) != h.b.class) {
            return null;
        }
        return new a(o.f(type));
    }
}
