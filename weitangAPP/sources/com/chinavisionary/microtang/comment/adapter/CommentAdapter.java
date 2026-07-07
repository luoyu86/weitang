package com.chinavisionary.microtang.comment.adapter;

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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.comment.vo.CommentItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentAdapter extends BaseRecyclerAdapter<CommentItemVo> {

    public static class CommentVh extends BaseRecyclerViewHolder<CommentItemVo> {

        @BindView(R.id.tv_comment_date)
        public TextView mCommentDateTv;

        @BindView(R.id.tv_subtitle_tv)
        public TextView mSubtitleTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public CommentVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CommentItemVo commentItemVo) {
            this.mTitleTv.setText(c(commentItemVo.getTitle()));
            this.mSubtitleTv.setText(c(commentItemVo.getContent()));
            this.mCommentDateTv.setText(c(commentItemVo.getCreateTimeStr()));
        }
    }

    public class CommentVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CommentVh f6964b;

        @UiThread
        public CommentVh_ViewBinding(CommentVh commentVh, View view) {
            this.f6964b = commentVh;
            commentVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            commentVh.mSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_subtitle_tv, "field 'mSubtitleTv'", TextView.class);
            commentVh.mCommentDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_comment_date, "field 'mCommentDateTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CommentVh commentVh = this.f6964b;
            if (commentVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6964b = null;
            commentVh.mTitleTv = null;
            commentVh.mSubtitleTv = null;
            commentVh.mCommentDateTv = null;
        }
    }

    public CommentAdapter() {
        CommentItemVo commentItemVo = new CommentItemVo();
        commentItemVo.setItemType(34952);
        addDataToList(commentItemVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list == 0 || list.isEmpty() || this.f6460b.size() != 1 || ((CommentItemVo) this.f6460b.get(i2)).getItemType() != 34952) {
            return super.getItemViewType(i2);
        }
        return 34952;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 34952) {
            ((CommentVh) viewHolder).g((CommentItemVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        View viewI = i(viewGroup, R.layout.item_comment_layout);
        CommentVh commentVh = new CommentVh(viewI);
        viewI.setTag(commentVh);
        a(commentVh);
        return commentVh;
    }
}
