package com.tom_roush.pdfbox.pdmodel.graphics.state;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.PDLineDashPattern;
import com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.util.GraphicsUtil;
import com.tom_roush.pdfbox.util.Matrix;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PDGraphicsState implements Cloneable {
    private double alphaConstant;
    private boolean alphaSource;
    private BlendMode blendMode;
    private double flatness;
    private boolean isClippingPathDirty;
    private Paint.Cap lineCap;
    private PDLineDashPattern lineDashPattern;
    private Paint.Join lineJoin;
    private float lineWidth;
    private float miterLimit;
    private double nonStrokingAlphaConstant;
    private PDColor nonStrokingColor;
    private PDColorSpace nonStrokingColorSpace;
    private boolean nonStrokingOverprint;
    private boolean overprint;
    private double overprintMode;
    private RenderingIntent renderingIntent;
    private double smoothness;
    private PDSoftMask softMask;
    private boolean strokeAdjustment;
    private PDColor strokingColor;
    private PDColorSpace strokingColorSpace;
    private PDTextState textState;
    private COSBase transfer;
    private List<Path> clippingPaths = new ArrayList();
    private Map<Path, Region> clippingCache = new IdentityHashMap();
    private Matrix currentTransformationMatrix = new Matrix();

    public PDGraphicsState(PDRectangle pDRectangle) {
        PDDeviceGray pDDeviceGray = PDDeviceGray.INSTANCE;
        this.strokingColor = pDDeviceGray.getInitialColor();
        this.nonStrokingColor = pDDeviceGray.getInitialColor();
        this.strokingColorSpace = pDDeviceGray;
        this.nonStrokingColorSpace = pDDeviceGray;
        this.textState = new PDTextState();
        this.lineWidth = 1.0f;
        this.lineCap = Paint.Cap.BUTT;
        this.lineJoin = Paint.Join.MITER;
        this.miterLimit = 10.0f;
        this.lineDashPattern = new PDLineDashPattern();
        this.strokeAdjustment = false;
        this.blendMode = BlendMode.COMPATIBLE;
        this.alphaConstant = 1.0d;
        this.nonStrokingAlphaConstant = 1.0d;
        this.alphaSource = false;
        this.overprint = false;
        this.nonStrokingOverprint = false;
        this.overprintMode = 0.0d;
        this.transfer = null;
        this.flatness = 1.0d;
        this.smoothness = 0.0d;
        this.clippingPaths.add(pDRectangle.toGeneralPath());
    }

    public double getAlphaConstant() {
        return this.alphaConstant;
    }

    public BlendMode getBlendMode() {
        return this.blendMode;
    }

    public Region getCurrentClippingPath() {
        if (this.clippingPaths.size() == 1) {
            Path path = this.clippingPaths.get(0);
            Region region = this.clippingCache.get(path);
            if (region != null) {
                return region;
            }
            Region pathRegion = GraphicsUtil.getPathRegion(path);
            this.clippingCache.put(path, pathRegion);
            return pathRegion;
        }
        Path path2 = new Path(this.clippingPaths.get(0));
        for (int i2 = 1; i2 < this.clippingPaths.size(); i2++) {
            path2.op(this.clippingPaths.get(i2), Path.Op.INTERSECT);
        }
        Region pathRegion2 = GraphicsUtil.getPathRegion(path2);
        ArrayList arrayList = new ArrayList();
        this.clippingPaths = arrayList;
        arrayList.add(path2);
        this.clippingCache.put(path2, pathRegion2);
        return pathRegion2;
    }

    public List<Path> getCurrentClippingPaths() {
        return this.clippingPaths;
    }

    public Matrix getCurrentTransformationMatrix() {
        return this.currentTransformationMatrix;
    }

    public double getFlatness() {
        return this.flatness;
    }

    public Paint.Cap getLineCap() {
        return this.lineCap;
    }

    public PDLineDashPattern getLineDashPattern() {
        return this.lineDashPattern;
    }

    public Paint.Join getLineJoin() {
        return this.lineJoin;
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public double getNonStrokeAlphaConstant() {
        return this.nonStrokingAlphaConstant;
    }

    @Deprecated
    public double getNonStrokeAlphaConstants() {
        return this.nonStrokingAlphaConstant;
    }

    public PDColor getNonStrokingColor() {
        return this.nonStrokingColor;
    }

    public PDColorSpace getNonStrokingColorSpace() {
        return this.nonStrokingColorSpace;
    }

    public double getOverprintMode() {
        return this.overprintMode;
    }

    public RenderingIntent getRenderingIntent() {
        return this.renderingIntent;
    }

    public double getSmoothness() {
        return this.smoothness;
    }

    public PDSoftMask getSoftMask() {
        return this.softMask;
    }

    public PDColor getStrokingColor() {
        return this.strokingColor;
    }

    public PDColorSpace getStrokingColorSpace() {
        return this.strokingColorSpace;
    }

    public PDTextState getTextState() {
        return this.textState;
    }

    public COSBase getTransfer() {
        return this.transfer;
    }

    public void intersectClippingPath(Path path) {
        intersectClippingPath(path, true);
    }

    public boolean isAlphaSource() {
        return this.alphaSource;
    }

    public boolean isNonStrokingOverprint() {
        return this.nonStrokingOverprint;
    }

    public boolean isOverprint() {
        return this.overprint;
    }

    public boolean isStrokeAdjustment() {
        return this.strokeAdjustment;
    }

    public void setAlphaConstant(double d2) {
        this.alphaConstant = d2;
    }

    public void setAlphaSource(boolean z) {
        this.alphaSource = z;
    }

    public void setBlendMode(BlendMode blendMode) {
        this.blendMode = blendMode;
    }

    public void setCurrentTransformationMatrix(Matrix matrix) {
        this.currentTransformationMatrix = matrix;
    }

    public void setFlatness(double d2) {
        this.flatness = d2;
    }

    public void setLineCap(Paint.Cap cap) {
        this.lineCap = cap;
    }

    public void setLineDashPattern(PDLineDashPattern pDLineDashPattern) {
        this.lineDashPattern = pDLineDashPattern;
    }

    public void setLineJoin(Paint.Join join) {
        this.lineJoin = join;
    }

    public void setLineWidth(float f2) {
        this.lineWidth = f2;
    }

    public void setMiterLimit(float f2) {
        this.miterLimit = f2;
    }

    public void setNonStrokeAlphaConstant(double d2) {
        this.nonStrokingAlphaConstant = d2;
    }

    @Deprecated
    public void setNonStrokeAlphaConstants(double d2) {
        this.nonStrokingAlphaConstant = d2;
    }

    public void setNonStrokingColor(PDColor pDColor) {
        this.nonStrokingColor = pDColor;
    }

    public void setNonStrokingColorSpace(PDColorSpace pDColorSpace) {
        this.nonStrokingColorSpace = pDColorSpace;
    }

    public void setNonStrokingOverprint(boolean z) {
        this.nonStrokingOverprint = z;
    }

    public void setOverprint(boolean z) {
        this.overprint = z;
    }

    public void setOverprintMode(double d2) {
        this.overprintMode = d2;
    }

    public void setRenderingIntent(RenderingIntent renderingIntent) {
        this.renderingIntent = renderingIntent;
    }

    public void setSmoothness(double d2) {
        this.smoothness = d2;
    }

    public void setSoftMask(PDSoftMask pDSoftMask) {
        this.softMask = pDSoftMask;
    }

    public void setStrokeAdjustment(boolean z) {
        this.strokeAdjustment = z;
    }

    public void setStrokingColor(PDColor pDColor) {
        this.strokingColor = pDColor;
    }

    public void setStrokingColorSpace(PDColorSpace pDColorSpace) {
        this.strokingColorSpace = pDColorSpace;
    }

    public void setTextState(PDTextState pDTextState) {
        this.textState = pDTextState;
    }

    public void setTransfer(COSBase cOSBase) {
        this.transfer = cOSBase;
    }

    private void intersectClippingPath(Path path, boolean z) {
        if (!this.isClippingPathDirty) {
            this.clippingPaths = new ArrayList(this.clippingPaths);
            this.isClippingPathDirty = true;
        }
        List<Path> list = this.clippingPaths;
        if (z) {
            path = new Path(path);
        }
        list.add(path);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PDGraphicsState m85clone() {
        try {
            PDGraphicsState pDGraphicsState = (PDGraphicsState) super.clone();
            pDGraphicsState.textState = this.textState.m86clone();
            pDGraphicsState.currentTransformationMatrix = this.currentTransformationMatrix.m87clone();
            pDGraphicsState.strokingColor = this.strokingColor;
            pDGraphicsState.nonStrokingColor = this.nonStrokingColor;
            pDGraphicsState.lineDashPattern = this.lineDashPattern;
            pDGraphicsState.clippingPaths = this.clippingPaths;
            pDGraphicsState.clippingCache = this.clippingCache;
            pDGraphicsState.isClippingPathDirty = false;
            return pDGraphicsState;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void intersectClippingPath(Region region) {
        intersectClippingPath(region.getBoundaryPath(), false);
    }
}
