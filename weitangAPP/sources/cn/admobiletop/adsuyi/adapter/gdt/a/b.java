package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.view.View;
import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.R;

/* JADX INFO: loaded from: classes.dex */
public class b<T extends ADSuyiAdListener, E> extends ADSuyiBaseAdInfo<T, E> {
    public b(String str) {
        super("gdt", str, R.drawable.adsuyi_gdt_platform_icon);
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
