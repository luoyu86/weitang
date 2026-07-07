package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements h.e<ResponseBody, Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f14883a = new h();

    @Override // h.e
    public Long convert(ResponseBody responseBody) throws IOException {
        return Long.valueOf(responseBody.string());
    }
}
