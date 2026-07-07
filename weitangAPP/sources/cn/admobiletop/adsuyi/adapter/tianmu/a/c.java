package cn.admobiletop.adsuyi.adapter.tianmu.a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.R;
import com.tianmu.ad.activity.BaseActivity;
import com.tianmu.ad.bean.NativeAdInfo;

/* JADX INFO: loaded from: classes.dex */
public class c extends a<ADSuyiInnerNoticeAdListener, NativeAdInfo> implements ADSuyiInnerNoticeAdInfo {
    public boolean k;
    public cn.admobiletop.adsuyi.adapter.tianmu.c.a.a l;

    public c(String str) {
        super(str);
    }

    public final boolean a(Activity activity) {
        return !(activity instanceof BaseActivity);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.tianmu.a.a, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        cn.admobiletop.adsuyi.adapter.tianmu.c.a.a aVar = this.l;
        if (aVar != null) {
            aVar.dismiss();
            this.l = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo
    public void showInnerNoticeAd(@NonNull Activity activity) {
        if (activity == null || isReleased() || !isReady() || hasShown() || hasExpired() || getAdapterAdInfo() == null || !a(activity)) {
            return;
        }
        this.k = true;
        cn.admobiletop.adsuyi.adapter.tianmu.c.a.a aVar = new cn.admobiletop.adsuyi.adapter.tianmu.c.a.a(activity);
        this.l = aVar;
        aVar.setNotificationListener(new b(this));
        this.l.render(getAdapterAdInfo().getImageUrl(), getAdapterAdInfo().getTitle(), getAdapterAdInfo().getDesc(), R.drawable.adsuyi_tianmu_platform_icon);
        this.l.show();
        if (getAdapterAdInfo() == null || this.l == null) {
            return;
        }
        getAdapterAdInfo().registerView(this.l.getNoticeAdContainer(), (View[]) this.l.getClickViewListAll().toArray(new View[this.l.getClickViewListAll().size()]));
    }
}
