package cn.admobiletop.adsuyi.c;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ViewTreeObserverOnPreDrawListenerC0334n implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f4237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<ImageView> f4238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0332l f4239c;

    public ViewTreeObserverOnPreDrawListenerC0334n(H h2, ImageView imageView, InterfaceC0332l interfaceC0332l) {
        this.f4237a = h2;
        this.f4238b = new WeakReference<>(imageView);
        this.f4239c = interfaceC0332l;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void a() {
        this.f4239c = null;
        ImageView imageView = this.f4238b.get();
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
        ImageView imageView = this.f4238b.get();
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
            this.f4237a.b().a(width, height).a(imageView, this.f4239c);
        }
        return true;
    }
}
