package cn.admobiletop.adsuyi.adapter.toutiao.c;

import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes.dex */
public class a implements TTAdSdk.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4057a;

    public a(d dVar) {
        this.f4057a = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
    public void fail(int i2, String str) {
        ADSuyiLogUtil.d("toutiaoadapter init fail code: " + i2 + " msg: " + str);
        ADSuyiIniter.setInited(false);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
    public void success() {
        ADSuyiLogUtil.d("toutiaoadapter init success");
    }
}
