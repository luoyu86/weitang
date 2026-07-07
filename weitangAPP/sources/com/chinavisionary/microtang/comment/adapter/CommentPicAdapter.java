package com.chinavisionary.microtang.comment.adapter;

import android.view.LayoutInflater;
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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.lzy.imagepicker.bean.ImageItem;

/* JADX INFO: loaded from: classes.dex */
public class CommentPicAdapter extends BaseRecyclerAdapter<ImageItem> {

    public static class CommentPicVH extends BaseRecyclerViewHolder<ImageItem> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f6965f;

        @BindView(R.id.img_commend_pic)
        public CoreRoundedImageView mCoreRoundedImageView;

        @BindView(R.id.img_del)
        public ImageView mDelImg;

        public CommentPicVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(ImageItem imageItem) {
            this.mCoreRoundedImageView.loadImageToUrl(imageItem.path);
            this.mDelImg.setVisibility(x.isNumeric(imageItem.path) ^ true ? 0 : 8);
            f(this.mDelImg, this.f6965f);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f6965f = onClickListener;
        }
    }

    public class CommentPicVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CommentPicVH f6966b;

        @UiThread
        public CommentPicVH_ViewBinding(CommentPicVH commentPicVH, View view) {
            this.f6966b = commentPicVH;
            commentPicVH.mCoreRoundedImageView = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_commend_pic, "field 'mCoreRoundedImageView'", CoreRoundedImageView.class);
            commentPicVH.mDelImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_del, "field 'mDelImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CommentPicVH commentPicVH = this.f6966b;
            if (commentPicVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6966b = null;
            commentPicVH.mCoreRoundedImageView = null;
            commentPicVH.mDelImg = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        CommentPicVH commentPicVH = (CommentPicVH) viewHolder;
        commentPicVH.setListPosition(i2);
        commentPicVH.g((ImageItem) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_commend_pic_layout, viewGroup, false);
        CommentPicVH commentPicVH = new CommentPicVH(viewInflate);
        commentPicVH.setOnClickListener(this.f6461c);
        a(commentPicVH);
        viewInflate.setTag(commentPicVH);
        return commentPicVH;
    }
}
