package c.e.a.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f1226a;

    static {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        f1226a = enumMap;
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
        arrayList.add(barcodeFormat);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
        enumMap.put(DecodeHintType.TRY_HARDER, barcodeFormat);
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        enumMap.put(DecodeHintType.CHARACTER_SET, "utf-8");
    }

    public static Bitmap a(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outHeight / 400;
            if (i3 > 0) {
                i2 = i3;
            }
            options.inSampleSize = i2;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Result[] analysisQRCodeOfMore(Bitmap bitmap) {
        QRCodeMultiReader qRCodeMultiReader = new QRCodeMultiReader();
        try {
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new c.e.a.c.b.g(bitmap)));
            Hashtable hashtable = new Hashtable();
            DecodeHintType decodeHintType = DecodeHintType.TRY_HARDER;
            Boolean bool = Boolean.TRUE;
            hashtable.put(decodeHintType, bool);
            hashtable.put(DecodeHintType.PURE_BARCODE, bool);
            hashtable.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
            return qRCodeMultiReader.decodeMultiple(binaryBitmap, hashtable);
        } catch (NotFoundException e2) {
            e2.printStackTrace();
            System.err.println("二维码识别中...");
            return null;
        }
    }

    public static String decodeQrToPath(String str) {
        return syncDecodeQR(a(str));
    }

    public static String syncDecodeImageView(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (!(drawable instanceof GlideBitmapDrawable)) {
            return null;
        }
        String strSyncDecodeQRCode = syncDecodeQRCode(((GlideBitmapDrawable) drawable).getBitmap());
        if (x.isNotNull(strSyncDecodeQRCode)) {
            return strSyncDecodeQRCode;
        }
        return null;
    }

    public static String syncDecodeQR(Bitmap bitmap) {
        c.e.a.c.b.g gVar;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            bitmap.getPixels(new int[width * height], 0, width, 0, 0, width, height);
            gVar = new c.e.a.c.b.g(bitmap);
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(gVar)), f1226a).getText();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (gVar != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(gVar)), f1226a).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            gVar = null;
        }
    }

    public static String syncDecodeQRCode(Bitmap bitmap) {
        c.e.a.c.b.g gVar;
        try {
            new QRCodeMultiReader();
            gVar = new c.e.a.c.b.g(bitmap);
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(gVar)), f1226a).getText();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (gVar != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(gVar)), f1226a).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            gVar = null;
        }
    }
}
