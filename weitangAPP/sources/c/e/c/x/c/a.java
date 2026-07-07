package c.e.c.x.c;

import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.e.a.s.e;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2009a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, WalletRecordDetailsVo> f2010b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f2011c = new ReentrantLock(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f2012d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f2013e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f2014f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f2015g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f2016h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f2017i;
    public String j;
    public String k;
    public String l;

    public static a getInstance() {
        return f2009a;
    }

    public final String a() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, null);
    }

    public void addData(String str, WalletRecordDetailsVo walletRecordDetailsVo) {
        this.f2011c.lock();
        if (str != null && walletRecordDetailsVo != null) {
            try {
                this.f2010b.put(str, walletRecordDetailsVo);
            } finally {
                this.f2011c.unlock();
            }
        }
    }

    public void clearCacheData() {
        this.f2011c.lock();
        try {
            this.f2010b.clear();
            this.f2014f.clear();
            this.f2015g.clear();
        } finally {
            this.f2011c.unlock();
        }
    }

    public String getCommunityDefaultBannerUrl() {
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo getDataToKey(java.lang.String r2) {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.f2011c
            r0.lock()
            if (r2 == 0) goto L1f
            java.util.Map<java.lang.String, com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo> r0 = r1.f2010b     // Catch: java.lang.Throwable -> L18
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1f
            java.util.Map<java.lang.String, com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo> r0 = r1.f2010b     // Catch: java.lang.Throwable -> L18
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L18
            com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo r2 = (com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo) r2     // Catch: java.lang.Throwable -> L18
            goto L20
        L18:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantLock r0 = r1.f2011c
            r0.unlock()
            throw r2
        L1f:
            r2 = 0
        L20:
            java.util.concurrent.locks.ReentrantLock r0 = r1.f2011c
            r0.unlock()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.x.c.a.getDataToKey(java.lang.String):com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo");
    }

    public String getLifeDefaultBannerUrl() {
        return this.k;
    }

    public int getMaxCount() {
        return this.f2016h;
    }

    public String getMaxCountValue() {
        switch (this.f2016h) {
            case 1:
                return "一";
            case 2:
                return "两";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            default:
                return "" + this.f2016h;
        }
    }

    public List<String> getOftenDeviceKeyList() {
        this.f2011c.lock();
        try {
            return this.f2015g;
        } finally {
            this.f2011c.unlock();
        }
    }

    public List<e> getOftenDeviceList() {
        this.f2011c.lock();
        try {
            List<e> array = JSON.parseArray(JSON.toJSONString(this.f2014f), e.class);
            if (array == null) {
                array = new ArrayList<>();
            }
            return array;
        } finally {
            this.f2011c.unlock();
        }
    }

    public String getRoomDefaultBannerUrl() {
        return this.j;
    }

    public void initOftenDevice() {
        this.f2017i = a();
        String string = w.getInstance().getString("cache_often_device_key" + this.f2017i, "");
        if (x.isNotNull(string)) {
            setOftenDeviceList(JSON.parseArray(string, e.class));
        }
    }

    public boolean isShowWallet() {
        return this.f2012d;
    }

    public boolean isShowWalletTest() {
        if ("13316429965".equals(w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, null))) {
            return true;
        }
        return this.f2013e;
    }

    public void setCommunityDefaultBannerUrl(String str) {
        this.l = str;
    }

    public void setLifeDefaultBannerUrl(String str) {
        this.k = str;
    }

    public void setMaxCount(int i2) {
        this.f2016h = i2;
    }

    public void setOftenDeviceList(List<e> list) {
        this.f2011c.lock();
        try {
            this.f2014f.clear();
            this.f2015g.clear();
            if (o.isNotEmpty(list)) {
                try {
                    String jSONString = JSON.toJSONString(list);
                    w.getInstance().putString("cache_often_device_key" + this.f2017i, jSONString);
                    for (e eVar : JSON.parseArray(jSONString, e.class)) {
                        if (eVar != null && eVar.getAssetInstanceKey() != null) {
                            this.f2015g.add(eVar.getAssetInstanceKey());
                        }
                    }
                    this.f2014f.addAll(list);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                w.getInstance().putString("cache_often_device_key" + this.f2017i, null);
            }
        } finally {
            this.f2011c.unlock();
        }
    }

    public void setRoomDefaultBannerUrl(String str) {
        this.j = str;
    }

    public void setShowWallet(boolean z) {
        this.f2012d = z;
    }

    public void setShowWalletTest(boolean z) {
        this.f2013e = z;
    }

    public void updateAssetConfirmStatus(e eVar) {
        this.f2011c.lock();
        try {
            if (o.isNotEmpty(this.f2014f) && eVar != null) {
                for (e eVar2 : this.f2014f) {
                    if (eVar2 != null && eVar2.getAssetInstanceKey() != null && eVar2.getAssetInstanceKey().equals(eVar.getAssetInstanceKey())) {
                        eVar2.setAssetConfirmDeadline(eVar.getAssetConfirmDeadline());
                        eVar2.setAssetConfirmStatus(eVar.isAssetConfirmStatus());
                    }
                }
            }
        } finally {
            this.f2011c.unlock();
        }
    }

    public void updateLockPower(e eVar) {
        this.f2011c.lock();
        try {
            if (o.isNotEmpty(this.f2014f) && eVar != null) {
                for (e eVar2 : this.f2014f) {
                    if (eVar2 != null && eVar2.getAssetInstanceKey() != null && eVar2.getAssetInstanceKey().equals(eVar.getAssetInstanceKey())) {
                        eVar2.setSoc(eVar.getSoc());
                        eVar2.setSocLevel(eVar.getSocLevel());
                        eVar2.setSocLevelName(eVar.getSocLevelName());
                    }
                }
            }
        } finally {
            this.f2011c.unlock();
        }
    }
}
