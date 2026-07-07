package h;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f14811a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrl f14813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public String f14814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public HttpUrl.Builder f14815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Request.Builder f14816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public MediaType f14817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f14818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public MultipartBody.Builder f14819i;

    @Nullable
    public FormBody.Builder j;

    @Nullable
    public RequestBody k;

    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestBody f14820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaType f14821b;

        public a(RequestBody requestBody, MediaType mediaType) {
            this.f14820a = requestBody;
            this.f14821b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f14820a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f14821b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(f.d dVar) throws IOException {
            this.f14820a.writeTo(dVar);
        }
    }

    public k(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f14812b = str;
        this.f14813c = httpUrl;
        this.f14814d = str2;
        Request.Builder builder = new Request.Builder();
        this.f14816f = builder;
        this.f14817g = mediaType;
        this.f14818h = z;
        if (headers != null) {
            builder.headers(headers);
        }
        if (z2) {
            this.j = new FormBody.Builder();
        } else if (z3) {
            MultipartBody.Builder builder2 = new MultipartBody.Builder();
            this.f14819i = builder2;
            builder2.setType(MultipartBody.FORM);
        }
    }

    public static String h(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                f.c cVar = new f.c();
                cVar.writeUtf8(str, 0, iCharCount);
                i(cVar, str, iCharCount, length, z);
                return cVar.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static void i(f.c cVar, String str, int i2, int i3, boolean z) {
        f.c cVar2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new f.c();
                    }
                    cVar2.writeUtf8CodePoint(iCodePointAt);
                    while (!cVar2.exhausted()) {
                        int i4 = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        char[] cArr = f14811a;
                        cVar.writeByte((int) cArr[(i4 >> 4) & 15]);
                        cVar.writeByte((int) cArr[i4 & 15]);
                    }
                } else {
                    cVar.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            this.j.addEncoded(str, str2);
        } else {
            this.j.add(str, str2);
        }
    }

    public void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f14816f.addHeader(str, str2);
            return;
        }
        MediaType mediaType = MediaType.parse(str2);
        if (mediaType != null) {
            this.f14817g = mediaType;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    public void c(Headers headers, RequestBody requestBody) {
        this.f14819i.addPart(headers, requestBody);
    }

    public void d(MultipartBody.Part part) {
        this.f14819i.addPart(part);
    }

    public void e(String str, String str2, boolean z) {
        String str3 = this.f14814d;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.f14814d = str3.replace("{" + str + com.alipay.sdk.m.u.i.f5699d, h(str2, z));
    }

    public void f(String str, @Nullable String str2, boolean z) {
        String str3 = this.f14814d;
        if (str3 != null) {
            HttpUrl.Builder builderNewBuilder = this.f14813c.newBuilder(str3);
            this.f14815e = builderNewBuilder;
            if (builderNewBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f14813c + ", Relative: " + this.f14814d);
            }
            this.f14814d = null;
        }
        if (z) {
            this.f14815e.addEncodedQueryParameter(str, str2);
        } else {
            this.f14815e.addQueryParameter(str, str2);
        }
    }

    public Request g() {
        HttpUrl httpUrlResolve;
        HttpUrl.Builder builder = this.f14815e;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            httpUrlResolve = this.f14813c.resolve(this.f14814d);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f14813c + ", Relative: " + this.f14814d);
            }
        }
        RequestBody aVar = this.k;
        if (aVar == null) {
            FormBody.Builder builder2 = this.j;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f14819i;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f14818h) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f14817g;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f14816f.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.f14816f.url(httpUrlResolve).method(this.f14812b, aVar).build();
    }

    public void j(RequestBody requestBody) {
        this.k = requestBody;
    }

    public void k(Object obj) {
        this.f14814d = obj.toString();
    }
}
