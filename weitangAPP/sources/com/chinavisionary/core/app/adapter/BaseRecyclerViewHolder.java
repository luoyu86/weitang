package com.chinavisionary.core.app.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.d.x;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f6469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6472e;

    public BaseRecyclerViewHolder(View view) {
        super(view);
        this.f6468a = -1;
    }

    public void a(CoreRoundedImageView coreRoundedImageView, ResourceVo resourceVo, boolean z) {
        if (coreRoundedImageView != null) {
            if (e()) {
                coreRoundedImageView.loadImageToResourceVo(resourceVo, z);
            } else {
                coreRoundedImageView.recyclerImage();
            }
        }
    }

    public void b(CoreRoundedImageView coreRoundedImageView, ResourceVo resourceVo) {
        a(coreRoundedImageView, resourceVo, false);
    }

    public final String c(String str) {
        return x.getNotNullStr(str, "");
    }

    public final String d(ResourceVo resourceVo) {
        if (resourceVo != null) {
            return resourceVo.getUrl();
        }
        return null;
    }

    public boolean e() {
        int adapterPosition = getAdapterPosition();
        return adapterPosition >= this.f6470c && adapterPosition <= this.f6471d;
    }

    public final void f(View view, View.OnClickListener onClickListener) {
        view.setOnClickListener(null);
        view.setOnClickListener(onClickListener);
        view.setTag(Integer.valueOf(getAdapterPosition()));
    }

    public int getListSize() {
        return this.f6472e;
    }

    public void setFirstLastPosition(int i2, int i3) {
        this.f6470c = i2;
        this.f6471d = i3;
    }

    public void setListPosition(int i2) {
        this.f6468a = i2;
    }

    public void setListSize(int i2) {
        this.f6472e = i2;
    }

    public final void setViewOnClickListener(View.OnClickListener onClickListener) {
        this.f6469b = onClickListener;
    }
}
