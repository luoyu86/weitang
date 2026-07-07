package com.chinavisionary.microtang;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends BaseActivity {
    public int k;
    public Runnable l = new a();

    @BindView(R.id.img_bottom_launcher)
    public ImageView mBottomLauncherImg;

    @BindView(R.id.img_launcher)
    public CoreRoundedImageView mSplashImg;

    @BindView(R.id.tv_timer)
    public TextView mTimerTv;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SplashActivity.this.f6478f.removeCallbacks(SplashActivity.this.l);
            SplashActivity.p0(SplashActivity.this);
            if (SplashActivity.this.k < 0) {
                SplashActivity.this.u0();
            } else {
                SplashActivity.this.t0();
            }
        }
    }

    public static /* synthetic */ int p0(SplashActivity splashActivity) {
        int i2 = splashActivity.k;
        splashActivity.k = i2 - 1;
        return i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
        u0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_splash_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        this.f6476d = false;
        this.mTimerTv.setOnClickListener(this.j);
        String string = w.getInstance().getString("splash_ad", null);
        if (string != null) {
            try {
                AppConfigExtVo.ADScreen.SplashScreenBean splashScreenBean = (AppConfigExtVo.ADScreen.SplashScreenBean) JSON.parseObject(string, AppConfigExtVo.ADScreen.SplashScreenBean.class);
                if (splashScreenBean != null) {
                    String resource = splashScreenBean.getResource();
                    this.k = ((int) splashScreenBean.getTimer().longValue()) / 1000;
                    if (x.isNotNull(resource)) {
                        this.mSplashImg.loadImageToUrl(resource);
                        this.mBottomLauncherImg.setVisibility(0);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f6478f = new CoreBaseActivity.a(this);
        if (this.k > 0) {
            t0();
        } else {
            u0();
        }
    }

    public final void s0() {
        CoreBaseActivity.a aVar = this.f6478f;
        if (aVar != null) {
            aVar.removeCallbacks(this.l);
            this.f6478f.removeCallbacksAndMessages(null);
        }
    }

    public final void t0() {
        this.mTimerTv.setText(x.appendStringToResId(R.string.placeholder_timer_unit, String.valueOf(this.k)));
        this.f6478f.postAtTime(this.l, SystemClock.uptimeMillis() + 1000);
    }

    public final void u0() {
        s0();
        finish();
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }
}
