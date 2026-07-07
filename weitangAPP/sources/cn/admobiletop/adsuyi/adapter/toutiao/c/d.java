package cn.admobiletop.adsuyi.adapter.toutiao.c;

import android.content.Context;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f4060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TTAdConfig f4061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4062c;

    public static d a() {
        if (f4060a == null) {
            synchronized (d.class) {
                if (f4060a == null) {
                    f4060a = new d();
                }
            }
        }
        return f4060a;
    }

    public static int[] c() {
        int downloadTip = ADSuyiSdk.getInstance().getDownloadTip();
        return downloadTip != 0 ? downloadTip != 2 ? new int[]{4} : new int[0] : new int[]{4, 2, 3, 5, 1};
    }

    public final TTAdConfig b(String str, String str2) {
        boolean zIsTtUseTextureView;
        boolean zIsMultiprocess;
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        try {
            zIsTtUseTextureView = config.isTtUseTextureView();
        } catch (Exception unused) {
            ADSuyiLogUtil.e("当前ADSuyi版本不支持TextureView控件播放视频设置");
            zIsTtUseTextureView = true;
        }
        try {
            zIsMultiprocess = config.isMultiprocess();
        } catch (Exception unused2) {
            ADSuyiLogUtil.e("当前ADSuyi版本不支持设置多进程");
            zIsMultiprocess = false;
        }
        TTAdConfig.Builder builderUseTextureView = new TTAdConfig.Builder().appId(str).useTextureView(zIsTtUseTextureView);
        if (TextUtils.isEmpty(str2)) {
            str2 = ADSuyiPackageUtil.getAppName(ADSuyiSdk.getInstance().getContext());
        }
        return builderUseTextureView.appName(str2).titleBarTheme(0).allowShowNotify(true).debug(ADSuyiSdk.getInstance().isDebug()).directDownloadNetworkType(c()).supportMultiProcess(zIsMultiprocess).customController(new c(this)).build();
    }

    public void a(String str, String str2) {
        TTAdConfig tTAdConfigB = b(str, str2);
        this.f4061b = tTAdConfigB;
        if (this.f4062c || tTAdConfigB == null) {
            return;
        }
        this.f4062c = true;
        TTAdSdk.init(ADSuyiSdk.getInstance().getContext(), this.f4061b);
        TTAdSdk.start(new a(this));
    }

    public TTAdNative a(Context context) {
        if (this.f4062c) {
            return TTAdSdk.getAdManager().createAdNative(context);
        }
        return null;
    }
}
