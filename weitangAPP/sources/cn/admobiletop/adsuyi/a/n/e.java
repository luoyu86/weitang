package cn.admobiletop.adsuyi.a.n;

import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;

/* JADX INFO: loaded from: classes.dex */
public class e extends ADSuyiSingleClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f3465d;

    public e(g gVar) {
        this.f3465d = gVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
    public void onSingleClick(View view) {
        this.f3465d.i(true);
    }
}
