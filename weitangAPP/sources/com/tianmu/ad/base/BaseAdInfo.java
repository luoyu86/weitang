package com.tianmu.ad.base;

import android.text.TextUtils;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.NativeVideoAdListener;
import com.tianmu.biz.bean.ECPMBean;
import com.tianmu.biz.bean.VideoAutoPlayType;
import com.tianmu.biz.utils.e0;
import com.tianmu.biz.utils.n0;
import com.tianmu.c.c.e;
import com.tianmu.c.i.c;
import com.tianmu.c.i.l;
import com.tianmu.c.m.d;
import com.tianmu.c.n.j;
import com.tianmu.c.n.m;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.j.a.c.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaseAdInfo implements IBidding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f10632a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f10638g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NativeVideoAdListener f10640i;
    private boolean k;
    private boolean l;
    private boolean m;
    private ECPMBean n;
    private com.tianmu.c.l.e p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10641q;
    private int r;
    private boolean s;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10636e = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10639h = VideoAutoPlayType.DEFAULT_PLAY;
    private int o = 1;
    private long j = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, c> f10633b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, com.tianmu.c.c.a> f10634c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f10635d = new ArrayList();

    public BaseAdInfo(e eVar) {
        this.f10632a = eVar;
    }

    private void b(c cVar) {
        a(cVar);
        this.f10641q = cVar.i();
        this.r = cVar.h();
    }

    private void c(c cVar) {
        if (cVar == null || cVar.z() == null) {
            return;
        }
        cVar.z().a(cVar);
    }

    public void a(l lVar) {
        if (lVar == null || lVar.a() == null || lVar.a().isEmpty()) {
            return;
        }
        if (lVar.a().size() == 1) {
            b(lVar.a().get(0));
            return;
        }
        Iterator<c> it = lVar.a().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        int iB = lVar.b();
        this.f10641q = iB;
        this.r = e0.a(this.f10633b, this.f10635d, iB);
    }

    public c getAdData(String str) {
        Map<String, c> map = this.f10633b;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f10633b.get(str);
    }

    public Map<String, c> getAdDataMap() {
        return this.f10633b;
    }

    public com.tianmu.c.c.a getAdInfoStatus(String str) {
        Map<String, com.tianmu.c.c.a> map = this.f10634c;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f10634c.get(str);
    }

    @Override // com.tianmu.ad.base.IBidding
    public int getBidFloor() {
        return this.r;
    }

    @Override // com.tianmu.ad.base.IBidding
    public int getBidPrice() {
        return this.f10641q;
    }

    public String getKey() {
        int size = this.f10635d.size();
        int i2 = this.f10636e;
        if (size > i2) {
            return this.f10635d.get(i2);
        }
        return null;
    }

    public List<String> getKeys() {
        return this.f10635d;
    }

    public String getNextKey() {
        int i2 = this.f10636e + 1;
        if (i2 >= this.f10635d.size()) {
            return null;
        }
        this.f10636e = i2;
        this.o++;
        return getUseKey();
    }

    public String getUseKey() {
        int size = this.f10635d.size();
        int i2 = this.f10636e;
        if (size > i2) {
            return this.f10635d.get(i2);
        }
        return null;
    }

    public int getVideoAutoPlayType() {
        return this.f10639h;
    }

    public boolean hasShow() {
        return this.m;
    }

    public boolean isAvailable() {
        if (this.f10632a == null) {
            return false;
        }
        if (hasShow()) {
            return true;
        }
        if (isReportBidLoss()) {
            a(TianmuErrorConfig.AD_REPORT_BID_LOSS_BAN_SHOW_ERROR, TianmuErrorConfig.MSG_AD_REPORT_BID_LOSS_BAN_SHOW_ERROR);
            return false;
        }
        if (this.f10632a.f() && !isReportBidWin()) {
            a(TianmuErrorConfig.AD_NO_REPORT_BID_WIN_ERROR, TianmuErrorConfig.MSG_AD_NO_REPORT_BID_WIN_ERROR);
            return false;
        }
        if (!isOvertime()) {
            return true;
        }
        a(TianmuErrorConfig.AD_SHOW_TIME_OUT_ERROR, TianmuErrorConfig.MSG_AD_SHOW_TIME_OUT_ERROR);
        return false;
    }

    public boolean isExpose(String str) {
        if (getAdInfoStatus() == null) {
            return false;
        }
        com.tianmu.c.c.a adInfoStatus = getAdInfoStatus(str);
        if ((adInfoStatus.e() && adInfoStatus.c()) || adInfoStatus.a()) {
            return true;
        }
        if (adInfoStatus.d() && adInfoStatus.e()) {
            return true;
        }
        return adInfoStatus.c() && adInfoStatus.b();
    }

    public boolean isMute() {
        return this.f10637f;
    }

    public boolean isOvertime() {
        return (System.currentTimeMillis() - this.j) / 1000 > 600;
    }

    public boolean isReportBidLoss() {
        return this.l;
    }

    public boolean isReportBidWin() {
        return this.k;
    }

    public void pause() {
    }

    public void release() {
        for (String str : this.f10633b.keySet()) {
            c cVar = this.f10633b.get(str);
            if (!TextUtils.isEmpty(str)) {
                m.b().c(str);
            }
            cVar.destroy();
        }
    }

    public void reportMultiBidWin() {
        if (b() && this.n != null) {
            c cVar = this.f10633b.get(this.f10635d.get(0));
            c cVar2 = this.f10633b.get(this.f10635d.get(1));
            a(cVar, this.n.getAdSettlementPrice1());
            a(cVar2, this.n.getAdSettlementPrice2());
        }
    }

    public void reportMultiExpose() {
        if (this.s) {
            return;
        }
        this.s = true;
        if (b()) {
            c cVar = this.f10633b.get(this.f10635d.get(0));
            c cVar2 = this.f10633b.get(this.f10635d.get(1));
            c(cVar);
            c(cVar2);
        }
    }

    public void resetKeyPosition() {
        this.f10636e = 0;
    }

    public void resume() {
    }

    @Override // com.tianmu.ad.base.IBidding
    public void sendLossNotice(int i2, int i3) {
        if (isReportBidLoss()) {
            a(TianmuErrorConfig.AD_ALREADY_REPORT_BID_LOSS_ERROR, TianmuErrorConfig.MSG_AD_ALREADY_REPORT_BID_LOSS_ERROR);
            return;
        }
        if (isReportBidWin()) {
            a(TianmuErrorConfig.AD_REPORT_BID_WIN_BAN_REPORT_LOSS_ERROR, TianmuErrorConfig.MSG_AD_REPORT_BID_WIN_BAN_REPORT_LOSS_ERROR);
            return;
        }
        if (getAdData() != null && !TextUtils.isEmpty(getAdData().v())) {
            j.b().a(Arrays.asList(n0.a(getAdData().v(), i2, i3)), false);
        }
        this.l = true;
        e eVar = this.f10632a;
        if (eVar != null) {
            eVar.a(i2, i3);
        }
    }

    @Override // com.tianmu.ad.base.IBidding
    public void sendWinNotice(int i2) {
        if (isReportBidWin()) {
            a(TianmuErrorConfig.AD_ALREADY_REPORT_BID_WIN_ERROR, TianmuErrorConfig.MSG_AD_ALREADY_REPORT_BID_WIN_ERROR);
            return;
        }
        if (isReportBidLoss()) {
            a(TianmuErrorConfig.AD_REPORT_BID_LOSS_BAN_REPORT_WIN_ERROR, TianmuErrorConfig.MSG_AD_REPORT_BID_LOSS_BAN_REPORT_WIN_ERROR);
            return;
        }
        if (getAdData() != null && (i2 < 0 || i2 > getBidPrice())) {
            a(TianmuErrorConfig.AD_REPORT_BID_WIN_PRICE_ERROR, TianmuErrorConfig.MSG_AD_REPORT_BID_WIN_PRICE_ERROR);
            return;
        }
        if (isOvertime()) {
            a(TianmuErrorConfig.AD_SHOW_TIME_OUT_ERROR, TianmuErrorConfig.MSG_AD_SHOW_TIME_OUT_ERROR);
            return;
        }
        this.k = true;
        if (b()) {
            this.n = new ECPMBean(this.f10633b, this.f10635d, i2);
            reportMultiBidWin();
        } else {
            a(getAdData(), i2);
        }
        e eVar = this.f10632a;
        if (eVar != null) {
            eVar.p();
        }
    }

    public void setHasShow(boolean z) {
        this.m = z;
    }

    public void setMute(boolean z) {
        this.f10637f = z;
    }

    public void setRenderListener(com.tianmu.c.l.e eVar) {
        this.p = eVar;
    }

    private boolean c() {
        return this.o < 2;
    }

    public c getAdData() {
        Map<String, c> map = this.f10633b;
        if (map == null || !map.containsKey(getUseKey())) {
            return null;
        }
        return this.f10633b.get(getUseKey());
    }

    public com.tianmu.c.c.a getAdInfoStatus() {
        Map<String, com.tianmu.c.c.a> map = this.f10634c;
        if (map == null || !map.containsKey(getUseKey())) {
            return null;
        }
        return this.f10634c.get(getUseKey());
    }

    public boolean b() {
        List<String> list;
        Map<String, c> map = this.f10633b;
        return map != null && map.size() >= 2 && (list = this.f10635d) != null && list.size() >= 2;
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f10633b.put(cVar.u(), cVar);
        this.f10634c.put(cVar.u(), new com.tianmu.c.c.a());
        this.f10635d.add(cVar.u());
    }

    public NativeVideoAdListener a() {
        return this.f10640i;
    }

    public void a(int i2, String str) {
        if (i2 == -3014 && this.p != null && this.f10633b.size() > 1) {
            if (c()) {
                this.p.a();
                return;
            } else if (this.o == 2) {
                this.p.b();
                return;
            }
        }
        e eVar = this.f10632a;
        if (eVar != null) {
            if ((eVar instanceof d) && (this instanceof NativeExpressAdInfo)) {
                ((d) eVar).onRenderFailed((NativeExpressAdInfo) this, new TianmuError(i2, str));
            } else if ((eVar instanceof com.tianmu.c.m.c) && (this instanceof NativeAdInfo)) {
                ((com.tianmu.c.m.c) eVar).onRenderFailed((NativeAdInfo) this, new TianmuError(i2, str));
            } else {
                eVar.onAdFailed(new TianmuError(i2, str));
            }
        }
    }

    private void a(c cVar, int i2) {
        if (cVar == null) {
            return;
        }
        cVar.a(i2);
        if (TextUtils.isEmpty(cVar.F())) {
            return;
        }
        j.b().a(Arrays.asList(n0.b(cVar.F(), i2)), false);
    }
}
