package com.lzy.imagepicker.adapter;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.lzy.imagepicker.bean.ImageItem;
import i.a.a.a.d;
import java.util.ArrayList;
import uk.co.senab.photoview.PhotoView;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePageAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.k.a.a f9336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<ImageItem> f9337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Activity f9338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f9339f;

    public class a implements d.f {
        public a() {
        }

        @Override // i.a.a.a.d.f
        public void onPhotoTap(View view, float f2, float f3) {
            b bVar = ImagePageAdapter.this.f9339f;
            if (bVar != null) {
                bVar.OnPhotoTapListener(view, f2, f3);
            }
        }
    }

    public interface b {
        void OnPhotoTapListener(View view, float f2, float f3);
    }

    public ImagePageAdapter(Activity activity, ArrayList<ImageItem> arrayList) {
        this.f9338e = activity;
        this.f9337d = arrayList;
        DisplayMetrics screenPix = c.k.a.e.d.getScreenPix(activity);
        this.f9334a = screenPix.widthPixels;
        this.f9335b = screenPix.heightPixels;
        this.f9336c = c.k.a.a.getInstance();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        try {
            PhotoView photoView = (PhotoView) obj;
            this.f9336c.getImageLoader().clearImageViewCache(photoView);
            viewGroup.removeView(photoView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.d(getClass().getSimpleName(), "destroyItem position:" + i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f9337d.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        PhotoView photoView = new PhotoView(this.f9338e);
        try {
            this.f9336c.getImageLoader().displayImagePreview(this.f9338e, this.f9337d.get(i2).path, photoView, this.f9334a, this.f9335b);
            photoView.setOnPhotoTapListener(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        viewGroup.addView(photoView);
        return photoView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void setData(ArrayList<ImageItem> arrayList) {
        this.f9337d = arrayList;
    }

    public void setPhotoViewClickListener(b bVar) {
        this.f9339f = bVar;
    }
}
