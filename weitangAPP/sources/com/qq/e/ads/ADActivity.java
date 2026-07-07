package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public class ADActivity extends Activity {
    public static final String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ACTD f9513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f9514b;

    public final void a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        super.setContentView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setTag(NOTCH_CONTAINER_TAG);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(frameLayout);
        this.f9514b = new FrameLayout(this);
        this.f9514b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.f9514b);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String string = null;
        try {
            POFactory pOFactory = a.b().c().getPOFactory();
            if (pOFactory != null) {
                Intent intent = getIntent();
                intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    string = extras.getString(ACTD.DELEGATE_NAME_KEY);
                    String string2 = extras.getString("appid");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && a.b().d()) {
                        ACTD activityDelegate = pOFactory.getActivityDelegate(string, this);
                        this.f9513a = activityDelegate;
                        if (activityDelegate == null) {
                            GDTLogger.e("创建 ADActivity Delegate " + string + " 失败");
                        }
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.e("创建ADActivity Delegate" + string + "发生异常", th);
        }
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (Throwable th2) {
                GDTLogger.e("ADActivity onCreate 发生异常", th2);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (Throwable th3) {
            com.qq.e.comm.managers.plugin.a.a(th3, "ADActivity onCreate 发生异常");
            GDTLogger.e("ADActivity onCreate 发生异常", th3);
        }
        ACTD actd2 = this.f9513a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        ACTD actd = this.f9513a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        a();
        LayoutInflater.from(this).inflate(i2, (ViewGroup) this.f9514b, true);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        a();
        this.f9514b.addView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a();
        this.f9514b.addView(view, layoutParams);
    }
}
