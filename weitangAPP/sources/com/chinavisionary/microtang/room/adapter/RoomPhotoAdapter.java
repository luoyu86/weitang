package com.chinavisionary.microtang.room.adapter;

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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.RoomPhotoVo;

/* JADX INFO: loaded from: classes2.dex */
public class RoomPhotoAdapter extends BaseRecyclerAdapter<RoomPhotoVo> {

    public static class RoomPhotoVH extends BaseRecyclerViewHolder<RoomPhotoVo> {

        @BindView(R.id.img_room_cover)
        public CoreRoundedImageView mRoomCoverImg;

        @BindView(R.id.tv_title_info)
        public TextView mTitleTv;

        public RoomPhotoVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomPhotoVo roomPhotoVo) {
            ResourceVo resourceVo = roomPhotoVo.getResourceVo();
            this.mRoomCoverImg.loadImageToUrl(resourceVo != null ? resourceVo.getUrl() : null);
            this.mTitleTv.setVisibility(x.isNotNull(roomPhotoVo.getTitle()) ? 0 : 8);
            this.mTitleTv.setText(x.getNotNullStr(roomPhotoVo.getTitle(), ""));
        }
    }

    public class RoomPhotoVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RoomPhotoVH f8301b;

        @UiThread
        public RoomPhotoVH_ViewBinding(RoomPhotoVH roomPhotoVH, View view) {
            this.f8301b = roomPhotoVH;
            roomPhotoVH.mRoomCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_room_cover, "field 'mRoomCoverImg'", CoreRoundedImageView.class);
            roomPhotoVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_info, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RoomPhotoVH roomPhotoVH = this.f8301b;
            if (roomPhotoVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8301b = null;
            roomPhotoVH.mRoomCoverImg = null;
            roomPhotoVH.mTitleTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 34952) {
            RoomPhotoVH roomPhotoVH = (RoomPhotoVH) viewHolder;
            roomPhotoVH.g((RoomPhotoVo) this.f6460b.get(i2));
            b(roomPhotoVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_room_photo_layout, viewGroup, false);
        RoomPhotoVH roomPhotoVH = new RoomPhotoVH(viewInflate);
        viewInflate.setTag(roomPhotoVH);
        return roomPhotoVH;
    }
}
