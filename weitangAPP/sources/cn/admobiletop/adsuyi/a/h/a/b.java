package cn.admobiletop.adsuyi.a.h.a;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.ciba.http.listener.SimpleHttpListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends SimpleHttpListener {
    public final long b(Map<String, List<String>> map) {
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

    public abstract void c(String str, String str2);

    public final void d(String str, Map<String, List<String>> map) {
        cn.admobiletop.adsuyi.a.h.d.c().b().execute(new a(this, str, map));
    }

    @Override // com.ciba.http.listener.SimpleHttpListener, com.ciba.http.listener.HttpListener
    public void onRequestSuccess(String str, Map<String, List<String>> map) {
        if (str == null || map == null) {
            onRequestFailed(ADSuyiErrorConfig.INIT_RESULT_EMPTY, "初始化接口数据为空");
        } else {
            d(str, map);
        }
    }
}
