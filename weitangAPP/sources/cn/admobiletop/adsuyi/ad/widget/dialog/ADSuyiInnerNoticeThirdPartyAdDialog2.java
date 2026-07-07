package cn.admobiletop.adsuyi.ad.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.R;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;
import cn.admobiletop.adsuyi.ad.widget.notice.ADSuyiNoticeAdContainer2;
import cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView;
import cn.admobiletop.adsuyi.config.ADSuyiImageLoader;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiInnerNoticeThirdPartyAdDialog2 extends Dialog implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoundedImageView f3581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f3582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f3583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f3584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f3585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f3586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ADSuyiNoticeAdContainer2 f3587h;

    public ADSuyiInnerNoticeThirdPartyAdDialog2(@NonNull Context context) {
        super(context, R.style.adsuyi_notice_dialog);
        setContentView(a());
        e();
        this.f3587h = (ADSuyiNoticeAdContainer2) findViewById(R.id.adsuyi_notice_ad_container);
        this.f3581b = (RoundedImageView) findViewById(R.id.adsuyi_iv_image);
        this.f3583d = (TextView) findViewById(R.id.adsuyi_tv_title);
        this.f3582c = (ImageView) findViewById(R.id.adsuyi_iv_target);
        this.f3584e = (TextView) findViewById(R.id.adsuyi_tv_des);
        this.f3585f = (TextView) findViewById(R.id.adsuyi_tv_action_button);
        this.f3586g = (ImageView) findViewById(R.id.adsuyi_iv_close);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.f3580a = ADSuyiDisplayUtil.activityIsLandscape(context);
        if (ADSuyiSdk.getInstance().isDarkMode()) {
            this.f3587h.setBackgroundResource(R.drawable.adsuyi_shape_27292d_radius8);
            this.f3583d.setTextColor(Color.parseColor("#e6ffffff"));
            this.f3584e.setTextColor(Color.parseColor("#e6ffffff"));
        }
        this.f3586g.setOnClickListener(new ADSuyiSingleClickListener() { // from class: cn.admobiletop.adsuyi.ad.widget.dialog.ADSuyiInnerNoticeThirdPartyAdDialog2.1
            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
            public void onSingleClick(View view) {
                ADSuyiInnerNoticeThirdPartyAdDialog2.this.d();
            }
        });
    }

    public final int a() {
        return R.layout.adsuyi_dialog_inner_notice_style4;
    }

    public final float c() {
        return 0.0f;
    }

    public final void d() {
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3587h;
        if (aDSuyiNoticeAdContainer2 != null && aDSuyiNoticeAdContainer2.getNotificationListener() != null) {
            this.f3587h.getNotificationListener().onManuallyDismiss();
        }
        release();
    }

    public final void e() {
        try {
            Window window = getWindow();
            if (window != null) {
                setWindowFlags(window);
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
                window.setWindowAnimations(R.style.adsuyi_alpha_enter_exit);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public List<View> getClickViewList() {
        ArrayList arrayList = new ArrayList();
        TextView textView = this.f3585f;
        if (textView != null) {
            arrayList.add(textView);
        }
        return arrayList;
    }

    public List<View> getClickViewListAll() {
        ArrayList arrayList = new ArrayList();
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3587h;
        if (aDSuyiNoticeAdContainer2 != null) {
            arrayList.add(aDSuyiNoticeAdContainer2);
        }
        RoundedImageView roundedImageView = this.f3581b;
        if (roundedImageView != null) {
            arrayList.add(roundedImageView);
        }
        ImageView imageView = this.f3582c;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        TextView textView = this.f3583d;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.f3584e;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.f3585f;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        return arrayList;
    }

    public ADSuyiNoticeAdContainer2 getNoticeAdContainer() {
        return this.f3587h;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        d();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        dismiss();
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3587h;
        if (aDSuyiNoticeAdContainer2 != null) {
            aDSuyiNoticeAdContainer2.release();
            this.f3587h = null;
        }
    }

    public void render(String str, String str2, String str3, int i2) {
        render(str, str2, str3, i2, null);
    }

    public void setNotificationListener(ADSuyiNoticeListener2 aDSuyiNoticeListener2) {
        ADSuyiNoticeAdContainer2 aDSuyiNoticeAdContainer2 = this.f3587h;
        if (aDSuyiNoticeAdContainer2 != null) {
            aDSuyiNoticeAdContainer2.setNotificationListener(aDSuyiNoticeListener2);
        }
    }

    public void setWindowFlags(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(8, 8);
        window.setFlags(32, 32);
        window.setFlags(262144, 262144);
    }

    public void render(String str, String str2, String str3, int i2, String str4) {
        if (TextUtils.isEmpty(str4)) {
            this.f3585f.setVisibility(8);
        } else {
            this.f3585f.setVisibility(0);
            this.f3585f.setText(str4);
        }
        ADSuyiImageLoader imageLoader = ADSuyiSdk.getInstance().getImageLoader();
        if (imageLoader != null) {
            RoundedImageView roundedImageView = this.f3581b;
            if (roundedImageView != null) {
                roundedImageView.setCornerRadius(c());
                imageLoader.loadImage(this.f3581b.getContext(), str, this.f3581b);
            }
            ImageView imageView = this.f3582c;
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
        }
        TextView textView = this.f3583d;
        if (textView != null) {
            textView.setText(str2);
        }
        TextView textView2 = this.f3584e;
        if (textView2 != null) {
            textView2.setMaxLines(this.f3580a ? 1 : 2);
            this.f3584e.setText(str3);
        }
    }
}
