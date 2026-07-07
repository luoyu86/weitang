package com.tianmu.c.k.f;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tianmu.c.n.k;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.http.listener.SimpleHttpListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends SimpleHttpListener {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f11812b;

        public a(String str, Map map) {
            this.f11811a = str;
            this.f11812b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11811a.contains("code")) {
                try {
                    if (new JSONObject(this.f11811a).optInt("code") == -1003) {
                        k.h().a(d.this.a(this.f11812b));
                        d.this.onRequestFailed(-1003, "请求过期");
                        return;
                    }
                } catch (JSONException unused) {
                }
            }
            List list = (List) this.f11812b.get("x-tm-st");
            if (list == null || list.isEmpty() || list.get(0) == null) {
                if (d.this.isMock()) {
                    d.this.a(this.f11811a, (String) null);
                    return;
                } else {
                    d.this.onRequestFailed(TianmuErrorConfig.INIT_KEY_EMPTY, "初始化接口KEY为空");
                    return;
                }
            }
            String str = (String) list.get(0);
            String strC = d.c(str, this.f11811a);
            if (strC != null) {
                d.this.a(strC, str);
            } else {
                d.this.onRequestFailed(TianmuErrorConfig.INIT_RESULT_DECRYPT_FAILED, "初始化接口数据解密失败");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String strA = com.tianmu.c.d.c.a(str);
                if (strA != null) {
                    return com.tianmu.c.d.a.a(str2, strA);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public abstract void a(String str, String str2);

    public void a(String str, Map<String, List<String>> map) {
        com.tianmu.c.k.e.e().b().execute(new a(str, map));
    }

    public boolean isMock() {
        return false;
    }

    @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
    public void onRequestSuccess(String str, Map<String, List<String>> map) {
        if (str == null || map == null) {
            onRequestFailed(TianmuErrorConfig.INIT_RESULT_EMPTY, "初始化接口数据为空");
        } else {
            a(str, map);
        }
    }

    public long a(Map<String, List<String>> map) {
        List<String> list = map.get(HttpHeaders.DATE);
        if (list != null && !list.isEmpty() && list.get(0) != null) {
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }
}
