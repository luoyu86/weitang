package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ca extends cn.admobiletop.adsuyi.adapter.toutiao.a.T {
    public final /* synthetic */ ea s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(ea eaVar, String str, int i2, int i3, Activity activity, String str2) {
        super(str, i2, i3, activity, str2);
        this.s = eaVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        this.s.d(false, this);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        this.s.d(true, this);
    }
}
