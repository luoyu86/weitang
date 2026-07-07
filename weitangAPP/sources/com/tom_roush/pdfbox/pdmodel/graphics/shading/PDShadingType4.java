package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageInputStream;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDShadingType4 extends PDTriangleBasedShadingType {
    public PDShadingType4(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public List<ShadedTriangle> collectTriangles(AffineTransform affineTransform, Matrix matrix) throws Throwable {
        byte bits;
        MemoryCacheImageInputStream memoryCacheImageInputStream;
        PDRange[] pDRangeArr;
        ArrayList arrayList;
        PointF[] pointFArr;
        float[][] fArr;
        char c2;
        PointF pointF;
        char c3;
        float[] fArr2;
        int bitsPerFlag = getBitsPerFlag();
        COSDictionary cOSObject = getCOSObject();
        if (!(cOSObject instanceof COSStream)) {
            return Collections.emptyList();
        }
        PDRange decodeForParameter = getDecodeForParameter(0);
        byte b2 = 1;
        PDRange decodeForParameter2 = getDecodeForParameter(1);
        if (Float.compare(decodeForParameter.getMin(), decodeForParameter.getMax()) == 0 || Float.compare(decodeForParameter2.getMin(), decodeForParameter2.getMax()) == 0) {
            return Collections.emptyList();
        }
        int numberOfColorComponents = getNumberOfColorComponents();
        PDRange[] pDRangeArr2 = new PDRange[numberOfColorComponents];
        for (int i2 = 0; i2 < numberOfColorComponents; i2++) {
            pDRangeArr2[i2] = getDecodeForParameter(i2 + 2);
        }
        ArrayList arrayList2 = new ArrayList();
        long jPow = ((long) Math.pow(2.0d, getBitsPerCoordinate())) - 1;
        long jPow2 = ((long) Math.pow(2.0d, getBitsPerComponent())) - 1;
        MemoryCacheImageInputStream memoryCacheImageInputStream2 = new MemoryCacheImageInputStream(((COSStream) cOSObject).createInputStream());
        try {
            try {
                bits = (byte) (memoryCacheImageInputStream2.readBits(bitsPerFlag) & 3);
            } catch (EOFException e2) {
                Log.e("PdfBox-Android", e2.getMessage(), e2);
                bits = 0;
            }
            boolean z = false;
            while (!z) {
                if (bits == 0) {
                    ArrayList arrayList3 = arrayList2;
                    pDRangeArr = pDRangeArr2;
                    MemoryCacheImageInputStream memoryCacheImageInputStream3 = memoryCacheImageInputStream2;
                    memoryCacheImageInputStream = memoryCacheImageInputStream3;
                    try {
                        try {
                            Vertex vertex = readVertex(memoryCacheImageInputStream3, jPow, jPow2, decodeForParameter, decodeForParameter2, pDRangeArr, matrix, affineTransform);
                            bits = (byte) (memoryCacheImageInputStream.readBits(bitsPerFlag) & 3);
                            if (bits != 0) {
                                Log.e("PdfBox-Android", "bad triangle: " + ((int) bits));
                            }
                            try {
                                Vertex vertex2 = readVertex(memoryCacheImageInputStream, jPow, jPow2, decodeForParameter, decodeForParameter2, pDRangeArr, matrix, affineTransform);
                                memoryCacheImageInputStream.readBits(bitsPerFlag);
                                if (bits != 0) {
                                    Log.e("PdfBox-Android", "bad triangle: " + ((int) bits));
                                }
                                Vertex vertex3 = readVertex(memoryCacheImageInputStream, jPow, jPow2, decodeForParameter, decodeForParameter2, pDRangeArr, matrix, affineTransform);
                                pointFArr = new PointF[3];
                                try {
                                    pointFArr[0] = vertex.point;
                                    pointFArr[1] = vertex2.point;
                                    pointFArr[2] = vertex3.point;
                                    fArr = new float[3][];
                                    fArr[0] = vertex.color;
                                    fArr[1] = vertex2.color;
                                    fArr[2] = vertex3.color;
                                    arrayList = arrayList3;
                                } catch (EOFException unused) {
                                    arrayList = arrayList3;
                                }
                            } catch (EOFException unused2) {
                                arrayList = arrayList3;
                                arrayList2 = arrayList;
                                memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                                pDRangeArr2 = pDRangeArr;
                                b2 = 1;
                                z = true;
                            }
                        } catch (EOFException unused3) {
                            arrayList = arrayList3;
                        }
                        try {
                            arrayList.add(new ShadedTriangle(pointFArr, fArr));
                            bits = (byte) (memoryCacheImageInputStream.readBits(bitsPerFlag) & 3);
                            arrayList2 = arrayList;
                            memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                            pDRangeArr2 = pDRangeArr;
                            b2 = 1;
                        } catch (EOFException unused4) {
                            arrayList2 = arrayList;
                            memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                            pDRangeArr2 = pDRangeArr;
                            b2 = 1;
                            z = true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        memoryCacheImageInputStream.close();
                        throw th;
                    }
                } else if (bits == b2 || bits == 2) {
                    try {
                        int size = arrayList2.size() - b2;
                        if (size < 0) {
                            Log.e("PdfBox-Android", "broken data stream: " + arrayList2.size());
                            memoryCacheImageInputStream = memoryCacheImageInputStream2;
                            arrayList = arrayList2;
                            pDRangeArr = pDRangeArr2;
                            arrayList2 = arrayList;
                            memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                            pDRangeArr2 = pDRangeArr;
                            b2 = 1;
                        } else {
                            ShadedTriangle shadedTriangle = (ShadedTriangle) arrayList2.get(size);
                            MemoryCacheImageInputStream memoryCacheImageInputStream4 = memoryCacheImageInputStream2;
                            ArrayList arrayList4 = arrayList2;
                            pDRangeArr = pDRangeArr2;
                            try {
                                try {
                                    Vertex vertex4 = readVertex(memoryCacheImageInputStream2, jPow, jPow2, decodeForParameter, decodeForParameter2, pDRangeArr2, matrix, affineTransform);
                                    PointF[] pointFArr2 = new PointF[3];
                                    if (bits == 1) {
                                        pointF = shadedTriangle.corner[1];
                                        c2 = 0;
                                    } else {
                                        c2 = 0;
                                        pointF = shadedTriangle.corner[0];
                                    }
                                    pointFArr2[c2] = pointF;
                                    pointFArr2[1] = shadedTriangle.corner[2];
                                    pointFArr2[2] = vertex4.point;
                                    float[][] fArr3 = new float[3][];
                                    if (bits == 1) {
                                        fArr2 = shadedTriangle.color[1];
                                        c3 = 0;
                                    } else {
                                        c3 = 0;
                                        try {
                                            fArr2 = shadedTriangle.color[0];
                                        } catch (EOFException unused5) {
                                            memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                            arrayList = arrayList4;
                                            arrayList2 = arrayList;
                                            memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                                            pDRangeArr2 = pDRangeArr;
                                            b2 = 1;
                                            z = true;
                                        }
                                    }
                                    fArr3[c3] = fArr2;
                                    fArr3[1] = shadedTriangle.color[2];
                                    fArr3[2] = vertex4.color;
                                    try {
                                        arrayList4.add(new ShadedTriangle(pointFArr2, fArr3));
                                        try {
                                            bits = (byte) (memoryCacheImageInputStream4.readBits(bitsPerFlag) & 3);
                                            memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                            arrayList = arrayList4;
                                            arrayList2 = arrayList;
                                            memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                                            pDRangeArr2 = pDRangeArr;
                                            b2 = 1;
                                        } catch (EOFException unused6) {
                                            memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                            arrayList = arrayList4;
                                            arrayList2 = arrayList;
                                            memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                                            pDRangeArr2 = pDRangeArr;
                                            b2 = 1;
                                            z = true;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                            memoryCacheImageInputStream.close();
                                            throw th;
                                        }
                                    } catch (EOFException unused7) {
                                        arrayList = arrayList4;
                                        memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                    }
                                } catch (EOFException unused8) {
                                    memoryCacheImageInputStream = memoryCacheImageInputStream4;
                                    arrayList = arrayList4;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                memoryCacheImageInputStream = memoryCacheImageInputStream4;
                            }
                        }
                    } catch (EOFException unused9) {
                        pDRangeArr = pDRangeArr2;
                        memoryCacheImageInputStream = memoryCacheImageInputStream2;
                        arrayList = arrayList2;
                    }
                } else {
                    try {
                        Log.w("PdfBox-Android", "bad flag: " + ((int) bits));
                        memoryCacheImageInputStream = memoryCacheImageInputStream2;
                        arrayList = arrayList2;
                        pDRangeArr = pDRangeArr2;
                        arrayList2 = arrayList;
                        memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                        pDRangeArr2 = pDRangeArr;
                        b2 = 1;
                    } catch (EOFException unused10) {
                        memoryCacheImageInputStream = memoryCacheImageInputStream2;
                        arrayList = arrayList2;
                        pDRangeArr = pDRangeArr2;
                        arrayList2 = arrayList;
                        memoryCacheImageInputStream2 = memoryCacheImageInputStream;
                        pDRangeArr2 = pDRangeArr;
                        b2 = 1;
                        z = true;
                    }
                }
            }
            ArrayList arrayList5 = arrayList2;
            memoryCacheImageInputStream2.close();
            return arrayList5;
        } catch (Throwable th4) {
            th = th4;
            memoryCacheImageInputStream = memoryCacheImageInputStream2;
            memoryCacheImageInputStream.close();
            throw th;
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ int getBitsPerComponent() {
        return super.getBitsPerComponent();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ int getBitsPerCoordinate() {
        return super.getBitsPerCoordinate();
    }

    public int getBitsPerFlag() {
        return getCOSObject().getInt(COSName.BITS_PER_FLAG, -1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType, com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading
    public /* bridge */ /* synthetic */ RectF getBounds(AffineTransform affineTransform, Matrix matrix) throws IOException {
        return super.getBounds(affineTransform, matrix);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ PDRange getDecodeForParameter(int i2) {
        return super.getDecodeForParameter(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ int getNumberOfColorComponents() throws IOException {
        return super.getNumberOfColorComponents();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading
    public int getShadingType() {
        return 4;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ void setBitsPerComponent(int i2) {
        super.setBitsPerComponent(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ void setBitsPerCoordinate(int i2) {
        super.setBitsPerCoordinate(i2);
    }

    public void setBitsPerFlag(int i2) {
        getCOSObject().setInt(COSName.BITS_PER_FLAG, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ void setDecodeValues(COSArray cOSArray) {
        super.setDecodeValues(cOSArray);
    }
}
