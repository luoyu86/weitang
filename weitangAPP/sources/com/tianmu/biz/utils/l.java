package com.tianmu.biz.utils;

import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FileFilter f10868a = new a();

    public static class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i2 = 3; i2 < name.length(); i2++) {
                if (name.charAt(i2) < '0' || name.charAt(i2) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static float a() {
        try {
            return (b() / 1000.0f) / 1000.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int b() {
        int iIntValue = 0;
        for (int i2 = 0; i2 < c(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (bArr[i3] >= 48 && bArr[i3] <= 57 && i3 < 128) {
                            i3++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return 0;
            }
        }
        if (iIntValue == 0) {
            return 0;
        }
        return iIntValue;
    }

    public static int c() {
        try {
            if (Build.VERSION.SDK_INT <= 10) {
                return 1;
            }
            return new File("/sys/devices/system/cpu/").listFiles(f10868a).length;
        } catch (NullPointerException | SecurityException | Exception unused) {
            return 0;
        }
    }
}
