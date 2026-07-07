package cn.admobiletop.adsuyi.ad.data;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodVideoListener;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiDrawVodAdInfo extends ADSuyiAdInfo {
    View getMediaView(@NonNull ViewGroup viewGroup);

    void render(@NonNull ViewGroup viewGroup);

    void setVideoListener(ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener);
}
