package h.p.a;

import c.i.b.f;
import c.i.b.m;
import c.i.b.v;
import h.e;
import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class c<T> implements e<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v<T> f14874b;

    public c(f fVar, v<T> vVar) {
        this.f14873a = fVar;
        this.f14874b = vVar;
    }

    @Override // h.e
    public T convert(ResponseBody responseBody) throws IOException {
        c.i.b.a0.a aVarNewJsonReader = this.f14873a.newJsonReader(responseBody.charStream());
        try {
            T t = this.f14874b.read(aVarNewJsonReader);
            if (aVarNewJsonReader.peek() == c.i.b.a0.b.END_DOCUMENT) {
                return t;
            }
            throw new m("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
