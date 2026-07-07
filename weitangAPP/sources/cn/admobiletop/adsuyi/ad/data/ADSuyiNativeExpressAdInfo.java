package cn.admobiletop.adsuyi.ad.data;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiNativeExpressAdInfo extends ADSuyiNativeAdInfo {
    View getNativeExpressAdView(@NonNull ViewGroup viewGroup);

    void render(@NonNull ViewGroup viewGroup);
}
