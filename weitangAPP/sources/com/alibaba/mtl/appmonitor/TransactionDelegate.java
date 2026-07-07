package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.d.i;

/* JADX INFO: loaded from: classes.dex */
public class TransactionDelegate {
    private static void a(Transaction transaction) {
        if (transaction == null || transaction.f4463b == null) {
            return;
        }
        e.a().a(transaction.r, transaction.f4462a, transaction.o, transaction.p, DimensionValueSet.create().addValues(transaction.f4463b));
    }

    public static void begin(Transaction transaction, String str) {
        try {
            if (AppMonitorDelegate.f4457i && transaction != null) {
                i.a("TransactionDelegate", "statEvent begin. module: ", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                f fVar = f.STAT;
                if (!fVar.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(fVar, transaction.o, transaction.p))) {
                    i.a("TransactionDelegate", "log discard", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                } else {
                    e.a().a(transaction.r, transaction.f4462a, transaction.o, transaction.p, str);
                    a(transaction);
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m23a(th);
        }
    }

    public static void end(Transaction transaction, String str) {
        try {
            if (AppMonitorDelegate.f4457i && transaction != null) {
                i.a("TransactionDelegate", "statEvent end. module: ", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                f fVar = f.STAT;
                if (!fVar.isOpen() || (!AppMonitorDelegate.IS_DEBUG && !j.a(fVar, transaction.o, transaction.p))) {
                    i.a("TransactionDelegate", "log discard", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                } else {
                    a(transaction);
                    e.a().a(transaction.r, str, false, transaction.f4464e);
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m23a(th);
        }
    }
}
