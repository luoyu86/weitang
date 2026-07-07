package com.ss.android.socialbase.downloader.p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Handler.Callback {
    private volatile Handler ok = new Handler(ok.ok, this);

    public interface a {
        long ok();
    }

    public static class ok {
        private static final Looper ok;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            ok = handlerThread.getLooper();
        }
    }

    public static Looper ok() {
        return ok.ok;
    }

    public void a() {
        Handler handler = this.ok;
        if (handler == null) {
            return;
        }
        this.ok = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            a aVar = (a) message.obj;
            long jOk = aVar.ok();
            if (jOk <= 0) {
                return true;
            }
            ok(aVar, jOk);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void ok(a aVar, long j) {
        Handler handler = this.ok;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = aVar;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
