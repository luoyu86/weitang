package cn.admobiletop.adsuyi.a.n.a;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends RelativeLayout implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObjectAnimator f3448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3449c;

    public g(@NonNull Context context) {
        this(context, null);
    }

    public final void a() {
        e();
        g();
    }

    public final void c() {
        ObjectAnimator objectAnimator = this.f3448b;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f3448b = null;
        }
    }

    public final void d() {
        e();
        this.f3447a = null;
    }

    public final void e() {
        Handler handler = this.f3447a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void f() {
        if (this.f3447a != null) {
            e();
            this.f3447a.postDelayed(new e(this), 10000L);
        }
    }

    public final void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, 0.0f);
        this.f3448b = objectAnimatorOfFloat;
        try {
            objectAnimatorOfFloat.setDuration(150L);
            this.f3448b.start();
            this.f3448b.addListener(new f(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract ADSuyiNoticeListener2 getNotificationListener();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(this.f3449c, getMeasuredWidth()), WXVideoFileObject.FILE_SIZE_LIMIT), i3);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        d();
        c();
    }

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3447a = new Handler(Looper.getMainLooper());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f3449c = (Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) * 2) / 3;
    }
}
