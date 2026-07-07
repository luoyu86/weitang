package cn.admobiletop.adsuyi.ad.widget;

import android.content.Context;
import android.view.View;
import cn.admobiletop.adsuyi.a.n.c;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiInterceptContainer extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3564a;

    public ADSuyiInterceptContainer(Context context) {
        super(context);
    }

    @Override // cn.admobiletop.adsuyi.a.n.c
    public void addResponseClickView(View view) {
        super.addResponseClickView(view);
    }

    @Override // cn.admobiletop.adsuyi.a.n.c
    public String getPosId() {
        return this.f3564a;
    }

    public void setPosId(String str) {
        this.f3564a = str;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
    }
}
