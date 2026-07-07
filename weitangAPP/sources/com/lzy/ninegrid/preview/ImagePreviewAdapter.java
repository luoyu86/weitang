package com.lzy.ninegrid.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import c.k.b.a;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.R;
import i.a.a.a.d;
import java.util.List;
import uk.co.senab.photoview.PhotoView;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePreviewAdapter extends PagerAdapter implements d.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f9467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f9468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f9469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnLongClickListener f9470d;

    public ImagePreviewAdapter(Context context, @NonNull List<a> list) {
        this.f9467a = list;
        this.f9468b = context;
    }

    public final void a(a aVar, PhotoView photoView) {
        try {
            Bitmap cacheImage = NineGridView.getImageLoader().getCacheImage(aVar.bigImageUrl);
            if (cacheImage == null) {
                cacheImage = NineGridView.getImageLoader().getCacheImage(aVar.thumbnailUrl);
            }
            if (cacheImage == null) {
                photoView.setImageResource(R.drawable.ic_default_color);
            } else {
                photoView.setImageBitmap(cacheImage);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            photoView.setImageResource(R.drawable.ic_default_color);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f9467a.size();
    }

    public ImageView getPrimaryImageView() {
        View view = this.f9469c;
        if (view != null) {
            return (ImageView) view.findViewById(R.id.pv);
        }
        return null;
    }

    public View getPrimaryItem() {
        return this.f9469c;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(this.f9468b).inflate(R.layout.item_photoview, viewGroup, false);
        PhotoView photoView = (PhotoView) viewInflate.findViewById(R.id.pv);
        a aVar = this.f9467a.get(i2);
        photoView.setOnPhotoTapListener(this);
        photoView.setOnLongClickListener(this.f9470d);
        a(aVar, photoView);
        try {
            NineGridView.getImageLoader().onDisplayImage(viewInflate.getContext(), photoView, aVar.bigImageUrl);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // i.a.a.a.d.f
    public void onPhotoTap(View view, float f2, float f3) {
        ((ImagePreviewActivity) this.f9468b).finishActivityAnim();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9470d = onLongClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        this.f9469c = (View) obj;
    }
}
