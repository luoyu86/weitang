package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import android.graphics.RectF;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDShadingType5 extends PDTriangleBasedShadingType {
    public PDShadingType5(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public List<ShadedTriangle> collectTriangles(AffineTransform affineTransform, Matrix matrix) throws IOException {
        COSDictionary cOSObject = getCOSObject();
        if (!(cOSObject instanceof COSStream)) {
            return Collections.emptyList();
        }
        PDRange decodeForParameter = getDecodeForParameter(0);
        PDRange decodeForParameter2 = getDecodeForParameter(1);
        if (Float.compare(decodeForParameter.getMin(), decodeForParameter.getMax()) == 0 || Float.compare(decodeForParameter2.getMin(), decodeForParameter2.getMax()) == 0) {
            return Collections.emptyList();
        }
        int verticesPerRow = getVerticesPerRow();
        int numberOfColorComponents = getNumberOfColorComponents();
        PDRange[] pDRangeArr = new PDRange[numberOfColorComponents];
        for (int i2 = 0; i2 < numberOfColorComponents; i2++) {
            pDRangeArr[i2] = getDecodeForParameter(i2 + 2);
        }
        ArrayList arrayList = new ArrayList();
        long jPow = ((long) Math.pow(2.0d, getBitsPerCoordinate())) - 1;
        long jPow2 = ((long) Math.pow(2.0d, getBitsPerComponent())) - 1;
        MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(((COSStream) cOSObject).createInputStream());
        boolean z = false;
        while (!z) {
            MemoryCacheImageInputStream memoryCacheImageInputStream2 = memoryCacheImageInputStream;
            ArrayList arrayList2 = arrayList;
            PDRange[] pDRangeArr2 = pDRangeArr;
            int i3 = verticesPerRow;
            try {
                arrayList2.add(readVertex(memoryCacheImageInputStream, jPow, jPow2, decodeForParameter, decodeForParameter2, pDRangeArr, matrix, affineTransform));
                arrayList = arrayList2;
                verticesPerRow = i3;
                memoryCacheImageInputStream = memoryCacheImageInputStream2;
                pDRangeArr = pDRangeArr2;
            } catch (EOFException unused) {
                arrayList = arrayList2;
                verticesPerRow = i3;
                memoryCacheImageInputStream = memoryCacheImageInputStream2;
                pDRangeArr = pDRangeArr2;
                z = true;
            } catch (Throwable th) {
                memoryCacheImageInputStream2.close();
                throw th;
            }
        }
        ArrayList arrayList3 = arrayList;
        int i4 = verticesPerRow;
        memoryCacheImageInputStream.close();
        int size = arrayList3.size() / i4;
        Vertex[][] vertexArr = (Vertex[][]) Array.newInstance((Class<?>) Vertex.class, size, i4);
        ArrayList arrayList4 = new ArrayList();
        if (size < 2) {
            return arrayList4;
        }
        for (int i5 = 0; i5 < size; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                vertexArr[i5][i6] = (Vertex) arrayList3.get((i5 * i4) + i6);
            }
        }
        PointF[] pointFArr = new PointF[3];
        float[][] fArr = new float[3][];
        int i7 = 0;
        while (true) {
            char c2 = 1;
            if (i7 >= size - 1) {
                return arrayList4;
            }
            int i8 = 0;
            while (i8 < i4 - 1) {
                pointFArr[0] = vertexArr[i7][i8].point;
                int i9 = i8 + 1;
                pointFArr[c2] = vertexArr[i7][i9].point;
                int i10 = i7 + 1;
                pointFArr[2] = vertexArr[i10][i8].point;
                fArr[0] = vertexArr[i7][i8].color;
                fArr[1] = vertexArr[i7][i9].color;
                fArr[2] = vertexArr[i10][i8].color;
                arrayList4.add(new ShadedTriangle(pointFArr, fArr));
                pointFArr[0] = vertexArr[i7][i9].point;
                pointFArr[1] = vertexArr[i10][i8].point;
                pointFArr[2] = vertexArr[i10][i9].point;
                fArr[0] = vertexArr[i7][i9].color;
                fArr[1] = vertexArr[i10][i8].color;
                fArr[2] = vertexArr[i10][i9].color;
                arrayList4.add(new ShadedTriangle(pointFArr, fArr));
                i8 = i9;
                c2 = 1;
            }
            i7++;
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
        return 5;
    }

    public int getVerticesPerRow() {
        return getCOSObject().getInt(COSName.VERTICES_PER_ROW, -1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ void setBitsPerComponent(int i2) {
        super.setBitsPerComponent(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ void setBitsPerCoordinate(int i2) {
        super.setBitsPerCoordinate(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDTriangleBasedShadingType
    public /* bridge */ /* synthetic */ void setDecodeValues(COSArray cOSArray) {
        super.setDecodeValues(cOSArray);
    }

    public void setVerticesPerRow(int i2) {
        getCOSObject().setInt(COSName.VERTICES_PER_ROW, i2);
    }
}
