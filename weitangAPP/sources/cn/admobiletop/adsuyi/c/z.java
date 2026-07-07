package cn.admobiletop.adsuyi.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class z extends Handler {
    public z(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 3) {
            AbstractC0321a abstractC0321a = (AbstractC0321a) message.obj;
            if (abstractC0321a.f().p) {
                S.p("Main", "canceled", abstractC0321a.f4209b.d(), "target got garbage collected");
            }
            abstractC0321a.f4208a.i(abstractC0321a.j());
            return;
        }
        int i3 = 0;
        if (i2 == 8) {
            List list = (List) message.obj;
            int size = list.size();
            while (i3 < size) {
                RunnableC0329i runnableC0329i = (RunnableC0329i) list.get(i3);
                runnableC0329i.f4230f.h(runnableC0329i);
                i3++;
            }
            return;
        }
        if (i2 != 13) {
            throw new AssertionError("Unknown handler message received: " + message.what);
        }
        List list2 = (List) message.obj;
        int size2 = list2.size();
        while (i3 < size2) {
            AbstractC0321a abstractC0321a2 = (AbstractC0321a) list2.get(i3);
            abstractC0321a2.f4208a.k(abstractC0321a2);
            i3++;
        }
    }
}
