package com.tianmu.j.a.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tianmu.c.f.h0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends FrameLayout implements com.tianmu.j.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.j.b.a.b f12245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageView f12246b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f12245a.g();
        }
    }

    public c(@NonNull Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(h0.f11386a, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(h0.f11387b);
        this.f12246b = imageView;
        imageView.setOnClickListener(new a());
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
    }

    @Override // com.tianmu.j.b.a.c
    public void a(@NonNull com.tianmu.j.b.a.b bVar) {
        this.f12245a = bVar;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2) {
        switch (i2) {
            case -1:
            case 0:
            case 1:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
                setVisibility(8);
                break;
            case 4:
                setVisibility(0);
                break;
        }
    }
}
