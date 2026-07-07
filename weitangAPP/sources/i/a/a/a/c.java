package i.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import i.a.a.a.d;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    boolean canZoom();

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    c getIPhotoViewImplementation();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    d.f getOnPhotoTapListener();

    d.h getOnViewTapListener();

    float getScale();

    ImageView.ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    void setAllowParentInterceptOnEdge(boolean z);

    boolean setDisplayMatrix(Matrix matrix);

    @Deprecated
    void setMaxScale(float f2);

    void setMaximumScale(float f2);

    void setMediumScale(float f2);

    @Deprecated
    void setMidScale(float f2);

    @Deprecated
    void setMinScale(float f2);

    void setMinimumScale(float f2);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(d.e eVar);

    void setOnPhotoTapListener(d.f fVar);

    void setOnScaleChangeListener(d.g gVar);

    void setOnViewTapListener(d.h hVar);

    void setPhotoViewRotation(float f2);

    void setRotationBy(float f2);

    void setRotationTo(float f2);

    void setScale(float f2);

    void setScale(float f2, float f3, float f4, boolean z);

    void setScale(float f2, boolean z);

    void setScaleLevels(float f2, float f3, float f4);

    void setScaleType(ImageView.ScaleType scaleType);

    void setZoomTransitionDuration(int i2);

    void setZoomable(boolean z);
}
