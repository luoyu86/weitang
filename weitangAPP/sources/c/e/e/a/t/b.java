package c.e.e.a.t;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.e.a.s.e;
import c.e.e.a.s.f;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f2470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SQLiteDatabase f2471b;

    public b() {
        a aVar = new a(c.e.a.a.b.getInstance().getContext());
        SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
        this.f2471b = writableDatabase;
        aVar.update(writableDatabase);
    }

    public static b getInstance() {
        if (f2470a == null) {
            synchronized (b.class) {
                if (f2470a == null) {
                    f2470a = new b();
                }
            }
        }
        return f2470a;
    }

    public final int a(Integer num) {
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final String[] b() {
        return new String[]{"asset_key", "asset_name", "lock_type", "contract_key", "soc_level_key", "soc_level_name", "assetConfirmStatus", "soc"};
    }

    public synchronized void clearTableData() {
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                this.f2471b.delete("logger_table", null, null);
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
    }

    public synchronized void closeDb() {
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        f2470a = null;
    }

    public synchronized boolean delPwd(String str) {
        boolean z;
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                z = ((long) this.f2471b.delete("room_pwd_table", "asset_key = ?", new String[]{str})) > 0;
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized boolean delRoomPwd() {
        boolean z;
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                z = this.f2471b.delete("room_pwd_table", null, null) > 0;
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized boolean deleteRoomLock() {
        boolean z;
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                z = this.f2471b.delete("room_lock_table", null, null) > 0;
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized List<f> getAllOpenLog(String str) {
        ArrayList arrayList;
        arrayList = null;
        if (this.f2471b != null && x.isNotNull(str)) {
            this.f2471b.beginTransaction();
            try {
                Cursor cursorQuery = this.f2471b.query("logger_table", new String[]{"log_json_value"}, "phone = ? ", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        if (x.isNotNull(string)) {
                            try {
                                arrayList.add((f) JSON.parseObject(string, f.class));
                            } catch (Exception e2) {
                                q.d(getClass().getSimpleName(), "json = " + string);
                                e2.printStackTrace();
                            }
                        }
                    }
                    cursorQuery.close();
                }
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return arrayList;
    }

    public synchronized Map<String, ResponseOpenDoorVo> getCachePwd() {
        HashMap map;
        map = null;
        if (this.f2471b != null) {
            map = new HashMap();
            Cursor cursorQuery = this.f2471b.query("room_pwd_table", new String[]{"room_pwd", "asset_key"}, null, null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("asset_key"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("room_pwd"));
                    if (string != null && string2 != null) {
                        try {
                            map.put(string, (ResponseOpenDoorVo) JSON.parseObject(string2, ResponseOpenDoorVo.class));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                cursorQuery.close();
            }
        }
        return map;
    }

    public synchronized String getCacheTimeToAssetKey(String str) {
        String string;
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null && str != null && (cursorQuery = sQLiteDatabase.query("room_pwd_table", new String[]{"create_time"}, "asset_key = ? ", new String[]{str}, null, null, null)) != null) {
            try {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("create_time")) : null;
                cursorQuery.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return string;
    }

    public synchronized String getPwdToAssetKey(String str) {
        Cursor cursorQuery;
        String string = null;
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null && str != null && (cursorQuery = sQLiteDatabase.query("room_pwd_table", new String[]{"room_pwd"}, "asset_key = ? ", new String[]{str}, null, null, null)) != null) {
            if (cursorQuery.moveToNext() && (string = cursorQuery.getString(cursorQuery.getColumnIndex("room_pwd"))) != null) {
                try {
                    if (string.length() > 3 && string.indexOf("VT") == 0) {
                        String strSubstring = string.substring(2);
                        if (strSubstring.length() > 4) {
                            return new String(Base64.decode(strSubstring.substring(0, strSubstring.length() - 2), 0));
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            cursorQuery.close();
        }
        return string;
    }

    public synchronized List<e> getRoomList() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f2471b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                Cursor cursorQuery = this.f2471b.query("room_lock_table", b(), null, null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("asset_key"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("asset_name"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("contract_key"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("soc_level_name"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("soc"));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("assetConfirmStatus"));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("lock_type"));
                        int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("soc_level_key"));
                        e eVar = new e();
                        eVar.setSocLevelName(string4);
                        if (i5 != -1) {
                            eVar.setSocLevel(Integer.valueOf(i5));
                        }
                        if (i2 != -1) {
                            eVar.setSoc(Integer.valueOf(i2));
                        }
                        if (i4 != -1) {
                            eVar.setLockType(Integer.valueOf(i4));
                        }
                        boolean z = true;
                        if (i3 != 1) {
                            z = false;
                        }
                        eVar.setAssetConfirmStatus(z);
                        eVar.setAssetInstanceKey(string);
                        eVar.setContractKey(string3);
                        eVar.setAssetInstanceName(string2);
                        arrayList.add(eVar);
                    }
                    cursorQuery.close();
                    this.f2471b.setTransactionSuccessful();
                }
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return arrayList;
    }

    public synchronized void insertOpenLog(f fVar, String str) {
        if (this.f2471b != null && fVar != null && x.isNotNull(str)) {
            this.f2471b.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_json_value", JSON.toJSONString(fVar));
                contentValues.put(NewLoginBo.SMS_LOGIN_NAME, str);
                long jInsert = this.f2471b.insert("logger_table", null, contentValues);
                q.d(getClass().getSimpleName(), "insert open log :" + str + ", result :" + jInsert);
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
    }

    public synchronized boolean insertPwd(String str, String str2) {
        boolean z;
        if (this.f2471b != null && str != null && str2 != null) {
            delPwd(str);
            this.f2471b.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("asset_key", str);
                contentValues.put("create_time", String.valueOf(System.currentTimeMillis()));
                contentValues.put("room_pwd", "VT" + str2 + "VT");
                z = this.f2471b.insert("room_pwd_table", null, contentValues) > 0;
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized boolean insertRoomList(List<e> list) {
        if (this.f2471b != null && list != null && !list.isEmpty()) {
            try {
                deleteRoomLock();
                this.f2471b.beginTransaction();
                for (e eVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("asset_key", eVar.getAssetInstanceKey());
                    contentValues.put("asset_name", eVar.getAssetInstanceName());
                    contentValues.put("lock_type", Integer.valueOf(a(eVar.getLockType())));
                    contentValues.put("contract_key", eVar.getContractKey());
                    contentValues.put("soc_level_key", Integer.valueOf(a(eVar.getSocLevel())));
                    contentValues.put("soc_level_name", eVar.getSocLevelName());
                    contentValues.put("soc", Integer.valueOf(a(eVar.getSoc())));
                    contentValues.put("assetConfirmStatus", Boolean.valueOf(eVar.isAssetConfirmStatus()));
                    this.f2471b.insert("room_lock_table", null, contentValues);
                }
                this.f2471b.setTransactionSuccessful();
                this.f2471b.endTransaction();
            } catch (Throwable th) {
                this.f2471b.endTransaction();
                throw th;
            }
        }
        return false;
    }
}
