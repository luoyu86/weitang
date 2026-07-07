package com.lzy.imagepicker.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;
import c.k.a.e.b;
import com.lzy.imagepicker.R;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePreviewDelActivity extends ImagePreviewBaseActivity implements View.OnClickListener {

    public class a extends ViewPager.SimpleOnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ImagePreviewDelActivity imagePreviewDelActivity = ImagePreviewDelActivity.this;
            imagePreviewDelActivity.f9392d = i2;
            imagePreviewDelActivity.f9393e.setText(imagePreviewDelActivity.getString(R.string.ip_preview_image_count, new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(ImagePreviewDelActivity.this.f9391c.size())}));
        }
    }

    public class b implements b.a {
        public b() {
        }

        @Override // c.k.a.e.b.a
        public void onNavigationBarHide(int i2) {
            ImagePreviewDelActivity.this.f9396h.setPadding(0, 0, 0, 0);
        }

        @Override // c.k.a.e.b.a
        public void onNavigationBarShow(int i2, int i3) {
            ImagePreviewDelActivity.this.f9396h.setPadding(0, 0, i3, 0);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ImagePreviewDelActivity imagePreviewDelActivity = ImagePreviewDelActivity.this;
            imagePreviewDelActivity.f9391c.remove(imagePreviewDelActivity.f9392d);
            if (ImagePreviewDelActivity.this.f9391c.size() <= 0) {
                ImagePreviewDelActivity.this.onBackPressed();
                return;
            }
            ImagePreviewDelActivity imagePreviewDelActivity2 = ImagePreviewDelActivity.this;
            imagePreviewDelActivity2.j.setData(imagePreviewDelActivity2.f9391c);
            ImagePreviewDelActivity.this.j.notifyDataSetChanged();
            ImagePreviewDelActivity imagePreviewDelActivity3 = ImagePreviewDelActivity.this;
            imagePreviewDelActivity3.f9393e.setText(imagePreviewDelActivity3.getString(R.string.ip_preview_image_count, new Object[]{Integer.valueOf(imagePreviewDelActivity3.f9392d + 1), Integer.valueOf(ImagePreviewDelActivity.this.f9391c.size())}));
        }
    }

    public final void E() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("要删除这张照片吗？");
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        builder.setPositiveButton("确定", new c());
        builder.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("extra_image_items", this.f9391c);
        setResult(1005, intent);
        finish();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_del) {
            E();
        } else if (id == R.id.btn_back) {
            onBackPressed();
        }
    }

    @Override // com.lzy.imagepicker.ui.ImagePreviewBaseActivity, com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImageView imageView = (ImageView) findViewById(R.id.btn_del);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        this.f9396h.findViewById(R.id.btn_back).setOnClickListener(this);
        this.f9393e.setText(getString(R.string.ip_preview_image_count, new Object[]{Integer.valueOf(this.f9392d + 1), Integer.valueOf(this.f9391c.size())}));
        this.f9397i.addOnPageChangeListener(new a());
        c.k.a.e.b.with(this, 2).setListener(new b());
    }

    @Override // com.lzy.imagepicker.ui.ImagePreviewBaseActivity
    public void onImageSingleTap() {
        if (this.f9396h.getVisibility() == 0) {
            this.f9396h.setAnimation(AnimationUtils.loadAnimation(this, R.anim.top_out));
            this.f9396h.setVisibility(8);
            this.f9361a.setStatusBarTintResource(0);
        } else {
            this.f9396h.setAnimation(AnimationUtils.loadAnimation(this, R.anim.top_in));
            this.f9396h.setVisibility(0);
            this.f9361a.setStatusBarTintResource(R.color.ip_color_primary_dark);
        }
    }
}
