package c.e.a.d;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f1234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1235b;

    public w(@NonNull String str) {
        this.f1235b = str;
    }

    public static w get(@NonNull String str) {
        return new w(str);
    }

    public static w getInstance() {
        return get("app_config");
    }

    public final SharedPreferences a() {
        if (this.f1234a == null) {
            synchronized (SharedPreferences.class) {
                if (this.f1234a == null) {
                    this.f1234a = c.e.a.a.b.getInstance().getContext().getSharedPreferences(this.f1235b, 0);
                }
            }
        }
        return this.f1234a;
    }

    public synchronized void clear() {
        j.getInstance().setPublicKey(null);
        c.e.a.a.b.getInstance().setToken(null);
        c.e.a.a.a.getInstance().setShowPwdDoor(false);
        putString(com.alipay.sdk.m.p.e.o, null);
        putString("Token", null);
        putBoolean("is_show_pwd_door", false);
        putString("userInfoKey", null);
        putString("userDetailsInfoKey", null);
    }

    public boolean getBoolean(String str, boolean z) {
        return a().getBoolean(str, z);
    }

    public float getFloat(String str, float f2) {
        return a().getFloat(str, f2);
    }

    public int getInt(String str, int i2) {
        return a().getInt(str, i2);
    }

    public long getLong(String str, long j) {
        return a().getLong(str, j);
    }

    public String getString(String str, String str2) {
        return a().getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return a().getStringSet(str, set);
    }

    public synchronized void putBoolean(String str, boolean z) {
        a().edit().putBoolean(str, z).commit();
    }

    public synchronized void putFloat(String str, float f2) {
        a().edit().putFloat(str, f2).commit();
    }

    public synchronized void putInt(String str, int i2) {
        if ("ad_time_key".equals(str)) {
            q.d(getClass().getSimpleName(), "putInt  value = " + i2);
        }
        a().edit().putInt(str, i2).commit();
    }

    public synchronized void putLong(String str, long j) {
        a().edit().putLong(str, j).commit();
    }

    public synchronized void putString(String str, String str2) {
        if ("selectProjectKey".equals(str) && x.isNotNull(str2)) {
            c.e.a.a.b.getInstance().setProjectKey(str2);
        }
        if (x.isNullStr(str2)) {
            remove(str);
        } else {
            a().edit().putString(str, str2).commit();
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        a().edit().putStringSet(str, set).commit();
    }

    public void remove(String str) {
        if (a().contains(str)) {
            a().edit().remove(str).commit();
        }
    }

    public void removeAll() {
        a().edit().clear().commit();
    }
}
