package com.tianmu.j.a.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.c.f.a1;

/* JADX INFO: loaded from: classes2.dex */
public class e extends FrameLayout implements com.tianmu.j.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.j.b.a.b f12254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f12255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tianmu.j.a.c.a f12256c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f12256c == null) {
                return;
            }
            if (e.this.f12256c.c()) {
                e.this.f12256c.a(false);
            } else {
                e.this.f12256c.a(true);
            }
            e.this.b();
        }
    }

    public e(@NonNull Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(a1.f11258a, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(a1.f11259b);
        this.f12255b = imageView;
        imageView.setOnClickListener(new a());
    }

    private void c() {
        com.tianmu.j.a.c.a aVar = this.f12256c;
        if (aVar == null || !aVar.b()) {
            return;
        }
        this.f12256c.d();
    }

    private void d() {
        com.tianmu.j.a.c.a aVar = this.f12256c;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.tianmu.j.b.a.c
    @Nullable
    public View a() {
        return this;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(boolean z, Animation animation) {
    }

    @Override // com.tianmu.j.b.a.c
    public void b(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.tianmu.j.a.c.a aVar = this.f12256c;
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        com.tianmu.j.b.a.b bVar = this.f12254a;
        if (bVar != null) {
            bVar.a(aVar.c());
        }
        if (this.f12255b != null) {
            if (this.f12256c.c()) {
                this.f12255b.setImageResource(com.tianmu.c.f.c.f11279e);
            } else {
                this.f12255b.setImageResource(com.tianmu.c.f.c.f11280f);
            }
        }
    }

    @Override // com.tianmu.j.b.a.c
    public void a(@NonNull com.tianmu.j.b.a.b bVar) {
        this.f12254a = bVar;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2) {
        if (i2 == 3) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        if (i2 == 1) {
            c();
        }
        if (i2 == 5) {
            d();
        }
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2, int i3) {
        com.tianmu.j.a.c.a aVar = this.f12256c;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public void a(com.tianmu.j.a.c.a aVar) {
        this.f12256c = aVar;
        b();
    }
}
