package com.lzy.imagepicker.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import c.k.a.a;
import com.lzy.imagepicker.R;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.view.CropImageView;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCropActivity extends ImageBaseActivity implements View.OnClickListener, CropImageView.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CropImageView f9362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f9363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<ImageItem> f9367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f9368h;

    public int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i5 > i3 || i4 > i2) {
            return i4 > i5 ? i4 / i2 : i5 / i3;
        }
        return 1;
    }

    @Override // com.lzy.imagepicker.view.CropImageView.d
    public void onBitmapSaveError(File file) {
    }

    @Override // com.lzy.imagepicker.view.CropImageView.d
    public void onBitmapSaveSuccess(File file) {
        this.f9367g.remove(0);
        ImageItem imageItem = new ImageItem();
        imageItem.path = file.getAbsolutePath();
        this.f9367g.add(imageItem);
        Intent intent = new Intent();
        intent.putExtra("extra_result_items", this.f9367g);
        setResult(1004, intent);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            setResult(0);
            finish();
        } else if (id == R.id.btn_ok) {
            this.f9362b.saveBitmapToFile(this.f9368h.getCropCacheFolder(this), this.f9365e, this.f9366f, this.f9364d);
        }
    }

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_crop);
        this.f9368h = a.getInstance();
        findViewById(R.id.btn_back).setOnClickListener(this);
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setText(getString(R.string.ip_complete));
        button.setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_des)).setText(getString(R.string.ip_photo_crop));
        CropImageView cropImageView = (CropImageView) findViewById(R.id.cv_crop_image);
        this.f9362b = cropImageView;
        cropImageView.setOnBitmapSaveCompleteListener(this);
        this.f9365e = this.f9368h.getOutPutX();
        this.f9366f = this.f9368h.getOutPutY();
        this.f9364d = this.f9368h.isSaveRectangle();
        ArrayList<ImageItem> selectedImages = this.f9368h.getSelectedImages();
        this.f9367g = selectedImages;
        String str = selectedImages.get(0).path;
        this.f9362b.setFocusStyle(this.f9368h.getStyle());
        this.f9362b.setFocusWidth(this.f9368h.getFocusWidth());
        this.f9362b.setFocusHeight(this.f9368h.getFocusHeight());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        options.inSampleSize = calculateInSampleSize(options, displayMetrics.widthPixels, displayMetrics.heightPixels);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        this.f9363c = bitmapDecodeFile;
        CropImageView cropImageView2 = this.f9362b;
        cropImageView2.setImageBitmap(cropImageView2.rotate(bitmapDecodeFile, c.k.a.e.a.getBitmapDegree(str)));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f9362b.setOnBitmapSaveCompleteListener(null);
        Bitmap bitmap = this.f9363c;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f9363c.recycle();
        this.f9363c = null;
    }
}
