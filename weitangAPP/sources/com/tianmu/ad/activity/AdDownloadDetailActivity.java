package com.tianmu.ad.activity;

import android.content.Intent;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tianmu.biz.bean.DownloadTipType;
import com.tianmu.biz.download.service.DownloadNoticeService;
import com.tianmu.biz.utils.b0;
import com.tianmu.biz.utils.t;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.d1;
import com.tianmu.c.h.f.b;
import com.tianmu.c.i.a;
import com.tianmu.c.i.c;
import com.tianmu.c.n.n;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class AdDownloadDetailActivity extends AdDetailActivity {
    private a y;
    private b z;

    private void a(String str, boolean z) {
        if (this.y == null) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 33 && !n.D().p() && !b0.a(this, "android.permission.POST_NOTIFICATIONS")) {
            t.a(this);
        }
        setTheme(d1.f11319c);
        initDownloadAndNoticeService();
        this.f10914e.setText(c1.f11302q);
        if (!DownloadTipType.notAutoStartDownload() || this.y.l()) {
            if (this.z == null) {
                b bVar = new b(this, str, this.n, this.p, z, this.u, this.y);
                this.z = bVar;
                this.j.addView(bVar, new ViewGroup.LayoutParams(-1, -1));
            }
            this.z.a(this);
            return;
        }
        if (this.z == null) {
            b bVar2 = new b(this, str, this.n, this.p, false, this.u, this.y);
            this.z = bVar2;
            this.j.addView(bVar2, new ViewGroup.LayoutParams(-1, -1));
        }
        f();
    }

    private void f() {
        this.z.a(this);
    }

    @Override // com.tianmu.ad.activity.AdDetailActivity, com.tianmu.biz.web.b.f
    public void checkStartDownload(String str, boolean z) {
        a aVar;
        if (this.f10553q || (aVar = this.y) == null) {
            return;
        }
        if (aVar.k()) {
            a(str, true);
        } else {
            a(str, !DownloadTipType.notAutoStartDownload());
        }
    }

    @Override // com.tianmu.ad.activity.AdDetailActivity
    public void d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26 || i2 == 27 || i2 == 29) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10918i.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
        if (e()) {
            layoutParams.width = -2;
            layoutParams.addRule(11);
            layoutParams2.width = TianmuDisplayUtil.getScreenWidth() / 2;
        } else {
            layoutParams.height = -2;
            layoutParams2.height = TianmuDisplayUtil.getScreenHeight() / 2;
        }
        this.f10918i.setLayoutParams(layoutParams);
        this.j.setLayoutParams(layoutParams2);
    }

    @Override // com.tianmu.ad.activity.AdDetailActivity, com.tianmu.biz.web.BaseWebActivity
    public void initData() {
        super.initData();
        this.y = this.p.f();
    }

    public void initDownloadAndNoticeService() {
        Intent intent = new Intent(this, (Class<?>) DownloadNoticeService.class);
        intent.putExtra("adKey", this.n);
        c cVar = this.p;
        intent.putExtra("appLogoUrl", cVar != null ? cVar.getAppIconUrl() : "");
        a aVar = this.y;
        intent.putExtra("appName", aVar != null ? aVar.d() : "");
        a aVar2 = this.y;
        intent.putExtra("appPackageName", aVar2 != null ? aVar2.b() : "");
        c cVar2 = this.p;
        intent.putExtra("title", cVar2 != null ? cVar2.getTitle() : "");
        try {
            startService(intent);
        } catch (Exception unused) {
        }
    }

    @Override // com.tianmu.ad.activity.AdDetailActivity, com.tianmu.biz.web.BaseWebActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        b bVar = this.z;
        if (bVar != null) {
            bVar.a();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        b bVar = this.z;
        if (bVar != null) {
            bVar.a(i2);
        }
    }
}
