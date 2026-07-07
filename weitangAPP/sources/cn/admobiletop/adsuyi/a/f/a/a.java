package cn.admobiletop.adsuyi.a.f.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.admobiletop.adsuyi.a.f.b.b;
import cn.admobiletop.adsuyi.a.f.e;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f3231a;

    public a(Context context, int i2) {
        super(context, "cn.admobiletop.adsuyi", (SQLiteDatabase.CursorFactory) null, i2);
    }

    public static a a(Context context, int i2) {
        if (f3231a == null) {
            synchronized (a.class) {
                if (f3231a == null) {
                    f3231a = new a(context, i2);
                }
            }
        }
        return f3231a;
    }

    public SQLiteDatabase b() {
        e.a();
        return getReadableDatabase();
    }

    public SQLiteDatabase c() {
        e.a();
        return getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, cn.admobiletop.adsuyi.a.f.b.a.a(), b.a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 != i3) {
            b(sQLiteDatabase, cn.admobiletop.adsuyi.a.f.b.a.b(), cn.admobiletop.adsuyi.a.f.b.a.a(), b.b(), b.a());
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase, String... strArr) {
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
        e.a(this);
    }
}
