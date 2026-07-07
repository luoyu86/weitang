package com.tianmu.biz.widget.l;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.q0;
import com.tianmu.biz.web.d;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.d1;
import com.tianmu.c.f.m0;
import com.tianmu.config.TianmuImageLoader;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RoundedImageView f11077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f11079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f11080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f11081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f11082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f11083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout f11084i;
    private TextView j;
    private TextView k;
    private WebView l;
    private AnimationSet m;

    public b(@NonNull Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tianmu.c.i.a aVar, com.tianmu.c.l.a aVar2, com.tianmu.c.l.a aVar3, com.tianmu.c.l.a aVar4) {
        super(context, d1.f11317a);
        setContentView(m0.f11445a);
        a(str6);
        a(aVar2, aVar3, aVar4);
        a(str, str2, str3, str4, str5, str7, aVar);
        d();
    }

    private void b() {
        try {
            TextView textView = this.f11082g;
            if (textView != null) {
                textView.clearAnimation();
            }
            TextView textView2 = this.f11083h;
            if (textView2 != null) {
                textView2.clearAnimation();
            }
            AnimationSet animationSet = this.m;
            if (animationSet != null) {
                animationSet.cancel();
                this.m = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c() {
        if (this.f11082g == null || this.f11083h == null) {
            return;
        }
        try {
            this.m = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(570L);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            this.m.addAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.15f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(600L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.m.addAnimation(scaleAnimation);
            this.f11082g.startAnimation(this.m);
            this.f11083h.startAnimation(scaleAnimation);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setGravity(17);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                attributes.dimAmount = 0.75f;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FrameLayout a() {
        return this.f11084i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        d.b(this.l);
        b();
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(2822);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    private void a(String str) {
        this.f11076a = (TextView) findViewById(m0.f11446b);
        this.f11077b = (RoundedImageView) findViewById(m0.f11447c);
        this.f11078c = (TextView) findViewById(m0.f11448d);
        this.f11079d = (TextView) findViewById(m0.f11449e);
        this.f11082g = (TextView) findViewById(m0.f11450f);
        this.f11083h = (TextView) findViewById(m0.f11451g);
        this.f11081f = (TextView) findViewById(m0.f11452h);
        this.f11084i = (FrameLayout) findViewById(m0.f11453i);
        this.j = (TextView) findViewById(m0.j);
        this.k = (TextView) findViewById(m0.k);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(m0.l);
        if (TextUtils.isEmpty(str)) {
            ImageView imageView = new ImageView(getContext());
            this.f11080e = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            relativeLayout.addView(this.f11080e, 0, new RelativeLayout.LayoutParams(-1, -1));
            return;
        }
        WebView webView = new WebView(getContext().getApplicationContext());
        this.l = webView;
        d.a(webView);
        try {
            this.l.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        relativeLayout.addView(this.l, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void a(com.tianmu.c.l.a aVar, com.tianmu.c.l.a aVar2, com.tianmu.c.l.a aVar3) {
        findViewById(m0.m).setOnClickListener(aVar);
        findViewById(m0.f11453i).setOnClickListener(aVar2);
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, com.tianmu.c.i.a aVar) {
        ImageView imageView;
        this.f11078c.setText(str3);
        this.f11079d.setText(str4);
        this.f11081f.setText(str5);
        this.j.setText(TextUtils.isEmpty(str6) ? c1.j : c1.k);
        if (TextUtils.isEmpty(str6)) {
            this.j.setText(c1.j);
        } else {
            this.k.setText(str6);
            this.k.setVisibility(0);
            this.j.setText(c1.k);
        }
        TianmuImageLoader imageLoader = TianmuSDK.getInstance().getImageLoader();
        if (imageLoader != null && !TextUtils.isEmpty(str) && (imageView = this.f11080e) != null) {
            imageLoader.loadImage(imageView.getContext(), str, this.f11080e);
        }
        if (imageLoader != null && !TextUtils.isEmpty(str2)) {
            imageLoader.loadImage(this.f11077b.getContext(), str2, this.f11077b);
            this.f11077b.a(TianmuDisplayUtil.dp2px(8));
        }
        if (aVar != null) {
            this.f11076a.setText(q0.a(getContext(), aVar, true));
        }
    }
}
