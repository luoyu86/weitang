package com.tom_roush.pdfbox.pdmodel.interactive.digitalsignature.visible;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class PDVisibleSignDesigner {
    private Bitmap image;
    private Float imageHeight;
    private float imageSizeInPercents;
    private Float imageWidth;
    private float pageHeight;
    private float pageWidth;
    private float xAxis;
    private float yAxis;
    private String signatureFieldName = "sig";
    private byte[] formatterRectangleParams = {0, 0, 100, 50};
    private int[] formatterRectangleParameters = {0, 0, 100, 50};
    private AffineTransform affineTransform = new AffineTransform();
    private int rotation = 0;

    public PDVisibleSignDesigner(String str, InputStream inputStream, int i2) throws IOException {
        readImageStream(inputStream);
        calculatePageSizeFromFile(str, i2);
    }

    private void calculatePageSize(PDDocument pDDocument, int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("First page of pdf is 1, not " + i2);
        }
        PDPage page = pDDocument.getPage(i2 - 1);
        PDRectangle mediaBox = page.getMediaBox();
        pageHeight(mediaBox.getHeight());
        this.pageWidth = mediaBox.getWidth();
        this.imageSizeInPercents = 100.0f;
        this.rotation = page.getRotation() % 360;
    }

    private void calculatePageSizeFromFile(String str, int i2) throws IOException {
        PDDocument pDDocumentLoad = PDDocument.load(new File(str));
        calculatePageSize(pDDocumentLoad, i2);
        pDDocumentLoad.close();
    }

    private void calculatePageSizeFromStream(InputStream inputStream, int i2) throws IOException {
        PDDocument pDDocumentLoad = PDDocument.load(inputStream);
        calculatePageSize(pDDocumentLoad, i2);
        pDDocumentLoad.close();
    }

    private PDVisibleSignDesigner pageHeight(float f2) {
        this.pageHeight = f2;
        return this;
    }

    private void readImageStream(InputStream inputStream) throws IOException {
        setImage(BitmapFactory.decodeStream(inputStream));
    }

    private void setImage(Bitmap bitmap) {
        this.image = bitmap;
        this.imageHeight = Float.valueOf(bitmap.getHeight());
        this.imageWidth = Float.valueOf(bitmap.getWidth());
        this.formatterRectangleParameters[2] = bitmap.getWidth();
        this.formatterRectangleParameters[3] = bitmap.getHeight();
    }

    public PDVisibleSignDesigner adjustForRotation() {
        int i2 = this.rotation;
        if (i2 == 90) {
            float f2 = this.yAxis;
            this.yAxis = (this.pageHeight - this.xAxis) - this.imageWidth.floatValue();
            this.xAxis = f2;
            this.affineTransform = new AffineTransform(0.0f, this.imageHeight.floatValue() / this.imageWidth.floatValue(), (-this.imageWidth.floatValue()) / this.imageHeight.floatValue(), 0.0f, this.imageWidth.floatValue(), 0.0f);
            float fFloatValue = this.imageHeight.floatValue();
            this.imageHeight = this.imageWidth;
            this.imageWidth = Float.valueOf(fFloatValue);
        } else if (i2 == 180) {
            float fFloatValue2 = (this.pageWidth - this.xAxis) - this.imageWidth.floatValue();
            float fFloatValue3 = (this.pageHeight - this.yAxis) - this.imageHeight.floatValue();
            this.xAxis = fFloatValue2;
            this.yAxis = fFloatValue3;
            this.affineTransform = new AffineTransform(-1.0f, 0.0f, 0.0f, -1.0f, this.imageWidth.floatValue(), this.imageHeight.floatValue());
        } else if (i2 == 270) {
            float f3 = this.xAxis;
            this.xAxis = (this.pageWidth - this.yAxis) - this.imageHeight.floatValue();
            this.yAxis = f3;
            this.affineTransform = new AffineTransform(0.0f, (-this.imageHeight.floatValue()) / this.imageWidth.floatValue(), this.imageWidth.floatValue() / this.imageHeight.floatValue(), 0.0f, 0.0f, this.imageHeight.floatValue());
            float fFloatValue4 = this.imageHeight.floatValue();
            this.imageHeight = this.imageWidth;
            this.imageWidth = Float.valueOf(fFloatValue4);
        }
        return this;
    }

    @Deprecated
    public PDVisibleSignDesigner affineTransformParams(byte[] bArr) {
        this.affineTransform = new AffineTransform(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5]);
        return this;
    }

    public PDVisibleSignDesigner coordinates(float f2, float f3) {
        xAxis(f2);
        yAxis(f3);
        return this;
    }

    public PDVisibleSignDesigner formatterRectangleParameters(int[] iArr) {
        this.formatterRectangleParameters = iArr;
        return this;
    }

    @Deprecated
    public PDVisibleSignDesigner formatterRectangleParams(byte[] bArr) {
        this.formatterRectangleParams = bArr;
        return this;
    }

    @Deprecated
    public byte[] getAffineTransformParams() {
        return new byte[]{(byte) this.affineTransform.getScaleX(), (byte) this.affineTransform.getShearY(), (byte) this.affineTransform.getShearX(), (byte) this.affineTransform.getScaleY(), (byte) this.affineTransform.getTranslateX(), (byte) this.affineTransform.getTranslateY()};
    }

    public int[] getFormatterRectangleParameters() {
        return this.formatterRectangleParameters;
    }

    @Deprecated
    public byte[] getFormatterRectangleParams() {
        return this.formatterRectangleParams;
    }

    public float getHeight() {
        return this.imageHeight.floatValue();
    }

    public Bitmap getImage() {
        return this.image;
    }

    public float getImageSizeInPercents() {
        return this.imageSizeInPercents;
    }

    public float getPageHeight() {
        return this.pageHeight;
    }

    public float getPageWidth() {
        return this.pageWidth;
    }

    public String getSignatureFieldName() {
        return this.signatureFieldName;
    }

    public String getSignatureText() {
        throw new UnsupportedOperationException("That method is not yet implemented");
    }

    public float getTemplateHeight() {
        return getPageHeight();
    }

    public AffineTransform getTransform() {
        return this.affineTransform;
    }

    public float getWidth() {
        return this.imageWidth.floatValue();
    }

    public float getxAxis() {
        return this.xAxis;
    }

    public float getyAxis() {
        return this.yAxis;
    }

    public PDVisibleSignDesigner height(float f2) {
        this.imageHeight = Float.valueOf(f2);
        this.formatterRectangleParameters[3] = (int) f2;
        return this;
    }

    public void imageSizeInPercents(float f2) {
        this.imageSizeInPercents = f2;
    }

    public PDVisibleSignDesigner pageWidth(float f2) {
        this.pageWidth = f2;
        return this;
    }

    public PDVisibleSignDesigner signatureFieldName(String str) {
        this.signatureFieldName = str;
        return this;
    }

    public PDVisibleSignDesigner signatureImage(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (Throwable th) {
            th = th;
        }
        try {
            readImageStream(bufferedInputStream);
            IOUtils.closeQuietly(bufferedInputStream);
            return this;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            IOUtils.closeQuietly(bufferedInputStream2);
            throw th;
        }
    }

    public PDVisibleSignDesigner signatureText(String str) {
        throw new UnsupportedOperationException("That method is not yet implemented");
    }

    public PDVisibleSignDesigner transform(AffineTransform affineTransform) {
        this.affineTransform = new AffineTransform(affineTransform);
        return this;
    }

    public PDVisibleSignDesigner width(float f2) {
        this.imageWidth = Float.valueOf(f2);
        this.formatterRectangleParameters[2] = (int) f2;
        return this;
    }

    public PDVisibleSignDesigner xAxis(float f2) {
        this.xAxis = f2;
        return this;
    }

    public PDVisibleSignDesigner yAxis(float f2) {
        this.yAxis = f2;
        return this;
    }

    public PDVisibleSignDesigner zoom(float f2) {
        this.imageHeight = Float.valueOf(this.imageHeight.floatValue() + ((this.imageHeight.floatValue() * f2) / 100.0f));
        Float fValueOf = Float.valueOf(this.imageWidth.floatValue() + ((this.imageWidth.floatValue() * f2) / 100.0f));
        this.imageWidth = fValueOf;
        this.formatterRectangleParameters[2] = (int) fValueOf.floatValue();
        this.formatterRectangleParameters[3] = (int) this.imageHeight.floatValue();
        return this;
    }

    public PDVisibleSignDesigner(InputStream inputStream, InputStream inputStream2, int i2) throws IOException {
        readImageStream(inputStream2);
        calculatePageSizeFromStream(inputStream, i2);
    }

    public PDVisibleSignDesigner(PDDocument pDDocument, InputStream inputStream, int i2) throws IOException {
        readImageStream(inputStream);
        calculatePageSize(pDDocument, i2);
    }

    public PDVisibleSignDesigner(String str, Bitmap bitmap, int i2) throws IOException {
        setImage(bitmap);
        calculatePageSizeFromFile(str, i2);
    }

    public PDVisibleSignDesigner(InputStream inputStream, Bitmap bitmap, int i2) throws IOException {
        setImage(bitmap);
        calculatePageSizeFromStream(inputStream, i2);
    }

    public PDVisibleSignDesigner(PDDocument pDDocument, Bitmap bitmap, int i2) {
        setImage(bitmap);
        calculatePageSize(pDDocument, i2);
    }

    public PDVisibleSignDesigner(InputStream inputStream) throws IOException {
        readImageStream(inputStream);
    }
}
