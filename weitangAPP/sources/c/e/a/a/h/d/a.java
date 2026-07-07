package c.e.a.a.h.d;

import c.e.a.a.b;
import c.e.a.d.w;
import c.e.a.d.x;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.android.agoo.common.Config;

/* JADX INFO: loaded from: classes.dex */
public class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String token = b.getInstance().getToken();
        String deviceId = b.getInstance().getDeviceId();
        if (x.isNullStr(token)) {
            token = w.getInstance().getString("Token", "");
            b.getInstance().setToken(token);
        }
        if (x.isNullStr(deviceId)) {
            deviceId = w.getInstance().getString("device_id_key", "");
            b.getInstance().setDeviceId(deviceId);
        }
        String str = x.isNullStr(token) ? "" : token;
        try {
            return chain.proceed(request.newBuilder().addHeader("Token", str).addHeader("token", str).addHeader("deviceId", deviceId).addHeader("source", "1").addHeader(Config.PROPERTY_APP_VERSION, b.getInstance().getAppVersionName()).addHeader("RequestStamp", String.valueOf(System.currentTimeMillis())).build());
        } catch (Exception e2) {
            e2.printStackTrace();
            return chain.proceed(request);
        }
    }
}
