package cn.admobiletop.adsuyi.adapter.tianmu;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import com.tianmu.config.TianmuCustomController;
import com.tianmu.config.TianmuLocationProvider;

/* JADX INFO: loaded from: classes.dex */
public class b extends TianmuCustomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ADSuyiIniter f3791a;

    public b(ADSuyiIniter aDSuyiIniter) {
        this.f3791a = aDSuyiIniter;
    }

    @Override // com.tianmu.config.TianmuCustomController
    public String getAndroidId() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            return ADSuyiSdk.getInstance().getAndroidId(ADSuyiSdk.getInstance().getContext());
        }
        return null;
    }

    @Override // com.tianmu.config.TianmuCustomController
    public String getDevImei() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            return ADSuyiSdk.getInstance().getImei(ADSuyiSdk.getInstance().getContext());
        }
        return null;
    }

    @Override // com.tianmu.config.TianmuCustomController
    public String getDevOaid() {
        return ADSuyiSdk.getInstance().getOAID();
    }

    @Override // com.tianmu.config.TianmuCustomController
    public String getDevVaid() {
        return ADSuyiSdk.getInstance().getVAID();
    }

    @Override // com.tianmu.config.TianmuCustomController
    public String getMacAddress() {
        if (ADSuyiSdk.getInstance().getContext() != null) {
            return ADSuyiSdk.getInstance().getMac(ADSuyiSdk.getInstance().getContext());
        }
        return null;
    }

    @Override // com.tianmu.config.TianmuCustomController
    public TianmuLocationProvider getTianmuLocation() {
        return new a(this);
    }
}
