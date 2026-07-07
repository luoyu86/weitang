package com.bytedance.pangle.e;

import android.content.SharedPreferences;
import androidx.multidex.MultiDexExtractor;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    public static class a extends File {
        public a(File file, String str) {
            super(file, str);
        }
    }

    public static String a(String str, int i2) {
        int iB = b(str, i2);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 1; i3 <= iB; i3++) {
            sb.append(new a(new File(com.bytedance.pangle.d.c.i(str, i2)), i3 == 1 ? "classes" + MultiDexExtractor.DEX_SUFFIX : "classes" + i3 + MultiDexExtractor.DEX_SUFFIX).getAbsolutePath());
            sb.append(":");
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static int b(String str, int i2) {
        return a((str + "-" + i2) + ".dex.number");
    }

    public static void a(ZipFile zipFile, ZipEntry zipEntry, a aVar, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), MultiDexExtractor.DEX_SUFFIX, aVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i2);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (fileCreateTempFile.setReadOnly()) {
                    if (fileCreateTempFile.renameTo(aVar)) {
                        return;
                    }
                    throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + aVar.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + aVar.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } finally {
            a(inputStream);
            fileCreateTempFile.delete();
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e2);
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    public static SharedPreferences a() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int a(String str) {
        return a().getInt(str, 0);
    }
}
