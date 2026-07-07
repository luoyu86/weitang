package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.harmony.javax.imageio.stream.ImageInputStream;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDTriangleBasedShadingType extends PDShading {
    private int bitsPerColorComponent;
    private int bitsPerCoordinate;
    private COSArray decode;
    private int numberOfColorComponents;

    public PDTriangleBasedShadingType(COSDictionary cOSDictionary) {
        super(cOSDictionary);
        this.decode = null;
        this.bitsPerCoordinate = -1;
        this.bitsPerColorComponent = -1;
        this.numberOfColorComponents = -1;
    }

    private COSArray getDecodeValues() {
        if (this.decode == null) {
            this.decode = (COSArray) getCOSObject().getDictionaryObject(COSName.DECODE);
        }
        return this.decode;
    }

    public abstract List<ShadedTriangle> collectTriangles(AffineTransform affineTransform, Matrix matrix) throws IOException;

    public int getBitsPerComponent() {
        if (this.bitsPerColorComponent == -1) {
            this.bitsPerColorComponent = getCOSObject().getInt(COSName.BITS_PER_COMPONENT, -1);
            Log.d("PdfBox-Android", "bitsPerColorComponent: " + this.bitsPerColorComponent);
        }
        return this.bitsPerColorComponent;
    }

    public int getBitsPerCoordinate() {
        if (this.bitsPerCoordinate == -1) {
            this.bitsPerCoordinate = getCOSObject().getInt(COSName.BITS_PER_COORDINATE, -1);
            Log.d("PdfBox-Android", "bitsPerCoordinate: " + (Math.pow(2.0d, this.bitsPerCoordinate) - 1.0d));
        }
        return this.bitsPerCoordinate;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading
    public RectF getBounds(AffineTransform affineTransform, Matrix matrix) throws IOException {
        RectF rectF = null;
        for (ShadedTriangle shadedTriangle : collectTriangles(affineTransform, matrix)) {
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
        return rectF == null ? new RectF() : rectF;
    }

    public PDRange getDecodeForParameter(int i2) {
        COSArray decodeValues = getDecodeValues();
        if (decodeValues == null || decodeValues.size() < (i2 * 2) + 1) {
            return null;
        }
        return new PDRange(decodeValues, i2);
    }

    public int getNumberOfColorComponents() throws IOException {
        if (this.numberOfColorComponents == -1) {
            this.numberOfColorComponents = getFunction() != null ? 1 : getColorSpace().getNumberOfComponents();
            Log.d("PdfBox-Android", "numberOfColorComponents: " + this.numberOfColorComponents);
        }
        return this.numberOfColorComponents;
    }

    public float interpolate(float f2, long j, float f3, float f4) {
        return f3 + ((f2 * (f4 - f3)) / j);
    }

    public Vertex readVertex(ImageInputStream imageInputStream, long j, long j2, PDRange pDRange, PDRange pDRange2, PDRange[] pDRangeArr, Matrix matrix, AffineTransform affineTransform) throws IOException {
        float[] fArr = new float[this.numberOfColorComponents];
        long bits = imageInputStream.readBits(this.bitsPerCoordinate);
        long bits2 = imageInputStream.readBits(this.bitsPerCoordinate);
        float fInterpolate = interpolate(bits, j, pDRange.getMin(), pDRange.getMax());
        float fInterpolate2 = interpolate(bits2, j, pDRange2.getMin(), pDRange2.getMax());
        Log.d("PdfBox-Android", "coord: " + String.format("[%06X,%06X] -> [%f,%f]", Long.valueOf(bits), Long.valueOf(bits2), Float.valueOf(fInterpolate), Float.valueOf(fInterpolate2)));
        PointF pointFTransformPoint = matrix.transformPoint(fInterpolate, fInterpolate2);
        affineTransform.transform(pointFTransformPoint, pointFTransformPoint);
        for (int i2 = 0; i2 < this.numberOfColorComponents; i2++) {
            int bits3 = (int) imageInputStream.readBits(this.bitsPerColorComponent);
            fArr[i2] = interpolate(bits3, j2, pDRangeArr[i2].getMin(), pDRangeArr[i2].getMax());
            Log.d("PdfBox-Android", "color[" + i2 + "]: " + bits3 + "/" + String.format("%02x", Integer.valueOf(bits3)) + "-> color[" + i2 + "]: " + fArr[i2]);
        }
        int bitOffset = imageInputStream.getBitOffset();
        if (bitOffset != 0) {
            imageInputStream.readBits(8 - bitOffset);
        }
        return new Vertex(pointFTransformPoint, fArr);
    }

    public void setBitsPerComponent(int i2) {
        getCOSObject().setInt(COSName.BITS_PER_COMPONENT, i2);
        this.bitsPerColorComponent = i2;
    }

    public void setBitsPerCoordinate(int i2) {
        getCOSObject().setInt(COSName.BITS_PER_COORDINATE, i2);
        this.bitsPerCoordinate = i2;
    }

    public void setDecodeValues(COSArray cOSArray) {
        this.decode = cOSArray;
        getCOSObject().setItem(COSName.DECODE, (COSBase) cOSArray);
    }
}
