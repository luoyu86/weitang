package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h.e<ResponseBody, Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14878a = new c();

    @Override // h.e
    public Byte convert(ResponseBody responseBody) throws IOException {
        return Byte.valueOf(responseBody.string());
    }
}
