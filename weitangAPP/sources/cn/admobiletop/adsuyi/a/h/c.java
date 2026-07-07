package cn.admobiletop.adsuyi.a.h;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.l.k;
import cn.admobiletop.adsuyi.a.l.p;
import cn.admobiletop.adsuyi.a.l.q;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import com.sun.mail.imap.IMAPStore;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(String str, Map<String, Object> map, Map<String, Object> map2, cn.admobiletop.adsuyi.a.h.a.b bVar) {
        super(str, map, map2, bVar);
    }

    @Override // cn.admobiletop.adsuyi.a.h.a
    public Map<String, Object> a() {
        HashMap map = new HashMap(14);
        String appId = ADSuyiSdk.getInstance().getAppId();
        Context context = ADSuyiSdk.getInstance().getContext();
        if (!TextUtils.isEmpty(appId) && context != null) {
            map.put("appId", appId);
            map.put("os", "1");
            map.put("packageName", ADSuyiPackageUtil.getPackageName(context));
            map.put("appVersion", ADSuyiPackageUtil.getAppVersion(context));
            map.put(DispatchConstants.MACHINE, p.a().b());
            map.put("network", k.d().h(context));
            map.put("osVersion", k.d().i());
            map.put(IMAPStore.ID_VENDOR, k.d().k());
            map.put("modelNo", k.d().g());
            map.put("deviceType", k.d().a(context));
            map.put("oaid", k.d().h());
            map.put(DispatchConstants.ANDROID, q.c().a());
            map.put("mac", q.c().d());
            map.put(Constants.KEY_IMEI, q.c().b());
        }
        return map;
    }

    @Override // cn.admobiletop.adsuyi.a.h.a
    public String c() {
        return this.f3319c.containsKey("INIT_FIRST_REQUEST") ? ((Boolean) this.f3319c.get("INIT_FIRST_REQUEST")).booleanValue() : false ? "" : cn.admobiletop.adsuyi.a.m.p.a().b();
    }
}
