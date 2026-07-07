package com.chinavisionary.core.app.upload.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.lzy.imagepicker.bean.ImageItem;

/* JADX INFO: loaded from: classes.dex */
public class NinePicAdapter extends BaseRecyclerAdapter<ImageItem> {
    public boolean n;

    public static class NinePicVH extends BaseRecyclerViewHolder<ImageItem> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View.OnClickListener f6520g;

        @BindView(2368)
        public CoreRoundedImageView mCoreRoundedImageView;

        @BindView(2369)
        public ImageView mDelImg;

        public NinePicVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(ImageItem imageItem) {
            this.mCoreRoundedImageView.loadImageToUrl(imageItem.path);
            this.mDelImg.setVisibility((this.f6519f || !(x.isNumeric(imageItem.path) ^ true)) ? 8 : 0);
            f(this.mDelImg, this.f6520g);
        }

        public void setHiedDelImg(boolean z) {
            this.f6519f = z;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f6520g = onClickListener;
        }
    }

    public class NinePicVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NinePicVH f6521b;

        @UiThread
        public NinePicVH_ViewBinding(NinePicVH ninePicVH, View view) {
            this.f6521b = ninePicVH;
            ninePicVH.mCoreRoundedImageView = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_commend_pic, "field 'mCoreRoundedImageView'", CoreRoundedImageView.class);
            ninePicVH.mDelImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_del, "field 'mDelImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            NinePicVH ninePicVH = this.f6521b;
            if (ninePicVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6521b = null;
            ninePicVH.mCoreRoundedImageView = null;
            ninePicVH.mDelImg = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        NinePicVH ninePicVH = (NinePicVH) viewHolder;
        ninePicVH.setHiedDelImg(this.n);
        ninePicVH.setListPosition(i2);
        ninePicVH.g((ImageItem) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.core_lib_item_nine_pic_layout);
        NinePicVH ninePicVH = new NinePicVH(viewI);
        ninePicVH.setOnClickListener(this.f6461c);
        a(ninePicVH);
        viewI.setTag(ninePicVH);
        return ninePicVH;
    }

    public void setHiedDelImg(boolean z) {
        this.n = z;
    }
}
