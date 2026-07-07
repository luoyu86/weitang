package anet.channel.e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;

/* JADX INFO: loaded from: classes.dex */
public final class c implements IStrategyListener {
    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        String str;
        if (dVar == null || dVar.f681b == null) {
            return;
        }
        int i2 = 0;
        loop0: while (true) {
            l.b[] bVarArr = dVar.f681b;
            if (i2 >= bVarArr.length) {
                return;
            }
            str = bVarArr[i2].f669a;
            l.a[] aVarArr = bVarArr[i2].f676h;
            if (aVarArr != null && aVarArr.length > 0) {
                for (l.a aVar : aVarArr) {
                    String str2 = aVar.f662b;
                    if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
                        break loop0;
                    }
                }
            }
            i2++;
        }
        if (!str.equals(a.f438b)) {
            String unused = a.f438b = str;
            SharedPreferences.Editor editorEdit = a.f442f.edit();
            editorEdit.putString("http3_detector_host", a.f438b);
            editorEdit.apply();
        }
        a.a(NetworkStatusHelper.getStatus());
    }
}
