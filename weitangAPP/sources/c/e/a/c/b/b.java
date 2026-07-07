package c.e.a.c.b;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f1155a = Pattern.compile(",");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Vector<BarcodeFormat> f1156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Vector<BarcodeFormat> f1157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Vector<BarcodeFormat> f1158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Vector<BarcodeFormat> f1159e;

    static {
        Vector<BarcodeFormat> vector = new Vector<>(5);
        f1156b = vector;
        vector.add(BarcodeFormat.UPC_A);
        vector.add(BarcodeFormat.UPC_E);
        vector.add(BarcodeFormat.EAN_13);
        vector.add(BarcodeFormat.EAN_8);
        vector.add(BarcodeFormat.RSS_14);
        Vector<BarcodeFormat> vector2 = new Vector<>(vector.size() + 4);
        f1157c = vector2;
        vector2.addAll(vector);
        vector2.add(BarcodeFormat.CODE_39);
        vector2.add(BarcodeFormat.CODE_93);
        vector2.add(BarcodeFormat.CODE_128);
        vector2.add(BarcodeFormat.ITF);
        Vector<BarcodeFormat> vector3 = new Vector<>(1);
        f1158d = vector3;
        vector3.add(BarcodeFormat.QR_CODE);
        Vector<BarcodeFormat> vector4 = new Vector<>(1);
        f1159e = vector4;
        vector4.add(BarcodeFormat.DATA_MATRIX);
    }
}
