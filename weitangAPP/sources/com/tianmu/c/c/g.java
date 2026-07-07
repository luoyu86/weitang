package com.tianmu.c.c;

import android.content.Context;
import android.os.CountDownTimer;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.base.BaseAdTouchView;
import com.tianmu.ad.base.BaseView;
import com.tianmu.ad.base.IBaseRelease;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<V extends BaseView, AD extends BaseAd, ADInfo extends BaseAdInfo> extends BaseAdTouchView implements IBaseRelease {
    public Map<String, V> m;
    public AD n;
    public ADInfo o;
    private CountDownTimer p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11249q;
    private boolean r;
    private boolean s;

    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            g gVar = g.this;
            gVar.f11249q = 0;
            gVar.r = true;
            g.this.a(false);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            g.this.f11249q = (int) j;
        }
    }

    public g(Context context, AD ad, ADInfo adinfo) {
        super(context);
        this.f11249q = 2500;
        this.n = ad;
        this.o = adinfo;
    }

    private void e() {
        this.p = new a(this.f11249q, 100L);
    }

    public abstract void a(boolean z);

    public boolean c() {
        return this.m.size() > 1;
    }

    public void cancelTask() {
        CountDownTimer countDownTimer;
        if (this.s && (countDownTimer = this.p) != null) {
            this.s = false;
            countDownTimer.cancel();
        }
    }

    public void d() {
        if (!c() || this.r || this.f11249q == 0 || this.s) {
            return;
        }
        e();
        CountDownTimer countDownTimer = this.p;
        if (countDownTimer != null) {
            this.s = true;
            countDownTimer.start();
        }
    }

    public abstract void init();

    public void release() {
        cancelTask();
        this.p = null;
        Iterator<String> it = this.m.keySet().iterator();
        while (it.hasNext()) {
            V v = this.m.get(it.next());
            if (v != null) {
                v.release();
            }
        }
    }

    public abstract void render();

    public void setStopMaterialSwitch(boolean z) {
        this.r = z;
    }

    public V a(String str) {
        Map<String, V> map = this.m;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
