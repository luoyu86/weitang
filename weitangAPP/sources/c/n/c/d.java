package c.n.c;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import c.n.a.a;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<ViewPropertyAnimator> f2941b;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0045a f2942a;

        public a(a.InterfaceC0045a interfaceC0045a) {
            this.f2942a = interfaceC0045a;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2942a.onAnimationCancel(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2942a.onAnimationEnd(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.f2942a.onAnimationRepeat(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2942a.onAnimationStart(null);
        }
    }

    public d(View view) {
        this.f2941b = new WeakReference<>(view.animate());
    }

    @Override // c.n.c.b
    public b alpha(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b alphaBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // c.n.c.b
    public long getDuration() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // c.n.c.b
    public long getStartDelay() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // c.n.c.b
    public b rotation(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b rotationBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b rotationX(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b rotationXBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b rotationY(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b rotationYBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b scaleX(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b scaleXBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b scaleY(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b scaleYBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b setDuration(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    @Override // c.n.c.b
    public b setInterpolator(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // c.n.c.b
    public b setListener(a.InterfaceC0045a interfaceC0045a) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            if (interfaceC0045a == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new a(interfaceC0045a));
            }
        }
        return this;
    }

    @Override // c.n.c.b
    public b setStartDelay(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    @Override // c.n.c.b
    public void start() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // c.n.c.b
    public b translationX(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b translationXBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b translationY(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b translationYBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b x(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b xBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b y(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f2);
        }
        return this;
    }

    @Override // c.n.c.b
    public b yBy(float f2) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2941b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f2);
        }
        return this;
    }
}
