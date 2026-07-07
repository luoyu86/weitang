package com.lzy.imagepicker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.lzy.imagepicker.R;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class CropImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f9403a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f9404b;
    public double A;
    public float B;
    public int C;
    public float D;
    public boolean E;
    public boolean F;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e[] f9405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9411i;
    public e j;
    public Paint k;
    public Path l;
    public RectF m;
    public int n;
    public int o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9412q;
    public Matrix r;
    public Matrix s;
    public PointF t;
    public PointF u;
    public PointF v;
    public PointF w;
    public PointF x;
    public int y;
    public long z;

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f9413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap.CompressFormat f9414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ File f9415c;

        public a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file) {
            this.f9413a = bitmap;
            this.f9414b = compressFormat;
            this.f9415c = file;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            CropImageView.this.o(this.f9413a, this.f9414b, this.f9415c);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f9417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap.CompressFormat f9418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OutputStream f9419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ File f9420d;

        public b(Bitmap bitmap, Bitmap.CompressFormat compressFormat, OutputStream outputStream, File file) {
            this.f9417a = bitmap;
            this.f9418b = compressFormat;
            this.f9419c = outputStream;
            this.f9420d = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9417a.compress(this.f9418b, 90, this.f9419c);
            Message.obtain(CropImageView.f9403a, 1001, this.f9420d).sendToTarget();
            this.f9417a.recycle();
        }
    }

    public static class c extends Handler {
        public c() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file = (File) message.obj;
            int i2 = message.what;
            if (i2 == 1001) {
                if (CropImageView.f9404b != null) {
                    CropImageView.f9404b.onBitmapSaveSuccess(file);
                }
            } else if (i2 == 1002 && CropImageView.f9404b != null) {
                CropImageView.f9404b.onBitmapSaveError(file);
            }
        }
    }

    public interface d {
        void onBitmapSaveError(File file);

        void onBitmapSaveSuccess(File file);
    }

    public enum e {
        RECTANGLE,
        CIRCLE
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private RectF getImageMatrixRect() {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        this.r.mapRect(rectF);
        return rectF;
    }

    public final File g(File file, String str, String str2) {
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        try {
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new File(file, str + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date(System.currentTimeMillis())) + str2);
    }

    public float getBorderWidth() {
        return this.f9408f;
    }

    public Bitmap getCropBitmap(int i2, int i3, boolean z) {
        if (i2 <= 0 || i3 < 0) {
            return null;
        }
        return m(rotate(((BitmapDrawable) getDrawable()).getBitmap(), this.C * 90), this.m, getImageMatrixRect(), i2, i3, z);
    }

    public int getFocusColor() {
        return this.f9407e;
    }

    public int getFocusHeight() {
        return this.f9410h;
    }

    public e getFocusStyle() {
        return this.j;
    }

    public int getFocusWidth() {
        return this.f9409g;
    }

    public int getMaskColor() {
        return this.f9406d;
    }

    public final void h(float f2, float f3) {
        float[] fArr = new float[9];
        this.r.getValues(fArr);
        float fAbs = Math.abs(fArr[0]) + Math.abs(fArr[1]);
        float fK = k(this.p, this.f9412q, this.f9409g, this.f9410h, true);
        float f4 = this.D;
        if (fAbs < f4) {
            float fMin = Math.min(fK + fAbs, f4) / fAbs;
            this.r.postScale(fMin, fMin, f2, f3);
        } else {
            float f5 = fK / fAbs;
            this.r.postScale(f5, f5, f2, f3);
            j();
        }
        setImageMatrix(this.r);
    }

    public final void i() {
        float[] fArr = new float[9];
        this.r.getValues(fArr);
        float fAbs = Math.abs(fArr[0]) + Math.abs(fArr[1]);
        float fK = k(this.p, this.f9412q, this.f9409g, this.f9410h, true);
        float f2 = 4.0f * fK;
        this.D = f2;
        if (fAbs < fK) {
            float f3 = fK / fAbs;
            this.r.postScale(f3, f3);
        } else if (fAbs > f2) {
            float f4 = f2 / fAbs;
            this.r.postScale(f4, f4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001b A[PHI: r1 r4
  0x001b: PHI (r1v7 float) = (r1v3 float), (r1v4 float) binds: [B:3:0x0019, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]
  0x001b: PHI (r4v4 float) = (r4v0 float), (r4v1 float) binds: [B:3:0x0019, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            r7 = this;
            android.graphics.RectF r0 = new android.graphics.RectF
            int r1 = r7.n
            float r1 = (float) r1
            int r2 = r7.o
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
            android.graphics.Matrix r1 = r7.r
            r1.mapRect(r0)
            float r1 = r0.left
            android.graphics.RectF r2 = r7.m
            float r4 = r2.left
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L1e
        L1b:
            float r1 = -r1
            float r1 = r1 + r4
            goto L28
        L1e:
            float r1 = r0.right
            float r4 = r2.right
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 >= 0) goto L27
            goto L1b
        L27:
            r1 = 0
        L28:
            float r4 = r0.top
            float r5 = r2.top
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 <= 0) goto L34
            float r0 = -r4
            float r3 = r0 + r5
            goto L3f
        L34:
            float r0 = r0.bottom
            float r2 = r2.bottom
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L3f
            float r0 = -r0
            float r3 = r0 + r2
        L3f:
            android.graphics.Matrix r0 = r7.r
            r0.postTranslate(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lzy.imagepicker.view.CropImageView.j():void");
    }

    public final float k(int i2, int i3, int i4, int i5, boolean z) {
        float f2 = i4 / i2;
        float f3 = i5 / i3;
        if (z) {
            if (f2 > f3) {
                return f2;
            }
        } else if (f2 < f3) {
            return f2;
        }
        return f3;
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (!this.E || drawable == null) {
            return;
        }
        this.y = 0;
        this.r = getImageMatrix();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.p = intrinsicWidth;
        this.n = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f9412q = intrinsicHeight;
        this.o = intrinsicHeight;
        int width = getWidth();
        int height = getHeight();
        this.x = new PointF(width / 2.0f, height / 2.0f);
        if (this.j == e.CIRCLE) {
            int iMin = Math.min(this.f9409g, this.f9410h);
            this.f9409g = iMin;
            this.f9410h = iMin;
        }
        RectF rectF = this.m;
        PointF pointF = this.x;
        float f2 = pointF.x;
        int i2 = this.f9409g;
        rectF.left = f2 - (i2 / 2.0f);
        rectF.right = f2 + (i2 / 2.0f);
        float f3 = pointF.y;
        int i3 = this.f9410h;
        rectF.top = f3 - (i3 / 2.0f);
        rectF.bottom = f3 + (i3 / 2.0f);
        float fK = k(this.n, this.o, i2, i3, true);
        this.D = 4.0f * fK;
        float fK2 = k(this.n, this.o, width, height, false);
        if (fK2 > fK) {
            fK = fK2;
        }
        this.r.setScale(fK, fK, this.n / 2.0f, this.o / 2.0f);
        float[] fArr = new float[9];
        this.r.getValues(fArr);
        PointF pointF2 = this.x;
        this.r.postTranslate(pointF2.x - (fArr[2] + ((this.n * fArr[0]) / 2.0f)), pointF2.y - (fArr[5] + ((this.o * fArr[4]) / 2.0f)));
        setImageMatrix(this.r);
        invalidate();
    }

    public final Bitmap m(Bitmap bitmap, RectF rectF, RectF rectF2, int i2, int i3, boolean z) {
        if (rectF2 == null || bitmap == null) {
            return null;
        }
        float fWidth = rectF2.width() / bitmap.getWidth();
        int i4 = (int) ((rectF.left - rectF2.left) / fWidth);
        int i5 = (int) ((rectF.top - rectF2.top) / fWidth);
        int iWidth = (int) (rectF.width() / fWidth);
        int iHeight = (int) (rectF.height() / fWidth);
        if (i4 < 0) {
            i4 = 0;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i4 + iWidth > bitmap.getWidth()) {
            iWidth = bitmap.getWidth() - i4;
        }
        if (i5 + iHeight > bitmap.getHeight()) {
            iHeight = bitmap.getHeight() - i5;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i4, i5, iWidth, iHeight);
            if (i2 == iWidth && i3 == iHeight) {
                return bitmapCreateBitmap;
            }
            bitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i2, i3, true);
            if (this.j != e.CIRCLE || z) {
                return bitmap;
            }
            int iMin = Math.min(i2, i3);
            int i6 = iMin / 2;
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap2);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            Paint paint = new Paint();
            paint.setShader(bitmapShader);
            canvas.drawCircle(i2 / 2.0f, i3 / 2.0f, i6, paint);
            return bitmapCreateBitmap2;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public final float n() {
        float[] fArr = new float[9];
        this.r.getValues(fArr);
        return this.D / (Math.abs(fArr[0]) + Math.abs(fArr[1]));
    }

    public final void o(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file) {
        try {
            OutputStream outputStreamOpenOutputStream = getContext().getContentResolver().openOutputStream(Uri.fromFile(file));
            if (outputStreamOpenOutputStream != null) {
                new Thread(new b(bitmap, compressFormat, outputStreamOpenOutputStream, file)).start();
            }
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            Message.obtain(f9403a, 1002, file).sendToTarget();
            bitmap.recycle();
        }
        this.F = false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e eVar = e.RECTANGLE;
        e eVar2 = this.j;
        if (eVar == eVar2) {
            this.l.addRect(this.m, Path.Direction.CCW);
            canvas.save();
            canvas.clipRect(0, 0, getWidth(), getHeight());
            canvas.clipPath(this.l, Region.Op.DIFFERENCE);
            canvas.drawColor(this.f9406d);
            canvas.restore();
        } else if (e.CIRCLE == eVar2) {
            RectF rectF = this.m;
            float fMin = Math.min((rectF.right - rectF.left) / 2.0f, (rectF.bottom - rectF.top) / 2.0f);
            Path path = this.l;
            PointF pointF = this.x;
            path.addCircle(pointF.x, pointF.y, fMin, Path.Direction.CCW);
            canvas.save();
            canvas.clipRect(0, 0, getWidth(), getHeight());
            canvas.clipPath(this.l, Region.Op.DIFFERENCE);
            canvas.drawColor(this.f9406d);
            canvas.restore();
        }
        this.k.setColor(this.f9407e);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(this.f9408f);
        this.k.setAntiAlias(true);
        canvas.drawPath(this.l, this.k);
        this.l.reset();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.E = true;
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0248  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instruction units count: 771
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lzy.imagepicker.view.CropImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final float p(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    public final float q(PointF pointF, PointF pointF2) {
        return p(pointF.x, pointF.y, pointF2.x, pointF2.y);
    }

    public Bitmap rotate(Bitmap bitmap, int i2) {
        if (i2 != 0 && bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap != bitmapCreateBitmap) {
                    return bitmapCreateBitmap;
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return bitmap;
    }

    public void saveBitmapToFile(File file, int i2, int i3, boolean z) {
        if (this.F) {
            return;
        }
        this.F = true;
        Bitmap cropBitmap = getCropBitmap(i2, i3, z);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        File fileG = g(file, "IMG_", ".jpg");
        if (this.j == e.CIRCLE && !z) {
            compressFormat = Bitmap.CompressFormat.PNG;
            fileG = g(file, "IMG_", ".png");
        }
        new a(cropBitmap, compressFormat, fileG).start();
    }

    public void setBorderColor(int i2) {
        this.f9407e = i2;
        invalidate();
    }

    public void setBorderWidth(int i2) {
        this.f9408f = i2;
        invalidate();
    }

    public void setFocusHeight(int i2) {
        this.f9410h = i2;
        l();
    }

    public void setFocusStyle(e eVar) {
        this.j = eVar;
        invalidate();
    }

    public void setFocusWidth(int i2) {
        this.f9409g = i2;
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l();
    }

    public void setMaskColor(int i2) {
        this.f9406d = i2;
        invalidate();
    }

    public void setOnBitmapSaveCompleteListener(d dVar) {
        f9404b = dVar;
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e[] eVarArr = {e.RECTANGLE, e.CIRCLE};
        this.f9405c = eVarArr;
        this.f9406d = -1358954496;
        this.f9407e = -1434419072;
        this.f9408f = 1;
        this.f9409g = 250;
        this.f9410h = 250;
        this.f9411i = 0;
        this.j = eVarArr[0];
        this.k = new Paint();
        this.l = new Path();
        this.m = new RectF();
        this.r = new Matrix();
        this.s = new Matrix();
        this.t = new PointF();
        this.u = new PointF();
        this.v = new PointF();
        this.w = new PointF();
        this.x = new PointF();
        this.y = 0;
        this.z = 0L;
        this.A = 0.0d;
        this.B = 1.0f;
        this.C = 0;
        this.D = 4.0f;
        this.E = false;
        this.F = false;
        this.f9409g = (int) TypedValue.applyDimension(1, this.f9409g, getResources().getDisplayMetrics());
        this.f9410h = (int) TypedValue.applyDimension(1, this.f9410h, getResources().getDisplayMetrics());
        this.f9408f = (int) TypedValue.applyDimension(1, this.f9408f, getResources().getDisplayMetrics());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView);
        this.f9406d = typedArrayObtainStyledAttributes.getColor(R.styleable.CropImageView_cropMaskColor, this.f9406d);
        this.f9407e = typedArrayObtainStyledAttributes.getColor(R.styleable.CropImageView_cropBorderColor, this.f9407e);
        this.f9408f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropImageView_cropBorderWidth, this.f9408f);
        this.f9409g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropImageView_cropFocusWidth, this.f9409g);
        this.f9410h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CropImageView_cropFocusHeight, this.f9410h);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.CropImageView_cropStyle, this.f9411i);
        this.f9411i = integer;
        this.j = this.f9405c[integer];
        typedArrayObtainStyledAttributes.recycle();
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
