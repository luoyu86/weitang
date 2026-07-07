package com.tianmu.c.k;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.sun.mail.imap.IMAPStore;
import com.taobao.accs.common.Constants;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.c0;
import com.tianmu.c.n.g;
import com.tianmu.c.n.i;
import com.tianmu.c.n.o;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    public c(String str, Map<String, Object> map, Map<String, Object> map2, com.tianmu.c.k.f.d dVar) {
        super(str, map, map2, dVar);
    }

    @Override // com.tianmu.c.k.a
    public Map<String, Object> a() {
        HashMap map = new HashMap();
        String appId = TianmuSDK.getInstance().getAppId();
        Context context = TianmuSDK.getInstance().getContext();
        if (!TextUtils.isEmpty(appId) && context != null) {
            map.put("os", "1");
            map.put("appVersion", TianmuPackageUtil.getAppVersion(context));
            map.put("osVersion", g.I().o());
            map.put("packageName", TianmuPackageUtil.getPackageName(context));
            map.put(DispatchConstants.MACHINE, i.b().a());
            map.put("oaid", g.I().n());
            map.put("androidId", c0.l().a());
            map.put(Constants.KEY_IMEI, c0.l().c());
            map.put("mac", c0.l().h());
            map.put(Constants.KEY_IMSI, c0.l().d());
            map.put("ip_v6", c0.l().e());
            map.put("network", g.I().h(context));
            map.put(IMAPStore.ID_VENDOR, g.I().r());
            map.put("modelNo", g.I().m());
            map.put("deviceType", g.I().a(context));
        }
        return map;
    }

    @Override // com.tianmu.c.k.a
    public String c() {
        return this.f11777c.containsKey("initApiFirstRequest") ? ((Boolean) this.f11777c.get("initApiFirstRequest")).booleanValue() : false ? "" : o.b().a();
    }
}
