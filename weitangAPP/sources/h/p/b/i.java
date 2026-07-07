package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements h.e<ResponseBody, Short> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f14884a = new i();

    @Override // h.e
    public Short convert(ResponseBody responseBody) throws IOException {
        return Short.valueOf(responseBody.string());
    }
}
