package cn.admobiletop.adsuyi.a.k.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.a.a.i;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManagerFactory;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cn.admobiletop.adsuyi.a.k.a.a.a f3357e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3359g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f3361i;
    public String l;
    public ADSuyiPosId m;
    public ADSuyiAd n;
    public ADSuyiAdListener o;
    public int s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cn.admobiletop.adsuyi.a.e.a f3353a = new cn.admobiletop.adsuyi.a.e.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cn.admobiletop.adsuyi.a.e.b f3354b = new cn.admobiletop.adsuyi.a.e.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3358f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, ADSuyiBidResponsed> f3360h = new HashMap<>();
    public ArrayList<ADSuyiPlatformPosId> j = new ArrayList<>();
    public List<i> k = new ArrayList();
    public Handler p = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Runnable f3362q = new cn.admobiletop.adsuyi.a.k.a.a(this);
    public ArrayList<Double> r = new ArrayList<>();

    public interface a {
        void a(ADSuyiPlatformPosId aDSuyiPlatformPosId);
    }

    public e(String str, String str2, cn.admobiletop.adsuyi.a.k.a.a.a aVar, int i2) {
        this.f3355c = str;
        this.f3356d = str2;
        this.f3357e = aVar;
        if (i2 == 0) {
            this.s = 2000;
        } else {
            this.s = i2;
        }
    }

    public final void A() {
        this.f3360h.clear();
        this.j.clear();
    }

    public final void B() {
        this.k.clear();
    }

    public final void C() {
        this.r.clear();
        if (this.j.size() <= 0) {
            a aVar = this.f3361i;
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        if (x()) {
            return;
        }
        ADSuyiPlatformPosId aDSuyiPlatformPosId = this.j.get(0);
        a aVar2 = this.f3361i;
        if (aVar2 != null) {
            aVar2.a(aDSuyiPlatformPosId);
        }
    }

    public final void D() {
        Runnable runnable;
        Handler handler = this.p;
        if (handler == null || (runnable = this.f3362q) == null) {
            return;
        }
        handler.postDelayed(runnable, this.s);
    }

    public final void E() {
        if (u()) {
            n();
            C();
        }
    }

    public boolean b() {
        return this.f3358f;
    }

    public final void f(ADSuyiPlatformPosId aDSuyiPlatformPosId, List<ADSuyiPlatformPosId> list) {
        String platform = aDSuyiPlatformPosId.getPlatform();
        ADSuyiBidResponsed aDSuyiBidResponsed = this.f3360h.get(platform);
        if (aDSuyiBidResponsed != null && aDSuyiBidResponsed.getNotice() != null) {
            ADSuyiLogUtil.d("当前队列竞价成功" + platform + "  sendWinNotice" + platform + "ecpm " + aDSuyiBidResponsed.getCPM());
            aDSuyiBidResponsed.getNotice().sendWinNotice(this.r);
            h("hbGroupWin", String.valueOf(aDSuyiPlatformPosId.getId()), aDSuyiBidResponsed.getCPM());
            y();
        }
        A();
        list.add(0, aDSuyiPlatformPosId);
        z(list);
        cn.admobiletop.adsuyi.a.k.a.a.a aVar = this.f3357e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g(ADSuyiBidResponsed aDSuyiBidResponsed, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        if (aDSuyiBidResponsed == null) {
            return;
        }
        if (!b()) {
            String platform = aDSuyiBidResponsed.getPlatform();
            if (this.f3360h.get(platform) == null) {
                aDSuyiPlatformPosId.setECPM(aDSuyiBidResponsed.getCPM());
                aDSuyiPlatformPosId.setBidToken(aDSuyiBidResponsed.getToken());
                this.f3360h.put(platform, aDSuyiBidResponsed);
                this.j.add(aDSuyiPlatformPosId);
                h("hbSuccess", String.valueOf(aDSuyiPlatformPosId.getId()), aDSuyiBidResponsed.getCPM());
            }
            E();
            return;
        }
        ADSuyiBidNotice notice = aDSuyiBidResponsed.getNotice();
        if (notice != null) {
            ADSuyiLogUtil.d(aDSuyiBidResponsed.getPlatform() + "平台竞价超时 ，BID_TIMEOUT ，" + aDSuyiBidResponsed.getCPM());
            notice.sendLossNotice(2, this.r);
        }
    }

    public final void h(String str, String str2, double d2) {
        this.k.add(new i(str, str2, d2));
    }

    public final void i(ArrayList<ADSuyiPlatformPosId> arrayList) {
        Iterator<ADSuyiPlatformPosId> it = arrayList.iterator();
        while (it.hasNext()) {
            this.r.add(Double.valueOf(it.next().getECPM()));
        }
    }

    public final void j(ArrayList<ADSuyiPlatformPosId> arrayList, a aVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f3361i = aVar;
        A();
        D();
        s(arrayList);
    }

    public final void l(ArrayList<ADSuyiPlatformPosId> arrayList) {
        Collections.sort(arrayList, this.f3353a);
    }

    public final void m(List<ADSuyiPlatformPosId> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            ADSuyiBidResponsed aDSuyiBidResponsed = this.f3360h.get(list.get(i2).getPlatform());
            if (aDSuyiBidResponsed != null && aDSuyiBidResponsed.getNotice() != null) {
                aDSuyiBidResponsed.getNotice().sendLossNotice(1, this.r);
            }
        }
    }

    public void n() {
        Runnable runnable;
        Handler handler = this.p;
        if (handler == null || (runnable = this.f3362q) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.f3362q = null;
    }

    public final void p(ArrayList<Double> arrayList) {
        Collections.sort(arrayList, new d(this));
    }

    public final void q(List<ADSuyiPlatformPosId> list) {
        if (list.size() == 0) {
            A();
            cn.admobiletop.adsuyi.a.k.a.a.a aVar = this.f3357e;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        z(list);
        A();
        cn.admobiletop.adsuyi.a.k.a.a.a aVar2 = this.f3357e;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public final void s(ArrayList<ADSuyiPlatformPosId> arrayList) {
        a aVar;
        B();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.f3360h.put(arrayList.get(i2).getPlatform(), null);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ADSuyiPlatformPosId aDSuyiPlatformPosId = arrayList.get(i3);
            String platform = aDSuyiPlatformPosId.getPlatform();
            ADSuyiBidManager bidManager = ADSuyiBidManagerFactory.getInstance().getBidManager(aDSuyiPlatformPosId, this.f3356d, this.n, this.o, this.m);
            if (bidManager != null) {
                h("hbRequest", String.valueOf(aDSuyiPlatformPosId.getId()), 0.0d);
                bidManager.bid(new c(this, aDSuyiPlatformPosId));
            } else {
                ADSuyiLogUtil.d(platform + " 平台的竞价适配器获取失败，请检查是否导入相应平台的竞价SDK，如果已导入并开启了混淆请检查混淆是否配置正确");
                this.f3360h.remove(platform);
                if (i3 == arrayList.size() - 1 && this.f3360h.size() == 0 && (aVar = this.f3361i) != null) {
                    aVar.a(null);
                }
            }
        }
    }

    public final void t(List<ADSuyiPlatformPosId> list) {
        ArrayList arrayList = new ArrayList();
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
            if (aDSuyiPlatformPosId.isBidType()) {
                arrayList.add(aDSuyiPlatformPosId);
            }
        }
        list.removeAll(arrayList);
    }

    public final boolean u() {
        Iterator<String> it = this.f3360h.keySet().iterator();
        while (it.hasNext()) {
            if (this.f3360h.get(it.next()) == null) {
                return false;
            }
        }
        return true;
    }

    public final void w(List<ADSuyiPlatformPosId> list) {
        ArrayList arrayList = new ArrayList();
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
            if (aDSuyiPlatformPosId.isFrequencyFinished()) {
                arrayList.add(aDSuyiPlatformPosId);
            }
        }
        list.removeAll(arrayList);
    }

    public final boolean x() {
        double hbBidFloor = this.m.getHbBidFloor();
        if (this.j.size() > 1) {
            l(this.j);
            i(this.j);
            ADSuyiPlatformPosId aDSuyiPlatformPosId = this.j.get(0);
            if (aDSuyiPlatformPosId != null) {
                double ecpm = aDSuyiPlatformPosId.getECPM();
                if (ecpm <= hbBidFloor) {
                    ADSuyiLogUtil.ti("ADSuyiBidding", aDSuyiPlatformPosId.getPlatform() + " 平台价格小于底价 ，当前竞价价格为：" + ecpm + "，底价为：" + hbBidFloor);
                    this.r.add(0, Double.valueOf(hbBidFloor));
                    m(this.j);
                    a aVar = this.f3361i;
                    if (aVar != null) {
                        aVar.a(null);
                        return true;
                    }
                } else {
                    ArrayList<ADSuyiPlatformPosId> arrayList = this.j;
                    m(arrayList.subList(1, arrayList.size()));
                    if (hbBidFloor > 0.0d) {
                        this.r.add(Double.valueOf(hbBidFloor));
                        p(this.r);
                    }
                }
            } else {
                a aVar2 = this.f3361i;
                if (aVar2 != null) {
                    aVar2.a(null);
                    return true;
                }
            }
        } else {
            ADSuyiPlatformPosId aDSuyiPlatformPosId2 = this.j.get(0);
            if (aDSuyiPlatformPosId2 != null) {
                double ecpm2 = aDSuyiPlatformPosId2.getECPM();
                if (ecpm2 <= hbBidFloor) {
                    this.r.add(0, Double.valueOf(hbBidFloor));
                    m(this.j);
                    a aVar3 = this.f3361i;
                    if (aVar3 != null) {
                        aVar3.a(null);
                        return true;
                    }
                } else {
                    this.r.add(0, Double.valueOf(ecpm2));
                    if (hbBidFloor > 0.0d) {
                        this.r.add(1, Double.valueOf(hbBidFloor));
                    }
                }
            } else {
                a aVar4 = this.f3361i;
                if (aVar4 != null) {
                    aVar4.a(null);
                    return true;
                }
            }
        }
        return false;
    }

    public final void y() {
        List<i> list;
        try {
            if (this.m == null || (list = this.k) == null || list.size() <= 0) {
                return;
            }
            cn.admobiletop.adsuyi.a.a.h.a(this.k, this.m.getPosId(), this.m.getGroupId(), this.l);
        } catch (Exception unused) {
        }
    }

    public final void z(List<ADSuyiPlatformPosId> list) {
        Collections.sort(list, this.f3354b);
    }

    @Override // cn.admobiletop.adsuyi.a.k.a.f
    public void a(ADSuyiPosId aDSuyiPosId, List<ADSuyiPlatformPosId> list, String str, ADSuyiAd aDSuyiAd, ADSuyiAdListener aDSuyiAdListener) {
        try {
            this.l = str;
            this.m = aDSuyiPosId;
            this.n = aDSuyiAd;
            this.o = aDSuyiAdListener;
            cn.admobiletop.adsuyi.a.f.c.b().a(aDSuyiPosId.getPosId(), list);
            w(list);
            ArrayList<ADSuyiPlatformPosId> arrayListB = b(list);
            if (arrayListB.size() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(aDSuyiPosId.getPosId());
                sb.append(" : 当前竞价请求组广告位为空或均已达到展示上限，停止竞价请求");
                ADSuyiLogUtil.e(sb.toString());
                if (list.size() == 0) {
                    A();
                    cn.admobiletop.adsuyi.a.k.a.a.a aVar = this.f3357e;
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                } else {
                    z(list);
                    A();
                    cn.admobiletop.adsuyi.a.k.a.a.a aVar2 = this.f3357e;
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                }
            }
            t(list);
            j(arrayListB, new b(this, list));
        } catch (Exception unused) {
        }
    }

    public void b(boolean z) {
        this.f3358f = z;
    }

    public final ArrayList<ADSuyiPlatformPosId> b(List<ADSuyiPlatformPosId> list) {
        ArrayList<ADSuyiPlatformPosId> arrayList = new ArrayList<>();
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
            if (aDSuyiPlatformPosId.isBidType()) {
                String platform = aDSuyiPlatformPosId.getPlatform();
                if (TextUtils.isEmpty(this.f3355c) || this.f3355c.equals(platform)) {
                    aDSuyiPlatformPosId.setECPM(0.0d);
                    arrayList.add(aDSuyiPlatformPosId);
                }
            }
        }
        return arrayList;
    }

    public boolean a() {
        return this.f3359g;
    }

    public void a(boolean z) {
        this.f3359g = z;
    }
}
