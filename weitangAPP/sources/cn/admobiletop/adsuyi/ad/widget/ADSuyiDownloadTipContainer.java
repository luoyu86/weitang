package cn.admobiletop.adsuyi.ad.widget;

import android.app.Activity;
import android.view.View;
import cn.admobiletop.adsuyi.a.n.b;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiDownloadTipContainer extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f3562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3563h;

    public ADSuyiDownloadTipContainer(Activity activity, boolean z) {
        super(activity, z);
        this.f3563h = true;
    }

    @Override // cn.admobiletop.adsuyi.a.n.b
    public void b() {
        this.f3563h = false;
    }

    @Override // cn.admobiletop.adsuyi.a.n.b
    public boolean d() {
        return this.f3563h;
    }

    @Override // cn.admobiletop.adsuyi.a.n.b
    public View getRespondClickView() {
        return this.f3562g;
    }

    public void setNeedDownloadTip(boolean z) {
        this.f3563h = z;
    }

    public void setRespondClickView(View view) {
        this.f3562g = view;
    }
}
