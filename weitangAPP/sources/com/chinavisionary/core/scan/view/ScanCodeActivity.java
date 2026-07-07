package com.chinavisionary.core.scan.view;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import c.e.a.c.a.c;
import c.e.a.c.b.f;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.t;
import c.e.b.c.d.d;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.core.scan.EventScanResultVo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class ScanCodeActivity extends CoreBaseActivity implements SurfaceHolder.Callback, View.OnClickListener {
    public c.e.a.c.b.a l;
    public ViewfinderView m;
    public TextView n;
    public boolean o;
    public Vector<BarcodeFormat> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f6661q;
    public f r;
    public MediaPlayer s;
    public boolean t;
    public boolean u;
    public ImageView v;
    public CameraManager x;
    public final MediaPlayer.OnCompletionListener k = new a();
    public boolean w = false;

    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k0() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 18);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    public void drawViewfinder() {
        this.m.drawViewfinder();
    }

    public final void f0() {
        try {
            this.v.setImageResource(R.drawable.ic_off_flush);
            c.get().offLight();
            if (Build.VERSION.SDK_INT >= 23) {
                this.x.setTorchMode("0", false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g0(SurfaceView surfaceView) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        q.d(getClass().getSimpleName(), "handleSurfaceHeight" + i2 + ",density:" + displayMetrics.widthPixels);
        if (i2 > 1920) {
            surfaceView.getLayoutParams().height = (int) (displayMetrics.widthPixels * 1.7778f);
        }
    }

    public Handler getHandler() {
        return this.l;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_scan_code;
    }

    public ViewfinderView getViewfinderView() {
        return this.m;
    }

    public final void h0() {
        if (this.t && this.s == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.s = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.s.setOnCompletionListener(this.k);
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.s.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                this.s.setVolume(0.1f, 0.1f);
                this.s.prepare();
            } catch (IOException unused) {
                this.s = null;
            }
        }
    }

    public void handleDecode(Result result, Bitmap bitmap) {
        f fVar = this.r;
        if (fVar != null) {
            fVar.onActivity();
        }
        r0(result.getText());
    }

    public final void i0(SurfaceHolder surfaceHolder) {
        try {
            c.get().openDriver(surfaceHolder);
            c.e.a.c.b.a aVar = this.l;
            if (aVar == null) {
                this.l = new c.e.a.c.b.a(this, this.p, this.f6661q);
            } else {
                aVar.resetCamera();
                this.l.restartPreviewAndDecode();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (RuntimeException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        this.m = (ViewfinderView) findViewById(R.id.scanCode_vv_finder);
        this.n = (TextView) findViewById(R.id.tv_permission_info);
        c.init(getApplication());
        this.r = new f(this);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_scan_code_local_pic).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.btn_scan_code_switch_light);
        this.v = imageView;
        imageView.setOnClickListener(this);
        findViewById(R.id.toolbar_menu_select_pic).setOnClickListener(this);
    }

    public final void l0() {
        try {
            this.v.setImageResource(R.drawable.ic_on_flush);
            c.get().openLight();
            if (Build.VERSION.SDK_INT >= 23) {
                this.x.setTorchMode("0", true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void m0(int i2) {
        c.k.a.a aVar = c.k.a.a.getInstance();
        if (i2 <= 0) {
            i2 = 1;
        }
        aVar.setSelectLimit(i2);
        c.k.a.a.getInstance().clear();
        Intent intent = new Intent(this, (Class<?>) ImageGridActivity.class);
        intent.putExtra("is_scan_key", true);
        startActivityForResult(intent, 1000);
    }

    public final void n0() {
        this.o = false;
        c.e.a.c.b.a aVar = this.l;
        if (aVar != null) {
            aVar.quitSynchronously();
            this.l = null;
        }
        c.get().closeDriver();
    }

    public final void o0() {
        MediaPlayer mediaPlayer;
        if (this.t && (mediaPlayer = this.s) != null) {
            mediaPlayer.start();
        }
        if (this.u) {
            ((Vibrator) getSystemService("vibrator")).vibrate(200L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 1004 && intent != null && i2 == 1000) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("extra_result_items");
            if (o.isNotEmpty(arrayList)) {
                r0(t.decodeQrToPath(((ImageItem) arrayList.get(0)).path));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        if (id != R.id.btn_scan_code_switch_light) {
            if (id == R.id.btn_scan_code_local_pic) {
                m0(1);
            }
        } else if (this.w) {
            this.w = false;
            f0();
        } else {
            this.w = true;
            l0();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f fVar = this.r;
        if (fVar != null) {
            fVar.shutdown();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (18 == i2) {
            boolean z = false;
            if (strArr == null || strArr.length <= 0 || iArr == null || iArr.length <= 0) {
                z = true;
            } else {
                for (int i3 : iArr) {
                    if (i3 == -1) {
                        break;
                    }
                }
                z = true;
            }
            if (z) {
                this.o = true;
                q0();
                return;
            }
            String str = Build.MANUFACTURER;
            Locale locale = Locale.ROOT;
            if (str.toLowerCase(locale).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) || str.toLowerCase(locale).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
                return;
            }
            p0();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != -1) {
            q0();
        } else {
            p0();
        }
        q.d(getClass().getSimpleName(), "on start");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (isFinishing()) {
            n0();
            f fVar = this.r;
            if (fVar != null) {
                fVar.shutdown();
            }
            this.r = null;
            c.get().stopPreview();
        }
        q.d(getClass().getSimpleName(), "on stop");
    }

    public final void p0() {
        this.n.setVisibility(0);
        new Thread(new Runnable() { // from class: c.e.a.c.c.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1172a.k0();
            }
        }).start();
    }

    public final void q0() {
        if (this.r == null) {
            this.r = new f(this);
        }
        if (this.x == null) {
            this.x = (CameraManager) getSystemService(d.SOURCE_TYPE_CAMERA);
        }
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.scanCode_sv_preview);
        g0(surfaceView);
        SurfaceHolder holder = surfaceView.getHolder();
        q.d(getClass().getSimpleName(), "hasSurface:" + this.o);
        if (this.o) {
            i0(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
            holder.setKeepScreenOn(true);
        }
        this.p = null;
        this.f6661q = null;
        this.t = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.t = false;
        }
        h0();
        this.u = true;
        this.n.setVisibility(8);
    }

    public final void r0(String str) {
        o0();
        if (!TextUtils.isEmpty(str)) {
            EventScanResultVo eventScanResultVo = new EventScanResultVo();
            eventScanResultVo.setResult(str);
            g.b.a.c.getDefault().post(eventScanResultVo);
        }
        finish();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.o) {
            return;
        }
        this.o = true;
        i0(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
