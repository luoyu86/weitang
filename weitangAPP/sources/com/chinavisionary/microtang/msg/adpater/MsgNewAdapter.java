package com.chinavisionary.microtang.msg.adpater;

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
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.msg.vo.MsgVo;

/* JADX INFO: loaded from: classes.dex */
public class MsgNewAdapter extends BaseRecyclerAdapter<MsgVo> {

    public static class MsgNewVh extends BaseRecyclerViewHolder<MsgVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7946f;

        @BindView(R.id.tv_badge_paint)
        public TextView mBadgePaintTv;

        @BindView(R.id.tv_cat_details)
        public TextView mCatDetailsTv;

        @BindView(R.id.tv_content)
        public TextView mContentTv;

        @BindView(R.id.img_msg_cover)
        public CoreRoundedImageView mCoverImg;

        @BindView(R.id.tv_time)
        public TextView mTimeTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public MsgNewVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(MsgVo msgVo) {
            this.mTimeTv.setText(z.getTime(msgVo.getCreateTime()));
            this.mTitleTv.setText(x.getNotNullStr(msgVo.getTitle(), ""));
            this.mContentTv.setText(x.getNotNullStr(msgVo.getContent(), ""));
            this.mBadgePaintTv.setVisibility(msgVo.isHasRead() ? 8 : 0);
            boolean z = msgVo.getResourceVo() != null;
            this.mCoverImg.setVisibility(z ? 0 : 8);
            if (z) {
                this.mCoverImg.loadImageToUrl(msgVo.getResourceVo().getUrl());
            }
            this.mCatDetailsTv.setTag(Integer.valueOf(this.f6468a));
            this.mCatDetailsTv.setOnClickListener(null);
            this.mCatDetailsTv.setOnClickListener(this.f7946f);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7946f = onClickListener;
        }
    }

    public class MsgNewVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MsgNewVh f7947b;

        @UiThread
        public MsgNewVh_ViewBinding(MsgNewVh msgNewVh, View view) {
            this.f7947b = msgNewVh;
            msgNewVh.mTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_time, "field 'mTimeTv'", TextView.class);
            msgNewVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            msgNewVh.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mContentTv'", TextView.class);
            msgNewVh.mCatDetailsTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cat_details, "field 'mCatDetailsTv'", TextView.class);
            msgNewVh.mBadgePaintTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_badge_paint, "field 'mBadgePaintTv'", TextView.class);
            msgNewVh.mCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_msg_cover, "field 'mCoverImg'", CoreRoundedImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MsgNewVh msgNewVh = this.f7947b;
            if (msgNewVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7947b = null;
            msgNewVh.mTimeTv = null;
            msgNewVh.mTitleTv = null;
            msgNewVh.mContentTv = null;
            msgNewVh.mCatDetailsTv = null;
            msgNewVh.mBadgePaintTv = null;
            msgNewVh.mCoverImg = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 == 0 && 1 == this.f6460b.size() && x.isNullStr(((MsgVo) this.f6460b.get(i2)).getTitle()) && x.isNullStr(((MsgVo) this.f6460b.get(i2)).getContent())) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        MsgNewVh msgNewVh = (MsgNewVh) viewHolder;
        msgNewVh.setListPosition(i2);
        msgNewVh.setOnClickListener(this.f6461c);
        msgNewVh.g((MsgVo) this.f6460b.get(i2));
        b(msgNewVh, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewI = i(viewGroup, R.layout.item_new_msg_layout);
        MsgNewVh msgNewVh = new MsgNewVh(viewI);
        viewI.setTag(msgNewVh);
        return msgNewVh;
    }
}
