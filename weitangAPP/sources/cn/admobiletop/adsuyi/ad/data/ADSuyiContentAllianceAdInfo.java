package cn.admobiletop.adsuyi.ad.data;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiContentAllianceAdInfo extends ADSuyiAdInfo {
    View getContentAllianceAdView(@NonNull ViewGroup viewGroup);

    void openKSContentPage(@NonNull Activity activity);

    void render(@NonNull ViewGroup viewGroup);
}
