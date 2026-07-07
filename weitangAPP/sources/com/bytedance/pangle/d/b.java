package com.bytedance.pangle.d;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Integer> f5983b;

    static {
        HashMap map = new HashMap();
        f5983b = map;
        map.put("arm64-v8a", 64);
        f5983b.put("armeabi-v7a", 32);
        f5983b.put("armeabi", 32);
        f5983b.put("x86_64", 64);
        f5983b.put("x86", 32);
        f5983b.put("mips64", 64);
        f5983b.put("mips", 32);
        f5982a = c();
    }

    private static Map<String, List<ZipEntry>> a(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && !zipEntryNextElement.getName().contains("../") && zipEntryNextElement.getName().startsWith("lib/") && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (f5983b.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    public static int b() {
        return f5983b.get(a()).intValue();
    }

    private static String c() {
        JSONObject jSONObjectD = d();
        String strA = a(jSONObjectD);
        return strA == null ? b(jSONObjectD) : strA;
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static String b(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(a(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = i.a() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            a(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            a(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                a(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (i.a()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            a(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        a(jSONObject, "defaultABI", str2);
        return str2;
    }

    private static void a(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String strSubstring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(strSubstring)) {
                list.add(zipEntry);
                set.add(strSubstring);
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i2 = 0;
        boolean z = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                g.a(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z = true;
            } catch (IOException e2) {
                if (i2 >= 3) {
                    throw e2;
                }
                i2++;
            }
        } while (!z);
    }

    public static boolean b(File file) throws Throwable {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                    Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches()) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (IOException unused) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e2) {
                    e = e2;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a() {
        String str = f5982a;
        if (str != null) {
            return str;
        }
        String strC = c();
        f5982a = strC;
        return strC;
    }

    private static String a(JSONObject jSONObject) {
        if (!i.a()) {
            return null;
        }
        try {
            String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            a(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    i2 = Process.is64Bit() ? 64 : 32;
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i2)));
                } catch (Exception unused) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i2)));
                }
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            a(jSONObject, "processMode", String.valueOf(i2));
            if (i2 != 0) {
                if (f5983b.get(str).intValue() != i2) {
                    return null;
                }
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
                return str;
            }
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
            return str;
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e2);
            a(jSONObject, "autoError", "1");
            return null;
        }
    }

    public static com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> a(File file) throws Throwable {
        boolean zA;
        HashMap map = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    map.putAll(a(zipFile2));
                    if (map.isEmpty()) {
                        zA = true;
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                    } else {
                        zA = a(map, f5982a);
                        if (zA) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zA + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zA + "], " + file);
                        }
                    }
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> eVar = new com.bytedance.pangle.util.e<>(Boolean.valueOf(zA), map);
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return eVar;
                } catch (IOException e2) {
                    e = e2;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> eVar2 = new com.bytedance.pangle.util.e<>(Boolean.FALSE, map);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return eVar2;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean a(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r16, java.io.File r17, java.lang.String r18, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.d.b.a(java.io.File, java.io.File, java.lang.String, java.util.Map):void");
    }
}
