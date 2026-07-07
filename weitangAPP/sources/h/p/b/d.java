package h.p.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements h.e<ResponseBody, Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14879a = new d();

    @Override // h.e
    public Character convert(ResponseBody responseBody) throws IOException {
        String strString = responseBody.string();
        if (strString.length() == 1) {
            return Character.valueOf(strString.charAt(0));
        }
        throw new IOException("Expected body of length 1 for Character conversion but was " + strString.length());
    }
}
