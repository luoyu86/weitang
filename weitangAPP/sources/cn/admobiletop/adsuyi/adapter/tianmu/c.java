package cn.admobiletop.adsuyi.adapter.tianmu;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.listener.TianmuInitListener;

/* JADX INFO: loaded from: classes.dex */
public class c implements TianmuInitListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ADSuyiIniter f3833a;

    public c(ADSuyiIniter aDSuyiIniter) {
        this.f3833a = aDSuyiIniter;
    }

    @Override // com.tianmu.listener.TianmuInitListener
    public void onInitFailed(TianmuError tianmuError) {
        ADSuyiLogUtil.d("tianmuadapter init fail code: " + tianmuError.getCode() + " msg: " + tianmuError.getError());
    }

    @Override // com.tianmu.listener.TianmuInitListener
    public void onInitFinished() {
        ADSuyiLogUtil.d("tianmuadapter init success");
    }
}
