package cn.admobiletop.adsuyi.adapter.gdt.widget.a;

import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;

/* JADX INFO: loaded from: classes.dex */
public class a extends ADSuyiSingleClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f3761d;

    public a(b bVar) {
        this.f3761d = bVar;
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
    public void onSingleClick(View view) {
        this.f3761d.d();
    }
}
