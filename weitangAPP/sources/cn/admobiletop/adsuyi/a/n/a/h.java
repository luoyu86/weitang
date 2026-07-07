package cn.admobiletop.adsuyi.a.n.a;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class h extends RelativeLayout implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector f3450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3458i;
    public float j;
    public Handler k;
    public ObjectAnimator l;
    public boolean m;
    public boolean n;
    public int o;

    public h(@NonNull Context context) {
        this(context, null);
    }

    public final void b() {
        this.f3451b = 3;
        p();
        i();
        j(true);
    }

    public final void c(int i2, int i3) {
        if (this.f3451b == 0) {
            if (Math.abs(i2) > Math.abs(i3)) {
                this.f3451b = i2 > 0 ? 2 : 1;
            } else if (i3 < 0) {
                this.f3451b = 3;
            }
        }
        int i4 = this.f3451b;
        if (i4 != 0) {
            if (1 == i4 || 2 == i4) {
                i3 = 0;
            } else if (3 == i4) {
                i2 = 0;
            }
            setX(getX() + i2);
            setY(Math.min(getY() + i3, this.f3457h));
        }
    }

    public final void d(Context context) {
        this.f3450a = new GestureDetector(context, new b(this));
    }

    public float getClickX() {
        return this.f3458i;
    }

    public float getClickY() {
        return this.j;
    }

    public abstract ADSuyiNoticeListener getNotificationListener();

    public final void i() {
        this.f3454e = getX();
        float y = getY();
        this.f3455f = y;
        if (this.f3456g == -727272.0f && this.f3457h == -727272.0f) {
            this.f3456g = this.f3454e;
            this.f3457h = y;
        }
    }

    public final void j(boolean z) {
        if (this.f3451b == 0) {
            q();
            return;
        }
        l();
        int i2 = this.f3451b;
        if (1 == i2) {
            float x = getX() - this.f3454e;
            boolean z2 = z || Math.abs(x) >= ((float) this.f3452c) / 2.0f;
            this.m = z2;
            if (z2) {
                this.l = ObjectAnimator.ofFloat(this, "translationX", (x - this.f3456g) - this.f3452c);
            }
        } else if (2 == i2) {
            float x2 = getX() - this.f3454e;
            boolean z3 = z || Math.abs(x2) >= ((float) this.f3452c) / 2.0f;
            this.m = z3;
            if (z3) {
                this.l = ObjectAnimator.ofFloat(this, "translationX", x2, ((((ViewGroup) getParent()) == null ? getResources().getDisplayMetrics().widthPixels : r2.getWidth()) - this.f3456g) + this.f3452c);
            }
        } else if (3 == i2) {
            float y = getY() - this.f3455f;
            boolean z4 = z || Math.abs(y) >= ((float) this.f3453d) / 2.0f;
            this.m = z4;
            if (z4) {
                float[] fArr = new float[2];
                fArr[0] = y;
                fArr[1] = z4 ? (-this.f3457h) - this.f3453d : 0.0f;
                this.l = ObjectAnimator.ofFloat(this, "translationY", fArr);
            }
        }
        if (!this.m || this.l == null) {
            m(true);
        } else {
            o(z);
        }
    }

    public final void l() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.l = null;
        }
    }

    public final void m(boolean z) {
        if (getNotificationListener() != null) {
            getNotificationListener().onClick(z);
        }
        setVisibility(8);
        release();
    }

    public final void n() {
        p();
        this.k = null;
    }

    public final void o(boolean z) {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            try {
                this.n = false;
                objectAnimator.setDuration(150L);
                this.l.start();
                this.l.addListener(new d(this, z));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(this.o, getMeasuredWidth()), WXVideoFileObject.FILE_SIZE_LIMIT), i3);
        this.f3452c = getMeasuredWidth();
        this.f3453d = getMeasuredHeight();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!this.m && this.n && 5 != actionMasked && 6 != actionMasked && 65280 != actionMasked && 8 != actionMasked && this.f3450a != null) {
            if (actionMasked == 0) {
                i();
                p();
            }
            this.f3450a.onTouchEvent(motionEvent);
            if (!this.m && (1 == actionMasked || 3 == actionMasked)) {
                this.f3458i = motionEvent.getX();
                this.j = motionEvent.getY();
                j(false);
                this.f3451b = 0;
            }
        }
        return true;
    }

    public final void p() {
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void q() {
        if (this.k != null) {
            p();
            this.k.postDelayed(new c(this), 10000L);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.f3450a = null;
        n();
        l();
    }

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3451b = 0;
        this.f3456g = -727272.0f;
        this.f3457h = -727272.0f;
        this.k = new Handler(Looper.getMainLooper());
        this.n = true;
        d(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.o = (Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) * 2) / 3;
    }
}
