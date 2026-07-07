package com.lzy.imagepicker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import c.k.a.a;
import c.k.a.e.b;
import com.lzy.imagepicker.R;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.view.SuperCheckBox;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePreviewActivity extends ImagePreviewBaseActivity implements a.InterfaceC0039a, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public boolean l;
    public SuperCheckBox m;
    public SuperCheckBox n;
    public Button o;
    public View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f9385q;

    public class a extends ViewPager.SimpleOnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            imagePreviewActivity.f9392d = i2;
            int size = imagePreviewActivity.f9391c.size();
            ImagePreviewActivity imagePreviewActivity2 = ImagePreviewActivity.this;
            if (size <= imagePreviewActivity2.f9392d) {
                imagePreviewActivity2.f9392d = imagePreviewActivity2.f9391c.size() - 1;
            }
            ImagePreviewActivity imagePreviewActivity3 = ImagePreviewActivity.this;
            if (imagePreviewActivity3.f9392d < 0) {
                imagePreviewActivity3.f9392d = 0;
            }
            ImagePreviewActivity.this.m.setChecked(ImagePreviewActivity.this.f9390b.isSelect(imagePreviewActivity3.f9391c.get(imagePreviewActivity3.f9392d)));
            ImagePreviewActivity imagePreviewActivity4 = ImagePreviewActivity.this;
            imagePreviewActivity4.f9393e.setText(imagePreviewActivity4.getString(R.string.ip_preview_image_count, new Object[]{Integer.valueOf(imagePreviewActivity4.f9392d + 1), Integer.valueOf(ImagePreviewActivity.this.f9391c.size())}));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = ImagePreviewActivity.this.f9391c.size();
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            if (size <= imagePreviewActivity.f9392d) {
                imagePreviewActivity.f9392d = imagePreviewActivity.f9391c.size() - 1;
            }
            ImagePreviewActivity imagePreviewActivity2 = ImagePreviewActivity.this;
            if (imagePreviewActivity2.f9392d < 0) {
                imagePreviewActivity2.f9392d = 0;
            }
            ImageItem imageItem = imagePreviewActivity2.f9391c.get(imagePreviewActivity2.f9392d);
            int selectLimit = ImagePreviewActivity.this.f9390b.getSelectLimit();
            if (!ImagePreviewActivity.this.m.isChecked() || ImagePreviewActivity.this.f9394f.size() < selectLimit) {
                ImagePreviewActivity imagePreviewActivity3 = ImagePreviewActivity.this;
                imagePreviewActivity3.f9390b.addSelectedImageItem(imagePreviewActivity3.f9392d, imageItem, imagePreviewActivity3.m.isChecked());
            } else {
                ImagePreviewActivity imagePreviewActivity4 = ImagePreviewActivity.this;
                Toast.makeText(imagePreviewActivity4, imagePreviewActivity4.getString(R.string.ip_select_limit, new Object[]{Integer.valueOf(selectLimit)}), 0).show();
                ImagePreviewActivity.this.m.setChecked(false);
            }
        }
    }

    public class c implements b.a {
        public c() {
        }

        @Override // c.k.a.e.b.a
        public void onNavigationBarHide(int i2) {
            ImagePreviewActivity.this.f9385q.setVisibility(8);
        }

        @Override // c.k.a.e.b.a
        public void onNavigationBarShow(int i2, int i3) {
            ImagePreviewActivity.this.f9385q.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = ImagePreviewActivity.this.f9385q.getLayoutParams();
            if (layoutParams.height == 0) {
                layoutParams.height = c.k.a.e.d.getNavigationBarHeight(ImagePreviewActivity.this);
                ImagePreviewActivity.this.f9385q.requestLayout();
            }
        }
    }

    public class d implements b.a {
        public d() {
        }

        @Override // c.k.a.e.b.a
        public void onNavigationBarHide(int i2) {
            ImagePreviewActivity.this.f9396h.setPadding(0, 0, 0, 0);
            ImagePreviewActivity.this.p.setPadding(0, 0, 0, 0);
        }

        @Override // c.k.a.e.b.a
        public void onNavigationBarShow(int i2, int i3) {
            ImagePreviewActivity.this.f9396h.setPadding(0, 0, i3, 0);
            ImagePreviewActivity.this.p.setPadding(0, 0, i3, 0);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.cb_origin) {
            if (!z) {
                this.l = false;
                this.n.setText(getString(R.string.ip_origin));
                return;
            }
            long j = 0;
            Iterator<ImageItem> it = this.f9394f.iterator();
            while (it.hasNext()) {
                j += it.next().size;
            }
            String fileSize = Formatter.formatFileSize(this, j);
            this.l = true;
            this.n.setText(getString(R.string.ip_origin_size, new Object[]{fileSize}));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_ok) {
            if (id == R.id.btn_back) {
                finish();
                return;
            }
            return;
        }
        if (this.f9390b.getSelectedImages().size() == 0) {
            this.m.setChecked(true);
            this.f9390b.addSelectedImageItem(this.f9392d, this.f9391c.get(this.f9392d), this.m.isChecked());
        }
        Intent intent = new Intent();
        intent.putExtra("extra_result_items", this.f9390b.getSelectedImages());
        setResult(1004, intent);
        finish();
    }

    @Override // com.lzy.imagepicker.ui.ImagePreviewBaseActivity, com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getIntent().getBooleanExtra("isOrigin", false);
        this.f9390b.addOnImageSelectedListener(this);
        Button button = (Button) findViewById(R.id.btn_ok);
        this.o = button;
        button.setVisibility(0);
        this.o.setOnClickListener(this);
        View viewFindViewById = findViewById(R.id.bottom_bar);
        this.p = viewFindViewById;
        viewFindViewById.setVisibility(0);
        this.m = (SuperCheckBox) findViewById(R.id.cb_check);
        this.n = (SuperCheckBox) findViewById(R.id.cb_origin);
        this.f9385q = findViewById(R.id.margin_bottom);
        this.n.setText(getString(R.string.ip_origin));
        this.n.setOnCheckedChangeListener(this);
        this.n.setChecked(this.l);
        onImageSelected(0, null, false);
        boolean zIsSelect = this.f9390b.isSelect(this.f9391c.get(this.f9392d));
        this.f9393e.setText(getString(R.string.ip_preview_image_count, new Object[]{Integer.valueOf(this.f9392d + 1), Integer.valueOf(this.f9391c.size())}));
        this.m.setChecked(zIsSelect);
        this.f9397i.addOnPageChangeListener(new a());
        this.m.setOnClickListener(new b());
        c.k.a.e.b.with(this).setListener(new c());
        c.k.a.e.b.with(this, 2).setListener(new d());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f9390b.removeOnImageSelectedListener(this);
        super.onDestroy();
    }

    @Override // c.k.a.a.InterfaceC0039a
    public void onImageSelected(int i2, ImageItem imageItem, boolean z) {
        if (this.f9390b.getSelectImageCount() > 0) {
            this.o.setText(getString(R.string.ip_select_complete, new Object[]{Integer.valueOf(this.f9390b.getSelectImageCount()), Integer.valueOf(this.f9390b.getSelectLimit())}));
        } else {
            this.o.setText(getString(R.string.ip_complete));
        }
        if (this.n.isChecked()) {
            long j = 0;
            Iterator<ImageItem> it = this.f9394f.iterator();
            while (it.hasNext()) {
                j += it.next().size;
            }
            this.n.setText(getString(R.string.ip_origin_size, new Object[]{Formatter.formatFileSize(this, j)}));
        }
    }

    @Override // com.lzy.imagepicker.ui.ImagePreviewBaseActivity
    public void onImageSingleTap() {
        if (this.f9396h.getVisibility() == 0) {
            this.f9396h.setAnimation(AnimationUtils.loadAnimation(this, R.anim.top_out));
            this.p.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));
            this.f9396h.setVisibility(8);
            this.p.setVisibility(8);
            this.f9361a.setStatusBarTintResource(0);
            return;
        }
        this.f9396h.setAnimation(AnimationUtils.loadAnimation(this, R.anim.top_in));
        this.p.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
        this.f9396h.setVisibility(0);
        this.p.setVisibility(0);
        this.f9361a.setStatusBarTintResource(R.color.ip_color_primary_dark);
    }
}
