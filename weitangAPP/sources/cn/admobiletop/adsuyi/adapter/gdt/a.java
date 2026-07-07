package cn.admobiletop.adsuyi.adapter.gdt;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.qq.e.comm.managers.GDTAdSdk;

/* JADX INFO: loaded from: classes.dex */
public class a implements GDTAdSdk.OnStartListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ADSuyiIniter f3618a;

    public a(ADSuyiIniter aDSuyiIniter) {
        this.f3618a = aDSuyiIniter;
    }

    @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
    public void onStartFailed(Exception exc) {
        ADSuyiLogUtil.d("gdtadapter init fail msg: " + exc.toString());
        boolean unused = ADSuyiIniter.f3617b = false;
    }

    @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
    public void onStartSuccess() {
        ADSuyiLogUtil.d("gdtadapter init success");
    }
}
