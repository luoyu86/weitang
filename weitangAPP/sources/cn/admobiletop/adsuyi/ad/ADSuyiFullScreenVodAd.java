package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiFullScreenVodAd extends u<ADSuyiFullScreenVodAdListener> {
    public ADSuyiFullScreenVodAd(@NonNull Activity activity) {
        super(activity);
        setTimeout(60000L);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return ADSuyiAdType.TYPE_FULLSCREEN_VOD;
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void loadAd(String str, int i2) {
        super.loadAd(str, 1);
    }

    public ADSuyiFullScreenVodAd(@NonNull Fragment fragment) {
        super(fragment);
        setTimeout(60000L);
    }
}
