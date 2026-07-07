package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.ta.a.c.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f10212a;

    public a(Context context, String str, String str2) {
        this.f10212a = null;
        if (context == null) {
            return;
        }
        this.f10212a = context.getSharedPreferences(str2, 0);
    }

    public int a() {
        SharedPreferences sharedPreferences = this.f10212a;
        int i2 = sharedPreferences != null ? sharedPreferences.getInt("type", 0) : 0;
        f.m80a("PersistentConfiguration", "getTypeFromSp type", Integer.valueOf(i2));
        return i2;
    }

    public String k() {
        SharedPreferences sharedPreferences = this.f10212a;
        String string = sharedPreferences != null ? sharedPreferences.getString("UTDID2", "") : "";
        f.m80a("PersistentConfiguration", "getUtdidFromSp utdid", string);
        return string;
    }

    public void a(String str, int i2) {
        if (this.f10212a != null) {
            f.m80a("PersistentConfiguration", "writeUtdidToSp utdid", str);
            SharedPreferences.Editor editorEdit = this.f10212a.edit();
            editorEdit.putString("UTDID2", str);
            editorEdit.putInt("type", i2);
            if (this.f10212a.getLong("t2", 0L) == 0) {
                editorEdit.putLong("t2", System.currentTimeMillis());
            }
            try {
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }
}
