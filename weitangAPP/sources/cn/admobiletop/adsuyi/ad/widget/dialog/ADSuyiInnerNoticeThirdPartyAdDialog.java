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
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;
import cn.admobiletop.adsuyi.ad.widget.notice.ADSuyiNoticeAdContainer;
import cn.admobiletop.adsuyi.ad.widget.roundimage.RoundedImageView;
import cn.admobiletop.adsuyi.config.ADSuyiImageLoader;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ADSuyiInnerNoticeThirdPartyAdDialog extends Dialog implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoundedImageView f3572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f3573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f3574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f3575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f3576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f3577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ADSuyiNoticeAdContainer f3578h;

    public ADSuyiInnerNoticeThirdPartyAdDialog(@NonNull Context context) {
        super(context, R.style.adsuyi_notice_dialog);
        setContentView(a());
        e();
        this.f3578h = (ADSuyiNoticeAdContainer) findViewById(R.id.adsuyi_notice_ad_container);
        this.f3572b = (RoundedImageView) findViewById(R.id.adsuyi_iv_image);
        this.f3574d = (TextView) findViewById(R.id.adsuyi_tv_title);
        this.f3573c = (ImageView) findViewById(R.id.adsuyi_iv_target);
        this.f3575e = (TextView) findViewById(R.id.adsuyi_tv_des);
        this.f3576f = (TextView) findViewById(R.id.adsuyi_tv_action_button);
        this.f3577g = (ImageView) findViewById(R.id.adsuyi_iv_close);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.f3571a = ADSuyiDisplayUtil.activityIsLandscape(context);
        if (ADSuyiSdk.getInstance().isDarkMode()) {
            this.f3578h.setBackgroundResource(R.drawable.adsuyi_shape_27292d_radius8);
            this.f3574d.setTextColor(Color.parseColor("#e6ffffff"));
            this.f3575e.setTextColor(Color.parseColor("#e6ffffff"));
        }
        this.f3577g.setOnClickListener(new ADSuyiSingleClickListener() { // from class: cn.admobiletop.adsuyi.ad.widget.dialog.ADSuyiInnerNoticeThirdPartyAdDialog.1
            @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
            public void onSingleClick(View view) {
                ADSuyiInnerNoticeThirdPartyAdDialog.this.d();
            }
        });
    }

    public final int a() {
        return R.layout.adsuyi_dialog_inner_notice_style3;
    }

    public final float c() {
        return 0.0f;
    }

    public final void d() {
        ADSuyiNoticeAdContainer aDSuyiNoticeAdContainer = this.f3578h;
        if (aDSuyiNoticeAdContainer != null && aDSuyiNoticeAdContainer.getNotificationListener() != null) {
            this.f3578h.getNotificationListener().onManuallyDismiss();
        }
        release();
    }

    public final void e() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(8, 8);
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
                window.setWindowAnimations(R.style.adsuyi_alpha_enter_exit);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public List<View> getClickViewList() {
        ArrayList arrayList = new ArrayList();
        TextView textView = this.f3576f;
        if (textView != null) {
            arrayList.add(textView);
        }
        return arrayList;
    }

    public List<View> getClickViewListAll() {
        ArrayList arrayList = new ArrayList();
        ADSuyiNoticeAdContainer aDSuyiNoticeAdContainer = this.f3578h;
        if (aDSuyiNoticeAdContainer != null) {
            arrayList.add(aDSuyiNoticeAdContainer);
        }
        RoundedImageView roundedImageView = this.f3572b;
        if (roundedImageView != null) {
            arrayList.add(roundedImageView);
        }
        ImageView imageView = this.f3573c;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        TextView textView = this.f3574d;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.f3575e;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.f3576f;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        return arrayList;
    }

    public ADSuyiNoticeAdContainer getNoticeAdContainer() {
        return this.f3578h;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        d();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        dismiss();
        ADSuyiNoticeAdContainer aDSuyiNoticeAdContainer = this.f3578h;
        if (aDSuyiNoticeAdContainer != null) {
            aDSuyiNoticeAdContainer.release();
            this.f3578h = null;
        }
    }

    public void render(String str, String str2, String str3, int i2) {
        render(str, str2, str3, i2, null);
    }

    public void setNotificationListener(ADSuyiNoticeListener aDSuyiNoticeListener) {
        ADSuyiNoticeAdContainer aDSuyiNoticeAdContainer = this.f3578h;
        if (aDSuyiNoticeAdContainer != null) {
            aDSuyiNoticeAdContainer.setNotificationListener(aDSuyiNoticeListener);
        }
    }

    public void render(String str, String str2, String str3, int i2, String str4) {
        if (TextUtils.isEmpty(str4)) {
            this.f3576f.setVisibility(8);
        } else {
            this.f3576f.setVisibility(0);
            this.f3576f.setText(str4);
        }
        ADSuyiImageLoader imageLoader = ADSuyiSdk.getInstance().getImageLoader();
        if (imageLoader != null) {
            RoundedImageView roundedImageView = this.f3572b;
            if (roundedImageView != null) {
                roundedImageView.setCornerRadius(c());
                imageLoader.loadImage(this.f3572b.getContext(), str, this.f3572b);
            }
            ImageView imageView = this.f3573c;
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
        }
        TextView textView = this.f3574d;
        if (textView != null) {
            textView.setText(str2);
        }
        TextView textView2 = this.f3575e;
        if (textView2 != null) {
            textView2.setMaxLines(this.f3571a ? 1 : 2);
            this.f3575e.setText(str3);
        }
    }
}
