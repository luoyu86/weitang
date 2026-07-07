package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements h.e<ResponseBody, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14881a = new f();

    @Override // h.e
    public Float convert(ResponseBody responseBody) throws IOException {
        return Float.valueOf(responseBody.string());
    }
}
