package com.tianmu.j.a.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tianmu.c.f.n;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout implements com.tianmu.j.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.j.b.a.b f12239a;

    /* JADX INFO: renamed from: com.tianmu.j.a.b.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0227a implements View.OnClickListener {
        public ViewOnClickListenerC0227a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f12239a.b(true);
        }
    }

    public a(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(n.f11454a, (ViewGroup) this, true);
        findViewById(n.f11455b).setOnClickListener(new ViewOnClickListenerC0227a());
    }

    @Override // com.tianmu.j.b.a.c
    public View a() {
        return this;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2, int i3) {
    }

    @Override // com.tianmu.j.b.a.c
    public void a(boolean z, Animation animation) {
    }

    @Override // com.tianmu.j.b.a.c
    public void b(int i2) {
        if (com.tianmu.j.b.e.b.c(getContext()) != null) {
            this.f12239a.a();
        }
    }

    @Override // com.tianmu.j.b.a.c
    public void a(@NonNull com.tianmu.j.b.a.b bVar) {
        this.f12239a = bVar;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2) {
        if (i2 == 5) {
            setVisibility(0);
            bringToFront();
        } else {
            setVisibility(8);
        }
    }
}
