package cn.admobiletop.adsuyi.adapter.tianmu.c.a;

import android.content.Context;
import android.view.Window;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.widget.dialog.ADSuyiInnerNoticeThirdPartyAdDialog2;

/* JADX INFO: loaded from: classes.dex */
public class a extends ADSuyiInnerNoticeThirdPartyAdDialog2 {
    public a(@NonNull Context context) {
        super(context);
    }

    @Override // cn.admobiletop.adsuyi.ad.widget.dialog.ADSuyiInnerNoticeThirdPartyAdDialog2
    public void setWindowFlags(Window window) {
        if (window != null) {
            window.setFlags(32, 32);
            window.setFlags(262144, 262144);
        }
    }
}
