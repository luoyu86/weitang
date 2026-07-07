package com.chinavisionary.microtang.base;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import c.e.a.a.a;
import c.e.a.d.x;
import c.e.c.m0.h;
import com.alibaba.sdk.android.man.MANHitBuilders;
import com.alibaba.sdk.android.man.MANService;
import com.alibaba.sdk.android.man.MANServiceProvider;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.core.app.event.EventPageAppearBo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import g.b.a.c;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseActivity extends CoreBaseActivity {
    public final void f0(String str) {
        if (a.getInstance().isDebug()) {
            return;
        }
        try {
            MANHitBuilders.MANCustomHitBuilder mANCustomHitBuilder = new MANHitBuilders.MANCustomHitBuilder("ad_click");
            mANCustomHitBuilder.setDurationOnEvent(1000L);
            mANCustomHitBuilder.setEventPage("event");
            if (x.isNotNull(str)) {
                mANCustomHitBuilder.setProperty("title", str);
            }
            mANCustomHitBuilder.setProperty("event", "ad_click");
            if (x.isNotNull(G())) {
                mANCustomHitBuilder.setProperty(NewLoginBo.SMS_LOGIN_NAME, G());
            }
            MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(mANCustomHitBuilder.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void g0(int i2, String str, String str2) {
        h.getInstance().handleForwardToType(this, i2, str, str2);
    }

    public boolean h0(int i2, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(PayTypeFragment.class.getCanonicalName());
        if (fragmentFindFragmentByTag instanceof PayTypeFragment) {
            return ((PayTypeFragment) fragmentFindFragmentByTag).onKeyDown(i2, keyEvent);
        }
        return false;
    }

    public void i0(Object obj) {
        c.getDefault().post(obj);
    }

    public void j0(Object obj) {
        c.getDefault().postSticky(obj);
    }

    public final void k0(EventPageAppearBo eventPageAppearBo) {
        try {
            if (!a.getInstance().isDebug() && eventPageAppearBo != null && eventPageAppearBo.getActivity() != null) {
                if (eventPageAppearBo.isPageDisAppear()) {
                    l0(eventPageAppearBo);
                } else {
                    MANService service = MANServiceProvider.getService();
                    String notNullStr = x.getNotNullStr(G(), "");
                    service.getMANAnalytics().updateUserAccount(notNullStr, notNullStr);
                    HashMap map = new HashMap();
                    map.put("pageName", eventPageAppearBo.getPageName());
                    service.getMANPageHitHelper().updatePageProperties(map);
                    service.getMANPageHitHelper().pageAppear(eventPageAppearBo.getActivity());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void l0(EventPageAppearBo eventPageAppearBo) {
        try {
            if (a.getInstance().isDebug() || eventPageAppearBo == null || eventPageAppearBo.getActivity() == null) {
                return;
            }
            MANService service = MANServiceProvider.getService();
            String notNullStr = x.getNotNullStr(G(), "");
            service.getMANAnalytics().updateUserAccount(notNullStr, notNullStr);
            service.getMANPageHitHelper().pageDisAppear(eventPageAppearBo.getActivity());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
