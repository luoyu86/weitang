package com.tianmu.c.n;

import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.tianmu.biz.utils.i0;
import com.tianmu.biz.utils.u0;
import com.tianmu.biz.utils.x;
import com.tianmu.config.TianmuAdConfig;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static i f11870b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11871a;

    public static i b() {
        if (f11870b == null) {
            synchronized (i.class) {
                if (f11870b == null) {
                    f11870b = new i();
                }
            }
        }
        return f11870b;
    }

    private String c() {
        try {
            return x.a(u0.a(32) + SystemClock.elapsedRealtime());
        } catch (Exception unused) {
            return x.a(u0.a(32));
        }
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f11871a)) {
            return this.f11871a;
        }
        String machineId = TianmuAdConfig.getInstance().getMachineId();
        if (!TextUtils.isEmpty(machineId)) {
            this.f11871a = machineId;
            return machineId;
        }
        String strC = i0.a().c(DispatchConstants.MACHINE, "TIANMU_MACHINE_ID");
        this.f11871a = strC;
        if (!TextUtils.isEmpty(strC)) {
            return this.f11871a;
        }
        this.f11871a = c();
        i0.a().a(DispatchConstants.MACHINE, "TIANMU_MACHINE_ID", this.f11871a);
        return this.f11871a;
    }
}
