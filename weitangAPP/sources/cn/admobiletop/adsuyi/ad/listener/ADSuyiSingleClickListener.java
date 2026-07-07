package cn.admobiletop.adsuyi.ad.listener;

import android.view.View;
import android.view.ViewGroup;
import cn.admobiletop.adsuyi.a.b.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class ADSuyiSingleClickListener extends r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3549a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3550b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f3551c;

    public final void a(View view, long j) {
        this.f3549a = j;
        onSingleClick(view);
    }

    public ViewGroup getContainer() {
        return this.f3551c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int id = view.getId();
        if (this.f3550b != id) {
            this.f3550b = id;
            a(view, jCurrentTimeMillis);
        } else if (jCurrentTimeMillis - this.f3549a > 150) {
            a(view, jCurrentTimeMillis);
        }
    }

    public abstract void onSingleClick(View view);

    @Override // cn.admobiletop.adsuyi.a.b.r
    public void performClick(View view) {
        super.performClick(view);
    }

    public void setContainer(ViewGroup viewGroup) {
        this.f3551c = viewGroup;
    }
}
