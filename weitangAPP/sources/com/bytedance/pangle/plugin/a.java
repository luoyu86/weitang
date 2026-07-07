package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taobao.accs.common.Constants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f6139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6140b;

    public a(String str, File file) {
        this.f6139a = file;
        this.f6140b = str;
    }

    private static File a(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private void b() {
        int i2 = 3;
        while (i2 > 0) {
            i2--;
            try {
                File file = new File(this.f6139a.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                g.b(this.f6139a.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.f6139a;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                File fileA = a(file2);
                if (fileA != null && fileA.exists() && fileA.isFile()) {
                    this.f6139a = fileA;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i2));
                    return;
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e2);
                e2.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }

    private static void a(String str, int i2, @NonNull String str2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a((Object) 0));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j))));
            jSONObject2.putOpt(Constants.SHARED_MESSAGE_ID_FILE, com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public final boolean a() {
        if (g.b(this.f6139a)) {
            ZeusLogger.d("Plugin install : start unZip file ~~~~");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            b();
            a(com.bytedance.pangle.c.b.f5964h, b.a.G, this.f6140b, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
            ZeusLogger.d("Plugin install : start install from unZip ~~~~");
        } else {
            ZeusLogger.d("Plugin install : start install without unZip ~~~~");
        }
        e eVarA = com.bytedance.pangle.f.a.d.a(this.f6139a);
        if (eVarA == null) {
            ZeusPluginStateListener.postStateChange(this.f6140b, 7, " read local file package info failed !!! pluginPkg = " + this.f6140b + " mApkFile.exists = " + this.f6139a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.f6140b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(eVarA.f6060a);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.f6140b, 7, " plugin == null !!! pluginPkg = " + this.f6140b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + eVarA.f6060a);
            return false;
        }
        boolean zInstall = plugin.install(this.f6139a, eVarA);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(eVarA.f6060a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(eVarA.f6060a, 7, "Internal error.");
        }
        return zInstall;
    }
}
