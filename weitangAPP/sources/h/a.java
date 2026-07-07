package h;

import h.e;
import h.q.w;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e.a {

    /* JADX INFO: renamed from: h.a$a, reason: collision with other inner class name */
    public static final class C0265a implements h.e<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0265a f14751a = new C0265a();

        @Override // h.e
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return o.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    public static final class b implements h.e<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14752a = new b();

        @Override // h.e
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    public static final class c implements h.e<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14753a = new c();

        @Override // h.e
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    public static final class d implements h.e<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14754a = new d();

        @Override // h.e
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class e implements h.e<ResponseBody, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f14755a = new e();

        @Override // h.e
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // h.e.a
    public h.e<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        if (RequestBody.class.isAssignableFrom(o.i(type))) {
            return b.f14752a;
        }
        return null;
    }

    @Override // h.e.a
    public h.e<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, m mVar) {
        if (type == ResponseBody.class) {
            return o.m(annotationArr, w.class) ? c.f14753a : C0265a.f14751a;
        }
        if (type == Void.class) {
            return e.f14755a;
        }
        return null;
    }
}
