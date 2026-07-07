package com.chinavisionary.microtang.open.adapter;

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
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.open.bo.AboutVo;

/* JADX INFO: loaded from: classes.dex */
public class AboutAdapter extends BaseRecyclerAdapter<AboutVo> {

    public static class AboutVH extends BaseRecyclerViewHolder<AboutVo> {

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public AboutVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(AboutVo aboutVo) {
            this.mTitleTv.setTag(aboutVo);
            this.mTitleTv.setText(x.getNotNullStr(aboutVo.getTitle(), ""));
        }
    }

    public class AboutVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AboutVH f7962b;

        @UiThread
        public AboutVH_ViewBinding(AboutVH aboutVH, View view) {
            this.f7962b = aboutVH;
            aboutVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            AboutVH aboutVH = this.f7962b;
            if (aboutVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7962b = null;
            aboutVH.mTitleTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 26214) {
            AboutVH aboutVH = (AboutVH) viewHolder;
            aboutVH.g((AboutVo) this.f6460b.get(i2 - e()));
            b(aboutVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_about_layout, viewGroup, false);
        AboutVH aboutVH = new AboutVH(viewInflate);
        viewInflate.setTag(aboutVH);
        return aboutVH;
    }
}
