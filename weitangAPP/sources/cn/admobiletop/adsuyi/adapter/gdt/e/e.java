package cn.admobiletop.adsuyi.adapter.gdt.e;

import com.qq.e.ads.cfg.VideoOption;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static VideoOption a(boolean z) {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(0);
        builder.setAutoPlayMuted(z);
        builder.setDetailPageMuted(z);
        builder.setNeedCoverImage(true);
        builder.setNeedProgressBar(true);
        builder.setEnableDetailPage(true);
        return builder.build();
    }
}
