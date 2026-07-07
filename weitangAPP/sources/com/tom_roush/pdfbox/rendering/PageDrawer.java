package com.tom_roush.pdfbox.rendering;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.common.function.PDFunction;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType0;
import com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType2;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.font.PDTrueTypeFont;
import com.tom_roush.pdfbox.pdmodel.font.PDType0Font;
import com.tom_roush.pdfbox.pdmodel.font.PDType1CFont;
import com.tom_roush.pdfbox.pdmodel.font.PDType1Font;
import com.tom_roush.pdfbox.pdmodel.font.PDType3Font;
import com.tom_roush.pdfbox.pdmodel.graphics.PDLineDashPattern;
import com.tom_roush.pdfbox.pdmodel.graphics.PDXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentMembershipDictionary;
import com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import com.tom_roush.pdfbox.pdmodel.graphics.state.RenderingMode;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.Vector;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class PageDrawer extends PDFGraphicsStreamEngine {
    public static final int JAVA_VERSION = getJavaVersion();
    private AnnotationFilter annotationFilter;
    private Canvas canvas;
    private Path.FillType clipWindingRule;
    private PointF currentPoint;
    private final RenderDestination destination;
    private boolean flipTG;
    private final Map<PDFont, Glyph2D> fontGlyph2D;
    private final float imageDownscalingOptimizationThreshold;
    private Path initialClip;
    private Region lastClip;
    private int lastStackSize;
    private Path linePath;
    private int nestedHiddenOCGCount;
    private PDRectangle pageSize;
    private Paint paint;
    private final PDFRenderer renderer;
    private final boolean subsamplingAllowed;
    private List<Path> textClippings;
    private final Deque<TransparencyGroup> transparencyGroupStack;
    private AffineTransform xform;
    private float xformScalingFactorX;
    private float xformScalingFactorY;

    public final class TransparencyGroup {
        private boolean isGray(PDColorSpace pDColorSpace) {
            return pDColorSpace instanceof PDDeviceGray;
        }

        private TransparencyGroup(PDTransparencyGroup pDTransparencyGroup, boolean z, Matrix matrix, PDColor pDColor) throws IOException {
            pDTransparencyGroup.getBBox().transform(Matrix.concatenate(matrix, pDTransparencyGroup.getMatrix()));
            AffineTransform affineTransform = PageDrawer.this.xform;
            PageDrawer.this.xform = AffineTransform.getScaleInstance(PageDrawer.this.xformScalingFactorX, PageDrawer.this.xformScalingFactorY);
            isGray(pDTransparencyGroup.getGroup().getColorSpace(pDTransparencyGroup.getResources()));
            if ((z || pDTransparencyGroup.getGroup().isIsolated() || !PageDrawer.this.hasBlendMode(pDTransparencyGroup, new HashSet())) ? false : true) {
                if (PageDrawer.this.transparencyGroupStack.isEmpty()) {
                    PageDrawer.this.renderer.getPageImage();
                }
            }
            boolean z2 = PageDrawer.this.flipTG;
            PageDrawer.this.flipTG = false;
            PDRectangle pDRectangle = PageDrawer.this.pageSize;
            Path.FillType fillType = PageDrawer.this.clipWindingRule;
            PageDrawer.this.clipWindingRule = null;
            Path path = PageDrawer.this.linePath;
            PageDrawer.this.linePath = new Path();
            PageDrawer.this.setRenderingHints();
            try {
                if (z) {
                    PageDrawer.this.processSoftMask(pDTransparencyGroup);
                } else {
                    PageDrawer.this.transparencyGroupStack.push(this);
                    PageDrawer.this.processTransparencyGroup(pDTransparencyGroup);
                    if (!PageDrawer.this.transparencyGroupStack.isEmpty()) {
                        PageDrawer.this.transparencyGroupStack.pop();
                    }
                }
            } finally {
                PageDrawer.this.flipTG = z2;
                PageDrawer.this.clipWindingRule = fillType;
                PageDrawer.this.linePath = path;
                PageDrawer.this.pageSize = pDRectangle;
                PageDrawer.this.xform = affineTransform;
            }
        }
    }

    public PageDrawer(PageDrawerParameters pageDrawerParameters) throws IOException {
        super(pageDrawerParameters.getPage());
        this.flipTG = false;
        this.clipWindingRule = null;
        this.linePath = new Path();
        this.lastStackSize = 0;
        this.fontGlyph2D = new HashMap();
        this.currentPoint = new PointF();
        this.transparencyGroupStack = new ArrayDeque();
        this.annotationFilter = new AnnotationFilter() { // from class: com.tom_roush.pdfbox.rendering.PageDrawer.1
            @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.AnnotationFilter
            public boolean accept(PDAnnotation pDAnnotation) {
                return true;
            }
        };
        this.renderer = pageDrawerParameters.getRenderer();
        this.subsamplingAllowed = pageDrawerParameters.isSubsamplingAllowed();
        this.destination = pageDrawerParameters.getDestination();
        this.imageDownscalingOptimizationThreshold = pageDrawerParameters.getImageDownscalingOptimizationThreshold();
    }

    private Bitmap applyTransferFunction(Bitmap bitmap, COSBase cOSBase) throws IOException {
        PDFunction pDFunctionCreate;
        Integer[] numArr;
        PDFunction pDFunctionCreate2;
        PDFunction pDFunctionCreate3;
        Integer[] numArr2;
        Integer[] numArr3;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            pDFunctionCreate = PDFunction.create(cOSArray.getObject(0));
            pDFunctionCreate3 = PDFunction.create(cOSArray.getObject(1));
            pDFunctionCreate2 = PDFunction.create(cOSArray.getObject(2));
            numArr = new Integer[256];
            numArr3 = new Integer[256];
            numArr2 = new Integer[256];
        } else {
            pDFunctionCreate = PDFunction.create(cOSBase);
            numArr = new Integer[256];
            pDFunctionCreate2 = pDFunctionCreate;
            pDFunctionCreate3 = pDFunctionCreate2;
            numArr2 = numArr;
            numArr3 = numArr2;
        }
        float[] fArr = new float[1];
        for (int i2 = 0; i2 < bitmap.getWidth(); i2++) {
            for (int i3 = 0; i3 < bitmap.getHeight(); i3++) {
                int pixel = bitmap.getPixel(i2, i3);
                int i4 = (pixel >> 16) & 255;
                int i5 = (pixel >> 8) & 255;
                int i6 = pixel & 255;
                if (numArr[i4] != null) {
                    iIntValue = numArr[i4].intValue();
                } else {
                    fArr[0] = (i4 & 255) / 255.0f;
                    int i7 = (int) (pDFunctionCreate.eval(fArr)[0] * 255.0f);
                    numArr[i4] = Integer.valueOf(i7);
                    iIntValue = i7;
                }
                if (numArr3[i5] != null) {
                    iIntValue2 = numArr3[i5].intValue();
                } else {
                    fArr[0] = (i5 & 255) / 255.0f;
                    iIntValue2 = (int) (pDFunctionCreate3.eval(fArr)[0] * 255.0f);
                    numArr3[i5] = Integer.valueOf(iIntValue2);
                }
                if (numArr2[i6] != null) {
                    iIntValue3 = numArr2[i6].intValue();
                } else {
                    fArr[0] = (i6 & 255) / 255.0f;
                    iIntValue3 = (int) (pDFunctionCreate2.eval(fArr)[0] * 255.0f);
                    numArr2[i6] = Integer.valueOf(iIntValue3);
                }
                bitmapCreateBitmap.setPixel(i2, i3, (iIntValue2 << 8) | (pixel & (-16777216)) | (iIntValue << 16) | iIntValue3);
            }
        }
        return bitmapCreateBitmap;
    }

    private void beginTextClip() {
        this.textClippings = new ArrayList();
    }

    private float clampColor(float f2) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private Glyph2D createGlyph2D(PDFont pDFont) throws IOException {
        Glyph2D type1Glyph2D;
        Glyph2D cIDType0Glyph2D = this.fontGlyph2D.get(pDFont);
        if (cIDType0Glyph2D != null) {
            return cIDType0Glyph2D;
        }
        if (pDFont instanceof PDTrueTypeFont) {
            type1Glyph2D = new TTFGlyph2D((PDTrueTypeFont) pDFont);
        } else if (pDFont instanceof PDType1Font) {
            type1Glyph2D = new Type1Glyph2D((PDType1Font) pDFont);
        } else if (pDFont instanceof PDType1CFont) {
            type1Glyph2D = new Type1Glyph2D((PDType1CFont) pDFont);
        } else {
            if (!(pDFont instanceof PDType0Font)) {
                throw new IllegalStateException("Bad font type: " + pDFont.getClass().getSimpleName());
            }
            PDType0Font pDType0Font = (PDType0Font) pDFont;
            if (pDType0Font.getDescendantFont() instanceof PDCIDFontType2) {
                cIDType0Glyph2D = new TTFGlyph2D(pDType0Font);
            } else if (pDType0Font.getDescendantFont() instanceof PDCIDFontType0) {
                cIDType0Glyph2D = new CIDType0Glyph2D((PDCIDFontType0) pDType0Font.getDescendantFont());
            }
            type1Glyph2D = cIDType0Glyph2D;
        }
        if (type1Glyph2D != null) {
            this.fontGlyph2D.put(pDFont, type1Glyph2D);
        }
        if (type1Glyph2D != null) {
            return type1Glyph2D;
        }
        throw new UnsupportedOperationException("No font for " + pDFont.getName());
    }

    private void drawBitmap(Bitmap bitmap, AffineTransform affineTransform) throws IOException {
        setClip();
        AffineTransform affineTransform2 = new AffineTransform(affineTransform);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        affineTransform2.scale(1.0d / ((double) width), (-1.0d) / ((double) height));
        affineTransform2.translate(0.0d, -height);
        if (getGraphicsState().getSoftMask() != null) {
            new RectF(0.0f, 0.0f, width, height);
            return;
        }
        COSBase transfer = getGraphicsState().getTransfer();
        if ((transfer instanceof COSArray) || (transfer instanceof COSDictionary)) {
            bitmap = applyTransferFunction(bitmap, transfer);
        }
        this.canvas.drawBitmap(bitmap, affineTransform2.toMatrix(), this.paint);
    }

    private void drawGlyph2D(Glyph2D glyph2D, PDFont pDFont, int i2, Vector vector, AffineTransform affineTransform) throws IOException {
        RenderingMode renderingMode = getGraphicsState().getTextState().getRenderingMode();
        Path pathForCharacterCode = glyph2D.getPathForCharacterCode(i2);
        if (pathForCharacterCode != null) {
            if (!pDFont.isEmbedded() && !pDFont.isVertical() && !pDFont.isStandard14() && pDFont.hasExplicitWidth(i2)) {
                if (pDFont.getWidthFromFont(i2) > 0.0f && Math.abs(r8 - (vector.getX() * 1000.0f)) > 1.0E-4d) {
                    affineTransform.scale((vector.getX() * 1000.0f) / r8, 1.0d);
                }
            }
            pathForCharacterCode.transform(affineTransform.toMatrix());
            if (isContentRendered()) {
                if (renderingMode.isFill()) {
                    this.paint.setColor(getNonStrokingColor());
                    setClip();
                    this.paint.setStyle(Paint.Style.FILL);
                    this.canvas.drawPath(pathForCharacterCode, this.paint);
                }
                if (renderingMode.isStroke()) {
                    this.paint.setColor(getStrokingColor());
                    setStroke();
                    setClip();
                    this.paint.setStyle(Paint.Style.STROKE);
                    this.canvas.drawPath(pathForCharacterCode, this.paint);
                }
            }
            renderingMode.isClip();
        }
    }

    private void endTextClip() {
        PDGraphicsState graphicsState = getGraphicsState();
        if (!graphicsState.getTextState().getRenderingMode().isClip() || this.textClippings.isEmpty()) {
            return;
        }
        Path path = new Path();
        path.setFillType(Path.FillType.WINDING);
        Iterator<Path> it = this.textClippings.iterator();
        while (it.hasNext()) {
            path.addPath(it.next());
        }
        graphicsState.intersectClippingPath(path);
        this.textClippings = new ArrayList();
        this.lastClip = null;
    }

    private int getColor(PDColor pDColor) throws IOException {
        float[] rgb = pDColor.getColorSpace().toRGB(pDColor.getComponents());
        return Color.rgb(Math.round(rgb[0] * 255.0f), Math.round(rgb[1] * 255.0f), Math.round(rgb[2] * 255.0f));
    }

    private float[] getDashArray(PDLineDashPattern pDLineDashPattern) {
        float[] dashArray = pDLineDashPattern.getDashArray();
        int phase = pDLineDashPattern.getPhase();
        if (dashArray.length != 0) {
            float f2 = phase;
            if (!Float.isInfinite(f2) && !Float.isNaN(f2)) {
                int i2 = 0;
                for (int i3 = 0; i3 < dashArray.length; i3++) {
                    if (Float.isInfinite(dashArray[i3]) || Float.isNaN(dashArray[i3])) {
                        return null;
                    }
                }
                if (JAVA_VERSION < 10) {
                    while (i2 < dashArray.length) {
                        float fTransformWidth = transformWidth(dashArray[i2]);
                        if (this.xformScalingFactorX < 0.5f) {
                            dashArray[i2] = Math.max(fTransformWidth, 0.2f);
                        } else {
                            dashArray[i2] = Math.max(fTransformWidth, 0.062f);
                        }
                        i2++;
                    }
                } else {
                    while (i2 < dashArray.length) {
                        dashArray[i2] = transformWidth(dashArray[i2]);
                        i2++;
                    }
                }
                return dashArray;
            }
        }
        return null;
    }

    private static int getJavaVersion() {
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.specification.version"), Consts.DOT);
        try {
            int i2 = Integer.parseInt(stringTokenizer.nextToken());
            return i2 == 1 ? stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0 : i2;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private int getStrokingColor() throws IOException {
        return getColor(getGraphicsState().getStrokingColor());
    }

    private int getSubsampling(PDImage pDImage, AffineTransform affineTransform) {
        int iFloor = (int) Math.floor(Math.sqrt(((double) (pDImage.getWidth() * pDImage.getHeight())) / Math.abs(affineTransform.getDeterminant() * this.xform.getDeterminant())));
        if (iFloor > 8) {
            iFloor = 8;
        }
        if (iFloor < 1) {
            iFloor = 1;
        }
        return (iFloor > pDImage.getWidth() || iFloor > pDImage.getHeight()) ? Math.min(pDImage.getWidth(), pDImage.getHeight()) : iFloor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasBlendMode(PDTransparencyGroup pDTransparencyGroup, Set<COSBase> set) {
        PDXObject xObject;
        if (set.contains(pDTransparencyGroup.getCOSObject())) {
            return false;
        }
        set.add(pDTransparencyGroup.getCOSObject());
        PDResources resources = pDTransparencyGroup.getResources();
        if (resources == null) {
            return false;
        }
        Iterator<COSName> it = resources.getExtGStateNames().iterator();
        while (it.hasNext()) {
            PDExtendedGraphicsState extGState = resources.getExtGState(it.next());
            if (extGState != null && extGState.getBlendMode() != BlendMode.NORMAL) {
                return true;
            }
        }
        Iterator<COSName> it2 = resources.getXObjectNames().iterator();
        while (it2.hasNext()) {
            try {
                xObject = resources.getXObject(it2.next());
            } catch (IOException unused) {
            }
            if ((xObject instanceof PDTransparencyGroup) && hasBlendMode((PDTransparencyGroup) xObject, set)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllZeroDash(float[] fArr) {
        if (fArr.length <= 0) {
            return false;
        }
        for (float f2 : fArr) {
            if (f2 != 0.0f) {
                return false;
            }
        }
        return true;
    }

    private boolean isContentRendered() {
        return this.nestedHiddenOCGCount <= 0;
    }

    private boolean isHiddenOCG(PDPropertyList pDPropertyList) {
        if (pDPropertyList instanceof PDOptionalContentGroup) {
            PDOptionalContentGroup pDOptionalContentGroup = (PDOptionalContentGroup) pDPropertyList;
            PDOptionalContentGroup.RenderState renderState = pDOptionalContentGroup.getRenderState(this.destination);
            return renderState == null ? !getRenderer().isGroupEnabled(pDOptionalContentGroup) : PDOptionalContentGroup.RenderState.OFF.equals(renderState);
        }
        if (pDPropertyList instanceof PDOptionalContentMembershipDictionary) {
            return isHiddenOCMD((PDOptionalContentMembershipDictionary) pDPropertyList);
        }
        return false;
    }

    private boolean isHiddenOCMD(PDOptionalContentMembershipDictionary pDOptionalContentMembershipDictionary) {
        if (pDOptionalContentMembershipDictionary.getCOSObject().getCOSArray(COSName.VE) != null) {
            Log.i("PdfBox-Android", "/VE entry ignored in Optional Content Membership Dictionary");
        }
        List<PDPropertyList> oCGs = pDOptionalContentMembershipDictionary.getOCGs();
        if (oCGs.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PDPropertyList> it = oCGs.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(!isHiddenOCG(it.next())));
        }
        COSName visibilityPolicy = pDOptionalContentMembershipDictionary.getVisibilityPolicy();
        if (COSName.ANY_OFF.equals(visibilityPolicy)) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!((Boolean) it2.next()).booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        if (COSName.ALL_ON.equals(visibilityPolicy)) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (!((Boolean) it3.next()).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        if (COSName.ALL_OFF.equals(visibilityPolicy)) {
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                if (((Boolean) it4.next()).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            if (((Boolean) it5.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean isRectangular(Path path) {
        return path.isRect(new RectF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderingHints() {
        this.paint.setAntiAlias(true);
    }

    private void setStroke() {
        PDGraphicsState graphicsState = getGraphicsState();
        float fTransformWidth = transformWidth(graphicsState.getLineWidth());
        if (fTransformWidth < 0.25d) {
            fTransformWidth = 0.25f;
        }
        PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
        if (isAllZeroDash(lineDashPattern.getDashArray())) {
            return;
        }
        float phase = lineDashPattern.getPhase();
        float[] dashArray = getDashArray(lineDashPattern);
        float fTransformWidth2 = transformWidth(phase);
        this.paint.setStrokeWidth(fTransformWidth);
        this.paint.setStrokeCap(graphicsState.getLineCap());
        this.paint.setStrokeJoin(graphicsState.getLineJoin());
        float miterLimit = graphicsState.getMiterLimit();
        if (miterLimit < 1.0f) {
            Log.w("PdfBox-Android", "Miter limit must be >= 1, value " + miterLimit + " is ignored");
            miterLimit = 10.0f;
        }
        this.paint.setStrokeMiter(miterLimit);
        if (dashArray != null) {
            this.paint.setPathEffect(new DashPathEffect(dashArray, fTransformWidth2));
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void appendRectangle(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        this.linePath.moveTo(pointF.x, pointF.y);
        this.linePath.lineTo(pointF2.x, pointF2.y);
        this.linePath.lineTo(pointF3.x, pointF3.y);
        this.linePath.lineTo(pointF4.x, pointF4.y);
        this.linePath.close();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void beginMarkedContentSequence(COSName cOSName, COSDictionary cOSDictionary) {
        int i2 = this.nestedHiddenOCGCount;
        if (i2 > 0) {
            this.nestedHiddenOCGCount = i2 + 1;
        } else {
            if (cOSName == null || getPage().getResources() == null || !isHiddenOCG(getPage().getResources().getProperties(cOSName))) {
                return;
            }
            this.nestedHiddenOCGCount = 1;
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void beginText() throws IOException {
        setClip();
        beginTextClip();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void clip(Path.FillType fillType) {
        this.clipWindingRule = fillType;
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void closePath() {
        this.linePath.close();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void curveTo(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.currentPoint.set(f6, f7);
        this.linePath.cubicTo(f2, f3, f4, f5, f6, f7);
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void drawImage(PDImage pDImage) throws IOException {
        if (!((pDImage instanceof PDImageXObject) && isHiddenOCG(((PDImageXObject) pDImage).getOptionalContent())) && isContentRendered()) {
            AffineTransform affineTransformCreateAffineTransform = getGraphicsState().getCurrentTransformationMatrix().createAffineTransform();
            if (!pDImage.getInterpolate()) {
                Bitmap image = this.subsamplingAllowed ? pDImage.getImage(null, getSubsampling(pDImage, affineTransformCreateAffineTransform)) : pDImage.getImage();
                if (image.getWidth() >= Math.round(affineTransformCreateAffineTransform.getScaleX())) {
                    int i2 = (image.getHeight() > Math.round(affineTransformCreateAffineTransform.getScaleY()) ? 1 : (image.getHeight() == Math.round(affineTransformCreateAffineTransform.getScaleY()) ? 0 : -1));
                }
            }
            setClip();
            if (!pDImage.isStencil()) {
                if (this.subsamplingAllowed) {
                    drawBitmap(pDImage.getImage(null, getSubsampling(pDImage, affineTransformCreateAffineTransform)), affineTransformCreateAffineTransform);
                } else {
                    drawBitmap(pDImage.getImage(), affineTransformCreateAffineTransform);
                }
            }
            if (pDImage.getInterpolate()) {
                return;
            }
            setRenderingHints();
        }
    }

    public void drawPage(Paint paint, Canvas canvas, PDRectangle pDRectangle) throws IOException {
        this.paint = paint;
        this.canvas = canvas;
        AffineTransform affineTransform = new AffineTransform(canvas.getMatrix());
        this.xform = affineTransform;
        Matrix matrix = new Matrix(affineTransform);
        this.xformScalingFactorX = Math.abs(matrix.getScalingFactorX());
        this.xformScalingFactorY = Math.abs(matrix.getScalingFactorY());
        this.canvas.save();
        this.pageSize = pDRectangle;
        setRenderingHints();
        this.canvas.translate(0.0f, pDRectangle.getHeight());
        this.canvas.scale(1.0f, -1.0f);
        this.canvas.translate(-pDRectangle.getLowerLeftX(), -pDRectangle.getLowerLeftY());
        processPage(getPage());
        Iterator<PDAnnotation> it = getPage().getAnnotations(this.annotationFilter).iterator();
        while (it.hasNext()) {
            showAnnotation(it.next());
        }
        this.canvas.restore();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void endMarkedContentSequence() {
        int i2 = this.nestedHiddenOCGCount;
        if (i2 > 0) {
            this.nestedHiddenOCGCount = i2 - 1;
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void endPath() {
        this.linePath.reset();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void endText() throws IOException {
        endTextClip();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void fillAndStrokePath(Path.FillType fillType) throws IOException {
        Path path = new Path(this.linePath);
        fillPath(fillType);
        this.linePath = path;
        strokePath();
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void fillPath(Path.FillType fillType) throws IOException {
        getGraphicsState();
        this.paint.setColor(getNonStrokingColor());
        setClip();
        this.linePath.setFillType(fillType);
        RectF rectF = new RectF();
        this.linePath.computeBounds(rectF, true);
        boolean z = isRectangular(this.linePath) && rectF.width() > 1.0f && rectF.height() > 1.0f;
        if (z) {
            this.paint.setAntiAlias(false);
        }
        if (isContentRendered()) {
            this.paint.setStyle(Paint.Style.FILL);
            this.canvas.drawPath(this.linePath, this.paint);
        }
        this.linePath.reset();
        if (z) {
            setRenderingHints();
        }
    }

    public AnnotationFilter getAnnotationFilter() {
        return this.annotationFilter;
    }

    public final Canvas getCanvas() {
        return this.canvas;
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public PointF getCurrentPoint() {
        return this.currentPoint;
    }

    public final Path getLinePath() {
        return this.linePath;
    }

    public final int getNonStrokingColor() throws IOException {
        return getColor(getGraphicsState().getNonStrokingColor());
    }

    public final PDFRenderer getRenderer() {
        return this.renderer;
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void lineTo(float f2, float f3) {
        this.currentPoint.set(f2, f3);
        this.linePath.lineTo(f2, f3);
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void moveTo(float f2, float f3) {
        this.currentPoint.set(f2, f3);
        this.linePath.moveTo(f2, f3);
    }

    public void setAnnotationFilter(AnnotationFilter annotationFilter) {
        this.annotationFilter = annotationFilter;
    }

    public final void setClip() {
        Region currentClippingPath = getGraphicsState().getCurrentClippingPath();
        if (currentClippingPath != this.lastClip) {
            int i2 = this.lastStackSize;
            if (i2 >= 1) {
                this.canvas.restoreToCount(i2);
            }
            this.lastStackSize = this.canvas.save();
            if (!currentClippingPath.isEmpty()) {
                this.canvas.clipPath(currentClippingPath.getBoundaryPath());
            }
            this.lastClip = currentClippingPath;
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void shadingFill(COSName cOSName) throws IOException {
        RectF bounds;
        if (isContentRendered()) {
            PDShading shading = getResources().getShading(cOSName);
            if (shading == null) {
                Log.e("PdfBox-Android", "shading " + cOSName + " does not exist in resources dictionary");
                return;
            }
            Matrix currentTransformationMatrix = getGraphicsState().getCurrentTransformationMatrix();
            if (shading.getBBox() == null && (bounds = shading.getBounds(new AffineTransform(), currentTransformationMatrix)) != null) {
                bounds.union((float) Math.floor(bounds.left - 1.0f), (float) Math.floor(bounds.top - 1.0f));
                bounds.union((float) Math.ceil(bounds.right + 1.0f), (float) Math.ceil(bounds.bottom + 1.0f));
            }
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void showAnnotation(PDAnnotation pDAnnotation) throws IOException {
        this.lastClip = null;
        if (pDAnnotation.isNoView() || pDAnnotation.isHidden()) {
            return;
        }
        if ((pDAnnotation.isInvisible() && (pDAnnotation instanceof PDAnnotationUnknown)) || isHiddenOCG(pDAnnotation.getOptionalContent())) {
            return;
        }
        PDAppearanceDictionary appearance = pDAnnotation.getAppearance();
        if (appearance == null || appearance.getNormalAppearance() == null) {
            pDAnnotation.constructAppearances(this.renderer.document);
        }
        if (!pDAnnotation.isNoRotate() || getCurrentPage().getRotation() == 0) {
            super.showAnnotation(pDAnnotation);
            return;
        }
        PDRectangle rectangle = pDAnnotation.getRectangle();
        android.graphics.Matrix matrix = this.canvas.getMatrix();
        this.canvas.rotate(getCurrentPage().getRotation(), rectangle.getLowerLeftX(), rectangle.getUpperRightY());
        super.showAnnotation(pDAnnotation);
        this.canvas.setMatrix(matrix);
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void showFontGlyph(Matrix matrix, PDFont pDFont, int i2, Vector vector) throws IOException {
        AffineTransform affineTransformCreateAffineTransform = matrix.createAffineTransform();
        affineTransformCreateAffineTransform.concatenate(pDFont.getFontMatrix().createAffineTransform());
        drawGlyph2D(createGlyph2D(pDFont), pDFont, i2, vector, affineTransformCreateAffineTransform);
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void showForm(PDFormXObject pDFormXObject) throws IOException {
        if (!isHiddenOCG(pDFormXObject.getOptionalContent()) && isContentRendered()) {
            Path path = new Path(this.linePath);
            this.linePath = new Path();
            super.showForm(pDFormXObject);
            this.linePath = path;
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void showTransparencyGroup(PDTransparencyGroup pDTransparencyGroup) throws IOException {
        showTransparencyGroupOnCanvas(pDTransparencyGroup, this.canvas);
    }

    public void showTransparencyGroupOnCanvas(PDTransparencyGroup pDTransparencyGroup, Canvas canvas) throws IOException {
        if (!isHiddenOCG(pDTransparencyGroup.getOptionalContent()) && isContentRendered()) {
            new TransparencyGroup(pDTransparencyGroup, false, getGraphicsState().getCurrentTransformationMatrix(), null);
            setClip();
            new AffineTransform(this.xform).scale(1.0d / ((double) this.xformScalingFactorX), 1.0d / ((double) this.xformScalingFactorY));
            getGraphicsState().getSoftMask();
        }
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void showType3Glyph(Matrix matrix, PDType3Font pDType3Font, int i2, Vector vector) throws IOException {
        if (RenderingMode.NEITHER.equals(getGraphicsState().getTextState().getRenderingMode())) {
            return;
        }
        super.showType3Glyph(matrix, pDType3Font, i2, vector);
    }

    @Override // com.tom_roush.pdfbox.contentstream.PDFGraphicsStreamEngine
    public void strokePath() throws IOException {
        if (isContentRendered()) {
            setStroke();
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setColor(getStrokingColor());
            setClip();
            this.canvas.drawPath(this.linePath, this.paint);
        }
        this.linePath.reset();
    }

    public void setStroke(Paint paint, float f2, Paint.Cap cap, Paint.Join join, float f3, float[] fArr, float f4) {
        paint.setStrokeWidth(f2);
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f3);
        if (fArr != null) {
            paint.setPathEffect(new DashPathEffect(fArr, f4));
        }
    }
}
