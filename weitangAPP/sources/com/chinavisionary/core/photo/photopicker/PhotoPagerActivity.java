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
import com.chinavisionary.core.photo.photopicker.widget.Titlebar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhotoPagerActivity extends FragmentActivity implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImagePagerFragment f6522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e.a.b.a.c f6523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.e.a.b.a.i.c f6524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Titlebar f6526e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int currentItem = PhotoPagerActivity.this.f6522a.getmViewPager().getCurrentItem();
            Photo photo = PhotoPagerActivity.this.f6523b.getPhotos().get(currentItem);
            PhotoPagerActivity.this.f6523b.getPhotos().remove(photo);
            PhotoPagerActivity.this.f6522a.getmPagerAdapter().notifyDataSetChanged();
            if (currentItem > 0) {
                PhotoPagerActivity.this.f6522a.getmViewPager().setCurrentItem(currentItem - 1);
            }
            if (currentItem > 0) {
                PhotoPagerActivity.this.setTvLeft(currentItem);
            }
            if (PhotoPagerActivity.this.f6523b.getOnPhotoDeleteListener() != null) {
                PhotoPagerActivity.this.f6523b.getOnPhotoDeleteListener().onPhotoDelete(photo.getPath());
            }
            if (PhotoPagerActivity.this.f6523b.getPhotos().isEmpty()) {
                PhotoPagerActivity.this.f6524c.finishPick(false);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<Photo> selectedList = c.e.a.b.a.i.c.getHelper().getSelectedList();
            if (selectedList == null || selectedList.size() <= 0) {
                Toast.makeText(PhotoPagerActivity.this.getApplicationContext(), PhotoPagerActivity.this.getString(R.string.__picker_no_photo), 0).show();
            } else {
                c.e.a.b.a.i.c.getHelper().finishPick(false);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.e.a.b.a.i.c.getHelper().finishPick(true);
        }
    }

    public final void E() {
        if (this.f6522a == null) {
            ImagePagerFragment imagePagerFragment = (ImagePagerFragment) getSupportFragmentManager().findFragmentById(R.id.photoPagerFragment);
            this.f6522a = imagePagerFragment;
            imagePagerFragment.setEditDismiss();
        }
    }

    public final void F(float f2, float f3) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(this.f6526e);
        objectAnimator.setDuration(200L);
        objectAnimator.setPropertyName("alpha");
        objectAnimator.setFloatValues(f2, f3);
        objectAnimator.start();
    }

    public final void G() {
        if (Build.VERSION.SDK_INT >= 19) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6525d.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, d.getStateBarHeight(this));
            }
            layoutParams.height = d.getStateBarHeight(this);
            this.f6525d.setLayoutParams(layoutParams);
        }
        c.e.a.b.a.d config = c.e.a.b.a.i.c.getHelper().getConfig();
        if (config == null || config.getStatusColor() == Integer.MAX_VALUE) {
            return;
        }
        this.f6525d.setBackgroundColor(config.getStatusColor());
    }

    public final void H() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6526e.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, d.getActionBarHeight(this));
        }
        layoutParams.topMargin = d.getStateBarHeight(this);
        this.f6526e.setLayoutParams(layoutParams);
        this.f6526e.setTitle("");
        if (this.f6523b.isPreviewOnly()) {
            this.f6526e.getTvRight().setVisibility(8);
        } else if (this.f6523b.isShowDelete()) {
            this.f6526e.getTvLeft().setVisibility(8);
            this.f6526e.getTvRight().setVisibility(8);
            this.f6526e.getIvRight().setVisibility(0);
            this.f6526e.getIvRight().setOnClickListener(new a());
        } else {
            this.f6526e.getTvRight().setVisibility(0);
            this.f6526e.getIvRight().setVisibility(8);
            I();
            this.f6526e.getTvRight().setOnClickListener(new b());
        }
        this.f6526e.getIvLeft().setOnClickListener(new c());
        this.f6526e.getTvLeft().setVisibility(0);
    }

    public final void I() {
        if (this.f6523b.getMaxCount() <= 1) {
            this.f6526e.getTvRight().setText(R.string.__picker_done);
        } else {
            this.f6526e.getTvRight().setText(getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(this.f6524c.getSelectedList().size()), Integer.valueOf(this.f6523b.getMaxCount())}));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (c.e.a.b.a.i.c.getHelper() == null) {
            super.onBackPressed();
        } else if (c.e.a.b.a.i.c.getHelper().getActivities().size() > 1) {
            super.onBackPressed();
        } else {
            c.e.a.b.a.i.c.getHelper().finishPick(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(512, 512);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(134217728, 134217728);
            getWindow().setFlags(67108864, 67108864);
        }
        super.onCreate(bundle);
        setContentView(R.layout.__picker_activity_photo_pager);
        E();
        this.f6523b = c.e.a.b.a.c.getCurrentPhotoPreview();
        c.e.a.b.a.i.c helper = c.e.a.b.a.i.c.getHelper();
        this.f6524c = helper;
        helper.addSelectedChangeListener(this);
        Titlebar titlebar = (Titlebar) findViewById(R.id.titlebar);
        this.f6526e = titlebar;
        titlebar.init(this);
        this.f6525d = findViewById(R.id.status_bg_view);
        F(1.0f, 0.8f);
        H();
        G();
        this.f6524c.addActivity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (c.e.a.b.a.i.c.getHelper() != null) {
            this.f6524c.removeSelectedChangeListener(this);
            this.f6524c.removeActivity(this);
        }
        c.e.a.b.a.c.a(false);
    }

    @Override // c.e.a.b.a.i.c.a
    public void selectedCount(int i2) {
        if (this.f6523b.getMaxCount() > 1) {
            this.f6526e.getTvRight().setText(getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f6523b.getMaxCount())}));
        }
    }

    public void setTvLeft(int i2) {
        this.f6526e.getTvLeft().setText(i2 + " / " + this.f6523b.getPhotos().size());
    }
}
