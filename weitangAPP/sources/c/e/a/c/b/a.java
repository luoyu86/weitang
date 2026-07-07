package c.e.a.c.b;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.chinavisionary.core.R;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1150a = a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScanCodeActivity f1151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f1152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EnumC0023a f1153d;

    /* JADX INFO: renamed from: c.e.a.c.b.a$a, reason: collision with other inner class name */
    public enum EnumC0023a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public a(ScanCodeActivity scanCodeActivity, Vector<BarcodeFormat> vector, String str) {
        this.f1151b = scanCodeActivity;
        d dVar = new d(scanCodeActivity, vector, str, new c.e.a.c.c.b(scanCodeActivity.getViewfinderView()));
        this.f1152c = dVar;
        dVar.start();
        this.f1153d = EnumC0023a.SUCCESS;
        c.e.a.c.a.c.get().startPreview();
        restartPreviewAndDecode();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        int i3 = R.id.auto_focus;
        if (i2 == i3) {
            if (this.f1153d == EnumC0023a.PREVIEW) {
                c.e.a.c.a.c.get().requestAutoFocus(this, i3);
                return;
            }
            return;
        }
        if (i2 == R.id.restart_preview) {
            Log.d(f1150a, "Got restart preview message");
            restartPreviewAndDecode();
            return;
        }
        if (i2 == R.id.decode_succeeded) {
            Log.d(f1150a, "Got decode succeeded message");
            this.f1153d = EnumC0023a.SUCCESS;
            Bundle data = message.getData();
            this.f1151b.handleDecode((Result) message.obj, data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap"));
            return;
        }
        if (i2 == R.id.decode_failed) {
            this.f1153d = EnumC0023a.PREVIEW;
            c.e.a.c.a.c.get().requestPreviewFrame(this.f1152c.a(), R.id.decode);
            return;
        }
        if (i2 == R.id.return_scan_result) {
            Log.d(f1150a, "Got return scan result message");
            this.f1151b.setResult(-1, (Intent) message.obj);
            this.f1151b.finish();
        } else if (i2 == R.id.launch_product_query) {
            Log.d(f1150a, "Got product query message");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
            intent.addFlags(524288);
            this.f1151b.startActivity(intent);
        }
    }

    public void quitSynchronously() {
        this.f1153d = EnumC0023a.DONE;
        c.e.a.c.a.c.get().stopPreview();
        Message.obtain(this.f1152c.a(), R.id.quit).sendToTarget();
        try {
            this.f1152c.join();
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    public void resetCamera() {
        this.f1153d = EnumC0023a.SUCCESS;
        c.e.a.c.a.c.get().startPreview();
    }

    public void restartPreviewAndDecode() {
        if (this.f1153d == EnumC0023a.SUCCESS) {
            this.f1153d = EnumC0023a.PREVIEW;
            c.e.a.c.a.c.get().requestPreviewFrame(this.f1152c.a(), R.id.decode);
            c.e.a.c.a.c.get().requestAutoFocus(this, R.id.auto_focus);
            this.f1151b.drawViewfinder();
        }
    }
}
