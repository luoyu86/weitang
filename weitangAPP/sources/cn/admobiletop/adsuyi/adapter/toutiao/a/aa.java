package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.os.Bundle;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f3896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ba f3897d;

    public aa(ba baVar, boolean z, int i2, Bundle bundle) {
        this.f3897d = baVar;
        this.f3894a = z;
        this.f3895b = i2;
        this.f3896c = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3897d.getAdListener() != 0) {
            HashMap map = new HashMap();
            map.put("isRewardValid", Boolean.valueOf(this.f3894a));
            map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(this.f3895b));
            map.put(MediationConstant.KEY_EXTRA_INFO, this.f3896c);
            this.f3897d.a(map);
            ((ADSuyiRewardVodAdListener) this.f3897d.getAdListener()).onReward(this.f3897d);
        }
    }
}
