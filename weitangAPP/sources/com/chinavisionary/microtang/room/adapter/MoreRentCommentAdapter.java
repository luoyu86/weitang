package com.chinavisionary.microtang.room.adapter;

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
import c.k.b.d.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.MerchantCommentVo;
import com.lzy.ninegrid.NineGridView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MoreRentCommentAdapter extends BaseRecyclerAdapter<MerchantCommentVo> {

    public static class MoreRentCommentVh extends BaseRecyclerViewHolder<MerchantCommentVo> {

        @BindView(R.id.tv_room_comment_content)
        public TextView mCommentContentTv;

        @BindView(R.id.tv_room_comment_date)
        public TextView mCommentDateTv;

        @BindView(R.id.nine_grid_view_commend)
        public NineGridView mNineGridView;

        @BindView(R.id.tv_room_no)
        public TextView mRoomNoTv;

        @BindView(R.id.img_user_icon)
        public CoreRoundedImageView mUserIconImg;

        @BindView(R.id.tv_room_user_name)
        public TextView mUserNameTv;

        public MoreRentCommentVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final void g(List<ResourceVo> list) {
            if (list == null || list.isEmpty()) {
                NineGridView nineGridView = this.mNineGridView;
                nineGridView.setAdapter(new a(nineGridView.getContext(), new ArrayList()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ResourceVo resourceVo : list) {
                if (resourceVo != null) {
                    c.k.b.a aVar = new c.k.b.a();
                    aVar.setThumbnailUrl(resourceVo.getUrl());
                    aVar.setBigImageUrl(resourceVo.getUrl());
                    arrayList.add(aVar);
                }
            }
            NineGridView nineGridView2 = this.mNineGridView;
            nineGridView2.setAdapter(new a(nineGridView2.getContext(), arrayList));
        }

        public void h(MerchantCommentVo merchantCommentVo) {
            g(merchantCommentVo.getPics());
            this.mRoomNoTv.setText(x.getNotNullStr(merchantCommentVo.getNickname(), ""));
            this.mUserIconImg.loadImageToResourceVo(merchantCommentVo.getAvatar());
            this.mUserNameTv.setText(x.getNotNullStr(merchantCommentVo.getNickname(), ""));
            this.mCommentDateTv.setText(z.getTime(merchantCommentVo.getCommentTime()));
            this.mCommentContentTv.setText(x.getNotNullStr(merchantCommentVo.getContent(), ""));
        }
    }

    public class MoreRentCommentVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MoreRentCommentVh f8295b;

        @UiThread
        public MoreRentCommentVh_ViewBinding(MoreRentCommentVh moreRentCommentVh, View view) {
            this.f8295b = moreRentCommentVh;
            moreRentCommentVh.mRoomNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_no, "field 'mRoomNoTv'", TextView.class);
            moreRentCommentVh.mUserNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_user_name, "field 'mUserNameTv'", TextView.class);
            moreRentCommentVh.mUserIconImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_user_icon, "field 'mUserIconImg'", CoreRoundedImageView.class);
            moreRentCommentVh.mCommentDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_comment_date, "field 'mCommentDateTv'", TextView.class);
            moreRentCommentVh.mCommentContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_comment_content, "field 'mCommentContentTv'", TextView.class);
            moreRentCommentVh.mNineGridView = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view_commend, "field 'mNineGridView'", NineGridView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MoreRentCommentVh moreRentCommentVh = this.f8295b;
            if (moreRentCommentVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8295b = null;
            moreRentCommentVh.mRoomNoTv = null;
            moreRentCommentVh.mUserNameTv = null;
            moreRentCommentVh.mUserIconImg = null;
            moreRentCommentVh.mCommentDateTv = null;
            moreRentCommentVh.mCommentContentTv = null;
            moreRentCommentVh.mNineGridView = null;
        }
    }

    public MoreRentCommentAdapter() {
        addDataToList(new MerchantCommentVo());
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list == 0 || list.isEmpty() || this.f6460b.size() != 1 || ((MerchantCommentVo) this.f6460b.get(i2)).getCommentKey() != null) {
            return super.getItemViewType(i2);
        }
        return 34952;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        ((MoreRentCommentVh) viewHolder).h((MerchantCommentVo) this.f6460b.get(i2 - h()));
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
        View viewI = i(viewGroup, R.layout.item_rent_comment_layout);
        MoreRentCommentVh moreRentCommentVh = new MoreRentCommentVh(viewI);
        viewI.setTag(moreRentCommentVh);
        return moreRentCommentVh;
    }
}
