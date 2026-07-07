package com.tianmu.j.b.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class d extends TextureView implements a, TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f12331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SurfaceTexture f12332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private com.tianmu.j.b.c.a f12333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Surface f12334d;

    public d(Context context) {
        super(context);
        this.f12331a = new b();
        setSurfaceTextureListener(this);
    }

    @Override // com.tianmu.j.b.d.a
    public View a() {
        return this;
    }

    @Override // com.tianmu.j.b.d.a
    public void a(@NonNull com.tianmu.j.b.c.a aVar) {
        this.f12333c = aVar;
    }

    @Override // com.tianmu.j.b.d.a
    public void b(int i2) {
        this.f12331a.b(i2);
        setRotation(i2);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int[] iArrA = this.f12331a.a(i2, i3);
        setMeasuredDimension(iArrA[0], iArrA[1]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = this.f12332b;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f12332b = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.f12334d = surface;
        com.tianmu.j.b.c.a aVar = this.f12333c;
        if (aVar != null) {
            aVar.a(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.tianmu.j.b.d.a
    public void release() {
        Surface surface = this.f12334d;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.f12332b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // com.tianmu.j.b.d.a
    public void a(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12331a.b(i2, i3);
        requestLayout();
    }

    @Override // com.tianmu.j.b.d.a
    public void a(int i2) {
        this.f12331a.a(i2);
        requestLayout();
    }
}
