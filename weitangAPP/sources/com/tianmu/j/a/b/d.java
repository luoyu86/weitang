package com.tianmu.j.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.c.f.j0;
import com.tianmu.j.b.c.k;

/* JADX INFO: loaded from: classes2.dex */
public class d extends FrameLayout implements com.tianmu.j.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.j.b.a.b f12248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageView f12249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageView f12250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ProgressBar f12251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f12252e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f12252e.setVisibility(8);
            k.c().a(true);
            d.this.f12248a.g();
        }
    }

    public d(@NonNull Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(j0.f11401a, (ViewGroup) this, true);
        this.f12249b = (ImageView) findViewById(j0.f11402b);
        this.f12250c = (ImageView) findViewById(j0.f11403c);
        this.f12251d = (ProgressBar) findViewById(j0.f11404d);
        this.f12252e = (FrameLayout) findViewById(j0.f11405e);
        findViewById(j0.f11406f).setOnClickListener(new a());
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

    public void a(String str) {
        if (this.f12249b == null || TextUtils.isEmpty(str)) {
            return;
        }
        TianmuSDK.getInstance().getImageLoader().loadImage(getContext(), str, this.f12249b);
    }

    @Override // com.tianmu.j.b.a.c
    public void a(@NonNull com.tianmu.j.b.a.b bVar) {
        this.f12248a = bVar;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2) {
        switch (i2) {
            case -1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setVisibility(8);
                break;
            case 0:
                setVisibility(0);
                bringToFront();
                this.f12251d.setVisibility(8);
                this.f12252e.setVisibility(8);
                this.f12250c.setVisibility(0);
                this.f12249b.setVisibility(0);
                break;
            case 1:
                bringToFront();
                setVisibility(0);
                this.f12250c.setVisibility(8);
                this.f12252e.setVisibility(8);
                this.f12251d.setVisibility(0);
                break;
            case 8:
                setVisibility(0);
                this.f12252e.setVisibility(0);
                this.f12252e.bringToFront();
                break;
        }
    }
}
