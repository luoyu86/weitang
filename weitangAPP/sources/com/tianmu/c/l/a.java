package com.tianmu.c.l;

import android.view.View;
import android.view.ViewGroup;
import com.tianmu.c.c.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11822a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11823b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f11824c;

    private void a(View view, long j) {
        this.f11822a = j;
        onSingleClick(view);
    }

    public ViewGroup getContainer() {
        return this.f11824c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int id = view.getId();
        if (this.f11823b != id) {
            this.f11823b = id;
            a(view, jCurrentTimeMillis);
        } else if (jCurrentTimeMillis - this.f11822a > 500) {
            a(view, jCurrentTimeMillis);
        }
    }

    public abstract void onSingleClick(View view);

    @Override // com.tianmu.c.c.h
    public void performClick(View view) {
        super.performClick(view);
    }

    public void setContainer(ViewGroup viewGroup) {
        this.f11824c = viewGroup;
    }
}
