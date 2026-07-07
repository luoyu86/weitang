package i.a.a.a;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class b implements GestureDetector.OnDoubleTapListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f14886a;

    public b(d dVar) {
        setPhotoViewAttacher(dVar);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.f14886a;
        if (dVar == null) {
            return false;
        }
        try {
            float scale = dVar.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.f14886a.getMediumScale()) {
                d dVar2 = this.f14886a;
                dVar2.setScale(dVar2.getMediumScale(), x, y, true);
            } else if (scale < this.f14886a.getMediumScale() || scale >= this.f14886a.getMaximumScale()) {
                d dVar3 = this.f14886a;
                dVar3.setScale(dVar3.getMinimumScale(), x, y, true);
            } else {
                d dVar4 = this.f14886a;
                dVar4.setScale(dVar4.getMaximumScale(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        d dVar = this.f14886a;
        if (dVar == null) {
            return false;
        }
        ImageView imageView = dVar.getImageView();
        if (this.f14886a.getOnPhotoTapListener() != null && (displayRect = this.f14886a.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.contains(x, y)) {
                this.f14886a.getOnPhotoTapListener().onPhotoTap(imageView, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.f14886a.getOnViewTapListener() != null) {
            this.f14886a.getOnViewTapListener().onViewTap(imageView, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    public void setPhotoViewAttacher(d dVar) {
        this.f14886a = dVar;
    }
}
