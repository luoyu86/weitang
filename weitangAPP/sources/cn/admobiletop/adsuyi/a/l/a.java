package cn.admobiletop.adsuyi.a.l;

import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class a implements IGetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3365a;

    public a(b bVar) {
        this.f3365a = bVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        this.f3365a.f3369d = str;
    }

    @Override // cn.admobiletop.adsuyi.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
    }
}
