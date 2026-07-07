package com.tianmu.g;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class g implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f12065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<ImageView> f12066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f12067c;

    public g(w wVar, ImageView imageView, e eVar) {
        this.f12065a = wVar;
        this.f12066b = new WeakReference<>(imageView);
        this.f12067c = eVar;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void a() {
        this.f12067c = null;
        ImageView imageView = this.f12066b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f12066b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f12065a.b().a(width, height).a(imageView, this.f12067c);
        }
        return true;
    }
}
