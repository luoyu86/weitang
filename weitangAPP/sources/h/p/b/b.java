package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements h.e<ResponseBody, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14877a = new b();

    @Override // h.e
    public Boolean convert(ResponseBody responseBody) throws IOException {
        return Boolean.valueOf(responseBody.string());
    }
}
