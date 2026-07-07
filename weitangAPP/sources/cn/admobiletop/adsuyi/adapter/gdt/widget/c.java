package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.qq.e.ads.nativ.MediaView;

/* JADX INFO: loaded from: classes.dex */
public class c extends FrameLayout implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaView f3771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3773c;

    public c(@NonNull Context context) {
        super(context);
        this.f3772b = true;
        MediaView mediaView = new MediaView(context);
        this.f3771a = mediaView;
        addView(mediaView);
    }

    public boolean a() {
        return this.f3772b;
    }

    public long getIdleTime() {
        return this.f3773c;
    }

    public MediaView getMediaView() {
        return this.f3771a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3772b = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3772b = true;
        this.f3773c = System.currentTimeMillis();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        ADSuyiViewUtil.removeSelfFromParent(this.f3771a);
        this.f3771a = null;
    }
}
