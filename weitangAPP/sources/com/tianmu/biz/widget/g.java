package com.tianmu.biz.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.listener.VideoAdListener;
import com.tianmu.biz.bean.VideoAutoPlayType;
import com.tianmu.biz.widget.a;
import com.tianmu.config.TianmuImageLoader;

/* JADX INFO: loaded from: classes2.dex */
public class g extends RelativeLayout implements a.InterfaceC0188a, com.tianmu.c.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f10990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ViewGroup.LayoutParams f10994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f10995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.tianmu.j.a.c.a f10996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private VideoAdListener f10998i;
    private com.tianmu.c.j.c j;
    private boolean k;

    public class a extends com.tianmu.listener.a {
        public a() {
        }

        @Override // com.tianmu.listener.a, com.tianmu.g.e
        public void onError() {
            if (g.this.f10998i != null) {
                g.this.f10998i.onVideoCoverLoadError();
            }
        }

        @Override // com.tianmu.listener.a, com.tianmu.g.e
        public void onSuccess() {
            if (g.this.f10998i != null) {
                g.this.f10998i.onVideoCoverLoadSuccess();
            }
        }
    }

    public g(Context context, String str, String str2, com.tianmu.j.a.c.a aVar, int i2, int i3, VideoAdListener videoAdListener, ViewGroup.LayoutParams layoutParams, Integer num, boolean z) {
        super(context);
        this.f10991b = str2;
        this.f10996g = aVar;
        this.f10992c = i2;
        this.f10993d = i3;
        this.f10994e = layoutParams;
        this.f10997h = str;
        this.f10998i = videoAdListener;
        this.f10995f = Integer.valueOf(hashCode());
        this.k = z;
        i();
        g();
    }

    private void b(boolean z) {
        com.tianmu.biz.widget.a aVarF = f();
        if (aVarF != null) {
            if (!z) {
                aVarF.F();
            } else if (aVarF.G()) {
                aVarF.J();
            }
        }
    }

    private com.tianmu.biz.widget.a f() {
        com.tianmu.biz.widget.a aVarA = com.tianmu.c.n.d.a().a(this.f10995f);
        if (aVarA == null) {
            aVarA = new com.tianmu.biz.widget.a(getContext(), this.f10991b, this.f10997h, this.f10996g);
            aVarA.c(this.f10992c);
            aVarA.a(this.f10996g.c());
            ViewGroup.LayoutParams layoutParams = this.f10994e;
            if (layoutParams == null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                addView(aVarA, layoutParams2);
            } else {
                addView(aVarA, layoutParams);
            }
            aVarA.a((a.InterfaceC0188a) this);
            com.tianmu.c.n.d.a().a(this.f10995f, aVarA);
        }
        return aVarA;
    }

    private void g() {
        if (this.j == null) {
            this.j = new com.tianmu.c.j.c(true, false, this);
        }
    }

    private boolean h() {
        com.tianmu.j.a.c.a aVar = this.f10996g;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    private void i() {
        if (TextUtils.isEmpty(this.f10997h)) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.f10990a = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TianmuImageLoader imageLoader = TianmuSDK.getInstance().getImageLoader();
        if (imageLoader != null) {
            imageLoader.loadImage(getContext(), this.f10997h, this.f10990a, new a());
        } else {
            VideoAdListener videoAdListener = this.f10998i;
            if (videoAdListener != null) {
                videoAdListener.onVideoCoverLoadError();
            }
        }
        addView(this.f10990a, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void j() {
        com.tianmu.biz.widget.a aVarF = f();
        if (aVarF != null) {
            aVarF.J();
        }
    }

    private void k() {
        com.tianmu.c.j.c cVar = this.j;
        if (cVar != null) {
            cVar.e();
            this.j = null;
        }
    }

    private void l() {
        if (!this.k) {
            m();
            return;
        }
        com.tianmu.c.j.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    private void m() {
        com.tianmu.biz.widget.a aVarF = f();
        if (aVarF != null) {
            try {
                if (!hasWindowFocus()) {
                    b(true);
                } else if (h()) {
                } else {
                    aVarF.I();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        com.tianmu.biz.widget.a aVarA = com.tianmu.c.n.d.a().a(this.f10995f);
        if (aVarA != null) {
            aVarA.J();
        }
    }

    public void d() {
        removeAllViews();
        com.tianmu.c.n.d.a().b(this.f10995f);
        k();
    }

    public void e() {
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b(true);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f10994e == null) {
            setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
            int measuredWidth = getMeasuredWidth();
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, WXVideoFileObject.FILE_SIZE_LIMIT);
            i3 = View.MeasureSpec.makeMeasureSpec((int) ((measuredWidth * 9.0f) / 16.0f), WXVideoFileObject.FILE_SIZE_LIMIT);
            i2 = iMakeMeasureSpec;
        }
        super.onMeasure(i2, i3);
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoCompletion(int i2) {
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoError() {
        a(f(), 8);
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPosition(int i2, int i3) {
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPrepared(long j) {
    }

    @Override // com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoStart() {
        com.tianmu.j.a.c.a aVar;
        com.tianmu.biz.widget.a aVarF = f();
        if (aVarF == null || h() || (aVar = this.f10996g) == null || aVar.a() <= 0) {
            return;
        }
        aVarF.a(this.f10996g.a());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a(false);
    }

    private void a(View view, int i2) {
        if (view == null || view.getVisibility() == i2) {
            return;
        }
        view.setVisibility(i2);
    }

    public void a(boolean z) {
        boolean zIsNativeAutoPlayVideo;
        com.tianmu.biz.widget.a aVarF = f();
        if (aVarF != null) {
            int i2 = this.f10993d;
            if (i2 == VideoAutoPlayType.DEFAULT_PLAY) {
                zIsNativeAutoPlayVideo = VideoAutoPlayType.isNativeAutoPlayVideo();
            } else {
                zIsNativeAutoPlayVideo = i2 == VideoAutoPlayType.AUTO_PLAY;
            }
            if (!hasWindowFocus()) {
                b(z);
                return;
            }
            if (!aVarF.e() && zIsNativeAutoPlayVideo) {
                l();
            } else {
                if (aVarF.e() || zIsNativeAutoPlayVideo) {
                    return;
                }
                b(z);
            }
        }
    }

    @Override // com.tianmu.c.j.d
    public void b() {
        m();
    }

    @Override // com.tianmu.c.j.d
    public void a() {
        j();
    }
}
