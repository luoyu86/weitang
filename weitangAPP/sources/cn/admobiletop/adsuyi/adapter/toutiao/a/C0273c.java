package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.view.View;
import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.R;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0273c<T extends ADSuyiAdListener, E> extends ADSuyiBaseAdInfo<T, E> {
    public C0273c(String str) {
        super(ADSuyiIniter.PLATFORM, str, R.drawable.adsuyi_toutiao_platform_icon);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onActionClick(ViewGroup viewGroup, View view) {
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onAdContainerClick(View view) {
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
    }
}
