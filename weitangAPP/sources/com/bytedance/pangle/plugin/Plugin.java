package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    public final Object installLock = new Object();
    public final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mApiVersionCode = jSONObject.getInt(TTLiveConstants.LIVE_API_VERSION_KEY);
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString(Constants.KEY_APP_KEY, "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                this.mSharedHostSos.add((String) jSONArrayOptJSONArray.get(i2));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i2) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i2 < this.mMinVersionCode || i2 > this.mMaxVersionCode) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i2), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
            return false;
        }
        if (i2 < this.mVersionCode && isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i2), Integer.valueOf(this.mVersionCode)));
            return false;
        }
        if (file == null || !file.exists()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i2 == this.mVersionCode && l.a().f6291a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i2 + " true");
        return true;
    }

    private boolean checkVersionValid(int i2, int i3, boolean z) {
        int iA = l.a().a(this.mPkgName);
        boolean z2 = false;
        if (iA > i3) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(iA), Integer.valueOf(i3)))));
            return false;
        }
        boolean z3 = i2 >= 0 && i2 >= this.mMinVersionCode && i2 <= this.mMaxVersionCode;
        if (z3 && i3 != -1) {
            l lVarA = l.a();
            String str = this.mPkgName;
            int i4 = lVarA.f6291a.getInt("API_MIN_" + str + "_" + i2, 0);
            l lVarA2 = l.a();
            String str2 = this.mPkgName;
            SharedPreferences sharedPreferences = lVarA2.f6291a;
            String str3 = "API_MAX_" + str2 + "_" + i2;
            int i5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i6 = sharedPreferences.getInt(str3, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i6 != 0) {
                i5 = i6;
            }
            if (i3 < i4 || i3 > i5) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)))));
                z3 = false;
            }
        }
        if (z3 && z && com.bytedance.pangle.d.b.b(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i2)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i2)))));
        } else {
            z2 = z3;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (l.a().f6291a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l lVarA = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor editorEdit = lVarA.f6291a.edit();
                editorEdit.remove("UNINSTALL__".concat(String.valueOf(str)));
                editorEdit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i2) {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            final String strConcat = "version-".concat(String.valueOf(i2));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !strConcat.equals(file.getName()) && !"data".equals(file.getName())) {
                        g.a(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public final void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + ".apk");
                        }
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                            return;
                        }
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i2) {
        String strA = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
        if (!TextUtils.isEmpty(strA) && TextUtils.equals(l.a().b(this.mPkgName), strA)) {
            return i2;
        }
        if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i2);
            return 0;
        }
        ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i2);
        int iA = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i2)), true, new StringBuilder());
        if (iA == 100 || iA == 200) {
            return i2;
        }
        return 0;
    }

    private void setupInternalPlugin() {
        int iA;
        if (l.a().f6291a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(h.f6112d)) {
                    if (str.startsWith(this.mPkgName + "_") && (iA = k.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = h.f6112d + "/" + str;
                        this.mInternalVersionCode = iA;
                        return;
                    }
                }
            } catch (IOException e2) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e2);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c cVarA;
        try {
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (cVarA = com.bytedance.pangle.servermanager.b.a()) == null || !cVarA.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(cVarA.b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.d.d.a());
            ZeusLogger.w(ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i2) {
        this.mVersionCode = i2;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        File[] fileArrListFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i2 = -1;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i3 = Integer.parseInt(file.getName().split("-")[1]);
                if (i3 > i2 && l.a().a(this.mPkgName, i3) && new File(com.bytedance.pangle.d.c.b(this.mPkgName, i3)).exists()) {
                    i2 = i3;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i2);
        return i2;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i2 = this.mVersionCode;
        return i2 > 0 ? com.bytedance.pangle.d.c.d(this.mPkgName, i2) : com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
                int iModifyResIfNeed = 0;
                if (!TextUtils.isEmpty(l.a().f6291a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    l lVarA = l.a();
                    String str = this.mPkgName;
                    z = !TextUtils.equals(lVarA.f6291a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + lVarA.f6291a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    iModifyResIfNeed = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(iModifyResIfNeed);
                }
                deleteOtherExpiredVer(iModifyResIfNeed);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                l lVarA2 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor editorEdit = lVarA2.f6291a.edit();
                editorEdit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                editorEdit.apply();
                l lVarA3 = l.a();
                String str3 = this.mPkgName;
                String string = lVarA3.f6291a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor editorEdit2 = lVarA3.f6291a.edit();
                editorEdit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                editorEdit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l lVarA4 = l.a();
                String str4 = this.mPkgName;
                String strA = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
                String strB = lVarA4.b(str4);
                if (!TextUtils.equals(strB, strA)) {
                    SharedPreferences.Editor editorEdit3 = lVarA4.f6291a.edit();
                    editorEdit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), strA);
                    editorEdit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + strB + " --> " + strA);
                l lVarA5 = l.a();
                String str5 = this.mPkgName;
                int i2 = this.mApiVersionCode;
                int iA = lVarA5.a(str5);
                if (iA != i2) {
                    SharedPreferences.Editor editorEdit4 = lVarA5.f6291a.edit();
                    editorEdit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i2);
                    editorEdit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + iA + " --> " + i2);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean zA = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = eVar.f6060a;
            int i2 = eVar.f6061b;
            synchronized (this.installLock) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean zCheckValid = checkValid(file, str, i2);
                if (zCheckValid) {
                    String str2 = com.bytedance.pangle.util.c.a(file)[0];
                    zA = b.a(file, str, i2);
                    if (zA) {
                        l lVarA = l.a();
                        String str3 = this.mPkgName;
                        SharedPreferences.Editor editorEdit = lVarA.f6291a.edit();
                        editorEdit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                        editorEdit.apply();
                        l.a().a(this.mPkgName, i2, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i2 + " identity=" + str2);
                        g.a(file);
                    }
                }
                synchronized (this) {
                    if (!zCheckValid) {
                        g.a(file);
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i2);
                    } else if (this.mLifeCycle == 3) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i2);
                    } else if (zA) {
                        updateToInstalled(i2);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i2);
                    } else {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i2);
                        g.a(file);
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i2);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
        }
        return zA;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i2) {
        return l.a().a(this.mPkgName, i2);
    }

    public void setApiCompatVersion(int i2, int i3, int i4) {
        l lVarA = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor editorEdit = lVarA.f6291a.edit();
        editorEdit.putInt("API_MIN_" + str + "_" + i2, i3);
        editorEdit.putInt("API_MAX_" + str + "_" + i2, i4);
        editorEdit.apply();
    }

    public void setLifeCycle(int i2) {
        this.mLifeCycle = i2;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
