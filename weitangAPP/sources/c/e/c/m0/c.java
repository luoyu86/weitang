package c.e.c.m0;

import android.content.Context;
import android.content.Intent;
import c.e.a.d.v;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.microtang.tip.TipActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1678a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f1679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppConfigExtVo f1680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<AlertMessageVo> f1681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<AlertMessageVo> f1682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1685h;

    public static c getInstance() {
        return f1678a;
    }

    public AppConfigExtVo getAppConfigExtVo() {
        return this.f1680c;
    }

    public List<AlertMessageVo> getBillAlertMessageVo() {
        return this.f1681d;
    }

    public List<AlertMessageVo> getLateFeeAlertMessageVo() {
        return this.f1682e;
    }

    public String getRoomKey() {
        return this.f1684g;
    }

    public boolean isRechargeable() {
        return this.f1683f;
    }

    public boolean isShowEnterpriseMsg() {
        return this.f1679b;
    }

    public boolean isUpdateAppAlertMessage() {
        if (this.f1685h == 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - this.f1685h > 30000;
        if (z) {
            this.f1685h = 0L;
        }
        return z;
    }

    public boolean openTipActivity(Context context, int i2) {
        if (i2 < 500 || i2 > 509 || v.getInstance().isRepeatedlyAction("openTipActivity", 1000)) {
            return false;
        }
        context.startActivity(new Intent(context, (Class<?>) TipActivity.class));
        return true;
    }

    public void setAppConfigExtVo(AppConfigExtVo appConfigExtVo) {
        this.f1680c = appConfigExtVo;
        c.e.a.d.g.getInstance().setupAppConfig(appConfigExtVo);
        if (appConfigExtVo != null) {
            c.e.c.x.c.a.getInstance().setMaxCount(appConfigExtVo.getMaxOftenLock());
            c.e.c.x.c.a.getInstance().setCommunityDefaultBannerUrl(appConfigExtVo.getCommunityDefaultBannerUrl());
            c.e.c.x.c.a.getInstance().setLifeDefaultBannerUrl(appConfigExtVo.getLifeDefaultBannerUrl());
            c.e.c.x.c.a.getInstance().setRoomDefaultBannerUrl(appConfigExtVo.getRoomDefaultBannerUrl());
            c.e.e.a.x.l.getInstance().setEnableNetworkCache(appConfigExtVo.isEnableNetworkCache());
            int cacheValidTime = appConfigExtVo.getCacheValidTime();
            if (cacheValidTime > 0) {
                c.e.e.a.x.l.getInstance().setMaxIntervalTime(((long) cacheValidTime) * 60 * 1000);
            }
        }
    }

    public void setBillAlertMessageVo(List<AlertMessageVo> list) {
        this.f1681d = list;
        c.e.e.a.x.l.getInstance().setBillAlertMessageVo(list);
    }

    public void setLateFeeAlertMessageVo(List<AlertMessageVo> list) {
        this.f1682e = list;
    }

    public void setRechargeable(boolean z) {
        this.f1683f = z;
    }

    public void setRoomKey(String str) {
        this.f1684g = str;
    }

    public void setShowEnterpriseMsg(boolean z) {
        this.f1679b = z;
    }

    public void updateAppBackground() {
        this.f1685h = System.currentTimeMillis();
    }
}
