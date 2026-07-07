package com.ss.android.socialbase.downloader.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.bl;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.kf.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class n extends bl.ok implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile SQLiteDatabase f9977a;
    private h bl;
    private volatile boolean kf;
    private h n;
    public a ok;
    private h s;

    public n() {
        this(false);
    }

    private void k() {
        try {
            if (f9977a == null || !f9977a.inTransaction()) {
                return;
            }
            f9977a.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f9977a == null) {
            synchronized (n.class) {
                if (f9977a == null) {
                    try {
                        f9977a = ok.ok().getWritableDatabase();
                        this.bl = new h(f9977a, "downloader", com.ss.android.socialbase.downloader.constants.bl.ok, com.ss.android.socialbase.downloader.constants.bl.f9991a);
                        this.s = new h(f9977a, "downloadChunk", com.ss.android.socialbase.downloader.constants.bl.bl, com.ss.android.socialbase.downloader.constants.bl.s);
                        this.n = new h(f9977a, "segments", com.ss.android.socialbase.downloader.constants.bl.n, com.ss.android.socialbase.downloader.constants.bl.kf);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private void q() {
        f9977a.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() {
        try {
            q();
            f9977a.delete("downloader", null, null);
            f9977a.delete("downloadChunk", null, null);
            f9977a.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    private void update(final int i2, final ContentValues contentValues) {
        p();
        if (f9977a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.ok(i2, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> a() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> a(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void a(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> bl(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo h(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public Map<Long, q> j(int i2) {
        Cursor cursorRawQuery;
        p();
        if (f9977a != null) {
            try {
                cursorRawQuery = f9977a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i2)});
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    int columnIndex = cursorRawQuery.getColumnIndex("info");
                    String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                    HashMap map = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        q qVar = new q(jSONArray.getJSONObject(i3));
                        map.put(Long.valueOf(qVar.bl()), qVar);
                    }
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                    return map;
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean kf(final int i2) {
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.11
            @Override // java.lang.Runnable
            public void run() {
                n.this.n(i2);
                n.this.s(i2);
                n.this.z(i2);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean n() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean n(int i2) {
        h hVar;
        p();
        if (f9977a != null && (hVar = this.bl) != null) {
            try {
                ok(i2, hVar.a());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> s(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void z(int i2) {
        p();
        if (f9977a == null) {
            return;
        }
        try {
            ok(i2, this.n.a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public n(boolean z) {
        this.ok = null;
        if (z) {
            this.kf = false;
            ok();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo a(int i2) {
        Cursor cursorRawQuery;
        p();
        if (f9977a != null) {
            try {
                cursorRawQuery = f9977a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i2)});
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                    return downloadInfo;
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<com.ss.android.socialbase.downloader.model.a> bl(int i2) {
        ArrayList arrayList = new ArrayList();
        p();
        if (f9977a != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = f9977a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i2)});
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.a(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo q(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void s(final int i2) {
        p();
        if (f9977a == null || this.s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i2, n.this.s.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo k(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i2, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!ok(downloadInfo.getId())) {
            bl(downloadInfo);
        } else {
            h hVar = this.bl;
            if (hVar == null) {
                return;
            }
            try {
                a(downloadInfo, hVar.bl());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo n(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public ArrayList<q> rh(int i2) {
        Map<Long, q> mapJ = j(i2);
        if (mapJ == null || mapJ.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapJ.values());
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo p(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
        ok(aVar);
    }

    private void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok() {
        ok(new SparseArray<>(), new SparseArray<>(), (s) null);
    }

    private void bl(final DownloadInfo downloadInfo) {
        p();
        if (f9977a == null || this.bl == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n nVar = n.this;
                    nVar.ok(downloadInfo, nVar.bl.ok());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void ok(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2, final s sVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.1
                /* JADX WARN: Removed duplicated region for block: B:170:0x034b A[PHI: r0
  0x034b: PHI (r0v14 com.ss.android.socialbase.downloader.a.s) = (r0v13 com.ss.android.socialbase.downloader.a.s), (r0v18 com.ss.android.socialbase.downloader.a.s) binds: [B:169:0x0349, B:164:0x0340] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:87:0x01b0 A[PHI: r0
  0x01b0: PHI (r0v30 com.ss.android.socialbase.downloader.a.s) = 
  (r0v27 com.ss.android.socialbase.downloader.a.s)
  (r0v29 com.ss.android.socialbase.downloader.a.s)
  (r0v41 com.ss.android.socialbase.downloader.a.s)
  (r0v43 com.ss.android.socialbase.downloader.a.s)
 binds: [B:128:0x0285, B:123:0x027b, B:86:0x01ae, B:81:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instruction units count: 887
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.a.n.AnonymousClass1.run():void");
                }
            };
            ExecutorService executorServiceTd = com.ss.android.socialbase.downloader.downloader.bl.td();
            if (executorServiceTd != null) {
                executorServiceTd.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo s(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void bl() {
        p();
        if (f9977a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.q.kf.a(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean s() {
        return this.kf;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo a(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo bl(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i2, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || f9977a == null) {
            return;
        }
        synchronized (f9977a) {
            try {
                try {
                    q();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                strArr[i2] = String.valueOf(list.get(i2));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            f9977a.delete("downloader", str, strArr);
                            f9977a.delete("downloadChunk", str, strArr);
                        } else {
                            String strJoin = TextUtils.join(", ", list2);
                            f9977a.delete("downloader", "_id IN (?)", new String[]{strJoin});
                            f9977a.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                        }
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        int iKeyAt = sparseArray.keyAt(i3);
                        DownloadInfo downloadInfo = sparseArray.get(iKeyAt);
                        f9977a.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                        f9977a.insert("downloader", null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            List<com.ss.android.socialbase.downloader.model.a> listBl = bl(iKeyAt);
                            if (listBl.size() > 0) {
                                f9977a.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                                for (com.ss.android.socialbase.downloader.model.a aVar : listBl) {
                                    aVar.a(downloadInfo.getId());
                                    f9977a.insert("downloadChunk", null, aVar.ok());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            int id = sparseArray2.valueAt(i4).getId();
                            List<com.ss.android.socialbase.downloader.model.a> listOk = com.ss.android.socialbase.downloader.q.kf.ok(bl(id));
                            if (listOk != null && listOk.size() > 0) {
                                sparseArray3.put(id, listOk);
                            }
                        }
                    }
                    f9977a.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            s(i2);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.a aVar : list) {
                    if (aVar != null) {
                        ok(aVar);
                        if (aVar.kf()) {
                            Iterator<com.ss.android.socialbase.downloader.model.a> it = aVar.h().iterator();
                            while (it.hasNext()) {
                                ok(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean ok(int i2) {
        try {
            return a(i2) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> ok(String str) {
        p();
        ArrayList arrayList = new ArrayList();
        if (f9977a != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = f9977a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", AgooConstants.OPEN_URL), new String[]{str});
                if (cursorRawQuery.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i2);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final com.ss.android.socialbase.downloader.model.a aVar) {
        p();
        if (f9977a == null || this.s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(aVar, n.this.s.ok());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(com.ss.android.socialbase.downloader.model.a aVar, SQLiteStatement sQLiteStatement) {
        if (aVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                aVar.ok(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final int i2, final int i3, final long j) {
        p();
        if (i2 == 0 || i3 < 0 || j < 0 || f9977a == null || this.s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i2, i3, j, n.this.s.bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final int i2, final int i3, final int i4, final long j) {
        p();
        if (i2 == 0 || i3 < 0 || i4 < 0 || j < 0 || f9977a == null || this.s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i2, i3, i4, j, n.this.s.bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final int i2, final int i3, final int i4, final int i5) {
        p();
        if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || f9977a == null || this.s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i2, i3, i4, i5, n.this.s.bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, int i4, int i5, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i5));
                f9977a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                f9977a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, int i4, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                f9977a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo ok(int i2, int i3) {
        p();
        if (f9977a == null) {
            return null;
        }
        int i4 = 10;
        while (f9977a.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i3));
        f9977a.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean ok(final DownloadInfo downloadInfo) {
        p();
        if (downloadInfo == null || f9977a == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.10
            @Override // java.lang.Runnable
            public void run() {
                n.this.s(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo ok(int i2, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo ok(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(int i2, Map<Long, q> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        p();
        if (f9977a == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).r());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement sQLiteStatementS = this.n.s();
        synchronized (sQLiteStatementS) {
            sQLiteStatementS.clearBindings();
            sQLiteStatementS.bindLong(1, i2);
            sQLiteStatementS.bindString(2, jSONArray.toString());
            sQLiteStatementS.execute();
        }
        com.ss.android.socialbase.downloader.bl.ok.a("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.q.kf.bl(jCurrentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, ContentValues contentValues) {
        int i3 = 10;
        while (f9977a.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            f9977a.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(a aVar) {
        this.ok = aVar;
    }

    public void ok(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2) {
        try {
            HashMap mapOk = com.ss.android.socialbase.downloader.q.kf.ok(sparseArray);
            HashMap mapOk2 = com.ss.android.socialbase.downloader.q.kf.ok(sparseArray2);
            a aVar = this.ok;
            if (aVar != null) {
                aVar.ok(mapOk, mapOk2);
            }
        } catch (Throwable unused) {
        }
    }
}
