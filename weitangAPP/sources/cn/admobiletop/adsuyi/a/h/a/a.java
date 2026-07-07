package cn.admobiletop.adsuyi.a.h.a;

import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f3322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f3323c;

    public a(b bVar, String str, Map map) {
        this.f3323c = bVar;
        this.f3321a = str;
        this.f3322b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3321a.contains("code")) {
            try {
                if (new JSONObject(this.f3321a).optInt("code") == -1003) {
                    cn.admobiletop.adsuyi.a.l.d.b().a(this.f3323c.b(this.f3322b));
                    this.f3323c.onRequestFailed(-1003, "请求过期");
                    return;
                }
            } catch (JSONException unused) {
            }
        }
        List list = (List) this.f3322b.get("x-adm-st");
        if (list == null || list.isEmpty() || list.get(0) == null) {
            this.f3323c.onRequestFailed(ADSuyiErrorConfig.INIT_KEY_EMPTY, "初始化接口KEY为空");
            return;
        }
        String str = (String) list.get(0);
        String strA = cn.admobiletop.adsuyi.a.m.d.a(str, this.f3321a);
        if (strA != null) {
            this.f3323c.c(strA, str);
        } else {
            this.f3323c.onRequestFailed(ADSuyiErrorConfig.INIT_RESULT_DECRYPT_FAILED, "初始化接口数据解密失败");
        }
    }
}
