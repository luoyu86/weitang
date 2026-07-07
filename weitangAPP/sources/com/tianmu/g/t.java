package com.tianmu.g;

import android.net.NetworkInfo;
import com.tianmu.g.f0;
import com.tianmu.g.r;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class t extends ThreadPoolExecutor {

    public static final class a extends FutureTask<c> implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f12152a;

        public a(c cVar) {
            super(cVar, null);
            this.f12152a = cVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            r.f fVarJ = this.f12152a.j();
            r.f fVarJ2 = aVar.f12152a.j();
            return fVarJ == fVarJ2 ? this.f12152a.f12044a - aVar.f12152a.f12044a : fVarJ2.ordinal() - fVarJ.ordinal();
        }
    }

    public t() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new f0.e());
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            a(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type == 1 || type == 6 || type == 9) {
                a(4);
                return;
            } else {
                a(3);
                return;
            }
        }
        int subtype = networkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                a(1);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                switch (subtype) {
                    case 12:
                        break;
                    case 13:
                    case 14:
                    case 15:
                        a(3);
                        break;
                    default:
                        a(3);
                        break;
                }
        }
        a(2);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }

    private void a(int i2) {
        setCorePoolSize(i2);
        setMaximumPoolSize(i2);
    }
}
