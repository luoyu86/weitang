package com.tianmu.ad.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public abstract void addData(List<T> list);

    public abstract void clearData();

    public abstract void removeData(T t);

    public abstract void setData(List<T> list);
}
