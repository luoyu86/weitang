package c.e.a.d.c0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/* JADX INFO: loaded from: classes.dex */
public class c extends BitmapTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1192a;

    public c(Context context) {
        this(context, 4);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float f2 = this.f1192a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        return bitmapCreateBitmap;
    }

    @Override // com.bumptech.glide.load.Transformation
    public String getId() {
        return c.class.getName() + Math.round(this.f1192a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return a(bitmapPool, bitmap);
    }

    public c(Context context, int i2) {
        super(context);
        this.f1192a = 0.0f;
        this.f1192a = Resources.getSystem().getDisplayMetrics().density * i2;
    }
}
