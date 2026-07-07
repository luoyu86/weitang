package cn.admobiletop.adsuyi.ad.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.R;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiInterstitalAdDialog extends Dialog implements IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f3589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiInterstitialAdInfo f3590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiInterstitialAdListener f3591c;

    public ADSuyiInterstitalAdDialog(@NonNull Context context) {
        super(context, R.style.adsuyi_common_dialog);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f3589a = relativeLayout;
        setContentView(relativeLayout);
        b();
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: cn.admobiletop.adsuyi.ad.widget.dialog.ADSuyiInterstitalAdDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ADSuyiInterstitalAdDialog.this.f3591c == null || ADSuyiInterstitalAdDialog.this.f3590b == null) {
                    return;
                }
                ADSuyiInterstitalAdDialog.this.f3591c.onAdClose(ADSuyiInterstitalAdDialog.this.f3590b);
            }
        });
    }

    public final void b() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setGravity(17);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                attributes.dimAmount = 0.55f;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(View view) {
        RelativeLayout relativeLayout;
        if (view == null || (relativeLayout = this.f3589a) == null) {
            return;
        }
        relativeLayout.removeAllViews();
        ADSuyiViewUtil.removeSelfFromParent(view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f3589a.addView(view, layoutParams);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        try {
            if (isShowing()) {
                dismiss();
            }
            this.f3590b = null;
            this.f3591c = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void renderInterstitalAd(View view, ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener) {
        this.f3590b = aDSuyiInterstitialAdInfo;
        this.f3591c = aDSuyiInterstitialAdListener;
        c(view);
    }
}
