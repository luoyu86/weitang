package c.e.e.a.t;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import c.e.e.a.x.i;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {
    public a(@Nullable Context context) {
        super(context, "wt_lock_record.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorRawQuery = null;
        boolean z = false;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info([" + str + "])", null);
                if (cursorRawQuery != null) {
                    while (true) {
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        if (cursorRawQuery.getColumnCount() >= 2 && str2.equals(cursorRawQuery.getString(1))) {
                            z = true;
                            break;
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (cursorRawQuery != null) {
                    if (!cursorRawQuery.isClosed()) {
                        cursorRawQuery.close();
                    }
                }
            }
            if (cursorRawQuery != null) {
                if (!cursorRawQuery.isClosed()) {
                    cursorRawQuery.close();
                }
            }
            return z;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    if (!cursorRawQuery.isClosed()) {
                        cursorRawQuery.close();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_lock_table (asset_name varchar(20) ,contract_key varchar(20) ,lock_type INTEGER ,soc_level_key INTEGER ,soc_level_name varchar(20) ,soc INTEGER ,assetConfirmStatus INTEGER ,asset_key varchar(20) )");
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_pwd_table (create_time varchar(20) ,asset_key varchar(20) ,room_pwd varchar(20) )");
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS logger_table (log_json_value varchar(200) ,phone varchar(11) )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        i.d(a.class.getSimpleName(), "onUpgrade onCreate ");
        d(sQLiteDatabase);
        b(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 < i3) {
            d(sQLiteDatabase);
            b(sQLiteDatabase);
            c(sQLiteDatabase);
        }
        i.d(a.class.getSimpleName(), "onUpgrade oldVersion = " + i2 + "， newVersion = " + i3);
        if (a(sQLiteDatabase, "room_pwd_table", "create_time")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE room_pwd_table ADD COLUMN create_time  varchar(20)");
        i.d(a.class.getSimpleName(), "onUpgrade ADD COLUMN CREATE_TIME_KEY");
    }

    public void update(SQLiteDatabase sQLiteDatabase) {
        i.d(a.class.getSimpleName(), "onUpgrade update ");
        if (sQLiteDatabase == null || a(sQLiteDatabase, "room_pwd_table", "create_time")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE room_pwd_table ADD COLUMN create_time  varchar(20)");
        i.d(a.class.getSimpleName(), "onUpgrade ADD COLUMN CREATE_TIME_KEY");
    }
}
