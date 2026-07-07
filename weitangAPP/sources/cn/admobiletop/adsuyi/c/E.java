package cn.admobiletop.adsuyi.c;

import android.net.NetworkInfo;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.S;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class E extends ThreadPoolExecutor {

    public static final class a extends FutureTask<RunnableC0329i> implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RunnableC0329i f4148a;

        public a(RunnableC0329i runnableC0329i) {
            super(runnableC0329i, null);
            this.f4148a = runnableC0329i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            A.e eVarS = this.f4148a.s();
            A.e eVarS2 = aVar.f4148a.s();
            return eVarS == eVarS2 ? this.f4148a.f4229e - aVar.f4148a.f4229e : eVarS2.ordinal() - eVarS.ordinal();
        }
    }

    public E() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new S.d());
    }

    public final void a(int i2) {
        setCorePoolSize(i2);
        setMaximumPoolSize(i2);
    }

    public void b(NetworkInfo networkInfo) {
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
        a aVar = new a((RunnableC0329i) runnable);
        execute(aVar);
        return aVar;
    }
}
