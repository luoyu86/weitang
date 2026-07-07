package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile l f6290b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f6291a = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private l() {
    }

    public static l a() {
        if (f6290b == null) {
            synchronized (l.class) {
                if (f6290b == null) {
                    f6290b = new l();
                }
            }
        }
        return f6290b;
    }

    public final String b(String str) {
        String string = this.f6291a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final void c(String str, int i2, boolean z) {
        SharedPreferences.Editor editorEdit = this.f6291a.edit();
        editorEdit.putBoolean("dex_remove_state_" + str + "_" + i2, z);
        editorEdit.apply();
    }

    public final void b(String str, int i2, boolean z) {
        SharedPreferences.Editor editorEdit = this.f6291a.edit();
        editorEdit.putBoolean("dex_opt_state_" + str + "_" + i2, z);
        editorEdit.apply();
    }

    public final int a(String str) {
        int i2 = this.f6291a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i2);
        return i2;
    }

    public final int b(String str, int i2) {
        return this.f6291a.getInt("remove_entry_flag_" + str + "_" + i2, 0);
    }

    public final void a(String str, int i2, boolean z) {
        SharedPreferences.Editor editorEdit = this.f6291a.edit();
        String str2 = "INSTALLED_" + str + "-" + i2;
        if (z) {
            editorEdit.putBoolean(str2, true);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
    }

    public final int b(String str, int i2, String str2) {
        return this.f6291a.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i2, 0);
    }

    public final boolean a(String str, int i2) {
        return this.f6291a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i2)), false);
    }

    public final void a(String str, int i2, String str2) {
        int iB = b(str, i2, str2);
        SharedPreferences.Editor editorEdit = this.f6291a.edit();
        editorEdit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i2, iB + 1);
        editorEdit.apply();
    }
}
