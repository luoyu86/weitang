package com.tianmu.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tianmu.c.h.a.c;
import com.tianmu.c.h.d.a;
import com.tianmu.d.c.b;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String schemeSpecificPart;
        Map<String, c> mapA;
        try {
            if (intent.getAction() == null || intent.getData() == null) {
                return;
            }
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                Map<String, c> mapA2 = a.c().a();
                if (mapA2 != null && !mapA2.isEmpty()) {
                    String schemeSpecificPart2 = intent.getData().getSchemeSpecificPart();
                    Iterator<Map.Entry<String, c>> it = mapA2.entrySet().iterator();
                    while (it.hasNext()) {
                        c value = it.next().getValue();
                        if (value != null && value.a(schemeSpecificPart2)) {
                            value.b();
                            b.a().a(schemeSpecificPart2);
                            com.tianmu.c.g.f.a.a().a(schemeSpecificPart2);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (!"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) || (schemeSpecificPart = intent.getData().getSchemeSpecificPart()) == null || (mapA = a.c().a()) == null || mapA.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<String, c>> it2 = mapA.entrySet().iterator();
            while (it2.hasNext()) {
                c value2 = it2.next().getValue();
                if (value2 != null && (value2.j() == 2 || value2.j() == 3)) {
                    if (schemeSpecificPart.equals(value2.c()) || schemeSpecificPart.equals(value2.h())) {
                        value2.a();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
