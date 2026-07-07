package com.ss.android.downloadlib.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class z extends Handler {
    public WeakReference<ok> ok;

    public interface ok {
        void ok(Message message);
    }

    public z(Looper looper, ok okVar) {
        super(looper);
        this.ok = new WeakReference<>(okVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ok okVar = this.ok.get();
        if (okVar == null || message == null) {
            return;
        }
        okVar.ok(message);
    }
}
