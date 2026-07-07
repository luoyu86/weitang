package com.bytedance.pangle.e;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDexExtractor;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i2) {
        String strB = com.bytedance.pangle.d.c.b(str, i2);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strB)));
        String strC = com.bytedance.pangle.d.c.c(str, i2);
        StringBuilder sb = new StringBuilder();
        sb.append(strC);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(b.b(strB));
        String string = sb.toString();
        String str3 = strC + str2 + b.a(strB);
        if (!a(strB, string)) {
            return false;
        }
        File file = new File(string);
        if (file.exists()) {
            file.renameTo(new File(str3));
        }
        String str4 = Build.VERSION.SDK_INT >= 26 ? ".odex" : MultiDexExtractor.DEX_SUFFIX;
        File file2 = new File(string.replace(str4, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str3.replace(str4, ".vdex")));
        }
        boolean zA = b.a(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zA)));
        return zA;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            return a.a(b.a(str, str2, b.f6010b));
        } catch (Exception unused) {
            return false;
        }
    }
}
