package com.chinavisionary.core.app.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleRecyclerViewHolder<T> extends BaseRecyclerViewHolder<T> {
    public SimpleRecyclerViewHolder(View view) {
        super(view);
    }

    public abstract void setupData(T t);
}
