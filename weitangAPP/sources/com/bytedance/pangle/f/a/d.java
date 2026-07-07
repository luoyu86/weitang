package com.bytedance.pangle.f.a;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.pangle.util.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static e a(File file) {
        ZipFile zipFile;
        a aVar;
        int iB;
        int i2;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                g.a((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    g.a(zipFile2);
                    return null;
                }
                aVar = new a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar.a();
                    if (inputStream != null) {
                        aVar.f6047b = new b(inputStream);
                    }
                    do {
                        iB = aVar.b();
                        if (iB == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.a();
                            } catch (Throwable unused) {
                            }
                            g.a(zipFile2);
                            return null;
                        }
                    } while (iB != 2);
                    int length = aVar.f6046a != 2 ? -1 : aVar.f6048c.length / 5;
                    String strA = null;
                    String strA2 = null;
                    for (int i3 = 0; i3 != length; i3++) {
                        if (TTDownloadField.TT_VERSION_CODE.equals(aVar.a(i3))) {
                            strA = a(aVar, i3);
                        } else if (AbsServerManager.PACKAGE_QUERY_BINDER.equals(aVar.a(i3))) {
                            strA2 = a(aVar, i3);
                        }
                    }
                    try {
                        i2 = Integer.parseInt(strA);
                    } catch (Throwable unused2) {
                        i2 = -1;
                    }
                    if (i2 == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strA)));
                        try {
                            aVar.a();
                        } catch (Throwable unused3) {
                        }
                        g.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(strA2, i2);
                    try {
                        aVar.a();
                    } catch (Throwable unused4) {
                    }
                    g.a(zipFile2);
                    return eVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        e eVar2 = new e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused5) {
                            }
                        }
                        g.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused6) {
                            }
                        }
                        g.a(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            aVar = null;
        }
    }

    private static String a(int i2) {
        return (i2 >>> 24) == 1 ? "android:" : "";
    }

    private static String a(a aVar, int i2) {
        int iB = aVar.b(i2);
        int iC = aVar.c(i2);
        if (iB == 3) {
            return aVar.d(i2);
        }
        return iB == 2 ? String.format("?%s%08X", a(iC), Integer.valueOf(iC)) : (iB < 16 || iB > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iC), Integer.valueOf(iB)) : String.valueOf(iC);
    }
}
