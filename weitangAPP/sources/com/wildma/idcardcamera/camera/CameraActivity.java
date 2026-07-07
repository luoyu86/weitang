package com.wildma.idcardcamera.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import c.r.a.d.e;
import com.alibaba.android.arouter.utils.Consts;
import com.wildma.idcardcamera.R;
import com.wildma.idcardcamera.cropper.CropImageView;

/* JADX INFO: loaded from: classes2.dex */
public class CameraActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CropImageView f12377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f12378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CameraPreview f12379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f12380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f12381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f12382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f12383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f12384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f12385i;
    public FrameLayout j;
    public View k;
    public int l;
    public boolean m = true;

    public class a implements Runnable {

        /* JADX INFO: renamed from: com.wildma.idcardcamera.camera.CameraActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0230a implements Runnable {
            public RunnableC0230a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraActivity.this.f12379c.setVisibility(0);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraActivity.this.runOnUiThread(new RunnableC0230a());
        }
    }

    public class b implements Camera.PreviewCallback {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Camera.Size f12389a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ byte[] f12390b;

            public a(Camera.Size size, byte[] bArr) {
                this.f12389a = size;
                this.f12390b = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Camera.Size size = this.f12389a;
                CameraActivity.this.i(c.r.a.d.c.getBitmapFromByte(this.f12390b, size.width, size.height));
            }
        }

        public b() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            camera.stopPreview();
            new Thread(new a(previewSize, bArr)).start();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraActivity.this.f12377a.setLayoutParams(new LinearLayout.LayoutParams(CameraActivity.this.f12381e.getWidth(), CameraActivity.this.f12381e.getHeight()));
            CameraActivity.this.n();
            CameraActivity.this.f12377a.setImageBitmap(CameraActivity.this.f12378b);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f12393a;

        public d(Bitmap bitmap) {
            this.f12393a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string;
            String str = c.r.a.c.a.f3155b;
            if (c.r.a.d.b.createOrExistsDir(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                if (CameraActivity.this.l == 1) {
                    stringBuffer.append(str);
                    stringBuffer.append("MicroTang");
                    stringBuffer.append(Consts.DOT);
                    stringBuffer.append("idCardFrontCrop.jpg");
                    string = stringBuffer.toString();
                } else if (CameraActivity.this.l == 2) {
                    stringBuffer.append(str);
                    stringBuffer.append("MicroTang");
                    stringBuffer.append(Consts.DOT);
                    stringBuffer.append("idCardBackCrop.jpg");
                    string = stringBuffer.toString();
                } else {
                    string = "";
                }
                if (c.r.a.d.c.save(this.f12393a, string, Bitmap.CompressFormat.JPEG)) {
                    Intent intent = new Intent();
                    intent.putExtra("image_path", string);
                    CameraActivity.this.setResult(17, intent);
                    CameraActivity.this.finish();
                }
            }
        }
    }

    public final void h() {
        Bitmap bitmap = this.f12378b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        m(this.f12378b);
    }

    public final void i(Bitmap bitmap) {
        float width = this.k.getWidth() - 120;
        float top = this.f12381e.getTop() - 120;
        float right = this.f12381e.getRight() + width + 240;
        float bottom = this.f12381e.getBottom() + 120;
        if (top <= 0.0f) {
            width = this.k.getWidth();
            top = this.f12381e.getTop();
            right = this.f12381e.getRight() + width;
            bottom = this.f12381e.getBottom();
        }
        float width2 = width / this.f12379c.getWidth();
        float height = top / this.f12379c.getHeight();
        float bottom2 = bottom / this.f12379c.getBottom();
        int width3 = (int) (bitmap.getWidth() * width2);
        int width4 = (int) (((right / this.f12379c.getWidth()) - width2) * bitmap.getWidth());
        int width5 = bitmap.getWidth();
        if (width3 + width4 > width5) {
            width3 = 0;
            width4 = width5;
        }
        this.f12378b = Bitmap.createBitmap(bitmap, width3, (int) (bitmap.getHeight() * height), width4, (int) ((bottom2 - height) * bitmap.getHeight()));
        Log.d(getClass().getSimpleName(), "crop bitmap width:" + this.f12378b.getWidth() + ", height:" + this.f12378b.getHeight());
        runOnUiThread(new c());
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void j() {
        setContentView(R.layout.activity_camera);
        this.l = getIntent().getIntExtra("take_type", 0);
        setRequestedOrientation(0);
        l();
        k();
    }

    public final void k() {
        this.f12379c.setOnClickListener(this);
        this.f12382f.setOnClickListener(this);
        findViewById(R.id.iv_camera_close).setOnClickListener(this);
        findViewById(R.id.iv_camera_take).setOnClickListener(this);
        findViewById(R.id.iv_camera_result_ok).setOnClickListener(this);
        findViewById(R.id.iv_camera_result_cancel).setOnClickListener(this);
    }

    public final void l() {
        this.f12379c = (CameraPreview) findViewById(R.id.camera_preview);
        this.f12380d = findViewById(R.id.ll_camera_crop_container);
        this.f12381e = (ImageView) findViewById(R.id.iv_camera_crop);
        this.f12382f = (ImageView) findViewById(R.id.iv_camera_flash);
        this.f12383g = findViewById(R.id.ll_camera_option);
        this.f12384h = findViewById(R.id.ll_camera_result);
        this.f12377a = (CropImageView) findViewById(R.id.crop_image_view);
        this.f12385i = (TextView) findViewById(R.id.view_camera_crop_bottom);
        this.j = (FrameLayout) findViewById(R.id.fl_camera_option);
        this.k = findViewById(R.id.view_camera_crop_left);
        float fMin = (int) (((double) Math.min(e.getScreenWidth(this), e.getScreenHeight(this))) * 0.75d);
        float f2 = (int) ((75.0f * fMin) / 47.0f);
        float fMax = (Math.max(e.getScreenWidth(this), e.getScreenHeight(this)) - f2) / 2.0f;
        int i2 = (int) f2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, (int) fMin);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) fMax, -1);
        this.f12380d.setLayoutParams(layoutParams);
        this.f12381e.setLayoutParams(layoutParams2);
        this.j.setLayoutParams(layoutParams3);
        int i3 = this.l;
        if (i3 == 1) {
            this.f12381e.setImageResource(R.mipmap.camera_idcard_front);
        } else if (i3 == 2) {
            this.f12381e.setImageResource(R.mipmap.camera_idcard_back);
        }
        new Handler().postDelayed(new a(), 500L);
    }

    public final void m(Bitmap bitmap) {
        if (bitmap == null) {
            Toast.makeText(getApplicationContext(), getString(R.string.crop_fail), 0).show();
            finish();
        }
        new Thread(new d(bitmap)).start();
    }

    public final void n() {
        this.f12381e.setVisibility(8);
        this.f12379c.setVisibility(8);
        this.f12383g.setVisibility(8);
        this.f12377a.setVisibility(0);
        this.f12384h.setVisibility(0);
        this.f12385i.setText("");
    }

    public final void o() {
        this.f12381e.setVisibility(0);
        this.f12379c.setVisibility(0);
        this.f12383g.setVisibility(0);
        this.f12377a.setVisibility(8);
        this.f12384h.setVisibility(8);
        this.f12385i.setText(getString(R.string.touch_to_focus));
        this.f12379c.focus();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.camera_preview) {
            this.f12379c.focus();
            return;
        }
        if (id == R.id.iv_camera_close) {
            finish();
            return;
        }
        if (id == R.id.iv_camera_take) {
            if (c.r.a.d.a.isFastClick()) {
                return;
            }
            p();
            return;
        }
        if (id == R.id.iv_camera_flash) {
            if (!c.r.a.a.b.hasFlash(this)) {
                Toast.makeText(this, R.string.no_flash, 0).show();
                return;
            } else {
                this.f12382f.setImageResource(this.f12379c.switchFlashLight() ? R.mipmap.camera_flash_on : R.mipmap.camera_flash_off);
                return;
            }
        }
        if (id == R.id.iv_camera_result_ok) {
            h();
            return;
        }
        if (id == R.id.iv_camera_result_cancel) {
            this.f12379c.setEnabled(true);
            this.f12379c.addCallback();
            this.f12379c.startPreview();
            this.f12382f.setImageResource(R.mipmap.camera_flash_off);
            o();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (c.r.a.d.d.checkPermissionFirst(this, 18, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"})) {
            j();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        boolean z = true;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (iArr[i3] == -1) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[i3]) && this.m) {
                    Toast.makeText(this, "请手动打开该应用需要的权限", 0).show();
                    this.m = false;
                }
                z = false;
            }
        }
        this.m = true;
        if (z) {
            Log.d("onRequestPermission", "onRequestPermissionsResult: 允许所有权限");
            j();
        } else {
            Log.d("onRequestPermission", "onRequestPermissionsResult: 有权限不允许");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        CameraPreview cameraPreview = this.f12379c;
        if (cameraPreview != null) {
            cameraPreview.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        CameraPreview cameraPreview = this.f12379c;
        if (cameraPreview != null) {
            cameraPreview.onStop();
        }
    }

    public final void p() {
        this.f12379c.setEnabled(false);
        c.r.a.a.b.getCamera().setOneShotPreviewCallback(new b());
    }
}
