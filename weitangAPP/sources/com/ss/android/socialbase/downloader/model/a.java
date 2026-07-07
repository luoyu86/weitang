package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10110a;
    private long bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10111h;
    private int j;
    private List<a> k;
    private long kf;
    private long n;
    private AtomicInteger p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f10112q;
    private a r;
    private AtomicBoolean rh;
    private AtomicLong s;
    private com.ss.android.socialbase.downloader.p.a t;
    private boolean z;
    private static final String ok = a.class.getSimpleName();
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.ss.android.socialbase.downloader.model.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    };

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f10113a;
        private long bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f10114h;
        private int kf;
        private long n;
        private int ok;
        private a p;
        private long s;

        public ok(int i2) {
            this.ok = i2;
        }

        public ok a(long j) {
            this.bl = j;
            return this;
        }

        public ok bl(long j) {
            this.s = j;
            return this;
        }

        public ok n(long j) {
            this.f10114h = j;
            return this;
        }

        public ok ok(long j) {
            this.f10113a = j;
            return this;
        }

        public ok s(long j) {
            this.n = j;
            return this;
        }

        public ok ok(int i2) {
            this.kf = i2;
            return this;
        }

        public ok ok(a aVar) {
            this.p = aVar;
            return this;
        }

        public a ok() {
            return new a(this);
        }
    }

    public int a() {
        AtomicInteger atomicInteger = this.p;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public boolean bl() {
        AtomicBoolean atomicBoolean = this.rh;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<a> h() {
        return this.k;
    }

    public long i() {
        return this.n;
    }

    public long j() {
        return this.bl;
    }

    public long k() {
        a aVar = this.r;
        if (aVar != null && aVar.h() != null) {
            int iIndexOf = this.r.h().indexOf(this);
            boolean z = false;
            for (int i2 = 0; i2 < this.r.h().size(); i2++) {
                a aVar2 = this.r.h().get(i2);
                if (aVar2 != null) {
                    if (z) {
                        return aVar2.rh();
                    }
                    if (iIndexOf == i2) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public boolean kf() {
        List<a> list = this.k;
        return list != null && list.size() > 0;
    }

    public a n() {
        a aVar = !s() ? this.r : this;
        if (aVar == null || !aVar.kf()) {
            return null;
        }
        return aVar.h().get(0);
    }

    public ContentValues ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f10110a));
        contentValues.put("chunkIndex", Integer.valueOf(this.f10111h));
        contentValues.put("startOffset", Long.valueOf(this.bl));
        contentValues.put("curOffset", Long.valueOf(rh()));
        contentValues.put("endOffset", Long.valueOf(this.n));
        contentValues.put("chunkContentLen", Long.valueOf(this.kf));
        contentValues.put("hostChunkIndex", Integer.valueOf(a()));
        return contentValues;
    }

    public boolean p() {
        a aVar = this.r;
        if (aVar == null) {
            return true;
        }
        if (!aVar.kf()) {
            return false;
        }
        for (int i2 = 0; i2 < this.r.h().size(); i2++) {
            a aVar2 = this.r.h().get(i2);
            if (aVar2 != null) {
                int iIndexOf = this.r.h().indexOf(this);
                if (iIndexOf > i2 && !aVar2.q()) {
                    return false;
                }
                if (iIndexOf == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean q() {
        long j = this.bl;
        if (s()) {
            long j2 = this.f10112q;
            if (j2 > this.bl) {
                j = j2;
            }
        }
        return rh() - j >= this.kf;
    }

    public int r() {
        return this.f10110a;
    }

    public long rh() {
        if (!s() || !kf()) {
            return z();
        }
        long jZ = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            a aVar = this.k.get(i2);
            if (aVar != null) {
                if (!aVar.q()) {
                    return aVar.z();
                }
                if (jZ < aVar.z()) {
                    jZ = aVar.z();
                }
            }
        }
        return jZ;
    }

    public boolean s() {
        return a() == -1;
    }

    public long t() {
        long jRh = rh() - this.bl;
        if (kf()) {
            jRh = 0;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                a aVar = this.k.get(i2);
                if (aVar != null) {
                    jRh += aVar.rh() - aVar.j();
                }
            }
        }
        return jRh;
    }

    public void td() {
        this.f10112q = rh();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10110a);
        parcel.writeLong(this.bl);
        AtomicLong atomicLong = this.s;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.n);
        parcel.writeLong(this.kf);
        parcel.writeInt(this.f10111h);
        AtomicInteger atomicInteger = this.p;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public long x() {
        return this.kf;
    }

    public long z() {
        AtomicLong atomicLong = this.s;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int zz() {
        return this.f10111h;
    }

    private a(ok okVar) {
        if (okVar == null) {
            return;
        }
        this.f10110a = okVar.ok;
        this.bl = okVar.f10113a;
        this.s = new AtomicLong(okVar.bl);
        this.n = okVar.s;
        this.kf = okVar.n;
        this.f10111h = okVar.kf;
        this.f10112q = okVar.f10114h;
        this.p = new AtomicInteger(-1);
        ok(okVar.p);
        this.rh = new AtomicBoolean(false);
    }

    public void a(boolean z) {
        this.z = z;
    }

    public void bl(int i2) {
        this.f10111h = i2;
    }

    public void a(int i2) {
        this.f10110a = i2;
    }

    public long bl(boolean z) {
        long jRh = rh();
        long j = this.kf;
        long j2 = this.f10112q;
        long j3 = j - (jRh - j2);
        if (!z && jRh == j2) {
            j3 = j - (jRh - this.bl);
        }
        com.ss.android.socialbase.downloader.bl.ok.a("DownloadChunk", "contentLength:" + this.kf + " curOffset:" + rh() + " oldOffset:" + this.f10112q + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void a(long j) {
        AtomicLong atomicLong = this.s;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.s = new AtomicLong(j);
        }
    }

    public void ok(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.j = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.j + 1;
        this.j = i2;
        sQLiteStatement.bindLong(i2, this.f10110a);
        int i3 = this.j + 1;
        this.j = i3;
        sQLiteStatement.bindLong(i3, this.f10111h);
        int i4 = this.j + 1;
        this.j = i4;
        sQLiteStatement.bindLong(i4, this.bl);
        int i5 = this.j + 1;
        this.j = i5;
        sQLiteStatement.bindLong(i5, rh());
        int i6 = this.j + 1;
        this.j = i6;
        sQLiteStatement.bindLong(i6, this.n);
        int i7 = this.j + 1;
        this.j = i7;
        sQLiteStatement.bindLong(i7, this.kf);
        int i8 = this.j + 1;
        this.j = i8;
        sQLiteStatement.bindLong(i8, a());
    }

    public a(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f10110a = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f10111h = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.bl = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.s = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.s = new AtomicLong(0L);
        }
        this.n = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.p = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.p = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.kf = cursor.getLong(columnIndex3);
        }
        this.rh = new AtomicBoolean(false);
    }

    public void ok(int i2) {
        AtomicInteger atomicInteger = this.p;
        if (atomicInteger == null) {
            this.p = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void ok(com.ss.android.socialbase.downloader.p.a aVar) {
        this.t = aVar;
        td();
    }

    public void ok(boolean z) {
        AtomicBoolean atomicBoolean = this.rh;
        if (atomicBoolean == null) {
            this.rh = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.t = null;
    }

    public a(Parcel parcel) {
        this.f10110a = parcel.readInt();
        this.bl = parcel.readLong();
        this.s = new AtomicLong(parcel.readLong());
        this.n = parcel.readLong();
        this.kf = parcel.readLong();
        this.f10111h = parcel.readInt();
        this.p = new AtomicInteger(parcel.readInt());
    }

    public void ok(a aVar) {
        this.r = aVar;
        if (aVar != null) {
            ok(aVar.zz());
        }
    }

    public void ok(List<a> list) {
        this.k = list;
    }

    public void ok(long j) {
        this.kf = j;
    }

    public List<a> ok(int i2, long j) {
        a aVar;
        long jI;
        long j2;
        long j3;
        long j4;
        long j5;
        a aVar2 = this;
        int i3 = i2;
        if (!s() || kf()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jZ = z();
        long jBl = aVar2.bl(true);
        long j6 = jBl / ((long) i3);
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "retainLen:" + jBl + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + aVar2.f10111h);
        int i4 = 0;
        while (i4 < i3) {
            if (i4 == 0) {
                j3 = j();
                j2 = (jZ + j6) - 1;
            } else {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    long jI2 = i();
                    j4 = jI2 > jZ ? (jI2 - jZ) + 1 : jBl - (((long) i5) * j6);
                    j5 = jI2;
                    j3 = jZ;
                    long j7 = jBl;
                    long j8 = j5;
                    a aVarOk = new ok(aVar2.f10110a).ok((-i4) - 1).ok(j3).a(jZ).n(jZ).bl(j8).s(j4).ok(aVar2).ok();
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + jZ + " endOffset:" + j8 + " contentLen:" + j4);
                    arrayList.add(aVarOk);
                    jZ += j6;
                    i4++;
                    aVar2 = this;
                    i3 = i2;
                    jBl = j7;
                } else {
                    j2 = (jZ + j6) - 1;
                    j3 = jZ;
                }
            }
            j4 = j6;
            j5 = j2;
            long j72 = jBl;
            long j82 = j5;
            a aVarOk2 = new ok(aVar2.f10110a).ok((-i4) - 1).ok(j3).a(jZ).n(jZ).bl(j82).s(j4).ok(aVar2).ok();
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + jZ + " endOffset:" + j82 + " contentLen:" + j4);
            arrayList.add(aVarOk2);
            jZ += j6;
            i4++;
            aVar2 = this;
            i3 = i2;
            jBl = j72;
        }
        long jX = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            a aVar3 = arrayList.get(size);
            if (aVar3 != null) {
                jX += aVar3.x();
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "reuseChunkContentLen:" + jX);
        a aVar4 = arrayList.get(0);
        if (aVar4 != null) {
            if (i() == 0) {
                jI = j - j();
            } else {
                jI = (i() - j()) + 1;
            }
            aVar4.ok(jI - jX);
            aVar = this;
            aVar4.bl(aVar.f10111h);
            com.ss.android.socialbase.downloader.p.a aVar5 = aVar.t;
            if (aVar5 != null) {
                aVar5.ok(aVar4.i(), x() - jX);
            }
        } else {
            aVar = this;
        }
        aVar.ok(arrayList);
        return arrayList;
    }
}
