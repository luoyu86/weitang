package com.chinavisionary.core.photo.photopicker.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import c.e.a.b.a.i.d;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhotoPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Photo> f6554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RequestManager f6555b;

    public class a implements RequestListener<Uri, GlideDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f6556a;

        public a(ProgressBar progressBar) {
            this.f6556a = progressBar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onException(Exception exc, Uri uri, Target<GlideDrawable> target, boolean z) {
            this.f6556a.setVisibility(8);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(GlideDrawable glideDrawable, Uri uri, Target<GlideDrawable> target, boolean z, boolean z2) {
            this.f6556a.setVisibility(8);
            return false;
        }
    }

    public PhotoPagerAdapter(RequestManager requestManager, List<Photo> list) {
        this.f6554a = new ArrayList();
        this.f6554a = list;
        this.f6555b = requestManager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        Glide.clear(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f6554a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_picker_item_pager, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_pager);
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.progress_view);
        progressBar.setVisibility(0);
        this.f6555b.load(d.getUri(this.f6554a.get(i2).getPath())).thumbnail(0.1f).listener((RequestListener<? super Uri, GlideDrawable>) new a(progressBar)).dontAnimate().dontTransform().override(900, 1300).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp).into(imageView);
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
