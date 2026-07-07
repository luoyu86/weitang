package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static long a(@NonNull List<q> list) {
        long jBl;
        long jS;
        long j = 0;
        loop0: while (true) {
            jBl = -1;
            jS = -1;
            for (q qVar : list) {
                if (jBl == -1) {
                    if (qVar.ok() > 0) {
                        jBl = qVar.bl();
                        jS = qVar.s();
                    }
                } else if (qVar.bl() > jS) {
                    j += jS - jBl;
                    if (qVar.ok() > 0) {
                        jBl = qVar.bl();
                        jS = qVar.s();
                    }
                } else if (qVar.s() > jS) {
                    jS = qVar.s();
                }
            }
        }
        return (jBl < 0 || jS <= jBl) ? j : j + (jS - jBl);
    }

    public static long ok(@NonNull List<q> list) {
        int size = list.size();
        long jN = 0;
        for (int i2 = 0; i2 < size; i2++) {
            q qVar = list.get(i2);
            if (qVar.bl() > jN) {
                break;
            }
            if (qVar.n() > jN) {
                jN = qVar.n();
            }
        }
        return jN;
    }
}
