package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public class e implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3775a;

    public e(f fVar) {
        this.f3775a = fVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        try {
            this.f3775a.getWindow().setWindowAnimations(0);
        } catch (Throwable unused) {
        }
    }
}
