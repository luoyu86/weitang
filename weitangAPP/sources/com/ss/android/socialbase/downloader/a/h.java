package com.ss.android.socialbase.downloader.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.q.q;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9970a;
    private final String[] bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SQLiteStatement f9971h;
    private SQLiteStatement kf;
    private SQLiteStatement n;
    private final SQLiteDatabase ok;
    private SQLiteStatement p;
    private final String[] s;

    public h(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.ok = sQLiteDatabase;
        this.f9970a = str;
        this.bl = strArr;
        this.s = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f9971h == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.ok.compileStatement(q.ok(this.f9970a, this.s));
            synchronized (this) {
                if (this.f9971h == null) {
                    this.f9971h = sQLiteStatementCompileStatement;
                }
            }
            if (this.f9971h != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.f9971h;
    }

    public SQLiteStatement bl() {
        if (this.kf == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.ok.compileStatement(q.ok(this.f9970a, this.bl, this.s));
            synchronized (this) {
                if (this.kf == null) {
                    this.kf = sQLiteStatementCompileStatement;
                }
            }
            if (this.kf != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.kf;
    }

    public SQLiteStatement ok() {
        if (this.n == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.ok.compileStatement(q.ok("INSERT INTO ", this.f9970a, this.bl));
            synchronized (this) {
                if (this.n == null) {
                    this.n = sQLiteStatementCompileStatement;
                }
            }
            if (this.n != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.n;
    }

    public SQLiteStatement s() {
        if (this.p == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.ok.compileStatement(q.a(this.f9970a, this.bl, this.s));
            synchronized (this) {
                if (this.p == null) {
                    this.p = sQLiteStatementCompileStatement;
                }
            }
            if (this.p != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.p;
    }
}
