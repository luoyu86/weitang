package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.harmony.javax.imageio.stream.ImageInputStream;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageInputStream;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDMeshBasedShadingType extends PDShadingType4 {
    public PDMeshBasedShadingType(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.tom_roush.pdfbox.pdmodel.common.PDRange[]] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.tom_roush.pdfbox.pdmodel.common.PDRange[]] */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.tom_roush.pdfbox.pdmodel.graphics.shading.PDMeshBasedShadingType, com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading, com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShadingType4] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.tom_roush.harmony.javax.imageio.stream.ImageInputStream] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final List<Patch> collectPatches(AffineTransform affineTransform, Matrix matrix, int i2) throws Throwable {
        ?? r3;
        ArrayList arrayList;
        MemoryCacheImageInputStream memoryCacheImageInputStream;
        ArrayList arrayList2;
        MemoryCacheImageInputStream memoryCacheImageInputStream2;
        String str;
        Patch patch;
        byte bits;
        PointF[] flag1Edge;
        float[][] flag1Color;
        String str2 = "PdfBox-Android";
        COSDictionary cOSObject = getCOSObject();
        if (!(cOSObject instanceof COSStream)) {
            return Collections.emptyList();
        }
        PDRange decodeForParameter = getDecodeForParameter(0);
        PDRange decodeForParameter2 = getDecodeForParameter(1);
        if (Float.compare(decodeForParameter.getMin(), decodeForParameter.getMax()) == 0 || Float.compare(decodeForParameter2.getMin(), decodeForParameter2.getMax()) == 0) {
            return Collections.emptyList();
        }
        int bitsPerFlag = getBitsPerFlag();
        int numberOfColorComponents = getNumberOfColorComponents();
        ?? r10 = new PDRange[numberOfColorComponents];
        for (int i3 = 0; i3 < numberOfColorComponents; i3++) {
            r10[i3] = getDecodeForParameter(i3 + 2);
            r3 = r10[i3];
            if (r3 == 0) {
                throw new IOException("Range missing in shading /Decode entry");
            }
        }
        ArrayList arrayList3 = new ArrayList();
        long jPow = ((long) Math.pow(2.0d, getBitsPerCoordinate())) - 1;
        long jPow2 = ((long) Math.pow(2.0d, getBitsPerComponent())) - 1;
        MemoryCacheImageInputStream memoryCacheImageInputStream3 = new MemoryCacheImageInputStream(((COSStream) cOSObject).createInputStream());
        try {
            PointF[] pointFArr = new PointF[4];
            try {
                try {
                    float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, 2, numberOfColorComponents);
                    byte bits2 = (byte) (memoryCacheImageInputStream3.readBits(bitsPerFlag) & 3);
                    boolean z = false;
                    while (true) {
                        if (z) {
                            arrayList = arrayList3;
                            memoryCacheImageInputStream = memoryCacheImageInputStream3;
                            break;
                        }
                        PointF[] pointFArr2 = pointFArr;
                        PointF[] pointFArr3 = pointFArr;
                        ArrayList arrayList4 = arrayList3;
                        MemoryCacheImageInputStream memoryCacheImageInputStream4 = memoryCacheImageInputStream3;
                        ?? r30 = r10;
                        int i4 = bitsPerFlag;
                        String str3 = str2;
                        try {
                            try {
                                patch = readPatch(memoryCacheImageInputStream3, bits2 == 0, pointFArr2, fArr, jPow, jPow2, decodeForParameter, decodeForParameter2, r30, matrix, affineTransform, i2);
                            } catch (EOFException unused) {
                                arrayList2 = arrayList4;
                            }
                            if (patch == null) {
                                arrayList = arrayList4;
                                memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                break;
                            }
                            arrayList2 = arrayList4;
                            try {
                                arrayList2.add(patch);
                                memoryCacheImageInputStream2 = memoryCacheImageInputStream4;
                            } catch (EOFException unused2) {
                                memoryCacheImageInputStream2 = memoryCacheImageInputStream4;
                                str = str3;
                                bitsPerFlag = i4;
                                arrayList3 = arrayList2;
                                memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                                str2 = str;
                                pointFArr = pointFArr3;
                                r10 = r30;
                                z = true;
                            }
                            try {
                                bits = (byte) (memoryCacheImageInputStream2.readBits(i4) & 3);
                            } catch (EOFException unused3) {
                                str = str3;
                            }
                            if (bits != 0) {
                                if (bits == 1) {
                                    str = str3;
                                    flag1Edge = patch.getFlag1Edge();
                                    flag1Color = patch.getFlag1Color();
                                } else if (bits != 2) {
                                    if (bits != 3) {
                                        try {
                                            str = str3;
                                            try {
                                                Log.w(str, "bad flag: " + ((int) bits));
                                            } catch (EOFException unused4) {
                                                bits2 = bits;
                                                bitsPerFlag = i4;
                                                arrayList3 = arrayList2;
                                                memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                                                str2 = str;
                                                pointFArr = pointFArr3;
                                                r10 = r30;
                                                z = true;
                                            }
                                        } catch (EOFException unused5) {
                                            str = str3;
                                        }
                                    } else {
                                        str = str3;
                                        flag1Edge = patch.getFlag3Edge();
                                        try {
                                            flag1Color = patch.getFlag3Color();
                                        } catch (EOFException unused6) {
                                            bits2 = bits;
                                            pointFArr3 = flag1Edge;
                                            bitsPerFlag = i4;
                                            arrayList3 = arrayList2;
                                            memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                                            str2 = str;
                                            pointFArr = pointFArr3;
                                            r10 = r30;
                                            z = true;
                                        }
                                    }
                                    bitsPerFlag = i4;
                                    arrayList3 = arrayList2;
                                    memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                                    str2 = str;
                                    pointFArr = pointFArr3;
                                    r10 = r30;
                                    z = true;
                                } else {
                                    str = str3;
                                    flag1Edge = patch.getFlag2Edge();
                                    flag1Color = patch.getFlag2Color();
                                }
                                fArr = flag1Color;
                                bitsPerFlag = i4;
                                memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                                bits2 = bits;
                                str2 = str;
                                pointFArr = flag1Edge;
                                r10 = r30;
                                arrayList3 = arrayList2;
                            } else {
                                str = str3;
                            }
                            flag1Edge = pointFArr3;
                            bitsPerFlag = i4;
                            memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                            bits2 = bits;
                            str2 = str;
                            pointFArr = flag1Edge;
                            r10 = r30;
                            arrayList3 = arrayList2;
                        } catch (Throwable th) {
                            th = th;
                            r3 = memoryCacheImageInputStream4;
                            r3.close();
                            throw th;
                        }
                    }
                    memoryCacheImageInputStream.close();
                    return arrayList;
                } catch (EOFException e2) {
                    Log.e("PdfBox-Android", e2.getMessage(), e2);
                    memoryCacheImageInputStream3.close();
                    return arrayList3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            r3 = memoryCacheImageInputStream3;
        }
    }

    public abstract Patch generatePatch(PointF[] pointFArr, float[][] fArr);

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShadingType4, com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType, com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading
    public abstract RectF getBounds(AffineTransform affineTransform, Matrix matrix) throws IOException;

    public RectF getBounds(AffineTransform affineTransform, Matrix matrix, int i2) throws IOException {
        Iterator<Patch> it = collectPatches(affineTransform, matrix, i2).iterator();
        RectF rectF = null;
        while (it.hasNext()) {
            for (ShadedTriangle shadedTriangle : it.next().listOfTriangles) {
                if (rectF == null) {
                    PointF[] pointFArr = shadedTriangle.corner;
                    rectF = new RectF(pointFArr[0].x, pointFArr[0].y, 0.0f, 0.0f);
                }
                PointF[] pointFArr2 = shadedTriangle.corner;
                rectF.union(pointFArr2[0].x, pointFArr2[0].y);
                PointF[] pointFArr3 = shadedTriangle.corner;
                rectF.union(pointFArr3[1].x, pointFArr3[1].y);
                PointF[] pointFArr4 = shadedTriangle.corner;
                rectF.union(pointFArr4[2].x, pointFArr4[2].y);
            }
        }
        return rectF;
    }

    public Patch readPatch(ImageInputStream imageInputStream, boolean z, PointF[] pointFArr, float[][] fArr, long j, long j2, PDRange pDRange, PDRange pDRange2, PDRange[] pDRangeArr, Matrix matrix, AffineTransform affineTransform, int i2) throws IOException {
        int i3;
        int numberOfColorComponents = getNumberOfColorComponents();
        int i4 = 2;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) float.class, 4, numberOfColorComponents);
        PointF[] pointFArr2 = new PointF[i2];
        if (z) {
            i4 = 0;
            i3 = 0;
        } else {
            pointFArr2[0] = pointFArr[0];
            pointFArr2[1] = pointFArr[1];
            pointFArr2[2] = pointFArr[2];
            pointFArr2[3] = pointFArr[3];
            for (int i5 = 0; i5 < numberOfColorComponents; i5++) {
                fArr2[0][i5] = fArr[0][i5];
                fArr2[1][i5] = fArr[1][i5];
            }
            i3 = 4;
        }
        while (i3 < i2) {
            try {
                PointF pointFTransformPoint = matrix.transformPoint(interpolate(imageInputStream.readBits(getBitsPerCoordinate()), j, pDRange.getMin(), pDRange.getMax()), interpolate(imageInputStream.readBits(getBitsPerCoordinate()), j, pDRange2.getMin(), pDRange2.getMax()));
                affineTransform.transform(pointFTransformPoint, pointFTransformPoint);
                pointFArr2[i3] = pointFTransformPoint;
                i3++;
            } catch (EOFException e2) {
                Log.d("PdfBox-Android", "EOF", e2);
                return null;
            }
        }
        while (i4 < 4) {
            for (int i6 = 0; i6 < numberOfColorComponents; i6++) {
                fArr2[i4][i6] = interpolate(imageInputStream.readBits(getBitsPerComponent()), j2, pDRangeArr[i6].getMin(), pDRangeArr[i6].getMax());
            }
            i4++;
        }
        return generatePatch(pointFArr2, fArr2);
    }
}
