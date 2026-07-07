package com.lzy.imagepicker.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.k.a.e.d;
import com.lzy.imagepicker.R;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.view.SuperCheckBox;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ImageRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.k.a.a f9341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f9342b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<ImageItem> f9344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LayoutInflater f9347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9348h;
    public View.OnClickListener j;
    public ViewGroup.LayoutParams k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9349i = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<ImageItem> f9343c = new ArrayList<>();

    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void a(View.OnClickListener onClickListener) {
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f9350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f9351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f9352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SuperCheckBox f9353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View.OnClickListener f9356g;

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f9358a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ImageItem f9359b;

            public a(int i2, ImageItem imageItem) {
                this.f9358a = i2;
                this.f9359b = imageItem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.f9353d.setChecked(!b.this.f9353d.isChecked());
                int selectLimit = ImageRecyclerAdapter.this.f9341a.getSelectLimit();
                if (!b.this.f9353d.isChecked() || ImageRecyclerAdapter.this.f9344d.size() < selectLimit) {
                    ImageRecyclerAdapter.this.f9341a.addSelectedImageItem(this.f9358a, this.f9359b, b.this.f9353d.isChecked());
                    b.this.f9351b.setVisibility(0);
                } else {
                    Toast.makeText(ImageRecyclerAdapter.this.f9342b.getApplicationContext(), ImageRecyclerAdapter.this.f9342b.getString(R.string.ip_select_limit, new Object[]{Integer.valueOf(selectLimit)}), 0).show();
                    b.this.f9353d.setChecked(false);
                    b.this.f9351b.setVisibility(8);
                }
            }
        }

        public b(View view) {
            super(view);
            d();
        }

        public void c(ImageItem imageItem) {
            int adapterPosition = getAdapterPosition();
            g(imageItem, adapterPosition);
            f(imageItem);
            h(imageItem, adapterPosition);
        }

        public final void d() {
            this.f9350a = (ImageView) this.itemView.findViewById(R.id.iv_thumb);
            this.f9351b = this.itemView.findViewById(R.id.mask);
            this.f9352c = this.itemView.findViewById(R.id.checkView);
            this.f9353d = (SuperCheckBox) this.itemView.findViewById(R.id.cb_check);
        }

        public final boolean e() {
            int adapterPosition = getAdapterPosition();
            int i2 = this.f9354e;
            int i3 = this.f9355f;
            return i2 + i3 == 0 || (adapterPosition >= i2 && adapterPosition <= i3);
        }

        public final void f(ImageItem imageItem) {
            if (!ImageRecyclerAdapter.this.f9341a.isMultiMode()) {
                this.f9353d.setVisibility(8);
                return;
            }
            this.f9353d.setVisibility(0);
            boolean zIsSelectPath = ImageRecyclerAdapter.this.f9341a.isSelectPath(imageItem.path);
            this.f9351b.setVisibility(zIsSelectPath ? 0 : 8);
            this.f9353d.setChecked(zIsSelectPath);
        }

        public final void g(ImageItem imageItem, int i2) {
            this.f9352c.setOnClickListener(new a(i2, imageItem));
        }

        public final void h(ImageItem imageItem, int i2) {
            ImageView imageView = this.f9350a;
            imageView.setTag(imageView.getId(), Integer.valueOf(i2));
            this.f9350a.setOnClickListener(null);
            this.f9350a.setOnClickListener(this.f9356g);
            try {
                if (e()) {
                    ImageRecyclerAdapter.this.f9341a.getImageLoader().displayImage(ImageRecyclerAdapter.this.f9342b, imageItem.path, this.f9350a, ImageRecyclerAdapter.this.f9346f, ImageRecyclerAdapter.this.f9346f);
                } else {
                    ImageRecyclerAdapter.this.f9341a.getImageLoader().clearImageViewCache(this.f9350a);
                    ImageView imageView2 = this.f9350a;
                    imageView2.setBackgroundColor(imageView2.getResources().getColor(R.color.ip_text_secondary_inverted));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void setFirstLastPosition(int i2, int i3) {
            this.f9354e = i2;
            this.f9355f = i3;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f9356g = onClickListener;
        }
    }

    public ImageRecyclerAdapter(Activity activity) {
        this.f9342b = activity;
        this.f9346f = d.getImageItemWidth(this.f9342b);
        c.k.a.a aVar = c.k.a.a.getInstance();
        this.f9341a = aVar;
        this.f9345e = aVar.isShowCamera();
        this.f9344d = this.f9341a.getSelectedImages();
        this.f9347g = LayoutInflater.from(activity);
        this.k = new AbsListView.LayoutParams(-1, this.f9346f);
    }

    public final View e(@LayoutRes int i2, ViewGroup viewGroup) {
        View viewInflate = this.f9347g.inflate(i2, viewGroup, false);
        viewInflate.setLayoutParams(this.k);
        return viewInflate;
    }

    public final ArrayList<ImageItem> getImages() {
        return this.f9343c;
    }

    public ImageItem getItem(int i2) {
        if (!this.f9345e) {
            return this.f9343c.get(i2);
        }
        if (i2 == 0) {
            return null;
        }
        return this.f9343c.get(i2 - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9345e ? this.f9343c.size() + 1 : this.f9343c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.f9345e && i2 == 0) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 1) {
            b bVar = (b) viewHolder;
            bVar.setFirstLastPosition(this.f9348h, this.f9349i);
            bVar.c(getItem(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 != 0) {
            b bVar = new b(e(R.layout.adapter_image_list_item, viewGroup));
            bVar.setOnClickListener(this.j);
            return bVar;
        }
        a aVar = new a(e(R.layout.adapter_camera_item, viewGroup));
        aVar.a(this.j);
        return aVar;
    }

    public final void refreshData(ArrayList<ImageItem> arrayList) {
        this.f9343c.clear();
        if (arrayList != null) {
            this.f9343c.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void resetFirstLastPosition() {
        setFirstLastPosition(0, 20);
    }

    public final void setFirstLastPosition(int i2, int i3) {
        this.f9348h = i2;
        this.f9349i = i3;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
