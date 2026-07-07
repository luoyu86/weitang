package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f9687a;

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(f9687a)) {
            return f9687a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            f9687a = Application.getProcessName();
            return f9687a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        f9687a = next.processName;
                        return f9687a;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = f9687a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        boolean zEndsWith = str2.endsWith("_");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(zEndsWith ? "" : "_");
        String strA = null;
        try {
            String str3 = new String(str2);
            try {
                strA = d.a(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str3.getBytes("UTF-8")));
            } catch (Exception unused) {
                strA = str3;
            }
        } catch (Exception unused2) {
        }
        sb.append(strA);
        return sb.toString();
    }

    public static void b(Context context, File file, File file2) throws Exception {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        boolean zA;
        AssetManager assets = context.getAssets();
        FileOutputStream fileOutputStream2 = null;
        try {
            h.b();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                String str = "Asset Error " + ((list == null || list.length <= 0) ? "no asset" : TextUtils.join(",", list));
                GDTLogger.e(str);
                throw new Exception(str);
            }
            String str2 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str3 = Sig.ASSET_PLUGIN_SIG;
            if (str3 == null) {
                str3 = "";
            }
            h.c(SDKStatus.getBuildInPluginVersion() + "#####" + str3, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                zA = h.a(assets.open(str2), file);
                inputStream2 = null;
            } else {
                InputStream inputStreamOpen = assets.open(str2);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th2) {
                    inputStream = inputStreamOpen;
                    th = th2;
                    InputStream inputStream3 = inputStream;
                    th = th;
                    inputStreamOpen = inputStream3;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } finally {
                        c(inputStreamOpen);
                        c(fileOutputStream2);
                    }
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = inputStreamOpen.read(bArr);
                        if (i4 <= 0) {
                            break;
                        }
                        int i5 = 0;
                        while (i5 < i4) {
                            int i6 = i3 + 1;
                            if (i3 >= 64) {
                                bArr[i5] = (byte) (bytes[i2 % length] ^ bArr[i5]);
                                i2++;
                            }
                            i5++;
                            i3 = i6;
                        }
                        fileOutputStream.write(bArr, 0, i4);
                    }
                    inputStream2 = inputStreamOpen;
                    fileOutputStream2 = fileOutputStream;
                    zA = true;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (!zA) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
