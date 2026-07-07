package c.e.a.c.b;

import android.os.Handler;
import android.os.Looper;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScanCodeActivity f1163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Hashtable<DecodeHintType, Object> f1164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f1165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f1166d = new CountDownLatch(1);

    public d(ScanCodeActivity scanCodeActivity, Vector<BarcodeFormat> vector, String str, ResultPointCallback resultPointCallback) {
        this.f1163a = scanCodeActivity;
        Hashtable<DecodeHintType, Object> hashtable = new Hashtable<>(3);
        this.f1164b = hashtable;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector<>();
            vector.addAll(b.f1157c);
            vector.addAll(b.f1158d);
            vector.addAll(b.f1159e);
        }
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            hashtable.put(DecodeHintType.CHARACTER_SET, str);
        }
        hashtable.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    public Handler a() {
        try {
            this.f1166d.await();
        } catch (InterruptedException unused) {
        }
        return this.f1165c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f1165c = new c(this.f1163a, this.f1164b);
        this.f1166d.countDown();
        Looper.loop();
    }
}
