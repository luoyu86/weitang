package com.wildma.idcardcamera.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.r.a.b.a;
import com.wildma.idcardcamera.R;

/* JADX INFO: loaded from: classes2.dex */
public class CropImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f12402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CropOverlayView f12403b;

    public CropImageView(@NonNull Context context) {
        super(context);
    }

    public void crop(a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        this.f12403b.crop(aVar, z);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f12402a.setImageBitmap(bitmap);
        this.f12403b.setBitmap(bitmap);
    }

    public CropImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.crop_image_view, (ViewGroup) this, true);
        this.f12402a = (ImageView) viewInflate.findViewById(R.id.img_crop);
        this.f12403b = (CropOverlayView) viewInflate.findViewById(R.id.overlay_crop);
    }
}
