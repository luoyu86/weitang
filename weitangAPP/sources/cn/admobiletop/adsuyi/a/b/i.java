package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class i implements ADSuyiParallelCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3184a;

    public i(k kVar) {
        this.f3184a = kVar;
    }

    @Override // cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback
    public void onFailed(String str, String str2) {
        if (this.f3184a.G == null) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "ADSuyiParallelCallback onFailed 状态已被释放 抛弃本次结果- 1");
            return;
        }
        this.f3184a.f();
        if (this.f3184a.G.b()) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "ADSuyiParallelCallback onFailed 状态已经赋值 ，抛弃本次结果- 2");
            return;
        }
        ADSuyiLogUtil.ti("ADSuyiParallel", "ADSuyiParallelCallback onFailed - 0 " + str2);
        this.f3184a.G.a(true);
        this.f3184a.G.b(false);
        this.f3184a.H.a();
    }

    @Override // cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback
    public void onSuccess() {
        if (this.f3184a.G == null) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "ADSuyiParallelCallback onSuccess 状态已被释放 抛弃本次结果- 1");
            return;
        }
        this.f3184a.f();
        if (this.f3184a.G.b()) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "ADSuyiParallelCallback onSuccess 状态已经赋值 ，抛弃本次结果 - 2");
            return;
        }
        ADSuyiLogUtil.ti("ADSuyiParallel", "ADSuyiParallelCallback onSuccess - 0");
        this.f3184a.G.a(true);
        this.f3184a.G.b(true);
        this.f3184a.H.a();
    }
}
