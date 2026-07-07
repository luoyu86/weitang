package com.tianmu.c.g.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tianmu.c.g.b;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f11585a;

    public a(Context context, int i2) {
        super(context, "com.tianmu.db", (SQLiteDatabase.CursorFactory) null, i2);
    }

    public static a a(Context context, int i2) {
        if (f11585a == null) {
            synchronized (a.class) {
                if (f11585a == null) {
                    f11585a = new a(context, i2);
                }
            }
        }
        return f11585a;
    }

    public SQLiteDatabase b() {
        b.a();
        return getReadableDatabase();
    }

    public SQLiteDatabase c() {
        b.a();
        return getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, com.tianmu.d.a.a.n());
        a(sQLiteDatabase, com.tianmu.c.g.d.a.o());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 != i3) {
            a(sQLiteDatabase, com.tianmu.d.a.a.o(), com.tianmu.d.a.a.n(), com.tianmu.c.g.d.a.p(), com.tianmu.c.g.d.a.o());
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            for (String str : strArr) {
                sQLiteDatabase.execSQL(str);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        b.a(this);
    }
}
