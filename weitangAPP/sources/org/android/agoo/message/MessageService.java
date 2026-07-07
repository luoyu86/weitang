package org.android.agoo.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f14975a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, Integer> f14976c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile SQLiteOpenHelper f14977b = null;

    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "emas_message_accs_db", (SQLiteDatabase.CursorFactory) null, 4);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN task_id TEXT");
            } catch (Throwable th) {
                ALog.e("MessageService", "insert task_id column fail ", th, new Object[0]);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
                return super.getWritableDatabase();
            }
            return null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("create table message(id text UNIQUE not null,state integer,body_code integer,report long,target_time long,interval integer,type text,message text,notify integer,create_time date,task_id text);");
                    sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                    sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                    sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
                } catch (Throwable th) {
                    ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            while (i2 < i3) {
                if (i2 == 3) {
                    a(sQLiteDatabase);
                } else {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                            try {
                                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                                sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
                            } catch (Throwable th) {
                                ALog.e("MessageService", "MessageService onUpgrade is error", th, new Object[0]);
                            }
                        } finally {
                            try {
                            } catch (Throwable th2) {
                            }
                        }
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                        sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
                    }
                }
                i2++;
            }
        }
    }

    private String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("&&");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public void a(Context context) {
        f14976c = new HashMap();
        f14975a = context;
        this.f14977b = new a(context);
    }

    public void deleteCacheMessage() {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.f14977b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            writableDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
            writableDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
        } catch (Throwable th) {
            try {
                ALog.e("MessageService", "deleteCacheMessage sql Throwable", th, new Object[0]);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        writableDatabase.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            writableDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    public void a(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + "]", new Object[0]);
        }
        SQLiteDatabase writableDatabase = null;
        try {
        } catch (Throwable th) {
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "updateAccsMessage error,e--->[" + th + "],ex=" + th.getStackTrace().toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(f14975a), "updateAccsMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            writableDatabase = this.f14977b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    return;
                } else {
                    return;
                }
            } else if (TextUtils.equals(str2, "1")) {
                writableDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
            } else {
                writableDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
            }
            writableDatabase.close();
        }
    }

    private MsgDO b(String str, String str2) {
        int i2;
        String str3;
        boolean z;
        String str4 = "ext";
        ALog.Level level = ALog.Level.I;
        if (ALog.isPrintLog(level)) {
            ALog.i("MessageService", "msgReceive,message--->[" + str + "],utdid=" + AdapterUtilityImpl.getDeviceId(f14975a), new Object[0]);
        }
        String str5 = null;
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", AdapterUtilityImpl.getDeviceId(f14975a), "message==null");
            if (ALog.isPrintLog(level)) {
                ALog.i("MessageService", "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(f14975a), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            new Bundle();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject == null) {
                    i2 = length;
                    str3 = str4;
                } else {
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString(OperatorName.SET_FLATNESS);
                    String string3 = jSONObject.getString(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);
                    String str6 = str5;
                    long j = jSONObject.getLong(OperatorName.FILL_NON_ZERO);
                    sb.append(string2);
                    String string4 = !jSONObject.isNull(str4) ? jSONObject.getString(str4) : str6;
                    int i4 = length - 1;
                    i2 = length;
                    if (i3 < i4) {
                        sb.append(",");
                    }
                    msgDO.msgIds = string2;
                    msgDO.extData = string4;
                    str3 = str4;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                    } else if (j == -1) {
                        msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                    } else if (!a(f14975a, string)) {
                        ALog.d("MessageService", "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", AdapterUtilityImpl.getDeviceId(f14975a), "deletePack", string);
                        sb3.append(string);
                        sb2.append(string2);
                        msgDO.removePacks = string;
                        if (i3 < i4) {
                            sb3.append(",");
                            sb2.append(",");
                        }
                    } else {
                        String string5 = a(j, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!f14975a.getPackageName().equals(string)) {
                            z = true;
                        } else if (TextUtils.equals(Integer.toString(0), string5) || TextUtils.equals(Integer.toString(4), string5)) {
                            z = false;
                        } else {
                            msgDO.errorCode = AgooConstants.ACK_PACK_ERROR;
                            ALog.e("MessageService", "error encrypted: " + string5, new Object[0]);
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                        str5 = string4;
                    }
                    str5 = string4;
                }
                i3++;
                length = i2;
                str4 = str3;
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("MessageService", "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    public void a(String str, String str2, String str3) {
        Cursor cursor;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                SQLiteDatabase writableDatabase = this.f14977b.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        writableDatabase.close();
                        return;
                    }
                    return;
                }
                try {
                    Cursor cursorRawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) > 0) {
                        cursorRawQuery.close();
                        cursorRawQuery.close();
                        writableDatabase.close();
                    } else {
                        writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        writableDatabase.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "addAccsMessage error,e--->[" + th + "],ex=" + a(th), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(f14975a), "addAccsMessageFailed", th.toString());
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private String a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void a(String str, String str2, String str3, int i2) {
        a(str, str2, str3, 1, -1L, -1, i2);
    }

    private void a(String str, String str2, String str3, int i2, long j, int i3, int i4) {
        Throwable th;
        int iHashCode;
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append("add sqlite3--->[");
        sb.append(str);
        sb.append("]");
        ALog.d("MessageService", sb.toString(), new Object[0]);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            String str5 = "";
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
                iHashCode = -1;
            } else {
                iHashCode = str2.hashCode();
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str5 = str3;
            }
            String strB = b(str);
            if (!TextUtils.isEmpty(strB)) {
                f14976c.put(strB, Integer.valueOf(iHashCode));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("MessageService", "addMessage,taskId=" + strB + ",messageStores＝" + f14976c.toString(), new Object[0]);
                }
            }
            try {
                SQLiteDatabase writableDatabase = this.f14977b.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                            return;
                        } catch (Throwable th2) {
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th2 + "]", new Object[0]);
                            }
                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(f14975a), "addMessageDBcloseFailed", th2.toString());
                            return;
                        }
                    }
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", str);
                    contentValues.put("state", Integer.valueOf(i2));
                    contentValues.put("body_code", Integer.valueOf(iHashCode));
                    contentValues.put(AgooConstants.MESSAGE_REPORT, (Integer) 0);
                    contentValues.put("target_time", Long.valueOf(j));
                    contentValues.put("interval", Integer.valueOf(i3));
                    contentValues.put("type", str5);
                    contentValues.put(Constants.SHARED_MESSAGE_ID_FILE, str4);
                    contentValues.put(AgooConstants.MESSAGE_NOTIFICATION, Integer.valueOf(i4));
                    contentValues.put("create_time", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()));
                    contentValues.put(AgooConstants.MESSAGE_TASK_ID, strB);
                    writableDatabase.insert(Constants.SHARED_MESSAGE_ID_FILE, null, contentValues);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.d("MessageService", "addMessage to db success", new Object[0]);
                    }
                    try {
                        writableDatabase.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(f14975a), "addMessageDBcloseFailed", th.toString());
                    }
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "addMessage error,e--->[" + th + "]", new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(f14975a), "addMessageFailed", th.toString());
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Throwable th5) {
                                th = th5;
                                if (ALog.isPrintLog(ALog.Level.E)) {
                                    ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                                }
                                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(f14975a), "addMessageDBcloseFailed", th.toString());
                            }
                        }
                    } finally {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0144 A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #4 {all -> 0x0187, blocks: (B:59:0x013c, B:61:0x0144), top: B:94:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0165 A[Catch: all -> 0x0161, TRY_LEAVE, TryCatch #0 {all -> 0x0161, blocks: (B:63:0x015d, B:67:0x0165), top: B:86:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<org.android.agoo.common.MsgDO> a() {
        /*
            Method dump skipped, instruction units count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a():java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r17) {
        /*
            r16 = this;
            java.lang.String r0 = "id"
            java.lang.String r1 = r16.b(r17)
            java.util.Map<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.f14976c
            boolean r2 = r2.containsKey(r1)
            java.lang.String r3 = "MessageService"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L31
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.E
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            if (r0 == 0) goto L30
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "hasMessageDuplicate,taskId="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.taobao.accs.utl.ALog.e(r3, r0, r1)
        L30:
            return r4
        L31:
            r2 = 0
            r6 = r16
            android.database.sqlite.SQLiteOpenHelper r7 = r6.f14977b     // Catch: java.lang.Throwable -> L7d
            android.database.sqlite.SQLiteDatabase r7 = r7.getReadableDatabase()     // Catch: java.lang.Throwable -> L7d
            if (r7 != 0) goto L42
            if (r7 == 0) goto L41
            r7.close()     // Catch: java.lang.Throwable -> L41
        L41:
            return r5
        L42:
            java.lang.String[] r10 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L7b
            java.lang.String r11 = "id = ? OR task_id = ?"
            r8 = 2
            java.lang.String[] r12 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L7b
            r12[r5] = r17     // Catch: java.lang.Throwable -> L7b
            r12[r4] = r1     // Catch: java.lang.Throwable -> L7b
            java.lang.String r9 = "message"
            r13 = 0
            r14 = 0
            r15 = 0
            r8 = r7
            android.database.Cursor r2 = r8.query(r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L70
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L70
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L7b
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7b
            if (r0 != 0) goto L70
            goto L71
        L70:
            r4 = 0
        L71:
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.lang.Throwable -> L79
        L76:
            r7.close()     // Catch: java.lang.Throwable -> L79
        L79:
            r5 = r4
            goto Lac
        L7b:
            r0 = move-exception
            goto L7f
        L7d:
            r0 = move-exception
            r7 = r2
        L7f:
            com.taobao.accs.utl.ALog$Level r1 = com.taobao.accs.utl.ALog.Level.E     // Catch: java.lang.Throwable -> Lad
            boolean r1 = com.taobao.accs.utl.ALog.isPrintLog(r1)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto La2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r1.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = "hasMessageDuplicate error,e--->["
            r1.append(r4)     // Catch: java.lang.Throwable -> Lad
            r1.append(r0)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = "]"
            r1.append(r0)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lad
            com.taobao.accs.utl.ALog.e(r3, r0, r1)     // Catch: java.lang.Throwable -> Lad
        La2:
            if (r2 == 0) goto La7
            r2.close()     // Catch: java.lang.Throwable -> Lac
        La7:
            if (r7 == 0) goto Lac
            r7.close()     // Catch: java.lang.Throwable -> Lac
        Lac:
            return r5
        Lad:
            r0 = move-exception
            if (r2 == 0) goto Lb3
            r2.close()     // Catch: java.lang.Throwable -> Lb8
        Lb3:
            if (r7 == 0) goto Lb8
            r7.close()     // Catch: java.lang.Throwable -> Lb8
        Lb8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String):boolean");
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static Bundle a(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }
}
