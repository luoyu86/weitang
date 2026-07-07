package com.bytedance.pangle.e;

import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i2) {
        String strA = g.a(str, i2);
        String strC = com.bytedance.pangle.d.c.c(str, i2);
        String[] strArrSplit = strA.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(strA));
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = strArrSplit.length;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            if (i3 >= length) {
                z = z2;
                break;
            }
            String str2 = strArrSplit[i3];
            if (!a(str2, strC + File.separator + b.a(str2))) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i3++;
            z2 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result:" + z);
        return z;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
