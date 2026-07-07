package com.tianmu.biz.widget.n.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.r0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c {
    public static int s = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f11131q;
    private TranslateAnimation r;

    public a(Context context, String str) {
        super(context, false, false, str);
        new HashMap();
    }

    @Override // com.tianmu.biz.widget.n.e.c, com.tianmu.biz.widget.n.a
    public void b(boolean z) {
        if (z) {
            this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        } else {
            this.f11113e = 32;
        }
    }

    @Override // com.tianmu.biz.widget.n.e.c, com.tianmu.biz.widget.n.a
    public void d() {
        TranslateAnimation translateAnimation = this.r;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        ImageView imageView = this.f11131q;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    @Override // com.tianmu.biz.widget.n.e.c
    public void e() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(r0.f11504a, (ViewGroup) this, true);
        this.f11109a = viewInflate;
        this.f11131q = (ImageView) viewInflate.findViewById(r0.f11505b);
        a(a(2, 21, this.f11114f, c1.f11294b));
    }

    @Override // com.tianmu.biz.widget.n.e.c
    public void g() {
        if (this.r == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 15.0f, 0, -15.0f);
            this.r = translateAnimation;
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            this.r.setDuration(1000L);
            this.r.setRepeatCount(-1);
            this.r.setRepeatMode(2);
        }
        this.f11131q.startAnimation(this.r);
    }

    @Override // com.tianmu.biz.widget.n.e.c, com.tianmu.biz.widget.n.a
    public void b() {
        super.b();
        ImageView imageView = this.f11131q;
        if (imageView != null) {
            imageView.clearAnimation();
            this.f11131q = null;
        }
        TranslateAnimation translateAnimation = this.r;
        if (translateAnimation != null) {
            translateAnimation.cancel();
            this.r = null;
        }
    }
}
