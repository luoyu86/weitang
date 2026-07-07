package com.tianmu.ad.widget.nativeadview.factory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.activity.AppPermissionsActivity;
import com.tianmu.ad.activity.WebViewActivity;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.widget.nativeadview.config.NativeConfig;
import com.tianmu.biz.utils.j;
import com.tianmu.biz.utils.v;
import com.tianmu.biz.widget.m.b;
import com.tianmu.biz.widget.n.a;
import com.tianmu.biz.widget.n.e.b;
import com.tianmu.c.f.c1;
import com.tianmu.g.b0;
import com.tianmu.g.r;
import com.tianmu.listener.a;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeBase extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f10741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RelativeLayout f10742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f10743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f10744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f10745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f10746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f10747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f10748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f10749i;
    public TextView j;
    public ImageView k;
    public Context l;
    public NativeConfig m;
    public NativeExpressAdInfo n;
    public View o;
    private a p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.tianmu.biz.widget.interaction.slideanimalview.a f10750q;
    private b r;
    public com.tianmu.biz.widget.m.b s;
    public ImageView t;
    public int u;
    public int v;
    private View w;

    public NativeBase(Context context, NativeConfig nativeConfig, NativeExpressAdInfo nativeExpressAdInfo) {
        super(context);
        this.m = nativeConfig;
        this.n = nativeExpressAdInfo;
        this.l = context;
        setConfigView();
        getNativeView();
    }

    public static NativeBase init(Context context, String str, NativeConfig nativeConfig, NativeExpressAdInfo nativeExpressAdInfo, a aVar) {
        NativeBase nativeTemplatePicFlow;
        str.hashCode();
        switch (str) {
            case "HORIZON_PIC":
                nativeTemplatePicFlow = new NativeTemplatePicFlow(context, nativeConfig, nativeExpressAdInfo);
                break;
            case "RIGHT_PIC_FLOW":
                nativeTemplatePicFlow = new NativeTemplateRightPicFlow(context, nativeConfig, nativeExpressAdInfo);
                break;
            case "LEFT_PIC_FLOW":
                nativeTemplatePicFlow = new NativeTemplateLeftPicFlow(context, nativeConfig, nativeExpressAdInfo);
                break;
            case "TOP_PIC_FLOW":
                nativeTemplatePicFlow = new NativeTemplateTopPicFlow(context, nativeConfig, nativeExpressAdInfo);
                break;
            case "BOTTOM_PIC_FLOW":
                nativeTemplatePicFlow = new NativeTemplateBottomPicFlow(context, nativeConfig, nativeExpressAdInfo);
                break;
            default:
                nativeTemplatePicFlow = new NativeTemplateTopPicFlow(context, nativeConfig, nativeExpressAdInfo);
                break;
        }
        TianmuLogUtil.iD("setAdImageLoaderCallback base " + aVar);
        nativeTemplatePicFlow.setAdImageLoaderCallback(aVar);
        nativeTemplatePicFlow.setAdInfo();
        return nativeTemplatePicFlow;
    }

    public a getADImageLoaderCallback() {
        return this.p;
    }

    @SuppressLint({"WrongConstant"})
    public GradientDrawable getDrawableBg(int i2, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }

    public abstract View getNativeView();

    public void hideEraseView() {
        com.tianmu.biz.widget.m.b bVar = this.s;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void release() {
        com.tianmu.biz.widget.interaction.slideanimalview.a aVar = this.f10750q;
        if (aVar != null) {
            aVar.b();
            this.f10750q = null;
        }
        b bVar = this.r;
        if (bVar != null) {
            bVar.b();
            this.r = null;
        }
        com.tianmu.biz.widget.m.b bVar2 = this.s;
        if (bVar2 != null) {
            bVar2.c();
            this.s = null;
        }
        this.t = null;
        this.p = null;
    }

    public void setAdImageLoaderCallback(a aVar) {
        this.p = aVar;
    }

    public void setAdInfo() {
        NativeExpressAdInfo nativeExpressAdInfo = this.n;
        if (nativeExpressAdInfo != null) {
            if (!TextUtils.isEmpty(nativeExpressAdInfo.getTitle())) {
                TextView textView = this.f10748h;
                if (textView != null) {
                    textView.setText(this.n.getTitle());
                }
            } else if (this.f10748h != null && this.n.getAdData() != null) {
                this.f10748h.setText(this.n.getAdData().c());
            }
            if (this.f10749i != null) {
                if (TextUtils.isEmpty(this.n.getDesc())) {
                    this.f10749i.setVisibility(8);
                } else {
                    this.f10749i.setText(this.n.getDesc());
                    this.f10749i.setVisibility(0);
                }
            }
            if (this.f10745e != null && TianmuSDK.getInstance().getContext() != null) {
                TianmuSDK.getInstance().getImageLoader().loadImage(TianmuSDK.getInstance().getContext(), this.n.getImageUrl(), this.f10745e, this.p);
            }
            ImageView imageView = this.k;
            if (imageView != null) {
                this.n.registerCloseView(imageView);
            }
            this.n.onAdContainerClick(this);
            if (this.f10746f != null && this.n.getAdData() != null) {
                this.f10746f.setText(this.n.getAdData().e());
            }
            if (this.f10747g != null && this.n.getAdData() != null && !TextUtils.isEmpty(this.n.getAdData().c())) {
                this.f10747g.setText(this.n.getAdData().c());
                this.f10747g.setVisibility(0);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setText(this.n.getAction());
            }
        }
    }

    public abstract void setAdMaterial();

    public abstract void setConfigView();

    public void setGivePolishView(int i2, int i3) {
        NativeExpressAdInfo nativeExpressAdInfo = this.n;
        if (nativeExpressAdInfo == null || nativeExpressAdInfo.isVideo() || this.t == null) {
            return;
        }
        this.s = new com.tianmu.biz.widget.m.b(getContext(), "flow");
        r.a(getContext()).a(this.n.getImageUrl()).a(Bitmap.Config.RGB_565).a(i2, i3).a().a(new b0() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeBase.3
            @Override // com.tianmu.g.b0
            public void onBitmapFailed(Drawable drawable) {
                if (NativeBase.this.p != null) {
                    NativeBase.this.p.onError();
                }
            }

            @Override // com.tianmu.g.b0
            public void onBitmapLoaded(Bitmap bitmap, r.e eVar) {
                if (NativeBase.this.p != null) {
                    NativeBase.this.p.onSuccess();
                }
                ImageView imageView = NativeBase.this.t;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
                try {
                    NativeBase nativeBase = NativeBase.this;
                    com.tianmu.biz.widget.m.b bVar = nativeBase.s;
                    if (bVar == null || nativeBase.f10744d == null) {
                        return;
                    }
                    Bitmap bitmapA = j.a(bitmap, 0.2f, 10);
                    NativeBase nativeBase2 = NativeBase.this;
                    bVar.a(bitmapA, nativeBase2.u, nativeBase2.v, new b.InterfaceC0197b() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeBase.3.1
                        @Override // com.tianmu.biz.widget.m.b.InterfaceC0197b
                        public void onClick(ViewGroup viewGroup) {
                            NativeExpressAdInfo nativeExpressAdInfo2 = NativeBase.this.n;
                            if (nativeExpressAdInfo2 != null) {
                                nativeExpressAdInfo2.onAdSlideClick(viewGroup);
                            }
                        }
                    });
                    NativeBase nativeBase3 = NativeBase.this;
                    TianmuViewUtil.addAdViewToAdContainer(nativeBase3.f10744d, nativeBase3.s);
                } catch (Exception unused) {
                }
            }

            @Override // com.tianmu.g.b0
            public void onPrepareLoad(Drawable drawable) {
            }
        });
    }

    public void setInteractSubStyle(int i2, int i3) {
        if (this.f10744d == null || this.n.getAdData() == null) {
            return;
        }
        int iS = this.n.getAdData().s();
        int iT = this.n.getAdData().t();
        if (iS != 2) {
            if (iS == 4 && !TianmuSDK.getInstance().isFlutter()) {
                setGivePolishView(i2, i3);
                return;
            }
            return;
        }
        if (iT == 23) {
            setSlideView(i2, i3, iT);
        } else {
            a(i2, i3);
        }
    }

    public void setSlideHide() {
        com.tianmu.biz.widget.interaction.slideanimalview.a aVar = this.f10750q;
        if (aVar != null) {
            aVar.setVisibility(8);
            this.f10750q.e();
        }
        View view = this.w;
        if (view != null) {
            view.setVisibility(8);
        }
        com.tianmu.biz.widget.n.e.b bVar = this.r;
        if (bVar != null) {
            bVar.setVisibility(8);
            this.r.a(this.f10744d);
        }
    }

    public void setSlideShow() {
        com.tianmu.biz.widget.interaction.slideanimalview.a aVar = this.f10750q;
        if (aVar != null) {
            aVar.setVisibility(0);
            this.f10750q.h();
        }
        View view = this.w;
        if (view != null) {
            view.setVisibility(0);
        }
        com.tianmu.biz.widget.n.e.b bVar = this.r;
        if (bVar != null) {
            bVar.setVisibility(0);
            this.r.a((View) this.f10744d, true);
        }
    }

    public void setSlideView(int i2, int i3, int i4) {
        if (this.f10744d == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (i4 == 23) {
            layoutParams.gravity = 17;
        } else {
            layoutParams.gravity = 5;
            layoutParams.topMargin = i3 / 2;
        }
        if (this.f10750q != null && this.w != null) {
            this.f10744d.removeAllViews();
            this.f10744d.addView(this.w, new ViewGroup.LayoutParams(i2, i3));
            this.f10744d.addView(this.f10750q, layoutParams);
            return;
        }
        View view = new View(getContext());
        this.w = view;
        view.setBackgroundColor(Color.parseColor("#4D000000"));
        this.f10744d.addView(this.w, new ViewGroup.LayoutParams(i2, i3));
        com.tianmu.biz.widget.interaction.slideanimalview.a aVar = new com.tianmu.biz.widget.interaction.slideanimalview.a(this.f10744d.getContext(), i2 / 2, i4, c1.f11300h, 0, this.f10744d, true, new com.tianmu.biz.widget.interaction.slideanimalview.b.a(), "flow");
        this.f10750q = aVar;
        aVar.a(new a.InterfaceC0198a() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeBase.1
            @Override // com.tianmu.biz.widget.n.a.InterfaceC0198a
            public void onClick(ViewGroup viewGroup, int i5) {
                NativeExpressAdInfo nativeExpressAdInfo = NativeBase.this.n;
                if (nativeExpressAdInfo != null) {
                    nativeExpressAdInfo.onAdSlideClick(viewGroup);
                }
            }
        });
        if (this.n.isVideo()) {
            setSlideHide();
        }
        this.f10744d.addView(this.f10750q, layoutParams);
    }

    private void a(int i2, int i3) {
        if (this.f10744d == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.r != null && this.w != null) {
            this.f10744d.removeAllViews();
            this.f10744d.addView(this.w, new ViewGroup.LayoutParams(i2, i3));
            this.f10744d.addView(this.r, layoutParams);
            return;
        }
        View view = new View(getContext());
        this.w = view;
        view.setBackgroundColor(Color.parseColor("#4D000000"));
        this.f10744d.addView(this.w, new ViewGroup.LayoutParams(i2, i3));
        this.r = new com.tianmu.biz.widget.n.e.b(this.f10744d.getContext(), true, "flow");
        int iDp2px = TianmuDisplayUtil.dp2px(100);
        this.r.a(iDp2px, iDp2px);
        int iDp2px2 = TianmuDisplayUtil.dp2px(20);
        this.r.b(iDp2px2, iDp2px2);
        this.r.a((View) this.f10744d, true);
        this.r.b(v.a(getContext(), 2, 22, "flow", c1.f11301i));
        this.r.a(14.0f, Color.parseColor("#ffffff"), false, TianmuDisplayUtil.dp2px(0), Typeface.DEFAULT);
        this.r.a(false);
        this.r.c(true);
        this.r.a(new a.InterfaceC0198a() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeBase.2
            @Override // com.tianmu.biz.widget.n.a.InterfaceC0198a
            public void onClick(ViewGroup viewGroup, int i4) {
                NativeExpressAdInfo nativeExpressAdInfo = NativeBase.this.n;
                if (nativeExpressAdInfo != null) {
                    nativeExpressAdInfo.onAdSlideClick(viewGroup);
                }
            }
        });
        layoutParams.gravity = 17;
        this.f10744d.addView(this.r, layoutParams);
    }

    public SpannableStringBuilder a() {
        final com.tianmu.c.i.a aVarF;
        try {
            NativeExpressAdInfo nativeExpressAdInfo = this.n;
            if (nativeExpressAdInfo == null || nativeExpressAdInfo.getAdData() == null || !this.n.getAdData().I() || (aVarF = this.n.getAdData().f()) == null || aVarF.l()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(aVarF.d())) {
                spannableStringBuilder.append((CharSequence) "应用名称：");
                spannableStringBuilder.append((CharSequence) aVarF.d());
                spannableStringBuilder.append((CharSequence) "；");
            }
            if (!TextUtils.isEmpty(aVarF.f())) {
                spannableStringBuilder.append((CharSequence) "版本号：");
                spannableStringBuilder.append((CharSequence) aVarF.f());
                spannableStringBuilder.append((CharSequence) "；");
            }
            if (!TextUtils.isEmpty(aVarF.a())) {
                spannableStringBuilder.append((CharSequence) "开发者：");
                spannableStringBuilder.append((CharSequence) aVarF.a());
                spannableStringBuilder.append((CharSequence) "；");
            }
            if (!TextUtils.isEmpty(aVarF.h()) || !TextUtils.isEmpty(aVarF.i())) {
                spannableStringBuilder.append((CharSequence) "\n权限信息");
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeBase.4
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        try {
                            if (!TextUtils.isEmpty(aVarF.h())) {
                                WebViewActivity.openUrl(NativeBase.this.getContext(), aVarF.h(), "权限信息");
                            } else if (!TextUtils.isEmpty(aVarF.i())) {
                                AppPermissionsActivity.start(NativeBase.this.getContext(), aVarF.i());
                            }
                        } catch (Exception unused) {
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        textPaint.setUnderlineText(true);
                    }
                }, spannableStringBuilder.toString().indexOf("权限信息"), spannableStringBuilder.toString().indexOf("权限信息") + 4, 33);
            }
            if ((!TextUtils.isEmpty(aVarF.h()) || !TextUtils.isEmpty(aVarF.i())) && !TextUtils.isEmpty(aVarF.j())) {
                spannableStringBuilder.append((CharSequence) " | ");
            }
            if (!TextUtils.isEmpty(aVarF.j())) {
                spannableStringBuilder.append((CharSequence) "隐私政策");
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeBase.5
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        try {
                            if (TextUtils.isEmpty(aVarF.j())) {
                                return;
                            }
                            WebViewActivity.openUrl(NativeBase.this.getContext(), aVarF.j(), "隐私政策");
                        } catch (Exception unused) {
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        textPaint.setUnderlineText(true);
                    }
                }, spannableStringBuilder.toString().indexOf("隐私政策"), spannableStringBuilder.toString().indexOf("隐私政策") + 4, 33);
            }
            return spannableStringBuilder;
        } catch (Exception unused) {
            return null;
        }
    }
}
