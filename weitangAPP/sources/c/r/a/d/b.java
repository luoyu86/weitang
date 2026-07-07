package c.r.a.d;

import android.os.Environment;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static boolean a(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static void closeIO(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        try {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static File getFileByPath(String str) {
        if (a(str)) {
            return null;
        }
        return new File(str);
    }

    public static File getRootPath() {
        return Environment.getDataDirectory();
    }

    public static boolean sdCardIsAvailable() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return new File(Environment.getExternalStorageDirectory().getPath()).canWrite();
        }
        return false;
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
