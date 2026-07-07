package cn.admobiletop.adsuyi.adapter.toutiao.f;

import android.view.View;
import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.adapter.toutiao.f.b;

/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f4066a;

    public a(b bVar) {
        this.f4066a = bVar;
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.f.b.a
    public void a() {
        this.f4066a.startRefreshDelayed();
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.f.b.a
    public void a(View view) {
        this.f4066a.removeAllViews();
        this.f4066a.addView(view, new RelativeLayout.LayoutParams(-1, -2));
    }
}
