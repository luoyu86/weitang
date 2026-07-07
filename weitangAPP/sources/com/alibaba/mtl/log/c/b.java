package com.alibaba.mtl.log.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.mtl.log.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f4542a;
    public String ae = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    public String af = "SELECT count(*) FROM %s";
    public String ag = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";

    public class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SQLiteDatabase f4543a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AtomicInteger f4544e;

        public a(Context context) {
            super(context, "ut.db", (SQLiteDatabase.CursorFactory) null, 2);
            this.f4544e = new AtomicInteger();
        }

        public synchronized void a(SQLiteDatabase sQLiteDatabase) {
            SQLiteDatabase sQLiteDatabase2;
            if (sQLiteDatabase == null) {
                return;
            }
            try {
                if (this.f4544e.decrementAndGet() == 0 && (sQLiteDatabase2 = this.f4543a) != null) {
                    sQLiteDatabase2.close();
                    this.f4543a = null;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            try {
            } finally {
            }
            if (this.f4544e.incrementAndGet() == 1) {
                this.f4543a = super.getWritableDatabase();
            }
            return this.f4543a;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable unused) {
            }
            b.this.a(cursorRawQuery);
            super.onOpen(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 == 1 && i3 == 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    i.a("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }
    }

    public b(Context context) {
        this.f4542a = new a(context);
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized void c(String str, String str2) {
        a aVar;
        SQLiteDatabase writableDatabase = this.f4542a.getWritableDatabase();
        if (writableDatabase != null) {
            try {
                writableDatabase.delete("log", str + " < ?", new String[]{String.valueOf(str2)});
                aVar = this.f4542a;
            } catch (Throwable unused) {
                aVar = this.f4542a;
            }
            aVar.a(writableDatabase);
        } else {
            i.a("UTSqliteLogStore", "db is null");
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized void clear() {
        SQLiteDatabase writableDatabase = this.f4542a.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.f4542a.a(writableDatabase);
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public void e(int i2) {
        if (i2 <= 0) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f4542a.getWritableDatabase();
        if (writableDatabase == null) {
            i.a("UTSqliteLogStore", "db is null");
        } else {
            try {
                writableDatabase.execSQL(String.format(this.ag, Integer.valueOf(i2)));
            } catch (Throwable unused) {
            }
            this.f4542a.a(writableDatabase);
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized int g() {
        int i2;
        a aVar;
        SQLiteDatabase writableDatabase = this.f4542a.getWritableDatabase();
        i2 = 0;
        if (writableDatabase != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = writableDatabase.rawQuery(String.format(this.af, "log"), null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.moveToFirst();
                    i2 = cursorRawQuery.getInt(0);
                }
                a(cursorRawQuery);
                aVar = this.f4542a;
            } catch (Throwable unused) {
                a(cursorRawQuery);
                aVar = this.f4542a;
            }
            aVar.a(writableDatabase);
        } else {
            i.a("UTSqliteLogStore", "db is null");
        }
        return i2;
    }

    @Override // com.alibaba.mtl.log.c.a
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo27a(List<com.alibaba.mtl.log.model.a> list) {
        boolean z = true;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = null;
                boolean z2 = false;
                try {
                    writableDatabase = this.f4542a.getWritableDatabase();
                    if (writableDatabase != null) {
                        writableDatabase.beginTransaction();
                        int i2 = 0;
                        while (true) {
                            try {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                com.alibaba.mtl.log.model.a aVar = list.get(i2);
                                if (aVar != null) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("eventId", aVar.X);
                                    contentValues.put("priority", aVar.Y);
                                    contentValues.put("content", aVar.j());
                                    contentValues.put("time", aVar.aa);
                                    contentValues.put("_index", aVar.ab);
                                    long jInsert = writableDatabase.insert("log", "", contentValues);
                                    if (jInsert == -1) {
                                        z = false;
                                        break;
                                    }
                                    i.a("UTSqliteLogStore", "[insert] ", aVar.ab, " isSuccess:", Boolean.TRUE, "ret", Long.valueOf(jInsert));
                                }
                                i2++;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    i.a("UTSqliteLogStore", "insert error", th);
                                    com.alibaba.mtl.appmonitor.b.b.m23a(th);
                                    if (writableDatabase != null) {
                                        try {
                                            writableDatabase.setTransactionSuccessful();
                                        } catch (Throwable unused) {
                                        }
                                        try {
                                            writableDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    this.f4542a.a(writableDatabase);
                                    z2 = z;
                                } finally {
                                    if (writableDatabase != null) {
                                        try {
                                            writableDatabase.setTransactionSuccessful();
                                        } catch (Throwable unused3) {
                                        }
                                        try {
                                            writableDatabase.endTransaction();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                    this.f4542a.a(writableDatabase);
                                }
                            }
                        }
                        z2 = z;
                    } else {
                        i.a("UTSqliteLogStore", "db is null");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                return z2;
            }
        }
        return true;
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized int a(List<com.alibaba.mtl.log.model.a> list) {
        boolean z;
        int i2;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = this.f4542a.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.beginTransaction();
                        z = true;
                        i2 = 0;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            long jDelete = writableDatabase.delete("log", "_id=?", new String[]{list.get(i3).id + ""});
                            if (jDelete <= 0) {
                                i.a("UTSqliteLogStore", "[delete]  ", Integer.valueOf(list.get(i3).id), " ret:", Long.valueOf(jDelete));
                                z = false;
                            } else if (!"6005".equalsIgnoreCase(list.get(i3).X)) {
                                i2++;
                            }
                        }
                    } finally {
                        try {
                            writableDatabase.setTransactionSuccessful();
                        } catch (Throwable unused) {
                        }
                        try {
                            writableDatabase.endTransaction();
                        } catch (Throwable unused2) {
                        }
                        this.f4542a.a(writableDatabase);
                    }
                } else {
                    i.a("UTSqliteLogStore", "db is null");
                    z = false;
                    i2 = 0;
                }
                i.a("UTSqliteLogStore", "delete ", Integer.valueOf(list.size()), " isSuccess:", Boolean.valueOf(z));
                return i2;
            }
        }
        return 0;
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized ArrayList<com.alibaba.mtl.log.model.a> a(String str, int i2) {
        a aVar;
        ArrayList<com.alibaba.mtl.log.model.a> arrayList = null;
        Cursor cursorRawQuery = null;
        if (i2 <= 0) {
            return (ArrayList) Collections.EMPTY_LIST;
        }
        ArrayList<com.alibaba.mtl.log.model.a> arrayList2 = new ArrayList<>(i2);
        try {
            SQLiteDatabase writableDatabase = this.f4542a.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM ");
                sb.append("log");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" WHERE ");
                    sb.append(str);
                }
                sb.append(" ORDER BY ");
                sb.append("time");
                sb.append(" ASC ");
                sb.append(" LIMIT ");
                sb.append(i2 + "");
                String string = sb.toString();
                i.a("UTSqliteLogStore", "sql:" + string);
                try {
                    cursorRawQuery = writableDatabase.rawQuery(string, null);
                    while (cursorRawQuery != null) {
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        com.alibaba.mtl.log.model.a aVar2 = new com.alibaba.mtl.log.model.a();
                        i.a("UTSqliteLogStore", "pos", Integer.valueOf(cursorRawQuery.getPosition()), "count", Integer.valueOf(cursorRawQuery.getCount()));
                        aVar2.id = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("_id"));
                        aVar2.X = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("eventId"));
                        aVar2.Y = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("priority"));
                        aVar2.l(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("content")));
                        aVar2.aa = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("time"));
                        try {
                            aVar2.ab = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("_index"));
                        } catch (Throwable unused) {
                        }
                        arrayList2.add(aVar2);
                    }
                    a(cursorRawQuery);
                    aVar = this.f4542a;
                } catch (Throwable th) {
                    try {
                        i.a("UTSqliteLogStore", "[get]", th);
                        a(cursorRawQuery);
                        aVar = this.f4542a;
                    } catch (Throwable th2) {
                        a(cursorRawQuery);
                        this.f4542a.a(writableDatabase);
                        throw th2;
                    }
                }
                aVar.a(writableDatabase);
            } else {
                i.a("UTSqliteLogStore", "db is null");
            }
        } catch (Throwable unused2) {
            arrayList = arrayList2;
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }
}
