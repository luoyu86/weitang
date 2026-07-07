package cn.admobiletop.adsuyi.a.n;

import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;

/* JADX INFO: loaded from: classes.dex */
public class d extends ADSuyiSingleClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f3464d;

    public d(g gVar) {
        this.f3464d = gVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
    public void onSingleClick(View view) {
        this.f3464d.i(true);
    }
}
