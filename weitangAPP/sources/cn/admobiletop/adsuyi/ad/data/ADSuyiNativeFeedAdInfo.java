package cn.admobiletop.adsuyi.ad.data;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiNativeFeedAdInfo extends ADSuyiNativeAdInfo {
    int getActionType();

    String getCtaText();

    @Nullable
    String getDesc();

    @Nullable
    String getIconUrl();

    @Nullable
    String getImageUrl();

    @Nullable
    List<String> getImageUrlList();

    @Nullable
    View getMediaView(@NonNull ViewGroup viewGroup);

    @Nullable
    String getTitle();

    boolean hasMediaView();

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, View... viewArr);
}
