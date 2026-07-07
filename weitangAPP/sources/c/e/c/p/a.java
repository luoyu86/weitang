package c.e.c.p;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "wt.db", (SQLiteDatabase.CursorFactory) null, 5);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cache_table (cache_key varchar(40), cache_value varchar(2000))");
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS food_buy_cart_table (product_key varchar(20), spec_key varchar(20), price integer, count integer)");
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS lock_sort_table (phone varchar(11), lock_sort_key varchar(200))");
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pic_table (file_path varchar(200), pic_url varchar(200))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
        c(sQLiteDatabase);
        d(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 == 5) {
            a(sQLiteDatabase);
        }
    }
}
