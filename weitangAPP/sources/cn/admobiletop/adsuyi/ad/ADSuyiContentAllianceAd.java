package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiContentAllianceAdListener;
import cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiContentAllianceAd extends u<ADSuyiContentAllianceAdListener> implements ADSuyiSceneAd {
    public String m;

    public ADSuyiContentAllianceAd(@NonNull Activity activity) {
        super(activity);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return ADSuyiAdType.TYPE_CONTENT_ALLIANCE;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public String getSceneId() {
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void loadAd(String str, int i2) {
        super.loadAd(str, 1);
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public void setSceneId(String str) {
        this.m = str;
    }

    public ADSuyiContentAllianceAd(@NonNull Fragment fragment) {
        super(fragment);
    }
}
