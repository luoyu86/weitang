package cn.admobiletop.adsuyi.adapter.gdt.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2;
import cn.admobiletop.adsuyi.ad.widget.notice.ADSuyiNoticeAdContainer2;
import cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView;
import cn.admobiletop.adsuyi.adapter.gdt.R;
import cn.admobiletop.adsuyi.config.ADSuyiImageLoader;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends Dialog implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeUnifiedADData f3762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoundedImageView f3763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f3764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f3765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiNoticeAdContainer2 f3766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NativeAdContainer f3767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f3768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f3769h;

    public b(@NonNull Context context, NativeUnifiedADData nativeUnifiedADData) {
        super(context, R.style.adsuyi_gdt_notice_dialog);
        this.f3762a = nativeUnifiedADData;
        setContentView(a());
        e();
        this.f3767f = (NativeAdContainer) findViewById(R.id.adsuyi_gdt_native_container);
        this.f3766e = (ADSuyiNoticeAdContainer2) findViewById(R.id.adsuyi_gdt_notice_ad_container);
        this.f3763b = (RoundedImageView) findViewById(R.id.adsuyi_gdt_iv_image);
        this.f3764c = (TextView) findViewById(R.id.adsuyi_gdt_tv_title);
        this.f3765d = (TextView) findViewById(R.id.adsuyi_gdt_tv_des);
        this.f3768g = (LinearLayout) findViewById(R.id.adsuyi_gdt_click_container);
        this.f3769h = (ImageView) findViewById(R.id.adsuyi_gdt_iv_close);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        if (ADSuyiSdk.getInstance().isDarkMode()) {
            this.f3766e.setBackgroundResource(R.drawable.adsuyi_gdt_shape_27292d_radius8);
            this.f3764c.setTextColor(Color.parseColor("#e6ffffff"));
            this.f3765d.setTextColor(Color.parseColor("#e6ffffff"));
        }
        this.f3769h.setOnClickListener(new a(this));
    }

    public void a(ADSuyiNoticeListener2 aDSuyiNoticeListener2) {
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3766e;
        if (aDSuyiNoticeAdContainer2 != null) {
            aDSuyiNoticeAdContainer2.setNotificationListener(aDSuyiNoticeListener2);
        }
    }

    public final float c() {
        return 0.0f;
    }

    public final void d() {
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3766e;
        if (aDSuyiNoticeAdContainer2 != null && aDSuyiNoticeAdContainer2.getNotificationListener() != null) {
            this.f3766e.getNotificationListener().onManuallyDismiss();
        }
        release();
    }

    public final void e() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(32, 32);
                window.setFlags(262144, 262144);
                int statusBarHeight = ADSuyiDisplayUtil.getStatusBarHeight(getContext());
                window.setGravity(48);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                if (statusBarHeight >= 80) {
                    statusBarHeight = 0;
                }
                attributes.y = statusBarHeight;
                attributes.dimAmount = 0.0f;
                window.setWindowAnimations(R.style.adsuyi_gdt_alpha_enter_exit);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        d();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        dismiss();
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3766e;
        if (aDSuyiNoticeAdContainer2 != null) {
            aDSuyiNoticeAdContainer2.release();
            this.f3766e = null;
        }
    }

    public void a(String str, String str2, String str3) {
        RoundedImageView roundedImageView;
        ADSuyiImageLoader imageLoader = ADSuyiSdk.getInstance().getImageLoader();
        if (imageLoader != null && (roundedImageView = this.f3763b) != null) {
            roundedImageView.setCornerRadius(c());
            imageLoader.loadImage(this.f3763b.getContext(), str, this.f3763b);
        }
        TextView textView = this.f3764c;
        if (textView != null) {
            textView.setText(str2);
        }
        TextView textView2 = this.f3765d;
        if (textView2 != null) {
            textView2.setText(str3);
        }
        if (this.f3762a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f3767f);
            arrayList.add(this.f3768g);
            arrayList.add(this.f3763b);
            arrayList.add(this.f3764c);
            arrayList.add(this.f3765d);
            this.f3762a.bindAdToView(getContext(), this.f3767f, new FrameLayout.LayoutParams(0, 0), arrayList);
        }
    }

    public final int a() {
        return R.layout.adsuyi_gdt_dialog_inner_notice_style;
    }
}
