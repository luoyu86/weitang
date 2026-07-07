package h.p.a;

import c.i.b.f;
import c.i.b.v;
import h.e;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements e<T, RequestBody> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaType f14869a = MediaType.parse("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f14870b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f14871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v<T> f14872d;

    public b(f fVar, v<T> vVar) {
        this.f14871c = fVar;
        this.f14872d = vVar;
    }

    @Override // h.e
    public RequestBody convert(T t) throws IOException {
        f.c cVar = new f.c();
        c.i.b.a0.c cVarNewJsonWriter = this.f14871c.newJsonWriter(new OutputStreamWriter(cVar.outputStream(), f14870b));
        this.f14872d.write(cVarNewJsonWriter, t);
        cVarNewJsonWriter.close();
        return RequestBody.create(f14869a, cVar.readByteString());
    }
}
