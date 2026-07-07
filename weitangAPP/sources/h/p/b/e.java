package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements h.e<ResponseBody, Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14880a = new e();

    @Override // h.e
    public Double convert(ResponseBody responseBody) throws IOException {
        return Double.valueOf(responseBody.string());
    }
}
