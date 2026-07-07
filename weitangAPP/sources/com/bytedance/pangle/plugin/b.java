package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDexExtractor;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taobao.accs.common.Constants;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i f6141a = i.a();

    public static class a extends IOException {
        public /* synthetic */ a(String str, byte b2) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th, byte b2) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static boolean a(final File file, final String str, final int i2) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            i iVar = f6141a;
            iVar.a(1000, 0, str, i2, null);
            com.bytedance.pangle.log.a aVarA = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f5961e, b.a.r, str, i2, -1L, null);
            int iB = l.a().b(str, i2, "install");
            int iB2 = l.a().b(str, i2, "load");
            int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            if (iB > 3 || iB2 > 3) {
                removeApkEntryFlag = 0;
            }
            SharedPreferences.Editor editorEdit = l.a().f6291a.edit();
            editorEdit.putInt("remove_entry_flag_" + str + "_" + i2, removeApkEntryFlag);
            editorEdit.apply();
            l.a().c(str, i2, false);
            g.a(com.bytedance.pangle.d.c.a(str, i2));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0099a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.a.a.InterfaceC0099a
                public final void a() {
                    b.a(file, str, i2, stringBuffer);
                }
            }, new a.InterfaceC0099a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.a.a.InterfaceC0099a
                public final void a() throws Throwable {
                    final Map mapF = b.f(file, str, i2, stringBuffer);
                    b.c(file, str, i2, stringBuffer);
                    b.a(b.g(file, str, i2, stringBuffer), str, i2, stringBuffer);
                    if (com.bytedance.pangle.util.i.f() || com.bytedance.pangle.util.i.b()) {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0099a() { // from class: com.bytedance.pangle.plugin.b.2.1
                            @Override // com.bytedance.pangle.a.a.InterfaceC0099a
                            public final void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.a(str, i2, mapF, stringBuffer);
                            }
                        }, new a.InterfaceC0099a() { // from class: com.bytedance.pangle.plugin.b.2.2
                            @Override // com.bytedance.pangle.a.a.InterfaceC0099a
                            public final void a() {
                                boolean[] zArr3 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr3[0] = b.h(file, str, i2, stringBuffer);
                            }
                        });
                        zArr[0] = b.a(str, i2, zArr2[0], stringBuffer);
                    } else {
                        b.a(str, i2, mapF, stringBuffer);
                        zArr[0] = b.a(str, i2, false, stringBuffer);
                        b.a(str, i2);
                    }
                }
            });
            g.a(file);
            a(com.bytedance.pangle.c.b.f5962f, b.a.s, str, i2, aVarA.a(), stringBuffer.toString());
            aVarA.a(com.taobao.agoo.a.a.b.JSON_SUCCESS);
            iVar.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, 0, str, i2, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f5962f, b.a.t, str, i2, -1L, stringBuffer.toString());
                f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -1, str, i2, th);
            }
            if (zArr[0]) {
                l.a().a(str, i2, "install");
            }
            return false;
        }
    }

    public static /* synthetic */ void c(File file, String str, int i2, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte b2 = 0;
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!listAsList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), b2);
                        }
                    }
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f5962f, b.a.v, str, i2, -1L, null);
                f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -4, str, i2, e2);
                throw new a("安装包权限校验失败", e2, b2);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> f(File file, String str, int i2, StringBuffer stringBuffer) {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte b2 = 0;
        try {
            try {
                e<Boolean, Map<String, List<ZipEntry>>> eVarA = com.bytedance.pangle.d.b.a(file);
                boolean zBooleanValue = eVarA.f6282a.booleanValue();
                Map<String, List<ZipEntry>> map = eVarA.f6283b;
                if (zBooleanValue) {
                    return map;
                }
                throw new a(str2, b2);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f5962f, b.a.A, str, i2, -1L, null);
                f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -5, str, i2, e2);
                throw new a(str2, e2, b2);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        }
        stringBuffer.append("checkMatchHostAbi cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(File file, String str, int i2, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strB = com.bytedance.pangle.d.c.b(str, i2);
        try {
            try {
                h.a(file.getAbsolutePath(), strB);
                return strB;
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f5962f, b.a.w, str, i2, -1L, null);
                f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -6, str, i2, e2);
                throw new a("安装包拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023e: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:72:0x023e */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0242: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:74:0x0242 */
    public static boolean h(File file, String str, int i2, StringBuffer stringBuffer) throws Throwable {
        String str2;
        String str3;
        String str4;
        File file2;
        String str5 = MultiDexExtractor.DEX_SUFFIX;
        String str6 = "classes";
        String str7 = com.alipay.sdk.m.u.i.f5697b;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                try {
                    if (!com.bytedance.pangle.util.i.b()) {
                        str3 = com.alipay.sdk.m.u.i.f5697b;
                        if (com.bytedance.pangle.util.i.f()) {
                            String strC = com.bytedance.pangle.d.c.c(str, i2);
                            String strB = com.bytedance.pangle.d.c.b(str, i2);
                            StringBuilder sb = new StringBuilder();
                            sb.append(strC);
                            String str8 = File.separator;
                            sb.append(str8);
                            sb.append(com.bytedance.pangle.e.b.a(strB));
                            String string = sb.toString();
                            if (com.bytedance.pangle.e.b.a(strB, strC + str8 + com.bytedance.pangle.e.b.a(strB)) && com.bytedance.pangle.e.b.a(string)) {
                                stringBuffer.append("dexOpt1 cost:");
                                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                                stringBuffer.append(str3);
                                return true;
                            }
                        }
                    } else {
                        if (!file.exists() || str == null) {
                            throw new IOException("Could not check apk info " + file.getAbsolutePath());
                        }
                        ZipFile zipFile = null;
                        try {
                            ZipFile zipFile2 = new ZipFile(file);
                            try {
                                ArrayList arrayList = new ArrayList();
                                File file3 = new File(com.bytedance.pangle.d.c.i(str, i2));
                                com.bytedance.pangle.e.g.a(file3);
                                int i3 = 1;
                                while (true) {
                                    StringBuilder sb2 = new StringBuilder(str6);
                                    Object objValueOf = "";
                                    sb2.append(i3 == 1 ? "" : Integer.valueOf(i3));
                                    sb2.append(str5);
                                    ZipEntry entry = zipFile2.getEntry(sb2.toString());
                                    if (entry == null) {
                                        str3 = str7;
                                        file.getName();
                                        SharedPreferences.Editor editorEdit = com.bytedance.pangle.e.g.a().edit();
                                        editorEdit.putInt((str + "-" + i2) + ".dex.number", arrayList.size());
                                        editorEdit.commit();
                                        g.a(zipFile2);
                                        com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i2).apply();
                                        f.a();
                                        break;
                                    }
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str6);
                                    String str9 = str7;
                                    if (i3 != 1) {
                                        try {
                                            objValueOf = Integer.valueOf(i3);
                                        } catch (Throwable th) {
                                            th = th;
                                            zipFile = zipFile2;
                                            g.a(zipFile);
                                            throw th;
                                        }
                                    }
                                    sb3.append(objValueOf);
                                    sb3.append(str5);
                                    g.a aVar = new g.a(file3, sb3.toString());
                                    String str10 = str5;
                                    int i4 = 0;
                                    boolean z = false;
                                    while (i4 < 3 && !z) {
                                        try {
                                            com.bytedance.pangle.e.g.a(zipFile2, entry, aVar, str6);
                                            str4 = str6;
                                            file2 = file3;
                                            z = true;
                                        } catch (IOException e2) {
                                            str4 = str6;
                                            file2 = file3;
                                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + aVar.getAbsolutePath(), e2);
                                        }
                                        int i5 = i4 + 1;
                                        StringBuilder sb4 = new StringBuilder("Plugin-MultiDex Extraction ");
                                        sb4.append(z ? "succeeded" : com.alipay.sdk.m.u.h.j);
                                        sb4.append(" '");
                                        sb4.append(aVar.getAbsolutePath());
                                        sb4.append("': length ");
                                        sb4.append(aVar.length());
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb4.toString());
                                        if (!z) {
                                            aVar.delete();
                                            if (aVar.exists()) {
                                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + aVar.getPath() + OperatorName.SHOW_TEXT_LINE);
                                            }
                                        }
                                        i4 = i5;
                                        str6 = str4;
                                        file3 = file2;
                                    }
                                    String str11 = str6;
                                    File file4 = file3;
                                    if (!z) {
                                        throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                                    }
                                    arrayList.add(aVar);
                                    i3++;
                                    str5 = str10;
                                    str7 = str9;
                                    str6 = str11;
                                    file3 = file4;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    stringBuffer.append(str3);
                    return false;
                } catch (Exception e3) {
                    e = e3;
                    a(com.bytedance.pangle.c.b.f5962f, b.a.z, str, i2, -1L, null);
                    throw new a("dexOpt1失败", e, (byte) 0);
                } catch (Throwable th4) {
                    th = th4;
                    str7 = str2;
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    stringBuffer.append(str7);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static void a(String str, int i2, @NonNull String str2, int i3, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i3)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j))));
            jSONObject2.putOpt(Constants.SHARED_MESSAGE_ID_FILE, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static /* synthetic */ void a(File file, String str, int i2, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                    return;
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f5962f, b.a.u, str, i2, -1L, null);
                f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -3, str, i2, e2);
                throw new a(e2.getMessage(), e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        }
        stringBuffer.append("checkSignature cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
    }

    public static /* synthetic */ void a(String str, String str2, int i2, StringBuffer stringBuffer) throws a {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        byte b2 = 0;
        int iA = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb);
        stringBuffer.append(iA == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        if (iA == 100 || iA == 200) {
            return;
        }
        String string = sb.toString();
        a(com.bytedance.pangle.c.b.f5962f, b.a.B, str2, i2, -1L, string);
        f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -2, str2, i2, null);
        throw new a("modifyRes failed. result = " + iA + ", errorLog = " + string, b2);
    }

    public static /* synthetic */ void a(String str, int i2, Map map, StringBuffer stringBuffer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i2)), new File(com.bytedance.pangle.d.c.d(str, i2)), str, (Map<String, List<ZipEntry>>) map);
            } catch (Exception e2) {
                a(com.bytedance.pangle.c.b.f5962f, b.a.x, str, i2, -1L, com.bytedance.pangle.log.b.a((Object) e2));
                f6141a.a(ZeusPluginEventCallback.EVENT_FINISH_INSTALLATION, -7, str, i2, e2);
                throw new a("安装包动态库拷贝失败", e2, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        }
    }

    public static /* synthetic */ boolean a(String str, int i2, boolean z, StringBuffer stringBuffer) {
        int iB = l.a().b(str, i2);
        boolean z2 = (iB & 1) != 0;
        boolean z3 = (iB & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strB = com.bytedance.pangle.d.c.b(str, i2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zA = com.bytedance.pangle.util.b.b.a(strB, z4, z3, str, i2, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(com.alipay.sdk.m.u.i.f5697b);
        return zA;
    }

    public static /* synthetic */ void a(String str, int i2) throws a {
        byte b2 = 0;
        try {
            if (com.bytedance.pangle.util.i.e() || com.bytedance.pangle.util.i.g()) {
                l.a().b(str, i2, false);
                com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i2).apply();
                f.a();
            }
        } catch (Exception e2) {
            a(com.bytedance.pangle.c.b.f5962f, b.a.z, str, i2, -1L, null);
            throw new a("dexOpt2失败", e2, b2);
        }
    }
}
