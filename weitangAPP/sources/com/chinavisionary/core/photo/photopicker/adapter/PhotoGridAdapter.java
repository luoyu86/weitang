package com.chinavisionary.core.photo.photopicker.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhotoGridAdapter extends RecyclerView.Adapter<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f6538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RequestManager f6539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.e.a.b.a.h.a f6540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f6541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.e.a.b.a.g.b f6542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6545i;
    public int j;
    public List<c.e.a.b.a.g.b> k;
    public int l;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoGridAdapter.this.f6541e != null) {
                PhotoGridAdapter.this.f6541e.onClick(view);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f6547a;

        public b(d dVar) {
            this.f6547a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoGridAdapter.this.f6540d != null) {
                int adapterPosition = this.f6547a.getAdapterPosition();
                if (PhotoGridAdapter.this.f6544h) {
                    PhotoGridAdapter.this.f6540d.onClick(view, adapterPosition, PhotoGridAdapter.this.showCamera());
                } else {
                    this.f6547a.f6552b.performClick();
                }
            }
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Photo f6549a;

        public c(Photo photo) {
            this.f6549a = photo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.a.b.a.i.c.getHelper().toggleSelection(PhotoGridAdapter.this.f6537a, this.f6549a)) {
                PhotoGridAdapter.this.notifyChange(this.f6549a);
            }
        }
    }

    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f6551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f6552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f6553c;

        public d(View view) {
            super(view);
            this.f6551a = (ImageView) view.findViewById(R.id.iv_photo);
            this.f6552b = (ImageView) view.findViewById(R.id.v_selected);
            if (c.e.a.b.a.i.c.getHelper().getConfig() != null) {
                this.f6552b.setImageResource(c.e.a.b.a.i.c.getHelper().getConfig().getImageSelectorRes());
            }
            this.f6553c = view.findViewById(R.id.cover);
        }
    }

    public PhotoGridAdapter(Context context, RequestManager requestManager, List<c.e.a.b.a.g.b> list) {
        this.f6540d = null;
        this.f6541e = null;
        this.f6543g = true;
        this.f6544h = true;
        this.j = 3;
        this.l = 0;
        this.f6537a = context;
        this.f6539c = requestManager;
        this.k = list;
        this.f6538b = LayoutInflater.from(context);
        f(context, this.j);
    }

    public final List<Photo> e() {
        c.e.a.b.a.g.b bVar = this.f6542f;
        if (bVar != null) {
            bVar.setSelected(false);
        }
        c.e.a.b.a.g.b bVar2 = this.k.get(this.l);
        this.f6542f = bVar2;
        bVar2.setSelected(true);
        c.e.a.b.a.i.c.getHelper().setCurrentPagePhotos(this.f6542f.getPhotos());
        return this.f6542f.getPhotos();
    }

    public final void f(Context context, int i2) {
        this.j = i2;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f6545i = displayMetrics.widthPixels / i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c.e.a.b.a.g.b> list = this.k;
        int size = 0;
        if (list != null && !list.isEmpty() && e() != null) {
            size = e().size();
        }
        return showCamera() ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (showCamera() && i2 == 0) ? 100 : 101;
    }

    public void notifyChange(Photo photo) {
        int iIndexOf = e().indexOf(photo);
        if (showCamera()) {
            iIndexOf++;
        }
        if (iIndexOf >= 0) {
            notifyItemChanged(iIndexOf);
        }
    }

    public void setCurrentDirectoryIndex(int i2) {
        this.l = i2;
    }

    public void setOnCameraClickListener(View.OnClickListener onClickListener) {
        this.f6541e = onClickListener;
    }

    public void setOnPhotoClickListener(c.e.a.b.a.h.a aVar) {
        this.f6540d = aVar;
    }

    public void setPreviewEnable(boolean z) {
        this.f6544h = z;
    }

    public void setShowCamera(boolean z) {
        this.f6543g = z;
    }

    public boolean showCamera() {
        return this.f6543g && this.l == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(d dVar, int i2) {
        if (getItemViewType(i2) != 101) {
            dVar.f6551a.setScaleType(ImageView.ScaleType.FIT_XY);
            if (c.e.a.b.a.i.c.getHelper().getConfig() != null) {
                dVar.f6551a.setImageResource(c.e.a.b.a.i.c.getHelper().getConfig().getCameraRes());
                return;
            } else {
                dVar.f6551a.setImageResource(R.drawable.__picker_alumnus_camera_selector);
                return;
            }
        }
        dVar.f6551a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        List<Photo> listE = e();
        Photo photo = showCamera() ? listE.get(i2 - 1) : listE.get(i2);
        DrawableRequestBuilder<Uri> drawableRequestBuilderThumbnail = this.f6539c.load(c.e.a.b.a.i.d.getUri(photo.getPath())).centerCrop().dontAnimate().thumbnail(0.5f);
        int i3 = this.f6545i;
        drawableRequestBuilderThumbnail.override(i3, i3).placeholder(R.drawable.__picker_default_weixin).error(R.drawable.__picker_ic_broken_image_black_48dp).into(dVar.f6551a);
        boolean zIsSelected = photo.isSelected();
        dVar.f6552b.setSelected(zIsSelected);
        dVar.f6553c.setSelected(zIsSelected);
        dVar.f6551a.setOnClickListener(new b(dVar));
        dVar.f6552b.setOnClickListener(new c(photo));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public d onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d dVar = new d(this.f6538b.inflate(R.layout.__picker_item_photo, viewGroup, false));
        if (i2 == 100) {
            dVar.f6552b.setVisibility(8);
            dVar.f6551a.setScaleType(ImageView.ScaleType.CENTER);
            dVar.f6551a.setOnClickListener(new a());
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(d dVar) {
        Glide.clear(dVar.f6551a);
        super.onViewRecycled(dVar);
    }

    public PhotoGridAdapter(Context context, RequestManager requestManager, List<c.e.a.b.a.g.b> list, int i2) {
        this(context, requestManager, list);
        f(context, i2);
    }
}
