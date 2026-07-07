package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements h.e<ResponseBody, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14882a = new g();

    @Override // h.e
    public Integer convert(ResponseBody responseBody) throws IOException {
        return Integer.valueOf(responseBody.string());
    }
}
