package com.tianmu.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.listener.InterstitialAdListener;
import com.tianmu.biz.utils.t0;
import com.tianmu.biz.widget.f;
import com.tianmu.c.f.z;
import com.tianmu.c.n.h;
import com.tianmu.c.n.q;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialActivity extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f10573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterstitialAdListener f10574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterstitialAd f10575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterstitialAdInfo f10576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f10578f;

    public static void start(Context context, String str, int i2) {
        Intent intent = new Intent(context, (Class<?>) (2 == i2 ? LandscapeInterstitialActivity.class : InterstitialActivity.class));
        intent.putExtra("AD_KEY", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public int a() {
        return z.f11558a;
    }

    public boolean b() {
        return false;
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public void initData() {
        super.initData();
        try {
            this.f10577e = getIntent().getStringExtra("AD_KEY");
            this.f10574b = h.a().c(this.f10577e);
            this.f10575c = h.a().a(this.f10577e);
            InterstitialAdInfo interstitialAdInfoB = h.a().b(this.f10577e);
            this.f10576d = interstitialAdInfoB;
            if (this.f10574b != null && this.f10575c != null && interstitialAdInfoB != null) {
                this.f10573a = new f(this.f10575c, this.f10576d, b(), new f.InterfaceC0190f() { // from class: com.tianmu.ad.activity.InterstitialActivity.1
                    @Override // com.tianmu.biz.widget.f.InterfaceC0190f
                    public void onClose() {
                        InterstitialActivity.this.finish();
                    }
                }, this.f10576d.getAutoCloseSecond());
                boolean zO = this.f10576d.getAdData() != null ? this.f10576d.getAdData().O() : false;
                InterstitialAd interstitialAd = this.f10575c;
                String posId = interstitialAd == null ? "" : interstitialAd.getPosId();
                this.f10573a.init();
                this.f10578f.addView(q.a().a(posId, this.f10577e, "interstitial", this.f10573a, zO));
                this.f10573a.render();
                return;
            }
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // com.tianmu.ad.activity.BaseActivity
    public void initView() {
        super.initView();
        try {
            t0.a((Activity) this);
        } catch (Exception unused) {
        }
        this.f10578f = (FrameLayout) findViewById(z.f11559b);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h.a().d(this.f10577e);
        f fVar = this.f10573a;
        if (fVar != null) {
            fVar.release();
            this.f10573a = null;
        }
        this.f10574b = null;
        InterstitialAd interstitialAd = this.f10575c;
        if (interstitialAd != null) {
            interstitialAd.release();
            this.f10575c = null;
        }
        InterstitialAdInfo interstitialAdInfo = this.f10576d;
        if (interstitialAdInfo != null) {
            interstitialAdInfo.release();
            this.f10576d = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f fVar = this.f10573a;
        if (fVar != null) {
            fVar.k();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        f fVar = this.f10573a;
        if (fVar != null) {
            fVar.l();
        }
    }
}
