package c.e.a.c.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.chinavisionary.core.R;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1160a = c.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScanCodeActivity f1161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MultiFormatReader f1162c;

    public c(ScanCodeActivity scanCodeActivity, Hashtable<DecodeHintType, Object> hashtable) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f1162c = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.f1161b = scanCodeActivity;
    }

    public final void a(byte[] bArr, int i2, int i3) {
        Result resultDecodeWithState;
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        c.e.a.c.a.e eVarBuildLuminanceSource = c.e.a.c.a.c.get().buildLuminanceSource(bArr2, i3, i2);
        try {
            resultDecodeWithState = this.f1162c.decodeWithState(new BinaryBitmap(new HybridBinarizer(eVarBuildLuminanceSource)));
            this.f1162c.reset();
        } catch (ReaderException unused) {
            this.f1162c.reset();
            resultDecodeWithState = null;
        } catch (Throwable th) {
            this.f1162c.reset();
            throw th;
        }
        if (resultDecodeWithState == null) {
            Message.obtain(this.f1161b.getHandler(), R.id.decode_failed).sendToTarget();
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Log.d(f1160a, "Found barcode (" + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms):\n" + resultDecodeWithState.toString());
        Message messageObtain = Message.obtain(this.f1161b.getHandler(), R.id.decode_succeeded, resultDecodeWithState);
        Bundle bundle = new Bundle();
        bundle.putParcelable("barcode_bitmap", eVarBuildLuminanceSource.renderCroppedGreyscaleBitmap());
        messageObtain.setData(bundle);
        messageObtain.sendToTarget();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == R.id.decode) {
            a((byte[]) message.obj, message.arg1, message.arg2);
        } else if (i2 == R.id.quit) {
            Looper.myLooper().quit();
        }
    }
}
