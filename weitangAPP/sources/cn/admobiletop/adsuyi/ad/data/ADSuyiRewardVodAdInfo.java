package cn.admobiletop.adsuyi.ad.data;

import android.app.Activity;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiRewardVodAdInfo extends ADSuyiOnceShowAdInfo {
    Map<String, Object> getRewardMap();

    void showRewardVod(@NonNull Activity activity);
}
