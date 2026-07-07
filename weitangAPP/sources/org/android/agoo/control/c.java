package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import org.android.agoo.common.MsgDO;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AgooFactory f14949a;

    public c(AgooFactory agooFactory) {
        this.f14949a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<MsgDO> arrayListA = this.f14949a.messageService.a();
        if (arrayListA == null || arrayListA.size() <= 0) {
            return;
        }
        ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(arrayListA.size()));
        for (MsgDO msgDO : arrayListA) {
            if (msgDO != null) {
                msgDO.isFromCache = true;
                this.f14949a.notifyManager.report(msgDO, null);
            }
        }
    }
}
