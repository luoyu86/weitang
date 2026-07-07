package com.tianmu.c.n;

import android.text.TextUtils;
import android.view.View;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.base.BaseAdTouchView;
import com.tianmu.biz.dr.IUnifiedAd;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q f11915a;

    private q() {
    }

    public static q a() {
        if (f11915a == null) {
            synchronized (q.class) {
                if (f11915a == null) {
                    f11915a = new q();
                }
            }
        }
        return f11915a;
    }

    public void a(com.tianmu.c.i.k kVar) {
        if (kVar == null || TextUtils.isEmpty(kVar.b())) {
            return;
        }
        p.b().a(TianmuSDK.getInstance().getContext(), kVar.b(), "com.tianmu.complicance.plugin.UnifiedAd");
    }

    public int a(BaseAdTouchView baseAdTouchView) {
        IUnifiedAd iUnifiedAdA = p.b().a();
        if (iUnifiedAdA == null) {
            return 0;
        }
        return iUnifiedAdA.getRefreshState(baseAdTouchView);
    }

    public View a(String str, String str2, String str3, View view, boolean z) {
        IUnifiedAd iUnifiedAdA = p.b().a();
        return iUnifiedAdA == null ? view : iUnifiedAdA.registerAdListener(str, str2, str3, view, z);
    }
}
