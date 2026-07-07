package com.tom_roush.pdfbox.rendering;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.appcompat.widget.ActivityChooserView;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.PDPageTree;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode;
import com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class PDFRenderer {
    private RenderDestination defaultDestination;
    public final PDDocument document;
    private Bitmap pageImage;
    private final PDPageTree pageTree;
    private AnnotationFilter annotationFilter = new AnnotationFilter() { // from class: com.tom_roush.pdfbox.rendering.PDFRenderer.1
        @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.AnnotationFilter
        public boolean accept(PDAnnotation pDAnnotation) {
            return true;
        }
    };
    private boolean subsamplingAllowed = false;
    private float imageDownscalingOptimizationThreshold = 0.5f;

    public PDFRenderer(PDDocument pDDocument) {
        this.document = pDDocument;
        this.pageTree = pDDocument.getPages();
    }

    private boolean hasBlendMode(PDPage pDPage) {
        PDResources resources = pDPage.getResources();
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
        return false;
    }

    private void transform(Canvas canvas, PDPage pDPage, float f2, float f3) {
        float height;
        canvas.scale(f2, f3);
        int rotation = pDPage.getRotation();
        if (rotation != 0) {
            PDRectangle cropBox = pDPage.getCropBox();
            float height2 = 0.0f;
            if (rotation != 90) {
                if (rotation == 180) {
                    height2 = cropBox.getWidth();
                    height = cropBox.getHeight();
                } else if (rotation == 270) {
                    height = cropBox.getWidth();
                }
                canvas.translate(height2, height);
                canvas.rotate(rotation);
            }
            height2 = cropBox.getHeight();
            height = 0.0f;
            canvas.translate(height2, height);
            canvas.rotate(rotation);
        }
    }

    public PageDrawer createPageDrawer(PageDrawerParameters pageDrawerParameters) throws IOException {
        PageDrawer pageDrawer = new PageDrawer(pageDrawerParameters);
        pageDrawer.setAnnotationFilter(this.annotationFilter);
        return pageDrawer;
    }

    public AnnotationFilter getAnnotationsFilter() {
        return this.annotationFilter;
    }

    public RenderDestination getDefaultDestination() {
        return this.defaultDestination;
    }

    public float getImageDownscalingOptimizationThreshold() {
        return this.imageDownscalingOptimizationThreshold;
    }

    public Bitmap getPageImage() {
        return this.pageImage;
    }

    public boolean isGroupEnabled(PDOptionalContentGroup pDOptionalContentGroup) {
        PDOptionalContentProperties oCProperties = this.document.getDocumentCatalog().getOCProperties();
        return oCProperties == null || oCProperties.isGroupEnabled(pDOptionalContentGroup);
    }

    public boolean isSubsamplingAllowed() {
        return this.subsamplingAllowed;
    }

    public Bitmap renderImage(int i2) throws IOException {
        return renderImage(i2, 1.0f);
    }

    public Bitmap renderImageWithDPI(int i2, float f2) throws IOException {
        return renderImage(i2, f2 / 72.0f, ImageType.RGB);
    }

    public void renderPageToGraphics(int i2, Paint paint, Canvas canvas) throws IOException {
        renderPageToGraphics(i2, paint, canvas, 1.0f);
    }

    public void setAnnotationsFilter(AnnotationFilter annotationFilter) {
        this.annotationFilter = annotationFilter;
    }

    public void setDefaultDestination(RenderDestination renderDestination) {
        this.defaultDestination = renderDestination;
    }

    public void setImageDownscalingOptimizationThreshold(float f2) {
        this.imageDownscalingOptimizationThreshold = f2;
    }

    public void setSubsamplingAllowed(boolean z) {
        this.subsamplingAllowed = z;
    }

    public Bitmap renderImage(int i2, float f2) throws IOException {
        return renderImage(i2, f2, ImageType.RGB);
    }

    public Bitmap renderImageWithDPI(int i2, float f2, ImageType imageType) throws IOException {
        return renderImage(i2, f2 / 72.0f, imageType);
    }

    public void renderPageToGraphics(int i2, Paint paint, Canvas canvas, float f2) throws IOException {
        renderPageToGraphics(i2, paint, canvas, f2, f2);
    }

    public Bitmap renderImage(int i2, float f2, ImageType imageType) throws IOException {
        RenderDestination renderDestination = this.defaultDestination;
        if (renderDestination == null) {
            renderDestination = RenderDestination.EXPORT;
        }
        return renderImage(i2, f2, imageType, renderDestination);
    }

    public void renderPageToGraphics(int i2, Paint paint, Canvas canvas, float f2, float f3) throws IOException {
        RenderDestination renderDestination = this.defaultDestination;
        if (renderDestination == null) {
            renderDestination = RenderDestination.VIEW;
        }
        renderPageToGraphics(i2, paint, canvas, f2, f3, renderDestination);
    }

    public Bitmap renderImage(int i2, float f2, ImageType imageType, RenderDestination renderDestination) throws IOException {
        Bitmap.Config bitmapConfig;
        Bitmap bitmapCreateBitmap;
        PDPage pDPage = this.pageTree.get(i2);
        PDRectangle cropBox = pDPage.getCropBox();
        float width = cropBox.getWidth();
        float height = cropBox.getHeight();
        int iMax = (int) Math.max(Math.floor(width * f2), 1.0d);
        int iMax2 = (int) Math.max(Math.floor(height * f2), 1.0d);
        if (((long) iMax) * ((long) iMax2) <= 2147483647L) {
            int rotation = pDPage.getRotation();
            ImageType imageType2 = ImageType.ARGB;
            if (imageType != imageType2 && hasBlendMode(pDPage)) {
                bitmapConfig = Bitmap.Config.ARGB_8888;
            } else {
                bitmapConfig = imageType.toBitmapConfig();
            }
            if (rotation != 90 && rotation != 270) {
                bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, bitmapConfig);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iMax2, iMax, bitmapConfig);
            }
            this.pageImage = bitmapCreateBitmap;
            Paint paint = new Paint();
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            if (imageType == imageType2) {
                paint.setColor(0);
            } else {
                paint.setColor(-1);
            }
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), paint);
            paint.reset();
            transform(canvas, pDPage, f2, f2);
            createPageDrawer(new PageDrawerParameters(this, pDPage, this.subsamplingAllowed, renderDestination, this.imageDownscalingOptimizationThreshold)).drawPage(paint, canvas, pDPage.getCropBox());
            if (bitmapCreateBitmap.getConfig() == imageType.toBitmapConfig()) {
                return bitmapCreateBitmap;
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), imageType.toBitmapConfig());
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            canvas2.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), paint);
            canvas2.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
            return bitmapCreateBitmap2;
        }
        throw new IOException("Maximum size of image exceeded (w * h * scale ^ 2) = " + width + " * " + height + " * " + f2 + " ^ 2 > " + ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void renderPageToGraphics(int i2, Paint paint, Canvas canvas, float f2, float f3, RenderDestination renderDestination) throws IOException {
        PDPage pDPage = this.pageTree.get(i2);
        transform(canvas, pDPage, f2, f3);
        PDRectangle cropBox = pDPage.getCropBox();
        canvas.drawRect(0.0f, 0.0f, cropBox.getWidth(), cropBox.getHeight(), paint);
        createPageDrawer(new PageDrawerParameters(this, pDPage, this.subsamplingAllowed, renderDestination, this.imageDownscalingOptimizationThreshold)).drawPage(paint, canvas, cropBox);
    }
}
