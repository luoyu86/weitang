package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import i.a.a.a.c;
import i.a.a.a.d;

/* JADX INFO: loaded from: classes3.dex */
public class PhotoView extends ImageView implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f14999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView.ScaleType f15000b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public void a() {
        d dVar = this.f14999a;
        if (dVar == null || dVar.getImageView() == null) {
            this.f14999a = new d(this);
        }
        ImageView.ScaleType scaleType = this.f15000b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f15000b = null;
        }
    }

    @Override // i.a.a.a.c
    public boolean canZoom() {
        return this.f14999a.canZoom();
    }

    @Override // i.a.a.a.c
    public Matrix getDisplayMatrix() {
        return this.f14999a.getDisplayMatrix();
    }

    @Override // i.a.a.a.c
    public RectF getDisplayRect() {
        return this.f14999a.getDisplayRect();
    }

    @Override // i.a.a.a.c
    public c getIPhotoViewImplementation() {
        return this.f14999a;
    }

    @Override // i.a.a.a.c
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // i.a.a.a.c
    public float getMaximumScale() {
        return this.f14999a.getMaximumScale();
    }

    @Override // i.a.a.a.c
    public float getMediumScale() {
        return this.f14999a.getMediumScale();
    }

    @Override // i.a.a.a.c
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // i.a.a.a.c
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // i.a.a.a.c
    public float getMinimumScale() {
        return this.f14999a.getMinimumScale();
    }

    @Override // i.a.a.a.c
    public d.f getOnPhotoTapListener() {
        return this.f14999a.getOnPhotoTapListener();
    }

    @Override // i.a.a.a.c
    public d.h getOnViewTapListener() {
        return this.f14999a.getOnViewTapListener();
    }

    @Override // i.a.a.a.c
    public float getScale() {
        return this.f14999a.getScale();
    }

    @Override // android.widget.ImageView, i.a.a.a.c
    public ImageView.ScaleType getScaleType() {
        return this.f14999a.getScaleType();
    }

    @Override // i.a.a.a.c
    public Bitmap getVisibleRectangleBitmap() {
        return this.f14999a.getVisibleRectangleBitmap();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.f14999a.cleanup();
        super.onDetachedFromWindow();
    }

    @Override // i.a.a.a.c
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f14999a.setAllowParentInterceptOnEdge(z);
    }

    @Override // i.a.a.a.c
    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f14999a.setDisplayMatrix(matrix);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.f14999a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        d dVar = this.f14999a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.f14999a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // i.a.a.a.c
    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    @Override // i.a.a.a.c
    public void setMaximumScale(float f2) {
        this.f14999a.setMaximumScale(f2);
    }

    @Override // i.a.a.a.c
    public void setMediumScale(float f2) {
        this.f14999a.setMediumScale(f2);
    }

    @Override // i.a.a.a.c
    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    @Override // i.a.a.a.c
    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    @Override // i.a.a.a.c
    public void setMinimumScale(float f2) {
        this.f14999a.setMinimumScale(f2);
    }

    @Override // i.a.a.a.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f14999a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, i.a.a.a.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14999a.setOnLongClickListener(onLongClickListener);
    }

    @Override // i.a.a.a.c
    public void setOnMatrixChangeListener(d.e eVar) {
        this.f14999a.setOnMatrixChangeListener(eVar);
    }

    @Override // i.a.a.a.c
    public void setOnPhotoTapListener(d.f fVar) {
        this.f14999a.setOnPhotoTapListener(fVar);
    }

    @Override // i.a.a.a.c
    public void setOnScaleChangeListener(d.g gVar) {
        this.f14999a.setOnScaleChangeListener(gVar);
    }

    @Override // i.a.a.a.c
    public void setOnViewTapListener(d.h hVar) {
        this.f14999a.setOnViewTapListener(hVar);
    }

    @Override // i.a.a.a.c
    public void setPhotoViewRotation(float f2) {
        this.f14999a.setRotationTo(f2);
    }

    @Override // i.a.a.a.c
    public void setRotationBy(float f2) {
        this.f14999a.setRotationBy(f2);
    }

    @Override // i.a.a.a.c
    public void setRotationTo(float f2) {
        this.f14999a.setRotationTo(f2);
    }

    @Override // i.a.a.a.c
    public void setScale(float f2) {
        this.f14999a.setScale(f2);
    }

    @Override // i.a.a.a.c
    public void setScaleLevels(float f2, float f3, float f4) {
        this.f14999a.setScaleLevels(f2, f3, f4);
    }

    @Override // android.widget.ImageView, i.a.a.a.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.f14999a;
        if (dVar != null) {
            dVar.setScaleType(scaleType);
        } else {
            this.f15000b = scaleType;
        }
    }

    @Override // i.a.a.a.c
    public void setZoomTransitionDuration(int i2) {
        this.f14999a.setZoomTransitionDuration(i2);
    }

    @Override // i.a.a.a.c
    public void setZoomable(boolean z) {
        this.f14999a.setZoomable(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // i.a.a.a.c
    public void setScale(float f2, boolean z) {
        this.f14999a.setScale(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        a();
    }

    @Override // i.a.a.a.c
    public void setScale(float f2, float f3, float f4, boolean z) {
        this.f14999a.setScale(f2, f3, f4, z);
    }
}
