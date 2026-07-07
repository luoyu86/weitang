package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewStatusListener f9619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewStatus f9620b;

    /* JADX INFO: renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9621a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f9621a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9621a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f9620b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9620b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9620b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f9619a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f9620b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f9619a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f9620b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f9619a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z);
        ViewStatusListener viewStatusListener = this.f9619a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i2);
        ViewStatusListener viewStatusListener = this.f9619a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i2);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f9619a = viewStatusListener;
        if (viewStatusListener != null) {
            int iOrdinal = this.f9620b.ordinal();
            if (iOrdinal == 1) {
                this.f9619a.onAttachToWindow();
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                this.f9619a.onDetachFromWindow();
            }
        }
    }
}
