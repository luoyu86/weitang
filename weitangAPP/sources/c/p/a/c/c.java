package c.p.a.c;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f3052a;

        public a(b bVar) {
            this.f3052a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = this.f3052a;
            if (bVar != null) {
                bVar.handleMessage(message);
            }
        }
    }

    public static Handler obtain() {
        return new a(null);
    }

    public static Handler obtain(b bVar) {
        return new a(bVar);
    }
}
