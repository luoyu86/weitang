package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements h.e<ResponseBody, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f14885a = new j();

    @Override // h.e
    public String convert(ResponseBody responseBody) throws IOException {
        return responseBody.string();
    }
}
