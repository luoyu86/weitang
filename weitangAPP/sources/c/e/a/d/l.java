package c.e.a.d;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1222a;

        public a(String str) {
            this.f1222a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f1222a);
            if (!file.isDirectory()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str : list) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    l.deleteFolder(file2.getAbsolutePath());
                } else {
                    file2.delete();
                }
            }
            file.delete();
        }
    }

    public static /* synthetic */ void a(List list, String str) {
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                File file = (File) list.get(i2);
                if (file != null && file.exists() && file.canWrite()) {
                    if (!x.isNotNull(str)) {
                        file.delete();
                    } else if (file.getName().contains(str)) {
                        file.delete();
                    }
                }
            }
        }
    }

    public static boolean copyFile(File file, File file2) {
        if (file2.exists()) {
            file2.delete();
        }
        if (file2.exists() || !file.exists()) {
            return false;
        }
        try {
            if (!file2.createNewFile()) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String createFolder(String str) {
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (file.exists() || !file.mkdirs()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public static void createMicroTangFolder() {
        createFolder("MicroTang");
    }

    public static void deleteFileList(final List<File> list, final String str) {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.d.a
            @Override // java.lang.Runnable
            public final void run() {
                l.a(list, str);
            }
        });
    }

    public static void deleteFolder(String str) {
        y.get().addRunnable(new a(str));
    }

    public static String getAdLockNamePath() {
        return getAppCacheDir().getPath() + File.separator;
    }

    public static String getAdSplashNamePath() {
        return getAppCacheDir().getPath() + File.separator;
    }

    public static File getAppCacheDir() {
        return c.e.a.a.b.getInstance().getContext().getCacheDir();
    }

    public static String getFileName(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return "";
        }
        String str2 = pathSegments.get(pathSegments.size() - 1);
        return str2.length() >= 18 ? str2.substring(str2.length() - 18) : str2;
    }

    public static String getFileSuffix(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return "";
        }
        String str2 = pathSegments.get(pathSegments.size() - 1);
        if (str2.lastIndexOf(Consts.DOT) < 0) {
            return str2;
        }
        String strSubstring = str2.substring(str2.lastIndexOf(Consts.DOT));
        q.d(c.e.a.a.h.c.class.getSimpleName(), "file name: " + str2 + ", fileE:" + strSubstring);
        return strSubstring;
    }

    public static String getHtmlSavePath(Context context) {
        File appCacheDir;
        if (context == null || (appCacheDir = getAppCacheDir()) == null) {
            return null;
        }
        return appCacheDir.getPath();
    }

    public static String getOAIDFilePath() {
        return new File(getAppCacheDir(), "oaid_cert.pem").getAbsolutePath();
    }

    public static File getPdfAppCacheDir() {
        File file = new File(getAppCacheDir().getAbsolutePath(), "PDF");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getSaveImgFolderPath() {
        File file = new File(getWtFolderPath(), "SaveImg");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getSignSavePath(Context context) {
        return getAppCacheDir().getPath() + "sign.jpg";
    }

    public static String getWtFolderPath() {
        File file = new File(Environment.getExternalStorageDirectory(), "MicroTang");
        return file.exists() ? file.getAbsolutePath() : getAppCacheDir().getAbsolutePath();
    }

    public static boolean isExitFolder() {
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return new File(Environment.getExternalStorageDirectory(), "vtapp").exists();
        }
        return false;
    }

    public static String renameFile(String str) {
        File file = new File(str);
        File file2 = new File(file.getParent(), System.currentTimeMillis() + ".jpg");
        return (file.exists() && file.renameTo(file2)) ? file2.getAbsolutePath() : str;
    }

    public static String renamePdfFile(String str, String str2) {
        File file = new File(str);
        File file2 = new File(file.getParent(), str2);
        return (file.exists() && file.renameTo(file2)) ? file2.getAbsolutePath() : str;
    }

    public static String setSavePath(Context context, String str, String str2) {
        String str3;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            str3 = context.getExternalCacheDir().getPath() + str;
        } else {
            str3 = context.getCacheDir().getPath() + str;
        }
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, str2).getAbsolutePath();
    }
}
