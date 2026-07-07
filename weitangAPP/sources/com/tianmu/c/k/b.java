package com.tianmu.c.k;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.sun.mail.imap.IMAPStore;
import com.taobao.accs.common.Constants;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.l;
import com.tianmu.biz.utils.q;
import com.tianmu.biz.utils.r0;
import com.tianmu.c.n.g;
import com.tianmu.c.n.i;
import com.tianmu.c.n.o;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {
    public b(String str, Map<String, Object> map, Map<String, Object> map2, com.tianmu.c.k.f.d dVar) {
        super(str, map, map2, dVar);
    }

    @Override // com.tianmu.c.k.a
    public Map<String, Object> a() {
        HashMap map = new HashMap(14);
        String appId = TianmuSDK.getInstance().getAppId();
        Context context = TianmuSDK.getInstance().getContext();
        if (!TextUtils.isEmpty(appId) && context != null) {
            map.put("os", "1");
            map.put("packageName", TianmuPackageUtil.getPackageName(context));
            map.put("appVersion", TianmuPackageUtil.getAppVersion(context));
            map.put("osVersion", g.I().o());
            map.put(DispatchConstants.MACHINE, i.b().a());
            map.put("oaid", g.I().n());
            map.put("androidId", g.I().b(context));
            map.put("mac", g.I().g(context));
            map.put(Constants.KEY_IMEI, g.I().c(context));
            map.put(Constants.KEY_IMSI, g.I().d(context));
            map.put("network", g.I().h(context));
            map.put(IMAPStore.ID_VENDOR, g.I().r());
            map.put("modelNo", g.I().m());
            map.put("longitude", g.I().e(context));
            map.put("latitude", g.I().f(context));
            map.put("screenWidth", Integer.valueOf(TianmuDisplayUtil.getScreenWidth()));
            map.put("screenHeight", Integer.valueOf(TianmuDisplayUtil.getScreenHeight()));
            map.put("ppi", Integer.valueOf(TianmuDisplayUtil.getDensityDpi()));
            map.put("deviceType", g.I().a(context));
            map.put("phoneName", g.I().r());
            map.put("diskSize", g.I().f());
            map.put("memorySize", Long.valueOf(q.a(TianmuSDK.getInstance().getContext())));
            map.put("cpuNumber", Integer.valueOf(l.c()));
            map.put("cpuFrequency", Float.valueOf(l.a()));
            String strA = g.I().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("osBootMark", strA);
            }
            String strC = g.I().c();
            if (!TextUtils.isEmpty(strC)) {
                map.put("osUpdateMark", strC);
            }
            map.put("androidApiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
            map.put("osElapseTime", Long.valueOf(SystemClock.elapsedRealtime() / 1000));
            map.put("vaid", g.I().q());
            map.put("language", b());
            map.put("timeZone", r0.a());
            map.put("storeVersion", com.tianmu.biz.utils.c.a(context));
            map.put("hmsVersion", com.tianmu.biz.utils.c.b(context));
            map.put("harmonyOsVer", com.tianmu.biz.utils.c.c());
            map.put("osUiVersion", com.tianmu.biz.utils.c.a());
            map.put("ip_v6", g.I().b());
            g.I().u();
        }
        return map;
    }

    @Override // com.tianmu.c.k.a
    public String c() {
        return o.b().a();
    }
}
