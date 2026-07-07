package com.chinavisionary.microtang.open.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.open.bo.CheckVo;

/* JADX INFO: loaded from: classes.dex */
public class LiveCheckAdapter extends BaseRecyclerAdapter<CheckVo> {

    public static class LiveCheckVH extends BaseRecyclerViewHolder<CheckVo> {

        @BindView(R.id.img_config_icon)
        public CoreRoundedImageView mImageView;

        @BindView(R.id.cb_no)
        public CheckBox mNoCb;

        @BindView(R.id.cb_ok)
        public CheckBox mOkCb;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public LiveCheckVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CheckVo checkVo) {
            this.mImageView.loadImageToUrl(checkVo.getUrl());
            this.mTitleTv.setText(x.getNotNullStr(checkVo.getName(), ""));
            this.mOkCb.setChecked(checkVo.isOk());
            this.mNoCb.setChecked(!checkVo.isOk());
        }
    }

    public class LiveCheckVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LiveCheckVH f7964b;

        @UiThread
        public LiveCheckVH_ViewBinding(LiveCheckVH liveCheckVH, View view) {
            this.f7964b = liveCheckVH;
            liveCheckVH.mImageView = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_config_icon, "field 'mImageView'", CoreRoundedImageView.class);
            liveCheckVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            liveCheckVH.mOkCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_ok, "field 'mOkCb'", CheckBox.class);
            liveCheckVH.mNoCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_no, "field 'mNoCb'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LiveCheckVH liveCheckVH = this.f7964b;
            if (liveCheckVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7964b = null;
            liveCheckVH.mImageView = null;
            liveCheckVH.mTitleTv = null;
            liveCheckVH.mOkCb = null;
            liveCheckVH.mNoCb = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        LiveCheckVH liveCheckVH = (LiveCheckVH) viewHolder;
        liveCheckVH.g((CheckVo) this.f6460b.get(i2));
        liveCheckVH.mOkCb.setTag(Integer.valueOf(i2));
        liveCheckVH.mNoCb.setTag(Integer.valueOf(i2));
        liveCheckVH.mOkCb.setOnClickListener(null);
        liveCheckVH.mNoCb.setOnClickListener(null);
        View.OnClickListener onClickListener = this.f6461c;
        if (onClickListener != null) {
            liveCheckVH.mOkCb.setOnClickListener(onClickListener);
            liveCheckVH.mNoCb.setOnClickListener(this.f6461c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_live_check_layout, viewGroup, false);
        LiveCheckVH liveCheckVH = new LiveCheckVH(viewInflate);
        viewInflate.setTag(liveCheckVH);
        return liveCheckVH;
    }
}
