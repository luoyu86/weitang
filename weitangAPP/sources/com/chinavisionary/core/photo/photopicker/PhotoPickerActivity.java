package com.chinavisionary.core.photo.photopicker;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import c.e.a.b.a.i.c;
import c.e.a.b.a.i.d;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import com.chinavisionary.core.photo.photopicker.fragment.ImagePagerFragment;
import com.chinavisionary.core.photo.photopicker.fragment.PhotoPickerFragment;
import com.chinavisionary.core.photo.photopicker.widget.Titlebar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhotoPickerActivity extends FragmentActivity implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PhotoPickerFragment f6530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImagePagerFragment f6531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Titlebar f6532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6533d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<Photo> selectedList = c.e.a.b.a.i.c.getHelper().getSelectedList();
            if (selectedList == null || selectedList.size() <= 0) {
                Toast.makeText(PhotoPickerActivity.this.getApplicationContext(), PhotoPickerActivity.this.getString(R.string.__picker_no_photo), 0).show();
            } else {
                c.e.a.b.a.i.c.getHelper().finishPick(false);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPickerActivity.this.onBackPressed();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoPickerActivity.this.f6531b != null && PhotoPickerActivity.this.f6531b.isAdded()) {
                PhotoPickerActivity.this.f6532c.getTvLeft().setVisibility(8);
                PhotoPickerActivity.this.getSupportFragmentManager().beginTransaction().remove(PhotoPickerActivity.this.f6531b).commit();
            }
            PhotoPickerActivity.this.f6531b = null;
            PhotoPickerActivity.this.F(0.8f, 1.0f);
        }
    }

    public final void E() {
        if (this.f6530a == null) {
            this.f6530a = new PhotoPickerFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container_grid, this.f6530a, "tag").commit();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    public final void F(float f2, float f3) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(this.f6532c);
        objectAnimator.setDuration(200L);
        objectAnimator.setPropertyName("alpha");
        objectAnimator.setFloatValues(f2, f3);
        objectAnimator.start();
    }

    public final void G(int i2) {
        int maxCount = c.e.a.b.a.b.getCurrentPhotoPicker().getMaxCount();
        if (maxCount <= 1) {
            this.f6532c.getTvRight().setText(R.string.__picker_done);
        } else {
            this.f6532c.getTvRight().setText(getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(i2), Integer.valueOf(maxCount)}));
        }
    }

    public final void H() {
        if (Build.VERSION.SDK_INT >= 19) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6533d.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, d.getStateBarHeight(this));
            }
            layoutParams.height = d.getStateBarHeight(this);
            this.f6533d.setLayoutParams(layoutParams);
        }
        c.e.a.b.a.d config = c.e.a.b.a.i.c.getHelper().getConfig();
        if (config == null || config.getStatusColor() == Integer.MAX_VALUE) {
            return;
        }
        this.f6533d.setBackgroundColor(config.getStatusColor());
    }

    public final void I() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6532c.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, d.getActionBarHeight(this));
        }
        layoutParams.topMargin = d.getStateBarHeight(this);
        this.f6532c.setLayoutParams(layoutParams);
        this.f6532c.getTvRight().setOnClickListener(new a());
        this.f6532c.getIvLeft().setOnClickListener(new b());
        G(c.e.a.b.a.i.c.getHelper().getSelectedList().size());
    }

    public void addImagePagerFragment() {
        this.f6531b = new ImagePagerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container_page, this.f6531b).addToBackStack(null).commit();
        F(1.0f, 0.8f);
        this.f6532c.bringToFront();
        this.f6532c.getTvLeft().setVisibility(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        ImagePagerFragment imagePagerFragment = this.f6531b;
        if (imagePagerFragment != null && imagePagerFragment.isVisible()) {
            this.f6531b.runExitAnimation(new c());
        } else if (c.e.a.b.a.i.c.getHelper() != null) {
            c.e.a.b.a.i.c.getHelper().finishPick(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        getWindow().setFlags(512, 512);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(134217728, 134217728);
            getWindow().setFlags(67108864, 67108864);
        }
        super.onCreate(bundle);
        setContentView(R.layout.__picker_activity_photo_picker);
        c.e.a.b.a.i.c.getHelper().addSelectedChangeListener(this);
        Titlebar titlebar = (Titlebar) findViewById(R.id.titlebar);
        this.f6532c = titlebar;
        titlebar.init(this);
        this.f6533d = findViewById(R.id.status_bg_view);
        I();
        H();
        E();
        c.e.a.b.a.i.c.getHelper().addActivity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (c.e.a.b.a.i.c.getHelper() != null) {
            c.e.a.b.a.i.c.getHelper().removeSelectedChangeListener(this);
            c.e.a.b.a.i.c.getHelper().removeActivity(this);
        }
        PhotoPickerFragment photoPickerFragment = this.f6530a;
        if (photoPickerFragment != null) {
            photoPickerFragment.clearDirectories();
        }
        c.e.a.b.a.b.b(false);
    }

    @Override // c.e.a.b.a.i.c.a
    public void selectedCount(int i2) {
        G(i2);
    }

    public void setTvLeft(int i2) {
        this.f6532c.getTvLeft().setText(i2 + " / " + c.e.a.b.a.i.c.getHelper().getCurrentPagePhotos().size());
    }
}
