package com.nanchen.compresshelper;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    public static final String FILES_PATH = "CompressHelper";

    private FileUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long jCopyLarge = copyLarge(inputStream, outputStream);
        if (jCopyLarge > 2147483647L) {
            return -1;
        }
        return (int) jCopyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copyLarge(inputStream, outputStream, new byte[4096]);
    }

    public static File getFileByPath(String str) {
        if (StringUtil.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[DONT_GENERATE, PHI: r1
  0x003b: PHI (r1v6 java.lang.String) = (r1v1 java.lang.String), (r1v7 java.lang.String) binds: [B:13:0x0031, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileName(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L3e
            android.content.ContentResolver r2 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)
            if (r8 == 0) goto L39
            boolean r0 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r0 == 0) goto L39
            java.lang.String r0 = "_display_name"
            int r0 = r8.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r0 = r8.getString(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r1 = r0
            goto L39
        L2e:
            r9 = move-exception
            goto L35
        L30:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            goto L3b
        L35:
            r8.close()
            throw r9
        L39:
            if (r8 == 0) goto L3e
        L3b:
            r8.close()
        L3e:
            if (r1 != 0) goto L53
            java.lang.String r1 = r9.getPath()
            java.lang.String r8 = java.io.File.separator
            int r8 = r1.lastIndexOf(r8)
            r9 = -1
            if (r8 == r9) goto L53
            int r8 = r8 + 1
            java.lang.String r1 = r1.substring(r8)
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nanchen.compresshelper.FileUtil.getFileName(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static String getRealPathFromURI(Context context, Uri uri) {
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return uri.getPath();
        }
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
        cursorQuery.close();
        return string;
    }

    public static File getTempFile(Context context, Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        String fileName = getFileName(context, uri);
        String[] strArrSplitFileName = splitFileName(fileName);
        File fileRenameFile = renameFile(File.createTempFile(strArrSplitFileName[0], strArrSplitFileName[1]), fileName);
        fileRenameFile.deleteOnExit();
        try {
            fileOutputStream = new FileOutputStream(fileRenameFile);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            fileOutputStream = null;
        }
        if (inputStreamOpenInputStream != null) {
            copy(inputStreamOpenInputStream, fileOutputStream);
            inputStreamOpenInputStream.close();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return fileRenameFile;
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFileExists(String str) {
        return isFileExists(getFileByPath(str));
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static File renameFile(File file, String str) {
        File file2 = new File(file.getParent(), str);
        if (!file2.equals(file)) {
            if (file2.exists() && file2.delete()) {
                Log.d("FileUtil", "Delete old " + str + " file");
            }
            if (file.renameTo(file2)) {
                Log.d("FileUtil", "Rename file to " + str);
            }
        }
        return file2;
    }

    public static String[] splitFileName(String str) {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        if (iLastIndexOf != -1) {
            String strSubstring2 = str.substring(0, iLastIndexOf);
            strSubstring = str.substring(iLastIndexOf);
            str = strSubstring2;
        } else {
            strSubstring = "";
        }
        return new String[]{str, strSubstring};
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    public static boolean isDir(File file) {
        return isFileExists(file) && file.isDirectory();
    }

    public static boolean isFile(File file) {
        return isFileExists(file) && file.isFile();
    }

    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || StringUtil.isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }
}
