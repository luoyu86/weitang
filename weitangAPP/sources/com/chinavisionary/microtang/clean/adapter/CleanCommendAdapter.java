package com.chinavisionary.microtang.clean.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.k.b.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.comment.vo.CommentListItemVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.hedgehog.ratingbar.RatingBar;
import com.lzy.ninegrid.NineGridView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CleanCommendAdapter extends BaseRecyclerAdapter<CommentListItemVo> {

    public static class CleanCommendVH extends BaseRecyclerViewHolder<CommentListItemVo> {

        @BindView(R.id.tv_clean_person_name)
        public TextView mCleanPersonNameTv;

        @BindView(R.id.tv_content)
        public TextView mCommendContentTv;

        @BindView(R.id.nine_grid_view_commend)
        public NineGridView mCommendNineGridView;

        @BindView(R.id.rating_bar_commend_star)
        public RatingBar mCommendStarRb;

        @BindView(R.id.tv_publish_time)
        public TextView mPublishTimeTv;

        @BindView(R.id.img_user_icon)
        public CoreRoundedImageView mUserIconImg;

        @BindView(R.id.tv_user_name)
        public TextView mUserNameTv;

        public CleanCommendVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final void g(CommentListItemVo commentListItemVo) {
            ArrayList arrayList = new ArrayList();
            for (ResourceVo resourceVo : commentListItemVo.getPhotoAttachmentList()) {
                a aVar = new a();
                aVar.setThumbnailUrl(resourceVo.getUrl());
                aVar.setBigImageUrl(resourceVo.getUrl());
                arrayList.add(aVar);
            }
            NineGridView nineGridView = this.mCommendNineGridView;
            nineGridView.setAdapter(new c.k.b.d.a(nineGridView.getContext(), arrayList));
        }

        public void h(CommentListItemVo commentListItemVo) {
            this.mCommendContentTv.setText(x.getNotNullStr(commentListItemVo.getContent(), ""));
            Double score = commentListItemVo.getScore();
            if (score == null) {
                score = Double.valueOf(0.0d);
            }
            this.mCommendStarRb.setStar(score.floatValue());
            g(commentListItemVo);
        }
    }

    public class CleanCommendVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CleanCommendVH f6933b;

        @UiThread
        public CleanCommendVH_ViewBinding(CleanCommendVH cleanCommendVH, View view) {
            this.f6933b = cleanCommendVH;
            cleanCommendVH.mUserIconImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_user_icon, "field 'mUserIconImg'", CoreRoundedImageView.class);
            cleanCommendVH.mUserNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_user_name, "field 'mUserNameTv'", TextView.class);
            cleanCommendVH.mCommendStarRb = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_commend_star, "field 'mCommendStarRb'", RatingBar.class);
            cleanCommendVH.mCleanPersonNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_clean_person_name, "field 'mCleanPersonNameTv'", TextView.class);
            cleanCommendVH.mPublishTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_publish_time, "field 'mPublishTimeTv'", TextView.class);
            cleanCommendVH.mCommendContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mCommendContentTv'", TextView.class);
            cleanCommendVH.mCommendNineGridView = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view_commend, "field 'mCommendNineGridView'", NineGridView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CleanCommendVH cleanCommendVH = this.f6933b;
            if (cleanCommendVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6933b = null;
            cleanCommendVH.mUserIconImg = null;
            cleanCommendVH.mUserNameTv = null;
            cleanCommendVH.mCommendStarRb = null;
            cleanCommendVH.mCleanPersonNameTv = null;
            cleanCommendVH.mPublishTimeTv = null;
            cleanCommendVH.mCommendContentTv = null;
            cleanCommendVH.mCommendNineGridView = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (h() > 0 && 1 == this.f6460b.size() && i2 == 1 && x.isNullStr(((CommentListItemVo) this.f6460b.get(0)).getContent()) && x.isNullStr(((CommentListItemVo) this.f6460b.get(0)).getKey())) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        CleanCommendVH cleanCommendVH = (CleanCommendVH) viewHolder;
        cleanCommendVH.h((CommentListItemVo) this.f6460b.get(i2 - h()));
        b(cleanCommendVH, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_clean_commend_layout, viewGroup, false);
        CleanCommendVH cleanCommendVH = new CleanCommendVH(viewInflate);
        viewInflate.setTag(cleanCommendVH);
        return cleanCommendVH;
    }
}
