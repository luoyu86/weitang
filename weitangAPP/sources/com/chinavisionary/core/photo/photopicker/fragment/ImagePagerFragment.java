package com.chinavisionary.core.photo.photopicker.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import c.e.a.b.a.i.c;
import c.e.a.d.l;
import c.n.a.a;
import c.n.a.h;
import com.bumptech.glide.Glide;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.PhotoPagerActivity;
import com.chinavisionary.core.photo.photopicker.PhotoPickerActivity;
import com.chinavisionary.core.photo.photopicker.adapter.PhotoPagerAdapter;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class ImagePagerFragment extends Fragment implements c.b, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6577a = 110;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f6578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PhotoPagerAdapter f6579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6580d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f6582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f6583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c.e.a.b.a.i.c f6584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.e.a.b.a.c f6585i;
    public float j;
    public float k;
    public int l;
    public int m;
    public TextView n;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ImagePagerFragment.this.f6578b.getViewTreeObserver().removeOnPreDrawListener(this);
            ImagePagerFragment.this.j();
            ImagePagerFragment.this.k();
            return true;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Photo photo = ImagePagerFragment.this.f6585i.getPhotos().get(ImagePagerFragment.this.f6578b.getCurrentItem());
            ImagePagerFragment.this.f6582f.setSelected(photo.isSelected());
            ImagePagerFragment.this.m(i2);
            ImagePagerFragment.this.n.setEnabled(photo.isSelected());
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Photo photo = ImagePagerFragment.this.f6585i.getPhotos().get(ImagePagerFragment.this.f6578b.getCurrentItem());
            ImagePagerFragment.this.f6584h.toggleSelection(ImagePagerFragment.this.getActivity(), photo);
            ImagePagerFragment.this.f6582f.setSelected(photo.isSelected());
            ImagePagerFragment.this.n.setEnabled(photo.isSelected());
        }
    }

    public class e implements a.InterfaceC0045a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f6590a;

        public e(Runnable runnable) {
            this.f6590a = runnable;
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationCancel(c.n.a.a aVar) {
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationEnd(c.n.a.a aVar) {
            this.f6590a.run();
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationRepeat(c.n.a.a aVar) {
        }

        @Override // c.n.a.a.InterfaceC0045a
        public void onAnimationStart(c.n.a.a aVar) {
        }
    }

    public PhotoPagerAdapter getmPagerAdapter() {
        return this.f6579c;
    }

    public ViewPager getmViewPager() {
        return this.f6578b;
    }

    public final String i() {
        return UUID.randomUUID().toString() + ".jpg";
    }

    public final void j() {
        this.j = ((this.f6578b.getWidth() / 3.0f) / this.f6578b.getWidth()) * 2.0f;
        this.k = ((this.f6578b.getHeight() / 3.0f) / this.f6578b.getHeight()) * 2.0f;
        this.l = (this.f6578b.getWidth() / 3) / 2;
        this.m = (this.f6578b.getHeight() / 3) / 2;
    }

    public final void k() {
        c.n.c.a.setPivotX(this.f6578b, 0.0f);
        c.n.c.a.setPivotY(this.f6578b, 0.0f);
        c.n.c.a.setScaleX(this.f6578b, this.j);
        c.n.c.a.setScaleY(this.f6578b, this.k);
        c.n.c.a.setTranslationX(this.f6578b, this.l);
        c.n.c.a.setTranslationY(this.f6578b, this.m);
        c.n.c.a.setAlpha(this.f6578b, 0.0f);
        c.n.c.b.animate(this.f6578b).setDuration(200L).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).alpha(255.0f).setInterpolator(new DecelerateInterpolator());
        h hVarOfInt = h.ofInt(this.f6578b.getBackground(), "alpha", 0, 255);
        hVarOfInt.setDuration(200L);
        hVarOfInt.start();
    }

    public final void l() {
        c.e.a.b.a.d config = c.e.a.b.a.i.c.getHelper().getConfig();
        if (config != null) {
            this.f6582f.setImageResource(config.getImageSelectorRes());
            this.f6583g.setTextColor(config.getChooseTextColor());
            this.f6583g.setTextSize(1, config.getChooseTextSize());
            View view = this.f6581e;
            if (view != null) {
                view.setBackgroundColor(config.getBottomBarColor());
            }
        }
    }

    public final void m(int i2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof PhotoPickerActivity) {
                ((PhotoPickerActivity) activity).setTvLeft(i2 + 1);
            } else if (activity instanceof PhotoPagerActivity) {
                ((PhotoPagerActivity) activity).setTvLeft(i2 + 1);
            }
        }
    }

    public final void n() {
        if (this.f6585i.isShowDelete()) {
            this.f6581e.setVisibility(8);
            return;
        }
        View view = this.f6581e;
        if (view != null) {
            view.setVisibility(this.f6585i.isPreviewOnly() ? 8 : 0);
            this.f6581e.setOnClickListener(new c());
        }
        this.f6582f.setSelected(this.f6585i.getPhotos().get(this.f6580d).isSelected());
        this.f6582f.setOnClickListener(new d());
    }

    public final void o() {
        this.f6578b.setAdapter(this.f6579c);
        this.f6578b.setCurrentItem(this.f6580d);
        this.f6578b.setOffscreenPageLimit(5);
        this.f6578b.addOnPageChangeListener(new b());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.e("edit_path", "onActivityResult ");
        if (i2 == f6577a) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.pager_edit_text || this.f6578b == null) {
            return;
        }
        l.setSavePath(getActivity(), "edit_pic", i());
        Uri.fromFile(new File(this.f6585i.getPhotos().get(this.f6578b.getCurrentItem()).getPath()));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6585i = c.e.a.b.a.c.getCurrentPhotoPreview();
        View viewInflate = layoutInflater.inflate(R.layout.__picker_picker_fragment_image_pager, viewGroup, false);
        this.f6585i = c.e.a.b.a.c.getCurrentPhotoPreview();
        c.e.a.b.a.i.c helper = c.e.a.b.a.i.c.getHelper();
        this.f6584h = helper;
        helper.addStateChangeListener(this);
        this.f6580d = this.f6585i.getCurrentPos();
        this.f6579c = new PhotoPagerAdapter(Glide.with(getActivity()), this.f6585i.getPhotos());
        if (Build.VERSION.SDK_INT >= 19) {
            View viewFindViewById = viewInflate.findViewById(R.id.bottom_nav);
            int navigationBarHeight = c.e.a.b.a.i.d.getNavigationBarHeight(getActivity());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, navigationBarHeight);
            }
            layoutParams.height = navigationBarHeight;
            viewFindViewById.setLayoutParams(layoutParams);
        }
        ViewPager viewPager = (ViewPager) viewInflate.findViewById(R.id.vp_photos);
        this.f6578b = viewPager;
        viewPager.getViewTreeObserver().addOnPreDrawListener(new a());
        o();
        this.f6581e = viewInflate.findViewById(R.id.check_view);
        this.f6582f = (ImageView) viewInflate.findViewById(R.id.v_selected);
        TextView textView = (TextView) viewInflate.findViewById(R.id.pager_edit_text);
        this.n = textView;
        textView.setOnClickListener(this);
        this.f6583g = (TextView) viewInflate.findViewById(R.id.pager_check_text);
        n();
        l();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f6584h.removeStateChangeListener(this);
        ViewPager viewPager = this.f6578b;
        if (viewPager != null) {
            viewPager.setAdapter(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m(this.f6578b.getCurrentItem());
    }

    @Override // c.e.a.b.a.i.c.b
    public void onSelectedChanged(Photo photo) {
        if (photo.equals(this.f6585i.getPhotos().get(this.f6578b.getCurrentItem()))) {
            this.f6582f.setSelected(photo.isSelected());
        }
    }

    public void runExitAnimation(Runnable runnable) {
        c.n.c.b.animate(this.f6578b).setDuration(200L).setInterpolator(new AccelerateInterpolator()).scaleX(this.j).scaleY(this.k).translationX(this.l).translationY(this.m).alpha(0.0f).setListener(new e(runnable));
        h hVarOfInt = h.ofInt(this.f6578b.getBackground(), "alpha", 255, 0);
        hVarOfInt.setDuration(200L);
        hVarOfInt.start();
    }

    public void setEditDismiss() {
        this.n.setVisibility(8);
    }
}
