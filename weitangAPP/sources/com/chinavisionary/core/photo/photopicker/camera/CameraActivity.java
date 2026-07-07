package com.chinavisionary.core.photo.photopicker.camera;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import anet.channel.entity.ConnType;
import c.e.a.d.l;
import c.e.a.d.n;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.core.R;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/camera/rout")
public class CameraActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e.a.b.a.f.b f6559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f6560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f6561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f6562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f6563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f6564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f6565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6566i;
    public ProgressDialog k;
    public Bitmap m;
    public boolean n;

    @Autowired(name = "isShowChangeBtn")
    public boolean p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6558a = true;
    public Handler j = new Handler();
    public int l = 5;
    public final int o = 122;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.f6559b.takePicture();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.f6559b.turnLight();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.f6559b.switchCamera();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.f6559b.reset();
            CameraActivity.this.f6565h.setVisibility(8);
            CameraActivity.this.f6561d.setVisibility(0);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity cameraActivity = CameraActivity.this;
            cameraActivity.f6566i = cameraActivity.saveToSDCard(cameraActivity.m);
            CameraActivity.this.w();
        }
    }

    public class f implements c.e.a.b.a.f.a {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraActivity.this.f6564g.setVisibility(4);
            }
        }

        public f() {
        }

        @Override // c.e.a.b.a.f.a
        public void onCameraChange(boolean z, int i2) {
            if (z) {
                CameraActivity cameraActivity = CameraActivity.this;
                if (cameraActivity.p) {
                    cameraActivity.f6563f.setVisibility(0);
                    return;
                }
            }
            CameraActivity.this.f6563f.setVisibility(8);
        }

        @Override // c.e.a.b.a.f.a
        public void onFlashLigChange(boolean z, String str) {
            if (!z) {
                CameraActivity.this.f6562e.setVisibility(8);
                return;
            }
            CameraActivity.this.f6562e.setVisibility(0);
            if (PDPrintFieldAttributeObject.CHECKED_STATE_OFF.equals(str)) {
                CameraActivity.this.f6562e.setImageResource(R.drawable.__picker_camera_flash_off);
            } else if ("torch".equals(str)) {
                CameraActivity.this.f6562e.setImageResource(R.drawable.__picker_camera_flash_on);
            } else if (ConnType.PK_AUTO.equals(str)) {
                CameraActivity.this.f6562e.setImageResource(R.drawable.__picker_camera_flash_auto);
            }
        }

        @Override // c.e.a.b.a.f.a
        public void onFocusIndex(float f2, float f3) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CameraActivity.this.f6564g.getLayoutParams());
            layoutParams.setMargins(((int) f2) - 60, ((int) f3) - 60, 0, 0);
            CameraActivity.this.f6564g.setLayoutParams(layoutParams);
            CameraActivity.this.f6564g.setVisibility(0);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            CameraActivity.this.f6564g.startAnimation(scaleAnimation);
            CameraActivity.this.j.postDelayed(new a(), 500L);
        }
    }

    public final boolean m(Context context, int i2, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions((Activity) context, (String[]) arrayList.toArray(new String[arrayList.size()]), i2);
        return false;
    }

    public final void n() {
        if (this.m == null) {
            this.f6559b.reset();
            Toast.makeText(this, R.string.camera_error, 0);
        } else {
            this.f6565h.setVisibility(0);
            this.f6561d.setVisibility(8);
        }
    }

    public final String o() {
        return UUID.randomUUID().toString() + ".jpg";
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 122) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f6565h.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        this.f6559b.reset();
        this.f6565h.setVisibility(8);
        this.f6561d.setVisibility(0);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(512, 512);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(134217728, 134217728);
            getWindow().setFlags(67108864, 67108864);
        }
        super.onCreate(bundle);
        setContentView(R.layout.__picker_activity_camera);
        ARouter.getInstance().inject(this);
        this.n = getIntent().getBooleanExtra("need_edit", false);
        u();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (this.k == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.k = progressDialog;
            progressDialog.setProgressStyle(0);
            this.k.setMessage(getString(R.string.deal_pic));
        }
        return this.k;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (x.isNullStr(this.f6566i)) {
            g.b.a.c.getDefault().post(new c.e.a.b.a.g.a());
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        boolean z = true;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (iArr[i3] == -1) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[i3]) && this.f6558a) {
                    Toast.makeText(this, "请手动打开该应用需要的权限", 0).show();
                    this.f6558a = false;
                }
                z = false;
            }
        }
        this.f6558a = true;
        if (z) {
            Log.d("onRequestPermission", "onRequestPermissionsResult: 允许所有权限");
            q();
        } else {
            Log.d("onRequestPermission", "onRequestPermissionsResult: 有权限不允许");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void p() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        q.d(getClass().getSimpleName(), "handleSurfaceHeight" + i2 + ",density:" + displayMetrics.widthPixels);
        if (i2 > 1920) {
            this.f6560c.getLayoutParams().height = (int) (displayMetrics.widthPixels * 1.7778f);
        }
    }

    public final void q() {
        t();
        s();
        r();
    }

    public final void r() {
        c.e.a.b.a.f.b bVar = new c.e.a.b.a.f.b(this, this.f6560c);
        this.f6559b = bVar;
        bVar.setCameraListener(new f());
        this.f6559b.setTakePictureCallback(new g());
        this.f6559b.create();
    }

    public final void s() {
        this.f6561d.setOnClickListener(new a());
        this.f6562e.setOnClickListener(new b());
        this.f6563f.setOnClickListener(new c());
        findViewById(R.id.delete).setOnClickListener(new d());
        findViewById(R.id.ok).setOnClickListener(new e());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        q.v(c.e.a.b.a.f.b.class.getSimpleName(), "DisplayMetric width: " + displayMetrics.widthPixels + ", height:" + displayMetrics.heightPixels + ", ro:" + (displayMetrics.widthPixels / displayMetrics.heightPixels));
    }

    public String saveToSDCard(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        return n.saveBitmapToSdCard(bitmap, l.getWtFolderPath() + File.separator + System.currentTimeMillis() + "mt.jpg");
    }

    public final void t() {
        this.f6560c = (LinearLayout) findViewById(R.id.surfaceView_container);
        this.f6561d = (Button) findViewById(R.id.takepicture);
        this.f6562e = (ImageView) findViewById(R.id.flashBtn);
        this.f6563f = (ImageView) findViewById(R.id.change);
        this.f6564g = findViewById(R.id.focus_index);
        this.f6565h = findViewById(R.id.bottom_bar);
        p();
        this.f6563f.setVisibility(this.p ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6561d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.bottomMargin = c.e.a.b.a.i.d.getNavigationBarHeight(this) + ((int) (getResources().getDisplayMetrics().density * 20.0f));
        this.f6561d.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f6565h.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        }
        layoutParams2.bottomMargin = c.e.a.b.a.i.d.getNavigationBarHeight(this) + ((int) (getResources().getDisplayMetrics().density * 20.0f));
        this.f6565h.setLayoutParams(layoutParams2);
    }

    public void toBitmap(byte[] bArr) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            Camera.Size adapterSize = this.f6559b.getAdapterSize();
            Camera.Size previewSize = this.f6559b.getPreviewSize();
            options.inSampleSize = Math.min(adapterSize.height / previewSize.height, adapterSize.width / previewSize.width);
            int i2 = this.f6559b.getisplayOrientation();
            Matrix matrix = new Matrix();
            matrix.setRotate(i2);
            this.m = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            this.m = Bitmap.createBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), 0, 0, previewSize.width, previewSize.height, matrix, true);
        } catch (Exception unused) {
        }
    }

    public final void u() {
        if (m(this, 18, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"})) {
            q();
        }
    }

    public final void v() {
        c.e.a.b.a.g.a aVar = new c.e.a.b.a.g.a();
        aVar.setPath(this.f6566i);
        g.b.a.c.getDefault().post(aVar);
    }

    public final void w() {
        if (TextUtils.isEmpty(this.f6566i)) {
            setResult(0);
            finish();
        } else {
            if (this.n) {
                l.setSavePath(this, "edit_pic", o());
                Uri.fromFile(new File(this.f6566i));
                return;
            }
            v();
            Intent intent = new Intent();
            intent.putExtra("image_path", this.f6566i);
            setResult(-1, intent);
            finish();
        }
    }

    public class g implements c.e.a.b.a.f.c {
        public g() {
        }

        @Override // c.e.a.b.a.f.c
        public void onTake(byte[] bArr) {
            CameraActivity.this.toBitmap(bArr);
            CameraActivity.this.n();
        }

        @Override // c.e.a.b.a.f.c
        public void prepareTake() {
        }

        @Override // c.e.a.b.a.f.c
        public void onTake(Bitmap bitmap) {
            CameraActivity.this.m = bitmap;
            CameraActivity.this.n();
        }
    }
}
