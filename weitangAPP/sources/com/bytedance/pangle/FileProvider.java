package com.bytedance.pangle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f5924a = {"_display_name", "_size"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final File f5925b = new File("/");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f5926c;

    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    public static void a(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            try {
                String str = plugin.mPkgName;
                Context contextWrapperContext = ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName);
                b bVar = (b) f5926c;
                while (true) {
                    int next = xmlResourceParser.next();
                    if (next == 1) {
                        return;
                    }
                    if (next == 2) {
                        String name = xmlResourceParser.getName();
                        File cacheDir = null;
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            cacheDir = f5925b;
                        } else if ("files-path".equals(name)) {
                            cacheDir = contextWrapperContext.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            cacheDir = contextWrapperContext.getCacheDir();
                        } else if ("external-files-path".equals(name)) {
                            File[] externalFilesDirs = Build.VERSION.SDK_INT >= 19 ? contextWrapperContext.getExternalFilesDirs(null) : new File[]{contextWrapperContext.getExternalFilesDir(null)};
                            if (externalFilesDirs.length > 0) {
                                cacheDir = externalFilesDirs[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            File[] externalCacheDirs = Build.VERSION.SDK_INT >= 19 ? contextWrapperContext.getExternalCacheDirs() : new File[]{contextWrapperContext.getExternalCacheDir()};
                            if (externalCacheDirs.length > 0) {
                                cacheDir = externalCacheDirs[0];
                            }
                        } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                            File[] externalMediaDirs = contextWrapperContext.getExternalMediaDirs();
                            if (externalMediaDirs.length > 0) {
                                cacheDir = externalMediaDirs[0];
                            }
                        }
                        if (cacheDir != null) {
                            String str2 = str + "_" + attributeValue;
                            File fileA = a(cacheDir, attributeValue2);
                            if (TextUtils.isEmpty(str2)) {
                                throw new IllegalArgumentException("Name must not be empty");
                            }
                            try {
                                bVar.f5927a.put(str2, fileA.getCanonicalFile());
                            } catch (IOException e2) {
                                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(fileA)), e2);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (XmlPullParserException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
        }
    }

    @Keep
    public static Uri getUriForFile(@NonNull File file) {
        return f5926c.a(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        if (f5926c != null) {
            throw new SecurityException("仅允许定义一个FileProvider");
        }
        f5926c = new b(providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return f5926c.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        File fileA = f5926c.a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        int i2;
        File fileA = f5926c.a(uri);
        if (PDPageLabelRange.STYLE_ROMAN_LOWER.equals(str)) {
            i2 = 268435456;
        } else if (OperatorName.SET_LINE_WIDTH.equals(str) || "wt".equals(str)) {
            i2 = 738197504;
        } else if ("wa".equals(str)) {
            i2 = 704643072;
        } else if ("rw".equals(str)) {
            i2 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
            }
            i2 = 1006632960;
        }
        return ParcelFileDescriptor.open(fileA, i2);
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i2;
        File fileA = f5926c.a(uri);
        if (strArr == null) {
            strArr = f5924a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = fileA.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i2 = i3 + 1;
                objArr[i3] = Long.valueOf(fileA.length());
            }
            i3 = i2;
        }
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr3, 0, strArr4, 0, i3);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, File> f5927a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5928b;

        public b(String str) {
            this.f5928b = str;
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final Uri a(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f5927a.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
                }
                String path2 = entry.getValue().getPath();
                return new Uri.Builder().scheme("content").authority(this.f5928b).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f5927a.get(strDecode);
            if (file != null) {
                File file2 = new File(file, strDecode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
        }
    }

    private static File a(File file, String... strArr) {
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }
}
