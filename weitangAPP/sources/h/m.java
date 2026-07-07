package h;

import h.a;
import h.c;
import h.e;
import h.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Method, n<?, ?>> f14825a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Call.Factory f14826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrl f14827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e.a> f14828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c.a> f14829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Executor f14830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f14831g;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f14832a = j.c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f14833b;

        public a(Class cls) {
            this.f14833b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f14832a.e(method)) {
                return this.f14832a.d(method, this.f14833b, obj, objArr);
            }
            n<?, ?> nVarB = m.this.b(method);
            return nVarB.a(new h(nVarB, objArr));
        }
    }

    public m(Call.Factory factory, HttpUrl httpUrl, List<e.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.f14826b = factory;
        this.f14827c = httpUrl;
        this.f14828d = list;
        this.f14829e = list2;
        this.f14830f = executor;
        this.f14831g = z;
    }

    public final void a(Class<?> cls) {
        j jVarC = j.c();
        for (Method method : cls.getDeclaredMethods()) {
            if (!jVarC.e(method)) {
                b(method);
            }
        }
    }

    public n<?, ?> b(Method method) {
        n nVarBuild;
        n<?, ?> nVar = this.f14825a.get(method);
        if (nVar != null) {
            return nVar;
        }
        synchronized (this.f14825a) {
            nVarBuild = this.f14825a.get(method);
            if (nVarBuild == null) {
                nVarBuild = new n.a(this, method).build();
                this.f14825a.put(method, nVarBuild);
            }
        }
        return nVarBuild;
    }

    public HttpUrl baseUrl() {
        return this.f14827c;
    }

    public c<?, ?> callAdapter(Type type, Annotation[] annotationArr) {
        return nextCallAdapter(null, type, annotationArr);
    }

    public List<c.a> callAdapterFactories() {
        return this.f14829e;
    }

    public Call.Factory callFactory() {
        return this.f14826b;
    }

    @Nullable
    public Executor callbackExecutor() {
        return this.f14830f;
    }

    public List<e.a> converterFactories() {
        return this.f14828d;
    }

    public <T> T create(Class<T> cls) {
        o.r(cls);
        if (this.f14831g) {
            a(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public b newBuilder() {
        return new b(this);
    }

    public c<?, ?> nextCallAdapter(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        o.b(type, "returnType == null");
        o.b(annotationArr, "annotations == null");
        int iIndexOf = this.f14829e.indexOf(aVar) + 1;
        int size = this.f14829e.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            c<?, ?> cVar = this.f14829e.get(i2).get(type, annotationArr, this);
            if (cVar != null) {
                return cVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f14829e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f14829e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f14829e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> nextRequestBodyConverter(@Nullable e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        o.b(type, "type == null");
        o.b(annotationArr, "parameterAnnotations == null");
        o.b(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f14828d.indexOf(aVar) + 1;
        int size = this.f14828d.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            e<T, RequestBody> eVar = (e<T, RequestBody>) this.f14828d.get(i2).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f14828d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f14828d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f14828d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<ResponseBody, T> nextResponseBodyConverter(@Nullable e.a aVar, Type type, Annotation[] annotationArr) {
        o.b(type, "type == null");
        o.b(annotationArr, "annotations == null");
        int iIndexOf = this.f14828d.indexOf(aVar) + 1;
        int size = this.f14828d.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            e<ResponseBody, T> eVar = (e<ResponseBody, T>) this.f14828d.get(i2).responseBodyConverter(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f14828d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f14828d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f14828d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return nextRequestBodyConverter(null, type, annotationArr, annotationArr2);
    }

    public <T> e<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        return nextResponseBodyConverter(null, type, annotationArr);
    }

    public <T> e<T, String> stringConverter(Type type, Annotation[] annotationArr) {
        o.b(type, "type == null");
        o.b(annotationArr, "annotations == null");
        int size = this.f14828d.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<T, String> eVar = (e<T, String>) this.f14828d.get(i2).stringConverter(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return a.d.f14754a;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f14835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Call.Factory f14836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public HttpUrl f14837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<e.a> f14838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<c.a> f14839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public Executor f14840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f14841g;

        public b(j jVar) {
            this.f14838d = new ArrayList();
            this.f14839e = new ArrayList();
            this.f14835a = jVar;
        }

        public b addCallAdapterFactory(c.a aVar) {
            this.f14839e.add((c.a) o.b(aVar, "factory == null"));
            return this;
        }

        public b addConverterFactory(e.a aVar) {
            this.f14838d.add((e.a) o.b(aVar, "factory == null"));
            return this;
        }

        public b baseUrl(String str) {
            o.b(str, "baseUrl == null");
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl != null) {
                return baseUrl(httpUrl);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public m build() {
            if (this.f14837c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory okHttpClient = this.f14836b;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            Call.Factory factory = okHttpClient;
            Executor executorDefaultCallbackExecutor = this.f14840f;
            if (executorDefaultCallbackExecutor == null) {
                executorDefaultCallbackExecutor = this.f14835a.defaultCallbackExecutor();
            }
            Executor executor = executorDefaultCallbackExecutor;
            ArrayList arrayList = new ArrayList(this.f14839e);
            arrayList.add(this.f14835a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.f14838d.size() + 1);
            arrayList2.add(new h.a());
            arrayList2.addAll(this.f14838d);
            return new m(factory, this.f14837c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f14841g);
        }

        public List<c.a> callAdapterFactories() {
            return this.f14839e;
        }

        public b callFactory(Call.Factory factory) {
            this.f14836b = (Call.Factory) o.b(factory, "factory == null");
            return this;
        }

        public b callbackExecutor(Executor executor) {
            this.f14840f = (Executor) o.b(executor, "executor == null");
            return this;
        }

        public b client(OkHttpClient okHttpClient) {
            return callFactory((Call.Factory) o.b(okHttpClient, "client == null"));
        }

        public List<e.a> converterFactories() {
            return this.f14838d;
        }

        public b validateEagerly(boolean z) {
            this.f14841g = z;
            return this;
        }

        public b() {
            this(j.c());
        }

        public b baseUrl(HttpUrl httpUrl) {
            o.b(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f14837c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public b(m mVar) {
            ArrayList arrayList = new ArrayList();
            this.f14838d = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f14839e = arrayList2;
            this.f14835a = j.c();
            this.f14836b = mVar.f14826b;
            this.f14837c = mVar.f14827c;
            arrayList.addAll(mVar.f14828d);
            arrayList.remove(0);
            arrayList2.addAll(mVar.f14829e);
            arrayList2.remove(arrayList2.size() - 1);
            this.f14840f = mVar.f14830f;
            this.f14841g = mVar.f14831g;
        }
    }
}
