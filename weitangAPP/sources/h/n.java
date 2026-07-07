package h;

import anet.channel.request.Request;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import h.i;
import h.q.p;
import h.q.q;
import h.q.r;
import h.q.s;
import h.q.t;
import h.q.u;
import h.q.v;
import h.q.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class n<R, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f14842a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f14843b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Call.Factory f14844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<R, T> f14845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HttpUrl f14846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e<ResponseBody, R> f14847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Headers f14850i;
    public final MediaType j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final i<?>[] n;

    public static final class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f14851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f14852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f14853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f14854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f14855e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Type f14856f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f14857g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f14858h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f14859i;
        public boolean j;
        public boolean k;
        public boolean l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f14860q;
        public Headers r;
        public MediaType s;
        public Set<String> t;
        public i<?>[] u;
        public e<ResponseBody, T> v;
        public c<T, R> w;

        public a(m mVar, Method method) {
            this.f14851a = mVar;
            this.f14852b = method;
            this.f14853c = method.getAnnotations();
            this.f14855e = method.getGenericParameterTypes();
            this.f14854d = method.getParameterAnnotations();
        }

        public final c<T, R> a() {
            Type genericReturnType = this.f14852b.getGenericReturnType();
            if (o.k(genericReturnType)) {
                throw c("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw c("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (c<T, R>) this.f14851a.callAdapter(genericReturnType, this.f14852b.getAnnotations());
            } catch (RuntimeException e2) {
                throw d(e2, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        public final e<ResponseBody, T> b() {
            try {
                return this.f14851a.responseBodyConverter(this.f14856f, this.f14852b.getAnnotations());
            } catch (RuntimeException e2) {
                throw d(e2, "Unable to create converter for %s", this.f14856f);
            }
        }

        public n build() {
            c<T, R> cVarA = a();
            this.w = cVarA;
            Type typeResponseType = cVarA.responseType();
            this.f14856f = typeResponseType;
            if (typeResponseType == l.class || typeResponseType == Response.class) {
                throw c(OperatorName.SHOW_TEXT_LINE + o.i(this.f14856f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.v = b();
            for (Annotation annotation : this.f14853c) {
                i(annotation);
            }
            if (this.m == null) {
                throw c("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.n) {
                if (this.p) {
                    throw c("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.o) {
                    throw c("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f14854d.length;
            this.u = new i[length];
            for (int i2 = 0; i2 < length; i2++) {
                Type type = this.f14855e[i2];
                if (o.k(type)) {
                    throw e(i2, "Parameter type must not include a type variable or wildcard: %s", type);
                }
                Annotation[] annotationArr = this.f14854d[i2];
                if (annotationArr == null) {
                    throw e(i2, "No Retrofit annotation found.", new Object[0]);
                }
                this.u[i2] = j(i2, type, annotationArr);
            }
            if (this.f14860q == null && !this.l) {
                throw c("Missing either @%s URL or @Url parameter.", this.m);
            }
            boolean z = this.o;
            if (!z && !this.p && !this.n && this.f14859i) {
                throw c("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z && !this.f14857g) {
                throw c("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.p || this.f14858h) {
                return new n(this);
            }
            throw c("Multipart method must contain at least one @Part.", new Object[0]);
        }

        public final RuntimeException c(String str, Object... objArr) {
            return d(null, str, objArr);
        }

        public final RuntimeException d(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f14852b.getDeclaringClass().getSimpleName() + Consts.DOT + this.f14852b.getName(), th);
        }

        public final RuntimeException e(int i2, String str, Object... objArr) {
            return c(str + " (parameter #" + (i2 + 1) + ")", objArr);
        }

        public final RuntimeException f(Throwable th, int i2, String str, Object... objArr) {
            return d(th, str + " (parameter #" + (i2 + 1) + ")", objArr);
        }

        public final Headers g(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw c("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    MediaType mediaType = MediaType.parse(strTrim);
                    if (mediaType == null) {
                        throw c("Malformed content type: %s", strTrim);
                    }
                    this.s = mediaType;
                } else {
                    builder.add(strSubstring, strTrim);
                }
            }
            return builder.build();
        }

        public final void h(String str, String str2, boolean z) {
            String str3 = this.m;
            if (str3 != null) {
                throw c("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.m = str;
            this.n = z;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (n.f14842a.matcher(strSubstring).find()) {
                    throw c("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f14860q = str2;
            this.t = n.c(str2);
        }

        public final void i(Annotation annotation) {
            if (annotation instanceof h.q.b) {
                h(Request.Method.DELETE, ((h.q.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof h.q.f) {
                h("GET", ((h.q.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof h.q.g) {
                h(Request.Method.HEAD, ((h.q.g) annotation).value(), false);
                if (!Void.class.equals(this.f14856f)) {
                    throw c("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof h.q.n) {
                h("PATCH", ((h.q.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof h.q.o) {
                h("POST", ((h.q.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof p) {
                h(Request.Method.PUT, ((p) annotation).value(), true);
                return;
            }
            if (annotation instanceof h.q.m) {
                h(Request.Method.OPTION, ((h.q.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof h.q.h) {
                h.q.h hVar = (h.q.h) annotation;
                h(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof h.q.k) {
                String[] strArrValue = ((h.q.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw c("@Headers annotation is empty.", new Object[0]);
                }
                this.r = g(strArrValue);
                return;
            }
            if (annotation instanceof h.q.l) {
                if (this.o) {
                    throw c("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.p = true;
            } else if (annotation instanceof h.q.e) {
                if (this.p) {
                    throw c("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.o = true;
            }
        }

        public final i<?> j(int i2, Type type, Annotation[] annotationArr) {
            i<?> iVar = null;
            for (Annotation annotation : annotationArr) {
                i<?> iVarK = k(i2, type, annotationArr, annotation);
                if (iVarK != null) {
                    if (iVar != null) {
                        throw e(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    iVar = iVarK;
                }
            }
            if (iVar != null) {
                return iVar;
            }
            throw e(i2, "No Retrofit annotation found.", new Object[0]);
        }

        public final i<?> k(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                if (this.l) {
                    throw e(i2, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.j) {
                    throw e(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.k) {
                    throw e(i2, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.f14860q != null) {
                    throw e(i2, "@Url cannot be used with @%s URL", this.m);
                }
                this.l = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new i.o();
                }
                throw e(i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof s) {
                if (this.k) {
                    throw e(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.l) {
                    throw e(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f14860q == null) {
                    throw e(i2, "@Path can only be used with relative url on @%s", this.m);
                }
                this.j = true;
                s sVar = (s) annotation;
                String strValue = sVar.value();
                l(i2, strValue);
                return new i.j(strValue, this.f14851a.stringConverter(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof t) {
                t tVar = (t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsI = o.i(type);
                this.k = true;
                if (!Iterable.class.isAssignableFrom(clsI)) {
                    return clsI.isArray() ? new i.k(strValue2, this.f14851a.stringConverter(n.b(clsI.getComponentType()), annotationArr), zEncoded).b() : new i.k(strValue2, this.f14851a.stringConverter(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new i.k(strValue2, this.f14851a.stringConverter(o.h(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw e(i2, clsI.getSimpleName() + " must include generic type (e.g., " + clsI.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof v) {
                boolean zEncoded2 = ((v) annotation).encoded();
                Class<?> clsI2 = o.i(type);
                this.k = true;
                if (!Iterable.class.isAssignableFrom(clsI2)) {
                    return clsI2.isArray() ? new i.m(this.f14851a.stringConverter(n.b(clsI2.getComponentType()), annotationArr), zEncoded2).b() : new i.m(this.f14851a.stringConverter(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new i.m(this.f14851a.stringConverter(o.h(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw e(i2, clsI2.getSimpleName() + " must include generic type (e.g., " + clsI2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof u) {
                Class<?> clsI3 = o.i(type);
                if (!Map.class.isAssignableFrom(clsI3)) {
                    throw e(i2, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeJ = o.j(type, clsI3, Map.class);
                if (!(typeJ instanceof ParameterizedType)) {
                    throw e(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeJ;
                Type typeH = o.h(0, parameterizedType);
                if (String.class == typeH) {
                    return new i.l(this.f14851a.stringConverter(o.h(1, parameterizedType), annotationArr), ((u) annotation).encoded());
                }
                throw e(i2, "@QueryMap keys must be of type String: " + typeH, new Object[0]);
            }
            if (annotation instanceof h.q.i) {
                String strValue3 = ((h.q.i) annotation).value();
                Class<?> clsI4 = o.i(type);
                if (!Iterable.class.isAssignableFrom(clsI4)) {
                    return clsI4.isArray() ? new i.f(strValue3, this.f14851a.stringConverter(n.b(clsI4.getComponentType()), annotationArr)).b() : new i.f(strValue3, this.f14851a.stringConverter(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new i.f(strValue3, this.f14851a.stringConverter(o.h(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw e(i2, clsI4.getSimpleName() + " must include generic type (e.g., " + clsI4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof h.q.j) {
                Class<?> clsI5 = o.i(type);
                if (!Map.class.isAssignableFrom(clsI5)) {
                    throw e(i2, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeJ2 = o.j(type, clsI5, Map.class);
                if (!(typeJ2 instanceof ParameterizedType)) {
                    throw e(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeJ2;
                Type typeH2 = o.h(0, parameterizedType2);
                if (String.class == typeH2) {
                    return new i.g(this.f14851a.stringConverter(o.h(1, parameterizedType2), annotationArr));
                }
                throw e(i2, "@HeaderMap keys must be of type String: " + typeH2, new Object[0]);
            }
            if (annotation instanceof h.q.c) {
                if (!this.o) {
                    throw e(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                h.q.c cVar = (h.q.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f14857g = true;
                Class<?> clsI6 = o.i(type);
                if (!Iterable.class.isAssignableFrom(clsI6)) {
                    return clsI6.isArray() ? new i.d(strValue4, this.f14851a.stringConverter(n.b(clsI6.getComponentType()), annotationArr), zEncoded3).b() : new i.d(strValue4, this.f14851a.stringConverter(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new i.d(strValue4, this.f14851a.stringConverter(o.h(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw e(i2, clsI6.getSimpleName() + " must include generic type (e.g., " + clsI6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof h.q.d) {
                if (!this.o) {
                    throw e(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsI7 = o.i(type);
                if (!Map.class.isAssignableFrom(clsI7)) {
                    throw e(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeJ3 = o.j(type, clsI7, Map.class);
                if (!(typeJ3 instanceof ParameterizedType)) {
                    throw e(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeJ3;
                Type typeH3 = o.h(0, parameterizedType3);
                if (String.class == typeH3) {
                    e<T, String> eVarStringConverter = this.f14851a.stringConverter(o.h(1, parameterizedType3), annotationArr);
                    this.f14857g = true;
                    return new i.e(eVarStringConverter, ((h.q.d) annotation).encoded());
                }
                throw e(i2, "@FieldMap keys must be of type String: " + typeH3, new Object[0]);
            }
            if (!(annotation instanceof q)) {
                if (!(annotation instanceof r)) {
                    if (!(annotation instanceof h.q.a)) {
                        return null;
                    }
                    if (this.o || this.p) {
                        throw e(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.f14859i) {
                        throw e(i2, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        e<T, RequestBody> eVarRequestBodyConverter = this.f14851a.requestBodyConverter(type, annotationArr, this.f14853c);
                        this.f14859i = true;
                        return new i.c(eVarRequestBodyConverter);
                    } catch (RuntimeException e2) {
                        throw f(e2, i2, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!this.p) {
                    throw e(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f14858h = true;
                Class<?> clsI8 = o.i(type);
                if (!Map.class.isAssignableFrom(clsI8)) {
                    throw e(i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeJ4 = o.j(type, clsI8, Map.class);
                if (!(typeJ4 instanceof ParameterizedType)) {
                    throw e(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeJ4;
                Type typeH4 = o.h(0, parameterizedType4);
                if (String.class == typeH4) {
                    Type typeH5 = o.h(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(o.i(typeH5))) {
                        throw e(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new i.C0268i(this.f14851a.requestBodyConverter(typeH5, annotationArr, this.f14853c), ((r) annotation).encoding());
                }
                throw e(i2, "@PartMap keys must be of type String: " + typeH4, new Object[0]);
            }
            if (!this.p) {
                throw e(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            q qVar = (q) annotation;
            this.f14858h = true;
            String strValue5 = qVar.value();
            Class<?> clsI9 = o.i(type);
            if (strValue5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(clsI9)) {
                    if (clsI9.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(clsI9.getComponentType())) {
                            return i.n.f14808a.b();
                        }
                        throw e(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (MultipartBody.Part.class.isAssignableFrom(clsI9)) {
                        return i.n.f14808a;
                    }
                    throw e(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (MultipartBody.Part.class.isAssignableFrom(o.i(o.h(0, (ParameterizedType) type)))) {
                        return i.n.f14808a.c();
                    }
                    throw e(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw e(i2, clsI9.getSimpleName() + " must include generic type (e.g., " + clsI9.getSimpleName() + "<String>)", new Object[0]);
            }
            Headers headersOf = Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
            if (!Iterable.class.isAssignableFrom(clsI9)) {
                if (!clsI9.isArray()) {
                    if (MultipartBody.Part.class.isAssignableFrom(clsI9)) {
                        throw e(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new i.h(headersOf, this.f14851a.requestBodyConverter(type, annotationArr, this.f14853c));
                }
                Class<?> clsB = n.b(clsI9.getComponentType());
                if (MultipartBody.Part.class.isAssignableFrom(clsB)) {
                    throw e(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new i.h(headersOf, this.f14851a.requestBodyConverter(clsB, annotationArr, this.f14853c)).b();
            }
            if (type instanceof ParameterizedType) {
                Type typeH6 = o.h(0, (ParameterizedType) type);
                if (MultipartBody.Part.class.isAssignableFrom(o.i(typeH6))) {
                    throw e(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new i.h(headersOf, this.f14851a.requestBodyConverter(typeH6, annotationArr, this.f14853c)).c();
            }
            throw e(i2, clsI9.getSimpleName() + " must include generic type (e.g., " + clsI9.getSimpleName() + "<String>)", new Object[0]);
        }

        public final void l(int i2, String str) {
            if (!n.f14843b.matcher(str).matches()) {
                throw e(i2, "@Path parameter name must match %s. Found: %s", n.f14842a.pattern(), str);
            }
            if (!this.t.contains(str)) {
                throw e(i2, "URL \"%s\" does not contain \"{%s}\".", this.f14860q, str);
            }
        }
    }

    public n(a<R, T> aVar) {
        this.f14844c = aVar.f14851a.callFactory();
        this.f14845d = aVar.w;
        this.f14846e = aVar.f14851a.baseUrl();
        this.f14847f = aVar.v;
        this.f14848g = aVar.m;
        this.f14849h = aVar.f14860q;
        this.f14850i = aVar.r;
        this.j = aVar.s;
        this.k = aVar.n;
        this.l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.u;
    }

    public static Class<?> b(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    public static Set<String> c(String str) {
        Matcher matcher = f14842a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    public T a(b<R> bVar) {
        return this.f14845d.adapt2(bVar);
    }

    public Call d(@Nullable Object... objArr) throws IOException {
        k kVar = new k(this.f14848g, this.f14846e, this.f14849h, this.f14850i, this.j, this.k, this.l, this.m);
        i<?>[] iVarArr = this.n;
        int length = objArr != null ? objArr.length : 0;
        if (length == iVarArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                iVarArr[i2].a(kVar, objArr[i2]);
            }
            return this.f14844c.newCall(kVar.g());
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + iVarArr.length + ")");
    }

    public R e(ResponseBody responseBody) throws IOException {
        return this.f14847f.convert(responseBody);
    }
}
