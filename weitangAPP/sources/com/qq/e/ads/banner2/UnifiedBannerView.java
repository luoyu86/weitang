package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnifiedBannerAD f9536a;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f9536a = new UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        a();
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e(UnifiedBannerView.class.getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.f9536a = new UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        a();
    }

    public final void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.f9536a.destroy();
    }

    public String getAdNetWorkName() {
        return this.f9536a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f9536a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.f9536a.getECPM();
    }

    public String getECPMLevel() {
        return this.f9536a.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.f9536a.getExtraInfo();
    }

    public boolean isValid() {
        return this.f9536a.isValid();
    }

    public void loadAD() {
        this.f9536a.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f9536a.onWindowFocusChanged(z);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        this.f9536a.sendLossNotification(i2, i3, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f9536a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        this.f9536a.sendWinNotification(i2);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f9536a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        this.f9536a.setBidECPM(i2);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f9536a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f9536a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f9536a.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i2) {
        this.f9536a.d(i2);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f9536a.setRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f9536a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }
}
