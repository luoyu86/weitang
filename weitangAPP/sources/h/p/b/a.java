package h.p.b;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements h.e<T, RequestBody> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<Object> f14875a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaType f14876b = MediaType.parse("text/plain; charset=UTF-8");

    @Override // h.e
    public RequestBody convert(T t) throws IOException {
        return RequestBody.create(f14876b, String.valueOf(t));
    }
}
