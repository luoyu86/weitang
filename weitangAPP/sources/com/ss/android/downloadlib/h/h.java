package com.ss.android.downloadlib.h;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static long ok(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return ok(file, file.lastModified(), 0);
    }

    private static long ok(File file, long j, int i2) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i3 = i2 + 1;
            if (i3 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, ok(file2, j, i3));
                }
            }
        }
        return j;
    }
}
