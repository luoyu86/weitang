package cn.admobiletop.adsuyi.adapter.tianmu.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.listener.NativeVideoAdListener;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends a<ADSuyiNativeAdListener, NativeAdInfo> implements ADSuyiNativeFeedAdInfo, NativeVideoAdListener {
    public ADSuyiNativeVideoListener k;

    public e(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public int getActionType() {
        return 0;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public String getCtaText() {
        return "查看详情";
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getDesc() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getDesc();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getIconUrl() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getImageUrl();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getImageUrl() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getImageUrl();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public List<String> getImageUrlList() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getImageUrls();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public View getMediaView(@NonNull ViewGroup viewGroup) {
        return getAdapterAdInfo().getMediaView(viewGroup);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    @Nullable
    public String getTitle() {
        if (getAdapterAdInfo() == null) {
            return null;
        }
        return getAdapterAdInfo().getTitle();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public boolean hasMediaView() {
        return isVideo();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isNativeExpress() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isVideo() {
        if (getAdapterAdInfo() == null) {
            return false;
        }
        return getAdapterAdInfo().isVideo();
    }

    @Override // com.tianmu.ad.listener.NativeVideoAdListener
    public void onVideoError(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.k;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoError(this, new ADSuyiError(-1, " tianmu video error "));
        }
    }

    @Override // com.tianmu.ad.listener.NativeVideoAdListener
    public void onVideoFinish(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.k;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoComplete(this);
        }
    }

    @Override // com.tianmu.ad.listener.NativeVideoAdListener
    public void onVideoPause(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.k;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoPause(this);
        }
    }

    @Override // com.tianmu.ad.listener.NativeVideoAdListener
    public void onVideoStart(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        ADSuyiNativeVideoListener aDSuyiNativeVideoListener = this.k;
        if (aDSuyiNativeVideoListener != null) {
            aDSuyiNativeVideoListener.onVideoStart(this);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo, cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void registerCloseView(View view) {
        getAdapterAdInfo().registerCloseView(view);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeFeedAdInfo
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, View... viewArr) {
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().registerView(viewGroup, viewArr);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void setVideoListener(ADSuyiNativeVideoListener aDSuyiNativeVideoListener) {
        if (isVideo()) {
            this.k = aDSuyiNativeVideoListener;
        }
    }
}
