package c.e.a.d;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static void a(Context context, Uri uri, File file) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            b(inputStreamOpenInputStream, fileOutputStream);
            inputStreamOpenInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(6:20|3|(1:5)(1:22)|16|7|12)|6|16|7|12|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.io.InputStream r6, java.io.OutputStream r7) {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r0]
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r6, r0)
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream
            r6.<init>(r7, r0)
            r7 = 0
            r3 = 0
        L10:
            int r4 = r2.read(r1, r7, r0)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L26
            r5 = -1
            if (r4 == r5) goto L1c
            r6.write(r1, r7, r4)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L26
            int r3 = r3 + r4
            goto L10
        L1c:
            r6.flush()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L26
        L1f:
            r6.close()     // Catch: java.lang.Exception -> L2e
            r2.close()     // Catch: java.lang.Exception -> L2e
            goto L2e
        L26:
            r7 = move-exception
            r6.close()     // Catch: java.lang.Exception -> L2d
            r2.close()     // Catch: java.lang.Exception -> L2d
        L2d:
            throw r7
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.d.m.b(java.io.InputStream, java.io.OutputStream):int");
    }

    public static String c(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String d(Uri uri) {
        String path;
        int iLastIndexOf;
        if (uri == null || (iLastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
            return null;
        }
        return path.substring(iLastIndexOf + 1);
    }

    public static String e(Context context, Uri uri) {
        String strF = f(context, uri);
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        File filesDir = context.getApplicationContext().getFilesDir();
        String strD = d(uri);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        File file = new File(filesDir + File.separator + strD);
        a(context, uri, file);
        return file.getAbsolutePath();
    }

    public static String f(Context context, Uri uri) {
        int columnIndex;
        String string = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme)) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_data")) > -1) {
            string = cursorQuery.getString(columnIndex);
        }
        cursorQuery.close();
        return string;
    }

    public static boolean g(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static String getFileAbsolutePath(Context context, Uri uri) {
        Uri uri2 = null;
        if (context != null && uri != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 19) {
                return f(context, uri);
            }
            if (i2 >= 19 && i2 < 29 && DocumentsContract.isDocumentUri(context, uri)) {
                if (h(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (g(uri)) {
                        return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (j(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (c.e.b.c.d.o.VIDEO_TYPE.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(str)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return c(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            }
            if (i2 >= 29) {
                return k(context, uri);
            }
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return i(uri) ? uri.getLastPathSegment() : i2 >= 24 ? e(context, uri) : c(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean h(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean i(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean j(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static String k(Context context, Uri uri) {
        File file = null;
        if (uri.getScheme().equals("file")) {
            file = new File(uri.getPath());
        } else if (uri.getScheme().equals("content")) {
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    File file2 = new File(context.getExternalCacheDir().getAbsolutePath() + "/" + System.currentTimeMillis());
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    File file3 = new File(file2.getPath(), string);
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    if (Build.VERSION.SDK_INT >= 29) {
                        FileUtils.copy(inputStreamOpenInputStream, fileOutputStream);
                    }
                    try {
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        file = file3;
                    } catch (IOException e2) {
                        file = file3;
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
        }
        return file.getAbsolutePath();
    }
}
