package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.adapter.gdt.R;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NativeDrawADInfoView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f3751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f3752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f3753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f3754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f3755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f3756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f3757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f3758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f3759i;

    public NativeDrawADInfoView(Context context) {
        super(context);
        c(context);
    }

    public final void c(Context context) {
        RelativeLayout.inflate(context, R.layout.adsuyi_gdt_native_draw_ad_info, this);
        this.f3751a = (LinearLayout) findViewById(R.id.adsuyi_gdt_btn_download);
        this.f3752b = (ImageView) findViewById(R.id.adsuyi_gdt_img_logo);
        this.f3753c = (ImageView) findViewById(R.id.adsuyi_gdt_img_logo_download);
        this.f3754d = (TextView) findViewById(R.id.adsuyi_gdt_btn_download_text);
        this.f3755e = (TextView) findViewById(R.id.adsuyi_gdt_text_title);
        this.f3756f = (TextView) findViewById(R.id.adsuyi_gdt_text_desc);
        b();
    }

    public final void d(TextView textView, NativeUnifiedADData nativeUnifiedADData) {
        textView.setText(nativeUnifiedADData.getButtonText());
    }

    public final void f(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isWeChatCanvasAd() || !nativeUnifiedADData.isAppAd()) {
            this.f3753c.setImageResource(R.drawable.adsuyi_gdt_icon_link);
            this.f3754d.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.adsuyi_gdt_icon_to_link), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ImageView imageView = this.f3753c;
            int i2 = R.drawable.adsuyi_gdt_icon_download_gray;
            imageView.setImageResource(i2);
            this.f3754d.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), i2), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.f3753c.setVisibility(0);
    }

    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3752b);
        arrayList.add(this.f3753c);
        arrayList.add(this.f3751a);
        return arrayList;
    }

    public final void h() {
        setPadding(0, 0, 0, 0);
    }

    public final void i() {
        if (Build.VERSION.SDK_INT >= 19) {
            AnimatorSet animatorSet = this.f3757g;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.f3757g.pause();
            }
            ValueAnimator valueAnimator = this.f3758h;
            if (valueAnimator == null || !valueAnimator.isStarted()) {
                return;
            }
            this.f3758h.pause();
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 19) {
            AnimatorSet animatorSet = this.f3757g;
            if (animatorSet != null && animatorSet.isPaused()) {
                this.f3757g.resume();
            }
            ValueAnimator valueAnimator = this.f3758h;
            if (valueAnimator == null || !valueAnimator.isPaused()) {
                return;
            }
            this.f3758h.resume();
        }
    }

    public final void k() {
        setPadding(0, 0, 0, ADSuyiDisplayUtil.dp2px(2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f3759i;
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            j();
        } else {
            b();
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void setAdInfo(NativeUnifiedADData nativeUnifiedADData) {
        if (!TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
            ADSuyiSdk.getInstance().getImageLoader().loadImage(getContext(), nativeUnifiedADData.getIconUrl(), this.f3752b);
        }
        this.f3755e.setText(nativeUnifiedADData.getTitle());
        this.f3756f.setText(nativeUnifiedADData.getDesc());
        this.f3759i = Boolean.valueOf(nativeUnifiedADData.getAdPatternType() == 2);
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        d(this.f3754d, nativeUnifiedADData);
        f(nativeUnifiedADData);
    }

    public void b() {
        h();
        this.f3751a.setVisibility(8);
        this.f3754d.setVisibility(8);
        this.f3755e.setTranslationY(0.0f);
        this.f3756f.setTranslationY(0.0f);
    }

    public NativeDrawADInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void a() {
        if (this.f3757g == null) {
            float f2 = -ADSuyiDisplayUtil.dp2px(42);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.f3755e, "translationY", 0.0f, f2).setDuration(300L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f3756f, "translationY", 0.0f, f2).setDuration(300L);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.f3751a, "alpha", 0.0f, 1.0f).setDuration(300L);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.f3754d, "alpha", 0.0f, 1.0f).setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f3757g = animatorSet;
            animatorSet.addListener(new g(this));
            this.f3757g.setInterpolator(new LinearInterpolator());
            this.f3757g.play(duration).with(duration2).with(duration3).with(duration4);
        }
        Boolean bool = this.f3759i;
        if (bool != null && bool.booleanValue()) {
            this.f3757g.setStartDelay(4000L);
            k();
        } else {
            this.f3757g.setStartDelay(0L);
        }
        this.f3757g.start();
    }

    public NativeDrawADInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
