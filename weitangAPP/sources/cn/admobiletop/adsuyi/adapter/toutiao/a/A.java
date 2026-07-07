package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;

/* JADX INFO: loaded from: classes.dex */
public class A extends ADSuyiSingleClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ J f3866d;

    public A(J j) {
        this.f3866d = j;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
    public void onSingleClick(View view) {
        if (this.f3866d.m != null) {
            this.f3866d.m.post(new RunnableC0295z(this));
        }
    }
}
