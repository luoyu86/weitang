package com.tianmu.biz.bean;

import com.tianmu.c.i.c;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ECPMBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10824c;

    public ECPMBean(Map<String, c> map, List<String> list, int i2) {
        this.f10822a = i2;
        if (list.size() <= 1 || map.size() <= 1) {
            return;
        }
        try {
            int i3 = map.get(list.get(0)).i();
            this.f10823b = new BigDecimal(i2).multiply(BigDecimal.valueOf(i3 / (map.get(list.get(1)).i() + i3))).intValue();
            this.f10824c = this.f10822a - getAdSettlementPrice1();
        } catch (Exception unused) {
        }
    }

    public int getAdSettlementPrice1() {
        if (this.f10823b <= 0) {
            this.f10823b = 0;
        }
        return this.f10823b;
    }

    public int getAdSettlementPrice2() {
        if (this.f10824c <= 0) {
            this.f10824c = 0;
        }
        return this.f10824c;
    }

    public int getPrice() {
        return this.f10822a;
    }
}
