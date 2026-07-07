package h;

import f.t;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class h<T> implements h.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<T, ?> f14770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Object[] f14771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f14772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    public Call f14773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    public Throwable f14774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    public boolean f14775f;

    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f14776a;

        public a(d dVar) {
            this.f14776a = dVar;
        }

        public final void a(Throwable th) {
            try {
                this.f14776a.onFailure(h.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f14776a.onResponse(h.this, h.this.b(response));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f14778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IOException f14779b;

        public class a extends f.h {
            public a(t tVar) {
                super(tVar);
            }

            @Override // f.h, f.t
            public long read(f.c cVar, long j) throws IOException {
                try {
                    return super.read(cVar, j);
                } catch (IOException e2) {
                    b.this.f14779b = e2;
                    throw e2;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.f14778a = responseBody;
        }

        public void a() throws IOException {
            IOException iOException = this.f14779b;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f14778a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f14778a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f14778a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public f.e source() {
            return f.l.buffer(new a(this.f14778a.source()));
        }
    }

    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaType f14781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f14782b;

        public c(MediaType mediaType, long j) {
            this.f14781a = mediaType;
            this.f14782b = j;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f14782b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f14781a;
        }

        @Override // okhttp3.ResponseBody
        public f.e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public h(n<T, ?> nVar, @Nullable Object[] objArr) {
        this.f14770a = nVar;
        this.f14771b = objArr;
    }

    public final Call a() throws IOException {
        Call callD = this.f14770a.d(this.f14771b);
        Objects.requireNonNull(callD, "Call.Factory returned null.");
        return callD;
    }

    public l<T> b(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new c(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                return l.error(o.a(responseBodyBody), responseBuild);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode == 204 || iCode == 205) {
            responseBodyBody.close();
            return l.success((Object) null, responseBuild);
        }
        b bVar = new b(responseBodyBody);
        try {
            return l.success(this.f14770a.e(bVar), responseBuild);
        } catch (RuntimeException e2) {
            bVar.a();
            throw e2;
        }
    }

    @Override // h.b
    public void cancel() {
        Call call;
        this.f14772c = true;
        synchronized (this) {
            call = this.f14773d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // h.b
    public void enqueue(d<T> dVar) {
        Call call;
        Throwable th;
        o.b(dVar, "callback == null");
        synchronized (this) {
            if (this.f14775f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f14775f = true;
            call = this.f14773d;
            th = this.f14774e;
            if (call == null && th == null) {
                try {
                    Call callA = a();
                    this.f14773d = callA;
                    call = callA;
                } catch (Throwable th2) {
                    th = th2;
                    o.p(th);
                    this.f14774e = th;
                }
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        if (this.f14772c) {
            call.cancel();
        }
        call.enqueue(new a(dVar));
    }

    @Override // h.b
    public l<T> execute() throws IOException {
        Call callA;
        synchronized (this) {
            if (this.f14775f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f14775f = true;
            Throwable th = this.f14774e;
            if (th != null) {
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            callA = this.f14773d;
            if (callA == null) {
                try {
                    callA = a();
                    this.f14773d = callA;
                } catch (IOException | Error | RuntimeException e2) {
                    o.p(e2);
                    this.f14774e = e2;
                    throw e2;
                }
            }
        }
        if (this.f14772c) {
            callA.cancel();
        }
        return b(callA.execute());
    }

    @Override // h.b
    public boolean isCanceled() {
        boolean z = true;
        if (this.f14772c) {
            return true;
        }
        synchronized (this) {
            Call call = this.f14773d;
            if (call == null || !call.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // h.b
    public synchronized boolean isExecuted() {
        return this.f14775f;
    }

    @Override // h.b
    public synchronized Request request() {
        Call call = this.f14773d;
        if (call != null) {
            return call.request();
        }
        Throwable th = this.f14774e;
        if (th != null) {
            if (th instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.f14774e);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            Call callA = a();
            this.f14773d = callA;
            return callA.request();
        } catch (IOException e2) {
            this.f14774e = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            o.p(e);
            this.f14774e = e;
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            o.p(e);
            this.f14774e = e;
            throw e;
        }
    }

    @Override // h.b
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h<T> m473clone() {
        return new h<>(this.f14770a, this.f14771b);
    }
}
